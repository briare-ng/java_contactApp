import java.util.Scanner;

public class Main {
    static ContactsList ContactsList = new ContactsList();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            printAppName();
            mainMenu();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            scan.close();
        }
    }

/**
  Affiche l'accueil de l'application
 */
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

    /**
     * Affiche un séparateur entre les menus
     */
    public static void printSeparator() {
        for (int i = 1; i < 30; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    /**
     * Menu principal de l'application
     */
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
                printSeparator();
                System.out.println("Ajouter un nouveau contact");
                addNewContact();
                break;
            case "2":
                searchMenu();
                break;
            case "3":
                if (ContactsList.list.isEmpty()) {
                    System.out.println("=> Il n'y a aucun contact à afficher !");
                    mainMenu();
                } else {
                    printContactListTitle();
                    sortMenu();
                }
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

    /**
     * Affiche le sous-menu pour la recherche de contact
     */
    public static void searchMenu() {
        printSeparator();
        System.out.println("Rechercher un contact");
        System.out.print("Entrez le nom ou le prénom du contact à rechercher : ");
        String searchInput = scanInput();
        ContactsList.search(searchInput);
        afterSearchMenu();
    }

    /**
     * Affiche le menu suivant une recherche
     */
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

    /**
     * Titre en entrée du menu Liste de contacts
     */
    public static void printContactListTitle() {
        printSeparator();
        System.out.println("Liste des contacts");
        printSeparator();
    }

    /**
     * Menu permettant de faire le tri dans l'ordre choisi
     */
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

    /**
     * Menu suivant l'affichage d'une liste triée
     */
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

    /**
     * Formulaire de saisie d'un nouveau contact
     */
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

    /**
     * Menu suivant la saisie d'un nouveau contact
     */
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

    /**
     * Méthode permettant la lecture de la saisie utilisateur dans le terminal
     * @return userInput
     */
    public static String scanInput() {
        String userInput = scan.nextLine();
//        System.out.println("Vous avez saisi l'option " + userInput);
        return userInput;
    }
}