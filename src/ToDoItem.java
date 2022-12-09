
public class ToDoItem {

    private String name;
    private String description;

    public ToDoItem(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public static ToDoItem createToDoItem(String itemName, String description){
        return new ToDoItem(itemName, description);
    }

}
