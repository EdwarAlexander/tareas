package ejercicio13;

public class RentalItem {
    private String itemName;
    private int itemID;
    private boolean available;

    public RentalItem(String itemName, int itemID) {
        this.itemName = itemName;
        this.itemID = itemID;
        this.available = true;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void showDetails() {
        System.out.println("Item Name: " + itemName);
        System.out.println("Item ID: " + itemID);
        System.out.println("Available: " + available);
    }
}
