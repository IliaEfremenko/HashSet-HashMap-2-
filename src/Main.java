import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Address add1 = new Address("Россия", "Казань");
        Address add3 = new Address("Россия", "Кудыкины Горы");
        Address add4 = new Address("Россия", "Гора рако-свист");
        Address add5 = new Address("Россия", "Туда не знаю куда");
        Address add6 = new Address("Там не знаю где", "Туда не знаю куда");

        Map<Address, Integer> costPerAddress = new HashMap<>();
        costPerAddress.put(add1, 200);
        costPerAddress.put(add3, 300);
        costPerAddress.put(add4, 150);
        costPerAddress.put(add5, 200);
        costPerAddress.put(add6, 500);

        Set<String> unicCounty = new HashSet<>();

        int priceSum = 0;
        while (true) {
            System.out.println("Заполнение нового заказа.");
            System.out.print("Введите страну: ");
            String country = scanner.nextLine();
            if ("end".equals(country)) {
                break;
            }
            System.out.print("Введите город: ");
            String city = scanner.nextLine();
            System.out.print("Введите вес (кг): ");
            int weight = Integer.parseInt(scanner.nextLine());

            Address address = new Address(country, city);
            if (!costPerAddress.containsKey(address)) {
                System.out.println("Доставки по этому адресу нет");
                System.out.println();
                continue;
            }
            int price = costPerAddress.get(address) * weight;
            priceSum += price;

            unicCounty.add(country);

            System.out.println("Стоимость доставки составит: " + price);
            System.out.println("Общая стоимость всех доставок: " + priceSum);
            System.out.println("Количество уникальных стран, в которые было соверлена доставка: " + unicCounty.size());
            System.out.println();
        }

        System.out.println();

        System.out.println("Программа завершена!");
    }
}