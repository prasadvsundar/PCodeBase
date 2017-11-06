package com.codebase.thread;

public class MultiThreadTest {
	public static void main(String[] args) {
		  Ball gameBall = new Ball();
		  Runnable playerOne = new Player("Pasha", gameBall);
		  Runnable playerTwo = new Player("Maxi", gameBall);
		  Runnable Prasad = new Player("Prasad", gameBall);
		  Runnable Prasad1 = new Player("Prasad1", gameBall);
		  Runnable Prasad2 = new Player("Prasad2", gameBall);

		  new Thread(playerOne).start();
		  new Thread(playerTwo).start();
		  new Thread(Prasad).start();
		  new Thread(Prasad1).start();
		  new Thread(Prasad2).start();
		 }

		}

		 class Player implements Runnable {

		 private final String name;
		 private final Ball ball;

		 public Player(String aName, Ball aBall) {
		  name = aName;
		  ball = aBall;
		 }

		 @Override
		 public void run() {
		  while(true) {
		   ball.kick(name);
		   try {
			   synchronized (this) {
				   wait(10);
			}
			   
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   System.out.println(ball.getLog());
		  }
		 }

		}

		class Ball {

		private String log;

		 public Ball() {
		  log = "";
		 }

		 //Removing the synchronized keyword will cause a race condition.
		 public synchronized void kick(String aPlayerName) {
		  log = aPlayerName;
		 }

		 public String getLog() {
		  return log;
		 }

		}