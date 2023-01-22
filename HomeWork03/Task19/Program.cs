/*
Задача 19

Напишите программу, которая принимает на вход пятизначное число и проверяет, является ли оно палиндромом.

14212 -> нет

12821 -> да

23432 -> да
*/
int GetNumber(string message)
{
    int resultNumber = 0;

    while (true)
    {
        Console.WriteLine(message);

        if (int.TryParse(Console.ReadLine(), out resultNumber) && resultNumber >= 10000 && resultNumber <= 99999)
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

bool isPalindrome(int number)
{
    return (number / 10000 == number % 10) && (number / 1000 % 10 == number / 10 % 10);
}

int number = GetNumber("Введите пятизначное число:");

if (isPalindrome(number))
{
    Console.WriteLine("Да");
}
else
{
    Console.WriteLine("Нет");
}