
import java.util.ArrayList;

public class ToDoList {

    private String name;
    ArrayList<ToDoItem> toDoList;

    public ToDoList(String name) {
        this.name = name;
        this.toDoList = new ArrayList<ToDoItem>();
    }

    public boolean addToDoItem(ToDoItem toDoItem) {
        if (findItem(toDoItem.getName()) >= 0) {
            System.out.println("Item is already listed");
            return false;
        }
        return toDoList.add(toDoItem);
    }

    public boolean updateItem(ToDoItem oldItem, ToDoItem newItem) {
        int foundPosition = findItem(oldItem);
        if (foundPosition < 0) {
            System.out.println(oldItem.getName() + ", was not found.");
            return false;
        } else {
            if (findItem(newItem.getName()) != -1) {
                System.out.println("Item with name " + newItem.getName() +
                        " already exist. Update was not successful.");
                return false;
            }
        }
        this.toDoList.set(foundPosition, newItem);
        System.out.println(oldItem.getName() + " was replaced with " + newItem.getName());
        return true;
    }

    public boolean removeItem(ToDoItem item) {
        int foundPosition = findItem(item);
        if (foundPosition < 0) {
            System.out.println(item.getName() + ", was not found.");
            return false;
        }
        this.toDoList.remove(foundPosition);
        System.out.println(item.getName() + ", was not found.");
        return false;
    }

    private int findItem(ToDoItem toDoItem) {
        return this.toDoList.indexOf(toDoItem);
    }

    private int findItem(String itemName) {
        for (int i = 0; i < this.toDoList.size(); i++) {
            ToDoItem toDoItem = this.toDoList.get(i);
            if (toDoItem.getName().equals(itemName)) {
                return i;
            }
        }
        return -1;
    }

    public String queryItem(ToDoItem toDoItem){
        if (findItem(toDoItem) >= 0){
            return toDoItem.getName();
        }
        return null;
    }

    public ToDoItem queryItem(String name) {
        int position = findItem(name);
        if (position >= 0) {
            return this.toDoList.get(position);
        }
        return null;
    }

    public void printItemList() {
        System.out.println("You have " + toDoList.size() + " item/s in your ToDo list");
        for (int i = 0; i < toDoList.size(); i++) {
            System.out.println((i + 1) + ". " +
                    this.toDoList.get(i).getName() + " -> " +
                    this.toDoList.get(i).getDescription());
        }
    }

}