public class TicTacToe {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    private final String[][] field;
    private int player;
    private final String player1Sign = "X";
    private final String player2Sign = "0";

    public TicTacToe(int size) {
        this.field = new String[size][size];
        this.player = 1;
    }

    public int getPlayer() {
        return player;
    }

    public String getPlayerSymbol() {
        return (player == 1 ? player1Sign : player2Sign);
    }

    public void initField() {
        for (int i = 0; i < field[0].length; i++) {
            for (int j = 0; j < field[1].length; j++) {
                field[i][j] = String.valueOf(j + 1 + i * field[0].length);
            }
        }
    }

    public void printField() {
        for (int i = 0; i < field[0].length; i++) {
            for (int j = 0; j < field[1].length; j++) {
                System.out.printf("%s%3s%s ",
                        ((field[i][j].equals(player1Sign) || field[i][j].equals(player2Sign)) ? ANSI_YELLOW : ANSI_GREEN),
                        field[i][j],
                        ANSI_RESET);
            }
            System.out.println();
        }
    }

    public boolean nextTurn(int cell) {
        if (cell < 0 || cell > field[0].length * field[1].length) {
            System.out.println("Введен неправильный номер клетки!");
            return true;
        }

        int i = (cell - 1) / field[0].length;
        int j = (cell - 1) % field[0].length;

        if (field[i][j].equals(player1Sign) || field[i][j].equals(player2Sign)) {
            System.out.println("Клетка занята!");
            return true;
        }

        field[i][j] = (player == 1 ? player1Sign : player2Sign);

        printField();

        return switch (checkWinner()) {
            case (-1) -> {
                player = (player == 1 ? 2 : 1);
                yield true;
            }
            case (0) -> {
                System.out.println("Все клетки заняты. Ничья!");
                yield false;
            }
            case (1), (2) -> {
                System.out.printf("Выиграл %d-й игрок!\n", player);
                yield false;
            }
            default -> {
                System.out.println("Неизвестный код проверки");
                yield false;
            }
        };
    }

    private int checkWinner() {
        int result = -1;
        int player1Cnt, player2Cnt;
        int freeCell = 0;

        // Проверка по строкам и свободные ячейки
        for (int i = 0; i < field[0].length; i++) {
            player1Cnt = 0;
            player2Cnt = 0;

            for (int j = 0; j < field[1].length; j++) {
                if (field[i][j].equals(player1Sign)) {
                    player1Cnt++;
                } else if (field[i][j].equals(player2Sign)) {
                    player2Cnt++;
                } else {
                    freeCell++;
                }
            }

            if (player1Cnt == field[0].length) {
                return 1;
            } else if (player2Cnt == field[0].length) {
                return 2;
            }
        }

        if (freeCell == 0) {
            return 0;
        }

        // Проверка по столбцам
        for (int j = 0; j < field[1].length; j++) {
            player1Cnt = 0;
            player2Cnt = 0;

            for (int i = 0; i < field[1].length; i++) {
                if (field[i][j].equals(player1Sign)) {
                    player1Cnt++;
                } else if (field[i][j].equals(player2Sign)) {
                    player2Cnt++;
                }
            }

            if (player1Cnt == field[0].length) {
                return 1;
            } else if (player2Cnt == field[0].length) {
                return 2;
            }
        }

        // Проверка по диагонали 1
        player1Cnt = 0;
        player2Cnt = 0;

        for (int i = 0; i < field[0].length; i++) {
            if (field[i][i].equals(player1Sign)) {
                player1Cnt++;
            } else if (field[i][i].equals(player2Sign)) {
                player2Cnt++;
            }
        }

        if (player1Cnt == field[0].length) {
            return 1;
        } else if (player2Cnt == field[0].length) {
            return 2;
        }

        // Проверка по диагонали 2
        player1Cnt = 0;
        player2Cnt = 0;

        for (int i = 0; i < field[0].length; i++) {
            if (field[i][field[0].length - 1 - i].equals(player1Sign)) {
                player1Cnt++;
            } else if (field[i][i].equals(player2Sign)) {
                player2Cnt++;
            }
        }

        if (player1Cnt == field[0].length) {
            return 1;
        } else if (player2Cnt == field[0].length) {
            return 2;
        }

        return result;
    }
}
