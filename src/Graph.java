

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * 
 */
public class Graph 
{
  Vertex[] adjList;
  int count;
  int index;
  Vertex[] dfspath;
  int dfscounter=-1;
  Graph()
  {
      adjList=new Vertex[101];
      count=0;
      index=-1;
      dfspath=new Vertex[20];
  }
 
  public boolean IsFull()
  {
      return index+1==adjList.length;
  }
  
  private boolean IsEmpty()
  {
      return index==-1;
  }
  public static int Hash(String str)
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
    return (int) Math.abs(hash_val%101);
 }
  
  
   public int Rehash(int alreadyhashed, int i)
 { 
     
   return (alreadyhashed+i)%adjList.length;
   
 }
   
   
   public void AddVertex(String city,String country)
 { 
     city=city.toLowerCase();
       int ind=Hash(city);
       Vertex v=new Vertex(city,country); 
   if(adjList[ind]==null)
   {
      adjList[ind]=v;
      index++;
   }
   else
   {
       int i=1;
       int numofCollisions = 0;
       while(adjList[ind]!=null && numofCollisions<adjList.length)
       {
           numofCollisions++;
           ind=Rehash(ind,i);
           i++; 
      }
     
       if(adjList[ind]==null)
       {
           adjList[ind]=v;
    
       }
       
            
  }
 }
  

  public void addVertex(Vertex v)
  {
      if(!IsFull())
      {
          adjList[++index]=v;
          count++;
     }
  }
  public Vertex topVertex()
  {
      if(adjList[0]!=null)
      {
      return adjList[0];
      }
      return null;
  }
 
  public void dfsclear()
  {
      dfspath=new Vertex[10];
  }
 
  public void AddEdge(String city1,String country1,String city2,String country2,int distance)
  {
      Vertex source=Find(city1,country1);
      Vertex dest=Find(city2,country2);
      
           if(dest!=null)
           {
               source.edgelist.Insert(dest,distance);
  
           }    
  }
  public void addEdge(Vertex s,Vertex d,int distance)
  {
       if(d!=null)
           {
               s.edgelist.Insert(d,distance);
      
           }
  }
  
  
  public void printgraphSimple()
  {
      for(int i=0;i<adjList.length;i++)
      {
          if(adjList[i]!=null)
          {
          System.out.println(adjList[i]);
          System.out.println("Direct Connected airports   : "+adjList[i].edgelist.forpath());
          System.out.println("-----------------------");
          }
      }
  }
  
  
public void deleteEdge(String city1,String country1,String city2,String  country2)
{
      Vertex source=Find(city1,country1);
      Vertex dest=Find(city2,country2);
     
           if(dest!=null)
           {
              source.edgelist.Removethroughvertex(dest);
              dest.edgelist.Removethroughvertex(source);
           }
      
}

 public Vertex Find(String city,String country)
{
        city=city.toLowerCase();
     if( adjList[Hash(city)]!=null && adjList[Hash(city)].city.equalsIgnoreCase(city) && adjList[Hash(city)].country.equalsIgnoreCase(country) )
     {
         return adjList[Hash(city)];
     }
     else
     {
          int i=1;
          int ind=Hash(city);
          int counter=0;
          while( adjList[Hash(city)]!=null && (!(adjList[ind].city.equalsIgnoreCase(city) && adjList[ind].country.equalsIgnoreCase(country))) && (counter<adjList.length) )
          {
              counter++;
              ind=Rehash(ind,i);
              i++;
          }
          if(adjList[Hash(city)]!=null)
          {
              
             if(adjList[ind].city.equalsIgnoreCase(city) && adjList[ind].country.equalsIgnoreCase(country))
            {
              return adjList[ind];
            } 
          }
          else
          {
             return null;
          }
     }
      return null;
}

public void DepthFirstSearchIterative(Vertex v)
{
    DFS( v);
    for(int i=0;i<adjList.length;i++)
    {
        if(adjList[i]!=null)
        {
          adjList[i].turnoffchek();
        }
    }
}
public Vertex[] getdfspath()
{
    return dfspath;
}
public void DFS(Vertex v)
{
    if(v==null)
    {
        return ;
    }
    v.turnonchek();
    dfspath[++dfscounter]=v;
    Edge temp=v.edgelist.head;
    while(temp!=null)
    {
        if(!temp.targetvertex.chek)
        {
            DFS(temp.targetvertex);
        }
        temp=temp.next;
    }
}
public void disjktraShortest(Vertex source)
{
    PriorityQueue pq=new PriorityQueue();
    source.mindistance=0;
    pq.Enquue(source, 0);
    while (!pq.IsEmpty())
    {

        Vertex u=pq.Dequue();
        u.turnonchek();
        Edge temp=u.edgelist.head;
        while(temp!=null)
        {          
            if(temp.targetvertex.chek)
            {
                temp=temp.next;
                continue;
            }
            if(temp.targetvertex.mindistance>temp.distance+u.mindistance)
            {
                
                temp.targetvertex.path.makemylistfresh(u.path);
                temp.targetvertex.path.Insert(u, temp.targetvertex.mindistance);
              
                temp.targetvertex.mindistance=temp.distance+u.mindistance;
                pq.Enquue( temp.targetvertex, temp.targetvertex.mindistance);
            }
            temp=temp.next;
        }
    }
   
}
}

