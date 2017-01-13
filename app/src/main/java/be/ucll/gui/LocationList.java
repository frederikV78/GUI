package be.ucll.gui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Tom on 13/01/2017.
 */

public class LocationList {

    private ArrayList<LocationItem> items;

    public LocationList() {
        items = new ArrayList<LocationItem>();
    }

    public int addItem(LocationItem item) {
        items.add(item);
        return items.size();
    }

    public int removeItem(LocationItem item) {
        items.remove(item);
        return items.size();
    }

    public LocationItem getItem(int index) {
        return items.get(index);
    }

    public ArrayList<LocationItem> getAllItems() {
        return items;
    }
}
