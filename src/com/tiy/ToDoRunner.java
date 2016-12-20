package com.tiy;

import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.jar.Pack200;

/**
 * Created by erronius on 12/19/2016.
 */
public class ToDoRunner {

    Scanner scanner;
    //List<ToDoItem> todoList;
    ToDoList todoList;

    public final static String FILE_NAME = "todo.json";

    public static void main(String[] args) {
        new ToDoRunner().startInterface();
    }

    public ToDoRunner () {
        scanner = new Scanner(System.in);
        todoList = new ToDoList();
    }

    public void startInterface() {
        String jsonString = readFromFile(FILE_NAME);
        System.out.println("Welcome to T0-D0.");
        if (jsonString != null) {
            todoList = ToDoList.jsonRestore(jsonString);
            System.out.println(todoList);
        }
        /*for (int index = 0; index < 3; index++) {
            System.out.println("Enter todo item:");
            todoList.add(new ToDoItem(scanner.nextLine()));
        }*/
        mainMenu();
        writeToFile(FILE_NAME, todoList.jsonSave());
    }

    public void mainMenu () {
        System.out.println(todoList);
        System.out.println("Options:");
        System.out.println("1. Add a todo");
        System.out.println("2. Remove or change a todo");
        System.out.println("3. Clear list");
        System.out.println("4. Exit");

        int userChoice = Integer.parseInt(scanner.nextLine());
        switch (userChoice) {
            case 1:
                System.out.println("Todo item to add?");
                todoList.add(new ToDoItem(scanner.nextLine()));
                mainMenu();
                break;
            case 2:
                System.out.println("Index of item to remove/change?");
                int userIndex = Integer.parseInt(scanner.nextLine());
                userIndex--;
                System.out.println("Remove, or change status? (r/c)");
                String actionChoice = scanner.nextLine().toLowerCase();
                if (actionChoice.contains("r")) {
                    todoList.remove(userIndex);
                } else if (actionChoice.contains("c")) {
                    todoList.changeStatus(userIndex);
                } else {
                    System.out.println("You dun messed up good, kid.");
                }
                mainMenu();
                break;
            case 3:
                //clear list
                mainMenu();
                break;
            case 4:
                //exit. Break/exit. Breaxit. Brexit! Gah
                break;
        }
    }

    public void writeToFile (String fileName, String contents) {
        try {
            File file = new File(fileName);
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(contents);
            fileWriter.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String readFromFile (String fileName) {
        try {
            File file = new File(fileName);
            Scanner fileScanner = new Scanner(file);
            if (fileScanner.hasNext()) {
                return fileScanner.nextLine();
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
