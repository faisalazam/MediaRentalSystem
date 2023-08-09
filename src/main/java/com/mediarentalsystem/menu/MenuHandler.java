package com.mediarentalsystem.menu;

import com.mediarentalsystem.utils.InputScanner;

import java.util.Arrays;
import java.util.Scanner;

import static com.mediarentalsystem.menu.MenuItem.INVALID_ITEM;
import static com.mediarentalsystem.menu.MenuItem.QUIT;
import static com.mediarentalsystem.menu.MenuItem.convert;
import static com.mediarentalsystem.menu.MenuItem.values;
import static com.mediarentalsystem.utils.Const.LINE_FEED;

public class MenuHandler {
    public void createMainMenu() {
        final Scanner scanner = InputScanner.getInstance();

        MenuItem menuItem;
        do {
            System.out.println(LINE_FEED + "   Welcome to Media Rental System");
            Arrays.stream(values())
                    .filter(item -> !INVALID_ITEM.equals(item))
                    .map(item -> item.getItemId() + ": " + item.getItemDisplayText())
                    .forEach(System.out::println);
            System.out.print(LINE_FEED + "Enter your selection: ");

            final String menuOption = scanner.nextLine();
            menuItem = convert(menuOption);
            menuItem.getRunnable().run();
        } while (menuItem != QUIT);
    }
}
