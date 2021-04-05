/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textile;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class pant500 extends JFrame{
    String value,materials="500";
    JFrame frame;
    ImageIcon img1,img2;
    JLabel imgl1,amt1,mat1,imgl2,amt2,mat2,size1,size2,s1,s2;
    JButton imgb1,imgb2,whole,end;
    float amount=0;
    pant500(String UserNameLogin){
        value=UserNameLogin;
        value+="\n---------------------------";
        frame=new JFrame("Pant Collection");
        frame.setLayout(null);
        img1=new ImageIcon(getClass().getResource("pant4.jpg"));
        img2=new ImageIcon(getClass().getResource("pant5.jpg"));
        mat1=new JLabel("Material 1");
        mat1.setBounds(300,30,150,35);
        mat2=new JLabel("Material 2");
        mat2.setBounds(300,320,150,35);
        imgl1=new JLabel(img1);
        imgl2=new JLabel(img2);
        imgl1.setBounds(10,10,235,225);
        imgl2.setBounds(10,300,235,225);
        amt1=new JLabel();
        amt1.setBounds(300,60,150,35);
        amt2=new JLabel();
        amt2.setBounds(300,350,150,35);
        size2=new JLabel();
        size2.setBounds(300,380,150,35);
        s2=new JLabel();
        s2.setBounds(300, 410, 150,35);
        size1=new JLabel();
        size1.setBounds(300,90,150,35);
        s1=new JLabel();
        s1.setBounds(300,120,150,35);
        try{
            String m1=mat1.getText();
            String m2=mat2.getText();
            Class.forName("com.mysql.jdbc.Driver");
            String connectString="jdbc:mysql://localhost:3306/textile?zeroDateTimeBehavior=convertToNull";
            Connection conn=DriverManager.getConnection(connectString,"root","");
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT * FROM pant2 where Material='"+m1+"'");
            if (rs.next()){
                String a=rs.getString("Amount");
                String s=rs.getString("Size");
                String st=rs.getString("Stocks");
                String amt="Rs."+a;
                String size="Size : "+s;
                String stock="Stocks Available :"+st;
                amt1.setText(amt);
                size1.setText(size);
                s1.setText(stock);
            }
            rs=stmt.executeQuery("SELECT * FROM pant2 where Material='"+m2+"'");
            if (rs.next()){
                String a=rs.getString("Amount");
                String s=rs.getString("Size");
                String st=rs.getString("Stocks");
                String amt="Rs."+a;
                String size="Size : "+s;
                String stock="Stocks Available :"+st;
                amt2.setText(amt);
                size2.setText(size);
                s2.setText(stock);
            }
        }
        catch(Exception e1){
                    System.out.println("Error : "+e1.getMessage());
        }
        imgb1=new JButton("Order");
        imgb1.setBounds(500,240,150,35);
        imgb1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               try{
                   String l=mat1.getText();
                   materials+=l;
                   System.out.println(l);
                   Class.forName("com.mysql.jdbc.Driver");
                    String connectString="jdbc:mysql://localhost:3306/textile?zeroDateTimeBehavior=convertToNull";
                    Connection conn=DriverManager.getConnection(connectString,"root","");
                    Statement stmt=conn.createStatement();
                    stmt.execute("UPDATE pant2 set Stocks=Stocks-1 where Stocks>=0 AND Material='"+l+"'");
                    ResultSet rs=stmt.executeQuery("SELECT * FROM Pant2 where Material='"+l+"'");
                    if(rs.next()){
                        String stock=rs.getString("Stocks");
                        s1.setText("Stocks Available :"+stock);
                        int amt=rs.getInt("Amount");
                        amount+=amt;
                        System.out.println(amount);
                    }
                    conn.close();
               }
               catch(Exception e1){
                    System.out.println("Error : "+e1.getMessage());
                }
           }
        });
        imgb2=new JButton("Order");
        imgb2.setBounds(500,510,150,35);
        imgb2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               try{
                   String l=mat2.getText();
                   materials+=l;
                   Class.forName("com.mysql.jdbc.Driver");
                    String connectString="jdbc:mysql://localhost:3306/textile?zeroDateTimeBehavior=convertToNull";
                    Connection conn=DriverManager.getConnection(connectString,"root","");
                    Statement stmt=conn.createStatement();
                    stmt.execute("UPDATE Pant2 set Stocks=Stocks-1 where Stocks>=0 AND Material='"+l+"'");
                    ResultSet rs=stmt.executeQuery("SELECT * FROM Pant2 where Material='"+l+"'");
                    if(rs.next()){
                        String stock=rs.getString("Stocks");
                        s2.setText("Stocks Available :"+stock);
                        int amt=rs.getInt("Amount");
                        amount+=amt;
                    }
                    conn.close();
               }
               catch(Exception e1){
                    System.out.println("Error : "+e1.getMessage());
                }
           }
        });
        frame.add(imgl1);
        frame.add(mat1);
        frame.add(amt1);
        frame.add(imgl2);
        frame.add(mat2);
        frame.add(amt2);
        frame.add(size1);
        frame.add(size2);
        frame.add(s1);
        frame.add(s2);
        frame.add(imgb1);
        frame.add(imgb2);
        end=new JButton("Finish");
        frame.add(end);
        end.setBounds(500,600,150,35);
        end.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                value+="\n"+materials+"\n";
                value+=amount;
                JOptionPane.showMessageDialog(frame,value);
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    String connectString="jdbc:mysql://localhost:3306/textile?zeroDateTimeBehavior=convertToNull";
                    Connection conn=DriverManager.getConnection(connectString,"root","");
                    Statement stmt=conn.createStatement();
                    String q="insert into OrderDetails values('"+UserNameLogin+"','"+materials+"','"+amount+"')";
                    stmt.executeUpdate(q);
                    conn.close();
                }
                catch(Exception e1){
                    System.out.println("Error : "+e1.getMessage());
                }
            }
        });
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,700);
        frame.setVisible(true); 
        pack();
    }
}
