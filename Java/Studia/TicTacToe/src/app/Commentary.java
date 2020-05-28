package app;
import java.util.ArrayList;


public class Commentary implements Printable {

    private String name;
    private char mark;

    
 
    public Commentary(String name, char mark) {
        this.name = name;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getMark() {
        return mark;
    }

    public void setMark(char mark) {
        this.mark = mark;
    }

    public void printMoves(ArrayList<Move> arr_li){
            System.out.println("Player " + name + " placed a " + mark + " on position: " +   arr_li.get(arr_li.size()-1).getX() + " and " + arr_li.get(arr_li.size()-1).getY());
        
    }


}