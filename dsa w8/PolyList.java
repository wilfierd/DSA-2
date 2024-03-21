/**
 * Class PolyList implement a linked-list data structure that is used to store a polynomial data. Each element of the list is a term of the polynomial.
 * Please refer to Topic 4 Tutorial & Exercise 3 for the PolyList class in detail.
 * 
 * @author (nxthang) 
 * @version (1.0)
 */
package Topic04.Exercises;

public class PolyList {
  private PolyNode head;
  private int length;

  /**
   * Constructor for objects of class PolyList.
   * This constructor will create an empty list.
   */
  public PolyList() {
    head = null;
    length = 0;
  }
  /**
   * This operation returns true if the list is empty, otherwise it returns false
   */
  public boolean isEmpty(){
    if (length == 0)
        return true;
    else
        return false;
  }
  
  /**
   * This is a private operation (supplementary operation). 
   * It returns the node before the exp in the list.
   */    
  private PolyNode traverse(int exp) {
    // QUESTION 4
    PolyNode cur = head;
    PolyNode prev = null;
    while (cur != null && cur.getExp() < exp) {
        prev = cur;
        cur = cur.getNext();
    }
    return prev;
  }
  
  /**
   * This operation adds a new term into the polynomial
   */  
  public void addTerm(float coef, int exp) {

    // QUESTION 5
    PolyNode newNode = new PolyNode(coef, exp);

    if (isEmpty() || exp > head.getExp()) {
        newNode.setNext(head);
        head = newNode;
    } else {
        PolyNode prev = traverse(exp);
        newNode.setNext(prev.getNext());
        prev.setNext(newNode);
    }
    length++;
    // Write java code to implement this method 
       

    // End of the method  
  }


  public PolyNode getHead() {
    return head;
  }
  
  public void add(PolyList p) {
    // QUESTION 6
    PolyNode currentP = p.getHead();
    PolyNode currentThis = head;
    PolyNode prevThis = null;

    while (currentP != null) {
        // Find the position to insert the term from p into this polynomial
        while (currentThis != null && currentThis.getExp() > currentP.getExp()) {
            prevThis = currentThis;
            currentThis = currentThis.getNext();
        }

        // If currentThis is null, we reached the end of the list, so just add the remaining terms from p
        if (currentThis == null) {
            while (currentP != null) {
                PolyNode newNode = new PolyNode(currentP.getCoef(), currentP.getExp());
                prevThis.setNext(newNode);
                prevThis = newNode;
                currentP = currentP.getNext();
            }
            break; // Break out of the loop since we added all terms from p
        }

        // If exponents match, add coefficients
        if (currentThis.getExp() == currentP.getExp()) {
            currentThis.setCoef(currentThis.getCoef() + currentP.getCoef());
            prevThis = currentThis;
            currentThis = currentThis.getNext();
            currentP = currentP.getNext();
        }
        // If the exponent of the term from p is smaller, insert it before currentThis
        else if (currentP.getExp() < currentThis.getExp()) {
            PolyNode newNode = new PolyNode(currentP.getCoef(), currentP.getExp());
            newNode.setNext(currentThis);
            if (prevThis != null) {
                prevThis.setNext(newNode);
            } else {
                head = newNode; // If prevThis is null, it means the new term is the new head
            }
            prevThis = newNode;
            currentP = currentP.getNext();
        }
    }
    // Write java code to implement this method  


    // End of the method    
  }

  public void subtract(PolyList p) {
    // QUESTION 7
    PolyNode currentP = p.getHead();
    PolyNode currentThis = head;
    PolyNode prevThis = null;

    while (currentP != null) {
        // Find the position to insert the term from p into this polynomial
        while (currentThis != null && currentThis.getExp() > currentP.getExp()) {
            prevThis = currentThis;
            currentThis = currentThis.getNext();
        }

        // If currentThis is null, we reached the end of the list, so just add the remaining terms from p with inverted coefficients
        if (currentThis == null) {
            while (currentP != null) {
                PolyNode newNode = new PolyNode(-currentP.getCoef(), currentP.getExp());
                prevThis.setNext(newNode);
                prevThis = newNode;
                currentP = currentP.getNext();
            }
            break; // Break out of the loop since we added all terms from p
        }

        // If exponents match, subtract coefficients
        if (currentThis.getExp() == currentP.getExp()) {
            currentThis.setCoef(currentThis.getCoef() - currentP.getCoef());
            prevThis = currentThis;
            currentThis = currentThis.getNext();
            currentP = currentP.getNext();
        }
        // If the exponent of the term from p is smaller, insert its negation before currentThis
        else if (currentP.getExp() < currentThis.getExp()) {
            PolyNode newNode = new PolyNode(-currentP.getCoef(), currentP.getExp());
            newNode.setNext(currentThis);
            if (prevThis != null) {
                prevThis.setNext(newNode);
            } else {
                head = newNode; // If prevThis is null, it means the new term is the new head
            }
            prevThis = newNode;
            currentP = currentP.getNext();
        }
    }
    // Write java code to implement this method  


    // End of the method        
  }

/*  
  public String toString() {
    if (isEmpty())
      return "[]";

    PolyNode current = head;
    String outTxt="[" + current.toString();
    for (int i=1; i<length; i++) {
      current = current.getNext();
      if (current.getCoef() > 0)
        outTxt = outTxt + "+" + current.toString();
      if (current.getCoef() < 0)
        outTxt = outTxt + current.toString();
    }  
    outTxt+="]";
    return outTxt;
  }  
*/
}