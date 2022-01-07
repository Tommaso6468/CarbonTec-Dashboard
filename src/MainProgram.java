import java.io.File;
import java.io.IOException;

public class MainProgram {

    public static void main(String[] args) throws IOException{


//        losapparaatScherm();
//        loginScherm();
        nieuwapparaatScherm();
        File fm = new File("apparaten.csv");

    }

    public static String gekozenLosApparaat;
    public static String naamGekozenApparaat;



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
            //5 is los apparaat
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

            if (homeReturn == 5){
                home.setVisible(false);
                losapparaatScherm();
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
            //4 is nieuw apparaat
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

            if (apparatenReturn == 4){
                apparaten.setVisible(false);
                nieuwapparaatScherm();
            }

            if (apparatenReturn == 5){
                apparaten.setVisible(false);
                losapparaatScherm();
            }

        };

    }
    public static void losapparaatScherm () {


        LosApparaat losApparaat = new LosApparaat();
        losApparaat.setVisible(true);

        losApparaat.callback = (losApparaatReturn) -> {

            //1 is logout
            //2 is home
            //3 is apparaten
            if (losApparaatReturn == 1){
                losApparaat.setVisible(false);
                try {
                    loginScherm();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (losApparaatReturn == 2){
                losApparaat.setVisible(false);
                try {
                    homeScherm();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (losApparaatReturn == 3){
                losApparaat.setVisible(false);
                apparatenScherm();
            }

        };



    }

    public static void nieuwapparaatScherm () {


        NieuwApparaat nieuwApparaat = new NieuwApparaat();
        nieuwApparaat.setVisible(true);

        nieuwApparaat.callback = (nieuwApparaatReturn) -> {

            //1 is logout
            //2 is home
            //3 is apparaten
            if (nieuwApparaatReturn == 1){
                nieuwApparaat.setVisible(false);
                try {
                    loginScherm();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (nieuwApparaatReturn == 2){
                nieuwApparaat.setVisible(false);
                try {
                    homeScherm();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (nieuwApparaatReturn == 3){
                nieuwApparaat.setVisible(false);
                apparatenScherm();
            }

        };



    }
    public static void grafiekscherm () {

        Grafiek Grafiek = new Grafiek();
        Grafiek.setVisible(true);

    }

}
