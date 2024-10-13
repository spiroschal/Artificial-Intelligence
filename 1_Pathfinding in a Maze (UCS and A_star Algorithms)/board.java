import java.util.Random;

class Board {
    Random rand = new Random();
    int rand_int1;
    boolean rand_bool1;
    int n;
    ////////////////////////////////
    private int entryx;
    private int entryy;
    private int g1x;
    private int g1y;
    private int g2x;
    private int g2y;
    /////////////////////////////////

    Cell[][] listboard;

    public Board(int n, int entryx, int entryy, int g1x, int g1y, int g2x, int g2y) {
        this.n = n;
        this.entryx = entryx;
        this.entryy = entryy;
        this.g1x = g1x;
        this.g1y = g1y;
        this.g2x = g2x;
        this.g2y = g2y;
        listboard = new Cell[n][n];
        for (int y = 0; y < listboard.length; y++) {
            for (int x = 0; x < listboard[y].length; x++) {
                rand_int1 = rand.nextInt(4) + 1;
                listboard[y][x] = new Cell(rand_int1, x, y, true);
            }

        }
    }

    public Cell[][] getListboard() {
        return listboard;
    }


    public void entrance(int x, int y) {
        entryx = x;
        entryy = y;
    }

    public void exits(int x1, int y1, int x2, int y2) {
        g1x = x1;
        g1y = y1;
        g2x = x2;
        g2y = y2;
    }

    public Cell entryCell() {
        Cell a = null;
        for (int i = 0; i < listboard.length; i++) {
            for (int j = 0; j < listboard[i].length; j++) {
                if (listboard[i][j].getX() == entryx && listboard[i][j].getY() == entryy) {
                    a = listboard[i][j];
                }
            }
        }
        return a;
    }

    public Cell exitCell1() {
        Cell a = null;
        for (int i = 0; i < listboard.length; i++) {
            for (int j = 0; j < listboard[i].length; j++) {
                if (listboard[i][j].getX() == g1x && listboard[i][j].getY() == g1y) {
                    a = listboard[i][j];
                }
            }
        }
        return a;
    }

    public Cell exitCell2() {
        Cell a = null;
        for (int i = 0; i < listboard.length; i++) {
            for (int j = 0; j < listboard[i].length; j++) {
                if (listboard[i][j].getX() == g2x && listboard[i][j].getY() == g2y) {
                    a = listboard[i][j];
                }
            }
        }
        return a;
    }


    public void putWalls() {
        int k;
        for (int y = 0; y < listboard.length; y++) {
            for (int x = 0; x < listboard[y].length; x++) {
                k = rand.nextInt(10);
                if (k == 0 ) {
                    if(!((y==entryy) && (x==entryx))) {
                        if(!((x==g1x) && (y==g1y))) {
                            if(!((x==g2x) && (y==g2y))) {
                                listboard[y][x].setValue(10000000);
                                listboard[y][x].setIsFree(false);
                            }
                        }
                    }
                }
            }

        }
    }

    public Cell[] getNeighborsOfCell(Cell mycell) {
        int counter = 0;
        // CORNERS
        //panw aristera
        int x1 = mycell.getX();
        int y1 = mycell.getY();
        if (mycell.getX() == 0 && mycell.getY() == 0) {
            Cell[] myCellBorad = new Cell[3];
            for (int y = 0; y < listboard.length; y++) {
                for (int x = 0; x < listboard[y].length; x++) {
                    if (listboard[y][x].getX() == 1 && listboard[y][x].getY() == 0) {
                        myCellBorad[counter] = listboard[y][x];
                        counter++;
                    }
                    if (listboard[y][x].getX() == 0 && listboard[y][x].getY() == 1) {
                        myCellBorad[counter] = listboard[y][x];
                        counter++;
                    }
                    if (listboard[y][x].getX() == 1 && listboard[y][x].getY() == 1) {
                        myCellBorad[counter] = listboard[y][x];
                        counter++;
                    }
                    if (counter == 3) {
                        break;
                    }

                }
                if (counter == 3) {
                    break;
                }
            }
            counter = 0;
            return myCellBorad;
        }
        // katw aristera
        if (mycell.getX() == (n - 1) && mycell.getY() == 0) {
            Cell[] myCellBorad = new Cell[3];
            for (int y = 0; y < listboard.length; y++) {
                for (int x = 0; x < listboard[y].length; x++) {
                    if (listboard[y][x].getX() == (n - 2) && listboard[y][x].getY() == 0) {
                        myCellBorad[counter] = listboard[y][x];
                        counter++;
                    }
                    if (listboard[y][x].getX() == (n - 1) && listboard[y][x].getY() == 1) {
                        myCellBorad[counter] = listboard[y][x];
                        counter++;
                    }
                    if (listboard[y][x].getX() == (n - 2) && listboard[y][x].getY() == 1) {
                        myCellBorad[counter] = listboard[y][x];
                        counter++;
                    }
                    if (counter == 3) {
                        break;
                    }

                }
                if (counter == 3) {
                    break;
                }
            }
            counter = 0;
            return myCellBorad;
        }
        //Panw dejia
        if (mycell.getX() == 0 && mycell.getY() == (n - 1)) {
            Cell[] myCellBorad = new Cell[3];
            for (int y = 0; y < listboard.length; y++) {
                for (int x = 0; x < listboard[y].length; x++) {
                    if (listboard[y][x].getX() == 0 && listboard[y][x].getY() == (n - 2)) {
                        myCellBorad[counter] = listboard[y][x];
                        counter++;
                    }
                    if (listboard[y][x].getX() == 1 && listboard[y][x].getY() == (n - 1)) {
                        myCellBorad[counter] = listboard[y][x];
                        counter++;
                    }
                    if (listboard[y][x].getX() == 1 && listboard[y][x].getY() == (n - 2)) {
                        myCellBorad[counter] = listboard[y][x];
                        counter++;
                    }
                    if (counter == 3) {
                        break;
                    }

                }
            }
            counter = 0;
            return myCellBorad;
        }
        //Katw dejia
        if (mycell.getX() == (n - 1) && mycell.getY() == (n - 1)) {
            Cell[] myCellBorad = new Cell[3];
            for (int y = 0; y < listboard.length; y++) {
                for (int x = 0; x < listboard[y].length; x++) {
                    if (listboard[y][x].getX() == (n - 1) && listboard[y][x].getY() == (n - 2)) {
                        myCellBorad[counter] = listboard[y][x];
                        counter++;
                    }
                    if (listboard[y][x].getX() == (n - 2) && listboard[y][x].getY() == (n - 1)) {
                        myCellBorad[counter] = listboard[y][x];
                        counter++;
                    }
                    if (listboard[y][x].getX() == (n - 2) && listboard[y][x].getY() == (n - 2)) {
                        myCellBorad[counter] = listboard[y][x];
                        counter++;
                    }
                    if (counter == 3) {
                        break;
                    }

                }
                if (counter == 3) {
                    break;
                }
            }
            counter = 0;
            return myCellBorad;
        }
        //SIDES
        // Aristerh pleyra
        if (mycell.getY() == 0 && mycell.getX() != 0 && mycell.getX() != (n - 1)) {
            Cell[] myCellBorad = new Cell[5];
            for (int y = 0; y < listboard.length; y++) {
                for (int x = 0; x < listboard[y].length; x++) {
                    if (listboard[y][x].getX() == x1 - 1 && listboard[y][x].getY() == 0) {//myCell.getX=x
                        myCellBorad[counter] = listboard[y][x];
                        counter++;
                    }
                    if (listboard[y][x].getX() == x1 + 1 && listboard[y][x].getY() == 0) {
                        myCellBorad[counter] = listboard[y][x];
                        counter++;
                    }
                    if (listboard[y][x].getX() == x1 - 1 && listboard[y][x].getY() == 1) {
                        myCellBorad[counter] = listboard[y][x];
                        counter++;
                    }
                    if (listboard[y][x].getX() == x1 && listboard[y][x].getY() == 1) {
                        myCellBorad[counter] = listboard[y][x];
                        counter++;
                    }
                    if (listboard[y][x].getX() == x1 + 1 && listboard[y][x].getY() == 1) {
                        myCellBorad[counter] = listboard[y][x];
                        counter++;
                    }
                }

            }
            counter = 0;
            return myCellBorad;
        }

        //Panw pleyra
        if (mycell.getX() == 0 && mycell.getY() != 0 && mycell.getY() != (n - 1)) {
            Cell[] myCellBorad = new Cell[5];
            for (int y = 0; y < listboard.length; y++) {
                for (int x = 0; x < listboard[y].length; x++) {
                    if (listboard[y][x].getX() == 0 && listboard[y][x].getY() == y1 - 1) {
                        myCellBorad[counter] = listboard[y][x];
                        counter++;
                    }
                    if (listboard[y][x].getX() == 0 && listboard[y][x].getY() == y1 + 1) {
                        myCellBorad[counter] = listboard[y][x];
                        counter++;
                    }
                    if (listboard[y][x].getX() == 1 && listboard[y][x].getY() == y1 - 1) {
                        myCellBorad[counter] = listboard[y][x];
                        counter++;
                    }
                    if (listboard[y][x].getX() == 1 && listboard[y][x].getY() == y1) {
                        myCellBorad[counter] = listboard[y][x];
                        counter++;
                    }
                    if (listboard[y][x].getX() == 1 && listboard[y][x].getY() == y1 + 1) {
                        myCellBorad[counter] = listboard[y][x];
                        counter++;
                    }
                }

            }

            return myCellBorad;
        }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Dexia pleyra
        if (mycell.getY() == (n - 1) && (mycell.getX() != 0 && mycell.getX() != (n - 1))) {
            //counter=0;
            Cell[] myCellBorad = new Cell[5];
            for (int y = 0; y < listboard.length; y++) {
                for (int x = 0; x < listboard[y].length; x++) {
                    if (listboard[y][x].getX() == (x1 - 1) && listboard[y][x].getY() == (n - 1)) {
                        myCellBorad[counter] = listboard[y][x];
                        counter++;
                    }
                    if (listboard[y][x].getX() == (x1 + 1) && listboard[y][x].getY() == (n - 1)) {
                        //System.out.println(counter);
                        myCellBorad[counter] = listboard[y][x];
                        counter++;
                    }
                    if (listboard[y][x].getX() == (x1 - 1) && listboard[y][x].getY() == (n - 2)) {
                        myCellBorad[counter] = listboard[y][x];
                        counter++;
                    }
                    if (listboard[y][x].getX() == x1 && listboard[y][x].getY() == (n - 2)) {
                        myCellBorad[counter] = listboard[y][x];
                        counter++;
                    }
                    if (listboard[y][x].getX() == (x1 + 1) && listboard[y][x].getY() == (n - 2)) {
                        myCellBorad[counter] = listboard[y][x];
                        counter++;

                    }
                }

            }
            //counter = 0;
            return myCellBorad;
        }

        //Katw pleyra
        if (mycell.getX() == n - 1 && mycell.getY() != 0 && mycell.getY() != (n - 1)) {///ypopto
            Cell[] myCellBorad = new Cell[5];
            for (int y = 0; y < listboard.length; y++) {
                for (int x = 0; x < listboard[y].length; x++) {
                    if (listboard[y][x].getX() == (n - 1) && listboard[y][x].getY() == (y1 - 1)) {
                        myCellBorad[counter] = listboard[y][x];
                        counter++;
                    }
                    if (listboard[y][x].getX() == (n - 1) && listboard[y][x].getY() == (y1 + 1)) {
                        myCellBorad[counter] = listboard[y][x];
                        counter++;
                    }
                    if (listboard[y][x].getX() == (n - 2) && listboard[y][x].getY() == y1 - 1) {
                        myCellBorad[counter] = listboard[y][x];
                        counter++;
                    }
                    if (listboard[y][x].getX() == (n - 2) && listboard[y][x].getY() == y1) {
                        myCellBorad[counter] = listboard[y][x];
                        counter++;
                    }
                    if (listboard[y][x].getX() == (n - 2) && listboard[y][x].getY() == (y1 + 1)) {
                        myCellBorad[counter] = listboard[y][x];
                        counter++;
                    }
                }
                //counter = 0;

            }
            return myCellBorad;
        }
        if ((mycell.getY() != 0) && (mycell.getY() != (n - 1)) && (mycell.getX() != 0) && (mycell.getX() != (n - 1)))  {////////////////////////// ta alla stoixeia
            Cell[] myCellBorad = new Cell[8];
            for (int y = 1; y < (listboard.length - 1); y++) {
                for (int x = 1; x < (listboard[y].length - 1); x++) {
                    if (listboard[y][x].getX() == x1 && listboard[y][x].getY() == y1) {
                        myCellBorad[counter] = listboard[y - 1][x - 1];
                        counter++;
                        myCellBorad[counter] = listboard[y - 1][x];
                        counter++;
                        myCellBorad[counter] = listboard[y - 1][x + 1];
                        counter++;
                        myCellBorad[counter] = listboard[y][x - 1];
                        counter++;
                        myCellBorad[counter] = listboard[y][x + 1];
                        counter++;
                        myCellBorad[counter] = listboard[y + 1][x - 1];
                        counter++;

                        myCellBorad[counter] = listboard[y + 1][x];
                        counter++;
                        myCellBorad[counter] = listboard[y + 1][x + 1];
                        counter++;
                    }
                }
                counter = 0;
            }

            return myCellBorad;
        }
        return null;
    }


    public boolean areNeighbors(Cell k1, Cell k2) {
        if ((k1.getX() == k2.getX()) && ((k1.getY() == (k2.getY() + 1)) || (k1.getY() == (k2.getY() - 1)))) {
            return true;
        } else if ((k1.getY() == k2.getY()) && ((k1.getX() == (k2.getX() + 1)) || (k1.getX() == (k2.getX() - 1)))) {
            return true;
        } else if ((k1.getY() == (k2.getY() + 1) && ((k1.getX() == (k2.getX() + 1)) || (k1.getX() == (k2.getX() - 1))))) {
            return true;


        } else if ((k1.getY() == (k2.getY() - 1) && ((k1.getX() == (k2.getX() + 1)) || (k1.getX() == (k2.getX() - 1))))) {
            return true;
        } else {
            return false;
        }
    }


    public double calculateD(Cell k1, Cell k2) {
        double D=0;
        if (this.areNeighbors(k1,k2)) {
            D=Math.abs(k1.getValue()-k2.getValue());
            if ((k1.getY() == (k2.getY() + 1) && ((k1.getX() == (k2.getX() + 1)) || (k1.getX() == (k2.getX() - 1))))){
                D=D+0.5;
            }else if((k1.getY() == (k2.getY() - 1) && ((k1.getX() == (k2.getX() + 1)) || (k1.getX() == (k2.getX() - 1))))){
                D=D+0.5;
            }else{
                D=D+1;
            }
            k2.setD(D);

        }
        return D;

    }
    public double calculatePath(Cell k1,Cell k2){
            double path = k1.getPath() + this.calculateD(k1, k2);
            //k2.setPath(path);
            return path;

    }
       public double CalculateEyk(Cell k1){
        double e1=0;
        double e2=0;
        double etel=0;
        e1=Math.sqrt(Math.pow((g1x-k1.getX()),2)+Math.pow((g1y-k1.getY()),2));
        e2=Math.sqrt(Math.pow((g2x-k1.getX()),2)+Math.pow((g2y-k1.getY()),2));
        if(e1<e2){
            etel=e1;
        }else{
            etel=e2;
        }
        etel=(etel/(2*Math.sqrt(2)));
        //etel=etel/2;
        return etel;
    }


    public int getN() {
        return n;
    }

    public int getEntryx() {
        return entryx;
    }
    public void setEntryx(int e){
        entryx=e;
    }

    public int getEntryy() {
        return entryy;
    }
    public void setEntryy(int e){
        entryy=e;
    }

    public int getG1x() {
        return g1x;
    }
    public void setG1x(int e){
        g1x=e;
    }

    public int getG1y() {
        return g1y;
    }
    public void setG1y(int e){
        g1y=e;
    }
    public int getG2x() {
        return g2x;
    }
    public void setG2x(int e){
        g2x=e;
    }

    public int getG2y() {
        return g2y;
    }
    public void setG2y(int e){
        g2y=e;
    }

}

