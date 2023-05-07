
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Bilal Ahmad
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    /*
    public static void main(String[] args) 
    {
          Graph flights=new Graph();
       flights.AddVertex("Dubai", "United Arab Emirates UAE");
       flights.AddVertex("Karachi", "Pakistan");
       flights.AddVertex("Tokyo", "Japan");
       flights.AddVertex("Makkah", "Saudia Arabia");
       flights.AddVertex("New York","United States Of America");
       flights.AddVertex("London", "United Kingdom");
       flights.AddVertex("Istanbul", "Turkey");
       flights.AddVertex("Bangkok","Thailand");
       
        
       flights.AddEdge("Dubai", "United Arab Emirates UAE","Karachi", "Pakistan",15000);
       flights.AddEdge("Dubai", "United Arab Emirates UAE","Makkah", "Saudia Arabia",40000); 
       flights.AddEdge("Dubai", "United Arab Emirates UAE","Istanbul", "Turkey",50000);
       flights.AddEdge("Karachi", "Pakistan","Dubai", "United Arab Emirates UAE",15000);
       flights.AddEdge("Karachi", "Pakistan","Makkah", "Saudia Arabia",70000);
       flights.AddEdge("Karachi", "Pakistan","Tokyo", "Japan",50000);
       flights.AddEdge("Karachi", "Pakistan","Istanbul", "Turkey",50000);
       flights.AddEdge("Karachi", "Pakistan","Bangkok","Thailand",60000);
       flights.AddEdge("Istanbul", "Turkey","Dubai", "United Arab Emirates UAE",50000);
       flights.AddEdge("Istanbul", "Turkey","London", "United Kingdom",70000);
       flights.AddEdge("Istanbul", "Turkey","New York","United States Of America",55000);
       flights.AddEdge("London", "United Kingdom","Istanbul", "Turkey",70000);
       flights.AddEdge("London", "United Kingdom","Karachi", "Pakistan",110000);
       flights.AddEdge("New York","United States Of America","London", "United Kingdom",125000);
       flights.AddEdge("New York","United States Of America","Istanbul", "Turkey",55000);
       flights.AddEdge("New York","United States Of America","Tokyo", "Japan",126000);
       flights.AddEdge("Makkah", "Saudia Arabia","Karachi", "Pakistan",70000);
       flights.AddEdge("Makkah", "Saudia Arabia","Dubai", "United Arab Emirates UAE",40000);
       flights.AddEdge("Makkah", "Saudia Arabia","Tokyo", "Japan",80000);
       flights.AddEdge("Tokyo", "Japan","Bangkok","Thailand",46000); 
       flights.AddEdge("Tokyo", "Japan","Dubai", "United Arab Emirates UAE",40000);
       flights.AddEdge("Bangkok","Thailand","New York","United States Of America",80000);
       flights.AddEdge("Bangkok","Thailand","Karachi", "Pakistan",60000);
       flights.printgraphSimple();
 
    Calendar a=new GregorianCalendar(2021,10,13);
    Calendar b=new GregorianCalendar(2021,10,13); 
    Calendar c=new GregorianCalendar(2021,10,13);
    Calendar d=new GregorianCalendar(2021,10,13);
    Calendar e=new GregorianCalendar(2021,10,13);
    Calendar f=new GregorianCalendar(2021,10,13);
    Calendar g=new GregorianCalendar(2021,10,13);
    ControlCentre cc=new ControlCentre(flights);
    cc.putdate(a);
    cc.putdate(b);
    cc.putdate(c);
    cc.putdate(d);
    cc.putdate(e);
    cc.putdate(f);
    cc.putdate(g);
    cc.addFlight(a,cc.mymap.Find("Karachi", "Pakistan"), cc.mymap.Find("Dubai", "United Arab Emirates UAE") , "10:00 AM", "3:00 PM", "PK5706", "5 Hours");
    cc.addFlight(a,cc.mymap.Find("Karachi", "Pakistan"),cc.mymap.Find("London", "United Kingdom"), "4:00 PM", "11:00 PM", "PK9089", " 7 Hours");
    cc.addFlight(a,cc.mymap.Find("Karachi", "Pakistan"),cc.mymap.Find("Tokyo", "Japan"), "4:00 PM", "11:00 PM", "PK-9089", " 7 Hours");
    cc.addFlight(a,cc.mymap.Find("Karachi", "Pakistan"),cc.mymap.Find("Makkah", "Saudia Arabia"), "4:00 PM", "11:00 PM", "PK1278", " 7 Hours");
    cc.addFlight(a,cc.mymap.Find("Makkah", "Saudia Arabia"),cc.mymap.Find("Istanbul", "Turkey"), "4:00 PM", "11:00 PM", "PK4356", " 7 Hours");
    cc.addFlight(a,cc.mymap.Find("New York","United States of America"),cc.mymap.Find("Istanbul", "Turkey"), "4:00 PM", "11:00 PM", "PK8452", " 7 Hours");
    cc.addFlight(a,cc.mymap.Find("London", "United Kingdom"),cc.mymap.Find("New York","United States of America"), "4:00 PM", "11:00 PM", "PK90932", " 7 Hours");
    cc.addFlight(a,cc.mymap.Find("New York","United States of America"),cc.mymap.Find("Bangkok", "Thailand"), "4:00 PM", "11:00 PM", "PK2341", " 7 Hours");
    cc.addFlight(a,cc.mymap.Find("Istanbul", "Turkey"), cc.mymap.Find("Dubai", "United Arab Emirates UAE") , "10:00 AM", "3:00 PM", "PK51295", "5 Hours");
    cc.addFlight(a,cc.mymap.Find("Dubai", "United Arab Emirates UAE") ,cc.mymap.Find("Karachi", "Pakistan"), "10:00 AM", "3:00 PM" , "PK4467", "5 Hours");
    cc.addFlight(a,cc.mymap.Find("Dubai", "United Arab Emirates UAE") , cc.mymap.Find("Tokyo", "Japan") , "10:00 AM", "3:00 PM" , "PK5630", "5 Hours");
    
        Calendar h= new GregorianCalendar(2021,10,13);
        System.out.println(cc.getSchedule(a).toString());
        System.out.println("----------------------");
        System.out.println("Finding flight with flightnumber :"+cc.FindFlight(a, "karachi","dubai").FlightDetails());
        int k=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your Departure City");
        String ds=sc.nextLine();
        sc.nextLine();
        System.out.println("Enter departure country");
        String dc=sc.nextLine();
        sc.nextLine();
         System.out.println("Enter your Arrival City");
        String as=sc.nextLine();
                sc.nextLine();

        System.out.println("Enter Arrival country");
        String ac=sc.nextLine();
                sc.nextLine();

        cc.mymap.disjktraShortest(cc.mymap.Find(ds, dc));
        
        System.out.println("-----------------------");
        
       for(int i=0;i<cc.mymap.adjList.length;i++)
       {
        if(cc.mymap.adjList[i]!=null)
        {
          if(cc.mymap.adjList[i].equals(cc.mymap.Find(as, ac)))
          {   
            
               if(cc.mymap.adjList[i].path.Length()<0)
              {
             
                System.out.println("No , there exists no flight from  "+cc.mymap.Find(ds, dc)+" to "+cc.mymap.adjList[i]);
              }
               
              else
             {
                 if(cc.flightExistsOrNot(a, cc.mymap.Find(ds, dc) , cc.mymap.adjList[i]   ))
                 {
                     System.out.println("Yes possible flight");
                     System.out.println("Ticket Price is "+cc.mymap.adjList[i].mindistance);
                     System.out.println("Connected Points are :"+cc.mymap.adjList[i].path.Length());
                     System.out.println("To Follow Flights are :"+cc.mymap.adjList[i].path.forpath()+""+ cc.mymap.adjList[i]);
                   
                 }
                 else
                 {
  
                    System.out.println("No , there exists no flight from  "+cc.mymap.Find(ds, dc)+" to "+cc.mymap.adjList[i]);
                 }
           
             }
         }
        }
       }
    }
     */   
}
      

      
    
