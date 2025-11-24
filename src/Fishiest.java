import java.util.ArrayList;
import java.util.HashMap;

public class Fishiest {
    private int userLuck = 5;
    private int fishCaught = 0;
    private HashMap<String, Integer> userInv = new HashMap<>() {{
        put("Bait", 10);
        put("Salmon", 10);
    }};

    private ArrayList<ArrayList<String>> fishCatalog = new ArrayList<>() {{
        add(new ArrayList<>() {{ add("Common"); add("Boot"); }});
        add(new ArrayList<>() {{ add("Common"); add("Cod"); }});
        add(new ArrayList<>() {{ add("Common"); add("Salmon"); }});
        add(new ArrayList<>() {{ add("Rare"); add("Eel"); }});
        add(new ArrayList<>() {{ add("Epic"); add("Swordfish"); }});
        add(new ArrayList<>() {{ add("Legendary"); add("Leviathan"); }});
    }};

    public Fishiest() {

    }

    public String catchFish() {
        System.out.println("-------------------------------------------------------------------------------");

        ArrayList<String> fishPool = new ArrayList<>();

        for (ArrayList<String> entry : fishCatalog) {
            String rarity = entry.get(0);
            String fishName = entry.get(1);

            int weight = switch (rarity) {
                case "Common" -> 8;
                case "Rare" -> 4;
                case "Epic" -> 2;
                case "Legendary" -> 1;
                default -> 1;
            };

            // Add fish to pool based on weight
            for (int i = 0; i < weight; i++) {
                fishPool.add(fishName);
            }
        }

        // Randomly choose fish
        String caughtFish = fishPool.get((int)(Math.random() * fishPool.size()));

        System.out.println("Caught fish " + caughtFish);
        System.out.println("Debug " + fishPool);

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
            for (int i = 10; i >= attracted; i--) {
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
