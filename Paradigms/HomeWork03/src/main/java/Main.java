import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Введите размерность поля: ");
        int size = scn.nextInt();

        TicTacToe ticTacToe = new TicTacToe(size);
        ticTacToe.initField();
        ticTacToe.printField();

        int cell;

        while (true) {
            System.out.printf("Игрок %d, Вы играете %s-ми. Ваш ход!\n", ticTacToe.getPlayer(), ticTacToe.getPlayerSymbol());
            System.out.println("Введите номер клетки (или 0 для завершения игры): ");
            cell = scn.nextInt();

            if (cell == 0) {
                System.out.println("Вы прервали игру!");
                break;
            }

            if (!ticTacToe.nextTurn(cell)) {
                System.out.println("Игра окончена!");
                break;
            }
        }

        scn.close();
    }
}
