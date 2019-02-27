package org.development.aihd.model;

import com.orm.SugarRecord;

/**
 * Developed by Rodney on 15/02/2018.
 */

public class Person extends SugarRecord {
    //private variables
    private String person_id;
    private String family_name;
    private String given_name;
    private String gender;
    private String birthdate;
    private String birthdate_estimated;
    private String national_id;
    private String telephone;
    private String location_id;
    private String address1,address2,address3,county_district,city_village;
    private String supporter;
    private String supporter_address;
    private String supporter_number;
    private String _status;
    private String isDead;
    private String isReport;
    private String identifier;

    // Empty constructor
    public Person() {
    }

    // constructor
    public Person(String person_id, String name) {
        this.person_id = person_id;
        this.family_name = name;
    }

    // constructor
    public Person(String family_name, String given_name, String gender, String birthdate,
                  String national_id, String telephone, String location_id, String status) {
        this.family_name = family_name;
        this.given_name = given_name;
        this.gender = gender;
        this.birthdate = birthdate;
        this.national_id = national_id;
        this.telephone = telephone;
        this.location_id = location_id;
        this._status = status;
    }

    public String get_id() {
        return person_id;
    }

    public void set_id(String person_id) {
        this.person_id = person_id;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getFamily_name() {
        return family_name;
    }

    public void setFamily_name(String family_name) {
        this.family_name = family_name;
    }

    public String getGiven_name() {
        return given_name;
    }

    public void setGiven_name(String given_name) {
        this.given_name = given_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getBirthdate_estimated() {
        return birthdate_estimated;
    }

    public void setBirthdate_estimated(String birthdate_estimated) {
        this.birthdate_estimated = birthdate_estimated;
    }

    public String getNational_id() {
        return national_id;
    }

    public void setNational_id(String national_id) {
        this.national_id = national_id;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getLocation_id() {
        return location_id;
    }

    public void setLocation_id(String location_id) {
        this.location_id = location_id;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getCounty_district() {
        return county_district;
    }

    public void setCounty_district(String county_district) {
        this.county_district = county_district;
    }

    public String getCity_village() {
        return city_village;
    }

    public void setCity_village(String city_village) {
        this.city_village = city_village;
    }

    public String getSupporter() {
        return supporter;
    }

    public void setSupporter(String supporter) {
        this.supporter = supporter;
    }

    public String getSupporter_address() {
        return supporter_address;
    }

    public void setSupporter_address(String supporter_address) {
        this.supporter_address = supporter_address;
    }

    public String getSupporter_number() {
        return supporter_number;
    }

    public void setSupporter_number(String supporter_number) {
        this.supporter_number = supporter_number;
    }

    public String get_status() {
        return _status;
    }

    public void set_status(String _status) {
        this._status = _status;
    }

    public String getIsDead() {
        return isDead;
    }

    public void setIsDead(String isDead) {
        this.isDead = isDead;
    }

    public String getIsReport() {
        return isReport;
    }

    public void setIsReport(String isReport) {
        this.isReport = isReport;
    }

}
