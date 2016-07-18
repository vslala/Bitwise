package edu.vs.project.parser;

import java.util.*;

/**
 * Created by varunsh on 7/14/2016.
 */
public class Command {

    private static ArrayList<String> commandsList;
    private static ArrayList<String> defaultCommandValues;
    private static final String [] commands = {"l", "d", "p"};
    private static final String [] defaultValues = {"Boolean", "String", "Integer"};
    private Map commandTable = new HashMap();
    public Map tempTable = new HashMap ();
    private String symbol, inputType;

    public Command () {
//        this.createNewSchema ();
        commandTable.put (this.commands[0], defaultValues[0]);
        commandTable.put (this.commands[1], defaultValues[1]);
        commandTable.put (this.commands[2], defaultValues[2]);
    }

    private void createNewSchema() {
        userInputForSchema();
        commandsList.add(this.symbol);  // append the new symbol to the existing list
        defaultCommandValues.add(this.inputType);   // appends the new value to the corresponding symbol
    }

    private void userInputForSchema() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the Symbol");
        this.symbol = in.nextLine();
        System.out.println ("Enter the Input Type as String");
        this.inputType = in.nextLine();
    }


    public boolean isPresent(String cmdStr) {
        if (Arrays.asList(commands).contains(this.parseString(cmdStr))) {
            return true;
        }
        return false;
    }

    // parse the string and remove the '-' from the beginning
    private String parseString (String cmdStr) {
        if (cmdStr.charAt(0) == '-') {
            cmdStr = cmdStr.substring(1, cmdStr.length()) ;
            return cmdStr;
        }
        return "";
    }


    public boolean isValueTypeValid (String cmdStr, String value) {
        if (isPresent(cmdStr)) {
            if (isPresent(value)) {     // if the argument is not present get the default value in place
                this.tempTable.put(this.parseString(cmdStr), getDefaultValue(this.parseString(cmdStr)));
                return true;
            }

            this.tempTable.put(cmdStr, getValueInstance(value));
            return true;
        }

        return false;
    }

    public String getDefaultValue (String cmdStr) {
        return this.commandTable.get(cmdStr).toString();
    }

    public String getValueInstance (String value) {
        if (Validation.isInteger(value.toString())) {
            return "Integer";
        } else if (Validation.isBoolean(value.toString())) {
            return "Boolean";
        } else {
            // throw exception
            return "String";
        }
    }

    public boolean checkUserInput () {
        int i = 0;
        boolean flag = false;
        Iterator itr = this.tempTable.entrySet().iterator();

        while (itr.hasNext()) {
            Map.Entry item = (Map.Entry)  itr.next();
            if (item.getKey().toString().equals(this.commands[i])) {
                if (item.getValue().toString().equals(this.defaultValues[i])) {
                    flag = true;
                } else {
                    flag = false;
                }
            }
        }

        return flag;
    }

    public Map getTempTable () { return this.tempTable; }




}
