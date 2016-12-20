package com.tiy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by erronius on 12/19/2016.
 */
public class ToDoListTest {

    ToDoList todoList;
    @Before
    public void setUp() throws Exception {
        todoList = new ToDoList();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testChangeStatus () {
        todoList.add(new ToDoItem("Vacuum"));
        todoList.add(new ToDoItem("Sweep"));
        todoList.add(new ToDoItem("Rake", true));
        for (int index = 0; index < todoList.size(); index++) {
            todoList.changeStatus(index);
        }
        assertEquals(true, todoList.get(0).isDone());
        assertEquals(true, todoList.get(1).isDone());
        assertEquals(false, todoList.get(2).isDone());
    }
}