package edu.altierd.Assign03;
import java.util.ArrayList;

public class Forest  {

private ArrayList<Giant> forest = new ArrayList<Giant>(); 

public Giant createGiant(String name, String typeName){

    if(name.isEmpty()){
        return null;}
    
        
    switch(typeName){
        case "GIANT":
        Giant mygiant= new Giant(name);
        return mygiant;
        
        
        case "TROLL":
        Troll mytroll= new Troll(name);
        return mytroll;
      
        
        case "TREE":
        Tree mytree= new Tree(name);
        return mytree;
        
        case "ENT":
        Ent myent= new Ent(name);
        return myent;

        case"HUORN":
        Huorn myhuorn= new Huorn(name);
        return myhuorn;
    
        default:
        return null;
    }
    
    }
   

public boolean addGiant(String name, String typeName){

Giant mygiant=createGiant(name,typeName);

if(mygiant!=null){
    forest.add(mygiant);
    return true;
}
else{
    return false;
}
}    

public Giant getGiant(int index){
    if(index>=0 && index<forest.size()){
    return forest.get(index);
    }
    else{
        return null;
    }
}

public void printAllGiants(){
    System.out.println("ALL GIANTS:");

    for(int x=0; x<forest.size(); x++){
       Giant mygiant=forest.get(x);
        System.out.println("- "+mygiant.toString());
    }

}

public void printAllTrees(){
    System.out.println("ALL TREES:");
    for(int x=0; x<forest.size(); x++){
        if(forest.get(x) instanceof Tree){
        Giant mygiant=forest.get(x);
        Tree mytree=(Tree)(mygiant);
        System.out.println("- "+mytree.toString()+": "+ mytree.speak());}
    
    }
}
public void printAllTrolls(){
    System.out.println("ALL TROLLS:");
    for(int x=0; x<forest.size(); x++){
        if(forest.get(x) instanceof Troll){
            Giant mygiant=forest.get(x);
            Troll mytroll=(Troll)(mygiant);

            System.out.println("- "+mytroll.toString()+": "+mytroll.cook());

        }
    }

}


}
