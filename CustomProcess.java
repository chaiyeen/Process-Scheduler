//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P10 Waiting Queue ADT
// Files: (CustomProcess), CustomProcessQueue, ProcessScheduler, ProcessSchedulerTests, WaitingQueueADT
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
 * This represents the data of CustomProcess of each process
 * @author chanwoong Jhon & chaiyeon Oh
 *
 */
public class CustomProcess implements Comparable<CustomProcess>{
  private static int nextProcessId = 1; // stores the id to be assigned to the next process 
                                        // to be created
  private final int PROCESS_ID; // unique identifier for this process
  private int burstTime; // time required by this process for CPU execution
  
  /**
   * Generate a CustomProcess with a burstTime
   * @param burstTime time required by this process for CPU execution
   */
  public CustomProcess(int burstTime) {
    PROCESS_ID = nextProcessId;
    this.burstTime = burstTime;
    nextProcessId ++;    
  }

  @Override
  public int compareTo(CustomProcess other) {
    if (this.getBurstTime() <other.getBurstTime()) {
      return -1; 
    }
    else if(this.getBurstTime() == other.getBurstTime())
      if (this.getProcessId()>= other.getProcessId())
        return 1;
      else
        return -1;
    else
      return 1;
  }
  
  /**
   * Retrieve the local private element PORCESS_ID
   * @return PROCESS_ID, which is the unique identifier for this process
   */
  public int getProcessId() {
    return this.PROCESS_ID;
  }

  /**
   * Retrieve the local private element burstTime
   * @return burstTime, which is the time required by this process for CPU execution
   */
  public int getBurstTime() {
    return this.burstTime;
  }

}
