/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rat.resources;

/**
 *
 * @author kingr
 */
import RAT.models.MenuItem;
import rat.StringConstants;
import java.sql.*;
import java.util.ArrayList;
public class MenuDbHandler {

    public MenuItem FindInMenu(int id,int qty) {
        MenuItem item=null;
        try(
            Connection conn=DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
            Statement stmt=conn.createStatement();
            )
        {
            String sqlSelect="SELECT name,price,tpp,nppt FROM menu WHERE id = "+id;
            ResultSet rSet=stmt.executeQuery(sqlSelect);
            
            rSet.next();
            item=new MenuItem(rSet.getString("name"),rSet.getDouble("price"),rSet.getInt("nppt"),rSet.getInt("tpp"),id,qty);
        }
        catch(SQLException ex){
                ex.printStackTrace();
                System.out.println(ex);
                }
        return item;
        
    }
    
    public boolean AddToMenu(String name,double price,int nppt,int tpp,int qty) 
    {
        boolean status=false;
        try(
            Connection conn=DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
            Statement stmt=conn.createStatement();
           )
            
        {
            String sql_insert="INSERT INTO menu (name,price,nppt,tpp) VALUES ('"+name+"', "+ price + ", " + nppt + ", " + tpp + " )";
            int count=stmt.executeUpdate(sql_insert);
            
            if(count!=0)    
                System.out.println("Menu Item added successfully!");
        }
        catch(SQLException ex)
                {
                ex.printStackTrace();
                }
        return status;
    }
    
    public ArrayList getMenu()
    {
        ArrayList <MenuItem> item=new ArrayList();
        try(
            Connection conn=DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
            Statement stmt=conn.createStatement();
           )
        {
            String sqlSelect="SELECT name,price,tpp,nppt,id FROM menu";
            ResultSet rSet=stmt.executeQuery(sqlSelect);
           while(rSet.next())
           {
               int id =rSet.getInt("id");
               String name=rSet.getString("name");
               double price =rSet.getDouble("price");
               int tpp=rSet.getInt("tpp");
               int nppt=rSet.getInt("nppt");
               item.add(new MenuItem(name,price,nppt,tpp,id,0));
           }
        }
        catch(SQLException ex)
                {
                ex.printStackTrace();
                System.out.println(ex);
                }
        return item;
        
    }
    public MenuItem QueryByName(String name,int qty) {
        // TODO code application logic here
        MenuItem item=null;
        try(
            Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
            Statement stmt = conn.createStatement();
        )
        {
            String SqlSearch = "SELECT id,price,tpp,nppt FROM menu WHERE name='"+name+"'";
            ResultSet rSet=stmt.executeQuery(SqlSearch);
            rSet.next();
            item=new MenuItem(rSet.getInt("id"),name,rSet.getDouble("price"),rSet.getInt("tpp"),rSet.getInt("nppt"),qty);
        }
        catch(SQLException ex){
            String temp=ex.getMessage();
            if(temp.equals("Illegal operation on empty result set."))
                System.out.println("No such menu item exists.");
            else
                ex.printStackTrace();
        }
        return item;
    }

    
}

