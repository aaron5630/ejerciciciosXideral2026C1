package ejercicioUno;

import java.util.*;
import java.util.stream.*;

class Contact implements Comparable<Contact> {
    private String name;
    private String email;
    private String phone;

    public Contact(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    // Getters
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }

    @Override
    public int compareTo(Contact other) {
        // Orden natural por name (alfabético, case-insensitive)
        int nameCompare = this.name.compareToIgnoreCase(other.name);
        if (nameCompare != 0) return nameCompare;

        // Desempate por email para mantener consistencia
        return this.email.compareToIgnoreCase(other.email);
    }

    @Override
    public boolean equals(Object o) {
        // Igualdad basada en email
        if (this == o) return true;
        if (!(o instanceof Contact c)) return false;
        return Objects.equals(this.email, c.email);
    }

    @Override
    public int hashCode() {
        // Hash basado en email
        return Objects.hash(email);
    }

    @Override
    public String toString() {
        return String.format("Contact{name='%s', email='%s', phone='%s'}",
            name, email, phone);
    }
}

public class ContactManager {
    private final Set<Contact> contacts = new TreeSet<>();

    public boolean addContact(Contact contact) {
        return contacts.add(contact);
    }

    public Optional<Contact> findByEmail(String email) {
        return contacts.stream()
            .filter(c -> c.getEmail().equalsIgnoreCase(email))
            .findFirst();
    }

    public List<Contact> findByNamePrefix(String prefix) {
        return contacts.stream()
            .filter(c -> c.getName()
                .toLowerCase()
                .startsWith(prefix.toLowerCase()))
            .collect(Collectors.toList());
    }

    public List<Contact> getAllSortedBy(Comparator<Contact> comp) {
        return contacts.stream()
            .sorted(comp)
            .collect(Collectors.toList());
    }

    public int size() { return contacts.size(); }

    public static void main(String[] args) {
        ContactManager mgr = new ContactManager();

        System.out.println("=== Agregando Contactos ===");
        System.out.println("Ana: " + mgr.addContact(
            new Contact("Ana Garcia", "ana@mail.com", "555-1111")));
        System.out.println("Luis: " + mgr.addContact(
            new Contact("Luis Lopez", "luis@mail.com", "555-2222")));
        System.out.println("Maria: " + mgr.addContact(
            new Contact("Maria Torres", "maria@mail.com", "555-3333")));
        System.out.println("Ana duplicada: " + mgr.addContact(
            new Contact("Ana Garcia", "ana@mail.com", "555-9999")));
        System.out.println("Carlos: " + mgr.addContact(
            new Contact("Carlos Ruiz", "carlos@mail.com", "555-4444")));
        System.out.println("Total contactos: " + mgr.size());

        System.out.println("\n=== Orden Natural (por nombre) ===");
        mgr.getAllSortedBy(Comparator.naturalOrder())
            .forEach(System.out::println);

        System.out.println("\n=== Ordenados por Email ===");
        mgr.getAllSortedBy(Comparator.comparing(Contact::getEmail))
            .forEach(System.out::println);

        System.out.println("\n=== Buscar por Email ===");
        mgr.findByEmail("maria@mail.com")
            .ifPresentOrElse(
                c -> System.out.println("Encontrado: " + c),
                () -> System.out.println("No encontrado"));
        mgr.findByEmail("noexiste@mail.com")
            .ifPresentOrElse(
                c -> System.out.println("Encontrado: " + c),
                () -> System.out.println("No encontrado"));

        System.out.println("\n=== Buscar por Prefijo 'Ma' ===");
        mgr.findByNamePrefix("Ma").forEach(System.out::println);
    }
}