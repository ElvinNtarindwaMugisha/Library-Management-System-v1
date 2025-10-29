package view;

import javax.swing.*;

public class TestSwing {
    public static void main (String[]args){
        JFrame bottle = new JFrame();
        bottle.setTitle("Inyange Bottle Water");
        bottle.setSize(400,500);

        //create a component
        JButton coverbtn = new JButton();
        coverbtn.setText("cover");
        bottle.add(coverbtn);

        bottle.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bottle.setVisible(true);
    }
}
