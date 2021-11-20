package controller;

import model.loginModel;
import view.adminCourseView;
public class loginController {
    loginModel objlogin;
    adminCourseView objcourse;
    String  course;
    
    public loginModel addUtype(String uname, String pass, String utype) {
        objlogin = new loginModel(uname, pass, utype);
        return objlogin;

    }
  
}
