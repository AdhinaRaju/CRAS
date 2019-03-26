/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DBConnection;

import java.sql.ResultSet;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author user
 */
@WebService(serviceName = "NewWebService")
public class NewWebService {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Login")
    public String Login(@WebParam(name = "username") String username, @WebParam(name = "password") String password) {
        //TODO write your implementation code here:
        //TODO write your implementation code here:
        connection reg =  new connection();
        String res = "";
        try
        {
           // String ins = "select * from  tbl_empreg where emp_username='"+username+"' and emp_password='"+password+"'"; 
            //'qwerty' and 'qwerty';

           String ins = "select * from tbl_empreg where emp_username='"+username+"' and emp_password='"+password+"'";
            ResultSet rs = reg.select(ins);
            if(rs.next())
            { res = rs.getString(1);
            } else {
                res = "failed";
            }

        } catch (Exception e) {

            res = e.toString();

        }

        return res;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ServerList")
    public String ServerList(@WebParam(name = "server_id") String server_id, @WebParam(name = "server_name") String server_name, @WebParam(name = "server_status") String server_status) {
        //TODO write your implementation code here:
         connection reg =  new connection();
         String res="";
        try
        {
        String slst="select * from tbl_server";
        ResultSet rs= reg.select(slst);   
        if (rs.next()) {
                res = "";
                while (rs.next()) {
                    res += rs.getString("server_id") + "#" + rs.getString("server_name") + "-" + rs.getString("server_status") + "$";
                }
            } else {
                res = "failed";
            }

        } catch (Exception e) {

            res = e.toString();

        }

        return res;
    }
}
