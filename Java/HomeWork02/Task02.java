/*
 * Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
 */

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Task02 {
    public static void main(String[] args) throws IOException {
        int[] array = new int[] { 8, 1, 5, 2, 3, 7, 4 };

        Logger logger = Logger.getLogger(Task02.class.getName());
        FileHandler fh = new FileHandler("log02.txt");
        SimpleFormatter sf = new SimpleFormatter();
        fh.setFormatter(sf);
        logger.addHandler(fh);

        int temp;

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }

                logger.log(Level.INFO, Arrays.toString(array));
            }
        }
    }
}
