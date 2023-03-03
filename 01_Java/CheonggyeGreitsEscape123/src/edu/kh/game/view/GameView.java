package edu.kh.game.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import edu.kh.game.service.Service;


public class GameView {
   
   private Scanner sc = new Scanner(System.in);
   private Service gameService = new Service();
   public void zom() {
	   
	   	
	      gameService.status();
	      System.out.println("------------------------------");
	      gameService.save();
	      gameService.start();
	     
	      System.out.println("------------------------------");
	      gameService.status();
	     
	      gameService.load();
	      System.out.println("------------------------------");
	      gameService.status();
	      
	      System.out.println("------------------------------");
	      
	      System.out.println("------------------------------");
	      gameService.status();
	      
	      System.out.println("------------------------------");
	      gameService.load();
	      System.out.println("------------------------------");
	      
		  
   }
}