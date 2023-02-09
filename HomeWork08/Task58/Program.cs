/*
Задача 58: Задайте две матрицы. Напишите программу, которая будет находить произведение двух матриц.
Например, даны 2 матрицы:
2 4 | 3 4
3 2 | 3 3
Результирующая матрица будет:
18 20
15 18
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

int[,] MultiplyMatrices(int[,] matrix1, int[,] matrix2)
{
    int[,] newMatrix = new int[matrix1.GetLength(0), matrix2.GetLength(1)];

    for (int i = 0; i < newMatrix.GetLength(0); i++)
    {
        for (int j = 0; j < newMatrix.GetLength(1); j++)
        {
            newMatrix[i, j] = 0;

            for (int k = 0; k < matrix1.GetLength(1); k++)
            {
                newMatrix[i, j] += matrix1[i, k] * matrix2[k, j];
            }
        }
    }

    return newMatrix;
}

int rowsCount1 = GetNumber("Задайте количество строк первой матрицы:");
int columnsCount1 = GetNumber("Задайте количество столбцов первой матрицы:");
int rowsCount2 = GetNumber("Задайте количество строк второй матрицы:");
int columnsCount2 = GetNumber("Задайте количество столбцов второй матрицы:");

if (columnsCount1 != rowsCount2)
{
    Console.WriteLine("Матрицы несовместимы.");
}
else
{
    int[,] matrix1 = InitMatrix(rowsCount1, columnsCount1);
    int[,] matrix2 = InitMatrix(rowsCount2, columnsCount2);
    PrintMatrix(matrix1);
    PrintMatrix(matrix2);

    PrintMatrix(MultiplyMatrices(matrix1, matrix2));
}
