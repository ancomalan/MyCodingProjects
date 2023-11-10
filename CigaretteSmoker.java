//alan vo 
//occc fall 2023
//advanced java
//cigarette smoker concurrency program

import java.util.concurrent.Semaphore;


public class CigaretteSmoker {

	static int currentItem = -1; //current item of the table (-1 means nothing is on table and the table is initially empty so initialize to -1)
	static Semaphore tableSemaphore = new Semaphore(1); //there is one table
	static Semaphore agentSemaphore = new Semaphore(0); //used to put agent to sleep in wait queue


	public static void mySleep(){
		// this function puts the thread "to sleep" for a while,
		// to simulate time spent processing 
		try{
			Thread.sleep((int)(Math.random()*1000));
		}
		catch(InterruptedException e){
			// do nothing
		}
	} // close sleep method


	public static void main (String [] args) {
		System.out.println("Welcome to Cigarette Smokers Program!");

		Smoker [] s = new Smoker[3]; //3 smokers
		Agent [] a = new Agent[1]; //1 agent to produce items

		//initialize three smokers first 
		for(int i = 0; i < 3; i++){
			s[i] = new Smoker(i); 
			s[i].start();
			System.out.println("Starting Smoker " + i + "...");
		}

		//initialize agent
		a[0] = new Agent(0);
		a[0].start();
		System.out.println("Agent is running...");
	}


	private static class Agent extends Thread{
		int i;
		public Agent(int i){
			super();
			this.i = i;
		}

		public void run(){
			while(true){
				mySleep();
				System.out.println("Agent is trying to acquire the table...");
				try{
					tableSemaphore.acquire(); //try to acquire the table
					System.out.println("Agent has the table!");
					mySleep();

					//if there is nothing on the table, restock random item with random int (0,1,2)
					//let 0 equal paper, 1 equal matches, and 2 equal tobacco
					if (currentItem == -1) {
						currentItem = (int)(Math.random()*3);
						//use case switch to assign int with correct item
						switch (currentItem){
						case 0: System.out.println("Agent put paper on the table!");
						break;
						case 1: System.out.println("Agent put matches on the table!");
						break;
						case 2: System.out.println("Agent put tobacco on the table!");
						break;
						}
					}
					System.out.println("Agent going to sleep...");
					tableSemaphore.release(); //release the table
					agentSemaphore.acquire(); //put the agent to sleep
				}
				catch(InterruptedException e){}
			}   
		}
	}


	private static class Smoker extends Thread{
		int i;
		public Smoker(int i){
			super();
			this.i = i;
		}

		public void run(){
			while(true){
				mySleep();
				System.out.println("Smoker " + i + " trying to acquire the table...");
				try{
					tableSemaphore.acquire();
					System.out.println("Smoker " + i + " has the table!");
					mySleep();

					int need; //variable to store specific needs of each smoker

					//if smoker 0, they need matches (case 1)
					if (i == 0) {
						need = 1;
						if (currentItem == need) {
							System.out.println("Smoker " + i + " found matches!");
							currentItem = -1; //set table to empty after smoker grabs item
							System.out.println("Smoker " + i + " is smoking...");
							agentSemaphore.release(); //issue a release on agentSemaphore to wake the agent up
							System.out.println("Agent is awake!");
							System.out.println("Agent is running...");
						}
						else {
							System.out.println("Smoker " + i + " didn't find matches...");
							System.out.println("Smoker " + i + " going back to sleep...");
						}
					}

					//if smoker 1, they need tobacco (case 2)
					if (i == 1) {
						need = 2;
						if (currentItem == need) {
							System.out.println("Smoker " + i + " found tobacco!");
							currentItem = -1; //set table to empty after smoker grabs item
							System.out.println("Smoker " + i + " is smoking...");
							agentSemaphore.release(); //issue a release on agentSemaphore to wake the agent up
							System.out.println("Agent is awake!");
							System.out.println("Agent is running...");
						}
						else {
							System.out.println("Smoker " + i + " didn't find tobacco...");
							System.out.println("Smoker " + i + " going back to sleep...");
						}
					}

					//if smoker 2, they need paper (case 0)
					if (i == 2) {
						need = 0;
						if (currentItem == need) {
							System.out.println("Smoker " + i + " found paper!");
							currentItem = -1; //set table to empty after smoker grabs item
							System.out.println("Smoker " + i + " is smoking...");
							agentSemaphore.release(); //issue a release on agentSemaphore to wake the agent up
							System.out.println("Agent is awake!");
							System.out.println("Agent is running...");
						}
						else {
							System.out.println("Smoker " + i + " didn't find paper...");
							System.out.println("Smoker " + i + " going back to sleep...");
						}
					}
					tableSemaphore.release();
				}
				catch(InterruptedException e){}
			}
		}
	} 
}
