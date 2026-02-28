package com.academia.batch.config;


import com.academia.batch.model.Libro;
import com.academia.batch.model.LibroReporte;
import com.academia.batch.processor.LibroProcessor;
import com.academia.batch.processor.ReporteProcessor;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.data.MongoItemWriter;
import org.springframework.batch.item.data.builder.MongoItemWriterBuilder;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class BatchConfig {

    // ---------- READER: lee el archivo CSV ----------
    @Bean
    public FlatFileItemReader<Libro> leerCsv() {
        return new FlatFileItemReaderBuilder<Libro>()
                .name("libroReader")
                .resource(new ClassPathResource("libros.csv"))
                .delimited()                          // separado por comas
                .names("nombre", "isbn", "categoria", "autor", "paginas", "precio", "cantidad") // columnas del CSV
                .targetType(Libro.class)            // mapea a nuestro POJO
                .linesToSkip(1)                        // saltar la linea de encabezado
                .build();
    }

    // ---------- PROCESSOR: transforma cada registro ----------
    @Bean
    public LibroProcessor procesarLibro() {
        return new LibroProcessor();
    }

    // ---------- WRITER: escribe en la tabla MySQL ----------
    @Bean
    public JdbcBatchItemWriter<Libro> escribirEnBd(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Libro>()
                .sql("INSERT INTO libros_procesados (nombre, isbn, categoria, autor, paginas, precio, cantidad) " +
                     "VALUES (:nombre, :isbn, :categoria, :autor, :paginas, :precio, :cantidad)")
                .dataSource(dataSource)
                .beanMapped()   // usa los getters del POJO para mapear :nombre, :salario, etc.
                .build();
    }

    // ---------- STEP: un paso = reader + processor + writer ----------
    @Bean
    public Step paso1(JobRepository jobRepository,
                      PlatformTransactionManager transactionManager,
                      FlatFileItemReader<Libro> leerCsv,
                      LibroProcessor procesarLibro,
                      JdbcBatchItemWriter<Libro> escribirEnBd) {

        return new StepBuilder("paso1", jobRepository)
                .<Libro, Libro>chunk(5, transactionManager)  
                .reader(leerCsv)
                .processor(procesarLibro)
                .writer(escribirEnBd)
                .build();
    }


    
    @Bean
    public JdbcCursorItemReader<Libro> leerDeBd(DataSource dataSource) {
        return new JdbcCursorItemReaderBuilder<Libro>()
                .name("libroDbReader")
                .dataSource(dataSource)
                .sql("SELECT nombre, isbn, categoria, autor, paginas, precio, cantidad FROM libros_procesados")
                .rowMapper((rs, rowNum) -> {
                    Libro libro = new Libro();
                    libro.setNombre(rs.getString("nombre"));
                    libro.setIsbn(rs.getString("isbn"));
                    libro.setCategoria(rs.getString("categoria"));
                    libro.setAutor(rs.getString("autor"));
                    libro.setPaginas(rs.getInt("paginas"));
                    libro.setPrecio(rs.getDouble("precio"));
                    libro.setCantidad(rs.getInt("cantidad"));
                    return libro;
                })
                .build();
    }

    @Bean
    public ReporteProcessor procesarReporte() {
        return new ReporteProcessor();
    }

    @Bean
    public MongoItemWriter<LibroReporte> escribirEnMongo(MongoTemplate mongoTemplate) {
        return new MongoItemWriterBuilder<LibroReporte>()
                .template(mongoTemplate)
                .collection("reportes")
                .build();
    }

    @Bean
    public Step paso2(JobRepository jobRepository,
                      PlatformTransactionManager transactionManager,
                      JdbcCursorItemReader<Libro> leerDeBd,
                      ReporteProcessor procesarReporte,
                      MongoItemWriter<LibroReporte> escribirEnMongo) {

        return new StepBuilder("paso2", jobRepository)
                .<Libro, LibroReporte>chunk(5, transactionManager)
                .reader(leerDeBd)
                .processor(procesarReporte)
                .writer(escribirEnMongo)
                .build();
    }

    // ---------- JOB: el trabajo completo ----------
    @Bean
    public Job procesarLibrosJob(JobRepository jobRepository, Step paso1, Step paso2) {
        return new JobBuilder("procesarLibrosJob", jobRepository)
                .start(paso1)   // inicia con el paso1
                .next(paso2)
                .build();
    }
}
