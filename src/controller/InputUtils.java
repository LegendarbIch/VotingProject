package controller;

import java.util.Scanner;

public class InputUtils {
    private static final Scanner scanner = new Scanner(System.in);
    public static String write() {
        return scanner.nextLine();
    }
}
