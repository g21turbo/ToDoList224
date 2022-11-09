import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class ToDoList {

    private String name;
    ArrayList<ToDoItem> toDoList;

    public ToDoList(String name) {
        this.name = name;
        this.toDoList = new ArrayList<ToDoItem>();
    }

    public boolean addItem(){
        Scanner scanner = new Scanner(System.in);
        ToDoItem toDoItem = new ToDoItem();
        System.out.println("Enter item name:");
        name = scanner.nextLine();
        System.out.println("Enter a description:");
        String description = scanner.nextLine();
        toDoItem.setName(name);
        toDoItem.setDescription(description);
        if (findItem(name) == null) {
            this.toDoList.add(toDoItem);
            return true;
        }
        return false;
    }

    public void editItem(){

    }

    public void deleteItem(){

    }

    public void printList(ToDoList toDoList){
        Iterator<ToDoItem> iterator = toDoList.toDoList.iterator();
        System.out.println("===============================");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("===============================");
    }

    private ToDoItem findItem(String title) {
        for (ToDoItem checkedItem : this.toDoList) {
            if (checkedItem.getName().equals(title)){
                return checkedItem;
            }
        }
        return null;
    }



}