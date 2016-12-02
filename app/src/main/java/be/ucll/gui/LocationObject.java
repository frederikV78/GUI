package be.ucll.gui;

/**
 * Created by mrx on 11/25/2016.
 */

public class LocationObject {

    public LocationObject(){}
    public LocationObject(int _id, String naam, String info, double latitude, double longitude){
        this._id = _id;
        this.naam = naam;
        this.info = info;
        this.latitude = latitude;
        this.longitude = longitude;
    }


    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    private int _id;
    private String naam;
    private String info;
    private double latitude;
    private double longitude;



}
