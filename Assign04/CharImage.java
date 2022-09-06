package edu.altierd.Assign04;

public class CharImage {
    private int rowCnt;
    private int colCnt;
    private char fillChar;
    private char[][] canvas;
 
public CharImage(int rowCnt, int colCnt, char fillChar){
    this.fillChar=fillChar;
    canvas= new char[rowCnt][colCnt];
    this.rowCnt=rowCnt;
    this.colCnt=colCnt;
    
    for (int i=0; i<canvas.length; i++){
            for (int x=0; x<canvas[i].length; x++){
                    canvas [i][x]=fillChar;
            }
        }
    }

 public void clear(){
    for (int i=0; i<canvas.length; i++){
        for (int x=0; x<canvas[i].length; x++){
                canvas [i][x]=fillChar;
        }
    }
        }
        
        
        
        public int getRowCnt(){
            return rowCnt;
        }

        public int getColCnt(){
            return colCnt;
        }
    
    
        public boolean isValidPosition(int row, int col){
            if(row>=0 && row<rowCnt && col>=0 && col<colCnt ){
                return true;}
            else{
                return false; }
        }
    
        public char getPos(int row, int col){
        boolean x=isValidPosition(row, col);
        
        if(x==true){
            return canvas[row][col];
        }
            else {
                return ' ';
            }
        }

        public boolean setPos(int row, int col, char c){
            boolean x=isValidPosition(row, col);
            
            if(x==true){
                canvas[row][col]=c;
                return true;
            }
            else{
                return false;
            }
        
        }

        public String toString(){
            String x="";
            
            for (rowCnt=0; rowCnt<canvas.length; rowCnt++){
                for (colCnt=0; colCnt<canvas[rowCnt].length; colCnt++){
                        x+=canvas[rowCnt][colCnt];
                }
            x+="\n";
            }
            return x;    
        }
    }

















