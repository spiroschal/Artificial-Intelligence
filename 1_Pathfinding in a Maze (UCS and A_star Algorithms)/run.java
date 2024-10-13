import java.io.*;
import java.util.*;

class run {

    private Cell lll;

    private Board myBoard;

    public run(Board myboard) {
        this.myBoard = myboard;

    }

    public ArrayList<Cell> ucs() {
        ArrayList<Cell> opened = new ArrayList<Cell>();
        Cell a;
        Cell min = myBoard.entryCell();
        myBoard.entryCell().setPath(0);
        //Cell[] finish = new Cell[(myBoard.getN() * myBoard.getN())];
        ArrayList<Cell> finish=new ArrayList<Cell>();
        //Cell[] finish=new Cell[1500];
        lll = myBoard.entryCell();
        int n = (int) (myBoard.getN() * (myBoard.getN()));
        myBoard.entryCell().setVisited(true);
        for (int q = 0; q < myBoard.getNeighborsOfCell(myBoard.entryCell()).length; q++) {
            if (myBoard.getNeighborsOfCell(min)[q].getVisited() == false) {
                if (myBoard.getNeighborsOfCell(min)[q].getIsFree()) {
                    opened.add(myBoard.getNeighborsOfCell(myBoard.entryCell())[q]);
                    myBoard.calculateD(myBoard.entryCell(), myBoard.getNeighborsOfCell(myBoard.entryCell())[q]);
                    double x = myBoard.calculatePath(myBoard.entryCell(), myBoard.getNeighborsOfCell(myBoard.entryCell())[q]);
                    myBoard.getNeighborsOfCell(myBoard.entryCell())[q].setPath(x);
                    myBoard.getNeighborsOfCell(myBoard.entryCell())[q].setVisited(true);
                }
            }
            myBoard.getNeighborsOfCell(myBoard.entryCell())[q].setParent(myBoard.entryCell());


            /*System.out.print(opened.get(q).getValue() + " ");
            System.out.print(opened.get(q).getD() + " ");
            System.out.print(opened.get(q).getPath() + " ");
            System.out.println();*/
        }


        a = myBoard.entryCell();
        boolean x = false;
        int break_counter = 0;

        //for (int u = 0; u < opened.size(); u++) {
          //  System.out.print(opened.get(u).getValue() + "(" + opened.get(u).getX() + " " + opened.get(u).getY() + ", " + opened.get(u).getPath() + " parent " + opened.get(u).getParent().getValue() + ") ");
        //}
        //System.out.println();
        int ext=1;
        while (!((min.getX() == myBoard.getG1x() && min.getY() == myBoard.getG1y()) || (min.getX() == myBoard.getG2x() && min.getY() == myBoard.getG2y()))) {
            ext ++;
            if (opened.size() == 0) {
                System.out.println("Path doesn't exist");
                break;
                //return;
            }

            int remover = 0;
            //System.out.println("Kollaw 1");
            //System.out.println("min " + min.getValue() + " " + min.getX() + " " + min.getY());
            min = opened.get(0);
            for (int i = 1; i < opened.size(); i++) {
                if (opened.get(i).getPath() <= min.getPath()) {
                    //System.out.println("For 1");
                    min = opened.get(i);
                    remover = i;
                }
            }

            if (opened.size() != 0) {
                opened.remove(remover);
            }

            lll = min;
            for (int q = 0; q < myBoard.getNeighborsOfCell(min).length; q++) {
                if (myBoard.getNeighborsOfCell(min)[q].getVisited() == false) {
                    if (myBoard.getNeighborsOfCell(min)[q].getIsFree()) {
                        myBoard.getNeighborsOfCell(min)[q].setParent(min);
                        opened.add(myBoard.getNeighborsOfCell(min)[q]);
                        myBoard.calculateD(min, myBoard.getNeighborsOfCell(min)[q]);
                        myBoard.getNeighborsOfCell(min)[q].setPath(myBoard.calculatePath(min, myBoard.getNeighborsOfCell(min)[q]));
                        myBoard.getNeighborsOfCell(min)[q].setVisited(true);

                    }
                }
            }


            for (int u = 0; u < opened.size(); u++) {
                //System.out.print(opened.get(u).getValue() + "(" + opened.get(u).getX() + " " + opened.get(u).getY() + ", " + opened.get(u).getPath() + " parent " + opened.get(u).getParent().getValue() + ") ");
            }
            //System.out.println();
            //System.out.println(remover);
            //System.out.println(opened.size());

            for (int j = 0; j < opened.size(); j++) {
                //System.out.println("for auefghanfeuifg");
                //System.out.println(opened.get(j).getValue());
                if (myBoard.areNeighbors(min, opened.get(j))) {
                    if (myBoard.calculatePath(min, opened.get(j)) <= opened.get(j).getPath()) {
                        opened.get(j).setParent(min);
                        opened.get(j).setPath(myBoard.calculatePath(min, opened.get(j)));
                        //allagh parent
                    }
                }
            }
            //for (int u = 0; u < opened.size(); u++) {
               // System.out.print(opened.get(u).getValue() + "(" + opened.get(u).getX() + " " + opened.get(u).getY() + ", " + opened.get(u).getPath() + " parent " + opened.get(u).getParent().getValue() + ") ");
            //}
            //System.out.println();
            //System.out.println(remover);
            //System.out.println(opened.size());
            //System.out.println("min " + min.getValue() + " " + min.getX() + " " + min.getY());
        }
        double cost = min.getPath();

        while(!(min.equals(myBoard.entryCell()))){
            //System.out.println(min.getValue());
            finish.add(min);
            min=min.getParent();
        }
        System.out.println("-------------------------------------------------------------------------");
        finish.add(myBoard.entryCell());
        System.out.print("Path is: ");
        for(int w=finish.size()-1;w>=0;w--){
            System.out.print(finish.get(w).getValue()+" ");
        }
        System.out.println();
        System.out.println("Cost is: " + cost);
        System.out.println("Extension is "+ext);
        return finish;

    }

//////////////////////////////////////////////////////////////////////////////////////////

    public ArrayList<Cell> Aastro() {
        ArrayList<Cell> opened = new ArrayList<Cell>();
        Cell a;
        Cell min = myBoard.entryCell();
        myBoard.entryCell().setPath(0);
        //Cell[] finish = new Cell[(myBoard.getN() * myBoard.getN())];
        ArrayList<Cell> finish=new ArrayList<Cell>();
        //Cell[] finish=new Cell[1500];
        lll = myBoard.entryCell();
        int n = (int) (myBoard.getN() * (myBoard.getN()));
        myBoard.entryCell().setVisited(true);
        for (int q = 0; q < myBoard.getNeighborsOfCell(myBoard.entryCell()).length; q++) {
            if (myBoard.getNeighborsOfCell(min)[q].getVisited() == false) {
                if (myBoard.getNeighborsOfCell(min)[q].getIsFree()) {
                    opened.add(myBoard.getNeighborsOfCell(myBoard.entryCell())[q]);
                    myBoard.calculateD(myBoard.entryCell(), myBoard.getNeighborsOfCell(myBoard.entryCell())[q]);
                    double x = myBoard.calculatePath(myBoard.entryCell(), myBoard.getNeighborsOfCell(myBoard.entryCell())[q]);
                    myBoard.getNeighborsOfCell(myBoard.entryCell())[q].setPath(x);
                    myBoard.getNeighborsOfCell(myBoard.entryCell())[q].setVisited(true);
                }
            }
            myBoard.getNeighborsOfCell(myBoard.entryCell())[q].setParent(myBoard.entryCell());


            /*System.out.print(opened.get(q).getValue() + " ");
            System.out.print(opened.get(q).getD() + " ");
            System.out.print(opened.get(q).getPath() + " ");
            System.out.println();*/
        }


        a = myBoard.entryCell();
        boolean x = false;
        int break_counter = 0;

        for (int u = 0; u < opened.size(); u++) {
            //System.out.print(opened.get(u).getValue() + "(" + opened.get(u).getX() + " " + opened.get(u).getY() + ", " + opened.get(u).getPath() + " parent " + opened.get(u).getParent().getValue() + ") ");
        }
        int ext=1;
        while (!((min.getX() == myBoard.getG1x() && min.getY() == myBoard.getG1y()) || (min.getX() == myBoard.getG2x() && min.getY() == myBoard.getG2y()))) {

            if (opened.size() == 0) {
                System.out.println("Path doesn't exist");
                break;
                //return;
            }
            ext++;
            int remover = 0;
            //System.out.println("Kollaw 1");
            //System.out.println("min " + min.getValue() + " " + min.getX() + " " + min.getY());
            min = opened.get(0);
            for (int i = 1; i < opened.size(); i++) {
                if ((opened.get(i).getPath()+myBoard.CalculateEyk(opened.get(i))) <= (min.getPath()+myBoard.CalculateEyk(min))) {
                    //System.out.println("For 1");
                    min = opened.get(i);
                    remover = i;
                }
            }
            //System.out.println("minValue" + min.getValue());
            //System.out.println(remover);
            //System.out.println(opened.size());
            if (opened.size() != 0) {
                opened.remove(remover);
            }

            lll = min;
            for (int q = 0; q < myBoard.getNeighborsOfCell(min).length; q++) {
                if (myBoard.getNeighborsOfCell(min)[q].getVisited() == false) {
                    if (myBoard.getNeighborsOfCell(min)[q].getIsFree()) {
                        //System.out.println("for 2");
                        //Cell m=new Cell(myBoard.getNeighborsOfCell(min)[q].getValue(),myBoard.getNeighborsOfCell(min)[q].getX(),myBoard.getNeighborsOfCell(min)[q].getY(),false);
                        myBoard.getNeighborsOfCell(min)[q].setParent(min);
                        opened.add(myBoard.getNeighborsOfCell(min)[q]);
                        myBoard.calculateD(min, myBoard.getNeighborsOfCell(min)[q]);
                        myBoard.getNeighborsOfCell(min)[q].setPath(myBoard.calculatePath(min, myBoard.getNeighborsOfCell(min)[q]));
                        //opened.get(q).setPath(myBoard.calculatePath(min,myBoard.getNeighborsOfCell(min)[q]));
                        myBoard.getNeighborsOfCell(min)[q].setVisited(true);

                    }
                }
            }


            //for (int u = 0; u < opened.size(); u++) {
                //System.out.print(opened.get(u).getValue() + "(" + opened.get(u).getX() + " " + opened.get(u).getY() + ", " + opened.get(u).getPath() + " parent " + opened.get(u).getParent().getValue() + ") ");
            //}
            //System.out.println();
            //System.out.println(remover);
            //System.out.println(opened.size());

            for (int j = 0; j < opened.size(); j++) {
                //System.out.println("for auefghanfeuifg");
                //System.out.println(opened.get(j).getValue());
                if (myBoard.areNeighbors(min, opened.get(j))) {
                    if (myBoard.calculatePath(min, opened.get(j)) <= opened.get(j).getPath()) {
                        opened.get(j).setParent(min);
                        opened.get(j).setPath(myBoard.calculatePath(min, opened.get(j)));
                        //allagh parent
                    }
                }
            }
           //for (int u = 0; u < opened.size(); u++) {
              //  System.out.print(opened.get(u).getValue() + "(" + opened.get(u).getX() + " " + opened.get(u).getY() + ", " + opened.get(u).getPath() + " parent " + opened.get(u).getParent().getValue() + ") ");
            //}
            //System.out.println();
            //System.out.println(remover);
            //System.out.println(opened.size());
            //System.out.println("min " + min.getValue() + " " + min.getX() + " " + min.getY());
        }
        double cost = min.getPath();

        while(!(min.equals(myBoard.entryCell()))){
            //System.out.println(min.getValue());
            finish.add(min);
            min=min.getParent();
        }
        System.out.println("-------------------------------------------------------------------------");
        finish.add(myBoard.entryCell());
        System.out.print("Path is: ");
        for(int w=finish.size()-1;w>=0;w--){
            System.out.print(finish.get(w).getValue()+" ");
        }
        System.out.println();
        System.out.println("Cost is: " + cost);
        System.out.println("Extension is "+ext);
        return finish;
    }
}



