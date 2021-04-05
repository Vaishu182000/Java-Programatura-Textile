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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
public class Textile {
    public String UserNameLogin;
    JFrame f1;
    JPanel p1,p2;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
    JPasswordField pass1,pass2;
    JButton b1,b2;
    JTabbedPane tp;
    JTextField t1,t2,t3,t4,t5,t6,ta;
    Textile(){
        l5=new JLabel("SignUp");
        l5.setBounds(135,10,250,35);
        l6=new JLabel("Login");
        l6.setBounds(135,10,250,35);
        f1=new JFrame("Textile App");
        p1=new JPanel();
        p2=new JPanel();
        tp=new JTabbedPane();
        l1=new JLabel("UserName");
        l1.setBounds(10,60,200,35);
        pass1 = new JPasswordField();
        pass1.setBounds(115,120,200,35);
        l2=new JLabel("PassWord");
        l2.setBounds(10,120,200,35);
        l8=new JLabel("Email");
        l8.setBounds(10,180,200,35);
        l9=new JLabel("Phone Number");
        l9.setBounds(10,240,200,35);
        l11=new JLabel("Address");
        l11.setBounds(10,300,200,40);
        l3=new JLabel("UserName");
        l3.setBounds(10,60,200,35);
        pass2 = new JPasswordField();
        pass2.setBounds(115,120,200,35);
        l4=new JLabel("PassWord");
        l4.setBounds(10,120,200,35);
        t1=new JTextField();
        t1.setBounds(115,60,200,35);
        //t2=new JTextField();
        //t2.setBounds(115,120,200,35);
        t5=new JTextField();
        t5.setBounds(115,180,200,35);
        t6=new JTextField();
        t6.setBounds(115,240,200,35);
        ta=new JTextField();
        ta.setBounds(115,300,200,50);
        t3=new JTextField();
        t3.setBounds(115,60,200,35);
        //t4=new JTextField();
        //t4.setBounds(115,120,200,35);
        b1=new JButton("SignUp");
        b1.setBounds(90,360,150,35);
        l7=new JLabel();
        l7.setBounds(90,410,150,35);
        l10=new JLabel();
        l10.setBounds(90,180,150,35);
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String name=t1.getText();
                String pass=new String(pass1.getPassword());
                String email=t5.getText();
                String phone=t6.getText();
                String add=ta.getText();
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    String connectString="jdbc:mysql://localhost:3306/textile?zeroDateTimeBehavior=convertToNull";
                    Connection conn=DriverManager.getConnection(connectString,"root","");
                    Statement stmt=conn.createStatement();
                    ResultSet rs=stmt.executeQuery("SELECT * FROM signup where UserName='"+name+"'");
                    if(rs.next()){
                        if(rs.getString("UserName").equals(name)){
                            l7.setText("UserName Already Taken");
                            t1.setText("");
                        }
                        else{
                            String q="insert into signup values('"+name+"','"+pass+"','"+email+"','"+phone+"','"+add+"')";
                            stmt.executeUpdate(q);
                            l7.setText("SignUp successful");
                            conn.close();
                            t1.setText("");
                            //t2.setText("");
                            t5.setText("");
                            t6.setText("");
                            ta.setText("");
                        }
                    }
                }
                catch(Exception e1){
                    System.out.println("Error : "+e1.getMessage());
                }
            }
        });
        
        b2=new JButton("Login");
        b2.setBounds(90,180,150,35);
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String name=t3.getText();
                UserNameLogin=name;
                String pass=new String(pass2.getPassword());
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    String connectString="jdbc:mysql://localhost:3306/textile?zeroDateTimeBehavior=convertToNull";
                    Connection conn=DriverManager.getConnection(connectString,"root","");
                    Statement stmt=conn.createStatement();
                    ResultSet rs=stmt.executeQuery("SELECT * FROM signup where UserName='"+name+"'");
                    if(rs.next()){
                        String n=rs.getString("UserName");
                        String p=rs.getString("PassWord");
                        if((n.equals(name))&&(p.equals(pass))){
                            JOptionPane.showMessageDialog(p2,"Login Successful");
                            Tree t=new Tree(UserNameLogin);
                        }
                        else{
                            JOptionPane.showMessageDialog(p2,"Incorrect UserName or PassWord");
                        }
                    }
                    t3.setText("");
                    t4.setText("");
                    ta.setText("");
                }
                catch(Exception e1){
                    System.out.println("Error : "+e1.getMessage());
                }
            }
        });
        p1.add(l5);
        p1.add(l1);
        p1.add(t1);
        p1.add(l2);
        p1.add(pass1);
        p1.add(l8);
        p1.add(l9);
        p1.add(b1);
        p1.add(l7);
        p1.add(t5);
        p1.add(t6);
        p1.add(l11);
        p1.add(ta);
        p2.add(l6);
        p2.add(l3);
        p2.add(t3);
        p2.add(l4);
        p2.add(pass2);
        p2.add(b2);
        p2.add(l10);
        tp.add("Sign Up",p1);  
        tp.add("Login",p2);
        tp.setBounds(0,0,350,600);
        p1.setLayout(null);
        p2.setLayout(null);
        f1.add(tp);  
        f1.setSize(400,700);  
        f1.setLayout(null);  
        f1.setVisible(true);  
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
       new Textile();
    }
    
}
