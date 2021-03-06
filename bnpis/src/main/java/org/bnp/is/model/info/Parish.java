package org.bnp.is.model.info;

import org.bnp.is.model.field.Address;

public class Parish {

    private Address address;

    private Integer id;

    private String name;

    public Parish() {
        name = null;
        address = null;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
