package com.example.CodeHat.Services;

import com.example.CodeHat.Model.Person;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

public class dbConnection {

    List<Person> ans = new ArrayList<Person>();
    public List<Person> makeConnection() {

        try {

            String query = "select user_first_name, user_last_name, score from users,student_profile where users.user_id=student_profile.user_id order by(score) desc;";
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://db-5308.cs.dal.ca/CSCI5308_10_DEVINT?serverTimezone=" + TimeZone.getDefault().getID();
            Connection con = DriverManager.getConnection(url, "CSCI5308_10_DEVINT_USER", "Xyv9jJ8em6");
            // System.out.println("No problem in connection");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()){
                Person list = new Person();
                System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getInt(3));
                list.setFirstName(rs.getString(1));
                list.setLastName(rs.getString(2));
                list.setScore(rs.getString(3));
                ans.add(list);
            }

            con.close();

        } catch (Exception ex) {
            System.out.println("Something wrong in connection !");
            System.out.println(ex);
        }

        return ans;
    }
}


