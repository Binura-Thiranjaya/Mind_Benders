/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import model.adminCourseModel;
import databaseAccessLayer.adminCourseAccessLogin;
/**
 *
 * @author binurathiranjaya
 */
public class adminCourseController {
      adminCourseModel objTCourse;
    adminCourseAccessLogin bal;

    public adminCourseController() {
        bal = new adminCourseAccessLogin();

    }
    public adminCourseModel addCourse(String uname,String course){
        objTCourse =new adminCourseModel(uname,course);
        return objTCourse;
    }
    public boolean insertCourseToDB(adminCourseModel Tcourse,String Uname) {
        boolean result = bal.insertAdminCourseToDB(Tcourse,Uname);
        return result;
    }
//    public boolean updateCourseToDB(int id){
//        boolean result = bal.updateAdminCourseToDB( id);
//        return result;
//    }
    public boolean deleteCourseToDB(int id){
        boolean result = bal.deleteAdminCourseToDB(id);
        return result;
    }
}
