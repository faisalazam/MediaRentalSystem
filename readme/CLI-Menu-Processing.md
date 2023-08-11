[Go Back](../README.md)

## Command Line Interface (CLI) - Menu Processing

It is a menu based application, which means:

* The [menu package][menu-package] contains most of the CLI code (i.e. the code for the menu items along with their
  runners/handlers)
* User will be prompted to enter his/her selection from the presented menu
    * The [item package][item-package] contains all the menu items which will be presented on the command line
* Once the user has entered his/her selection, then that menu selection should be processed/handled by the application
    * and the [runner package][runner-package] contains all the runners/handlers for all the menu items presented on the
      command line
    * once the selection has been made, one of the runners in this package will process/handle that

## How to add a new menu item?

* Adding a new menu item could be as easy as adding a new class in this package.
  See [LoadMediaObjectsMenuItem.java][LoadMediaObjectsMenuItem-java] as an example below:

  ```java
  package com.mediarentalsystem.menu.item.main;
  
  import com.mediarentalsystem.menu.item.AbstractMenuItem;
  import com.mediarentalsystem.menu.runner.main.LoadMediaObjectsRunner;
  
  import static com.mediarentalsystem.menu.ParentMenu.MAIN;
  
  class LoadMediaObjectsMenuItem extends AbstractMenuItem {
      private LoadMediaObjectsMenuItem() {
          super(false,
                  MAIN,
                  "1",
                  "Load Media objects...",
                  new LoadMediaObjectsRunner()
          );
      }
  }
  ```
* That's right, the constructor is private and the framework ([MenuItemsInitializer.java][MenuItemsInitializer-java])
  will take care of the initialization of all the menu items
* It has to extend from the [AbstractMenuItem.java][AbstractMenuItem-java] abstract class

#### What's required to add a new menu item?

* When adding a new menu item, we'll need to tell:
    * if it has sub-menu items
    * what will be the parent menu for this menu item
    * it's id
    * it's display text
    * it's runner/handler

## How to add a new runner/handler to handle the menu item?

* Adding a new runner/handler to handle menu item could be as easy as adding a new class in this package.
  See [LoadMediaObjectsRunner.java][LoadMediaObjectsRunner-java] as an example below:

    ```java
    package com.mediarentalsystem.menu.runner.main;
    
    import com.mediarentalsystem.menu.runner.MenuOptionRunnable;
    
    import static com.mediarentalsystem.utils.Const.LINE_FEED;
    
    public class LoadMediaObjectsRunner implements MenuOptionRunnable {
        @Override
        public void run() {
            System.out.print(LINE_FEED + "Enter path (directory) where to load from: ");
            final String pathToLoadFrom = inputScanner.nextLine();
            final boolean isMediaLoaded = mediaService.loadMedia(pathToLoadFrom);
            if (isMediaLoaded) {
                System.out.println();
            } else {
                System.out.println("File cannot be opened: Could not load, no such directory" + LINE_FEED);
            }
        }
    }
    ```

#### What's required to add a runner/handler to handle menu item?

* It has to implement [MenuOptionRunnable.java][MenuOptionRunnable-java] interface

## [MenuItemsInitializer.java][MenuItemsInitializer-java]

We saw private constructor in [LoadMediaObjectsMenuItem.java][LoadMediaObjectsMenuItem-java] and all menu items are
actually having private constructors. The static block of code in [MenuItemsInitializer.java][MenuItemsInitializer-java]
is the one take care of the initialisation of all the menu items through reflection:

```
private static final Map<ParentMenu, Map<String, MenuItem>> ID_TO_ITEM_MAP = new HashMap<>();

static {
    // caching to avoid calculating again and again
    LOGGER.info("Initializing menu items...");

    final Reflections reflections = new Reflections(MAIN_PACKAGE);
    final Set<Class<? extends AbstractMenuItem>> menuItemsSubTypes = reflections.getSubTypesOf(AbstractMenuItem.class);
    for (Class<? extends AbstractMenuItem> menuItemClass : menuItemsSubTypes) {
        try {
            final Constructor<? extends AbstractMenuItem> classDeclaredConstructor = menuItemClass.getDeclaredConstructor();
            classDeclaredConstructor.setAccessible(true);
            final AbstractMenuItem menuItem = classDeclaredConstructor.newInstance();
            final ParentMenu parentMenu = menuItem.getParentMenu();
            ID_TO_ITEM_MAP.putIfAbsent(parentMenu, new HashMap<>());
            ID_TO_ITEM_MAP.get(parentMenu).put(menuItem.getItemId(), menuItem);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
```

That code above, is using reflection to load all available menu items into system.
And that's how simply creating a new menu item extended it from [AbstractMenuItem.java][AbstractMenuItem-java]
will start working automagically.

[Go Back](../README.md)


<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->

[menu-package]:../src/main/java/com/mediarentalsystem/menu

[item-package]:../src/main/java/com/mediarentalsystem/menu/item

[runner-package]:../src/main/java/com/mediarentalsystem/menu/runner

[AbstractMenuItem-java]:../src/main/java/com/mediarentalsystem/menu/item/AbstractMenuItem.java

[MenuItemsInitializer-java]:../src/main/java/com/mediarentalsystem/menu/MenuItemsInitializer.java

[MenuOptionRunnable-java]:../src/main/java/com/mediarentalsystem/menu/runner/MenuOptionRunnable.java

[LoadMediaObjectsRunner-java]:../src/main/java/com/mediarentalsystem/menu/runner/main/LoadMediaObjectsRunner.java

[LoadMediaObjectsMenuItem-java]:../src/main/java/com/mediarentalsystem/menu/item/main/LoadMediaObjectsMenuItem.java
