
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static ToDoList toDoList = new ToDoList("Chores");

    public static void main(String[] args) {

        boolean quit = false;
        printActions();
        while (!quit) {
            System.out.println("\nEnter action: (6 to show available actions)");
            int action = scanner.nextInt();
            scanner.nextLine();


            switch (action) {
                case 0:
                    quit = true;
                    System.out.println("\nShutting Down...");
                    break;
                case 1:
                    toDoList.printItemList();
                    break;
                case 2:
                    addNewItem();
                    break;
                case 3:
                    updateItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    queryItem();
                    break;
                case 6:
                    printActions();
                    break;
            }
        }

    }

    private static void addNewItem(){
        System.out.println("Enter new ToDo item: ");
        String name = scanner.nextLine();
        System.out.println("Enter item description: ");
        String description = scanner.nextLine();
        ToDoItem toDoItem = ToDoItem.createToDoItem(name, description);
        if (toDoList.addToDoItem(toDoItem)) {
            System.out.println("New item added: item = " + name + ", description = " + description);
        } else {
            System.out.println("Cannot add " + name + " already on file");
        }
    }

    private static void updateItem() {
        System.out.println("Enter existing item: ");
        String name = scanner.nextLine();
        ToDoItem existingToDoItem = toDoList.queryItem(name);
        if (existingToDoItem == null){
            System.out.println("Item not found.");
            return;
        }
        System.out.println("Enter new ToDo item: ");
        String newItem = scanner.nextLine();
        System.out.println("Enter item description: ");
        String description = scanner.nextLine();
        ToDoItem newContact = ToDoItem.createToDoItem(newItem, description);
        if (toDoList.updateItem(existingToDoItem, newContact)) {
            System.out.println("Successfully updated record.");
        } else {
            System.out.println("Error updating record.");
        }
    }

    private static void removeItem() {
        System.out.println("Enter existing item: ");
        String name = scanner.nextLine();
        ToDoItem existingContactRecord = toDoList.queryItem(name);
        if (existingContactRecord == null) {
            System.out.println("Item not found.");
            return;
        }
        if (toDoList.removeItem(existingContactRecord)){
            System.out.println("Successfully deleted");
        } else {
            System.out.println("Error deleting item");
        }
    }

    private static void queryItem() {
        System.out.println("Enter existing item: ");
        String name = scanner.nextLine();
        ToDoItem existingToDoItem = toDoList.queryItem(name);
        if (existingToDoItem == null) {
            System.out.println("Item not found.");
            return;
        }
        System.out.println("Item: " + existingToDoItem.getName() + " description: " + existingToDoItem.getDescription());
    }

    public static void printActions () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Available actions \n press");
        System.out.println("0 - to quit\n" +
                " 1 - To print ToDo list \n" +
                " 2 - To to add a new ToDo item \n" +
                " 3 - To update an existing item \n" +
                " 4 - To remove an existing item \n" +
                " 5 - To query ToDo list \n" +
                " 6 - To print a list of available actions \n");


    }
}
