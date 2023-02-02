/*
Задача 43: Напишите программу, которая найдёт точку пересечения двух прямых, заданных уравнениями y = k1 * x + b1, y = k2 * x + b2; значения b1, k1, b2 и k2 задаются пользователем.

b1 = 2, k1 = 5, b2 = 4, k2 = 9 -> (-0,5; -0,5)
*/
double GetNumber(string message)
{
    double resultNumber = 0;

    while (true)
    {
        Console.WriteLine(message);

        if (double.TryParse(Console.ReadLine(), out resultNumber))
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

(double, double) GetPointOfIntersection(double b1, double k1, double b2, double k2)
{
    double x = (b2 - b1) / (k1 - k2);
    double y = (k1 * b2 - k2 * b1) / (k1 - k2);
    return (x, y);
}

double b1 = GetNumber("Введите b1:");
double k1 = GetNumber("Введите k1:");
double b2 = GetNumber("Введите b2:");
double k2 = GetNumber("Введите k2:");

if (k1 == k2)
{
    Console.WriteLine("Прямые не имеют точки пересечения");
}
else
{
    (double, double) point = GetPointOfIntersection(b1, k1, b2, k2);
    Console.WriteLine($"Точка пересечения двух прямых ({point.Item1}; {point.Item2})");
}