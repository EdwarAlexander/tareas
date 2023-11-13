package ejercicio13;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String customerName;
    private int customerID;
    private List<RentalItem> rentedItems;

    public Customer(String customerName, int customerID) {
        this.customerName = customerName;
        this.customerID = customerID;
        this.rentedItems = new ArrayList<>();
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public List<RentalItem> getRentedItems() {
        return rentedItems;
    }

    public void rentItem(RentalItem item) {
        if (item.isAvailable()) {
            rentedItems.add(item);
            item.setAvailable(false);
            System.out.println("Item rented successfully!");
        } else {
            System.out.println("Item is not available for rent.");
        }
    }

    public void returnItem(RentalItem item) {
        if (rentedItems.contains(item)) {
            rentedItems.remove(item);
            item.setAvailable(true);
            System.out.println("Item returned successfully!");
        } else {
            System.out.println("Item not rented by this customer.");
        }
    }

    public void showCustomerDetails() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Customer ID: " + customerID);
        System.out.println("Rented Items:");
        for (RentalItem item : rentedItems) {
            item.showDetails();
            System.out.println("-----");
        }
    }
}
