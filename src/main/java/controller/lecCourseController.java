/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.lecCourseModel;
import databaseAccessLayer.lecCourseAccesslogic;

public class lecCourseController {

    lecCourseModel objgrade;
    lecCourseAccesslogic bal;
    
     public lecCourseController () {
        bal = new lecCourseAccesslogic();

    }
     public lecCourseModel addGrade(String grade){
        objgrade =new lecCourseModel(grade);
        return objgrade;
    }
    public boolean insertGradeToDB(lecCourseModel grade,int id) {
        boolean result = bal.addGradeTODB(grade,id);
        return result;
    }
}
