import java.util.ArrayList;
import java.util.Arrays;

public class Fishiest {
    private int userLuck = 5;
    private int userStrength = 1;
    private ArrayList<String[]> userInv = new ArrayList<>();

    public Fishiest() {

    }

    public void castLure() {


    }

    public void inventoryCheck() {
        userInv.add(new String[]{"1", "Fish"});
        userInv.add(new String[]{"2", "Not Fish"});
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("You have ");
        for (int i = 0; i < userInv.size(); i++) {
            System.out.print(i + ") ");
            System.out.println(userInv.get(i)[0] + " " + userInv.get(i)[1]);
        }

    }
}
