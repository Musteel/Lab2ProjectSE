import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database {


    void dbConnection(){
        try{
            // Get connection
            Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root" , "root");
            // Create statement
            Statement mySta = myConnection.createStatement();
            // Execute query
            ResultSet myRs = mySta.executeQuery("SELECT * FROM user");
            while (myRs.next()){
                String firstname = myRs.getString("user_name");
                System.out.println(firstname);
            }



        }
        catch (Exception exc) {
            exc.printStackTrace();
        }



    }

    Connection dbConnect() throws Exception {


        Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");

        return myCon;
    }


    public String isLogin(String username, String password) throws Exception {


        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
        String query = "SELECT * FROM user";

        // create the java statement
        Statement st = conn.createStatement();

        // execute the query, and get a java resultset
        ResultSet rs = st.executeQuery(query);
        String login="";
        // iterate through the java resultset
        while (rs.next()) {

            String firstName = rs.getString("user_name");
            String passwordOne = rs.getString("user_password");

            if (firstName.equals(username)&&passwordOne.equals(password)) {
                System.out.println("Logged In");
                login = "Done";


            }

        }return login;

    }

}
