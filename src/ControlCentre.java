
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
public class ControlCentre
{
 Schedule[] schedule;
 Graph mymap;
 public ControlCentre(Graph map)
 {
     schedule=new Schedule[30];
     mymap=map;
 }
 public void addFlight(Calendar a,Vertex de,Vertex arr,String dept,String arri,String flin,String flightd,int costoftrip)
  {
          int day=a.get(Calendar.DAY_OF_MONTH);   
          schedule[HashDates(day)].AddFlight(a, de, arr, dept, arri, flin, flightd);
          schedule[HashDates(day)].flightmap.AddEdge(de.city,de.country, arr.city,arr.country, costoftrip);
  }
  public void printschedule()
  {
      for(int i=0;i<schedule.length;i++)
      {
          if(schedule[i]!=null)
          {
              System.out.println("at index : "+i+" , "+schedule[i].toString());
          }
      }
  }
  public Schedule getSchedule(Calendar a)
  {
       int day=a.get(Calendar.DAY_OF_MONTH);   
      return schedule[HashDates(day)];
  }
  private int HashDates(int key)
  {
      return key%schedule.length;
  }
   public Flight FindFlight(Calendar a,String dep,String arr)         
  {
      int day=a.get(Calendar.DAY_OF_MONTH);   
      return schedule[HashDates(day)].FindFlight(dep,arr);
  }
  
  public void putdate(Calendar a)
  {
      int day=a.get(Calendar.DAY_OF_MONTH);   
      schedule[HashDates(day)]= new Schedule(a);
      for(int i=0;i<mymap.adjList.length;i++)
      {
          if(mymap.adjList[i]!=null)
          {
           schedule[HashDates(day)].flightmap.AddVertex(mymap.adjList[i].city, mymap.adjList[i].country);
          }
      }
  }
   public boolean flightExistsOrNot(Calendar a,Vertex departure,Vertex Destination)
  {
           int day=a.get(Calendar.DAY_OF_MONTH);   
           schedule[HashDates(day)].flightmap.DFS( schedule[HashDates(day)].flightmap.Find(departure.city,departure.country));
           Vertex[] array=schedule[HashDates(day)].flightmap.getdfspath();
           
           
           for(int i=0;i<array.length;i++)
           {
              
                if(array[i]!=null)
                {
                   if(array[i].equals(Destination) )
                   {
                       System.out.println("Yes flight from "+departure.city+" to : "+array[i].city);
                       return true;
                   }
                }
              }  
           
           return false;
    
           
  }
} 
