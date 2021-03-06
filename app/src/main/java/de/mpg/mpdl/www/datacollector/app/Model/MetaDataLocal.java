package de.mpg.mpdl.www.datacollector.app.Model;


import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * Created by allen on 01/04/15.
 */
@Table(name = "MetaDataLocal")

public class MetaDataLocal extends Model{

    @Expose
    @Column(name = "title")
    private String title;

    @Expose
    @Column(name = "address")
    private String address;

    @Expose
    @Column(name = "latitude")
    private double latitude;

    @Expose
    @Column(name = "longitude")
    private double longitude;

    @Expose
    @Column(name = "accuracy")
    private double accuracy;

    @Column(name = "deviceID")
    private String deviceID;

    @Expose
    //@Column(name = "tags")
    private List<String> tags;

    @Expose
    @Column(name = "creator")
    private String creator;

//    @Column(name = "whichItem")
//    private DataItem whichItem;

    public MetaDataLocal() {
        super();
    }


    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }



    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
//
//    public DataItem getWhichItem() {
//        return whichItem;
//    }
//
//    public void setWhichItem(DataItem whichItem) {
//        this.whichItem = whichItem;
//    }


}

