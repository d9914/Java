package edu.altierd.Assign05;
// NOTE: CHANGE realemj to YOUR SITNETID!!!
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Scanner;

public class Test_A05_TreasureMap {
    private String SITNETID = Test_A05_TreasureMap.class.getCanonicalName().split("\\.")[1];

    @Test()
    public void test_RowsAndColumns() {
        for(int i = 1; i < 100; i++) {
            for(int j = 1; j < 100; j++) {
                CharImage myMap = new TreasureMap(i, j, '.');
                Assert.assertEquals(myMap.getRowCnt(), i);
                Assert.assertEquals(myMap.getColCnt(), j);
            }
        }
    }

    @Test()
    public void test_isValidPosition() {
        for (int rowCnt = 1; rowCnt < 100; rowCnt++) {
            for (int colCnt = 1; colCnt < 100; colCnt++) {
                CharImage myMap = new TreasureMap(rowCnt, colCnt, '.');
                // Check negative
                Assert.assertFalse(myMap.isValidPosition(-1, -1));
                Assert.assertFalse(myMap.isValidPosition(-1, 0));
                Assert.assertFalse(myMap.isValidPosition(0, -1));

                // Check just outside
                Assert.assertFalse(myMap.isValidPosition(0, colCnt));
                Assert.assertFalse(myMap.isValidPosition(rowCnt, 0));
                Assert.assertFalse(myMap.isValidPosition(rowCnt, colCnt));

                // Check inside
                for(int row = 0; row < rowCnt; row++) {
                    for(int col = 0; col < colCnt; col++) {
                        Assert.assertTrue(myMap.isValidPosition(row, col));
                    }
                }
            }
        }
    }

    @Test()
    public void test_GetAndSetPos() {
        for (int rowCnt = 1; rowCnt < 100; rowCnt++) {
            for (int colCnt = 1; colCnt < 100; colCnt++) {
                char defaultChar = '*';
                CharImage myMap = new TreasureMap(rowCnt, colCnt, defaultChar);
                // Check negative
                Assert.assertEquals(myMap.getPos(-1, -1), ' ');
                Assert.assertEquals(myMap.getPos(-1, 0), ' ');
                Assert.assertEquals(myMap.getPos(0, -1), ' ');

                Assert.assertFalse(myMap.setPos(-1, -1, '!'));
                Assert.assertFalse(myMap.setPos(-1, 0, '!'));
                Assert.assertFalse(myMap.setPos(0, -1, '!'));

                // Check just outside
                Assert.assertEquals(myMap.getPos(0, colCnt), ' ');
                Assert.assertEquals(myMap.getPos(rowCnt, 0), ' ');
                Assert.assertEquals(myMap.getPos(rowCnt, colCnt), ' ');

                Assert.assertFalse(myMap.setPos(0, colCnt, '!'));
                Assert.assertFalse(myMap.setPos(rowCnt, 0, '!'));
                Assert.assertFalse(myMap.setPos(rowCnt, colCnt, '!'));

                // Check inside
                int randTrials = 100;
                for(int i = 0; i < randTrials; i++) {
                    int row = ((int)(Math.random()*rowCnt));
                    int col = ((int)(Math.random()*colCnt));
                    char c = ((char)(Math.random()*127));

                    Assert.assertTrue(myMap.setPos(row, col, c));
                    Assert.assertEquals(myMap.getPos(row, col), c);
                }
            }
        }
    }

    @Test()
    public void test_clearAndCurRowCurCol() {
        TreasureMap m = new TreasureMap(5, 10, 'a');

        m.setPos(0, 1, 'b');
        m.setPos(2, 0, 'c');
        m.setPos(5, 0, 'd');
        m.setPos(4, 8, 'e');

        String s = m.toString();
        String exp =
                "abaaaaaaaa\n" +
                        "aaaaaaaaaa\n" +
                        "caaaaaaaaa\n" +
                        "aaaaaaaaaa\n" +
                        "aaaaaaaaea\n";
        Assert.assertEquals(s, exp);

        Assert.assertEquals(m.getCurRow(), 0);
        Assert.assertEquals(m.getCurCol(), 0);

        m.setCurRow(7);
        m.setCurCol(4);

        Assert.assertEquals(m.getCurRow(), 7);
        Assert.assertEquals(m.getCurCol(), 4);

        m.clear();

        s = m.toString();
        exp =
                "aaaaaaaaaa\n" +
                        "aaaaaaaaaa\n" +
                        "aaaaaaaaaa\n" +
                        "aaaaaaaaaa\n" +
                        "aaaaaaaaaa\n";
        Assert.assertEquals(s, exp);

        Assert.assertEquals(m.getCurRow(), 0);
        Assert.assertEquals(m.getCurCol(), 0);
    }

    @Test()
    public void test_toString() {
        CharImage m = new TreasureMap(5, 10, 'a');

        m.setPos(0, 1, 'b');
        m.setPos(2, 0, 'c');
        m.setPos(5, 0, 'd');
        m.setPos(4, 8, 'e');

        String s = m.toString();
        String exp =
                "abaaaaaaaa\n" +
                        "aaaaaaaaaa\n" +
                        "caaaaaaaaa\n" +
                        "aaaaaaaaaa\n" +
                        "aaaaaaaaea\n";
        Assert.assertEquals(s, exp);
    }

    private void oneTestGoodParseDirection(TreasureMap m,
                                           String dir,
                                           int er, int ec,
                                           String expectedMap) {
        try {
            m.parseDirection(dir);
        }
        catch(Exception e) {
            throw new AssertionError("Should NOT throw exception!", e);
        }

        Assert.assertEquals(m.getCurRow(), er);
        Assert.assertEquals(m.getCurCol(), ec);
        Assert.assertEquals(m.toString(), expectedMap);
    }

    private void oneTestBadParseDirection(TreasureMap m,
                                           String dir,
                                           int er, int ec,
                                           String expectedMap,
                                           boolean isBadCommand) {
        try {
            m.parseDirection(dir);
        }
        catch(TreasureMapException e) {
            //e.printStackTrace();
            Assert.assertEquals(e.getMessage(), "YE CANNOT MOVE SO!");
            Assert.assertNotNull(e.getCause());

            if(isBadCommand) {
                Assert.assertTrue(e.getCause() instanceof TreasureMapException);
                Assert.assertEquals(e.getCause().getMessage(), "BAD COMMAND!");
                Assert.assertNull(e.getCause().getCause());
            }
        }

        Assert.assertEquals(m.getCurRow(), er);
        Assert.assertEquals(m.getCurCol(), ec);
        Assert.assertEquals(m.toString(), expectedMap);
    }

    @Test()
    public void test_parseDirection() {
        TreasureMap m = new TreasureMap(5, 10, '#');

        //////////////////////////////////
        // SINGLE calls to parseDirection
        //////////////////////////////////

        m.clear();
        m.setCurRow(3);
        m.setCurCol(1);
        oneTestGoodParseDirection(m, "north 2", 1, 1,
                "##########\n" +
                           "#.########\n" +
                           "#.########\n" +
                           "#.########\n" +
                           "##########\n");

        m.clear();
        m.setCurRow(3);
        m.setCurCol(1);
        oneTestGoodParseDirection(m, "east 4", 3, 5,
                "##########\n" +
                        "##########\n" +
                        "##########\n" +
                        "#.....####\n" +
                        "##########\n");

        m.clear();
        m.setCurRow(1);
        m.setCurCol(7);
        oneTestGoodParseDirection(m, "west 3", 1, 4,
                "##########\n" +
                        "####....##\n" +
                        "##########\n" +
                        "##########\n" +
                        "##########\n");

        m.clear();
        m.setCurRow(0);
        m.setCurCol(5);
        oneTestGoodParseDirection(m, "south 1", 1, 5,
                "#####.####\n" +
                        "#####.####\n" +
                        "##########\n" +
                        "##########\n" +
                        "##########\n");

        //////////////////////////////////
        // MULTIPLE calls to parseDirection
        //////////////////////////////////

        m.clear();
        m.setCurRow(3);
        m.setCurCol(1);
        oneTestGoodParseDirection(m, "north 3", 0, 1,
                "#.########\n" +
                        "#.########\n" +
                        "#.########\n" +
                        "#.########\n" +
                        "##########\n");

        oneTestGoodParseDirection(m, "east 7", 0, 8,
                "#........#\n" +
                        "#.########\n" +
                        "#.########\n" +
                        "#.########\n" +
                        "##########\n");

        oneTestGoodParseDirection(m, "south 2", 2, 8,
                "#........#\n" +
                        "#.######.#\n" +
                        "#.######.#\n" +
                        "#.########\n" +
                        "##########\n");

        oneTestGoodParseDirection(m, "west 4", 2, 4,
                "#........#\n" +
                        "#.######.#\n" +
                        "#.##.....#\n" +
                        "#.########\n" +
                        "##########\n");

        //////////////////////////////////
        // Check for bad calls to parseDirection
        //////////////////////////////////

        oneTestBadParseDirection(m, "northeast 3", 2, 4,
                "#........#\n" +
                        "#.######.#\n" +
                        "#.##.....#\n" +
                        "#.########\n" +
                        "##########\n",
                        true);

        oneTestBadParseDirection(m, "", 2, 4,
                "#........#\n" +
                        "#.######.#\n" +
                        "#.##.....#\n" +
                        "#.########\n" +
                        "##########\n",
                        false);

        oneTestBadParseDirection(m, "north", 2, 4,
                "#........#\n" +
                        "#.######.#\n" +
                        "#.##.....#\n" +
                        "#.########\n" +
                        "##########\n",
                false);

    }

    private void oneTestGoodLoad(TreasureMap m,
                                 String filename,
                                 int er, int ec,
                                 String expectedMap) {
        try {
            m.loadInstructions(filename);
        }
        catch(Exception e) {
            throw new AssertionError("Should NOT throw exception!", e);
        }

        Assert.assertEquals(m.getCurRow(), er);
        Assert.assertEquals(m.getCurCol(), ec);
        Assert.assertEquals(m.toString(), expectedMap);
    }

    private void oneTestBadLoad(TreasureMap m,
                                String filename,
                                int er, int ec,
                                String expectedMap) {
        try {
            m.loadInstructions(filename);
        }
        catch(TreasureMapException e) {
            //e.printStackTrace();
            Assert.assertEquals(e.getMessage(), "YE CANNOT READ THIS MAP!");
            Assert.assertNotNull(e.getCause());
        }

        Assert.assertEquals(m.getCurRow(), er);
        Assert.assertEquals(m.getCurCol(), ec);
        Assert.assertEquals(m.toString(), expectedMap);
    }

    @Test()
    public void test_loadInstructions() {        
        TreasureMap m = new TreasureMap(15, 20, '#');

        ///////////////////////////////
        // These should load without issue...
        ///////////////////////////////

        m.setCurRow(1);
        m.setCurCol(3);

        oneTestGoodLoad(m, "steps1.txt",8,9,
                "####################\n" +
                        "###.################\n" +
                        "###.################\n" +
                        "###.################\n" +
                        "###.################\n" +
                        "###.################\n" +
                        "###.################\n" +
                        "###.################\n" +
                        "###.#####X.#########\n" +
                        "###.######.#########\n" +
                        "###.######.#########\n" +
                        "###........#########\n" +
                        "####################\n" +
                        "####################\n" +
                        "####################\n");

        oneTestGoodLoad(m, "steps2.txt",3,14,
                "####################\n" +
                        "###.##.........#####\n" +
                        "###.##.#######.#####\n" +
                        "###.##.#######X#####\n" +
                        "###.##.#############\n" +
                        "###.##.#############\n" +
                        "###.##....##########\n" +
                        "###.#####.##########\n" +
                        "###.#####..#########\n" +
                        "###.######.#########\n" +
                        "###.######.#########\n" +
                        "###........#########\n" +
                        "####################\n" +
                        "####################\n" +
                        "####################\n");

        oneTestGoodLoad(m, "steps3.txt",13,10,
                "####################\n" +
                        "###.##.........#####\n" +
                        "###.##.#######.#####\n" +
                        "###.##.#######.#####\n" +
                        "###.##.#######.#####\n" +
                        "###.##.#######.#####\n" +
                        "###.##....####.#####\n" +
                        "###.#####.####.#####\n" +
                        "###.#####..###.#####\n" +
                        "###.######.###.#####\n" +
                        "###.######.###.#####\n" +
                        "###........###.#####\n" +
                        "##############.#####\n" +
                        "##########X....#####\n" +
                        "####################\n");

        ///////////////////////////////
        // Bad filename...
        ///////////////////////////////

        oneTestBadLoad(m, "NOT_HERE.txt",0,0,
                "####################\n" +
                        "####################\n" +
                        "####################\n" +
                        "####################\n" +
                        "####################\n" +
                        "####################\n" +
                        "####################\n" +
                        "####################\n" +
                        "####################\n" +
                        "####################\n" +
                        "####################\n" +
                        "####################\n" +
                        "####################\n" +
                        "####################\n" +
                        "####################\n");

        ///////////////////////////////
        // Corrupt file...
        ///////////////////////////////

        m.setCurRow(3);
        m.setCurCol(5);

        oneTestGoodLoad(m, "steps1.txt",10,11,
                "####################\n" +
                        "####################\n" +
                        "####################\n" +
                        "#####.##############\n" +
                        "#####.##############\n" +
                        "#####.##############\n" +
                        "#####.##############\n" +
                        "#####.##############\n" +
                        "#####.##############\n" +
                        "#####.##############\n" +
                        "#####.#####X.#######\n" +
                        "#####.######.#######\n" +
                        "#####.######.#######\n" +
                        "#####........#######\n" +
                        "####################\n");

        oneTestBadLoad(m, "badsteps.txt",0,0,
                "####################\n" +
                        "####################\n" +
                        "####################\n" +
                        "####################\n" +
                        "####################\n" +
                        "####################\n" +
                        "####################\n" +
                        "####################\n" +
                        "####################\n" +
                        "####################\n" +
                        "####################\n" +
                        "####################\n" +
                        "####################\n" +
                        "####################\n" +
                        "####################\n");
    }

    private void oneTestGoodSave(TreasureMap m,
                                 String filename) {
        try {
            m.saveMap(filename);
        }
        catch(Exception e) {
            throw new AssertionError("Should NOT throw exception!", e);
        }

        // Load file up quick
        try (
                Scanner input = new Scanner(new File(filename));
        ){
            String data = "";
            while(input.hasNextLine()) {
                data += input.nextLine() + "\n";
            }

            Assert.assertEquals(data, m.toString());
        }
        catch(Exception e) {
            throw new AssertionError("Should NOT throw exception!", e);
        }
    }

    private void oneTestBadSave(TreasureMap m,
                                String filename) {
        try {
            m.saveMap(filename);
        }
        catch(TreasureMapException e) {
            //e.printStackTrace();
            Assert.assertEquals(e.getMessage(), "SUCH TREASURE NEEDS BE SECRET!");
            Assert.assertNotNull(e.getCause());
        }
    }

    @Test()
    public void test_saveMap() {
        TreasureMap m = new TreasureMap(15, 20, '#');

        m.setCurRow(1);
        m.setCurCol(3);

        oneTestGoodLoad(m, "steps1.txt", 8, 9,
                "####################\n" +
                        "###.################\n" +
                        "###.################\n" +
                        "###.################\n" +
                        "###.################\n" +
                        "###.################\n" +
                        "###.################\n" +
                        "###.################\n" +
                        "###.#####X.#########\n" +
                        "###.######.#########\n" +
                        "###.######.#########\n" +
                        "###........#########\n" +
                        "####################\n" +
                        "####################\n" +
                        "####################\n");

        oneTestGoodSave(m, SITNETID + "_TestSaveTreasureMap.txt");

        oneTestBadSave(m, "");
    }
}
