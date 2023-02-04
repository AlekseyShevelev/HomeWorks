/*
Задача 50. Напишите программу, которая на вход принимает позиции элемента в двумерном массиве, и возвращает значение этого элемента или же указание, что такого элемента нет.
Например, задан массив:
1 4 7 2
5 9 2 3
8 4 2 4
пользователь вводит индексы 10, 10 - такого элемента нет.
пользователь вводите индексы 0, 2 - выводим элеменет 7
*/
int GetNumber(string message, bool zeroIsAllowed)
{
    int resultNumber = 0;

    while (true)
    {
        Console.WriteLine(message);

        if (int.TryParse(Console.ReadLine(), out resultNumber) && (zeroIsAllowed || resultNumber > 0))
        {
            break;
        }
        else
        {
            Console.WriteLine("Ввели не число или не корректное число. Повторите ввод!\n");
        }
    }

    return resultNumber;
}

int[,] InitMatrix(int rows, int columns)
{
    int[,] matrix = new int[rows, columns];
    Random rnd = new Random();

    for (int i = 0; i < rows; i++)
    {
        for (int j = 0; j < columns; j++)
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

void PrintElement(int[,] matrix, int row, int column)
{
    if (row > matrix.GetLength(0) - 1 || column > matrix.GetLength(1) - 1)
        Console.WriteLine("Такого элемента нет.");
    else
        Console.WriteLine(matrix[row, column]);
}

int rowsCount = GetNumber("Введите количество строк:", false);
int columnsCount = GetNumber("Введите количество столбцов:", false);

int[,] matrix = InitMatrix(rowsCount, columnsCount);
PrintMatrix(matrix);

int row = GetNumber("Введите строку элемента:", true);
int column = GetNumber("Введите столбец элемента:", true);

PrintElement(matrix, row, column);