package prac2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

import static java.util.Arrays.*;

public class Server extends Thread {
    private final ServerSocket serverSocket;
    private final int port = 1001;

    public Server() throws IOException {
        serverSocket = new ServerSocket(port);
    }

    @Override
    @SuppressWarnings("InfiniteLoopStatement")
    public void run() {
        System.out.println("Server> Сервер запущен на порту: " + port);
        try {
            while (true) {
                new ClientHandler(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            System.err.println("Server> Ошибка во время ожидания соединения с клиентом: " + e.getMessage());
        }
    }

    private static class ClientHandler extends Thread {
        private BufferedReader fromClient;
        private PrintStream toClient;

        ClientHandler(Socket socket) {
            try {
                fromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            } catch (IOException e) {
                System.err.println("Server> Не удалось создать поток чтения от клиента" + e.getMessage());
            }
            try {
                toClient = new PrintStream(socket.getOutputStream());
            } catch (IOException e) {
                System.err.println("Server> Не удалось создать поток записи к клиенту: " + e.getMessage());
            }
            System.out.println("Server> Установлено соединение с клиентом: " + socket);
        }

        @Override
        @SuppressWarnings("InfiniteLoopStatement")
        public void run() {
            try {
                while (true) {
                    String message = fromClient.readLine();
                    if (message != null) {
                        System.out.println("Server> Получено сообщение от клиента: " + message);
                        int choice;
                        try {
                            choice = Integer.parseInt(message);
                        } catch (NumberFormatException e) {
                            toClient.println("Введите число. Доступные операции: [11, 14, 17, 20, 23]");
                            continue;
                        }
                        switch (choice) {
                            case 11 -> {
                                int[] nums = stream(fromClient.readLine().split("\s"))
                                        .mapToInt(Integer::parseInt)
                                        .toArray();
                                toClient.println(Solution.task11(nums[0], nums[1], nums[2]));
                            }
                            case 14 -> {
                                toClient.println(Solution.task14(Double.parseDouble(fromClient.readLine())));
                            }
                            case 17 -> {
                                int[] coords = stream(fromClient.readLine().split("\s"))
                                        .mapToInt(Integer::parseInt)
                                        .toArray();
                                toClient.println(Solution.task17(coords));
                            }
                            case 20 -> {
                                int[] xes = stream(fromClient.readLine().split("\s"))
                                        .mapToInt(Integer::parseInt)
                                        .toArray();
                                double[] res = Solution.task20(xes);
                                String resStr="";
                                for(int i=0; i < xes.length; i++){
                                    resStr += res[i] + " ";
                                }
                                toClient.println(resStr);
                            }
                            case 23 -> {
                                int[] nums = stream(fromClient.readLine().split("\s"))
                                        .mapToInt(Integer::parseInt)
                                        .toArray();
                                boolean[] res = Solution.task23(nums);
                                String resStr="";
                                for(int i=0; i < nums.length; i++){
                                    resStr += "Число " + nums[i] + " - ";
                                    if(res[i]){
                                        resStr += " простое. ";
                                    }
                                    else resStr += " не простое. ";

                                }
                                toClient.println(resStr);
                            }
                            default -> {
                                toClient.println("Выбранная не доступная операция. Доступные операции: [11, 14, 17, 20, 23]");
                            }
                        }
                    }
                }
            } catch (IOException e) {
                System.err.println("Server> Не удалось получить сообщение от клиента: " + e.getMessage());
            }
        }
    }
}
