package edu.altierd.Assign01;
// NOTE: CHANGE realemj to YOUR SITNETID!!!
import edu.altierd.Testing.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_A01_LOTRQuiz {

    @Test()
    public void testMain() {

        String [] allInputs = {
                "-1 -1\n",  // Error
                "-1 0\n",   // Error
                "0 -1\n",   // Error
                "0 0\n",    // Gollum
                "0 49\n",   // Gollum
                "49 0\n",   // Gollum
                "0 50\n",   // Gandalf
                "50 0\n",   // Boromir
                "50 50\n",  // Aragorn
                "75 30\n",  // Boromir
                "20 83\n",  // Gandalf
                "64 91\n"   // Aragorn
        };

        GeneralTesting.OutPack [] correctOutputs = {
                // Error cases
                new GeneralTesting.OutPack(
                        "Enter strength and wisdom:\n",
                        "ERROR: Negative entry!\n"),

                new GeneralTesting.OutPack(
                        "Enter strength and wisdom:\n",
                        "ERROR: Negative entry!\n"),

                new GeneralTesting.OutPack(
                        "Enter strength and wisdom:\n",
                        "ERROR: Negative entry!\n"),

                // Regular cases
                new GeneralTesting.OutPack(
                        "Enter strength and wisdom:\n" +
                                "GOLLUM!\n",
                        ""),

                new GeneralTesting.OutPack(
                        "Enter strength and wisdom:\n" +
                                "GOLLUM!\n",
                        ""),

                new GeneralTesting.OutPack(
                        "Enter strength and wisdom:\n" +
                                "GOLLUM!\n",
                        ""),

                new GeneralTesting.OutPack(
                        "Enter strength and wisdom:\n" +
                                "GANDALF!\n",
                        ""),

                new GeneralTesting.OutPack(
                        "Enter strength and wisdom:\n" +
                                "BOROMIR!\n",
                        ""),

                new GeneralTesting.OutPack(
                        "Enter strength and wisdom:\n" +
                                "ARAGORN!\n",
                        ""),

                new GeneralTesting.OutPack(
                        "Enter strength and wisdom:\n" +
                                "BOROMIR!\n",
                        ""),

                new GeneralTesting.OutPack(
                        "Enter strength and wisdom:\n" +
                                "GANDALF!\n",
                        ""),

                new GeneralTesting.OutPack(
                        "Enter strength and wisdom:\n" +
                                "ARAGORN!\n",
                        ""),
        };

        for(int i = 0; i < allInputs.length; i++) {
            // Start redirect
            GeneralTesting.StreamPack.getInstance().start(allInputs[i]);

            // Call main
            LOTRQuiz.main(null);

            // Stop redirect
            GeneralTesting.OutPack programOutput = GeneralTesting.StreamPack.getInstance().stop();

            // Compare to correct result
            Assert.assertEquals(programOutput, correctOutputs[i]);
        }
    }
}
