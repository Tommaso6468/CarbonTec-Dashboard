import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.*;

public class DBUtils {

    public static void main(String[]args) {
    }


    public static String voorNaam;
    public static String achterNaam;
    public static String emailAdres;
    public static String Pwd;




    public static void signUpUser (){
        Connection connection = null;
        PreparedStatement psInsert = null;
        PreparedStatement psCheckUserExists = null;
        ResultSet resultSet = null;

        String connectionUrl = "jdbc:mysql://localhost:3306/CO2MELDER";
        String user = "root";
        String pass = "delft2001";

        try {

            connection = DriverManager.getConnection(connectionUrl, user, pass);
            psCheckUserExists = connection.prepareStatement("SELECT * FROM gebruikers WHERE emailadres = ?");
            psCheckUserExists.setString(1, emailAdres);
            resultSet = psCheckUserExists.executeQuery();

            if (resultSet.isBeforeFirst()) {
                System.out.println("Emailadres bestaat al!");
            } else {
                psInsert = connection.prepareStatement("INSERT INTO gebruikers (voornaam, achternaam, emailadres, wachtwoord) VALUES (?, ?, ?, ?)");
                psInsert.setString(1, voorNaam);
                psInsert.setString(2, achterNaam);
                psInsert.setString(3, emailAdres);
                psInsert.setString(4, Pwd);
                psInsert.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if (psCheckUserExists != null) {
                try {
                    psCheckUserExists.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (psInsert != null) {
                try {
                    psInsert.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void logInUser() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String connectionUrl = "jdbc:mysql://localhost:3306/CO2MELDER";
        String user = "root";
        String pass = "delft2001";
        try {
            connection = DriverManager.getConnection(connectionUrl, user, pass);
            preparedStatement = connection.prepareStatement("SELECT wachtwoord FROM gebruikers WHERE emailadres = ?");
            preparedStatement.setString(1, emailAdres);
            resultSet = preparedStatement.executeQuery();

            if (!resultSet.isBeforeFirst()) {
                System.out.println("Gebruiker niet gevonden!");
            } else {
                while (resultSet.next()) {
                    String retrievedPwd = resultSet.getString("wachtwoord");
                    if (retrievedPwd.equals(Pwd)) {
                        System.out.println("Welkom");
                    } else {
                        System.out.println("Wachtwoord komt niet overeen");
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null)
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
