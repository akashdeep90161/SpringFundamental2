package com.akash.autowiring.example;

public class Offers {

    private int idoffers;
    private String name;
    private String email;
    private String text;

    public Offers( String name, String email, String text) {
        this.name = name;
        this.email = email;
        this.text = text;
    }

    public Offers() {
    }

    public int getIdoffers() {
        return idoffers;
    }

    public void setIdoffers(int idoffers) {
        this.idoffers = idoffers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Offers{" +
                "idoffer=" + idoffers +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
