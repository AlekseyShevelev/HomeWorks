/*
Задача 13: Напишите программу, которая выводит третью цифру заданного числа или сообщает, что третьей цифры нет.

645 -> 5

78 -> третьей цифры нет

32679 -> 6
*/

int GetThirdDigit(int number)
{
    int result = -1;

    if (number > 99)
    {
        while (number > 999)
        {
            number = number / 10;
        }

        result = number % 10;
    }

    return result;
}

Console.WriteLine("Введите число:");
int digit = GetThirdDigit(Convert.ToInt32(Console.ReadLine()));

if (digit == -1)
{
    Console.WriteLine("Третьей цифры нет");
}
else
{
    Console.WriteLine(digit);
}

/*
// Второй вариант
Console.WriteLine("Введите число:");
int number = Math.Abs(Convert.ToInt32(Console.ReadLine()));

if (number < 100)
{
    Console.WriteLine("Третьей цифры нет");
}
else
{
    Console.WriteLine(Convert.ToString(number)[2]);
}
*/