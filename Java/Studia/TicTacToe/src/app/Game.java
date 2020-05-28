package app;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {



    public static void main(String[] args) throws Exception {
        Game game = new Game();
        Scanner scr = new Scanner(System.in);
        String name1, name2;
        char mark1, mark2;
        System.out.println("Type in  the name and the mark of Player 1: ");
        name1 = scr.nextLine();
        mark1 = scr.next().charAt(0);
        Player p_1 = new Player(name1, mark1);

        System.out.println("Type in the name and the mark of Player 2: ");
        scr.nextLine();
        name2 = scr.next();
        mark2 = scr.next().charAt(0);
        Player p_2 = new Player(name2, mark2);


        ArrayList<Player> players = new ArrayList<Player>();
        players.add(p_1);
        players.add(p_2);

        boolean FirstPlayerActive = true;

        int x=0, y=0;

        ArrayList<Move> moves = new ArrayList<>();

        Commentary comment = new Commentary(p_1.getName(), p_1.getMark());
        Board playp = new Board(p_1.getMark(), x);
        Move newMove = new Move(x, y);

      for(int rounds = 0; rounds <9; rounds++){
            if(FirstPlayerActive == true ){
                comment.setName(p_1.getName());
                comment.setMark(p_1.getMark());
                playp.setMark(p_1.getMark());

                System.out.println("Give a position X: ");
                x= scr.nextInt();
                System.out.println("Give a position Y: ");
                y= scr.nextInt();
   

                playp.setX(x);
                playp.setY(y);

                newMove.setX(x);
                newMove.setY(y);

                moves.add(newMove);

                FirstPlayerActive = false;
                    }
            else{
                comment.setName(p_2.getName());
                comment.setMark(p_2.getMark());
                playp.setMark(p_2.getMark());

                System.out.println("Give a position X: ");
                x= scr.nextInt();
                System.out.println("Give a position Y: ");
                y= scr.nextInt();

                playp.setX(x);
                playp.setY(y);

                newMove.setX(x);
                newMove.setY(y);

                moves.add(newMove);

                FirstPlayerActive = true;
            }
            comment.printMoves(moves);
            playp.printMoves(moves);
           
      }

      playp.getWinner();

      
       
    }
}