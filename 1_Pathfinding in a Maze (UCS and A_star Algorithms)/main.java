import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        int n = 5;
        Scanner input = new Scanner(System.in);
        System.out.print("S_x: ");
        int sx = input.nextInt();
        System.out.print("S_y: ");
        int sy = input.nextInt();
        System.out.print("G1_x: ");
        int g1x = input.nextInt();
        System.out.print("G1_y: ");
        int g1y = input.nextInt();
        System.out.print("G2_x: ");
        int g2x = input.nextInt();
        System.out.print("G2_y: ");
        int g2y = input.nextInt();
        System.out.println();
        System.out.println("Board is (by values):");
        Board myboard = new Board(n, sx, sy, g1x, g1y, g2x, g2y);//vazw kai tis exodoys*/
        Board mynewboard = new Board(n, sx, sy, g1x, g1y, g2x, g2y);
        //Board myboard = new Board(500, 0, 34, 499, 76, 499, 12);//vazw kai tis exodoys
        //Board mynewboard = new Board(500, 0, 34, 499, 76, 499, 12);
        myboard.putWalls();
        Cell a = myboard.entryCell();
        for (int i = 0; i < myboard.getListboard().length; i++) {
            // Loop through all elements of current row
            for (int j = 0; j < myboard.getListboard()[i].length; j++) {
                if (myboard.getListboard()[i][j].getIsFree() == false) {
                    System.out.print("0 ");
                } else {
                    System.out.print(myboard.getListboard()[i][j].getValue() + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("_______________________________________________________________________________________________________________________________");
        System.out.println();

        for(int i=0;i<myboard.getListboard().length;i++){
            for(int j=0;j<myboard.getListboard()[i].length;j++){
                mynewboard.getListboard()[i][j].setValue(myboard.getListboard()[i][j].getValue());
                mynewboard.getListboard()[i][j].setIsFree(myboard.getListboard()[i][j].getIsFree());
                mynewboard.getListboard()[i][j].setX(myboard.getListboard()[i][j].getX());
                mynewboard.getListboard()[i][j].setY(myboard.getListboard()[i][j].getY());
            }
        }


        /*for (int i = 0; i < mynewboard.getListboard().length; i++) {
            // Loop through all elements of current row
            for (int j = 0; j < mynewboard.getListboard()[i].length; j++) {
                if (mynewboard.getListboard()[i][j].getIsFree() == false) {
                    System.out.print("0 ");
                } else {
                    System.out.print(mynewboard.getListboard()[i][j].getValue() + " ");
                }
            }
            System.out.println();
        }*/

        run b = new run(myboard);
        run c=new run(mynewboard);
        System.out.println("UCS");
        b.ucs();

        System.out.println("_______________________________________________________________________________________________________________________________");
        System.out.println();

        System.out.println("A*");
        c.Aastro();

    }
}
