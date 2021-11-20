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
public class issueModel {
    private String uname;
    private String Email;
    private String problem;
    private String Type;
    
    public issueModel(String uname,String Email,String problem,String Type){
        this.uname=uname;
        this.Email=Email;
        this.problem=problem;
        this.Type=Type;
    }

    public String getEmail() {
        return Email;
    }

    public String getProblem() {
        return problem;
    }

    public String getType() {
        return Type;
    }

    public String getUname() {
        return uname;
    }
     

  
}
