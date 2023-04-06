# Задача 38: Дополнить телефонный справочник возможностью изменения и удаления данных.
# Пользователь также может ввести имя или фамилию, и Вы должны реализовать функционал для изменения и удаления данных

def show_menu() -> int:
    print("\nВыберите необходимое действие:\n"
          "1. Отобразить весь справочник\n"
          "2. Найти абонента по фамилии\n"
          "3. Найти абонента по номеру телефона\n"
          "4. Добавить абонента в справочник\n"
          "5. Сохранить справочник в текстовом формате\n"
          "6. Изменить фамилию\n"
          "7. Изменить имя\n"
          "8. Удалить по фамилии\n"
          "9. Удалить по имени\n"
          "0. Закончить работу")
    choice = int(input())
    return choice

def read_csv(filename):
    data = []
    fields = ["Фамилия", "Имя", "Телефон", "Описание"]
    with open(filename, 'r', encoding='utf-8') as file:
        for line in file:
            record = dict(zip(fields, line.strip().split(',')))
            data.append(record)

    return data

def show_book(list):
    for el in list:
        for k, v in el.items():
            print(f'{k}: {v}')
        print()

def find_by_last_name(list):
    last_name = input("Ведите фамилию: ")

    found_list = []

    for d in list:
        if d['Фамилия'] == last_name:
            found_list.append(d)

    show_book(found_list)

def find_by_phone(list):
    phone_number = input("Ведите номер телефона: ")

    found_list = []

    for d in list:
        if d['Телефон'] == phone_number:
            found_list.append(d)

    show_book(found_list)

def add_to_book(filename):
    last_name = input('Ведите фамилию: ')
    first_name = input('Ведите имя: ')
    phone = input('Введите телефон: ')
    desc = input('Ведите описание: ')
    with open(filename, 'a', encoding='utf-8') as file:
        file.write(f'{last_name},{first_name},{phone},{desc}\n')

def save_to_txt(list):
    new_file_name = input("Введите имя файла: ")
    with open(new_file_name, 'w', encoding='utf-8') as file:
        for el in list:
            for v in el.values():
                file.write(f'{v}\n')

def save_to_file(list, filename):
    with open(filename, 'w', encoding='utf-8') as file:
        for el in list:
            file.write(f'{el["Фамилия"]},{el["Имя"]},{el["Телефон"]},{el["Описание"]}\n')

def change_last_name(list, filename):
    old_last_name = input("Введите фамилию, которую надо заменить: ")
    new_last_name = input("Введите новую фамилию: ")

    for el in list:
        if el["Фамилия"] == old_last_name:
            el["Фамилия"] = new_last_name

    save_to_file(list, filename)

def change_first_name(list, filename):
    old_first_name = input("Введите имя, которое надо заменить: ")
    new_first_name = input("Введите новое имя: ")

    for el in list:
        if el["Имя"] == old_first_name:
            el["Имя"] = new_first_name
            
    save_to_file(list, filename)

def del_by_last_name(list, filename):
    last_name = input("Введите фамилию, которую надо удалить: ")

    for i in range(len(list) - 1, -1, -1):
        if list[i]["Фамилия"] == last_name:
            list.pop(i)

    save_to_file(list, filename)

def del_by_first_name(list, filename):
    first_name = input("Введите имя, которое надо удалить: ")

    for i in range(len(list) - 1, -1, -1):
        if list[i]["Имя"] == first_name:
            list.pop(i)

    save_to_file(list, filename)

file_name = 'phonebook.csv'
phone_book = read_csv(file_name)

choice = show_menu()

while choice != 0:
    if choice == 1:
        show_book(phone_book)
    elif choice == 2:    
        find_by_last_name(phone_book)
    elif choice == 3:    
        find_by_phone(phone_book)
    elif choice == 4:    
        add_to_book(file_name)
        phone_book = read_csv(file_name)
    elif choice == 5:    
        save_to_txt(phone_book)
    elif choice == 6:    
        change_last_name(phone_book, file_name)
        phone_book = read_csv(file_name)        
    elif choice == 7:    
        change_first_name(phone_book, file_name)
        phone_book = read_csv(file_name)        
    elif choice == 8:    
        del_by_last_name(phone_book, file_name)
        phone_book = read_csv(file_name)        
    elif choice == 9:    
        del_by_first_name(phone_book, file_name)
        phone_book = read_csv(file_name) 

    choice = show_menu()

