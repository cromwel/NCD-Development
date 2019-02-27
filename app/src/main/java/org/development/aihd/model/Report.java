package org.development.aihd.model;

import com.orm.SugarRecord;

/**
 * Developed by Rodney on 27/03/2018.
 */

public class Report extends SugarRecord {

    //private variables
    private String _id;
    private String _name;
    private String _date;
    private byte[] _image;

    public Report(){
    }

    // constructor
    public Report(String id, String name,String date, byte[] image){
        this._id = id;
        this._name = name;
        this._date = date;
        this._image = image;
    }

    // getting ID
    public String  getID(){
        return this._id;
    }

    // setting id
    public void setID(String id){
        this._id = id;
    }

    // getting ID
    public String  getDate(){
        return this._date;
    }

    // setting id
    public void setDate(String date){
        this._date = date;
    }

    // getting name
    public String getName(){
        return this._name;
    }

    // setting name
    public void setName(String name){
        this._name = name;
    }
    // getting image
    public byte[] getImage(){
        return this._image;
    }

    // setting status
    public void setImage(byte[] image){
        this._image = image;
    }

}
