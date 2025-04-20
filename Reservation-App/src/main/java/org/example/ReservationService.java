package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class ReservationService {
    public static Scanner in = new Scanner(System.in);

    public static ArrayList<Reservation> reservations = new ArrayList<>();


    public void makeReservation() {

        try {
            System.out.print("Make a Reservation id:");
            int rsvId = in.nextInt();
            in.nextLine();

            for (Reservation it : reservations) {
                if (it.getReservId() == rsvId) {
                    throw new InvalidOperationException("This ID has been used!");
                }
            }

            System.out.print("Enter name:");
            String name = in.nextLine();
            if (name.isEmpty()) {
                throw new InvalidOperationException("You have not entered a name!");
            }
            System.out.print("Enter reservation date:");
            String date = in.nextLine();
            if (date.isEmpty()) {
                throw new InvalidOperationException("You have not entered the date!");
            }
            System.out.print("Enter start time:");
            String start = in.nextLine();
            System.out.print("Enter end time:");
            String end = in.nextLine();

            Reservation addReservation = new Reservation(rsvId, name, date, start, end);
            reservations.add(addReservation);

        } catch (InvalidOperationException e) {
            System.err.println("Error: " + e.getMessage());
            makeReservation();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        System.out.println();
        System.out.println("New add reservation space? (add/back)!\n");
        System.out.print("Enter your choice: ");
        String newAdd = in.next();

        if (newAdd.equalsIgnoreCase("Add")) {
            makeReservation();
        } else {
            Main.userMenu();
        }


    }

    public void viewMyReservation() {
        for (Reservation it : reservations) {
            System.out.println("Id:" + it.getReservId() + " " + "Name:" + it.getName() + " " + "Date:" + it.getDate() + " " + "Start Time:" + it.getStartTime() + " " + "IsAvailable:" + it.getEndTime());
        }

        if (CoworkingService.coworkingSpaces.isEmpty()) {
            System.out.println("No reservations!\n");
            Main.adminMenu();
            return;
        }

        System.out.print("If you want to go back -> 'back': ");
        String goBack = in.next();
        if (goBack.equalsIgnoreCase("back")) {
            Main.userMenu();
        } else {
            Main.Menu();
        }

    }

    public void cancelReservation() {
        for (Reservation it : reservations) {
            System.out.println("Id:" + it.getReservId() + " " + "Name:" + it.getName() + " " + "Date:" + it.getDate() + " " + "Start Time:" + it.getStartTime() + " " + "IsAvailable:" + it.getEndTime());
        }

        getElementById();

        for (Reservation it : reservations) {
            System.out.println("Id:" + it.getReservId() + " " + "Name:" + it.getName() + " " + "Date:" + it.getDate() + " " + "Start Time:" + it.getStartTime() + " " + "IsAvailable:" + it.getEndTime());
        }
        System.out.println();
        System.out.println("Do you want to cancel it again? (Yes/No)\n");
        System.out.print("Enter your choice: ");
        String newAdd = in.next();

        if (newAdd.equalsIgnoreCase("Yes")) {
            cancelReservation();
        } else {
            Main.userMenu();
        }

    }

    public void getElementById() {
        System.out.print("Enter the reservation ID you want to cancel:");
        int choise = in.nextInt();

        try {
            for (int i = 0; i < reservations.size(); i++) {
                if (reservations.get(i).getReservId()== choise)
                    reservations.remove(i);
            }

            if (choise < 0 || choise >= reservations.size()) {
                throw new InvalidOperationException("Invalid index!");
            }
            System.out.println("Coworking space removed successfully!\n");
            reservations.remove(choise);

        } catch (InvalidOperationException e) {
            System.err.println("Error: " + e.getMessage());
            cancelReservation();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());

        }

    }
}