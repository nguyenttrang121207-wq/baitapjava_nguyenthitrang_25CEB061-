package Bai2_2;

public class Author {
    private String name;
    private String email;
    private char gender;
    public Author(String name, String email, char gender){
        this.name=name;
        this.email=email;
        this.gender=gender;
    }
    public String getname () {
        return name;
    }
    public String getemail(){
        return email;
    }
    public char getgender(){
        return gender;
    }
    public void setemail(String email){
        this.email=email;
    }
    @Override
    public String toString(){
        return "Author [name="+name+",email="+email+",gender="+gender+"]";
    }
}