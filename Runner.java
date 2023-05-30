/**
* Author: Gabriel Cotua
* Date: 05/27/2023
* Language: Java
*/
import java.util.*;
import core.data.*;

public class OpenEnded {
    public static void main(String[] args) {
        DataSource ds = DataSource.connect("https://data.cityofnewyork.us/api/views/25th-nujf/rows.xml?accessType=DOWNLOAD").load();
        //ds.printUsageString();

        // Obtener el conjunto de datos
        ArrayList<BabyNames> data = ds.fetchList("BabyNames","row/row/_uuid", "row/row/_id", "row/row/nm", "row/row/cnt", "row/row/rnk", "row/row/gndr", "row/row/brth_yr");
        Scanner scan = new Scanner(System.in);
        System.out.println("Apply a filter: (name/quantity/year/gender[male/female])");
        String filtro = scan.next(); //Respuesta del usuario
        String ans;
        int ans1;
        if(filtro.equalsIgnoreCase("name")) { //filtro por nombre
        		
        	System.out.println("Write a name that you whould like to know about");
        	ans = scan.next();
            for(BabyNames a : data) {

        	if(ans.equalsIgnoreCase(a.getNm())) {
        		System.out.println("Name: " + a.getNm() + " Count: " + a.getCnt() + " Year of Birth: " + a.getBrth_yr() +  " Rank: " + a.getRnk());
        		}
        	}
        }
        if(filtro.equalsIgnoreCase("quantity")) { //filtro por cantidad
        		
        	System.out.println("Write a minimum amount to see names that are equal or more used than that amount");
        	ans1 = scan.nextInt();
            for(BabyNames a : data) {
            	if(a.getCnt() >= ans1) {
            		System.out.println("Name: " + a.getNm() + " Count: " + a.getCnt() + " Year of Birth: " + a.getBrth_yr() +  " Rank: " + a.getRnk());
        		}
        	}
        }
        if(filtro.equalsIgnoreCase("year")) { //filtro por año
        	System.out.println("Write a year to check names used that year");
        	ans1 = scan.nextInt();
            for(BabyNames a : data) {
            	if(a.getBrth_yr() >= ans1) {
            		System.out.println("Name: " + a.getNm() + " Count: " + a.getCnt() + " Year of Birth: " + a.getBrth_yr() +  " Rank: " + a.getRnk());
        		}
        	}
        }
        if(filtro.equalsIgnoreCase("gender")){ //filtro por genero
        	System.out.println("Write a gender only (\"male\" or \"female\")");
        	ans = scan.next();
        	for(BabyNames a : data) {
        		if(a.getGndr().equalsIgnoreCase(ans)) {
            		System.out.println("Name: " + a.getNm() + " Count: " + a.getCnt() + " Year of Birth: " + a.getBrth_yr() +  " Rank: " + a.getRnk());
        		}
        	}
        } 
    }
}
/**
 * Data Available:
 * 
 * 
 * The following data is available:
   a structure with fields:
   {
     row : a structure with fields:
           {
             row : A list of:
                     structures with fields:
                     {
                       _address : *
                       _id : *
                       _position : *
                       _uuid : *
                       brth_yr : *
                       cnt : *
                       ethcty : *
                       gndr : *
                       nm : *
                       rnk : *
                     }
           }
   }
*/
