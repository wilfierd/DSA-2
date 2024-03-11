/**
 * SortAlgoComp class implements driver code to 
 * compare different sorting algorithms in term of running time
 *  
 * @author (nxthang) 
 * @version (1.0)
 */
package Topic03.Examples;

import java.util.Random;

public class SortAlgoComp {
  /**
   * Constructor for objects of class SortComparison
   */
  public SortAlgoComp() {      
  }

  public static void printArray(int[] a) {
    for (int i=0; i<a.length; i++) {
       System.out.print(a[i]+" ");
    }        
    System.out.println(" ");
  }    

  public static void copyArray(int[] src, int[] des) {
    for (int i = 0; i < src.length; i++)
        des[i] = src[i];
  }

  public static void compareRunningTime(int n) {
    int[] data = new int[n];
    int[] a = new int[n];

    System.out.println("Generating an array of " + n + " items ...");
    Random rand = new Random(); 
    for (int i=0; i<n; i++) {
      data[i]=rand.nextInt(5000) + 1;
    }
  //  printArray(data);
    
    SortAlgo sortAlgo = new SortAlgo();

    copyArray(data, a);
    System.out.println("Running selection sort ...");
    long startTime, stopTime, elapsedTime;
    startTime=System.currentTimeMillis();
    sortAlgo.selectionSort(a);
    stopTime=System.currentTimeMillis();
    elapsedTime=stopTime - startTime;
    System.out.println("Selection sort took : " + elapsedTime + " milliseconds to finish");

    copyArray(data, a);
    System.out.println("Running insertion sort ...");
    startTime=System.currentTimeMillis();
    sortAlgo.insertionSort(a);
    stopTime=System.currentTimeMillis();
    elapsedTime=stopTime - startTime;
    System.out.println("Insertion sort took : " + elapsedTime + " milliseconds to finish");        

    copyArray(data, a);
    System.out.println("Running bubble sort ...");
    startTime=System.currentTimeMillis();
    sortAlgo.bubbleSort(a);
    stopTime=System.currentTimeMillis();
    elapsedTime=stopTime - startTime;
    System.out.println("Bubble sort took : " + elapsedTime + " milliseconds to finish"); 

    copyArray(data, a);
    System.out.println("Running improved bubble sort ...");
    startTime=System.currentTimeMillis();
    sortAlgo.bubbleSortImproved(a);
    stopTime=System.currentTimeMillis();
    elapsedTime=stopTime - startTime;
    System.out.println("Improved bubble sort took : " + elapsedTime + " milliseconds to finish");        

    copyArray(data, a);
    System.out.println("Running merge sort ...");
    startTime=System.currentTimeMillis();
    sortAlgo.mergeSort(a, 0, a.length - 1);
    stopTime=System.currentTimeMillis();
    elapsedTime=stopTime - startTime;
    System.out.println("Merge sort took : " + elapsedTime + " milliseconds to finish");    

    copyArray(data, a);
    System.out.println("Running quick sort ...");
    startTime=System.currentTimeMillis();
    sortAlgo.quickSort(a, 0, a.length - 1);
    stopTime=System.currentTimeMillis();
    elapsedTime=stopTime - startTime;
    System.out.println("Quick sort took : " + elapsedTime + " milliseconds to finish");    

    copyArray(data, a);
    System.out.println("Running heap sort ...");
    startTime=System.currentTimeMillis();
    sortAlgo.heapSort(a);
    stopTime=System.currentTimeMillis();
    elapsedTime=stopTime - startTime;
    System.out.println("Heap sort took : " + elapsedTime + " milliseconds to finish");      

    copyArray(data, a);
    System.out.println("Running counting sort ...");
    startTime=System.currentTimeMillis();
    sortAlgo.countingSort(a);
    stopTime=System.currentTimeMillis();
    elapsedTime=stopTime - startTime;
    System.out.println("Counting sort took : " + elapsedTime + " milliseconds to finish");      

    copyArray(data, a);
    System.out.println("Running radix sort ...");
    startTime=System.currentTimeMillis();
    sortAlgo.radixSort(a);
    stopTime=System.currentTimeMillis();
    elapsedTime=stopTime - startTime;
    System.out.println("Radix sort took : " + elapsedTime + " milliseconds to finish");          
  }

  public static void main(String[] args) {
    compareRunningTime(100000);
  }
}