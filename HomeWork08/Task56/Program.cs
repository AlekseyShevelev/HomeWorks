/*
Задача 56: Задайте прямоугольный двумерный массив. Напишите программу, которая будет находить строку с наименьшей суммой элементов.

Например, задан массив:
1 4 7 2
5 9 2 3
8 4 2 4
5 2 6 7

Программа считает сумму элементов в каждой строке и выдаёт номер строки с наименьшей суммой элементов: 1 строка
*/
int GetNumber(string message)
{
    int result = 0;

    while (true)
    {
        Console.WriteLine(message);

        if (int.TryParse(Console.ReadLine(), out result) && result > 0)
            break;
        else
            Console.WriteLine("Ввели не число или некорректное число. Повторите ввод!\n");
    }

    return result;
}

int[,] InitMatrix(int rows, int columns)
{
    int[,] matrix = new int[rows, columns];
    Random rnd = new Random();

    for (int i = 0; i < matrix.GetLength(0); i++)
    {
        for (int j = 0; j < matrix.GetLength(1); j++)
        {
            matrix[i, j] = rnd.Next(1, 10);
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
            Console.Write($"{matrix[i, j]} ");
        }

        Console.WriteLine();
    }

    Console.WriteLine();
}

int FindMinRow(int[,] matrix)
{
    int minRow = 0, minSum = 0, sum = 0;

    for (int i = 0; i < matrix.GetLength(0); i++)
    {
        sum = 0;

        for (int j = 0; j < matrix.GetLength(1); j++)
        {
            sum += matrix[i, j];
        }

        if (i == 0 || sum < minSum)
        {
            minSum = sum;
            minRow = i;
        }
    }

    return minRow;
}

int rowsCount = GetNumber("Задайте количество строк:");
int columnsCount = GetNumber("Задайте количество столбцов:");
int[,] matrix = InitMatrix(rowsCount, columnsCount);
PrintMatrix(matrix);

Console.WriteLine($"{FindMinRow(matrix)} строка"); 