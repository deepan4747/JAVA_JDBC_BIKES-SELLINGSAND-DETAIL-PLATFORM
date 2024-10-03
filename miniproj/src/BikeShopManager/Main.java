package BikeShopManager;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventory inventory = new Inventory();
        Bike bike = new Bike();
        int choice;
        User user = new User();
        System.out.println("\t\t\tBIKES DETAIL PLATFORM");

        
        while (true) {
        	
            System.out.println("WELCOME TO 4747BIKES");
            System.out.print("USERNAME: ");
            user.setName(scanner.nextLine());

            System.out.print("PASSWORD: ");
            user.setPass(scanner.nextLine());

            if (user.getName().equals("deepan") && user.getPass().equals("deepan4747")) {
                System.out.println("Login successful!");
                break; 
            } else {
                System.out.println("Invalid credentials. Please try again.");
            }
        }
        
        do {
            System.out.println("1. Add");
            System.out.println("2. Update");
            System.out.println("3. Remove");
            System.out.println("4. Search by ID");
            System.out.println("5. Show");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter brand: ");
                    bike.setBrand(scanner.nextLine());
                    System.out.print("Enter name: ");
                    bike.setName(scanner.nextLine());
                    System.out.print("Enter price: ");
                    bike.setPrice(scanner.nextInt());
                    scanner.nextLine();
                    System.out.print("Enter mileage: ");
                    bike.setMileage(scanner.nextInt());
                    scanner.nextLine();
                    inventory.addBike(bike);
                    System.out.println("Bike added successfully.");
                    break;

                case 2:
                    System.out.println("Enter ID to Update the bike:");
                    int bikeIdUpdate = scanner.nextInt();
                    bike.setId(bikeIdUpdate);
                    System.out.println("Enter the records to update:");
                    scanner.nextLine();
                    System.out.print("Enter name: ");
                    bike.setName(scanner.nextLine());
                    System.out.print("Enter price: ");
                    bike.setPrice(scanner.nextInt());
                    scanner.nextLine();
                    inventory.updateBike(bike);
                    break;

                case 3:
                 /*   System.out.print("Enter bike index to remove (0-" + (inventory.getBikes().size() - 1) + "): ");
                    int indexToRemove = scanner.nextInt();
                    scanner.nextLine();
                    inventory.removeBike(indexToRemove);*/
                	System.out.println("Enter ID to delete the product");
                	int bikess=scanner.nextInt();
                	inventory.removeBike(bikess);
                    break;

                case 4:
                	System.out.print("Enter bike ID to search: ");
                	int searchId = scanner.nextInt();
                	scanner.nextLine(); // Consume the newline character

                	Bike foundBike = inventory.findBikeById(searchId);
                	if (foundBike != null) {
                	    System.out.println("Bike found:");
                	    System.out.println(foundBike);
                	} else {
                	    System.out.println("Bike not found.");
                	}

                case 5:
                    System.out.println("All bikes in inventory:");
                    inventory.showAllBikes();
                    break;

                case 6:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }

        } while (choice != 6);

        scanner.close();
    }
}
