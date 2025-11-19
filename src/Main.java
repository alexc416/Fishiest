import java.util.Scanner;

/*
    TO DO:
    1. Add fishing
    2. Fix inventory
    3. Make stats work with scalable luck
    4. Add fish
    5. Useable items, maybe selling fish

    Also clean up UI



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
                System.out.println("Hello what would you like to do \n1. Cast lure \n2. Access items\n3. Check stats");
                int inp = _scan.nextInt();

                if (inp == 1) {
                    screen = 2;
                    System.out.println(spacer);
                    System.out.println("You have a fish on the line, do you wish to \n1. Pull it out of the water! \n2. Start reeling it in \n3. Give it some more line");
                    System.out.println("(HINT!: Giving the fish line is always a safe option, you want to have a balence between reeling and giving, untill finaly pulling it out of the water when you think you closed the distance, yet also have the fish intrested)");
                } else if (inp == 2) {
                    screen = 3;
                } else if (inp == 3) {
                    user.statCheck();
                }

                if (inp == 0) {
                    Playing = false;
                }

            } else if (screen == 2) {
                /*
                Changing Attraction and distance
                The idea is that Attraction is on a scale of 0-10, and distance is random
                The difficulty is going to be 1-5 on rarities

                Every turn if you give line, you have a chance based on the difficulty if you lose attraction or gain, more so you should gain
                If you reel it in then you have a chance based on the difficulty if you lose attraction or gain, riskier than giving line, and

                When you reel in a random num is generated 1-100
                A base line is going to be generated from the distance, and fish attraction
                if the num is greater than the baseline, you succesfully reel in, otherwise you dont

                */
                int fishCaught = user.catchFish();

                int difficulty = 5;
                int distance = (int) (Math.random()*10)+5;
                int fishAtraction = 1;

                boolean catching = true;

                while (catching) {
                    user.fishGraphic(distance, fishAtraction);
                    int inp = _scan.nextInt();
                    if (inp == 1) {
                        if (fishAtraction > difficulty && distance < 10) {
                            System.out.println("You pulled the fish out of the water! Congrats you caught a " + fishCaught);
                        } else {
                            if (distance >= 10) {
                                System.out.println("The fish is was too far away!"); 
                            } else {
                                System.out.println("You reeled in the fish to early!");
                            }
                        }
                        catching = false;
                        screen = 1;
                    } else if (inp == 2) {
                        int reelRoll = (int) (Math.random()*26);
                        if (reelRoll > difficulty) {
                            System.out.println("You reeled in the fish closer.");
                            distance -= 5;
                            fishAtraction += 2;

                            System.out.println("What do you wish to do next? \n1. Pull it out of the water! \n2. Start reeling it in \n3. Give it some more line");
                            System.out.println("Fish Intrestedness: " + fishAtraction);
                            System.out.println("Fish Distance: " + distance);
                            //might replace this with less descriptive message later
                        } else {
                            System.out.println("The fish pulled away and let go!");
                            catching = false;
                        }

                    } else if (inp == 3) {
                        System.out.println("You gave the fish some more line.");
                        fishAtraction += 2;
                        distance += 3;

                        System.out.println("What do you wish to do next? \n1. Pull it out of the water! \n2. Start reeling it in \n3. Give it some more line");
                        System.out.println("Fish Intrestedness: " + fishAtraction);
                        System.out.println("Fish Distance: " + distance);

                    }
                }

            } else if (screen == 3) {
                //Accessing inventory
                user.inventoryCheck();
                System.out.println(spacer);
                System.out.println("If you wish to use any, please type the index of item, else type 0 to exit");
                int inp = _scan.nextInt();

                if (inp == 0) {
                    screen = 1;
                } else {
                    user.useItem(inp);
                }
            }
        }
        _scan.close();
    }
}