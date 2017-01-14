package be.ucll.gui;

/**
 * Created by Tom on 13/01/2017.
 */

public class LocationItem {
    private String naam = null;
    private String info = null;

    public void setNaam(String naam)     {
        this.naam = naam;
    }

    public String getTitle() {
        return naam;
    }

    public void setInfo(String info)     {
        this.info= info;
    }

    public String getDescription() {
        return info;
    }
}
