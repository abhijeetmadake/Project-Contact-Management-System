import java.util.ArrayList;
import java.util.Scanner;

public class ContactManager {
    private ArrayList<Contact> contacts;

    public ContactManager() {
        contacts = new ArrayList<>();
    }

    public void addContact(String name, String phoneNumber) {
        Contact contact = new Contact(name, phoneNumber);
        contacts.add(contact);
        System.out.println("Contact added successfully!");
    }

    public void removeContact(String name) {
        boolean found = false;
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getName().equalsIgnoreCase(name)) {
                contacts.remove(i);
                System.out.println("Contact removed successfully!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Contact not found.");
        }
    }

    public void searchContact(String name) {
        boolean found = false;
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                System.out.println(contact);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Contact not found.");
        }
    }

    public static void main(String[] args) {
        ContactManager contactManager = new ContactManager();
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Contact Management System");
        System.out.println("Commands: add, remove, search, exit");

        do {
            System.out.print("Enter command: ");
            command = scanner.nextLine().toLowerCase();

            switch (command) {
                case "add":
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    contactManager.addContact(name, phoneNumber);
                    break;
                case "remove":
                    System.out.print("Enter name to remove: ");
                    name = scanner.nextLine();
                    contactManager.removeContact(name);
                    break;
                case "search":
                    System.out.print("Enter name to search: ");
                    name = scanner.nextLine();
                    contactManager.searchContact(name);
                    break;
                case "exit":
                    System.out.println("Exiting Contact Management System...");
                    break;
                default:
                    System.out.println("Invalid command. Please enter add, remove, search, or exit.");
            }
        } while (!command.equals("exit"));

        scanner.close();
    }
}
