package com.tiy;

import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by erronius on 12/19/2016.
 */
public class ToDoList implements Serializable {

    List<ToDoItem> todoList;

    public ToDoList () {
        todoList = new ArrayList<>();
    }

    public List<ToDoItem> getTodoList() {
        return todoList;
    }

    public void setTodoList(List<ToDoItem> todoList) {
        this.todoList = todoList;
    }

    /**
     * Flips the status of the item at the given index.
     * @param itemIndex - index of the item in the list
     * @return true if successfully found, false if IndexOutOfBoundsException was thrown
     */
    public boolean changeStatus (int itemIndex) {
        try {
            ToDoItem item = todoList.get(itemIndex);
            item.setDone(!item.isDone());
            return true;
        } catch (IndexOutOfBoundsException ex) {
            return false;
        }
    }

    @Override
    public String toString () {

        if (todoList.size() == 0) {
            return "(No items in list)";
        }
        String response = "";
        int index = 1;
        for (ToDoItem item : todoList) {
            response += index + ". " + item.toString() + "\n";

            index++;
        }


        return response;
    }

    public void add (ToDoItem item) {
        todoList.add(item);
    }

    public ToDoItem get (int index) {
        return todoList.get(index);
    }

    public String jsonSave() {
        JsonSerializer jsonSerializer = new JsonSerializer().deep(true);
        return jsonSerializer.serialize(this);
    }

    public static ToDoList jsonRestore(String jsonTD) {
        JsonParser toDoListParser = new JsonParser();
        return toDoListParser.parse(jsonTD, ToDoList.class);
    }

    public int size () {
        return todoList.size();
    }

    public void remove (int index) {
        todoList.remove(index);
    }
}
