package AP;

import java.util.Scanner;
import java.util.function.IntFunction;

public class Main {

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void menu(Infrastructure infrastructure) {
        clearScreen();
        String mainTitle="\n*****Welcome to the news app*****\n";
        System.out.println("\n\n"+mainTitle);
        infrastructure.displayNewsList();
        System.out.println("\nPress enter to continue...\n");
        Scanner myObj = new Scanner(System.in);
        myObj.nextLine();
        System.out.println("\n\n\n\n\n");

    }




    public static void main(String[] args) {
        final String api = "6e6beaec95014f8baf91954086c2a212";
        Infrastructure iif = new Infrastructure(api);

        while(true){
            menu(iif);
        }


    }
}