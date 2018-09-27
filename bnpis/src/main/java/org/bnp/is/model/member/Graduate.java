package org.bnp.is.model.member;

import org.bnp.is.model.info.Address;
import org.bnp.is.model.retreat.Marian;
import org.bnp.is.model.retreat.Panawagan;

/**
 * This is the base class for those who have graduated the Banal Na Pag-aaral.
 */
public class Graduate extends Person {

    private Marian marian;

    private Panawagan panawagan;

    private Address chapter;

    public Graduate() {

    }
}
