import java.util.Scanner;

public class Main {
    static ContactsList ContactsList = new ContactsList();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
//Boucle du programme principal
        try {
            printAppName();
            mainMenu();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            scan.close();
        }
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
        System.out.println();
    }

    public static void printSeparator() {
        for (int i = 1; i < 30; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void mainMenu() {
        printSeparator();
        System.out.println("1 -> Ajouter un contact");
        System.out.println("2 -> Rechercher un contact");
        System.out.println("3 -> Afficher tous les contacts");
        System.out.println("4 -> Quitter");
        System.out.print(": ");

        String userInput = scanInput();
        switch (userInput) {
            case "1":
//                System.out.println("to AddNewContact ");
                printSeparator();
                System.out.println("Ajouter un nouveau contact");

                addNewContact();
                break;
            case "2":
//                System.out.println("to SearchContacts ");
                searchMenu();
                break;
            case "3":
//                System.out.println("to displayContacts ");
                if (ContactsList.list.isEmpty()) {
                    System.out.println("=> Il n'y a aucun contact à afficher !");
                    mainMenu();
                } else {
                    //si le ArrayList n'est pas vide, afficher le menu secondaire pour le choix du tri ASC ou DSC
                    printContactListTitle();
                    sortMenu();
                }
                //afficher menu choix nouvelle liste ou retour mainMenu
                break;
            case "4":
                System.out.println();
                printSeparator();
                System.out.println("A bientôt");
                break;
            default:
                System.out.println("=> /!\\ Cette option n'existe pas");
                mainMenu();
        }
    }

    public static void searchMenu() {
        printSeparator();
        System.out.println("Rechercher un contact");
        System.out.print("Entrez le nom ou le prénom du contact à rechercher : ");
        String searchInput = scanInput();
        ContactsList.search(searchInput);
        afterSearchMenu();
    }

    public static void afterSearchMenu() {
        printSeparator();
        System.out.println("1-> Rechercher un nouveau contact");
        System.out.println("2-> Retour au menu principal");
        System.out.print(": ");

        String Input = scanInput();

        if (Input.equals("1")) {
            searchMenu();
        } else if (Input.equals("2")) {
            mainMenu();
        } else {
            System.out.println("=> /!\\ Cette option n'existe pas");
            afterSearchMenu();
        }
    }

    public static void printContactListTitle() {
        printSeparator();
        System.out.println("Liste des contacts");
        printSeparator();
    }

    public static void sortMenu() {
        System.out.println("1 -> Par ordre croissant");
        System.out.println("2 -> Par ordre décroissant");
        String sortType = scanInput();
        if (sortType.equals("1") || sortType.equals("2")) {
            ContactsList.displayContacts(sortType);
            afterContactsList();
        } else {
            System.out.println("=> /!\\ Cette option n'existe pas");
            sortMenu();
        }
    }

    public static void afterContactsList() {
        System.out.println("3 -> Lister les contacts à nouveau");
        System.out.println("4 -> Retour au menu principal");
        String input = scanInput();
        if (input.equals("3")) {
            sortMenu();
        } else if (input.equals("4")) {
            mainMenu();
        } else {
            System.out.println("=> /!\\ Cette option n'existe pas");
            afterContactsList();
        }
    }

    public static void addNewContact() {
        System.out.println();
        System.out.print("Entrez son nom : ");
        String nom = scanInput();
        System.out.print("Entrez son prénom : ");
        String prenom = scanInput();
        System.out.print("Entrez son numéro de téléphone : ");
        String tel = scanInput();

        Contact newContact = new Contact(nom, prenom, tel);
        ContactsList.addContact(newContact);
        afterNewContact();
    }

    public static void afterNewContact() {
        System.out.println();
        printSeparator();
        System.out.println("1 -> Entrer un nouveau contact");
        System.out.println("2 -> Retour au menu principal");
        String input = scanInput();
        if (input.equals("1")) {
            addNewContact();
        } else if (input.equals("2")) {
            mainMenu();
        } else {
            System.out.println("=> /!\\ Cette option n'existe pas");
            afterNewContact();
        }
    }


    public static String scanInput() {
        String userInput = scan.nextLine();
//        System.out.println("Vous avez saisi l'option " + userInput);
        return userInput;
    }
}