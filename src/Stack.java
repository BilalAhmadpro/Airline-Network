/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * 
 */
public class Stack 
{
     Edge head;
     int length;
     int maximum;
     Stack()
     {
         head=null;
         length=-1;
         maximum=100;
     }
     public boolean IsEmpty()
     {
         return head==null;
     }
     public void push(Vertex v,int distance)
     {
        Edge n=new Edge(v,distance);
             if(head==null)
             {
                 head=n;
                 length++;
             }
             else
             {
                 
                 n.next=head;
                 head=n;
                 length++;
                
             }
             
         }
     
     public Vertex pop()
     {
         if(!IsEmpty())
         {
             Vertex data=  head.targetvertex;
             head=head.next;
             return data;
         }
         return null;
     }
    
}
