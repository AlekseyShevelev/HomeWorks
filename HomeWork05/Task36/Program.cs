/*
Задача 36: Задайте одномерный массив, заполненный случайными числами. Найдите сумму элементов, стоящих на нечётных позициях.

[3, 7, 23, 12] -> 19

[-4, -6, 89, 6] -> 0
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
        arr[i] = rnd.Next(-99, 100);
    }

    return arr;
}

int GetSumOfElemetsInOddPositions(int[] arr)
{
    int sum = 0;

    for (int i = 1; i < arr.Length; i += 2)
    {
        sum += arr[i];
    }

    return sum;
}

int number = GetNumber("Введите размерность массива:");
int[] array = InitArray(number);
Console.WriteLine($"Исходный массив: [{string.Join(", ", array)}]");
int sum = GetSumOfElemetsInOddPositions(array);
Console.WriteLine($"Сумма элементов, стоящих на нечётных позициях = {sum}");
