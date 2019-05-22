package model;

public class Person {

    protected String id;
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String gender;
    protected String country;
    protected String pathPhoto;
    protected String birthday;

    public Person(String id, String firstName, String lastName, String email, String gender, String country, String pathPhoto, String birthday) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.country = country;
        this.pathPhoto = pathPhoto;
        this.birthday = birthday;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPathPhoto() {
        return pathPhoto;
    }

    public void setPathPhoto(String pathPhoto) {
        this.pathPhoto = pathPhoto;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString(){
        return "Id: " + this.getId() + "\n" +
                       "Nombre: " + this.getFirstName() + "\n" +
                       "Apellido: " + this.getLastName() + "\n" +
                       "Email: " + this.getEmail() + "\n" +
                       "Género: " + this.getGender() + "\n" +
                       "País: " + this.getCountry() + "\n" +
                       "Cumpleaños: " + this.getBirthday() + "\n";
    }

}
