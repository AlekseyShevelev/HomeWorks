/*
Задача 38: Задайте массив вещественных чисел. Найдите разницу между максимальным и минимальным элементов массива.

[3 7 22 2 78] -> 76
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

double[] InitArray(int dimension)
{
    double[] arr = new double[dimension];
    Random rnd = new Random();

    for (int i = 0; i < dimension; i++)
    {
        arr[i] = Math.Round(rnd.NextDouble() * 100, 2);
    }

    return arr;
}

double GetDiffMaxMin(double[] arr)
{
    double minValue = arr[0];
    double maxValue = arr[0];

    for (int i = 1; i < arr.Length; i++)
    {
        if (arr[i] < minValue) minValue = arr[i];
        if (arr[i] > maxValue) maxValue = arr[i];
    }

    return (maxValue - minValue);
}

int number = GetNumber("Введите размерность массива:");
double[] array = InitArray(number);
Console.WriteLine($"Исходный массив: [{string.Join("; ", array)}]");
double diff = GetDiffMaxMin(array);
Console.WriteLine($"Разница между максимальным и минимальным элементов массива = {diff}");