package application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.event.ActionEvent;
import javafx.scene.text.*;
import javafx.scene.layout.VBox;


/**
 * Contains all functions of the TicTacToe board.
 * @author Grace Barton.
 */
public class BoardFunctions{
	
	/**
	 * This represents the TicTacToe board as an array.
	 */
	String [] arr= {" "," "," "," "," "," "," "," "," "};
	
	/**
	 * This represents player one's character on board.
	 */
	String p1="X";
	
	/**
	 * This represents player two's character on board.
	 */
	String p2="O";
	
	/**
	 * This keeps track of the games played.
	 */
	int games=1;
	
	/**
	 * This keeps track of which player's turn it is.
	 */
	int turn=1;
	
	/**
	 * Player one's wins.
	 */
	int wins1=0;
	
	/**
	 * Player two's wins.
	 */
	int wins2=0;
		
	
	/**
	 * Connects to fxml and represents one buttons on TicTacToe board.
	 */
	@FXML
	private Button btn1;
	
	/**
	 * Connects to fxml and represents one buttons on TicTacToe board.
	 */
	@FXML
	private Button btn2;
	
	/**
	 * Connects to fxml and represents one buttons on TicTacToe board.
	 */
	@FXML
	private Button btn3;
	
	/**
	 * Connects to fxml and represents one buttons on TicTacToe board.
	 */
	@FXML
	private Button btn4;
	
	/**
	 * Connects to fxml and represents one buttons on TicTacToe board.
	 */
	@FXML
	private Button btn5;
	
	/**
	 * Connects to fxml and represents one buttons on TicTacToe board.
	 */
	@FXML
	private Button btn6;
	
	/**
	 * Connects to fxml and represents one buttons on TicTacToe board.
	 */
	@FXML
	private Button btn7;
	
	/**
	 * Connects to fxml and represents one buttons on TicTacToe board.
	 */
	@FXML
	private Button btn8;
	
	/**
	 * Connects to fxml and represents one buttons on TicTacToe board.
	 */
	@FXML
	private Button btn9;
	
	/**
	 * Connects to fxml and represents one buttons on TicTacToe board.
	 */
	@FXML
	private VBox player1;
	
	/**
	 * Connects to fxml and represents one buttons on TicTacToe board.
	 */
	@FXML
	private VBox player2;
	
	/**
	 * Connects to fxml and represents one buttons on TicTacToe board.
	 */
	@FXML
	private Text words;
	
	/**
	 * Connects to fxml and represents one buttons on TicTacToe board.
	 */
	@FXML
	private Text play1;
	
	/**
	 * Connects to fxml and represents one buttons on TicTacToe board.
	 */
	@FXML
	private Text play2;
	
	
	/**
	 * Updates the array board.
	 * @param index gives the index of the board array to be updated.
	 * @param sym gives the symbol to use at the indicated index.
	 */
	public void updateBoard(int index, String sym) {
		arr[index]=sym;
	}
	
	
	/**
	 * resets the board and all scores.
	 */
	public void newGame() {
		games=0;
		wins1=0;
		wins2=0;
		play1.setText("Player 1- Wins: "+wins1);
		play2.setText("Player 2- Wins: "+wins2);
		words.setText(" ");
		clearBoard();
	}
	
	
	/**
	 * resets board but leaves player scores visible.
	 */
	public void clearBoard() {
		incGame();
		
		words.setText(" ");
		
		for(int i=0;i<9;i++) {
			arr[i]=" ";
			
			
			
		}
		btn1.setText(" ");
		btn2.setText(" ");
		btn3.setText(" ");
		btn4.setText(" ");
		btn5.setText(" ");
		btn6.setText(" ");
		btn7.setText(" ");
		btn8.setText(" ");
		btn9.setText(" ");
		
		enableButtons(false);
		
		
	}
	
	
	/**
	 * enables or disables the buttons on the TicTacToe board.
	 * @param val is the boolean value determining whether or not the buttons are enabled.
	 */
	public void enableButtons(boolean val) {
		btn1.setMouseTransparent(val);
		btn2.setMouseTransparent(val);
		btn3.setMouseTransparent(val);
		btn4.setMouseTransparent(val);
		btn5.setMouseTransparent(val);
		btn6.setMouseTransparent(val);
		btn7.setMouseTransparent(val);
		btn8.setMouseTransparent(val);
		btn9.setMouseTransparent(val);
	}
	
	
	/**
	 * Determines which players turn it is.
	 */
	public void playerUp() {
		if(turn==1) {
			turn=2;
		}
		else {
			turn=1;
		}
	}
	
	
	/**
	 * Keeps track of the number of games played.
	 */
	public void incGame() {
		games++;
		
	}
	

	
	/**
	 * This places the appropriate character on the board, disables buttons, checks for a win, updates player.
	 * @param evt the button that was clicked.
	 */
	public void place(ActionEvent evt) {
		String symbol;
		
		Button btn=(Button)evt.getSource();
		if(turn==1) {
			btn.setTextFill(Color.LIMEGREEN);
			btn.setText(p1);
			symbol=p1;
		}
		else {
			btn.setTextFill(Color.ORANGE);
			btn.setText(p2);
			symbol=p2;
		}
		
		btn.setMouseTransparent(true);
		
		switch(btn.getId()) {
			case "btn1":{
				updateBoard(0, symbol);
				break;
			}
			case "btn2":{
				updateBoard(1, symbol);
				break;
			}
			case "btn3":{
				updateBoard(2, symbol);
				break;
			}
			case "btn4":{
				updateBoard(3, symbol);
				break;
			}
			case "btn5":{
				updateBoard(4, symbol);
				break;
			}
			case "btn6":{
				updateBoard(5, symbol);
				break;
			}
			case "btn7":{
				updateBoard(6, symbol);
				break;
			}
			case "btn8":{
				updateBoard(7, symbol);
				break;
			}
			case "btn9":{
				updateBoard(8, symbol);
				break;
			}
			
			
		}
		
		checkWin();
				
		playerUp();
		highlightPlayer();
		
	}
	
	
	
	/**
	 * checks all possible wins and sees if one exists.
	 * @return whether a win exists or not.
	 */
	public boolean checkWin() {
		boolean [] w= {winHelper(0,1,2),winHelper(3,4,5),winHelper(6,7,8),winHelper(0,3,6),winHelper(1,4,7),winHelper(2,5,8),winHelper(0,4,8),winHelper(2,4,6)};
		
		
		
		for(int i=0;i<w.length;i++) {
			if(w[i]==true) {
				enableButtons(true);
				displayWin();
				
				return true;
			}
		}
		
		
				
		return false;
		
		
	}
	
	
	/**
	 * helper method for checkWin takes three indexes to check if they all contain the same character.
	 * @param in1 first index in possible TicTacToe win.
	 * @param in2 second index in possible TicTacToe win.
	 * @param in3 third index in possible TicTacToe win.
	 * @return whether or not a win exists
	 */
	public boolean winHelper(int in1, int in2, int in3) {
		if(arr[in1]==arr[in2]&&arr[in1]==arr[in3]&&arr[in1]=="X") {
			wins1++;
			return true;
		}
			
		else if(arr[in1]==arr[in2]&&arr[in1]==arr[in3]&&arr[in1]=="O"){
				wins2++;
				return true;
		}
		
			return false;
	
		
	}
	
	
	
	/**
	 * highlights the current player.
	 */
	public void highlightPlayer() {
		if(turn==1) {
			player1.setStyle("-fx-background-color:white;");
			player2.setStyle("-fx-background-color:black;");
		}
		else {
			player2.setStyle("-fx-background-color:white;");
			player1.setStyle("-fx-background-color:black;");
		}
		
	}
	
	
	/**
	 * exits the program.
	 */
	public void exit() {
		System.exit(0);
	}
	
	
	/**
	 * prints the score of each player in the score area.
	 */
	public void displayWin() {
		
		if(turn==1) {
			play1.setText("Player 1- Wins: "+wins1);
			words.setText("Player 1 won that round!");
		}
		else {
			play2.setText("Player 2- Wins: "+wins2);
			words.setText("Player 2 won that round!");
		}
	}

}