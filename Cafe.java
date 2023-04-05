public class Cafe extends Building{

    private int nCoffeeOunces;
    private int nSugarPackets;
    private int nCreams;
    private int nCups;
    private boolean hasElevator;

    /** Constructor for the Cafe class */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups, boolean hasElevator) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        this.hasElevator = hasElevator;
    }

    /** Accessor for nCoffeeOunces */
    public int getCoffee() {
        return this.nCoffeeOunces;
    }

    /** Accessor for nSugarPackets */
    public int getSugar() {
        return this.nSugarPackets;
    }

    /** Accessor for nCreams */
    public int getCreams() {
        return this.nCreams;
    }

    /** Accessor for nCups */
    public int getCups() {
        return this.nCups;
    }

    /** Accessor for hasElevator */
    public boolean getElevator() {
        return this.hasElevator;
    }

    /** This checks if there is enough inventory to make a coffee, if there is, a coffee is sold
     * @param1 int size
     * @param2 int nSugarPackets
     * @param3 int nCreams
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        try {
            if (this.nCoffeeOunces <= size -1 | this.nSugarPackets <= nSugarPackets -1 | this.nCreams <= nCreams -1 | this.nCups == 0) {
                throw new RuntimeException("Sorry we don't have enough inventory to sell this coffee. Please try again.");
            }
            this.nCoffeeOunces -= size;
            this.nSugarPackets -= nSugarPackets;
            this.nCreams -= nCreams;
            this.nCups -= 1;
            System.out.println("Thank you for your purchase!");
        } 
        catch(RuntimeException e){
            System.out.println(e);
            this.restock(size, nSugarPackets, nCreams, nCups);
        }
    }

    /** This is an overloaded method for sellCoffee if the person orders an americano (no cream nor sugar) */
    public void sellCoffee(int size) {
        try {
            if (this.nCoffeeOunces <= size -1 | this.nCups ==0) {
                throw new RuntimeException("Sorry we don't have enough inventory to sell this coffee. Please try again.");
            }
            this.nCoffeeOunces -= size;
            this.nCups -= 1;
            System.out.println("Thank you for your purchase!");
        } catch(RuntimeException e) {
            System.out.println(e);
            this.restock(size);
        }
    }

    /** This checks what items are running low and restocks the items to have enough to make the next coffee */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        if (this.nCoffeeOunces < nCoffeeOunces) {
            this.nCoffeeOunces = nCoffeeOunces + 20;
        }
        if (this.nSugarPackets < nSugarPackets) {
            this.nSugarPackets = nSugarPackets + 10;
        }
        if (this.nCreams < nCreams) {
            this.nCreams = nCreams + 10;
        }
        if (this.nCups < nCups) {
            this.nCups = nCups + 10;
        }
    }

    /** This is an overloaded method for restock if the person orders an americano and needs to restock the coffee */
    private void restock(int nCoffeeOunces) {
        this.nCoffeeOunces = nCoffeeOunces + 10;
    }

    /** method that prints all the available method options for the class */
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + sellCoffee() \n + restock() \n");
    }

    /** method that lets you go to another floor of the house if an elevator is present */
    public void goToFloor(int floorNum) {
        try {
            throw new RuntimeException("Sorry, you dont have access to this floor. Employees only.");
        } catch (RuntimeException e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        Cafe my_cafe = new Cafe("Compass Cafe", "Neilson Library", 1, 12, 4, 4, 2, false);
        my_cafe.enter();
        my_cafe.goToFloor(2);
        my_cafe.sellCoffee(22, 12, 12);
        my_cafe.sellCoffee(22, 12, 12);
        my_cafe.sellCoffee(22, 12, 12);
        my_cafe.sellCoffee(12);

    }
    
}
