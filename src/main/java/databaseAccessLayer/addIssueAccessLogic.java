package databaseAccessLayer;

import model.addIssueModel;
import databaseLayer.dbConnection;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class addIssueAccessLogic {

    private dbConnection singleConn;

    public addIssueAccessLogic() {
        singleConn = dbConnection.getSingleInstace();

    }

    public boolean UpdateIssueToDB(addIssueModel issue, int id) {
        try {
            String query = "update issues set sol='" + issue.getMsg() + "',status='" + issue.getStatus() + "'  where id ='" + id + "';";;

            boolean result = singleConn.ExecuteQuery(query);
            System.out.println(query);
            return result;
        } catch (Exception ex) {
            return false;
        }
    }

   
}
