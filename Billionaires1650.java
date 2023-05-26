import java.util.*;

public class Billionaires1650 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Long> man_money = new HashMap<>();
        Map<String, String> man_city = new HashMap<>();
        Map<String, Long> city_money = new HashMap<>();
        Map<Long, Set<String>> money_cities = new TreeMap<>(Collections.reverseOrder());
        TreeMap<String, Integer> city_top = new TreeMap<>();

        int n = scanner.nextInt();
        long money;
        String name, city;
        for (int i = 0; i < n; i++) {
            name = scanner.next();
            city = scanner.next();
            money = scanner.nextLong();
            man_money.put(name, money);
            man_city.put(name, city);
            if (city_money.containsKey(city)) {
                long sum = city_money.get(city);
                money_cities.get(sum).remove(city);
                if (money_cities.get(sum).size() == 0)
                    money_cities.remove(sum);
            }
            city_money.put(city, city_money.getOrDefault(city, 0L) + money);
            money_cities.computeIfAbsent(city_money.get(city), k -> new HashSet<>()).add(city);
        }

        int days = scanner.nextInt();
        int m = scanner.nextInt();
        int pred_day = 0, this_day;
        for (int i = 0; i < m; i++) {
            this_day = scanner.nextInt();
            name = scanner.next();
            city = scanner.next();

            Iterator<Map.Entry<Long, Set<String>>> iterator = money_cities.entrySet().iterator();
            if (this_day != pred_day && iterator.hasNext()) {
                Map.Entry<Long, Set<String>> entry = iterator.next();
                if (entry.getValue().size() == 1)
                    city_top.merge(entry.getValue().iterator().next(), this_day - pred_day, Integer::sum);
            }

            String old_city = man_city.get(name);
            long old_money = city_money.get(old_city);
            money_cities.get(old_money).remove(old_city);
            if (money_cities.get(old_money).size() == 0)
                money_cities.remove(old_money);
            city_money.put(old_city, city_money.get(old_city) - man_money.get(name));
            money_cities.computeIfAbsent(city_money.get(old_city), k -> new HashSet<>()).add(old_city);

            long newMoney = city_money.getOrDefault(city, 0L);
            money_cities.computeIfAbsent(newMoney, k -> new HashSet<>()).remove(city);
            if (money_cities.get(newMoney).size() == 0)
                money_cities.remove(newMoney);
            city_money.put(city, city_money.getOrDefault(city, 0L) + man_money.get(name));
            money_cities.computeIfAbsent(city_money.get(city), k -> new HashSet<>()).add(city);

            man_city.put(name, city);
            pred_day = this_day;
        }

        this_day = days;
        Iterator<Map.Entry<Long, Set<String>>> iterator = money_cities.entrySet().iterator();
        if (this_day != pred_day && iterator.hasNext()) {
            Map.Entry<Long, Set<String>> entry = iterator.next();
            if (entry.getValue().size() == 1)
                city_top.merge(entry.getValue().iterator().next(), this_day - pred_day, Integer::sum);
        }
        for (Map.Entry<String, Integer> entry : city_top.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
