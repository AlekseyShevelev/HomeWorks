/*
Задача 34: Задайте массив заполненный случайными положительными трёхзначными числами. Напишите программу, которая покажет количество чётных чисел в массиве.

[345, 897, 568, 234] -> 2
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

    return Math.Abs(resultNumber);
}

int[] InitArray(int dimension)
{
    int[] arr = new int[dimension];
    Random rnd = new Random();

    for (int i = 0; i < dimension; i++)
    {
        arr[i] = rnd.Next(100, 1000);
    }

    return arr;
}

int GetNumberOfEven(int[] arr)
{
    int result = 0;

    for (int i = 0; i < arr.Length; i++)
    {
        if (arr[i] % 2 == 0) result++;
    }

    return result;
}

int number = GetNumber("Введите размерность массива:");
int[] array = InitArray(number);
Console.WriteLine($"Исходный массив: [{string.Join(", ", array)}]");
int numberOfEven = GetNumberOfEven(array);
Console.WriteLine($"Количество четных чисел в массиве {numberOfEven}");