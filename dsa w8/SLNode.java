/**
 * Class SLNode implement an elements (a node) of a linked-list data structure.
 * Each element of the list contains a string (item) and a reference variable named next.
 * Please refer to Topic 4 for the Node ADT in detail.
 * 
 * @author (nxthang) 
 * @version (1.0)
 */
package Topic04.Exercises;
public class SLNode {
  private String item;
  private SLNode next;

  /**
   * Constructor for objects of class SLNode
   * This constructor create a node from an input item
   */
  public SLNode(String item) {
    this.item=item;
    this.next=null;
  }
  /**
   * This operation sets the next reference to the node specify in the parameter (next)
   */    
  public void setNext(SLNode next) {
    this.next=next;
  }
  /**
   * This operation return the next reference
   */    
  public SLNode getNext() {
      return this.next;
  }
  /**
   * This operation assigns data of the node to the input item
   */        
  public void setData(String item) {
    this.item=item;
  }
  /**
   * This operation return the current data of the node
   */        
  public String getData() {
    return this.item;
  }    
}