import java.util.Scanner;

/*
    TO DO:
    Main tasks




*/
public class Main {
    public static void main(String[] args) {
        Scanner _scan = new Scanner(System.in);
        Boolean Playing = true;
        String spacer = "-------------------------------------------------------------------------------";
        Fishiest user = new Fishiest();


        System.out.println("Welcome to Fishiest, the worlds best fishing game in the command line");
        while (Playing) {
            System.out.println(spacer);
            System.out.println("Hello what would you like to do \n1. Cast lure \n2. Access items\n3. blah blah");
            int inp = _scan.nextInt();

            if (inp == 1) {
                System.out.println(spacer);
                System.out.println("you casted a lure");
            } else if (inp == 2) {
                System.out.println(spacer);
                user.inventoryCheck();
            }


            if (inp == 0) {
                Playing = false;
            }
        }
    }
}