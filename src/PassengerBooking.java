/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * 
 */
public class PassengerBooking
{
  String name;
  String phone;
  String email;
  int ticketnumber;
  String cnic;
  String gender;
  PassengerBooking(String n,String p,String e,int t,String c,String g)
  {
      this.cnic=c;
      this.email=e;
      this.gender=g;
      this.ticketnumber=t;
      this.phone=p;
      this.name=n;
  }
  public String toString()
  {
      return "_______Ticket Details____ \n Name of Person : "+name+"\nTicket Number : "+ticketnumber+" CNIC # "+cnic+ "\nGender :"+gender
              +"\nEmail : "+email+"\n Phone : "+phone;
  }
  
}
