import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        //DatabaseMethod dm = new DatabaseMethod();

        try {
            Frame f1 = new Frame("client_sign_in");
            JPanel p1 = new JPanel();//主界面（登录）

            /////////////////////////////////////////////////////////
            //搭框架
            DatabaseMethod dm = new DatabaseMethod();
            new Scanner(System.in);
            MyWindowListener mw = new MyWindowListener();
            f1.addWindowListener(mw);
            f1.setSize(800, 1000);
            f1.setLocation(200, 0);
            f1.setVisible(true);

            //////////////////////////////////////////////////////////
            //客户登录界面设置
            f1.add(p1);
            p1.setSize(800, 1000);//大小位置背景
            p1.setLocation(0, 0);
            p1.setVisible(true);
            p1.setBackground(java.awt.Color.white);

            //////////////////////////////////////////
            // 登录部分
            JTextField field1 = new JTextField();
            JLabel l1 = new JLabel("username");
            JTextField field2 = new JTextField();
            JLabel l2 = new JLabel("password");
            JButton b1 = new JButton("sign in");
            p1.add(field1);///////////////////用户名输入
            field1.setLocation(220 , 30);
            field1.setSize(100 , 30);
            p1.add(l1);
            l1.setLocation(350 , 30);
            l1.setSize(80 , 30);
            p1.add(field2);//////////////////密码输入
            field2.setLocation(220 , 100);
            field2.setSize(100 , 30);
            p1.add(l2);
            l2.setLocation(350 , 100);
            l2.setSize(80 , 30);
            p1.add(b1);////////////////////登录按钮
            b1.setLocation(220 , 150);
            b1.setSize(80 , 30);
            b1.addActionListener((e) -> {
                dm.openDB("localhost", field1.getText(), field2.getText());
                f1.setVisible(false);
                functionFrame f2 = new functionFrame(dm);
            });




        } catch (IllegalArgumentException var17) {
            System.err.println(var17.getMessage());
        }
    }
}
