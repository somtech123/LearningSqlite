import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try{
            Connection conn = DriverManager.getConnection("jdbc:sqlite:\\C:\\Users\\hp\\Documents\\javaPrograms\\JavaFolder\\LearningSqlite\\testjava.db");
            // conn.setAutoCommit(false);
            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS contacts " +
                    "(name TEXT, phone INTEGER, email TEXT)");
            //statement.execute("UPDATE contacts SET phone=66689 WHERE name = 'allan'");

//            statement.execute("INSERT INTO contacts (name, phone, email) " +
//                    "VALUES('joe', '123456', 'joe@gmail.com') ");
//
//            statement.execute("INSERT INTO contacts (name, phone, email) " +
//                    "VALUES('snow', '0000123', 'snow@nowhere.com') ");
//
//            statement.execute("INSERT INTO contacts (name, phone, email) " +
//                    "VALUES('allan', '11111', 'allan@gmail.com') ");
            statement.execute("DELETE FROM contacts WHERE name='snow' ");
            statement.execute("SELECT * FROM contacts");
            ResultSet result = statement.getResultSet();
            while (result.next()){
                System.out.println(result.getString("name") + " " +
                        result.getInt("phone") + " " +
                        result.getString("email"));
            }
            result.close();

            statement.close();
            conn.close();
        }catch (SQLException e){
            System.out.println("something went wrong " +  e.getMessage());
        }
    }
}