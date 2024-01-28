package task2;

import java.io.*;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 0, 1, 2, 3, 0};
        String fileName = "./test.txt";
        writeArrayToFile(arr, fileName);
        System.out.println("Размер файла: " + Path.of(fileName).toFile().length());
        printFile(fileName);
    }

    /*
    Предположить, что числа в исходном массиве из 9 элементов имеют диапазон[0, 3],
    и представляют собой, например, состояния ячеек поля для игры в крестики-нолики,
    где 0 – это пустое поле, 1 – это поле с крестиком, 2 – это поле с ноликом, 3 – резервное значение.
    Такое предположение позволит хранить в одном числе типа int всё поле 3х3.
    Записать в файл 9 значений так, чтобы они заняли три байта.
    */
    public static void writeArrayToFile(int[] arr, String fileName) {
        if (arr.length != 9) {
            throw new RuntimeException("Размер массива должен быть равным 9.");
        }

        byte[] byteArr = new byte[3];

        for (int i = 0; i < 3; i++) {
            byte b = 0;

            for (int j = 0; j < 3; j++) {
                b = (byte) ((b << 2) + arr[i * 3 + j]);
            }

            byteArr[i] = b;
        }

        try (FileOutputStream outputStream = new FileOutputStream(fileName)) {
            outputStream.write(byteArr);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void printFile(String fileName) {
        try (DataInputStream inputStream = new DataInputStream(new FileInputStream(fileName))) {
            for (byte b : inputStream.readAllBytes()) {
                System.out.printf("%s: %s, %s, %s\n", b, b >> 4 & 0x03, b >> 2 & 0x03, b & 0x03);
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
