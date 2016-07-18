package test.edu.vs.project.parser;

import edu.vs.project.parser.Command;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by varunsh on 7/14/2016.
 */
public class TCommand {


    public Command cmd;

    @Test
    public void itShouldReturnFalseIfTheCommandIsNotPresentInTheTable () {
        cmd = new Command();
        String cmdStr = "-k";
        Assert.assertFalse (cmd.isPresent(cmdStr));
    }

    @Test
    public void itShouldReturnTrueIfCommandIsPresentInTheTable () {
        cmd = new Command();
        String cmdStr = "-l";

        Assert.assertTrue(cmd.isPresent(cmdStr));
    }

    @Test
    public void itShouldCheckIfTheTypeOfValueAssociatedWithTheCommandIsValid () {
        cmd = new Command ();
        String value = "";

        Assert.assertTrue(cmd.isValueTypeValid("-l", "true"));
    }

    @Test
    public void isValueTypeFunctionReturningTheExpectedResult () {
        cmd = new Command ();

        Assert.assertEquals("String", cmd.getValueInstance("abc/asd"));

    }

    @Test
    public void itShouldCheckTheCorrespondingValueWithTheCommand () {
        cmd = new Command ();

    }
}
