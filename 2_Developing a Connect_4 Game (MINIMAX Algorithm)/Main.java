import java.util.Scanner;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Board{
    private int m;
    private int n;
    private int k;
    private String[][] cell;
    private int[] counterList;
    private int counter;

    public Board(int m, int n, int k){
        this.m = m;
        this.n = n;
        this.k = k;
        this.cell = new String[m][n];
        this.counterList = new int[n];
        for(int i=0;i<n;i++){
            counterList[i] = m-1;
        }
        this.counter = 0;
    }

    public Board makeInitialBoard(){
        Board myBoard = new Board(m, n, k);
        for(int i=0; i<cell.length; i++){
            for(int j=0; j<cell[i].length; j++){
                cell[i][j] = "_";
            }
        }
        for(int i=0;i<n;i++){
            counterList[i] = m-1;
        }
        return myBoard;
    }

    public Boolean playMax(){
        if(counter % 2 == 0){
            counter++;
            return true;
        }
        counter++;
        return false;
    }

    public Boolean youWin(){
        int c;
        //katheta
        for(int j=0; j<this.n; j++){
            for(int i=0; i<=cell.length-this.k; i++){
                c = 0;
                for(int o=1; o<this.k; o++){
                    if(this.cell[i][j] == this.cell[i+o][j]){
                        if(this.cell[i][j] == "_"){
                            continue;
                        }
                        c++;
                        if(c == this.k-1){
                            return true;
                        }
                    }
                }
            }
        }
        
        //orizodia
        for(int i=0; i<cell.length; i++){
            for(int j=0; j<=cell[i].length-this.k; j++){
                c = 0;
                for(int o=1; o<this.k; o++){
                    if(this.cell[i][j] == this.cell[i][j+o]){
                        if(this.cell[i][j] == "_"){
                            continue;
                        }
                        c++;
                        if(c == this.k-1){
                            return true;
                        }
                    }
                }
            }
        }

        //diagonia [/]
        for(int i=this.k-1; i<cell.length; i++){
            for(int j=0; j<=cell[i].length-this.k; j++){
                c = 0;
                for(int o=1; o<this.k; o++){
                    if(this.cell[i][j] == this.cell[i-o][j+o]){
                        if(this.cell[i][j] == "_"){
                            continue;
                        }
                        c++;
                        if(c == this.k-1){
                            return true;
                        }
                    }
                }
            }
        }

        //diagonia [\]
        for(int i=0; i<=cell.length-this.k; i++){
            for(int j=0; j<=cell[i].length-this.k; j++){
                c = 0;
                for(int o=1; o<this.k; o++){
                    if(this.cell[i][j] == this.cell[i+o][j+o]){
                        if(this.cell[i][j] == "_"){
                            continue;
                        }
                        c++;
                        if(c == this.k-1){
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    public void printBoard(){
        for(int i=0; i<cell.length; i++){
            for(int j=0; j<cell[i].length; j++){
                System.out.print(this.cell[i][j] + " ");
            }
            System.out.println();
        }
        for(int c=0; c<this.n; c++){
            System.out.print(c + " ");
        }
        System.out.println();
    }

    public void printcounterList(){
        for(int i=0;i<n;i++){
            System.out.print(counterList[i] + " ");
        }
        System.out.println();
    }

    public String[][] getCell(){
        return cell;
    }
    public void setCell(String[][] oldCell){
        for(int i=0; i<this.m; i++){
            for(int j=0; j<this.n; j++){
                cell[i][j] = oldCell[i][j];
            }
        }
    }

    public int[] getCounterList(){
        return counterList;
    }
    public void setCounterList(int[] oldCounterList){
        for(int i = 0; i<this.n; i++){
            counterList[i] = oldCounterList[i];
        }
    }

    public int getCounter(){
        return counter;
    }
    public void setCounter(int oldCounter){
        counter = oldCounter;
    }

    public int getM(){
        return m;
    }

    public int getN(){
        return n;
    }

    public int getK(){
        return k;
    }
}

class Main{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Rows: ");
        int dimM = input.nextInt();         //tis diastaseis m tou board
        System.out.print("Columns: ");
        int dimN = input.nextInt();         //tis diastaseis n tou board
        System.out.print("Connections: ");
        int dimK = input.nextInt();         //tis diastaseis k tou board
        Board myBoardd = new Board(dimM, dimN, dimK);
        if(dimK > dimM || dimK > dimN){
            System.out.println("It is not possible for K to be larger than lines or columns. Try again");
            return;
        }
        myBoardd.makeInitialBoard();
        TreeNode root = new TreeNode(myBoardd);
        Tree myTree = new Tree(dimM, dimN, dimK);
        myBoardd.printBoard();
        //myBoardd.printcounterList();

        myTree.allPosibleScenariosX(root);

        myTree.miniMax(root, 0, true);

        int count = dimN * dimM;
        int ccc = 0;
        while(true){
            count--;
            System.out.println("____________________________________________\n");
            
            if(ccc % 2 == 0){
                System.out.println("PC turn");
                System.out.println("PC is playing...");
                TreeNode newNode = new TreeNode(myBoardd);
                newNode = myTree.doTheBestMove(root);
                myBoardd = myTree.deepCopyBoard(newNode.myBoard);
                root = newNode;
                ccc++;
            }else{
                ccc++;
                System.out.println("YOUR turn");
                System.out.print("Select column: ");
                int playerRow = input.nextInt(); //tin stili pou thelei na pai3ei o paixtis
                myBoardd.getCell()[myBoardd.getCounterList()[playerRow]][playerRow] = "O";
                myBoardd.getCounterList()[playerRow]--;

                for(int i=0; i<root.children.size(); i++){
                    if(Arrays.deepEquals(myBoardd.getCell(), root.children.get(i).myBoard.getCell())){
                        myBoardd = myTree.deepCopyBoard(root.children.get(i).myBoard);
                        root = root.children.get(i);
                        break;
                    }
                }
            }

            myBoardd.printBoard();
            //myBoardd.printcounterList();
            if(count == 0 && myBoardd.youWin()==false){
                System.out.println("____________________________________________\n");
                System.out.println("Tie");
                break;
            }else{
                if(myBoardd.youWin()){
                    if(myBoardd.playMax()){
                        System.out.println("____________________________________________\n");
                        System.out.println("Winner: PC");
                        break;
                    }else{
                        System.out.println("____________________________________________\n");
                        System.out.println("Winner: YOU");
                        break;
                    }
                }
            }
        }
    }
}