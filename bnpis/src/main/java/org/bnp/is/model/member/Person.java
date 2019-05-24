package org.bnp.is.model.member;

import org.bnp.is.constants.EducationLevel;
import org.bnp.is.constants.MaritalStatus;
import org.bnp.is.model.field.Address;
import org.bnp.is.model.field.Contact;
import org.bnp.is.model.field.Name;
import org.bnp.is.model.info.Parish;

import java.util.Date;

/**
 * This the base retreat for all persons involved with Banal Na Pag-aaral. This contains all the basic contact
 * info.
 *
 * @author Andrew Madrazo
 */
public class Person {

    private Name name;

    private Address address;

    private Contact homePhone;

    private Contact workPhone;

    private Contact mobilePhone;

    private EducationLevel educationLevel;

    private String degree;

    private Date birthday;

    private Character gender;

    private MaritalStatus maritalStatus;

    private Adorer contactPerson;

    private Parish parish;

    public Person() {
        name = null;
        address = null;
        homePhone = null;
        workPhone = null;
        mobilePhone = null;
        educationLevel = null;
        degree = null;
        birthday = null;
        gender = null;
        maritalStatus = null;
        contactPerson = null;
        parish = null;
    }
}
