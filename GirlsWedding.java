/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textile;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class GirlsWedding implements ActionListener{
    String User;
    JFrame f;
    JMenu tshirt,Shirt,pant;
    JMenuBar mb;
    JMenuItem t1000,t500,t300,s1000,s500,s300,p1000,p500,p300;
    GirlsWedding(String UserName){
        User=UserName;
        f=new JFrame("Girls Wedding Wear");
        mb=new JMenuBar();
        tshirt=new JMenu("T-Shirts");
        //shirt=new JMenu("Shirts");
        Shirt=new JMenu("Shirts");
        pant=new JMenu("Pants");
        t1000=new JMenuItem("Above 1000");  
        t500=new JMenuItem("Above 500");  
        t300=new JMenuItem("Above 300"); 
        s1000=new JMenuItem("Above 1000");  
        s500=new JMenuItem("Above 500");  
        s300=new JMenuItem("Above 300"); 
        p1000=new JMenuItem("Above 1000");  
        p500=new JMenuItem("Above 500");  
        p300=new JMenuItem("Above 300"); 
        t1000.addActionListener(this);
        t500.addActionListener(this);
        t300.addActionListener(this);
        s1000.addActionListener(this);
        s500.addActionListener(this);
        s300.addActionListener(this);
        p1000.addActionListener(this);
        p500.addActionListener(this);
        p300.addActionListener(this);
        tshirt.add(t1000);tshirt.addSeparator();
        tshirt.add(t500);tshirt.addSeparator();
        tshirt.add(t300);tshirt.addSeparator();  
        //shirt.add(s1000);shirt.addSeparator();
        //shirt.add(s500);shirt.addSeparator();
        //shirt.add(s300);shirt.addSeparator();  
        Shirt.add(s1000);Shirt.addSeparator();
        Shirt.add(s500);Shirt.addSeparator();
        Shirt.add(s300);Shirt.addSeparator();  
        pant.add(p1000);pant.addSeparator();
        pant.add(p500);pant.addSeparator();
        pant.add(p300);pant.addSeparator();  
        //mb.add(tshirt);
        //mb.add(shirt);
        mb.add(pant);
        mb.add(tshirt);
        //mb.add(shirt);
        f.setJMenuBar(mb);  
        f.setSize(400,400);  
        f.setLayout(new FlowLayout());  
        f.setVisible(true);  
    }
     public void actionPerformed(ActionEvent e){
        if(e.getSource()==t1000) {
            tshirt1000 t=new tshirt1000(User);
        }
        if(e.getSource()==t500) {
            tshirt500 t=new tshirt500(User);
        }
        if(e.getSource()==t300) {
            tshirt300 t=new tshirt300(User);
        }
        if(e.getSource()==s1000) {
            
        }
        if(e.getSource()==s500) {
            
        }
        if(e.getSource()==s300) {
            
        }
        if(e.getSource()==p1000) {
            pant1000 p=new pant1000(User);
        }
        if(e.getSource()==p500) {
            pant500 p=new pant500(User);
        }
        if(e.getSource()==p300) {
            pant300 p=new pant300(User);
        }
    }   
    }

