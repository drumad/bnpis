package org.bnp.is.model.member;

import org.bnp.is.model.info.Address;
import org.bnp.is.model.info.Contact;
import org.bnp.is.model.info.Name;

/**
 * This the base retreat for all persons involved with Banal Na Pag-aaral. This contains all the basic contact
 * info.
 *
 * @author Andrew Madrazo
 */
public class Person {

    private Name name;

    private Address address;

    private Contact contact;

    private Adorer contactPerson;
}
