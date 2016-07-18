package edu.vs.project.parser;

/**
 * Created by varunsh on 7/18/2016.
 */
public class Menu {

    private int ch;

    public Menu () {
        this.ui();
    }

    private void ui() {
        this.userChoice();
    }

    private void userChoice() {
        do {
            this.choiceWindow ();
            this.performAction ();
        } while (this.ch != 0);
    }

    private void performAction() {
        switch (this.ch) {
            case 1:
            {

                break;
            }
        }
    }

    private void choiceWindow() {
        System.out.println("1. Create New Schema");
        System.out.println("2. ");
    }


}
