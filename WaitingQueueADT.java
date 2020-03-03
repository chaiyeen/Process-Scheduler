//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P10 Waiting Queue ADT
// Files: CustomProcess, CustomProcessQueue, ProcessScheduler, ProcessSchedulerTests, (WaitingQueueADT)
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


/**
 * This interface define the Abstract Data Type that represents the pattern for our ready processes waiting list.
 * @author chanwoong Jhon & chaiyeon Oh
 *
 * @param <T> MUST be a generic interface
 */
public interface WaitingQueueADT<T extends Comparable<T>> {

  public void enqueue(T newObject); // inserts a newObject in the priority queue

  public T dequeue(); // removes and returns the item with the highest priority

  public T peek(); // returns without removing the item with the highest priority

  public int size(); // returns size of the waiting queue

  public boolean isEmpty(); // checks if the waiting queue is empty
}