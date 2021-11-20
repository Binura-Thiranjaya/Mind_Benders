/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseAccessLayer;

import databaseLayer.dbConnection;
import model.issueModel;


public class issueaccesslogic {

    private dbConnection singleConn;
    public issueaccesslogic() {
        singleConn = dbConnection.getSingleInstace();

    }
    

    public boolean insertIssueToDB(issueModel issue) {
        try {
            String query = "insert into issues(sid,type,msg,email) values('" + issue.getUname() + "','" + issue.getType() + "','" + issue.getProblem() + "','"+issue.getEmail()+"');";
            
            boolean result = singleConn.ExecuteQuery(query);
            System.out.println(query);
            return result;
        } catch (Exception ex) {
            return false;
        }
    }
//
//    public void setUname(String uname) {
//        this.uname = uname;
//    }
    
}
