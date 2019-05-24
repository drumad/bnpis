package org.bnp.is.controller;

import org.bnp.is.constants.DBAction;
import org.bnp.is.model.info.Parish;
import org.bnp.is.view.ParishRegistration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class ParishController {

    private Parish model;

    private Map<Integer, String> countryMap;

    public ParishController() {
        this(null);
    }

    public ParishController(Parish parishInfo) {
        model = parishInfo;
        loadData();
    }

    public static void main(String[] args) {
        ParishController c = new ParishController();
        c.openView();
        c.deleteParish();
    }

    public void openView() {
        ParishRegistration reg = new ParishRegistration();
        reg.openView();
    }

    private void loadData() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bnpid", "root", "root123");

            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery("select * from country");

            countryMap = new HashMap<>();

            while (result.next()) {
                countryMap.put(result.getInt("id"), result.getString("nicename"));
            }

            result.close();
            stmt.close();
            con.close();

        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public boolean addParish() {
        return actParish(DBAction.ADD);
    }

    public boolean modifyParish() {
        return actParish(DBAction.MODIFY);
    }

    public boolean deleteParish() {
        return actParish(DBAction.DELETE);
    }

    public Parish getModel() {
        return model;
    }

    public Map<Integer, String> getCountryMap() {
        return countryMap;
    }

    public void setCountryMap(Map<Integer, String> countryMap) {
        this.countryMap = countryMap;
    }

    private boolean actParish(DBAction action) {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root123");

            switch (action) {
                case ADD:
                case MODIFY:
                case DELETE:
                default:
                    break;
            }

            con.close();
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
            return false;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }

        return true;
    }
}
