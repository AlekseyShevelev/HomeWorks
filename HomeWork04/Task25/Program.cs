/*
Задача 25: Напишите цикл, который принимает на вход два числа (A и B) и возводит число A в натуральную степень B.

3, 5 -> 243 (3⁵)

2, 4 -> 16
*/
int GetNumber(string message)
{
    int resultNumber = 0;

    while (true)
    {
        Console.WriteLine(message);

        if (int.TryParse(Console.ReadLine(), out resultNumber) && resultNumber >= 0)
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

int GetPower(int a, int b)
{
    int power = 1;

    for (int i = 1; i <= b; i++)
    {
        power *= a;
    }

    return power;
}

int a = GetNumber("Введите положительное число A:");
int b = GetNumber("Введите положительное число B:");
Console.WriteLine(GetPower(a, b));