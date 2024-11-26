import java.util.ArrayList;

public class ContactsList {
    public ArrayList<Contact> list;

    public ContactsList() {
        this.list = new ArrayList<>();
//        list.add(new Contact("NGUYEN", "Briare", "0624299126"));
//        list.add(new Contact("Number", "number", "0621635116"));
    }

    public void addContact(Contact contact) {
        this.list.add(contact);
    }

    public void displayContacts() {
        if (list.isEmpty()) {
            System.out.println("=> Il n'y a aucun contact à afficher !");
        } else {
            for (Contact contact : list) {
                System.out.println(contact.toString());
            }
        }
    }
}
