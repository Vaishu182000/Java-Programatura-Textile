/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textile;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;  
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;  
import javax.swing.tree.TreePath;
public class Tree {
    JFrame f;
    JPanel p;
    JTree jt;
    Tree(String UserNameLogin){
        f=new JFrame("Categories");   
        p=new JPanel();
        DefaultMutableTreeNode Cat=new DefaultMutableTreeNode("CATEGORIES");  
        DefaultMutableTreeNode kid=new DefaultMutableTreeNode("Kids");  
        DefaultMutableTreeNode men=new DefaultMutableTreeNode("Mens");   
        DefaultMutableTreeNode women=new DefaultMutableTreeNode("Womens");  
        Cat.add(kid);
        Cat.add(men);  
        Cat.add(women);   
        
        DefaultMutableTreeNode boys =new DefaultMutableTreeNode("BOYS COLLECTION");  
        DefaultMutableTreeNode girls=new DefaultMutableTreeNode("GIRLS COLLECTION");
        kid.add(boys);
        kid.add(girls);
        
        DefaultMutableTreeNode cbwear=new DefaultMutableTreeNode("Casual Wear");  
        DefaultMutableTreeNode pbwear=new DefaultMutableTreeNode("Party Wear");  
        boys.add(cbwear);
        boys.add(pbwear);
        
        DefaultMutableTreeNode cgwear =new DefaultMutableTreeNode("Casual Wear");  
        DefaultMutableTreeNode pgwear =new DefaultMutableTreeNode("Party Wear");
        girls.add(cgwear);
        girls.add(pgwear);
        
        DefaultMutableTreeNode cmwear =new DefaultMutableTreeNode("Casual Wear");  
        DefaultMutableTreeNode wedmwear =new DefaultMutableTreeNode("Wedding Wear");
        men.add(cmwear);
        men.add(wedmwear);

        DefaultMutableTreeNode cwwear =new DefaultMutableTreeNode("Casual Wear");
        DefaultMutableTreeNode wedwwear =new DefaultMutableTreeNode("Wedding Wear");
        women.add(cwwear);
        women.add(wedwwear);
        
        jt=new JTree(Cat);  
    jt.addTreeSelectionListener(new TreeSelectionListener(){
    public void valueChanged(TreeSelectionEvent e) {
        String getPath = String.valueOf(jt.getSelectionPath());
        System.out.println(getPath);
        if(getPath.equals("[CATEGORIES, Kids, BOYS COLLECTION, Casual Wear]")){
            BoysCasual c=new BoysCasual(UserNameLogin);
        }
        if(getPath.equals("[CATEGORIES, Kids, BOYS COLLECTION, Party Wear]")){
            BoysWedding c=new BoysWedding(UserNameLogin);
        }
        if(getPath.equals("[CATEGORIES, Kids, GIRLS COLLECTION, Casual Wear]")){
            GirlsCasual c=new GirlsCasual(UserNameLogin);
        }
        if(getPath.equals("[CATEGORIES, Kids, GIRLS COLLECTION, Party Wear]")){
            GirlsWedding c=new GirlsWedding(UserNameLogin);
        }
        if(getPath.equals("[CATEGORIES, Mens, Casual Wear]")){
            BoysCasual c=new BoysCasual(UserNameLogin);
        }
        if(getPath.equals("[CATEGORIES, Mens, Wedding Wear]")){
            BoysWedding c=new BoysWedding(UserNameLogin);
        }
        if(getPath.equals("[CATEGORIES, Womens, Casual Wear]")){
            GirlsCasual c=new GirlsCasual(UserNameLogin);
        }
        if(getPath.equals("[CATEGORIES, Womens, Wedding Wear]")){
            GirlsWedding c=new GirlsWedding(UserNameLogin);
        }
    }        
    });    
        p.add(jt);
        p.setBounds(20,30,300,400);
        f.add(p);
        f.setSize(400,500);  
        f.setVisible(true);  
    }
}
