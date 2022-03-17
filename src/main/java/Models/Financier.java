package Models;

import java.util.Objects;

public abstract class Financier {

    private String name;
    private  String email;
    private int nationalId;
    private String contact;
    private String password;
    private int id;

    public String type;

    public Financier(String name, String email, int nationalId, String contact, String password) {
        this.name = name;
        this.email = email;
        this.nationalId = nationalId;
        this.contact = contact;
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNationalId(int nationalId) {
        this.nationalId = nationalId;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getNationalId() {
        return nationalId;
    }

    public String getContact() {
        return contact;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Financier financier = (Financier) o;
        return nationalId == financier.nationalId
                && Objects.equals(name, financier.name)
                && Objects.equals(email, financier.email)
                && Objects.equals(contact, financier.contact)
                && Objects.equals(password, financier.password)
                && Objects.equals(type, financier.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, nationalId, contact, password, type);
    }
}
