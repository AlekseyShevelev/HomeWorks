/*
Задача 27: Напишите программу, которая принимает на вход число и выдаёт сумму цифр в числе.

452 -> 11

82 -> 10

9012 -> 12
*/
int GetNumber(string message)
{
    int resultNumber = 0;

    while (true)
    {
        Console.WriteLine(message);

        if (int.TryParse(Console.ReadLine(), out resultNumber))
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

int GetSumOfDigits(int number)
{
    int sum = 0;

    while (number > 0)
    {
        sum += number % 10;
        number = number / 10;
    }

    return sum;
}

int number = GetNumber("Введите число:");
Console.WriteLine(GetSumOfDigits(number));
