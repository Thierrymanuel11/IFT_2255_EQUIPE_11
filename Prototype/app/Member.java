// Classe pour gerer les membres de l'application. Pour un soucis de test, on ne fera pas de différenciation pour le moment
// entre les proffésseurs, les administrateurs et les autres membres

public class Member {
    private String courriel;
    private String username;
    private String password;

    public Member(String username, String courriel,String password){
        this.password = password;
        this.courriel = courriel;
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public String getCourriel() {
        return courriel;
    }

    public String getUsername() {
        return username;
    }

    public String toString(){
        return "Username= "+this.username+"\n"+"courriel= "+this.courriel+"\n";
    }
}
