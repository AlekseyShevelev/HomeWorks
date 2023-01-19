/*
Задача 15: Напишите программу, которая принимает на вход цифру, обозначающую день недели, и проверяет, является ли этот день выходным.

6 -> да
7 -> да
1 -> нет
*/
Console.WriteLine("Введите день недели (1-7):");
int day = Convert.ToInt32(Console.ReadLine());

if (day >= 1 && day <= 5)
{
    Console.WriteLine("Нет");
}
else if (day == 6 || day == 7)
{
    Console.WriteLine("Да");
}
else
{
    Console.WriteLine("Неверный день недели");
}
