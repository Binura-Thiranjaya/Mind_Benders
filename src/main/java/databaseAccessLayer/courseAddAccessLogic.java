/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseAccessLayer;
import databaseLayer.dbConnection;
import model.courseAddModel;

/**
 *
 * @author binurathiranjaya
 */
public class courseAddAccessLogic {
     private dbConnection singleConn;
    //Import new

    public courseAddAccessLogic() {
        singleConn = dbConnection.getSingleInstace();

    }

    public boolean addCourseTODB(courseAddModel course) {
        try {
            String query = "insert into course(course) values('" + course.getCourse() + "');";
            System.out.println(query);
            boolean result = singleConn.ExecuteQuery(query);
            return result;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean updateCourseToDB(String utype, int id) {
        try {
            String query = "update course set course='" + utype + "'  where id ='" + id + "';";
            boolean result = singleConn.ExecuteQuery(query);
            return result;

        } catch (Exception ex) {
            return false;
        }
    }
    public boolean deleteCourseToDB(int id) {
        try {
            String query = "delete from course where id ='" + id + "';";
            boolean result = singleConn.ExecuteQuery(query);
            return result;

        } catch (Exception ex) {
            return false;
        }
    }
}
