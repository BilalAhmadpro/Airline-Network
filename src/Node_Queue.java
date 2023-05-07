/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * 
 */
public class Node_Queue 
{
  int weight;
  Vertex v;
  Node_Queue next;
  Node_Queue(Vertex v,int weight)
  {
      this.weight=weight;
      this.v=v;
  }
  
}
