import java.io.IOException;

public class MainProgram {

    public static void main(String[] args) throws IOException {
        //1 is inloggen
        //2 is signup
        LogIn logIn = new LogIn();
        logIn.callback = (i) -> {

            if (i == 1) {
                logIn.setVisible(false);
                Home home = new Home();
                home.setVisible(true);
            }


            if (i == 2) {
                logIn.setVisible(false);
                SignUp signUp = null;
                try {


                    signUp = new SignUp();
                    signUp.setVisible(true);



                } catch (IOException e) {
                    e.printStackTrace();
                }
                //System.out.println(2);
            }

        };
        logIn.setVisible(true);





        //new SignUp().setVisible(true);
    }

}
