import java.util.ArrayList;

public class ContactsList {
    public ArrayList<Contact> list;

    public ContactsList() {
        this.list = new ArrayList<>();
//        list.add(new Contact("NGUYEN", "Briare", "0624299126"));
//        list.add(new Contact("Number", "num", "0621635116"));
//        list.add(new Contact("Allo", "ambre", "0621635116"));
    }

    /**
     * Ajoute un objet de type Contact à la liste des contacts
     * @param contact
     */
    public void addContact(Contact contact) {
        this.list.add(contact);
    }

    /**
     * Affiche une liste triée selon le paramètre de tri en entrée
     * @param type type de tri 1 pour tri croissant et 2 pour un tri décroissant
     */
    public void displayContacts(String type) {
        ArrayList<Contact> sortedList = list;
        switch (type) {
            case "1":
                sortedList.sort((a, b) -> a.getNom().compareTo(b.getNom()));
                break;
            case "2":
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

    /**
     * Recherche dans la liste des contacts si ceux ci contiennent la valeur d'entrée searchInput.
     * Affiche ensuite les contacts contennant la valeur recherchée dans le nom ou le prénom.
     * @param searchInput chaîne recherchée dans les noms et prénoms de la liste
     */
    public void search(String searchInput) {
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