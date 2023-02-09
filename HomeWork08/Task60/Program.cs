/*
Задача 60. ...Сформируйте трёхмерный массив из неповторяющихся двузначных чисел. Напишите программу, которая будет построчно выводить массив, добавляя индексы каждого элемента.

Массив размером 2 x 2 x 2
66(0,0,0) 25(0,1,0)
34(1,0,0) 41(1,1,0)
27(0,0,1) 90(0,1,1)
26(1,0,1) 55(1,1,1)
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

int[,,] InitArray(int size1, int size2, int size3)
{
    int[,,] array = new int[size1, size2, size3];
    Random rnd = new Random();
    HashSet<int> usedNumbers = new HashSet<int>();
    int newNumber;

    for (int i = 0; i < array.GetLength(0); i++)
    {
        for (int j = 0; j < array.GetLength(1); j++)
        {
            int k = 0;

            while (k < array.GetLength(2))
            {
                newNumber = rnd.Next(10, 100);

                if (!usedNumbers.Contains(newNumber))
                {
                    array[i, j, k] = newNumber;
                    usedNumbers.Add(newNumber);
                    k++;
                }
            }
        }
    }

    return array;
}

void PrintArray(int[,,] array)
{
    for (int k = 0; k < array.GetLength(2); k++)
    {
        for (int i = 0; i < array.GetLength(0); i++)
        {
            for (int j = 0; j < array.GetLength(1); j++)
            {
                Console.Write($"{array[i, j, k]}({i},{j},{k}) ");
            }

            Console.WriteLine();
        }
    }

    Console.WriteLine();
}

int size1 = GetNumber("Задайте первую размерность массива:");
int size2 = GetNumber("Задайте вторую размерность массива:");
int size3 = GetNumber("Задайте третью размерность массива:");

if (size1 * size2 * size3 > 90)
{
    Console.WriteLine("Массив слишком большой.");
}
else
{
    PrintArray(InitArray(size1, size2, size3));
}