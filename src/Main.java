import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        Scanner scanner = new Scanner(System.in);

        logger.log("Запускаем программу");

        logger.log("Просим пользователя ввести входные данные для списка");

        int sizeList;
        while(true){
            System.out.println("Введите размер списка:");
            try {
                sizeList = Integer.parseInt(scanner.nextLine());
                if(sizeList > 0){
                    break;
                }
                logger.log("Размер списка должен быть > 0. Повторите ввод!");
            } catch (Exception e){
                logger.log("Требуется число! Введите числовое значение.");
            }
        }

        int maxValues;
        while(true){
            System.out.println("Введите верхнюю границу для значений:");
            try {
                maxValues = Integer.parseInt(scanner.nextLine());
                if(maxValues > 0){
                    break;
                }
                logger.log("Верхняя граница для значений должна быть > 0. Повторите ввод!");
            } catch (Exception e){
                logger.log("Требуется число! Введите числовое значение.");
            }
        }

        logger.log("Создаём и наполняем список");
        List<Integer> list = new Random().ints(sizeList, 0, maxValues).boxed().toList();
        System.out.print("Вот случайный список: ");
        list.forEach(x -> System.out.print(x + " "));
        System.out.println();

        logger.log("Просим пользователя ввести входные данные для фильтрации");
        int threshold;
        while(true){
            System.out.println("Введите порог для фильтра:");
            try {
                threshold = Integer.parseInt(scanner.nextLine());
                if(threshold > 0){
                    break;
                }
                logger.log("Порог должен быть > 0. Повторите ввод!");
            } catch (Exception e){
                logger.log("Требуется число! Введите числовое значение.");
            }
        }

        logger.log("Запускаем фильтрацию");
        Filter filter = new Filter(threshold);
        list = filter.filterOut(list);

        logger.log("Прошло фильтр " + list.size() + " элемента из " + sizeList);

        logger.log("Выводим результат на экран");
        System.out.print("Отфильтрованный список: ");
        list.forEach(x -> System.out.print(x + " "));
        System.out.println();

        logger.log("Завершаем программу");
    }
}