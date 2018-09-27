package org.bnp.is.model.info;

import org.bnp.is.util.StringUtil;

public class Address {

    private String address1;

    private String address2;

    private String state;

    private String city;

    private String country;

    private Integer zip;

    public Address() {
        address1 = null;
        address2 = null;
        city = null;
        country = null;
        zip = null;
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

        if (!StringUtil.isNullOrEmpty(address1)) {
            address.append(address1);
            address.append(", ");
        }

        if (!StringUtil.isNullOrEmpty(address2)) {
            address.append(address2);
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
