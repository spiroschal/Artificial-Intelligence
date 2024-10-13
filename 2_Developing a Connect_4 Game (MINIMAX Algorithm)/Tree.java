import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Tree {
    private int m;
    private int n;
    private int k;

    public Tree(int m, int n, int k){
        this.m = m;
        this.n = n;
        this.k = k;
    }

    public void allPosibleScenariosX(TreeNode myTreeNode){
        for(int i=0; i<this.n; i++){
            if(myTreeNode.myBoard.getCounterList()[i] < 0){
                continue;
            }
            Board myNewBoard = new Board(this.m, this.n, this.k);
            myNewBoard = this.deepCopyBoard(myTreeNode.myBoard);
            myNewBoard.getCell()[myNewBoard.getCounterList()[i]][i] = "X";
            myNewBoard.getCounterList()[i]--;
            if(myNewBoard.youWin()){
                TreeNode myNewTreeNode = new TreeNode(myNewBoard, 1);
                myTreeNode.children.add(myNewTreeNode); //to vazei kai me value
                //myTreeNode.myBoard.printBoard();
                //myTreeNode.myBoard.printcounterList();
            }else{
                TreeNode myNewTreeNode = new TreeNode(myNewBoard);
                myTreeNode.children.add(myNewTreeNode); //to vazei apla
                //myTreeNode.myBoard.printBoard();
                //myTreeNode.myBoard.printcounterList();

                // prepei na sunexisei
                this.allPosibleScenariosO(myNewTreeNode);
            }
            //myTreeNode.myBoard.printBoard();
            //myTreeNode.myBoard.printcounterList();

            //myNewBoard.printBoard();
            //myNewBoard.printcounterList();
            //System.out.println("........................................");
        }
    }

    public void allPosibleScenariosO(TreeNode myTreeNode){
        for(int i=0; i<this.n; i++){
            if(myTreeNode.myBoard.getCounterList()[i] < 0){
                continue;
            }
            Board myNewBoard = new Board(this.m, this.n, this.k);
            myNewBoard = this.deepCopyBoard(myTreeNode.myBoard);
            myNewBoard.getCell()[myNewBoard.getCounterList()[i]][i] = "O";
            myNewBoard.getCounterList()[i]--;
            if(myNewBoard.youWin()){
                TreeNode myNewTreeNode = new TreeNode(myNewBoard, -1);
                myTreeNode.children.add(myNewTreeNode); //to vazei kai me value
                //myTreeNode.myBoard.printBoard();
                //myTreeNode.myBoard.printcounterList();
            }else{
                TreeNode myNewTreeNode = new TreeNode(myNewBoard);
                myTreeNode.children.add(myNewTreeNode); //to vazei apla
                //myTreeNode.myBoard.printBoard();
                //myTreeNode.myBoard.printcounterList();

                // kai prepei na sunexisei
                this.allPosibleScenariosX(myNewTreeNode);
            }
            //myTreeNode.myBoard.printBoard();
            //myTreeNode.myBoard.printcounterList();
            //System.out.println("........................................");
        }
    }

    public Board deepCopyBoard(Board myOldBoard){
        Board myNewBoard = new Board(this.m, this.n, this.k);
        for(int i=0; i<this.m; i++){
            for(int j=0; j<this.n; j++){
                myNewBoard.setCell(myOldBoard.getCell());
            }
        }
        for(int i = 0; i<this.n; i++){
            myNewBoard.setCounterList(myOldBoard.getCounterList());
        }
        myNewBoard.setCounter(myOldBoard.getCounter());

        return myNewBoard;
    }

    public int miniMax(TreeNode node, int depth, boolean maximizing){
        if(node.children.size() == 0){
            return node.val;
        }
        if(maximizing){
            int bestValue = -100; // enas tixaia mikros arithmos
            for(int i=0; i<node.children.size(); i++){
                int value = miniMax(node.children.get(i), depth + 1, false);
                if(value > bestValue){
                    bestValue = value;
                    node.val = bestValue; // na ananeonei ta val sosta
                    //System.out.println(bestValue);
                }
            }
            return bestValue;
        }else{
            int bestValue = 100; // enas tixaia megalos arithmos
            for(int i=0; i<node.children.size(); i++){
                int value = miniMax(node.children.get(i), depth + 1, true);
                if(value < bestValue){
                    bestValue = value;
                    node.val = bestValue; // na ananeonei ta val sosta
                    //System.out.println(bestValue);
                }
            }
            return bestValue;
        }
    }

    public TreeNode doTheBestMove(TreeNode node){
        for(int i=0; i<node.children.size(); i++){
            if(node.children.get(i).val == 1){
                //node.children.get(i).myBoard.printBoard();
                return node.children.get(i);
            }
        }
        for(int i=0; i<node.children.size(); i++){
            if(node.children.get(i).val == 0){
                //node.children.get(i).myBoard.printBoard();
                return node.children.get(i);
            }
        }
        return null;
    }

    //Debugging
    private void printTree(TreeNode root){
        if(root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i=0;i<len;i++) {
                TreeNode node = queue.poll();
                assert node != null;
                // an theloume na doume oles tis periptoseis tou board
                /*for(int o=0; o<node.myBoard.getCell().length; o++){
                    for(int j=0; j<node.myBoard.getCell()[o].length; j++){
                        System.out.print(node.myBoard.getCell()[o][j] + " ");
                    }
                    System.out.println();
                }
                for(int c=0; c<this.n; c++){
                    System.out.print(c + " ");
                }
                System.out.println();*/
                System.out.print(node.val + " ");
                //System.out.println();
                for (TreeNode item : node.children) {
                    queue.offer(item);
                }
            }
            System.out.println();
            System.out.println("-------------------------------------------");
            System.out.println();
        }
    }

    //Debugging
    /*public static void main(String[] args) {
        Board myBoard = new Board(2, 3, 3);
        myBoard.makeInitialBoard();
        TreeNode root = new TreeNode(myBoard);
        Tree myTree = new Tree(2, 3, 3);

        myTree.allPosibleScenariosX(root);

        myTree.printTree(root);

        myTree.miniMax(root, 0, true);

        myTree.printTree(root);
    }*/
}