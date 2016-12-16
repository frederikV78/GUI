package be.ucll.gui;

/**
 * Created by mrx on 11/25/2016.
 */

public class UserObject {
    public UserObject(){}

    public UserObject(int _id, String rNummer, String naam, String passwoord, String functie, String departement){
        this._id = _id;
        this.rNummer = rNummer;
        this.naam = naam;
        this.passwoord = passwoord;
        this.functie = functie;
        this.departement = departement;
    }



    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getrNummer() {
        return rNummer;
    }

    public void setrNummer(String rNummer) {
        this.rNummer = rNummer;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getPasswoord() {
        return passwoord;
    }

    public void setPasswoord(String passwoord) {
        this.passwoord = passwoord;
    }

    public String getFunctie() {
        return functie;
    }

    public void setFunctie(String functie) {
        this.functie = functie;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    private int _id;
    private String rNummer;
    private String naam;
    private String passwoord;
    private String functie;
    private String departement;
}
