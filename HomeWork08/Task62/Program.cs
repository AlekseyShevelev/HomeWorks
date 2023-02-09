/*
Задача 62. Напишите программу, которая заполнит спирально массив 4 на 4.
Например, на выходе получается вот такой массив:
01 02 03 04
12 13 14 05
11 16 15 06
10 09 08 07
*/
int[,] InitMatrix(int size)
{
    int[,] matrix = new int[size, size];
    int number = 1;

    for (int i = 0; i < (size / 2 + size % 2); i++)
    {
        // идем вправо
        for (int col = i; col < size - i; col++)
        {
            matrix[i, col] = number++;
        }

        // идем вниз
        for (int row = i + 1; row < size - i; row++)
        {
            matrix[row, size - 1 - i] = number++;
        }

        // идем влево
        for (int col = size - 2 - i; col >= i; col--)
        {
            matrix[size - 1 - i, col] = number++;
        }

        // идем вверх
        for (int row = size - 2 - i; row > i; row--)
        {
            matrix[row, i] = number++;
        }
    }

    return matrix;
}

void PrintMatrix(int[,] matrix)
{
    for (int i = 0; i < matrix.GetLength(0); i++)
    {
        for (int j = 0; j < matrix.GetLength(1); j++)
        {
            Console.Write($"{matrix[i, j]:d2} ");
        }

        Console.WriteLine();
    }

    Console.WriteLine();
}

PrintMatrix(InitMatrix(4));