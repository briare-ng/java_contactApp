public class Contact {
    private String nom;
    private String prenom;
    private String numeroTel;

    public Contact(String n, String p,String t) {
        this.nom = n;
        this.prenom = p;
        this.numeroTel = t;
    }

    @Override
    public String toString(){
        return "-> " + nom + " " + prenom + " : " + numeroTel;
    }



}
