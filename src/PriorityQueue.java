/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * 
 * 
 */
public class PriorityQueue 
{
 private Node_Queue front;
 private Node_Queue rear;
 private int length;
   PriorityQueue()
   {
       length=0;
       front=rear=null;
   }
   public boolean IsEmpty()
   {
       return (front==null && rear==null);
   }
   public void Enquue(Vertex v,int weight)
   {
       length++;
      Node_Queue n= new Node_Queue(v,weight);
       if(IsEmpty())
       {
           
           front=rear=n;
       }
       else
       {
           if(front.weight>=weight)
           {
               Node_Queue temp=n;
               temp.next=front;
               front=temp;
               return;
           }
           
           else
           {
               Node_Queue temp=front;
               Node_Queue prev=front;
               while(temp!=null && temp.weight<=weight)
               {
                 
                   prev=temp;
                   temp=temp.next;
               }
               if(prev==rear)
               {
                   prev.next=n;
                   rear=n;
               }
               else
               {
                n.next=temp;
                prev.next=n;
               }
               
           }
           
       }
   }
   public int getLength()
   {
       return length;
   }
@Override
   public String toString()
   {
       Node_Queue temp=front;
       String str="";
       while(temp!=null)
       {
           str+=temp.weight+" , ";
           temp=temp.next;
       }
       return str;
   }
   public Vertex Dequue()
   {
       Vertex temp=null;
      if(!IsEmpty())
      {
          length--;
          if(front==rear)
          { 
              temp=front.v;
              front=rear=null;
             
              return temp;
          }
          else
          {
          temp=front.v;
          front=front.next;
          return temp;
          }
          
      }
      return temp;
   }
           
}
