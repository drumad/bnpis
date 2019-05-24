package org.bnp.is.model.member;

import org.bnp.is.model.field.Address;
import org.bnp.is.model.retreat.ClassInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the base class for those who have graduated the Banal Na Pag-aaral.
 */
public class Graduate extends Person {

    private List<ClassInfo> classes;

    private Address chapter;

    private Adorer sponsor;

    public Graduate() {
        classes = new ArrayList<>();
        chapter = null;
        sponsor = null;
    }
}
