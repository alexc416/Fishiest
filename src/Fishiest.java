import java.util.ArrayList;

public class Fishiest {
    private int userLuck = 5;
    private int fishCaught = 0;
    private ArrayList<String[]> userInv = new ArrayList<>();

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
        userInv.add(new String[]{"1", "Fish"});
        userInv.add(new String[]{"2", "Not Fish"});
        userInv.add(new String[]{"3", "Bait"});
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("You have ");

        for (int i = 0; i < userInv.size(); i++) {
            System.out.print((i+1) + ") ");
            System.out.println(userInv.get(i)[0] + " " + userInv.get(i)[1]);
        }
    }

    public void useItem(int ind) {
        String item = userInv.get(ind-1)[1];
        if (item.equals("Fish")) {
            System.out.println("You can't do anything with the fish");
        } else if (item.equals("Bait")) {
            System.out.println("You used Bait, your luck has increased");
        } else {
            System.out.println("Debug, item not included");
        }

        String[] updatedItem = new String[] {String.valueOf(Integer.parseInt(userInv.get(ind-1)[0]) - 1), userInv.get(ind-1)[1]};
        userInv.remove(ind+1);
        userInv.add(ind+1, updatedItem);
    }

    public void statCheck() {
        System.out.println("Luck: " + userLuck);
        System.out.println("Fish Caught: " + fishCaught);
    }

}
