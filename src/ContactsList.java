import java.util.ArrayList;

public class ContactsList {
    public ArrayList<Contact> list;

    public ContactsList() {
        this.list = new ArrayList<>();
        list.add(new Contact("NGUYEN", "Briare", "0624299126"));
        list.add(new Contact("Number", "number", "0621635116"));
        list.add(new Contact("Allo", "ambre", "0621635116"));
    }

    public void addContact(Contact contact) {
        this.list.add(contact);
    }

    public void displayContacts(String type) {
        ArrayList<Contact> sortedList = list;
        switch (type) {
            case "1":
//                System.out.println("display by ASC...");
                sortedList.sort((a, b) -> a.getNom().compareTo(b.getNom()));
                break;
            case "2":
//                System.out.println("display by DSC...");
                sortedList.sort((a, b) -> -1 * a.getNom().compareTo(b.getNom()));
                break;
        }
        if (list.isEmpty()) {
            System.out.println("=> Il n'y a aucun contact à afficher !");
            System.out.println();
        } else {
            for (Contact contact : sortedList) {
                System.out.println(contact.toString());
            }
            System.out.println();
        }
    }

    public void search(String searchInput) {
//        System.out.println("searching in the Contact list for : " + searchInput);
        ArrayList<Contact> searchResults = new ArrayList<>();

        for (Contact contact : list) {
            if (contact.getNom().toLowerCase().contains(searchInput.toLowerCase()) || contact.getPrenom().toLowerCase().contains(searchInput.toLowerCase())) {
                searchResults.add(contact);
            }
        }

        if (searchResults.isEmpty()) {
            System.out.println("Aucune correspondance trouvée ! (sur " + list.size() + " contact(s))");
            System.out.println();
        } else {
            for (Contact contact : searchResults) {
                System.out.println(contact.toString());
            }
            System.out.println();
        }

    }
}
//Essayer une méthode avec les ensembles Set (pour garantir l'unicité d'un contact)?