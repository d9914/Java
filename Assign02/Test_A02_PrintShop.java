package edu.altierd.Assign02;
// NOTE: CHANGE realemj to YOUR SITNETID!!!

import edu.altierd.Testing.GeneralTesting;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Scanner;

public class Test_A02_PrintShop {

    private String [] allNames = {
            "Empty Industries",
            "WAYNE ENTERPRISES",
            "Luthor Inc.",
            "KENT FARMS",
            "Green Lantern Corp."
    };

    private String [] allSlogans = {
            "",

            "...\n",

            "Power, Trust,\n"
                    + "Control\n",

            "A family owned business\n"
                    + "serving Smallville for over\n"
                    + "37 years\n",

            "Saving the galaxy\n"
                    + "for the low, low price of free.\n"
                    + "You always get\n"
                    + "what you pay for :)\n"
    };

    private char [] allChars = {'.', '*', '$', '#', '@'};

    String [] allCardAnswers = {
            "..........................................\n" +
            ". Empty Industries                       .\n" +
            ".                                        .\n" +
            ".                                        .\n" +
            ".                                        .\n" +
            ".                                        .\n" +
            ".                                        .\n" +
            "..........................................\n",

            "******************************************\n" +
            "* WAYNE ENTERPRISES                      *\n" +
            "*                                        *\n" +
            "* ...                                    *\n" +
            "*                                        *\n" +
            "*                                        *\n" +
            "*                                        *\n" +
            "******************************************\n",

            "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n" +
            "$ Luthor Inc.                            $\n" +
            "$                                        $\n" +
            "$ Power, Trust,                          $\n" +
            "$ Control                                $\n" +
            "$                                        $\n" +
            "$                                        $\n" +
            "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n",

            "##########################################\n" +
            "# KENT FARMS                             #\n" +
            "#                                        #\n" +
            "# A family owned business                #\n" +
            "# serving Smallville for over            #\n" +
            "# 37 years                               #\n" +
            "#                                        #\n" +
            "##########################################\n",

            "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n" +
            "@ Green Lantern Corp.                    @\n" +
            "@                                        @\n" +
            "@ Saving the galaxy                      @\n" +
            "@ for the low, low price of free.        @\n" +
            "@ You always get                         @\n" +
            "@ what you pay for :)                    @\n" +
            "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n"
    };

    private String [] generateInputs() {
        String [] allInputs = new String[allNames.length];
        for(int i = 0; i < allInputs.length; i++) {
            allInputs[i] = allNames[i] + "\n"
                    + allChars[i] + "\n"
                    + allSlogans[i] + "\n\n\n\n";
        }

        return allInputs;
    }

    private String getCommonPromptOutput() {
        String promptOutput = "Enter business name:\n"
                + "Enter boundary character:\n"
                + "Enter slogan (max 4 lines):\n";
        return promptOutput;
    }

    @Test()
    public void test_askForBusinessCardData() {

        String [] allInputs = generateInputs();

        String promptOutput = getCommonPromptOutput();
        GeneralTesting.OutPack correctOutput = new GeneralTesting.OutPack(promptOutput, "");

        for(int i = 0; i < allInputs.length; i++) {

            // Start redirect
            GeneralTesting.StreamPack.getInstance().start(allInputs[i]);

            // Create Scanner
            Scanner input = new Scanner(allInputs[i]);

            // Generate card
            BusinessCard card = PrintShop.askForBusinessCardData(input);

            // Stop redirect
            GeneralTesting.OutPack programOutput = GeneralTesting.StreamPack.getInstance().stop();

            // Compare to correct result
            Assert.assertEquals(programOutput, correctOutput);

            // Compare card content
            Assert.assertEquals(card.toString(), allCardAnswers[i]);
        }

    }

    @Test()
    public void testMain() {

        String [] allInputs = generateInputs();

        String promptOutput = getCommonPromptOutput();
        promptOutput += "Your new business card:\n";

        GeneralTesting.OutPack [] correctOutputs = new GeneralTesting.OutPack[allCardAnswers.length];
        for(int i = 0; i < correctOutputs.length; i++) {
            correctOutputs[i] = new GeneralTesting.OutPack(
                    promptOutput + allCardAnswers[i] + "\n", "");
        }

        for(int i = 0; i < allInputs.length; i++) {

            // Start redirect
            GeneralTesting.StreamPack.getInstance().start(allInputs[i]);

            // Call main
            PrintShop.main(null);

            // Stop redirect
            GeneralTesting.OutPack programOutput = GeneralTesting.StreamPack.getInstance().stop();

            // Compare to correct result
            Assert.assertEquals(programOutput, correctOutputs[i]);

            System.out.println(allInputs[i] + correctOutputs[i].getStdOut());

        }
    }
}
