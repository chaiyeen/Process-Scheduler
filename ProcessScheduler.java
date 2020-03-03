import java.util.ArrayList;
import java.util.Scanner;

//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P10 Process Scheduler
// Files: CustomProcess, CustomProcessQueue, (ProcessScheduler), ProcessSchedulerTests, WaitingQueueADT
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
 * The ProcessScheduler class represents the data type for the main scheduler for our processes.
 * @author chanwoong Jhon & chaiyeon Oh
 */
public class ProcessScheduler{
  private int currentTime; // stores the current time after the last run
  private int numProcessesRun; // stores the number of processes run so far
  private CustomProcessQueue queue; // this processing unit's custom process queue

  public ProcessScheduler() {
    this.currentTime = 0;
    this.numProcessesRun = 0;
    this.queue = new CustomProcessQueue();
  }
  /**
   * The ProcessScheduler class represents the data type for the main scheduler for our processes. 
   * @param process user data that wants to be processed
   */
  public void scheduleProcess(CustomProcess process) {
    queue.enqueue(process);
  }


  public String run() {
    String firstString = "";
    String secondString = "";
    String thirdString = "";
    String combinedString = "";

    int sizeToRun = 0;
    while (!queue.isEmpty()){
      secondString = secondString + "Time " + currentTime + " : Process ID " + queue.peek().getProcessId() + " Starting.\n";
      currentTime = currentTime + queue.peek().getBurstTime();
      secondString = secondString + "Time " + currentTime + ": Process ID " + queue.peek().getProcessId() + " Completed.\n";

      queue.dequeue();
      numProcessesRun++;
      sizeToRun++;
    }
    firstString = firstString+ "Starting " + sizeToRun + " processes\n\n";    //beginning comment
    thirdString = thirdString+ "\nTime " + currentTime + ": All scheduled processes completed.\n";
    combinedString = firstString+secondString+thirdString;

    return combinedString;
  }
  public int getCurrentTime() {
    return currentTime;
  }
  
  public int getNumProcessesRun() {
    return numProcessesRun;
  }
  
  public static Boolean checkValidCommand(String command) {
    String[] stringArray = command.split(" ");
    ArrayList<String> stringArrayList = new ArrayList<String>();
    stringArrayList.add("run");
    stringArrayList.add("r");
    stringArrayList.add("quit");
    stringArrayList.add("q");

    try {
      if (stringArray.length == 2) {
        if(stringArray[0].equals("schedule") || stringArray[0].equals("s")){
          if(Integer.parseInt(stringArray[1])>0) {
            return true;
          }
          else {
            System.out.print("WARNING: burst time MUST be greater than 0!\n");
            return false;
          }
        }
        else {
          System.out.print("WARNING: Please enter a valid command!\n");
          return false;
        }
      }
      else {
        if(stringArray.length == 1)
          if(stringArrayList.contains(stringArray[0])) {
            return true;
          }
        System.out.print("WARNING: Please enter a valid command!\n");
        return false;
      }
    }
    catch(RuntimeException e) {
      System.out.print("WARNING: Please enter a valid command!\n");
      return false;
    }

  }

  public static void main(String[]args) {
    String command = " ";
    ProcessScheduler main = new ProcessScheduler();
    Scanner scanner = new Scanner(System.in);
    
    System.out.println("==========   Welcome to the SJF Process Scheduler App   ========");
    while (!(command.equals("quit") || command.equals("q"))) {
      System.out.println("\r\n"+"Enter command:\r\n" + "[schedule <burstTime>] or [s <burstTime>]\r\n" + "[run] or [r]\r\n" + "[quit] or [q]\r\n");
      
      command = scanner.nextLine();
      if (checkValidCommand(command)) {

        String[] commandStringArray = command.split(" ");

        if(commandStringArray[0].equals("schedule") || commandStringArray[0].equals("s")) {
          CustomProcess process = new CustomProcess(Integer.parseInt(commandStringArray[1]));
          main.scheduleProcess(process); 
          System.out.print("Process ID "+ process.getProcessId()+" scheduled. Burst Time = "+process.getBurstTime()+"\r\n");
        }
        
        else if(commandStringArray[0].equals("run") ||commandStringArray[0].equals("r")) {
          System.out.print(main.run());
        }
        else {
          System.out.print(main.getNumProcessesRun() + " processes run in " + main.getCurrentTime() + " units of time!\n" + 
"Thank you for using our scheduler!\n" + "Goodbye!\n");
          
        }
      }
    }
  }
}