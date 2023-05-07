/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 *
 */
public class Vertex
{
 String city;
 String country;
 boolean chek;
 Integer mindistance;
 LinkedList edgelist;
 LinkedList path;
 Vertex(String city,String country)
 {
     path=new LinkedList();
     this.mindistance=Integer.MAX_VALUE;
     this.city=city;
     this.country=country;
     chek=false;
     edgelist=new LinkedList();
 }
 public void reset()
 {
     edgelist=new LinkedList();
 }
 public void turnonchek()
 {
     this.chek=true;
 }
 public void turnoffchek()
 {
     this.chek=false;
 }
 
 @Override
 public String toString()
 {
  
     String s="";
     s= " "+city.toUpperCase()+" , "+country.toUpperCase();
    return s;
 }
 public boolean equals(Vertex tochek)
 {
     if(this.city.equalsIgnoreCase(tochek.city) && this.country.equalsIgnoreCase(tochek.country))
     {
         return true;
     }
     return false;
 }
}
