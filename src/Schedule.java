
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
public class Schedule
{
  Flight[] flights;
  public int index=-1;
  Calendar date;
  public Graph flightmap;
  Schedule(Calendar date)
  {
      this.date=date;
      flights=new Flight[37];
      flightmap=new Graph(); 
  }
   public int Hash(String str)
  {
    int p = 31;
    int m = (int)(1e9 + 9);
    long power_of_p = 1;
    long hash_val = 0;
 
    for(int i = 0; i < str.length(); i++)
    {
        hash_val = (hash_val + (str.charAt(i) -
                    'a' + 1) * power_of_p) % m;
        power_of_p = (power_of_p * p) % m;
    }
    return (int) Math.abs(hash_val%37);
 }
  
  
   public int Rehash(int alreadyhashed, int i)
 { 
     
   return (alreadyhashed+i)%flights.length;
   
 }
  public String toString()
  {
      String str="";
       str+="Day :  "+date.get(Calendar.DAY_OF_MONTH)+"  ,  Month : "+date.get(Calendar.MONTH)+" ,  Year : "+date.get(Calendar.YEAR)+"\n";
       for(int i=0;i<flights.length;i++)
       {
           if(flights[i]!=null)
           {
               str+=flights[i].FlightDetails()+" \n ";
           }
       }
       return str;
  }
   public void AddFlight(Calendar a,Vertex de,Vertex arr,String dept,String arri,String flin,String flightd)
 { 
       
       int ind=Hash(de.city.toLowerCase()+arr.city.toLowerCase());
       Flight fl= new Flight(de,arr,a,dept,arri,flin,flightd);
   if(flights[ind]==null)
   {
      flights[ind]=fl;
   }
   else
   {
       int i=1;
       int numofCollisions = 0;
       while(flights[ind]!=null && numofCollisions<flights.length)
       {
           numofCollisions++;
           ind=Rehash(ind,i);
           i++; 
      }
       
       if(flights[ind]==null)
       {
           flights[ind]=fl;
       }
       else
       {
       }
            
  }
 }
   public Flight FindFlight(String  dep,String arr )
  {
       dep=dep.toLowerCase();
       arr=arr.toLowerCase();
     if( flights[Hash(dep+arr)]!=null && flights[Hash(dep+arr)].departure.city.equalsIgnoreCase(dep) &&
             flights[Hash(dep+arr)].Arrival.city.equalsIgnoreCase(arr) ) 
     {
         return flights[Hash(dep+arr)];
     }
     else
     {
          int i=1;
          int ind=Hash(dep+arr);
          int counter=0;
          while(flights[ind]!=null && !( flights[ind].departure.city.equalsIgnoreCase(dep) &&
                  flights[ind].Arrival.city.equalsIgnoreCase(arr)) 
                  && (counter<flights.length)
                 )
          {
              counter++;
              ind=Rehash(ind,i);
              i++;
          }
          if(flights[ind]!=null)
          {
              
             if(flights[ind].departure.city.equalsIgnoreCase(dep) && flights[ind].Arrival.city.equalsIgnoreCase(arr) ) 
            {
              return flights[ind];
            } 
          }
          else
          {
             return null;
          }
     }
      return null;
}
}
