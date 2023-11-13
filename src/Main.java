import ejercicio13.Customer;
import ejercicio13.Movie;
import ejercicio13.MovieRentalSystem;
import ejercicio13.RentalItem;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Movie movie1 = new Movie("Inception", 1, "Christopher Nolan", 148, "PG-13", "Sci-Fi");
        Movie movie2 = new Movie("The Shawshank Redemption", 2, "Frank Darabont", 142, "R", "Drama");

        MovieRentalSystem rentalSystem = new MovieRentalSystem();
        rentalSystem.addItem(movie1);
        rentalSystem.addItem(movie2);

        Customer customer1 = new Customer("John Doe", 101);
        Customer customer2 = new Customer("Jane Smith", 102);
        rentalSystem.registerCustomer(customer1);
        rentalSystem.registerCustomer(customer2);

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("========= Sistema de alquiler de películas =========");
            System.out.println("1. Alquilar una película");
            System.out.println("2. Devolver una película");
            System.out.println("3. Mostrar todos los artículos");
            System.out.println("4. Mostrar todos los clientes");
            System.out.println("0. Salida");
            System.out.print("Ingrese su opción: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    showAllItems(rentalSystem);
                    System.out.print("Ingrese el ID de la pelicula a alquilar: ");
                    int rentItemID = scanner.nextInt();
                    RentalItem rentItem = findItemById(rentalSystem.getRentalItems(), rentItemID);
                    if (rentItem != null) {
                        showAllCustomers(rentalSystem);
                        System.out.print("Ingrese el ID del cliente para alquilar: ");
                        int customerID = scanner.nextInt();
                        Customer rentCustomer = findCustomerById(rentalSystem, customerID);
                        if (rentCustomer != null) {
                            rentalSystem.rentMovieToCustomer(rentCustomer, rentItem);
                            System.out.println("Película alquilada con éxito!");
                        } else {
                            System.out.println("Cliente no encontrado.");
                        }
                    } else {
                        System.out.println("No encontrado.");
                    }
                    break;

                case 2:
                    showAllCustomers(rentalSystem);
                    System.out.print("Ingrese el ID del cliente desde el cual regresar: ");
                    int returnCustomerID = scanner.nextInt();
                    Customer returnCustomer = findCustomerById(rentalSystem, returnCustomerID);
                    if (returnCustomer != null) {
                        showRentedItems(returnCustomer);
                        System.out.print("Ingrese el ID de la pelicula a devolver: ");
                        int returnItemID = scanner.nextInt();
                        RentalItem returnItem = findItemById(returnCustomer.getRentedItems(), returnItemID);
                        if (returnItem != null) {
                            rentalSystem.returnMovie(returnCustomer, returnItem);
                            System.out.println("La película se devolvió con éxito!");
                        } else {
                            System.out.println("Pelicula no alquilado por este cliente.");
                        }
                    } else {
                        System.out.println("Cliente no encontrado.");
                    }
                    break;

                case 3:
                    showAllItems(rentalSystem);
                    break;

                case 4:
                    showAllCustomers(rentalSystem);
                    break;

                case 0:
                    System.out.println("Salir del sistema de alquiler de películas. Gracias!");
                    break;

                default:
                    System.out.println("Opción no válida. Por favor ingresa una opción válida.");
                    break;
            }

        } while (choice != 0);

        scanner.close();
    }

    private static void showAllItems(MovieRentalSystem rentalSystem) {
        System.out.println("========= Todos las peliculas =========");
        rentalSystem.showAllItems();
        System.out.println("=============================");
    }

    private static void showAllCustomers(MovieRentalSystem rentalSystem) {
        System.out.println("========= Todos los clientes =========");
        rentalSystem.showAllCustomers();
        System.out.println("===============================");
    }

    private static void showRentedItems(Customer customer) {
        System.out.println("========= Peliculas alquiladas =========");
        for (RentalItem item : customer.getRentedItems()) {
            item.showDetails();
            System.out.println("-----");
        }
        System.out.println("===============================");
    }

    private static RentalItem findItemById(List<RentalItem> items, int itemID) {
        for (RentalItem item : items) {
            if (item.getItemID() == itemID) {
                return item;
            }
        }
        return null;
    }

    private static Customer findCustomerById(MovieRentalSystem rentalSystem, int customerID) {
        for (Customer customer : rentalSystem.getCustomers()) {
            if (customer.getCustomerID() == customerID) {
                return customer;
            }
        }
        return null;
    }
}