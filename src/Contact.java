public class Contact {
    private final String nom;
    private final String prenom;
    private final String numeroTel;

    public Contact(String n, String p,String t) {
        this.nom = n.toUpperCase();
        this.prenom = p;
        this.numeroTel = t;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

/*
    public String getNumeroTel() {
        return numeroTel;
    }
*/

    /**
     * Réécriture de la méthode toString pour l'affichage d'un contact
     * @return prénom + nom + numéro
     */
    @Override
    public String toString(){
        return "-> " + prenom + " " + nom + " : " + numeroTel;
    }



}
