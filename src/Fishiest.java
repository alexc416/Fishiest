import java.util.ArrayList;
import java.util.HashMap;

public class Fishiest {
    private int userLuck = 5;
    private int fishCaught = 0;
    private HashMap<String, Integer> userInv = new HashMap<>() {{
        put("Bait", 10);
        put("Salmon", 10);
    }};
    

    public Fishiest() {

    }

    public int catchFish() {
        System.out.println("-------------------------------------------------------------------------------");
        //need to think about luck system and how to integrate
        int caughtFish = (int) (Math.random()*10);
        return caughtFish;
    }

    public void fishGraphic(int dis, int attracted) {
        System.out.println("         o      ");
        System.out.println("       / []      ");
        System.out.println("      |  ||       ");
        System.out.println("      :  ----------");
        for (int i = 0; i < dis; i++) {
            System.out.println("      :            ");
        }
        if (attracted >= 10) {
            System.out.println("      :<<--         ");
        } else {
            System.out.print("      :");
            for (int i = 0; i <= attracted; i++) {
                System.out.print("   ");
            }
            System.out.println("<<--");
        }
    }

    public void inventoryCheck() {
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("You have ");

        String[] userInvItems = userInv.keySet().toArray(new String[0]);
        Integer[] userInvCounts = userInv.values().toArray(new Integer[0]);
        for (int i = 0; i < userInv.size(); i++) {
            System.out.print((i+1) + ") ");
            System.out.println(userInvCounts[i] + " " + userInvItems[i]);
        }
    }

    public void useItem(int ind) {
        String item = userInv.keySet().toArray(new String[0])[ind-1];
        switch (item) {
            case "Bait":
                System.out.println("You used Bait. Your luck increased!");
                break;
            case "Salmon":
                System.out.println("You ate the Salmon. Your luck increased!");
                break;
            default:
                System.out.println("Debug: item not included");
                break;
        }
        userInv.put(item, userInv.get(item)-1);
        if (userInv.get(item) <= 0) {
            userInv.remove(item);
        }
    }

    public void statCheck() {
        System.out.println("Luck: " + userLuck);
        System.out.println("Fish Caught: " + fishCaught);
    }

}
