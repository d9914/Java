package edu.altierd.Assign01;
// NOTE: CHANGE realemj to YOUR SITNETID!!!
import edu.altierd.Testing.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_A01_DMV {

    @Test()
    public void testMain() {

        String [] allInputs = {
                "Diana Prince\n10 21 1941\n72\n",
                "Bruce Wayne\n3 30 1939\n74\n",
                "  Peter    Parker  06  05   1962     70\n"
        };

        GeneralTesting.OutPack [] correctOutputs = {
                new GeneralTesting.OutPack(
                        "Enter name:\n" +
                                "Enter DOB (month day year):\n" +
                                "Enter height in inches:\n" +
                                "NAME: Prince, Diana\n" +
                                "DOB: 10/21/1941\n" +
                                "HEIGHT: 6'-0\"\n",
                        ""),
                new GeneralTesting.OutPack(
                        "Enter name:\n" +
                                "Enter DOB (month day year):\n" +
                                "Enter height in inches:\n" +
                                "NAME: Wayne, Bruce\n" +
                                "DOB: 03/30/1939\n" +
                                "HEIGHT: 6'-2\"\n", ""),
                new GeneralTesting.OutPack(
                        "Enter name:\n" +
                                "Enter DOB (month day year):\n" +
                                "Enter height in inches:\n" +
                                "NAME: Parker, Peter\n" +
                                "DOB: 06/05/1962\n" +
                                "HEIGHT: 5'-10\"\n", ""),

        };

        for(int i = 0; i < allInputs.length; i++) {
            // Start redirect
            GeneralTesting.StreamPack.getInstance().start(allInputs[i]);

            // Call main
            DMV.main(null);

            // Stop redirect
            GeneralTesting.OutPack programOutput = GeneralTesting.StreamPack.getInstance().stop();

            // Compare to correct result
            Assert.assertEquals(programOutput, correctOutputs[i]);
        }
    }
}
