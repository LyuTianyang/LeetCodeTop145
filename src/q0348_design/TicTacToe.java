package q0348_design;
/**
You may assume the following rules:

A move is guaranteed to be valid and is placed on an empty block.
Once a winning condition is reached, no more moves is allowed.
A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.
Example:
Given n = 3, assume that player 1 is "X" and player 2 is "O" in the board.

TicTacToe toe = new TicTacToe(3);

toe.move(0, 0, 1); -> Returns 0 (no one wins)
|X| | |
| | | | // Player 1 makes a move at (0, 0).
| | | |

toe.move(0, 2, 2); -> Returns 0 (no one wins)
|X| |O|
| | | | // Player 2 makes a move at (0, 2).
| | | |

toe.move(2, 2, 1); -> Returns 0 (no one wins)
|X| |O|
| | | | // Player 1 makes a move at (2, 2).
| | |X|

toe.move(1, 1, 2); -> Returns 0 (no one wins)
|X| |O|
| |O| | // Player 2 makes a move at (1, 1).
| | |X|

toe.move(2, 0, 1); -> Returns 0 (no one wins)
|X| |O|
| |O| | // Player 1 makes a move at (2, 0).
|X| |X|

toe.move(1, 0, 2); -> Returns 0 (no one wins)
|X| |O|
|O|O| | // Player 2 makes a move at (1, 0).
|X| |X|

toe.move(2, 1, 1); -> Returns 1 (player 1 wins)
|X| |O|
|O|O| | // Player 1 makes a move at (2, 1).
|X|X|X|
Follow up:
Could you do better than O(n^2) per move() operation?

Hint:

Could you trade extra space such that move() operation can be done in O(1)?
You need two arrays: int rows[n], int cols[n], plus two variables: diagonal, anti_diagonal.
 */
public class TicTacToe {
	
	int[] rows;
	int[] cols;
	int dc1;
	int dc2;
	int n;
	
	public TicTacToe(int n){
		this.n = n;
		this.rows = new int[n];
		this.cols = new int[n];
	}
	
	public int move(int row, int col, int player){
		int val = player==1 ? 1:-1;
		rows[row]+=val;
		cols[col]+=val;
		
		if(row==col){
			dc1+=val;
		}
		if(col==n-row-1){
			dc2+=val;
		}
		if(Math.abs(rows[row])==n || Math.abs(cols[col])==n
				|| Math.abs(dc1)==n || Math.abs(dc2)==n){
			return player;
		}
		
		return 0;
	}
}