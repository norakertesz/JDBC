package models;

import java.util.ArrayList;

public class Kunde {
    private int Kundenid;
    private String Vorname;
    private String Telefonnummer;
    private ArrayList<String> telefonnummern;  // ArrayList für Telefonnummern
    private String Art;

    public String getArt() {
        return Art;
    }

    public void setArt(String art) {
        Art = art;
    }

    // Konstruktor, Getter und Setter für kundenid und vorname

    public ArrayList<String> getTelefonnummern() {
        return telefonnummern;
    }

    public void setTelefonnummern(ArrayList<String> telefonnummern) {
        this.telefonnummern = telefonnummern;
    }

    // Methode zur Anzeige der Telefonnummern in der Konsole
    public void printTelefonnummern() {
        if (telefonnummern != null && !telefonnummern.isEmpty()) {
            System.out.println("Telefonnummern:");
            for (String telefonnummer : telefonnummern) {
                System.out.println(telefonnummer);
            }
        } else {
            System.out.println("Keine Telefonnummern vorhanden.");
        }
    }
    @Override
    public String toString() {
        return "Kunde{" +
                "Kundenid=" + Kundenid +
                ", Vorname='" + Vorname + '\'' +
                ", Bonuspunkte=" + Bonuspunkte +
                '}';
    }

    public String getTelefonnummer() {
        return Telefonnummer;
    }

    public void setTelefonnummer(String telefonnummer) {
        Telefonnummer = telefonnummer;
    }

    public int getKundenid() {
        return Kundenid;
    }

    public void setKundenid(int kundenid) {
        Kundenid = kundenid;
    }

    public String getVorname() {
        return Vorname;
    }

    public void setVorname(String vorname) {
        Vorname = vorname;
    }

    public double getBonuspunkte() {
        return Bonuspunkte;
    }

    public void setBonuspunkte(double bonuspunkte) {
        Bonuspunkte = bonuspunkte;
    }

    private double Bonuspunkte;

}
