package org.bnp.is.model.field;

import org.bnp.is.util.StringUtil;

public class Address {

    private String street;

    private String city;

    private String state;

    private String country;

    private Integer zip;

    public Address() {
        street = null;
        city = null;
        state = null;
        country = null;
        zip = null;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getZip() {
        return zip;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }

    public String toString() {
        StringBuilder address = new StringBuilder();

        if (!StringUtil.isNullOrEmpty(this.street)) {
            address.append(this.street);
            address.append(", ");
        }

        if (!StringUtil.isNullOrEmpty(city)) {
            address.append(city);
            if (zip != null && zip > 0) {
                address.append(" ");
                address.append(zip);
                address.append(" ");
            }
        }

        if (!StringUtil.isNullOrEmpty(country)) {
            address.append(country);

            if (StringUtil.isNullOrEmpty(city)) {
                address.append(" ");
                address.append(zip);
            }
        }

        return address.toString().trim();
    }
}
