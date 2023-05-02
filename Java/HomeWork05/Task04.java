/*
 * На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга
 * (решение без использования рекурсии)
 */

public class Task04 {
    public static void main(String[] args) {
        int N = 8;
        boolean[][] board = new boolean[N][N];

        clearBoard(board);
        setQueens(board);
        printBoard(board);
    }

    private static void clearBoard(boolean[][] board) {
        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board[1].length; j++) {
                board[i][j] = false;
            }
        }
    }

    private static void printBoard(boolean[][] board) {
        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board[1].length; j++) {
                System.out.printf("%s ", board[i][j] ? "Q" : "-");
            }

            System.out.println();
        }
    }

    private static void setQueens(boolean[][] board) {
        boolean isSet = false;

        for (int c1 = 0; c1 < board[1].length; c1++) {
            board[0][c1] = true;

            for (int c2 = 0; c2 < board[1].length; c2++) {
                if (!canSet(board, 1, c2))
                    continue;

                board[1][c2] = true;

                for (int c3 = 0; c3 < board[1].length; c3++) {
                    if (!canSet(board, 2, c3))
                        continue;

                    board[2][c3] = true;

                    for (int c4 = 0; c4 < board[1].length; c4++) {
                        if (!canSet(board, 3, c4))
                            continue;

                        board[3][c4] = true;

                        for (int c5 = 0; c5 < board[1].length; c5++) {
                            if (!canSet(board, 4, c5))
                                continue;

                            board[4][c5] = true;

                            for (int c6 = 0; c6 < board[1].length; c6++) {
                                if (!canSet(board, 5, c6))
                                    continue;

                                board[5][c6] = true;

                                for (int c7 = 0; c7 < board[1].length; c7++) {
                                    if (!canSet(board, 6, c7))
                                        continue;

                                    board[6][c7] = true;

                                    for (int c8 = 0; c8 < board[1].length; c8++) {
                                        if (!canSet(board, 7, c8))
                                            continue;

                                        board[7][c8] = true;
                                        isSet = true;
                                        break;
                                    }

                                    if (isSet)
                                        break;

                                    board[6][c7] = false;
                                }

                                if (isSet)
                                    break;

                                board[5][c6] = false;
                            }

                            if (isSet)
                                break;

                            board[4][c5] = false;
                        }

                        if (isSet)
                            break;

                        board[3][c4] = false;
                    }

                    if (isSet)
                        break;

                    board[2][c3] = false;
                }

                if (isSet)
                    break;

                board[1][c2] = false;
            }

            if (isSet)
                break;

            board[0][c1] = false;
        }
    }

    private static boolean canSet(boolean[][] board, int row, int col) {
        // Проверяем вертикаль
        for (int i = 0; i < row; i++) {
            if (board[i][col])
                return false;
        }

        // Проверяем диагональ "\"
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j])
                return false;
        }

        // Проверяем диагональ "/"
        for (int i = row - 1, j = col + 1; i >= 0 && j < board[1].length; i--, j++) {
            if (board[i][j])
                return false;
        }

        return true;
    }
}