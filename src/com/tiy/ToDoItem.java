package com.tiy;

/**
 * Created by erronius on 12/19/2016.
 */
public class ToDoItem {

    public static final String CHECK_MARK = "\u2714";

    private String text;
    private boolean done;

    public ToDoItem () {

    }

    public ToDoItem (String text) {
        this.text = text;
        this.done = false;
    }

    public ToDoItem (String text, boolean done) {
        this.text = text;
        this.done = done;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString () {
        if (done) {
            return text + CHECK_MARK;
        } else {
            return text;
        }
    }
}
