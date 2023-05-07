
import java.util.Calendar;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * 
 */
public class Flight
{
     Vertex departure;
     Vertex Arrival;
     Calendar date;
     String departuretime;
     String arrivaltime;
     String flightnumber;
     String flightduration;
     final int totalseats=100;
     PassengerBooking[] userdata;
     int index;
     int ecocount;
     int businesscount;
     int occupiedseats;
     Flight(Vertex depar,Vertex arr,Calendar date,String dept,String arrt,String flin,String fldu)
     {
         this.date=date;
         this.flightnumber=flin;
         this.Arrival=arr;
         this.departure=depar;
         this.arrivaltime=arrt;
         this.departuretime=dept;
         this.flightduration=fldu;
         index=-1;
         occupiedseats=0;
         userdata=new PassengerBooking[totalseats];
     }
     
     public boolean Book(String name,String cnic,String email,String phone,String gender )
     {
         if(index<99)
         {
           int ticketassigned=++index+1;
           PassengerBooking passenger=new PassengerBooking(name,phone,email,ticketassigned,cnic,gender);
           userdata[index]=passenger;
           return true;
         }
         
         return false;
         
     }
     public String FlightDetails()
     {
         return  "Flight Departure : "+this.departure+" ,  Arrival Spot : "+this.Arrival+
            "\n  Flight number :"+this.flightnumber+ " , Departure time : "+this.departuretime+" , Arrival Time : "+this.arrivaltime+"\n"+this.printDate()
                 +"\n "+Find(index+1);
     }
     public String Find(int ticket)
     {
         String s="";
         if(ticket>0 && ticket<100)
         {
             if(userdata[ticket-1]!=null)
             {
                 return userdata[ticket-1].toString();
             }
             
         }
         s+=" Reccord Not Found";
         return s;
     }
     public int Hash(int key)
     {
         return key%100;
     }
     public int totalEmptySeats()
     {
         return totalseats-occupiedseats;
     }
     public String printDate()
     {
         return "Day :  "+date.get(Calendar.DAY_OF_MONTH)+"  ,  Month : "+date.get(Calendar.MONTH)+" ,  Year : "+date.get(Calendar.YEAR);
     }
     
 } 
