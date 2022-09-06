package edu.altierd.Assign05;
// NOTE: CHANGE realemj to YOUR SITNETID!!!
import edu.altierd.Testing.GeneralTesting;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Test_A05_TreasureHunter {

    private String SITNETID = Test_A05_TreasureHunter.class.getCanonicalName().split("\\.")[1];

    @Test()
    public void testMain() throws IOException {

        GeneralTesting.OutPack correctOut =
                new GeneralTesting.OutPack(
                        "AVAST! TREASURE AT 15,12!\n" +
                                "==============================\n" +
                                "==============================\n" +
                                "==============================\n" +
                                "=====.==.........=============\n" +
                                "=====.==.=======.=============\n" +
                                "=====.==.=======.=============\n" +
                                "=====.==.=======.=============\n" +
                                "=====.==.=======.=============\n" +
                                "=====.==....====.=============\n" +
                                "=====.=====.====.=============\n" +
                                "=====.=====..===.=============\n" +
                                "=====.======.===.=============\n" +
                                "=====.======.===.=============\n" +
                                "=====........===.=============\n" +
                                "================.=============\n" +
                                "============X....=============\n" +
                                "==============================\n" +
                                "==============================\n" +
                                "==============================\n" +
                                "==============================\n" +
                                "\n" +
                                "AVAST! TREASURE AT 7,6!\n" +
                                ".=============================\n" +
                                ".=============================\n" +
                                ".=============================\n" +
                                ".=============================\n" +
                                ".=============================\n" +
                                ".=============================\n" +
                                ".=============================\n" +
                                ".=====X.======================\n" +
                                ".======.======================\n" +
                                ".======.======================\n" +
                                "........======================\n" +
                                "==============================\n" +
                                "==============================\n" +
                                "==============================\n" +
                                "==============================\n" +
                                "==============================\n" +
                                "==============================\n" +
                                "==============================\n" +
                                "==============================\n" +
                                "==============================\n" +
                                "\n",
                        "YE CANNOT READ THIS MAP!\n");

        // Start redirect
        GeneralTesting.StreamPack.getInstance().start("");

        // Call main
        TreasureHunter.main(null);

        // Stop redirect
        GeneralTesting.OutPack programOutput = GeneralTesting.StreamPack.getInstance().stop();

        // Compare to correct result
        Assert.assertEquals(programOutput, correctOut);

        // Load output file
        String actualOutput = "";

        try {
            Scanner actualOutputFile= new Scanner(new File(SITNETID + "_treasure.txt"));
            while(actualOutputFile.hasNextLine()) {
                actualOutput += actualOutputFile.nextLine() + "\n";
            }
            actualOutputFile.close();
        }
        catch(IOException e) {
            throw new IOException("Must write " + SITNETID + "_treasure.txt", e);
        }

        // Check expected output
        Assert.assertEquals(actualOutput,
                "==============================\n" +
                        "==============================\n" +
                        "==============================\n" +
                        "=====.==.........=============\n" +
                        "=====.==.=======.=============\n" +
                        "=====.==.=======.=============\n" +
                        "=====.==.=======.=============\n" +
                        "=====.==.=======.=============\n" +
                        "=====.==....====.=============\n" +
                        "=====.=====.====.=============\n" +
                        "=====.=====..===.=============\n" +
                        "=====.======.===.=============\n" +
                        "=====.======.===.=============\n" +
                        "=====........===.=============\n" +
                        "================.=============\n" +
                        "============X....=============\n" +
                        "==============================\n" +
                        "==============================\n" +
                        "==============================\n" +
                        "==============================\n");
    }
}
