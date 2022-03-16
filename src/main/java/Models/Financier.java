package Models;

import java.util.Objects;

public abstract class Financier {

    private String name;
    private  String email;
    private int nationalId;
    private String contact;
    private int id;

    public String type;

    public Financier(String name, String email, int nationalId, String contact) {
        this.name = name;
        this.email = email;
        this.nationalId = nationalId;
        this.contact = contact;
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

    public int getId() {
        return id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Financier financier = (Financier) o;
        return nationalId == financier.nationalId && Objects.equals(name, financier.name) && Objects.equals(email, financier.email) && Objects.equals(contact, financier.contact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, nationalId, contact);
    }
}
