/*
Задача 68: Напишите программу вычисления функции Аккермана с помощью рекурсии. Даны два неотрицательных числа m и n.
m = 2, n = 3 -> A(m,n) = 9
m = 3, n = 2 -> A(m,n) = 29
*/
int GetNumber(string message)
{
    int resultNumber = 0;

    while (true)
    {
        Console.Write(message);

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

int GetAckermanFunction(int m, int n)
{
    if (m == 0)
        return n + 1;
    else if (n == 0)
        return GetAckermanFunction(m - 1, 1);
    else
        return GetAckermanFunction(m - 1, GetAckermanFunction(m, n - 1));
}

int m = GetNumber("Введите число m: ");
int n = GetNumber("Введите число m: ");
Console.WriteLine(GetAckermanFunction(m, n));
