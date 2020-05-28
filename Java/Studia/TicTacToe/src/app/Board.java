package app;

import java.util.ArrayList;
import java.util.Arrays;

public class Board implements Printable{

    private char mark;
    private int x;
    private int y;
    private char[][] gameBoard = new char[3][5];

    public Board(char mark, int x) {
        this.mark = mark;
        this.x= x;
        this.y= y;


        gameBoard[0][1] = gameBoard[0][3] = '|' ;
        gameBoard[1][1] = gameBoard[1][3] = '|' ;
        gameBoard[2][1] = gameBoard[2][3] = '|' ;
    }

    

    public void printMoves(ArrayList<Move> arr_li){

        gameBoard[x][y] = mark;

        for(int row=0; row <3; row++){
            for(int column=0; column < 5; column ++){
                System.out.print(gameBoard[row][column] );
            }
            System.out.println();
            System.out.println("-------");
        } 

    }

    public void getWinner(){
        String capction = "The winner is player with: ";

        for(int i = 0; i < 3; i++){
                if(gameBoard[i][0] == gameBoard[i][2] && gameBoard[i][0] == gameBoard[i][4]) System.out.println(capction + gameBoard[i][0]);
            
        }

            for(int j = 0; j < 5; j=j+2){
                if(gameBoard[0][j] == gameBoard[1][j] && gameBoard[0][j] == gameBoard[2][j]) System.out.println(capction + gameBoard[0][j]);
        }

        if(gameBoard[0][0] == gameBoard[1][2] && gameBoard[0][0] == gameBoard[2][4]) System.out.println(capction + gameBoard[0][0]);
        else if(gameBoard[0][4] == gameBoard[1][2] && gameBoard[0][4] == gameBoard[2][0]) System.out.println(capction + gameBoard[0][4]);
        
    }

    public char getMark() {
        return mark;
    }

    public void setMark(char mark) {
        this.mark = mark;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }



	public int getY() {
		return y;
	}



	public void setY(int y) {
		this.y = y;
	}

}