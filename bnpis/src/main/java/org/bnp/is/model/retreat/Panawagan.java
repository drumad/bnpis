package org.bnp.is.model.retreat;

import org.bnp.is.constants.Assignment;
import org.bnp.is.model.member.Adorer;
import org.bnp.is.model.member.Council;
import org.bnp.is.model.member.Graduate;
import org.bnp.is.model.member.Staff;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Panawagan {

    private Adorer rector;

    private Staff da;

    private Council dp;

    private Date beginDate;

    private Date endDate;

    private Map<Graduate, List<Assignment>> servers;

}