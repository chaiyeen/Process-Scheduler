//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P10 Waiting Queue ADT
// Files: CustomProcess, (CustomProcessQueue), ProcessScheduler, ProcessSchedulerTests, WaitingQueueADT
// Course:CS300, Fall2018        
//
// Author: ChanWoong Jhon
// Email:  cjhon@wisc.edu
// Lecturer's Name: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:  Chaiyeen Oh
// Partner Email:  coh26@wisc.edu
// Partner Lecturer's Name: Mouna Kacem
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   X  Write-up states that pair programming is allowed for this assignment.
//   X  We have both read and understand the course Pair Programming Policy.
//   X  We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates, 
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Persons: None
// Online Sources: None
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

public class CustomProcessQueue implements WaitingQueueADT<CustomProcess>{
  private static final int INITIAL_CAPACITY = 20; // the initial capacity of the heap
  private CustomProcess[] heap ; // array-based min heap storing the data. This is an oversize array
  private int size; // number of CustomProcesses present in this CustomProcessQueue


  public CustomProcessQueue(){
    heap = new CustomProcess[INITIAL_CAPACITY];
  }



  private void minHeapPercolateUp(int index) { 
    int parentIndex;
    CustomProcess temp = null;  //temporary value to change 

    while (index>=2) { //because index starts from 1.
      parentIndex = (index)/2;
      if(heap[index].compareTo(heap[parentIndex]) == 0) //when size is same
        return;
      else if (heap[index].compareTo(heap[parentIndex]) == 1)    //when index is bigger than parent
        return;
      else {        //when index is smaller than parent 
        temp = heap[index];
        heap[index] = heap[parentIndex];
        heap[parentIndex] = temp;
      }
    }
  }

  private void minHeapPercolateDown(int index) {
    CustomProcess temp;
    int minChildIndex; 
  
      if(index * 2 + 1 > size)  {      //checking right child index works/
        if(index * 2 == size) {     // want to check if left child exists
          minChildIndex = index*2;
        }
        else {
         return;
        }
      }
    // until left child index works // really right child exists
      
      else {                                    
        if (heap[index*2].compareTo(heap[index*2+1])==-1)
          minChildIndex = index*2;

        else {
          minChildIndex = index*2+1;
        }
      
    }
    if(heap[index].compareTo(heap[minChildIndex]) ==-1) {
      return;
    }
    else {
      temp = heap[index];
      heap[index] = heap[minChildIndex];
      heap[minChildIndex] = temp;
    }
    minHeapPercolateDown(minChildIndex);
  }

  
  @Override
  public void enqueue(CustomProcess newObject) {
    int i;
    size++;

    if (isEmpty())
      heap[size] = newObject;
    else {
      if (size >= INITIAL_CAPACITY) {
        heap = new CustomProcess[INITIAL_CAPACITY];
        CustomProcess[] temp = new CustomProcess[ 2*(this.size()-1)];   //double the size of the heap.
        for(i = 0; i< size; i++ ) {
          temp[i] = heap[i];
        }
        heap = temp;
      }
      heap[size] = newObject;
      minHeapPercolateUp(size);
    }
  }

  @Override
  public CustomProcess dequeue() {
    CustomProcess returnVal = heap[1];
    heap[1] = heap[size];
    heap[size] = null;
    size--;
    minHeapPercolateDown(1);
    
    return returnVal;
  }

  @Override
  public CustomProcess peek() {
    return heap[1];
  }

  /**
   * check the size of array
   * @return the size of the queue.
   */
  @Override
  public int size() {
    return size;
  }

  /**
   * check is the queue empty
   * @return true when the queue is empty. else, return false.
   */
  @Override
  public boolean isEmpty() {
    if(heap[1] == null)
      return true;
    else
      return false;
  }

  /**
   * return the hape of this queue
   * @return heap, where the data is loaded
   */
  public CustomProcess[] getHeap() {
    return heap;
  }

}
