package edu.altierd.Assign03;

public class Tree extends Giant {

public Tree(String name){
    super(name); 
}

public String toString(){
    return super.toString()+" of the trees";
}

public String speak(){
    return "<rustling>";
}
}