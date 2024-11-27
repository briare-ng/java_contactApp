public class Contact {
    private String nom;
    private String prenom;
    private String numeroTel;

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

    public String getNumeroTel() {
        return numeroTel;
    }

    @Override
    public String toString(){
        return "-> " + prenom + " " + nom + " : " + numeroTel;
    }



}
