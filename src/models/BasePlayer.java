package models;

public class BasePlayer {
    String name;
    int point;

    boolean win;
    boolean lose;

    public BasePlayer(String name) {
        this.name = name;
        this.point = 0;
        this.win = false;
        this.lose = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public boolean isLose() {
        return lose;
    }

    public void setLose(boolean lose) {
        this.lose = lose;
    }

    public void addPoint(int point) {
        setPoint(getPoint() + point);
    }

    public String toString() {
        return this.name + ": " + this.getPoint();
    }
}
