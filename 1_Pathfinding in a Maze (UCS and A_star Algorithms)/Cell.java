import java.util.Random;

class Cell {
    private int value=0;
    private boolean isFree;  //E;an einai free 1 alliws 0
    private int x=0;
    private int y=0;
    private boolean visited=false; //
    int[][] neighbors = new int[8][2];
    double D = 0;//teleytaio bhma toy path
    double path = 0;
    Cell parent ;// level


    public Cell(int value, int x, int y, boolean isFree) {
        this.value = value;
        this.isFree = isFree;
        this.x = x;
        this.y = y;
        neighbors[0][0] = x - 1;
        neighbors[0][1] = y - 1;
        neighbors[1][0] = x - 1;
        neighbors[1][1] = y;
        neighbors[2][0] = x + 1;
        neighbors[2][1] = y + 1;
        neighbors[3][0] = x;
        neighbors[3][1] = y + 1;
        neighbors[4][0] = x + 1;
        neighbors[4][1] = y + 1;
        neighbors[5][0] = x + 1;
        neighbors[5][1] = y;
        neighbors[6][0] = x + 1;
        neighbors[6][1] = y - 1;
        neighbors[7][0] = x;
        neighbors[7][1] = y - 1;

    }

    public int getValue() {
        return value;
    }

    public void setValue(int k) {
        value = k;
    }

    public boolean getIsFree() {
        return isFree;
    }

    public void setIsFree(boolean k) {
        isFree = k;
    }

    public int getX() {
        return x;
    }
    public void setX(int x){
        this.x=x;
    }

    public int getY() {
        return y;
    }
    public void setY(int x){
        this.y=y;
    }
    public double getPath() {
        return path;
    }

    public void setPath(double k) {
        path = k;
    }

    public Cell getParent() {
        return parent;
    }

    public void setParent(Cell k) {
        parent = k;
    }

    public double getD() {
        return D;
    }

    public void setD(double k) {
        D = k;
    }
    public boolean getVisited() {
        return visited;
    }

    public void setVisited(boolean k) {
        visited = k;
    }
}
