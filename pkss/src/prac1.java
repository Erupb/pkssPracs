import java.util.Scanner;
import java.lang.Math;

public class prac1 {
    public static void main(String[] args) {
        // num 11
        //z11();
        //z14();
        //z17();
        //z20();
        z23();
    }
    public static void z11(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите четыре числа:");
        int[] numbers = new int[4];

        for (int i = 0; i < 4; i++) {
            System.out.print("Введите число #" + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        System.out.println("Числа, принадлежащие интервалу [1, 25]:");
        for (int number : numbers) {
            if (number >= 1 && number <= 25) {
                System.out.println(number);
            }
        }

        scanner.close();
    }

    public static void z14(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите значение x: ");
        double x = scanner.nextDouble();

        System.out.print("Введите значение y: ");
        double y = scanner.nextDouble();

        // Проверка деления на 0 (знаменатель не должен быть равен 0)
        if (y == 0) {
            System.out.println("Ошибка: Знаменатель (y) не может быть равен 0.");
        } else {
            double z = Math.log(x / y) - (1.0 / x);
            System.out.println("Значение функции z = log(x/y) - 1/x: " + z);
        }

        scanner.close();
    }
    public static void z17(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите радиус окружности R: ");
        double R = scanner.nextDouble();

        System.out.print("Введите координаты точки A (x1 y1): ");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();

        System.out.print("Введите координаты точки B (x2 y2): ");
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();

        double distanceA = Math.sqrt(x1 * x1 + y1 * y1); // Расстояние от начала координат до точки A
        double distanceB = Math.sqrt(x2 * x2 + y2 * y2); // Расстояние от начала координат до точки B

        if (Math.abs(distanceA - R) < 1e-6) {
            System.out.println("Точка A лежит на окружности.");
        } else {
            System.out.println("Точка A не лежит на окружности.");
        }

        if (Math.abs(distanceB - R) < 1e-6) {
            System.out.println("Точка B лежит на окружности.");
        } else {
            System.out.println("Точка B не лежит на окружности.");
        }

        scanner.close();
    }
    public static void z20(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите значение A: ");
        int A = scanner.nextInt();

        System.out.print("Введите значение B: ");
        int B = scanner.nextInt();

        System.out.print("Введите значение C: ");
        int C = scanner.nextInt();

        // Создаем массив для хранения переменных
        int[] variables = {A, B, C};

        // Сортируем переменные в порядке убывания
        java.util.Arrays.sort(variables);
        for (int i = variables.length - 1; i >= 0; i--) {
            System.out.println("Переменная " + (i + 1) + " в порядке убывания: " + variables[i]);
        }

        scanner.close();
    }
    public static void z23(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите значение x: ");
        double x = scanner.nextDouble();

        System.out.print("Введите значение y: ");
        double y = scanner.nextDouble();

        // Проверка деления на 0 (знаменатель не должен быть равен 0)
        if (y == 0) {
            System.out.println("Ошибка: Знаменатель (y) не может быть равен 0.");
        } else {
            double z = Math.log(x) - (x / y);
            System.out.println("Значение функции z = ln(x) - x/y: " + z);
        }

        scanner.close();
    }
}
