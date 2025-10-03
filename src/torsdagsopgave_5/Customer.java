package torsdagsopgave_5;

public class Customer {
    private String firstname;
    private String lastname;
    private String username;
    private int id;
    private static int counter = 0;

    public Customer (String firstname, String lastname, String username){
        setFirstname(firstname);
        setLastname(lastname);
        setUsername(username);
        counter++;
        this.id = counter;

    }

    public static int getCounter() {
        return counter;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        if(firstname != null && !firstname.equals("") && firstname.length() > 1) {
            this.firstname = firstname;
        }
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String toString(){
        return id + ": Navn: " + firstname + " " + lastname + ", username: " + username;
    }
}
