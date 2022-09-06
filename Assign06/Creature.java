package edu.altierd.Assign06;
import java.util.Scanner;
public abstract class Creature implements Loadable, Drawable {
    int currow=0;
    int curcol=0;

    protected Creature(){

    }

    protected Creature(int row, int col){
        currow=row;
        curcol=col;
    }


public int getRow(){
    return currow;
}

public int getCol(){
    return curcol;
}
      
public void setRow(int row)
{
    currow=row;
}
public void setCol(int col){
    curcol=col;
}
public void load(Scanner input) throws GameFileException{
    try{
        currow=input.nextInt();
        curcol=input.nextInt();
    }
catch(Exception e){
    currow=0;
    curcol=0;
    throw new GameFileException("Error loading Creature",e);
    
}
}



}
