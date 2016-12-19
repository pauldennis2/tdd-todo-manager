package com.tiy;

import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by erronius on 12/19/2016.
 */
public class ToDoRunner {

    Scanner scanner;
    List<ToDoItem> todoList;

    public static void main(String[] args) {
        new ToDoRunner().startInterface();
    }

    public ToDoRunner () {
        scanner = new Scanner(System.in);
        todoList = new ArrayList<>();
    }

    public void startInterface() {
        System.out.println("Welcome to T0-D0.");
        printList(todoList);
        for (int i = 0; i < 3; i++) {
            System.out.println("Text of item to add?");
            String text = scanner.nextLine();
            todoList.add(new ToDoItem(text));
        }
        printList(todoList);
        String jsonString = jsonSave(todoList);
        System.out.println(jsonString);
        List<ToDoItem> restoredList = jsonRestore(jsonString);
        printList(restoredList);

    }

    public void printList(List<ToDoItem> list) {
        for (ToDoItem item : list) {
            System.out.println(item);
        }
        if (list.size() == 0) {
            System.out.println("(No items in list)");
        }
    }

    public static String jsonSave(List<ToDoItem> todoList) {
        JsonSerializer jsonSerializer = new JsonSerializer().deep(true);
        String jsonString = jsonSerializer.serialize(todoList);
        System.out.println("jsonString = " + jsonString);
        return jsonString;
    }

    public static List<ToDoItem> jsonRestore(String jsonTD) {
        JsonParser toDoListParser = new JsonParser();
        List<ToDoItem> item = toDoListParser.parse(jsonTD, List.class);

        return item;
    }
}
