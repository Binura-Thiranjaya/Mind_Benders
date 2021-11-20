/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseAccessLayer;
import databaseLayer.dbConnection;
import model.adminCourseModel;
/**
 *
 * @author binurathiranjaya
 */
public class adminCourseAccessLogin {
      private dbConnection singleConn;

    public adminCourseAccessLogin() {
        singleConn = dbConnection.getSingleInstace();

    }

    public boolean insertAdminCourseToDB(adminCourseModel tcourse,String Uname) {
        try {
            String query = "insert into tcourse(uname,course) values('" + Uname + "','" + tcourse.getCourse() + "');";
            boolean result = singleConn.ExecuteQuery(query);
            return result;
        } catch (Exception ex) {
            return false;
        }
    }

//    public boolean updateAdminCourseToDB(String course,String grade,int id) {
//        try {
//            String query = "update tcourse set name='" + course + "',pnumber='" + grade + "' where id ='" + id + ",;";
//            boolean result = singleConn.ExecuteQuery(query);
//            return result;
//
//        } catch (Exception ex) {
//            return false;
//        }
//    }

    public boolean deleteAdminCourseToDB(int id) {
        try {
            String query = "delete from tcourse where id ='" + id + "';";
            boolean result = singleConn.ExecuteQuery(query);
            return result;

        } catch (Exception ex) {
            return false;
        }
    }
}
