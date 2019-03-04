package learn.saga.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountService {

    private static String url = "jdbc:mysql://10.10.103.102:3306/saga?useUnicode=true&characterEncoding=UTF-8&useSSL=false";
    private static String user = "buynow";
    private static String password = "buynow";

    public static List<String[]> transfer(double fee, String type) throws Throwable{
        List<String[]> users = new ArrayList<String[]>();

        Connection con = null;
        PreparedStatement pst = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            String sql = "update account set money = money + ? where type = ?";
            con.setAutoCommit(false);
            pst = con.prepareStatement(sql);
            pst.setDouble(1, fee);
            pst.setString(2, type);
            pst.execute();
            con.commit();

        } finally {
            if (con != null) {
                try {
                    con.setAutoCommit(true);
                    con.close();
                } catch (SQLException e) {
                    // ignore
                    e.printStackTrace();
                }
            }
        }
        return users;

    }

    public static void main(String[] args) {
        try {
            AccountService.transfer(1000, "DEBT");
            System.out.println("yeah");
        }
        catch (Throwable e) {
            e.getStackTrace();
        }
    }

}
