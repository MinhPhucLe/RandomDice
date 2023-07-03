package models;

public class BasePlayer {
    String name;
    int point;

    public BasePlayer(String name) {
        this.name = name;
        this.point = 0;
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

    public void addPoint(int point) {
        setPoint(getPoint() + point);
    }

    public String toString() {
        return this.name + ": " + this.getPoint();
    }
}
