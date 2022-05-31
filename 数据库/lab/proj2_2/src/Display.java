import javax.swing.*;

public class Display {
    String display ;


    public Display(String input){
        JFrame dis = new JFrame("result");
        JPanel p1 = new JPanel();
        p1.setSize(800 , 1000);
        p1.setBackground(java.awt.Color.white);
        dis.setVisible(true);
        dis.setSize(800 , 1000);
        dis.setLocation(1000 , 0);
        p1.setVisible(true);
        this.display = input;
        JLabel disp = new JLabel(display);
        disp.setBounds(50 , 50 , 700 , 800);
        dis.add(disp);
        dis.add(p1);
    } 
}
