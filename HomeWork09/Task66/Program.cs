/*
Задача 66: Задайте значения M и N. Напишите программу, которая найдёт сумму натуральных элементов в промежутке от M до N.

M = 1; N = 15 -> 120
M = 4; N = 8. -> 30
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

int GetSumOfNaturalNumbers(int m, int n)
{
    if (m == n)
        return m;
    else
        return m + GetSumOfNaturalNumbers(m + 1, n);
}

int m = GetNumber("Введите число M: ");
int n = GetNumber("Введите число N: ");
Console.WriteLine(GetSumOfNaturalNumbers(m, n));
