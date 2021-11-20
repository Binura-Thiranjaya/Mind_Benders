/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author binurathiranjaya
 */
public class adminCourseModel {
    private String uname;
    private String course;
    
    public adminCourseModel(String uname,String course)
    {
        this.uname=uname;
        this.course=course;
        
    }

    public String getUname() {
        return uname;
    }

    public String getCourse() {
        return course;
    }

   
    
}
