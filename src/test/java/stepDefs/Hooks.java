package stepDefs;


import io.cucumber.java.Before;
import utils.DBUtils;

import java.sql.SQLException;

public class Hooks {

    @Before
    public  void setUp(){
        System.out.println("I am setting up test environment!");
    }
    @Before("@db")
    public void setupDBConnection(){
        System.out.println("I am setting jdbc connection setup!");
        DBUtils.createConnection();
    }

    public void tearDownDBConnection(){
        System.out.println("I am closing jdbc connection after test!");
        try {
            DBUtils.destroy();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
