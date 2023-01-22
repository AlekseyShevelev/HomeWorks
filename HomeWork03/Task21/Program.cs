/*
Задача 21

Напишите программу, которая принимает на вход координаты двух точек и находит расстояние между ними в 3D пространстве.

A (3,6,8); B (2,1,-7), -> 15.84

A (7,-5, 0); B (1,-1,9) -> 11.53
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
            Console.WriteLine("Ввели не число. Повторите ввод!\n");
        }
    }

    return resultNumber;
}

double getDistance(int ax, int ay, int az, int bx, int by, int bz)
{
    return Math.Sqrt(Math.Pow(bx - ax, 2) + Math.Pow(by - ay, 2) + Math.Pow(bz - az, 2));
}

int ax = GetNumber("Введите координату X первого числа:");
int ay = GetNumber("Введите координату Y первого числа:");
int az = GetNumber("Введите координату Z первого числа:");
int bx = GetNumber("Введите координату X второго числа:");
int by = GetNumber("Введите координату Y второго числа:");
int bz = GetNumber("Введите координату Z второго числа:");

double distance = getDistance(ax, ay, az, bx, by, bz);

Console.WriteLine($"Расстояние между точкой с координатами ({ax},{ay},{az}) и точкой с координатами ({bx},{by},{bz}) равно {distance:f2}");
