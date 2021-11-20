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
public class addIssueModel {
    private String msg;
    private String Email;
    private String status;
    
    public addIssueModel(String msg,String Email,String status){
        this.msg=msg;
        this.Email=Email;
        this.status=status;
        
    }

    public String getMsg() {
        return msg;
    }

    public String getStatus() {
        return status;
    }

    public String getEmail() {
        return Email;
    }
            
}
