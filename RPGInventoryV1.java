import java.util.Arrays;

public class RPGInventoryV1 {

    static int[] inventory = {101, 505, 202}; 

    public static void lootItem(int newItemID) {
      int[] newInv = new int[inventory.length+1];
      int i = 0;
      for (int item : inventory) newInv[i++] = item;
      newInv[i] = newItemID;
      inventory = newInv;
    }

    public static void dropItem(int itemID) {
      int[] newInv = new int[inventory.length!=0?inventory.length-1:0];
      int i = 0;
      int deleted = 0;
      for (int item : inventory) if((item != itemID || deleted++ == 1) && i != newInv.length) newInv[i++] = item;  // Important!!!
      if(deleted == 0) return
      inventory = newInv;
    }

    public static double calculateTotalWeight() {
      double totalWeight = 0.0;
      for (int i=0; i<inventory.length; i++) {
          if(100<=inventory[i] && inventory[i]<200) totalWeight+=5.0;
          else if(200<=inventory[i] && inventory[i]<300) totalWeight+=10.0;
          else totalWeight+=1.0;
      }
      return totalWeight;
    }

    public static void main(String[] args) {
        System.out.println("--- START ---");
        System.out.print("Inventory: " + Arrays.toString(inventory));
        System.out.println(" | Total Weight: " + calculateTotalWeight()); 

        System.out.println("\n--- LOOTING RING (550) ---");

        lootItem(550);
        
        System.out.print("Inventory: " + Arrays.toString(inventory));
        System.out.println(" | Total Weight: " + calculateTotalWeight());

        System.out.println("\n--- DROPPING SHIELD (202) ---");
        dropItem(202);
        
        System.out.print("Inventory: " + Arrays.toString(inventory));
        System.out.println(" | Total Weight: " + calculateTotalWeight());

        System.out.println("\n--- DROPPING MISSING ITEM (999) ---");
        dropItem(999);
        
        System.out.print("Inventory: " + Arrays.toString(inventory));
        System.out.println(" | Total Weight: " + calculateTotalWeight());
    }
}
