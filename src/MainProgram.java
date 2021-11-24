import java.io.IOException;
import java.util.function.Consumer;

public class MainProgram {

    public static void main(String[] args) throws IOException {

        loginScherm();

    }



    public static void loginScherm() throws IOException {

        //1 is inloggen
        //2 is signup
        LogIn logIn = new LogIn();
        logIn.setVisible(true);
        logIn.callback = (loginReturn) -> {

            if (loginReturn == 1) {
                logIn.setVisible(false);
                try {
                    homeScherm();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


            if (loginReturn == 2) {
                logIn.setVisible(false);
                try {
                    signupScherm();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        };

    }



    public static void signupScherm() throws IOException {

        //1 is aanmaken
        //2 is terug naar login
        SignUp signUp = new SignUp();
        signUp.setVisible(true);
        signUp.callback = (signupReturn) -> {

            if (signupReturn == 1){
                signUp.setVisible(false);
                try {
                    homeScherm();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (signupReturn == 2){
                signUp.setVisible(false);
                try {
                    loginScherm();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        };

    }



    public static void homeScherm() throws InterruptedException {

        Home home = new Home();
        home.setVisible(true);

        home.callback = (homeReturn) -> {

            //1 is logout
            //2 is home
            //3 is apparaten
            if (homeReturn == 1){
                home.setVisible(false);
                try {
                    loginScherm();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (homeReturn == 2){
                home.setVisible(false);
                try {
                    homeScherm();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (homeReturn == 3){
                home.setVisible(false);
                apparatenScherm();
            }

        };

    }

    public static void apparatenScherm(){

        Apparaten apparaten = new Apparaten();
        apparaten.setVisible(true);

        apparaten.callback = (apparatenReturn) -> {

            //1 is logout
            //2 is home
            //3 is apparaten
            if (apparatenReturn == 1){
                apparaten.setVisible(false);
                try {
                    loginScherm();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (apparatenReturn == 2){
                apparaten.setVisible(false);
                try {
                    homeScherm();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (apparatenReturn == 3){
                apparaten.setVisible(false);
                apparatenScherm();
            }

        };

    }

}
