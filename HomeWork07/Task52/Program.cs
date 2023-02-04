/*
Задача 52. Задайте двумерный массив из целых чисел. Найдите среднее арифметическое элементов в каждом столбце.

Например, задан массив:
1 4 7 2
5 9 2 3
8 4 2 4
Среднее арифметическое каждого столбца: 4,6; 5,6; 3,6; 3.
*/
int GetNumber(string message)
{
    int resultNumber = 0;

    while (true)
    {
        Console.WriteLine(message);

        if (int.TryParse(Console.ReadLine(), out resultNumber) && resultNumber > 0)
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

void PrintArithmeticMeanOfColumns(int[,] matrix)
{
    double sum;

    for (int j = 0; j < matrix.GetLength(1); j++)
    {
        sum = 0;
        
        for (int i = 0; i < matrix.GetLength(0); i++)
        {
            sum += matrix[i, j];
        }

        Console.Write(Math.Round(sum / matrix.GetLength(0), 1, MidpointRounding.ToZero));

        if (j < matrix.GetLength(1) - 1)
            Console.Write("; ");
        else
            Console.WriteLine(".");
    }
}

int rowsCount = GetNumber("Введите количество строк:");
int columnsCount = GetNumber("Введите количество столбцов:");
int[,] matrix = InitMatrix(rowsCount, columnsCount);
PrintMatrix(matrix);
PrintArithmeticMeanOfColumns(matrix);