package edu.altierd.Assign02;
// NOTE: CHANGE realemj to YOUR SITNETID!!!
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_A02_BusinessCard {

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

    private String [] allCardAnswers = {
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

    public BusinessCard [] createSampleCards() {
        BusinessCard [] cards = new BusinessCard[allNames.length];
        cards[0] = new BusinessCard(allNames[0], new String[]{}, allChars[0]);
        for(int i = 1; i < allNames.length; i++) {
            cards[i] = new BusinessCard(allNames[i], allSlogans[i].split("\n"), allChars[i]);
        }
        return cards;
    }

    @Test()
    public void test_getName() {
        BusinessCard [] cards = createSampleCards();
        for(int i = 0; i < cards.length; i++) {
            Assert.assertEquals(cards[i].getName(), allNames[i] + "");
        }
    }

    @Test()
    public void test_getSlogan() {
        BusinessCard [] cards = createSampleCards();
        for(int i = 0; i < cards.length; i++) {
            Assert.assertEquals(cards[i].getSlogan(), allSlogans[i] + "");
        }
    }

    @Test()
    public void test_getBoundaryChar() {
        BusinessCard [] cards = createSampleCards();
        for(int i = 0; i < cards.length; i++) {
            Assert.assertEquals(cards[i].getBoundaryChar(), allChars[i]);
        }
    }

    @Test()
    public void test_setName() {
        BusinessCard [] cards = createSampleCards();
        String newName = "Harold Industries";
        cards[0].setName(newName);
        Assert.assertEquals(cards[0].getName(), newName + "");
    }

    @Test()
    public void test_setSlogan() {
        BusinessCard [] cards = createSampleCards();
        String newSlogan = "Do you know\nthe Muffin Man????\n";
        cards[0].setSlogan(newSlogan.split("\n"));
        Assert.assertEquals(cards[0].getSlogan(), newSlogan);
    }

    @Test()
    public void test_setBoundaryChar() {
        BusinessCard [] cards = createSampleCards();
        char newChar = '&';
        cards[0].setBoundaryChar(newChar);
        Assert.assertEquals(cards[0].getBoundaryChar(), newChar);
    }

    @Test()
    public void test_toString() {
        BusinessCard [] cards = createSampleCards();

        // Testing based strictly on constructor
        for(int i = 0; i < cards.length; i++) {
            Assert.assertEquals(cards[i].toString(), allCardAnswers[i]);
        }

        // Change one of them and try again
        String newName = "Harold Industries";
        cards[0].setName(newName);
        String newSlogan = "Do you know\nthe Muffin Man????\n";
        cards[0].setSlogan(newSlogan.split("\n"));
        char newChar = '&';
        cards[0].setBoundaryChar(newChar);

        Assert.assertEquals(cards[0].toString(),
                "&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&\n" +
                        "& Harold Industries                      &\n" +
                        "&                                        &\n" +
                        "& Do you know                            &\n" +
                        "& the Muffin Man????                     &\n" +
                        "&                                        &\n" +
                        "&                                        &\n" +
                        "&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&\n");
    }
}
