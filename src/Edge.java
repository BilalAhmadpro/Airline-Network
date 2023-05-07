/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * 
 */
public class Edge
{
   Vertex targetvertex ;
   int distance;
   Edge next;
   Edge()
   {
       this.next=null;
   }
   Edge(Vertex data,int distance)
   {
      this.targetvertex=data;
      this.distance=distance;
       next=null;
   }
   @Override
   public String toString()
   {
       return this.targetvertex.city.toUpperCase()+" , "+this.targetvertex.country.toUpperCase()+" ";
   }
 
   
   
          
}
