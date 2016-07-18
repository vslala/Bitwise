package edu.vs.project.parser;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by varunsh on 7/14/2016.
 */
public class Main {

    Command cmd;

    public void start(String [] args) {
        boolean flag = false;
        cmd = new Command();

        for (int i=0; i < args.length; i++) {
            if (cmd.isPresent(args[i])) {
                System.out.println (args[i] + " is present in the table");
                if (cmd.isValueTypeValid(args[i], args[i+1])) {
                    System.out.println("Checking for valid value type");
                    if (cmd.checkUserInput()) {
                        System.out.println ("Checking user string");
                        flag = true;
                    }
                }
            }
        }

        if (flag) {
            System.out.println("Command is correct!");

            this.listCommandTable();
        } else {
            System.out.println("Bad User Input");
        }
    }

    private void listCommandTable() {
        Map userTable = cmd.getTempTable();

        Iterator itr = userTable.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry item = (Map.Entry) itr.next();
            System.out.print(item.getKey() + " : " + item.getValue());
            System.out.println();
        }
    }

    public static void main (String [] args) {
        new Main().start(args);
    }
}
