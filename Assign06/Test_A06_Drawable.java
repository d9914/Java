package edu.altierd.Assign06;
//NOTE: CHANGE realemj to YOUR SITNETID!!!
import org.testng.annotations.Test;

public class Test_A06_Drawable {

    private class DrawTest implements Drawable {
        public void draw(CharImage map) {

        }
    }

    @Test()
    public void testDrawable() {
        Drawable drawableThing = new DrawTest();
        drawableThing.draw(new CharImage(1,1,'.'));
    }
}
