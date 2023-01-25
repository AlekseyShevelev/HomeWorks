/*
Задача 29: Напишите программу, которая задаёт массив из 8 элементов и выводит их на экран.

1, 2, 5, 7, 19 -> [1, 2, 5, 7, 19]

6, 1, 33 -> [6, 1, 33]
*/
/*
Примечание:
Так как текст задачи не коррелирует с примерами, я интерпретировал ее так:

Напишите программу, которая задаёт массив из N элементов и выводит их на экран.
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

int[] GetArray(int arraySize)
{
    int[] array = new int[arraySize];
    Random rnd = new Random();

    for (int i = 0; i < array.Length; i++)
    {
        array[i] = rnd.Next(0, 100);
    }

    return array;
}

void PrintArray(int[] array)
{
    string result = string.Empty;

    for (int i = 0; i < array.Length - 1; i++)
    {
        result += array[i].ToString() + ", ";
    }

    result += array[array.Length - 1].ToString();

    Console.WriteLine($"[{result}]");
}

int arraySize = GetNumber("Введите количество элементов в массиве:");
PrintArray(GetArray(arraySize));