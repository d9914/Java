package edu.altierd.Assign02;



public class BusinessCard {
    private String name;
    private String [] sloganLines;
    private char boundaryChar;
    
    public BusinessCard(String name, String [] sloganLines, char boundaryChar){
        this.name=name;
        this.sloganLines=sloganLines;
        this.boundaryChar=boundaryChar;
    }


public String getName(){
    return name;
}
public char getBoundaryChar(){
return boundaryChar;
}

public String getSlogan(){
    String s="";
    int y=sloganLines.length;
    for(int i=0;i<y;++i){
    s+=sloganLines[i] +"\n";
      
}
    return s;
}

public void setName(String name){
    this.name=name;  
}


    public void setBoundaryChar(char boundaryChar){
        this.boundaryChar=boundaryChar;  
    }


    public void setSlogan(String [] sloganLines){
        this.sloganLines=sloganLines;    
    }

    
    
    public String toString(){
     String fc="";
     for(int i=0;i<42;++i){
         fc+=getBoundaryChar();
     }
     fc+="\n"+getBoundaryChar()+" ";
     fc+=getName();
     String t=getName();
     int x= t.length();
     x=39-x;
     
     for(int i=0;i<x;++i){
         fc+=" ";
     }
     fc+=getBoundaryChar()+"\n"+getBoundaryChar();
     
     for(int i=0;i<40;++i){
        fc+=" ";
    }
    fc+=getBoundaryChar()+"\n"+getBoundaryChar()+" ";
    
    
    int y=sloganLines.length;
    for(int i=0; i<y;i++){
        fc+= sloganLines[i];
    x= 39-sloganLines[i].length();
        for(int z=0; z<x; z++){
            fc+=" ";
        }
    fc+=getBoundaryChar()+"\n"+getBoundaryChar();
    if(i<(y-1)){
        fc+=" ";
    }    
    }


for(int i=0;i<41;++i){
         fc+=getBoundaryChar();
     }

    return fc;
    } 

}

