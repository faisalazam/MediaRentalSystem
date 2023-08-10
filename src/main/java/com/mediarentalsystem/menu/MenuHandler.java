package com.mediarentalsystem.menu;

import com.mediarentalsystem.menu.item.MenuItem;
import com.mediarentalsystem.menu.item.main.InvalidMenuItem;
import com.mediarentalsystem.menu.item.main.QuitMenuItem;
import com.mediarentalsystem.utils.InputScanner;

import java.util.Scanner;
import java.util.Stack;

import static com.mediarentalsystem.menu.MenuItemsInitializer.convert;
import static com.mediarentalsystem.menu.MenuItemsInitializer.getMenuItems;
import static com.mediarentalsystem.menu.ParentMenu.MAIN;
import static com.mediarentalsystem.utils.Const.LINE_FEED;

public class MenuHandler {
    // Static variable reference of single_instance of type Singleton
    private static MenuHandler singleInstance = null;
    private static final Stack<ParentMenu> backMenuStack = new Stack<>();

    private MenuItem menuItem;
    private final Scanner scanner;

    // Constructor
    // Here we will be creating private constructor restricted to this class itself
    private MenuHandler() {
        menuItem = null;
        scanner = InputScanner.getInstance();
    }

    // Static method to create instance of Singleton class
    public static synchronized MenuHandler getInstance() {
        if (singleInstance == null) {
            singleInstance = new MenuHandler();
        }
        return singleInstance;
    }

    public void createMainMenu(ParentMenu parentMenu) {
        do {
            if (menuItem == null) {
                backMenuStack.push(MAIN);
                System.out.println(LINE_FEED + "   Welcome to Media Rental System");
            } else {
                System.out.println();
            }
            presentMenu(parentMenu);
            menuItem = readSelectionAndConvert(parentMenu);
            updateBackMenusIfRequired();
            menuItem.getRunnable().run();
        } while (!(menuItem instanceof QuitMenuItem));
    }

    public void goBackToParentMenu() {
        if (backMenuStack.size() == 1) {
            createMainMenu(backMenuStack.peek());
        } else if (!backMenuStack.isEmpty()) {
            createMainMenu(backMenuStack.pop());
        }
    }

    private void presentMenu(ParentMenu parentMenu) {
        getMenuItems(parentMenu).stream()
                .filter(item -> !(item instanceof InvalidMenuItem))
                .map(item -> item.getItemId() + ": " + item.getItemDisplayText())
                .forEach(System.out::println);
        System.out.print(LINE_FEED + "Enter your selection: ");
    }

    private MenuItem readSelectionAndConvert(ParentMenu parentMenu) {
        final String menuOption = scanner.nextLine();
        return convert(parentMenu, menuOption);
    }

    private void updateBackMenusIfRequired() {
        if (menuItem.hasSubMenu() && !menuItem.getParentMenu().equals((backMenuStack.peek()))) {
            backMenuStack.push(menuItem.getParentMenu());
        }
    }
}
