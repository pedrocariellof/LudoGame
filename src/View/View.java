package View;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class View {
	
	private Scanner scan;
	private int column, line;
	private char[][] board = new char[33][34];
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_RESET = "\u001B[0m";
	
	public View(String path) throws FileNotFoundException {
		this.scan = ReadFile.readFile(path);
	}
	
	public void printLines() {
		while(scan.hasNextLine()) {
			System.out.println(scan.nextLine());
		}
	}
	
	public void setBoard() throws IOException {
	     FileInputStream entrada = new FileInputStream("./src/View/LudoBoard.txt");
	     InputStreamReader entradaFormatada = new InputStreamReader(entrada);
	     int c = entradaFormatada.read();
	     
	     while( c!=-1){
	    	 char camp = (char) c;
	    	 if(camp == '\n') {
	    		 column++;
	    		 line = 0;
	    	 }
	    	 else {
	    		board[column][line] = camp;
	    		line++;
	    	 }
	      c = entradaFormatada.read();
	     } 
	}
	
	public void printBoard() {
		for (int i = 0; i < 33; i++){
			for(int j = 0; j < 34; j++) {
				if(DecideColor.isRed(i,j)) {
					System.out.print(ANSI_RED + board[i][j] + ANSI_RESET);
				}
				else if(DecideColor.isBlue(i,j)) {
					System.out.print(ANSI_BLUE + board[i][j] + ANSI_RESET);
				}
				else if(DecideColor.isGreen(i,j)) {
					System.out.print(ANSI_GREEN + board[i][j] + ANSI_RESET);
				}
				else if(DecideColor.isYellow(i,j)) {
					System.out.print(ANSI_YELLOW + board[i][j] + ANSI_RESET);
				}
				else {
					System.out.print(board[i][j]);
				}
				
			}
			System.out.println();
		}
	}
}
