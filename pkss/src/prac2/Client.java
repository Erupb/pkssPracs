package prac2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Client extends Thread {
    private final BufferedReader fromServer;
    private final PrintStream toServer;

    public Client() throws IOException {
        Socket socket = new Socket("localhost", 1001);
        fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        toServer = new PrintStream(socket.getOutputStream());
    }

    @Override
    @SuppressWarnings("InfiniteLoopStatement")
    public void run() {
        try {
            while (true) {
                System.out.println("Client> Выберите операцию: [11, 14, 17, 20, 23]");
                Scanner scanner = new Scanner(System.in);
                int choice;
                try {
                    choice = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Client> Введите число. Доступные операции: [11, 14, 17, 20, 23]");
                    continue;
                }
                switch (choice) {
                    case 11 -> {
                        System.out.println("Client> Введите 3 числа:");
                        StringBuilder stringBuilder = new StringBuilder();
                        try {
                            stringBuilder.append(scanner.nextInt());
                            stringBuilder.append(" ");
                            stringBuilder.append(scanner.nextInt());
                            stringBuilder.append(" ");
                            stringBuilder.append(scanner.nextInt());
                        } catch (InputMismatchException e) {
                            System.err.println("Некорректный ввод!");
                            continue;
                        }
                        toServer.println(choice);
                        toServer.println(stringBuilder);
                    }
                    case 14 -> {
                        System.out.println("Client> Введите 1 число:");
                        double number;
                        try {
                            number = scanner.nextDouble();
                        } catch (InputMismatchException e) {
                            System.err.println("Некорректный ввод!");
                            continue;
                        }
                        toServer.println(choice);
                        toServer.println(number);
                    }
                    case 17 -> {
                        System.out.println("Client> Введите координаты восьмиугольника:");
                        StringBuilder stringBuilder = new StringBuilder();
                        try {
                            for (int i = 0; i < 16; i++) {
                                stringBuilder.append(scanner.nextInt());
                                stringBuilder.append(" ");
                            }
                        } catch (InputMismatchException e) {
                            System.err.println("Некорректный ввод!");
                            continue;
                        }
                        toServer.println(choice);
                        toServer.println(stringBuilder);
                    }
                    case 20 -> {
                        System.out.println("Client> Введите количество чисел:");
                        StringBuilder stringBuilder = new StringBuilder();
                        int n = scanner.nextInt();
                        for(int i=0; i<n; i++){
                            stringBuilder.append(scanner.nextInt());
                            stringBuilder.append(" ");
                        }
                        toServer.println(choice);
                        toServer.println(stringBuilder);
                    }
                    case 23 -> {
                        System.out.println("Client> Введите 10 чисел:");
                        StringBuilder stringBuilder = new StringBuilder();
                        try {
                            for (int i = 0; i < 10; i++) {
                                stringBuilder.append(scanner.nextInt());
                                stringBuilder.append(" ");
                            }
                        } catch (InputMismatchException e) {
                            System.err.println("Некорректный ввод!");
                            continue;
                        }
                        toServer.println(choice);
                        toServer.println(stringBuilder);
                    }

                    default -> {
                        System.out.println("Client> Выбрана не допустимая операция. Доступные операции: [5, 8, 11, 14, 17]");
                        continue;
                    }
                }
                String message = fromServer.readLine();
                if (message != null) {
                    System.out.println("Client> Получено сообщение от сервера: " + message);
                }
            }
        } catch (IOException e) {
            System.err.println("Client> не удалось прочитать сообщение от сервера: " + e.getMessage());
        }
    }
}
