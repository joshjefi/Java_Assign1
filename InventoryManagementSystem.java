import java.util.*;

// Parent Class: Item
class Item {
    protected String name;
    protected int quantity;
    protected double price;

    public Item(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public void displayDetails() {
        System.out.println("Item: " + name + ", Quantity: " + quantity + ", Price: $" + price);
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}

// Inventory Class
class Inventory {
    private ArrayList<Item> items;

    public Inventory() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
        System.out.println("Item added successfully.");
    }

    public void updateItem(String itemName, int quantity, double price) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                item.setQuantity(quantity);
                item.setPrice(price);
                System.out.println("Item updated successfully.");
                return;
            }
        }
        System.out.println("Item not found.");
    }

    public void displayInventory() {
        if (items.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            System.out.println("Inventory Details:");
            for (Item item : items) {
                item.displayDetails();
            }
        }
    }
}

// Exception Handling Class
class ExceptionHandler {
    public static void handleException(Exception e) {
        System.out.println("Error: " + e.getMessage());
    }
}

// Main Class
public class InventoryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventory inventory = new Inventory();

        while (true) {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add Item");
            System.out.println("2. Update Item");
            System.out.println("3. Display Inventory");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter item name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter quantity: ");
                        int quantity = scanner.nextInt();
                        System.out.print("Enter price: ");
                        double price = scanner.nextDouble();
                        inventory.addItem(new Item(name, quantity, price));
                        break;
                    case 2:
                        System.out.print("Enter item name to update: ");
                        String updateName = scanner.nextLine();
                        System.out.print("Enter new quantity: ");
                        int newQuantity = scanner.nextInt();
                        System.out.print("Enter new price: ");
                        double newPrice = scanner.nextDouble();
                        inventory.updateItem(updateName, newQuantity, newPrice);
                        break;
                    case 3:
                        inventory.displayInventory();
                        break;
                    case 4:
                        System.out.println("Exiting... Goodbye!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } catch (InputMismatchException e) {
                ExceptionHandler.handleException(e);
                scanner.nextLine(); // Clear invalid input
            }
        }
    }
}
