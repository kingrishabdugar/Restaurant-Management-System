/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rat;
import java.util.*;
import RAT.models.Staff;
import RAT.models.MenuItem;
import RAT.models.Order;
import javax.swing.SwingUtilities;
import rat.screens.*;
import rat.resources.*;

/**
 *
 * @author kingrishabdugar
 */
public class RAT {
    public static void main(String[] args) {
           
         
        Staff s1=new Staff("Manager",35,75000.0);
        s1.setSalary(100000.0);
        s1.DisplayDetails();
        MenuItem m1=new MenuItem("CBiryani",300.0,4,3,3,2);
        m1.setName("Pulao");
        m1.DisplayDetails();
        MenuItem m2=new MenuItem("Veg Biriyani",200.0,1,3,4,5);
        m2.DisplayDetails();
        ArrayList<MenuItem> temp= new ArrayList <MenuItem>();
        temp.add(m1);
        temp.add(m2);
        Order o1=new Order(1,"11:00",temp);
        o1.DisplayDetails();*/
              SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
               Login app=new Login();
                app.setVisible(true);
            }
            
        });
      // MenuDbHandler ob1 =new MenuDbHandler();
       //ob1.AddToMenu("SYOP",792.90,114,121,4);
        //App_Screen ob1 =new App_Screen();
        //ob1.setVisible(true);
      

    }
}
        

