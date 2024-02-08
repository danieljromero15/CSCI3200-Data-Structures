package DoubleNode;

public class DoubleNode
{
   private double data;
   private DoubleNode link;   


   public DoubleNode(double initialData, DoubleNode initialLink)
   {
      data = initialData;
      link = initialLink;
   }

   public double getData( )   
   {
      return data;
   }
   
   public DoubleNode getLink( )
   {
      return link;                                               
   } 

   public void removeNodeAfter( )   
   {
      link = link.link;
   }          
   
   
   public void setData(double newData)   
   {
      data = newData;
   }                                                               
   
   public void setLink(DoubleNode newLink)
   {                    
      link = newLink;
   }
   
   public void addNodeAfter(double item)   
   {
      //the source code for this method is in the notes, simply type that here.
   }          
      
   public static DoubleNode listCopy(DoubleNode source)
   {
     
   }
   
   
   public static DoubleNode[ ] listCopyWithTail(DoubleNode source)
   {
	   // the source code for this method is in the notes, simply type that here.
   }
   
      
   public static int listLength(DoubleNode head)
   {
      
   }
   
   
   public static DoubleNode[ ] listCopyPart(DoubleNode start, DoubleNode end)
   {
      
   }        
   
      
   public static DoubleNode listPosition(DoubleNode head, int position)
   {
      
   }

   public static DoubleNode listSearch(DoubleNode head, double target)
   {
      
   }

}
