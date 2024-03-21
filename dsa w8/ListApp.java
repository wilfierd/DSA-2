/**
 * Write a description of class ListApp here.
 * 
 * @author (nxthang) 
 * @version (1.0)
 */
package Topic04.Exercises;
public class ListApp {
  /**
   * Constructor for objects of class ListApp
   */
  public ListApp() {
  }
  
  public static void main(String[]args) {

    //Instance đầu tiên: myList
    ArrayList myList = new ArrayList();
    myList.add(1,100);
    myList.add(2,200);
    myList.add(3,300);
    myList.add(4,400);        
    System.out.println(myList.toString());
    System.out.println(myList.getLength());
    
    //Xoá phần tử 4
    myList.remove(4);
    //Cập nhập
    System.out.println(myList.toString());
    //Kiem tra danh sach lieu co trong
    System.out.println(myList.isEmpty());
    //Kiem tra danh sach da day chua, max la 100 phan tu
    System.out.println(myList.isFull());
    //Xem do dai
    System.out.println(myList.getLength());

    //Instance mới 
    SLList myList1 = new SLList();
    myList1.add(1,"String 1");
    myList1.add(2,"String 2");
    myList1.add(3,"String 3");
    myList1.add(4,"String 4");   
    myList1.add(5,"String 5");   
         
    System.out.println(myList1.toString());  
    System.out.println(myList1.getLength());  

    //Xoá phần tử 4
    myList1.remove(4);
    //Cập nhập
    System.out.println(myList1.toString());
    System.out.println(myList1.getLength());    

    //Tìm kiếm, nếu k dúng trả về -1
    String item = "String 4";
    System.out.println("Searching for: " + item + " result: " + myList1.search(item));    
  }    
}