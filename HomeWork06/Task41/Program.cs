/*
Задача 41: Пользователь вводит с клавиатуры M чисел. Посчитайте, сколько чисел больше 0 ввёл пользователь.

0, 7, 8, -2, -2 -> 2

1, -7, 567, 89, 223-> 3
*/
int[] GetArray(string message)
{
    int resultNumber = 0;
    string[] strArr;
    int[] arr = { };
    bool isContinue = true;

    Console.WriteLine(message);

    while (isContinue)
    {
        strArr = Console.ReadLine()!.Split(',');
        arr = new int[strArr.Length];
        isContinue = false;

        for (int i = 0; i < strArr.Length; i++)
        {
            if (int.TryParse(strArr[i], out resultNumber))
            {
                arr[i] = resultNumber;
            }
            else
            {
                Console.WriteLine("Ввели не число или не корректное число. Повторите ввод!\n");
                isContinue = true;
                break;
            }
        }
    }

    return arr;
}

int GetNumberOfPositive(int[] arr)
{
    int result = 0;

    for (int i = 0; i < arr.Length; i++)
    {
        if (arr[i] > 0) result++;
    }

    return result;
}

int[] array = GetArray("Введите строку чисел (через запятую):");
int numberOfPositive = GetNumberOfPositive(array);
Console.WriteLine($"Количество положительных чисел: {numberOfPositive}");
