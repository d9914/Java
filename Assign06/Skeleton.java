package edu.altierd.Assign06;

public class Skeleton extends Creature{

    
    public Skeleton(){
       
    }
public Skeleton(int row, int col){
    super(row,col);
}
public String toString(){
    return "Skeleton at " + getRow() + "," + getCol();
}
public void draw(CharImage map){
    map.setPos(currow,curcol,'S');
}

}