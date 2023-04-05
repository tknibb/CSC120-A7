import java.util.Hashtable;

public class Library extends Building{

  private Hashtable<String, Boolean> collection;
  private boolean hasElevator;

  /** Constructor for Library class */
  public Library(String name, String address, int nFloors, boolean hasElevator) {
    super(name, address, nFloors);
    this.collection = new Hashtable<String, Boolean>();
    this.hasElevator = hasElevator;
  }
  
  /** Accessor for Hashtable */
  public Hashtable <String, Boolean> getCollection() {
    return this.collection;
  }

  /** Accessor for hasElevator */
  public boolean getElevator() {
    return this.hasElevator;
  }

  /** Original method that just adds a title of a book to the collection */
  public void addTitle(String title) {
    try {
      if (this.collection.containsKey(title)) {
        throw new RuntimeException("This book is already in the library.");
      }
      else {
        this.collection.put(title, true);
      }
    }
    catch(RuntimeException e){
      System.out.println(e);
    }
  }

  /** Overloaded method to add a numerical int title of a book to the collection */
  public void addTitle(int num_title) {
    String title = String.valueOf(num_title);
    this.addTitle(title);
  }

  /** method that returns the title that we removed */
  public String removeTitle(String title) {
    try {
      if (!this.collection.containsKey(title)) {
        throw new RuntimeException("This book is not in the library.");
      }
      else {
        this.collection.remove(title);
      }
    }
    catch(RuntimeException e){
      System.out.println(e);
    }
    return title;
  }

  /** Overloaded method that removes a numerical int title that we removed out of the collection */
  public String removeTitle(int num_title) {
    String title = String.valueOf(num_title);
    this.removeTitle(title);
    return title;
  }

  /** method that checks out a title out of the collection */
  public void checkOut(String title) {
    try {
      if (!this.collection.containsKey(title)) {
        throw new RuntimeException(title + " is not in the library.");
      }
      else if (this.collection.get(title).equals(false)) {
        throw new RuntimeException(title + " is currently checked out.");
      }
      else{
        this.collection.replace(title, false);
        System.out.println("Successfully checked out " + title);
      }
    }
    catch(RuntimeException e){
      System.out.println(e);
    }
  }

  /** Overloaded method that checks out a numerical int title out of the collection */
  public void checkOut(int num_title) {
    String title = String.valueOf(num_title);
    this.checkOut(title);
  }

  /** method that returns a book to the collection */
  public void returnBook(String title) {
    try {
      if (!this.collection.containsKey(title)) {
        throw new RuntimeException(title + " is not the library.");
      }
      else if (this.collection.get(title).equals(true)) {
        throw new RuntimeException(title + " has already been returned to library.");
      }
      else {
        this.collection.replace(title, true);
        System.out.println("Successfully returned " + title);
      }
    }
    catch(RuntimeException e){
      System.out.println(e);
    }
  }

  /** Overloaded method that returns a numerical int title to the collection */
  public void returnBook(int num_title) {
    String title = String.valueOf(num_title);
    this.returnBook(title);
  }

  /** method that returns true if the title appears as a key in the library's collection, false otherwise */
  public boolean containsTitle(String title) {
    if (this.collection.containsKey(title)){
      return true;
    }
    return false;
  } 

  /** Overloaded method that returns true if the numerical int title appears as a key in the library's collection, false otherwise */
  public boolean containsTitle(int num_title) {
    String title = String.valueOf(num_title);
    return this.containsTitle(title);
  }

  /** method that returns true if the title is currently available, false otherwise */
  public boolean isAvailable(String title) {
    if (this.collection.get(title).equals(true)) {
      return true;
    }
    return false;
  } 

  /** Overloaded method that returns true if the numerical int title is currently available, false otherwise */
  public boolean isAvailable(int num_title) {
    String title = String.valueOf(num_title);
    return this.isAvailable(title);
  }

  public String toString() {
    String description = super.toString();
    description += " There are currently " + this.collection.size() + " books in this collection.";
    return description;
  } 

  /** method that prints out the entire collection in an easy-to-read way (including checkout status) */
  public void printCollection() {
    System.out.println(this.collection.toString());
  }

  /** method that prints all the available method options for a class */
  public void showOptions() {
    System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + addTitle() \n + removeTitle() \n + checkOut() \n + returnBook()\n + containsTitle()\n + isAvailable \n");
  }

  /** method that allows you to go to another floor if the building has an active elevator */
  public void goToFloor(int floorNum) {
    try {
        if (this.hasElevator == false) {
            throw new RuntimeException("Sorry, there is no elevator, use stairs.");
        }
        super.goToFloor(floorNum);
    } catch (RuntimeException e){
        System.out.println(e);
    }
  }

  public static void main(String[] args) {
    Library neilson  = new Library("Neilson", "Smith College", 4, true);
    neilson.enter();
    neilson.goToFloor(2);
    neilson.addTitle("The Bible");
    System.out.println(neilson);
    neilson.printCollection();
    neilson.checkOut("The Bible");
    neilson.returnBook("The Bible");
    neilson.returnBook("The Cat in the Hat");
    neilson.addTitle("The Cat in the Hat");
    neilson.checkOut("The Cat in the Hat");
    neilson.addTitle(1984);
    neilson.checkOut(1984);
  }
}