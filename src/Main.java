import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner _scan = new Scanner(System.in);
        Boolean playing = true;
        String spacer = "-------------------------------------------------------------------------------";
        String cutsceneSpacer = "///////////////////////////////////////////////////////////////////////////////";
        Fishiest user = new Fishiest();
        int screen = 1;

        System.out.println("Welcome to Fishiest, the worlds best fishing game in the command line");
        while (playing) {
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
                    System.out.println(cutsceneSpacer);
                } else if (inp == 3) {
                    System.out.println(cutsceneSpacer);
                    user.statCheck();
                }

                if (inp == 0) {
                    playing = false;
                }

            } else if (screen == 2) {
                /*
                Changing Attraction and distance
                The idea is that Attraction is on a scale of 0-10, and distance is random
                The difficulty is going to be 1-5 on rarities

                Every turn if you give line, you have a chance based on the difficulty if you lose attraction or gain, more so you should gain
                If you reel it in then you have a chance based on the difficulty if you lose attraction or gain, riskier than giving line, and

                */
                String[] fishCaught = user.catchFish();
                System.out.println("it seems you have hooked a " + fishCaught[1] + " fish!");
                int distance = (int) (Math.random()*8)+3;

                int difficulty = switch (fishCaught[1]) {
                    case "Common" -> 1;
                    case "Rare" -> 2;
                    case "Epic" -> 3;
                    case "Legendary" -> 4;
                    default -> 1;
                };

                int fishAtraction = 10 - (difficulty * 2);       // 0 to 10

                boolean catching = true;

                while (catching) {
                    user.fishGraphic(distance, fishAtraction);
                    int luckRoll = (int) (Math.random() * 100);
                    System.out.println("LR: " + luckRoll);
                    //debug
                    int inp = _scan.nextInt();
                    if (inp == 1) {
                        if (distance > 10) {
                            System.out.println("The fish was nowhere near you");
                        } else {
                            if (luckRoll > (100 - (fishAtraction * 7)) + (distance * 2)) {
                                System.out.println("CONGRATS! You caught a " + fishCaught[1] + " " + fishCaught[0] + "!");
                                user.addFish(fishCaught[0]);
                            } else {
                                System.out.println("You lost the fish...");
                            }
                        }
                        catching = false;
                        screen = 1;

                    } else if (inp == 2) {
                        if (luckRoll > (difficulty * 10)) {
                            System.out.println("You reeled in the fish closer.");
                            System.out.println(spacer);
                            distance -= (int) (Math.random() * 3) + 1;
                            fishAtraction += (int) (Math.random() * 2) + 1;

                            System.out.println("What do you wish to do next? \n1. Pull it out of the water! \n2. Start reeling it in \n3. Give it some more line");
                            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
                            System.out.println("Fish Intrestedness: " + fishAtraction);
                            System.out.println("Fish Distance: " + distance);
                            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
                            //might replace this with less descriptive message later
                        } else {
                            System.out.println("The fish pulled away and let go...");
                            catching = false;
                            screen = 1;
                        }

                    } else if (inp == 3) {
                        System.out.println("You gave the fish some more line.");
                        System.out.println(spacer);
                        fishAtraction += 1;
                        distance += (int) (Math.random() * 3) + 1;

                        System.out.println("What do you wish to do next? \n1. Pull it out of the water! \n2. Start reeling it in \n3. Give it some more line");
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println("Fish Intrestedness: " + fishAtraction);
                        System.out.println("Fish Distance: " + distance);
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        //might replace this with less descriptive message later
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