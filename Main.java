import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TikTakToe game = new TikTakToe();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Player " + game.getPlayer());
            System.out.println("Enter Row:");
            int row = sc.nextInt();
            System.out.println("Enter Column:");
            int col = sc.nextInt();

            if (game.makeMove(row, col)) {
                game.printBoard();
                break;
            }
            game.printBoard();

        }
        sc.close();

    }
}