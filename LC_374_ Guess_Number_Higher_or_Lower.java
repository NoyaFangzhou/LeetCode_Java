/**
 *
 * Block commentWe are playing the Guess Game. The game is as follows:
 *
 * I pick a number from 1 to n. You have to guess which number I picked.
 *
 * Every time you guess wrong, I'll tell you whether the number is higher or lower.
 *
 * You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
 *
 * -1 : My number is lower
 * 1 : My number is higher
 * 0 : Congrats! You got it!
 *
 * Example:
 * n = 10, I pick 6.
 * Return 6.
 *
 */

/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return 6r, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {// from 1 to n

        int left = 1;
        int right = n;
        int myGuess = 1;
        while((right - left)>1) {
            myGuess = left + (right-left)/2;
            if(guess(myGuess) > 0) { //lower myGuess < correct
                left = myGuess+1;
            }
            else if(guess(myGuess) < 0) { //higher myGuess > correct
                right = myGuess;
            }
            else if(guess(myGuess) == 0) {
                return myGuess;
            }
        }
        return guess(left)<=0?left:right;
    }
    
}