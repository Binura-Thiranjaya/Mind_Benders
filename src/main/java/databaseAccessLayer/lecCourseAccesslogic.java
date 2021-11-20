/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseAccessLayer;

import model.lecCourseModel;
import databaseLayer.dbConnection;

public class lecCourseAccesslogic {

    private dbConnection singleConn;
    //Import new

    public lecCourseAccesslogic() {
        singleConn = dbConnection.getSingleInstace();

    }

    public boolean addGradeTODB(lecCourseModel grade,int id) {
        try {
            String query = "update tcourse set grade ='"+grade.getGrade()+"' where id="+id+";";
            System.out.println(query);
            boolean result = singleConn.ExecuteQuery(query);
            return result;
        } catch (Exception ex) {
            return false;
        }
    }
}
