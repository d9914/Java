package edu.altierd.Assign05;
import java.util.*;  
import java.io.File;
import java.io.PrintWriter;




public class TreasureMap extends CharImage{
private int currentrow=0;
private int currentcol=0;
    
public TreasureMap(int rowCnt, int colCnt, char fillChar) {
        super(rowCnt, colCnt, fillChar);
        }
        public void clear(){
            currentrow=0;
            currentcol=0;
            super.clear();
        }
        public String toString(){
           String s=super.toString();
            return s;
        }
        public int getCurRow(){
            return currentrow;
        }
        public int getCurCol(){
            return currentcol;
        }
        public void setCurRow(int row){
            currentrow=row; 
        }
        public void setCurCol(int col){
            currentcol=col; 
        }
        public void parseDirection(String dirLine) throws TreasureMapException{
            try{
                Scanner input= new Scanner(dirLine);
                String direction= input.next();
                int offset= input.nextInt();
                input.close();
                setPos(currentrow, currentcol, '.');
                
            switch(direction){
            case "north":
               for(int i=0; i<offset; i++){
                currentrow=currentrow-1; 
                setPos(currentrow, currentcol, '.');
                   } 
                   break;
        
            case "south":
            for(int i=0; i<offset; i++){
                currentrow=currentrow+1; 
                setPos(currentrow, currentcol, '.');
                   } 
                   break;
            
            case "west":
            for(int i=0; i<offset; i++){
                currentcol=currentcol-1; 
                setPos(currentrow, currentcol, '.');
                   } 
                   break;
            
            case "east":
            for(int i=0; i<offset; i++){
                currentcol=currentcol+1; 
                setPos(currentrow, currentcol, '.');
                   } 
                   break;
                
            default: throw new TreasureMapException("BAD COMMAND!");
}     

}

catch (Exception e){
    throw new TreasureMapException("YE CANNOT MOVE SO!", e);

}
}

public void loadInstructions(String filename) throws TreasureMapException{
    File file = new File(filename);
   
    try{
    Scanner scan=new Scanner(file);
        while(scan.hasNextLine()){
            String s= scan.nextLine();
            parseDirection(s);
        }
        scan.close();
        setPos(currentrow,currentcol,'X');
    } 
    catch (Exception e){
        clear();
        throw new TreasureMapException("YE CANNOT READ THIS MAP!", e);
    }
}


public void saveMap(String filename) throws TreasureMapException{
   
    try{
    PrintWriter Writer = new PrintWriter(filename);
    Writer.print(this);
    Writer.close();
}
catch (Exception e){
    throw new TreasureMapException("SUCH TREASURE NEEDS BE SECRET!", e);
}
}

}








