import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//Boucle du programme principal
        printAppName();
//        mainMenu();
        ContactsList Contactslist = new ContactsList();
        Contactslist.displayContacts();
    }

    public static void printAppName() {
        for (int i = 1; i <= 7; i++) {

            if (i < 3 || i > 5) {
                for (int j = 1; j < 30; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }

            if (i > 2 && i < 6) {
                for (int j = 1; j < 30; j++) {
                    if (j < 4 || j > 26) {
                        System.out.print("*");
                    } else {
                        if (i == 4 && j == 8) {
                            System.out.print("APPLI CONTACTS");
                            j = 21;
                        } else {
                            System.out.print(" ");
                        }
                    }
                }
                System.out.println();
            }
        }

    }

    public static void printSeparator() {
        for (int i = 1; i < 30; i++) {
            System.out.print("-");
        }
    }

    public static void mainMenu() {
        printSeparator();
        System.out.println();
        System.out.println("1 -> Ajouter un contact");
        System.out.println("2 -> Rechercher un contact");
        System.out.println("3 -> Afficher tous les contacts");
        System.out.println("4 -> Quitter");
        System.out.println(": ");

        Scanner scan = new Scanner(System.in);
        Integer userInput = scan.nextInt();
        System.out.print("Vous avez saisi ");
        System.out.println(userInput);
        switch (userInput) {
            case 1:
                System.out.print("redirect to AddNewContact() ");
                break;
            case 2:
                System.out.print("redirect to SearchContacts() ");
                searchContacts();
                break;
            case 3:
                System.out.println("redirect to DisplayAllContacts() ");
                displayAllContacts();
                break;
            case 4:
                System.out.print("display Bye bye ");
                break;
        }
        scan.close();
    }

    public static void displayAllContacts() {
        //méthode avec ArrayList
        ArrayList<String> contactList = new ArrayList<>();
        contactList.add("NGUYEN Briare 0624299126");
        contactList.add("NUMBER number 0621635116");

        if (contactList.isEmpty()) {
            System.out.println("=> Il n'y a aucun contact à afficher !");
        } else {
            for (String contact : contactList) {
                System.out.print("-> ");
                System.out.println(contact);
            }
        }

        //méthode avec les ensembles sets (garanti l'unicité d'un contact)
        //TODO faire avec cette méthode pour être plus proche de la réalité
    }

    public static void searchContacts(){

    }
}