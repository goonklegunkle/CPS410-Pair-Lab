import java.util.Random;
import java.util.Scanner;

public class App{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    Player player = new Player();
    Game game = new Game();

    while(game.won == false){
      System.out.println("Enter an odd integer guess between 1 and 1000\n");
      boolean result = player.attempt_guess(sc.nextInt(), game);
      if(result){
        game.won = true;
      }
    }

    System.out.println("You won!");

    sc.close();
  }
}

class Player{
  int numGuess = 0;

  public boolean attempt_guess(int guess, Game game){
	if(!game.isValidGuess(guess)) {
		return false;
	}
    boolean result = game.check_guess(guess);
    numGuess++;
    return result;
  }
}

class Game{
  final int MIN_VALUE = 1;
  final int MAX_VALUE = 1000;
  int win_value;
  boolean won = false;

  public Game(){
    Random rand = new Random();
    boolean flag = true;
    while(flag){
      win_value = rand.nextInt((MAX_VALUE - MIN_VALUE) + 1) + MIN_VALUE;
      if(win_value % 2 == 1){
        flag = false;
      }
    }
  }
  
  public boolean isValidGuess(int guess) {
	  boolean valid = false;
	  if(guess < MIN_VALUE || guess > MAX_VALUE || guess % 2 == 0){
	      System.out.println("Invalid guess");
	  }
	  else {
		  valid = true;
	  }
	  
	  return valid;
  }

  public boolean check_guess(int guess){
    if(guess == win_value){
      won = true;
      return true;
    }
    else{
      return false;
    }
  }
}
