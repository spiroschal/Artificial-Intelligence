import java.util.LinkedList;
import java.util.List;

public class TreeNode{
    int val;
    List<TreeNode> children = new LinkedList<>();
    Board myBoard;

    TreeNode(Board myBoard){
        this.myBoard = myBoard;
    }

    TreeNode(Board myBoard, int val){
        this.myBoard = myBoard;
        this.val = val;
    }
}