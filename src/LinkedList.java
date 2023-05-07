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
public class LinkedList
{
    Edge head;
    Edge tail;
   private int Length;
   LinkedList()
   {
       head=tail=null;
       Length=0;
   }
   public void Insert(Vertex data,int distance)
   {
       Edge n=new Edge(data,distance);
       if(head==null)
       {
           head=tail=n;
       }
       else
       {
          tail.next=n;
          tail=n;
       }
       Length++;
   }
   public void makemylistfresh(LinkedList l)
   {
      this.head=null;
      this.tail=null;
      Edge temp=l.head;
      this.Length=0;
      while(temp!=null)
      {
          this.Insert(temp.targetvertex, temp.distance);
          temp=temp.next;
      }
      
   }
   public int Length()
   {
       return Length;
   }
   
  
 
   public boolean IsEmpty()
   {
        
       return head==null;
   }
   public void ClearList()
   {
      
       Length=0;
       head=null;
   }
  
 
   public String forpath()
   {
       
      String s="";
       Edge temp=head;
       while(temp!=null)
       {
           if(temp.next==null)
           {
            s+=temp.toString();
           }
           else
           {
            s+=temp.toString()+" >>> ";
           }
           temp=temp.next;
       }
       return s;
   }
   
   
   public void Removethroughvertex(Vertex data)
   {
       if(head!=null)
       {
          if(head.targetvertex.equals(data))
          {
            Length--;
            head=head.next;
          }
         else
         {
           Edge temp1=head;
           Edge temp=temp1;
           while(temp!=null && !temp.targetvertex.equals(data))
           {
               temp1=temp;
               temp=temp.next;
           }
           if(temp!=null)
           {
             Length--;
             temp1.next=temp.next;
           }
        }
     }
   }
   public void Removethroughname(String city,String country)
   {
       if(head!=null)
       {
          if(head.targetvertex.city.equalsIgnoreCase(city) && head.targetvertex.country.equalsIgnoreCase(country) )
          {
            Length--;
            head=head.next;
          }
         else
         {
          Edge temp1=head;
          Edge temp=temp1;
           while(temp!=null && !(temp.targetvertex.city.equalsIgnoreCase(city) && temp.targetvertex.country.equalsIgnoreCase(country)))
           {
               temp1=temp;
               temp=temp.next;
           }
           if(temp!=null)
           {
             Length--;
             temp1.next=temp.next;
           }
        }
     }
   }
   
   
   
}