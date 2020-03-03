//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P10 Process Scheduler Tests
// Files: CustomProcess, CustomProcessQueue, ProcessScheduler, (ProcessSchedulerTests), WaitingQueueADT
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

public class ProcessSchedulerTests{

  /**
   * checks the correctness of the MinHeapPercolateUp. operation implemented in the CustomProcessQueue class
   * @return true when MinHeapPercolateUp works. else, return false.
   */
  public static boolean testPeekCustomProcessQueue(){
    CustomProcess p1 = new CustomProcess(3);
    CustomProcess p2 = new CustomProcess(2);
    CustomProcess p3 = new CustomProcess(4);
    
    CustomProcessQueue t1 = new CustomProcessQueue();
    t1.enqueue(p1);
    t1.enqueue(p2);
    t1.enqueue(p3);
    
    if (t1.peek().getBurstTime() == 2)
      return true;
    else
    return false;
  }

  /**
   * checks the correctness of the MinHeapPercolateDown. operation implemented in the CustomProcessQueue class
   * @return true when MinHeapPercolateDown works. else, return false.
   */
  public static boolean testSizeCustomProcessQueue(){
    CustomProcess p1 = new CustomProcess(3);
    CustomProcess p2 = new CustomProcess(2);
    CustomProcess p3 = new CustomProcess(4);
    
    CustomProcessQueue t1 = new CustomProcessQueue();
    t1.enqueue(p1);
    t1.enqueue(p2);
    t1.enqueue(p3);
    
    if (t1.size() ==3)
      return true;
    else
    return false;
  } 



  /**
   * checks the correctness of the enqueue. operation implemented in the CustomProcessQueue class
   * @return true when enque works. else, return false.
   */
  public static boolean testEnqueueCustomProcessQueue(){
    CustomProcess p1 = new CustomProcess(3);
    CustomProcess p2 = new CustomProcess(2);
    CustomProcess p3 = new CustomProcess(4);
    
    CustomProcessQueue t1 = new CustomProcessQueue();
    t1.enqueue(p1);
    t1.enqueue(p2);
    t1.enqueue(p3);
    
    if( t1.getHeap()[1] == p2)
      if(t1.getHeap()[2] == p1)
        if(t1.getHeap()[3] == p3)
          return true;

    return false;
  } 

  /**
   *  checks the correctness of the dequeue. operation implemented in the CustomProcessQueue class
   * @return true whendequeue works. else, return false.
   */
  public static boolean testDequeueCustomProcessQueue(){
    CustomProcess p1 = new CustomProcess(1);
    CustomProcess p2 = new CustomProcess(2);
    CustomProcess p3 = new CustomProcess(3);
    CustomProcess p4 = new CustomProcess(4);
    CustomProcess p5 = new CustomProcess(5);
    CustomProcess p6 = new CustomProcess(6);
    CustomProcess p7 = new CustomProcess(7);
    
    CustomProcessQueue t1 = new CustomProcessQueue();
    t1.enqueue(p1);
    t1.enqueue(p2);
    t1.enqueue(p3);
    t1.enqueue(p4);
    t1.enqueue(p5);
    t1.enqueue(p6);
    t1.enqueue(p7);

    if (t1.dequeue().getBurstTime() ==1)
      if (t1.dequeue().getBurstTime() ==2)
        if (t1.dequeue().getBurstTime() ==3)
          if (t1.dequeue().getBurstTime() ==4)
             return true;
    return false;
     } 

  public static boolean testDequeueCustomProcessQueue1(){
    CustomProcess p1 = new CustomProcess(5);

    CustomProcess p3 = new CustomProcess(3);
    CustomProcess p4 = new CustomProcess(7);
   
    
    CustomProcessQueue t1 = new CustomProcessQueue();
    t1.enqueue(p1);

    t1.enqueue(p3);
    t1.enqueue(p4);
    

    if (t1.dequeue().getBurstTime() ==3)
      if (t1.dequeue().getBurstTime() ==5)
        if (t1.dequeue().getBurstTime() ==7)
            return true;
    return false;
     } 

  
  public static void main(String[]args) {
    System.out.println("testPeekCustomProcessQueue is " + testPeekCustomProcessQueue());
    System.out.println("testSizeCustomProcessQueue is " + testSizeCustomProcessQueue());
    System.out.println("testEnqueueCustomProcessQueue is " + testEnqueueCustomProcessQueue());
    System.out.println("testDequeueCustomProcessQueue is " + testDequeueCustomProcessQueue());
    System.out.println("testDequeueCustomProcessQueue is " + testDequeueCustomProcessQueue1());
  }
}