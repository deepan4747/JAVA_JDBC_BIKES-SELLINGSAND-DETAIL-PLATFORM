package BikeShopManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dbutil;

public class Inventory {
    private List<Bike> bikes;

    public Inventory() {
        this.bikes = new ArrayList<>();
    }

    public void addBike(Bike bike) {
        Statement stmt;
        DbUtil db = new DbUtil();
        try {
            Connection con = db.getDBConnection();
            stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO bikes(brand, name, price, mileage) VALUES('" + bike.getBrand() + "','" + bike.getName() + "','" + bike.getPrice() + "','" + bike.getMileage() + "')");
            System.out.println("INSERTED SUCCESSFULLY");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void updateBike(Bike bike) {
        Statement stmt;
        DbUtil db = new DbUtil();
        try {
            Connection con = db.getDBConnection();
            stmt = con.createStatement();
            stmt.executeUpdate("UPDATE bikes SET name='" + bike.getName() + "', price=" + bike.getPrice() + " WHERE id=" + bike.getId());
            System.out.println("UPDATED SUCCESSFULLY");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void removeBike(int bikess) {
       /* if (index >= 0 && index < bikes.size()) {
            bikes.remove(index);
            System.out.println("Bike removed successfully.");
        } else {
            System.out.println("Invalid index. No bike removed.");
        }*/
//    	
    	/*Statement stmt;
    	ResultSet rs;
    	String qry=null;
    	dbutil db=new dbutil();
    	//Connection con;
    	boolean sts=false;
    	try
    	{
    		Connection con=db.getDBConnection();
    		con=db.getDBConnection();
    		//Connection con = null;
			stmt=con.createStatement();
    		int count=stmt.executeUpdate("DELETE from bikes WHERE id="+bikess+"");
    	}
    	catch(Exception ex)
    	{
    		System.out.println(ex.getMessage());
    	}*/
    	
    	    Statement stmt = null;
    	    Connection con = null;
    	    
    	    try {
    	        DbUtil db = new DbUtil();
    	        con = db.getDBConnection();
    	        stmt = con.createStatement();
    	        
    	        int count = stmt.executeUpdate("DELETE FROM bikes WHERE id=" + bikess);
    	        
    	        if (count > 0) {
    	            System.out.println("Bike removed successfully.");
    	            bikes.removeIf(bike -> bike.getId() == bikess);
    	        } else {
    	            System.out.println("No bike found with the given ID.");
    	        }
    	    } catch (Exception ex) {
    	        System.out.println("Error occurred: " + ex.getMessage());
    	    } finally {
    	        try {
    	            if (stmt != null) stmt.close();
    	            if (con != null) con.close();
    	        } catch (Exception e) {
    	            System.out.println("Error closing resources: " + e.getMessage());
    	        }
    	    }
    	

    	
    	
    }

    public Bike findBikeById(int id) {
        for (Bike bike : bikes) {
            if (bike.getId() == id) {
                return bike;
            }
        }
        return null; // Return null if no bike is found
    }

    public void showAllBikes() {
        Statement stmt;
        ResultSet rs;
        DbUtil db = new DbUtil();
        Connection con;
        try {
            con = db.getDBConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM bikes");
            while (rs.next()) {
                System.out.println( rs.getString(1) + "    " + rs.getString(2) + "    " + rs.getInt(3) + "    " + rs.getInt(4)+"   "+rs.getInt(5));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Bike> getBikes() {
        return bikes;
    }


}

