/**
 * SortAlgo class implements different sorting algorithms to sort an array of integer items
 * We assume that the sorting order is ascending
 *  
 * @author (nxthang) 
 * @version (1.0)
 */
package Topic03.Examples;

public class SortAlgo {
  /**
  * Constructor for objects of class SortAlgo
  */
  public SortAlgo() {
  }

  // Selection sort algorithm
  public void selectionSort(int[] a) {
    int n = a.length;     
    // After each passs, the boundary of unsorted subarray is moved one step to the right
    for (int step = 0; step < n-1; step++) {
      // Find the minimum element in unsorted array
      int minIndex = step;
      for (int i = step+1; i < n; i++)
        if (a[i] < a[minIndex])
            minIndex = i;
      // Swap to put the found minimum element at correct position
      int tmp = a[step];
      a[step] = a[minIndex];
      a[minIndex] = tmp;
    }
  }

  // Insertion sort algorithm
  public void insertionSort(int[] a) {
    int n = a.length;
    // At the begining the sorted subarray contains the first item
    // The unsorted range is from the second item to the end of the array
    // After each pass, the boundary of the sorted subarray is increased by one 
    for (int i = 1; i < n; ++i) {
      // key is the first item of unsorted subarray
      int key = a[i];
      int j = i - 1;
      // Shifted the items one slot to the right until we find a correct position for key
      while (j >=0 && a[j]>key ) {
        a[j+1] = a[j];
        j --;
      }
      // Put key at its correct position
      a[j+1] = key;
    }
  }

  // Bubble sort algorithm
  public void bubbleSort(int[] a) {
    int n = a.length;
    // Loop to access each array item
    for (int i = 0; i < n-1; ++i)
      // Loop to compare adjacent items 
      for (int j = 0; j < n - i - 1; j++)
        if (a[j] > a[j+1]) {    // Here we find out an out of order pair
          // Swap a[j] and a[j+1]
          int tmp = a[j];
          a[j] = a[j+1];
          a[j+1] = tmp;
        }
  }

  // Improved Bubble sort algorithm
  public void bubbleSortImproved(int[] a) {
      int n = a.length;      
      // Loop to access each array item
      for (int i = 0; i < (n-1); ++i) {
        // Assume that we couldn't find out any out of order pair
        boolean isSorted = true;
        // Loop to compare adjacent items 
        for (int j = 0; j < (n - i - 1); j++)
          if (a[j] > a[j+1]) {    // Here we find out an out of order pair
            // Swap a[j] and a[j+1]
            int tmp = a[j];
            a[j] = a[j+1];
            a[j+1] = tmp;
            isSorted = false;
          }
        // Stop if there is no out of order pair
        if (isSorted)
          break;
      }        
  }

  // Merge sort algorithm
  public void mergeSort(int[] a, int start, int end) {
    if (start < end) {
      int mid = (start + end) / 2;
      mergeSort(a, start, mid);
      mergeSort(a, mid+1, end);
      merge(a, start, mid, end);
    }      
  }    

  // Merge two subarrays of a[].
  // First subarray is a[start..mid]
  // Second subarray is arr[mid+1..end]
  private void merge(int[] a, int start, int mid, int end) {
    // Define a temporary array to store the result
    int[] c = new int[end - start+1];
    // Define two indices index1 and index2
    int index1 = start;
    int index2 = mid+1;    
    // Define the current length of the result array
    int len = 0;
    // First we compare current elements of two subarrays 
    // and copy smaller item into the result array
    while ((index1 <= mid)&&(index2 <= end)) {
      if (a[index1] < a[index2]) {
        c[len]=a[index1];
        index1++;
      }
      else {
        c[len]=a[index2];
        index2++;
      }
      len++;
    }        

    // Then we copy all remaining items of non-empty subarray to the result array
    for (int i = index1; i <= mid; i++) {
      c[len]=a[i];
      len++;
    }
    
    for (int i = index2; i <= end; i++) {
      c[len]=a[i];
      len++;
    }        

    // We copy items from the temporary result array back to array a
    for (int i = 0; i < len; i++) {
      a[start + i] = c[i];
    }        
  }    

  public int partition(int[] a, int left, int right) {
    // choose the rightmost element as pivot
    int pivot = a[right];

    // pointer for greater element
    int index2 = left;

    // traverse through all elements
    // compare each element with pivot
    for (int index3 = left; index3 < right; index3++) {
      if (a[index3] < pivot) {

        // if element smaller than pivot is found
        // swap it with the greatr element pointed by index2
        int temp = a[index2];
        a[index2] = a[index3];
        a[index3] = temp;

        // set index2 to the next greater element
        index2++;
      }
    }

    // swapt the pivot element with the greater element specified by index2
    int temp = a[index2];
    a[index2] = a[right];
    a[right] = temp;

    // return the position from where partition is done
    return index2;
  }
  
  public void quickSort(int[] a, int left, int right) {
    if (left < right) {
      // find pivot element such that
      // elements smaller than pivot are on the left
      // elements greater than pivot are on the right
      int pivotIndex = partition(a, left, right);

      // recursive call on the left of pivot
      quickSort(a, left, pivotIndex - 1);

      // recursive call on the right of pivot
      quickSort(a, pivotIndex + 1, right);
    }
  }  

  public void heapSort(int[] a) {
    int n = a.length;

    // Build max heap
    for (int i = n / 2 - 1; i >= 0; i--) {
      heapify(a, n, i);
    }   

    // Heap sort
    for (int i = n - 1; i >= 0; i--) {
      // Swap the root element with the ith item of the array
      int temp = a[0];
      a[0] = a[i];
      a[i] = temp;

      // Heapify the array a[0..i]
      heapify(a, i, 0);
    }    
  }

  public void heapify(int[] a, int size, int rootIndex) {
    // Find largest among root, left child and right child
    int largest = rootIndex;
    int leftChild = 2 * rootIndex + 1;
    int rightChild = 2 * rootIndex + 2;

    if ((leftChild < size) && (a[leftChild] > a[largest]))
      largest = leftChild;
    
    if ((rightChild < size) && (a[rightChild] > a[largest]))
      largest = rightChild;

    // Swap and continue heapifying if root is not largest
    if (largest != rootIndex) {
      int temp = a[rootIndex];
      a[rootIndex] = a[largest];
      a[largest] = temp;
      heapify(a, size, largest);
    }    
  }  

  public void countingSort(int[] a) {
    int n = a.length;

    // Find the largest element of the array
    int max = a[0];
    for (int i = 1; i < n; i++) {
      if (a[i] > max)
        max = a[i];
    }

    int[] count = new int[max + 1];
    int[] output = new int[n];

    // Initialize count array with all zeros.
    for (int i = 0; i <= max; ++i) {
      count[i] = 0;
    }    

    // Store the count of each element
    for (int i = 0; i < n; i++) {
      count[a[i]]++;
    }    
    // Calculate the cumulative count of each array
    for (int i = 1; i <= max; i++) {
      count[i] += count[i - 1];
    }   

    // Find the index of each element of the original array in count array, and
    // place the elements in output array
    for (int i = n - 1; i >= 0; i--) {
      count[a[i]]--;
      output[count[a[i]]] = a[i];      
    }

    // Copy the sorted elements into original array
    for (int i = 0; i < n; i++) {
      a[i] = output[i];
    }    
  }

  /**
   * This method calculates the place value an integer x, where the place can be 1, 10, 100, 1000 ...
   * For example, getDigit(549,1) returns 9, getDigit(549,10) retunrs 4, and getDigit(549,100) returns 5.
   * The following formula is used to find the place value of an integer x:
   *          getDigit(x,place) = (x / place) % 10
   * @author (nxthang) 
   * @version (1.0)
   */
  public static int getDigit(int x, int place) {
    return (x / place) % 10;
  }

  // This method returns the largest element of the input array
  public static int getMaxArray(int[] a) {
    int n = a.length;
    int max = a[0];
    for (int i = 1; i < n; i++)
      if (a[i] > max)
        max = a[i];
    return max;
  }

  /**
   * This method sorts the array based on the place value, where the place can be 1, 10, 100, 1000 ...
   * For example, if input array a = [329,457,657,839,436,720,355]. 
   * The result of columnSort(a,1) will be:
   *      a = [720,355,436,457,657,329,839]
   * Or the result of columnSort(a,10) will be:
   *      a = [329,720,839,436,457,657,355]
   * Counting sort algorithm is used as a stable sort method (with max=9 because the range of elements
   * in counting sort is 0..9).     
   * 
   * @author (nxthang) 
   * @version (1.0)
   */
  
  public static void columnSort(int[] a, int place) {
    int n = a.length;
    int[] count = new int[10];
    int[] output = new int[n];

    // Initialize count array with all zeros.
    for (int i = 0; i <= 9; ++i) {
      count[i] = 0;
    }    

    // Store the count of each element
    for (int i = 0; i < n; i++) {
      int digit = getDigit(a[i], place);
      count[digit]++;
    }    
    // Calculate the cumulative count of each array
    for (int i = 1; i <= 9; i++) {
      count[i] += count[i - 1];
    }   

    // Find the index of each element of the original array in count array, and
    // place the elements in output array
    for (int i = n - 1; i >= 0; i--) {
      int digit = getDigit(a[i], place);
      count[digit]--;
      output[count[digit]] = a[i];      
    }

    // Copy the sorted elements into original array
    for (int i = 0; i < n; i++) {
      a[i] = output[i];
    }    
  }
  
  public static void radixSort(int[] a) {   
    // Find the largest element of the array
    int max = getMaxArray(a);
    
    // Apply column sort to sort elements based on place value.
    for (int place = 1; max / place > 0; place *= 10)
      columnSort(a, place);    
  }
  
}