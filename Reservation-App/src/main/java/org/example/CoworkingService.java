package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class CoworkingService {
    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList<CoworkingSpaces> coworkingSpaces = new ArrayList<>();

    static {
        coworkingSpaces.add(new CoworkingSpaces(1, "Open", 22.5, true));
        coworkingSpaces.add(new CoworkingSpaces(2, "Private", 30.2, true));
        coworkingSpaces.add(new CoworkingSpaces(3, "Open", 22.5, true));

    }

    public void addCoworkingSpaces() {
        int addId = 1;
        if (!coworkingSpaces.isEmpty()) {
            addId = coworkingSpaces.get(coworkingSpaces.size()-1).getId() + 1;
        }
        try {
            System.out.print("Writing type (open/private):");
            String spacesType = scanner.nextLine();
            if (!spacesType.equalsIgnoreCase("open") && !spacesType.equalsIgnoreCase("private")) {
                throw new InvalidOperationException("Invalid space type! Only 'open' or 'private' are allowed.");
            }

            System.out.print("Specify the price:");
            double spacesPrice = scanner.nextDouble();

            if (spacesPrice <= 0) {
                throw new InvalidOperationException("Price must be greater than 0!");
            }

            System.out.print("isAvailable? - true/false:");
            boolean isAvailable = scanner.nextBoolean();

            CoworkingSpaces addSpace = new CoworkingSpaces(addId, spacesType, spacesPrice, isAvailable);
            coworkingSpaces.add(addSpace);
        } catch (InvalidOperationException e) {
            System.err.println("Error" + e.getMessage());
            addCoworkingSpaces();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println();
        System.out.println("New add coworking space? (add/back)!\n");
        System.out.print("Enter your choice: ");
        String newAdd = scanner.next();
        scanner.nextLine();


        if (newAdd.equalsIgnoreCase("Add")) {
            addCoworkingSpaces();
        } else {
            Main.adminMenu();
        }
    }

    public void removeSpaces() {

        for (CoworkingSpaces it : coworkingSpaces) {
            System.out.println("Id:" + it.getId() + " " + "Type:" + it.getType() + " " + "Price:" + it.getPrice() + " " + "IsAvailable:" + it.getIsAvailable());
        }

        getElementById();

        for (CoworkingSpaces it : coworkingSpaces) {
            System.out.println("Id:" + it.getId() + " " + "Type:" + it.getType() + " " + "Price:" + it.getPrice() + " " + "IsAvailable:" + it.getIsAvailable());
        }
        System.out.println();
        System.out.println("Do you want to remove it again? (Yes/No)\n");
        System.out.print("Enter your choice: ");
        String newAdd = scanner.next();

        if (newAdd.equalsIgnoreCase("Yes")) {
            removeSpaces();
        } else {
            Main.adminMenu();
        }

    }

    public void viewAllSpaces() {
        if (coworkingSpaces.isEmpty()) {
            System.out.println("No coworking spaces available!\n");
            Main.adminMenu();
            return;
        }

        for (CoworkingSpaces it : coworkingSpaces) {
            System.out.println("Id:" + it.getId() + " " + "Type:" + it.getType() + " " + "Price:" + it.getPrice() + " " + "IsAvailable:" + it.getIsAvailable());

        }
        System.out.print("If you want to go back -> 'back': ");
        String goBack = scanner.next();
        if (goBack.equalsIgnoreCase("back")) {
            Main.adminMenu();
        } else {
            Main.Menu();

        }

    }

    public void getElementById() {
        System.out.print("Select the index you want to delete:");
        int choise = scanner.nextInt();

        try {
        for (int i = 0; i < coworkingSpaces.size(); i++) {
            if (coworkingSpaces.get(i).getId() == choise)
                coworkingSpaces.remove(i);
        }

            if (choise < 0 || choise >= coworkingSpaces.size()) {
                throw new InvalidOperationException("Invalid index!");
            }
            System.out.println("Coworking space removed successfully!\n");
            coworkingSpaces.remove(choise);

        } catch (InvalidOperationException e) {
        System.err.println("Error: " + e.getMessage());
        removeSpaces();
        } catch (Exception e) {
        System.err.println("Error: " + e.getMessage());

    }

    }
}
