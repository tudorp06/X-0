import java.util.Scanner;
public class x0 {
    static String[][] mat = new String[10][10];

    //Method that initialises 2D array as "_"
    public static void initialise() {
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                mat[i][j] = "_";
                System.out.print(mat[i][j] + " ");
            }
            System.out.print('\n');
        }
    }

    //Method that prints the X-0 board
    public static void printBoard() {
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.print('\n');
        }
    }


    //Method that verifies the winner
    static String Winner() {
        String line = null;
        for (int i = 1; i<=8; i++) {
            switch (i) {
                case 1 -> line = mat[1][1] + mat[1][2] + mat[1][3];
                case 2 -> line = mat[2][1] + mat[2][2] + mat[2][3];
                case 3 -> line = mat[3][1] + mat[3][2] + mat[3][3];
                case 4 -> line = mat[1][1] + mat[2][1] + mat[3][1];
                case 5 -> line = mat[1][2] + mat[2][2] + mat[3][2];
                case 6 -> line = mat[1][3] + mat[2][3] + mat[3][3];
                case 7 -> line = mat[1][1] + mat[2][2] + mat[3][3];
                case 8 -> line = mat[1][3] + mat[2][2] + mat[3][1];
            }
            if (line.equals("XXX")) {
                return "user X won!";
            }
            else if (line.equals("000")) {
                return "user 0 won!";
            }
        }
        return null;
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //incepe mereu X
        int l, c;
        initialise();
        System.out.println("Please enter the coordinates: ");
        l = input.nextInt();
        c = input.nextInt();
        int moves = 1;
        boolean condition = (l > 0 && l < 4) && (c > 0 && c < 4);
        Winner();
        while (moves<=8 && condition){
            Winner();
            if (moves % 2 == 1 && mat[l][c].equals("_")) {
                mat[l][c] = "X";
                moves++;
            }
            else if (moves % 2 == 0 && mat[l][c].equals("_")) {
                mat[l][c] = "0";
                moves++;
            }
            else {
                System.out.println("This slot is taken! ");
            }
            printBoard();
            if(Winner() == null) {
                System.out.println("Please enter the coordinates: ");
                l = input.nextInt();
                c = input.nextInt();
            }
        }
        if(Winner() == null){
            System.out.println("It's a draw!");
        }
        else {
            System.out.println(Winner());
        }

    }
}

