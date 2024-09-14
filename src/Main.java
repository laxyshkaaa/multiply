import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод чисел
        System.out.println("Введите первое число: ");
        int num = scanner.nextInt();
        System.out.println("Введите второе число: ");
        int num2 = scanner.nextInt();

        System.out.println("Выберите метод умножения: ");
        System.out.println("1. Умножение через логарифмы");
        System.out.println("2. Умножение через удвоение и деление на два (метод древних египтян)");
        System.out.println("3. Умножение через последовательное вычитание");

        int choice = scanner.nextInt();

        // Выбор способа через switch
        switch (choice) {
            case 1:
                System.out.println("Результат (через логарифмы): " + multiplyUsingLogarithms(num, num2));
                break;

            case 2:
                System.out.println("Результат (через удвоение и деление): " + multiplyUsingDoubling(num, num2));
                break;

            case 3:
                System.out.println("Результат (через вычитание): " + multiplyUsingSubtraction(num, num2));
                break;

            default:
                System.out.println("Неверный выбор!");
        }

        scanner.close();
    }

    // Способ 1: Умножение через логарифмы
    public static int multiplyUsingLogarithms(int num, int num2) {
        if (num == 0 || num2 == 0) {
            return 0;
        }

        // Используем свойства логарифмов для умножения
        double result = Math.exp(Math.log(Math.abs(num)) + Math.log(Math.abs(num2)));

        // Определяем правильный знак результата
        if ((num < 0 && num2 > 0) || (num > 0 && num2 < 0)) {
            result = -result;
        }

        return (int) result;
    }

    // Способ 2: Умножение через удвоение и деление на два (метод древних египтян)
    public static int multiplyUsingDoubling(int num, int num2) {
        int result = 0;

        // Работаем с положительными числами, результат определяется позже
        int absNum = Math.abs(num);
        int absNum2 = Math.abs(num2);

        while (absNum2 > 0) {
            // Если второе число нечётное, прибавляем текущее значение первого числа к результату
            if (absNum2 % 2 != 0) {
                result += absNum;
            }

            // Удваиваем первое число
            absNum <<= 1; // Удваиваем значение (битовый сдвиг влево)
            // Делим второе число на два
            absNum2 >>= 1; // Делим значение пополам (битовый сдвиг вправо)
        }

        // Если одно из исходных чисел было отрицательным, делаем результат отрицательным
        if ((num < 0 && num2 > 0) || (num > 0 && num2 < 0)) {
            result = -result;
        }

        return result;
    }

    // Способ 3: Умножение через последовательное вычитание
    public static int multiplyUsingSubtraction(int num, int num2) {
        int result = 0;
        boolean isNegative = false;

        if (num2 < 0) {
            num2 = -num2; // Преобразуем отрицательный множитель в положительный
            isNegative = true; // Запоминаем, что результат будет отрицательным
        }

        for (int i = 0; i < num2; i++) {
            result -= -num; // Вычитаем отрицательное num, что эквивалентно умножению
        }

        return isNegative ? -result : result; // Если один из множителей был отрицательным, меняем знак результата
    }
}
