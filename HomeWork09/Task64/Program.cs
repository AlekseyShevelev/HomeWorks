/*
Задача 64: Задайте значение N. Напишите программу, которая выведет все натуральные числа в промежутке от N до 1. Выполнить с помощью рекурсии.

N = 5 -> "5, 4, 3, 2, 1"
N = 8 -> "8, 7, 6, 5, 4, 3, 2, 1"
*/
int GetNumber(string message)
{
    int resultNumber = 0;

    while (true)
    {
        Console.Write(message);

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

string GetNaturalNumbers(int n)
{
    if (n == 1)
        return "1";
    else
        return $"{n}, " + GetNaturalNumbers(n - 1);
}

int number = GetNumber("Введите число: ");
Console.WriteLine(GetNaturalNumbers(number));
