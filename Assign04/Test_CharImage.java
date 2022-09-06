package edu.altierd.Assign04;


import org.testng.Assert;
import org.testng.annotations.Test;

 public class Test_CharImage{
    
    private CharImage x= new CharImage( 5, 4, 'c' );
   
    @Test
    public void test_getters(){
        Assert.assertEquals(x.getRowCnt(), 5);
        Assert.assertEquals(x.getColCnt(), 4);
    }

    @Test
    public void test_isValidPosition(){
        Assert.assertTrue(x.isValidPosition(2,3));
        Assert.assertTrue(x.isValidPosition(4,2));
        Assert.assertFalse(x.isValidPosition(17,2));
        Assert.assertFalse(x.isValidPosition(-2,2));
        Assert.assertFalse(x.isValidPosition(2,-2));
        Assert.assertFalse(x.isValidPosition(2,6));
        Assert.assertFalse(x.isValidPosition(17,18));
        Assert.assertFalse(x.isValidPosition(2,17));
        Assert.assertFalse(x.isValidPosition(-2,-2));
    }

    @Test
    public void test_getPosSet(){
        CharImage y= new CharImage( 5, 4, 'c' );
        Assert.assertEquals(y.getPos(0,2), 'c');
        Assert.assertEquals(y.getPos(0,-1),' ');

        y.setPos(2,3,'!');
        Assert.assertEquals(y.getPos(2,3), '!');
        Assert.assertTrue(y.setPos(2,3, '!') );
        Assert.assertFalse(y.setPos(-2,3, '!') );
           }
        
           
           
    
    

    

    @Test
    public void test_clear(){
        CharImage x= new CharImage( 3, 2, 'c' );
        x.setPos(2,2, '$');
        x.setPos(1,2 ,'x');
        x.setPos(1,1, '#');
        x.clear();
        String t=x.toString();
        String z="";
        for (int i=0; i<3; i++){
            for (int y=0; y<2; y++){
                    z+='c';
            }
        z+="\n";
        }
        Assert.assertEquals(t, z);

    }



        
        @Test
        public void test_toString(){
            CharImage x= new CharImage( 3, 2, 'c' );
            x.setPos(2,1,'#');
            x.setPos(1,2,'#');
            String z= x.toString();
            Assert.assertEquals(x.toString(), z);

              
            }
   

}