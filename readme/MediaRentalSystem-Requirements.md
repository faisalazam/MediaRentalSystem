[Go Back](../README.md)

## Media Rental System

Design and implement Java program as follows:

1. Media hierarchy:
    * Create Media, EBook, MovieDVD, and MusicCD classes
    * Add an attribute to Media class to store indication when media object is rented versus available.
    * Add code to constructor and create get and set methods as appropriate.
    * Add any additional constructors and methods needed to support the below functionality
2. Design and implement Manager class which:
    * stores a list of Media objects
    * has functionality to load Media objects from files
    * creates/updates Media files
    * has functionality to add new Media object to its Media list
    * has functionality to find all media objects for a specific title and returns that list
    * has functionality to rent Media based on id (updates rental status on media, updates
      file, returns rental fee)
3. Design and implement MediaRentalSystem which has the following functionality:
    * Command line user interface. Look at the bottom of this project file for sample look and feel.
    * selection to load Media files from a given directory (user supplies directory)
    * selection to find a media object for a specific title value (user supplies title and should
      display to user the media information once it finds it - should find all media with that
      title)
    * selection to rent a media object based on its id value (user supplies id and should
      display rental fee value to the user)
    * selection to exit program
4. Program should throw and catch Java built-in and user-defined exceptions as appropriate
5. Your classes must be coded with correct encapsulation: private/protected attributes, get
   methods, and set methods and value validation
6. There should be appropriate polymorphism: overloading, overriding methods, and dynamic binding
7. Program should take advantage of the inheritance properties as appropriate

## Sample User interface - command driven / Application's Demo/output

[Click here for the application's demo](Application-Demo.md)

[Go Back](../README.md)