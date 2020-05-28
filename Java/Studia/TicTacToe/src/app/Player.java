package app;

public class Player {
    private String name;
    private char mark;

    public Player(String name, char mark) {
        this.name = name;
        this.mark = mark;
    }

    public char getMark() {
        return mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMark(char mark) {
        this.mark = mark;
    }
    

}