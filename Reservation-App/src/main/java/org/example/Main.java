package org.example;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static CoworkingService cowmanager = new CoworkingService();
    public static ReservationService resmanager = new ReservationService();

    public static void main(String[] args) {
        Menu();
    }

    public static void Menu() {
        System.out.println("Welcome Coworking Space Reservation");
        System.out.println("Option");
        System.out.println("1-Admin login:");
        System.out.println("2-Customer login:");
        System.out.println("0-Exit:");
        System.out.print("Choise:");
        int choise = sc.nextInt();

        switch (choise) {
            case 1:
                adminMenu();
                break;
            case 2:
                userMenu();
                break;
            case 0:
                Exit();
                break;
            default:
                System.out.println("Make the right choice");
                Menu();
        }
    }

    public static void adminMenu() {
        System.out.println("Admin menu");
        System.out.println("1-Add a new coworking spaces:");
        System.out.println("2-Remove a coworking spaces:");
        System.out.println("3-View all reservations:");
        System.out.println("0-Exit");
        System.out.print("Choise:");
        int choise = sc.nextInt();

        switch (choise) {
            case 1:
                cowmanager.addCoworkingSpaces();
                break;
            case 2:
                cowmanager.removeSpaces();
                break;
            case 3:
                cowmanager.viewAllSpaces();
                break;
            case 0:
                Menu();
                break;
            default:
                System.out.println("Make the right choice");
                adminMenu();
        }
    }

    public static void userMenu() {
        System.out.println("Admin menu");
        System.out.println("1-Browse available spaces make a reservation:");
        System.out.println("2-View my reservations:");
        System.out.println("3-Cancel a reservation:");
        System.out.println("0-Exit");
        System.out.print("Choise:");
        int choise = sc.nextInt();

        switch (choise) {
            case 1:
                resmanager.makeReservation();
                break;
            case 2:
                resmanager.viewMyReservation();
                break;
            case 3:
                resmanager.cancelReservation();
                break;
            case 0:
                Menu();
                break;
            default:
                System.out.println("Make the right choice");
                userMenu();
        }
    }

    public static void Exit() {
        System.out.println("Logging out!");
        System.exit(0);
        Menu();
    }


}

