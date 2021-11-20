/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseAccessLayer;

import databaseLayer.dbConnection;
import model.registorModel;

public class regAccessLogic {

    private dbConnection singleConn;

    public regAccessLogic() {
        singleConn = dbConnection.getSingleInstace();

    }

    public boolean insertUserToDB(registorModel user) {
        try {
            String query = "insert into user values('" + user.getUname() + "','" + user.getPassword() + "','" + user.getName() + "','" + user.getPnumber() + "','" + user.getEmail() + "','" + user.getUtype() + "');";
            boolean result = singleConn.ExecuteQuery(query);
            return result;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean updateUserToDB(String uname, String password, String pnumber, String name, String email, String utype) {
        try {
            String query = "update user set pass='" + password + "',name='" + name + "',pnumber='" + pnumber + "',email='" + email + "',utype='" + utype + "'  where uname ='" + uname + "';";
            boolean result = singleConn.ExecuteQuery(query);
            return result;

        } catch (Exception ex) {
            return false;
        }
    }

    public boolean deleteUserToDB(String uname) {
        try {
            String query = "delete from user where uname ='" + uname + "';";
            boolean result = singleConn.ExecuteQuery(query);
            return result;

        } catch (Exception ex) {
            return false;
        }
    }

}
