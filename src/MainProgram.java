public class MainProgram {

    public static void main(String[] args){
        //1 is inloggen
        //2 is signup
        LogIn logIn = new LogIn();
        logIn.callback = (i) -> {

            System.out.println(i);


            if (i == 2) {
                logIn.setVisible(false);
                SignUp signUp = new SignUp();
                signUp.setVisible(true);
                //System.out.println(2);
            }

        };
        logIn.setVisible(true);





        //new SignUp().setVisible(true);
    }

}
