package task1;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class Main {
    public static void main(String[] args) {
        /*
        В качестве задачи предлагаю вам реализовать код для демонстрации парадокса Монти Холла (Парадокс Монти Холла — Википедия )
        и наглядно убедиться в верности парадокса (запустить игру в цикле на 1000 и вывести итоговый счет).
        Необходимо:
        Создать свой Java Maven или Gradle проект;
        Подключите зависимость lombok и возможно какую то математическую библиотеку (напр. commons-math3)
        Самостоятельно реализовать прикладную задачу;
        Сохранить результат игр в одну из коллекций или в какой-то библиотечный класс.
        Вывести на экран статистику по победам и поражениям
        В качестве ответа прислать ссылку на репозиторий, в котором присутствует все важные файлы проекта (напр pom.xml)
         */

        DescriptiveStatistics statistics = new DescriptiveStatistics();

        for (int i = 0; i < 1000; i++) {
            statistics.addValue(new Game().playGame(false));
        }
        System.out.printf("Игра без смены двери игроком. Всего попыток: %d, выиграно %.1f%%\n", statistics.getN(), statistics.getMean() * 100);

        statistics.clear();

        for (int i = 0; i < 1000; i++) {
            statistics.addValue(new Game().playGame(true));
        }
        System.out.printf("Игра со сменой двери игроком. Всего попыток: %d, выиграно %.1f%%\n", statistics.getN(), statistics.getMean() * 100);
    }
}
