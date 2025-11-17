import java.util.Scanner;

/*
    TO DO:
    1. Add fishing
    2. Fix inventory
    3. Make stats work with scalable luck
    4. Add fish
    5. Useable items, maybe selling fish




*/
public class Main {
    public static void main(String[] args) {
        Scanner _scan = new Scanner(System.in);
        Boolean Playing = true;
        String spacer = "-------------------------------------------------------------------------------";
        Fishiest user = new Fishiest();
        int screen = 1;


        System.out.println("Welcome to Fishiest, the worlds best fishing game in the command line");
        while (Playing) {
            if (screen == 1) {
                System.out.println(spacer);
                System.out.println("Hello what would you like to do \n1. Cast lure \n2. Access items\n3. blah blah");
                int inp = _scan.nextInt();

                if (inp == 1) {
                    System.out.println(spacer);
                    System.out.println("you casted a lure");
                } else if (inp == 2) {
                    screen = 2;
                }


                if (inp == 0) {
                    Playing = false;
                }
            } else if (screen == 2) {
                //Accessing inventory
                user.inventoryCheck();
                System.out.println(spacer);
                System.out.println("If you wish to use any, please type the index of item, else type 0 to exit");
                int inp = _scan.nextInt();

                if (inp == 0) {
                    screen = 1;
                } else {
                    user.useItem(inp);
                    screen = 1;
                }
            }
        }
    }
}