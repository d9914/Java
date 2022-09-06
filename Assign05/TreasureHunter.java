package edu.altierd.Assign05;
// NOTE: CHANGE realemj to YOUR SITNETID!!!

public class TreasureHunter {
    public static void main(String [] args) {
        String SITNETID = TreasureHunter.class.getCanonicalName().split("\\.")[1];
        
        TreasureMap myMap = new TreasureMap(20, 30, '=');
        myMap.setCurRow(3);
        myMap.setCurCol(5);

        try {
            myMap.loadInstructions("steps1.txt");
            myMap.loadInstructions("steps2.txt");
            myMap.loadInstructions("steps3.txt");
            System.out.println("AVAST! TREASURE AT "
                    + myMap.getCurRow() + ","
                    + myMap.getCurCol() + "!");
            System.out.println(myMap);            
            myMap.saveMap(SITNETID + "_treasure.txt");

            myMap.clear();
            myMap.loadInstructions("steps1.txt");
            System.out.println("AVAST! TREASURE AT "
                    + myMap.getCurRow() + ","
                    + myMap.getCurCol() + "!");
            System.out.println(myMap);

            myMap.loadInstructions("badsteps.txt");
        }
        catch(TreasureMapException e) {
            System.err.println(e.getMessage());
            // UNCOMMENT FOR DEBUGGING:
            //e.printStackTrace();
        }
    }
}
