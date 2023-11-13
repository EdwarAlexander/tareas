package ejercicio13;

import java.util.ArrayList;
import java.util.List;

public class MovieRentalSystem {

    private List<RentalItem> rentalItems;
    private List<Customer> customers;

    public List<RentalItem> getRentalItems() {
        return rentalItems;
    }

    public void setRentalItems(List<RentalItem> rentalItems) {
        this.rentalItems = rentalItems;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public MovieRentalSystem() {
        this.rentalItems = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    public void addItem(RentalItem item) {
        rentalItems.add(item);
    }

    public void registerCustomer(Customer customer) {
        customers.add(customer);
    }

    public void rentMovieToCustomer(Customer customer, RentalItem item) {
        customer.rentItem(item);
    }

    public void returnMovie(Customer customer, RentalItem item) {
        customer.returnItem(item);
    }

    public void showAllItems() {
        for (RentalItem item : rentalItems) {
            item.showDetails();
            System.out.println("-----");
        }
    }

    public void showAllCustomers() {
        for (Customer customer : customers) {
            customer.showCustomerDetails();
            System.out.println("===============");
        }
    }
}
