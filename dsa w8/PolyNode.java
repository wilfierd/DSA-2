/**
 * Class PolyNode implement an elements (a node) of a linked-list data structure that is used to store a polynomial data.
 * Each element of the list contains a term's data (its coefficient and its exponent), and a reference variable named next.
 * Please refer to the Topic 4 Tutorial & Exercise 3 for the PolyNode in detail.
 * 
 * @author (nxthang) 
 * @version (1.0)
 */
package Topic04.Exercises;

public class PolyNode {  
  private float coef;
  private int exp;
  private PolyNode next;

  // QUESTION 3
  // Constructor
  public PolyNode(float coef, int exp) {
    this.coef = coef;
    this.exp = exp;
    this.next = null; // Initially, the next reference is null
  }

  // Getter method for coefficient
  public float getCoef() {
    return coef;
  }

  // Getter method for exponent
  public int getExp() {
    return exp;
  }

  // Getter method for the next node
  public PolyNode getNext() {
    return next;
  }

  // Setter method for the next node
  public void setNext(PolyNode next) {
    this.next = next;
  }
  
  public String toString() {
    if (exp > 0)
      return String.format("%.1f",coef) + "x^" + exp;
    return String.format("%.1f",coef);
  }
  
}