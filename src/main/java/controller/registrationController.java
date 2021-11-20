/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.registorModel;
import databaseAccessLayer.regAccessLogic;

public class registrationController {

    registorModel objuser;
    regAccessLogic bal;

    public registrationController() {
        bal = new regAccessLogic();

    }

    public registorModel addUser(String uname, String password, String pnumber, String name, String email, String utype) {
        objuser = new registorModel(uname, password, name, pnumber, email, utype);
        return objuser;
    }

    public boolean insertUserToDB(registorModel user) {
        boolean result = bal.insertUserToDB(user);
        return result;
    }
   public boolean updateUserToDB(String uname, String password, String pnumber,String name,String email, String utype){
        boolean result = bal.updateUserToDB(uname,password,name,pnumber,email,utype);
        return result;
    }
    public boolean deleteUserToDB(String uname){
        boolean result = bal.deleteUserToDB(uname);
        return result;
    }


}
