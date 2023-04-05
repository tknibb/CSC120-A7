import java.util.*;


public class House extends Building {

  private ArrayList<String> residents;
  private boolean hasDiningRoom;
  private boolean hasElevator;
  private boolean hasKitchen;

  /* Full constructor */
  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
    super(name, address, nFloors);
    this.residents = new ArrayList<String>();
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;
    this.hasKitchen = false;
  }

  /* Overloaded constructor for a house with no dining room, elevator, nor kitchen */
  public House(String name, String address, int nFloors) {
    super(name, address, nFloors);
    this.residents = new ArrayList<String>();
    this.hasDiningRoom = false;
    this.hasElevator = false;
    this.hasKitchen = false;
  }

  /* Overloaded constructor for a house with no dining room, nor elevator, but has a kitchen */
  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator, boolean hasKitchen) {
    super(name, address, nFloors);
    this.residents = new ArrayList<String>();
    this.hasDiningRoom = false;
    this.hasElevator = false;
    this.hasKitchen = hasKitchen;
  }

  /** Accessor for hasDiningRoom */
  public boolean hasDiningRoom() {
    return this.hasDiningRoom;
  }

  /** Accessor for number of residents */
  public int nResidents() {
    return this.residents.size();
  }

  /** Acessor for hasKitchen */
  public boolean hasKitchen() {
    return this.hasKitchen;
  }

  /** method that checks if this.residents contains name */
  public void moveIn(String name) {
    try {
      if (this.residents.contains(name)) {
        //   if so: throw and exception
        throw new RuntimeException(name + " is already a resident of " + this.name);
      }
      // if we're good to go, add to roster
      this.residents.add(name);
      System.out.println(name + " has just moved into " + this.name + "! Go say hello :-)");
    } 
    catch (RuntimeException e) {
        System.out.println(e);
    }
  }

  /** method that returns the name of the person who moved out */
  public String moveOut(String name) {
    try {
      if (!this.residents.contains(name)) {
        throw new RuntimeException(name + " doesnt live in " + this.name);
      }
      this.residents.remove(name);
      System.out.println(name + " has moved out of " + this.name);
    }
    catch (RuntimeException e) {
      System.out.println(e);
    }
    return name;
  }

  /** method that returns true if person is a resident of the house */
  public boolean isResident(String person) {
    if (this.residents.contains(name)) {
      return true;
    }
    return false;
  }

  public String toString() {
    String description = super.toString();
    description += " There are currently " + this.nResidents() + " people living in this house.";
    description += " This house ";
    if (this.hasDiningRoom) {
      description += "has";
    } else {
      description += "does not have";
    }
    description += " an active dining room.";
    description += " This house ";
    if (this.hasElevator) {
      description += "has";
    } else {
      description += "does not have";
    }
    description += " an elevator.";
    description += " This house ";
    if (this.hasKitchen) {
      description += "has";
    } else {
      description += "does not have";
    }
    description += " an active kitchen.";
    return description;
  }

  /** method that prints all the available method options for the class */
  public void showOptions() {
    System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n) \n + moveIn() \n + moveOut() \n + isResident() \n");
  } 

/** method that lets you go to another floor of the house if an elevator is present */
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
    House wilson = new House("Wilson", "16 Kensington Ave", 4);
    System.out.println(wilson);
    wilson.moveIn("Taylor");
    wilson.moveIn("Kim");
    wilson.moveIn("Julie");
    wilson.moveOut("Kim");
    wilson.enter();
    wilson.goToFloor(3);
    System.out.println(wilson);
    House scales = new House("Scales", "170 Elm Street", 4, true, true);
    System.out.println(scales);
    scales.moveIn("Liz");
    scales.moveOut("Ella");
    System.out.println(scales);
    scales.enter();
    scales.goToFloor(3);

  }
}
