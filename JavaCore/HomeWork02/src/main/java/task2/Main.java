package task2;

public class Main {
    public static void main(String[] args) {
        printArray(getSpiralArray(3, 2));
        System.out.println();
        printArray(getSpiralArray(1, 3));
        System.out.println();
        printArray(getSpiralArray(4, 4));
        System.out.println("***");
        printArray(getSpiralArray2(3, 2));
        System.out.println();
        printArray(getSpiralArray2(1, 3));
        System.out.println();
        printArray(getSpiralArray2(4, 4));
    }

    /*
    4. Требуется написать метод, принимающий на вход размеры двумерного массива
       и выводящий массив в виде инкрементированной цепочки чисел, идущих по спирали.
    */
    private static int[][] getSpiralArray(int rows, int cols) {
        int[][] arr = new int[rows][cols];

        int count = 1;
        int topRow = 0, leftCol = 0;
        int bottomRow = arr.length - 1;
        int rightCol = arr[0].length - 1;

        while (true) {
            for (int j = leftCol; j <= rightCol; j++) {
                arr[topRow][j] = count++;
            }

            if (++topRow > bottomRow) {
                break;
            }

            for (int i = topRow; i <= bottomRow; i++) {
                arr[i][rightCol] = count++;
            }

            if (--rightCol < leftCol) {
                break;
            }

            for (int j = rightCol; j >= leftCol; j--) {
                arr[bottomRow][j] = count++;
            }

            if (--bottomRow < topRow) {
                break;
            }

            for (int i = bottomRow; i >= topRow; i--) {
                arr[i][leftCol] = count++;
            }

            if (++leftCol > rightCol) {
                break;
            }
        }

        return arr;
    }

    private static int[][] getSpiralArray2(int rows, int cols) {
        int[][] arr = new int[rows][cols];

        int direction = 1; // направление движения (1-вправо, 2-вниз, 3-влево, 4-вверх)
        int i = 0, j = 0;
        int topRow = 0, leftCol = 0;
        int bottomRow = arr.length - 1;
        int rightCol = arr[0].length - 1;

        for (int n = 1; n <= arr.length * arr[0].length; n++) {
            arr[i][j] = n;
            switch (direction) {
                case 1:
                    if (j == rightCol) {
                        i = ++topRow;
                        direction = 2;
                    } else {
                        j++;
                    }
                    break;
                case 2:
                    if (i == bottomRow) {
                        j = --rightCol;
                        direction = 3;
                    } else {
                        i++;
                    }
                    break;
                case 3:
                    if (j == leftCol) {
                        i = --bottomRow;
                        direction = 4;
                    } else {
                        j--;
                    }
                    break;
                case 4:
                    if (i == topRow) {
                        j = ++leftCol;
                        direction = 1;
                    } else {
                        i--;
                    }
                    break;
            }
        }

        return arr;
    }

    private static void printArray(int[][] arr) {
        int maxLen = String.valueOf(arr.length * arr[0].length).length();
        String format = "%0" + maxLen + "d ";

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.printf(format, arr[i][j]);
            }
            System.out.println();
        }
    }
}
