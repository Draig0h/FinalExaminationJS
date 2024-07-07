package FinalExamination;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class LaptopSet {
    public static void main(String[] args) {
        Set<Laptop> laptops = new HashSet<>();
        laptops.add(new Laptop("Model1", 256, 1000, "Windows", "Black"));
        laptops.add(new Laptop("Model2", 512, 512, "MacOs", "White"));
        laptops.add(new Laptop("Model3", 1024, 126, "Linux", "Grey"));
        laptops.add(new Laptop("Model4", 256, 1000, "Windows", "Orange"));
        laptops.add(new Laptop("Model5", 512, 512, "MacOs", "Red"));
        laptops.add(new Laptop("Model6", 1024, 126, "Linux", "Blue"));
        laptops.add(new Laptop("Model7", 124, 1000, "Windows", "Black"));
        laptops.add(new Laptop("Model8", 512, 512, "Windows", "White"));
        laptops.add(new Laptop("Model9", 1024, 126, "Windows", "Grey"));

        Map<Integer, String> criterionMap = new HashMap<>();
        criterionMap.put(1, "ram");
        criterionMap.put(2, "hdd");
        criterionMap.put(3, "os");
        criterionMap.put(4, "color");

        Scanner scanner = new Scanner(System.in);

        Map<String, String> filters = new HashMap<>();
        while (true) {
            try {
                if (!filters.isEmpty()) {
                    System.out.println("Current criteria:");
                    for (Map.Entry<String, String> entry : filters.entrySet()) {
                        System.out.println(entry.getKey() + ": " + entry.getValue());
                    }
                }
                System.out.println("Enter the number corresponding to the required criterion:");
                System.out.println("1. RAM");
                System.out.println("2. Size HDD");
                System.out.println("3. OS");
                System.out.println("4. Color");
                int criterion = scanner.nextInt();
                if (criterionMap.containsKey(criterion)) {
                    String criterionKey = criterionMap.get(criterion);
                    System.out.println("Enter value for " + criterionKey + ":");
                    String value = scanner.next();
                    filters.put(criterionKey, value);
                } else {
                    System.out.println("Invalid criterion. Retry.");
                }

                System.out.println("Continue entering criteria? (yes or no)");
                String continueInput = scanner.next();
                if (continueInput.equalsIgnoreCase("no")) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("An input error occurred: " + e.getMessage());
                scanner.nextLine();
            }
        }
        scanner.close();

        Set<Laptop> filteredLaptops = filterLaptops(laptops, filters);
        if (filteredLaptops.isEmpty()) {
            System.out.println("No laptops found.");
        } else {
            System.out.println("Laptops:");
            for (Laptop laptop : filteredLaptops) {
                System.out.println(laptop);
            }
        }
    }

    public static Set<Laptop> filterLaptops(Set<Laptop> laptops, Map<String, String> filters) {
        Set<Laptop> filteredLaptops = new HashSet<>(laptops);

        // Применение каждого фильтра
        for (Map.Entry<String, String> filter : filters.entrySet()) {
            String key = filter.getKey();
            String value = filter.getValue();

            switch (key) {
                case "ram":
                    int ram = Integer.parseInt(value);
                    filteredLaptops.removeIf(laptop -> laptop.ram != ram);
                    break;
                case "hdd":
                    int sizeHdd = Integer.parseInt(value);
                    filteredLaptops.removeIf(laptop -> laptop.sizeHdd != sizeHdd);
                    break;
                case "os":
                    filteredLaptops.removeIf(laptop -> !laptop.os.equalsIgnoreCase(value));
                    break;
                case "color":
                    filteredLaptops.removeIf(laptop -> !laptop.color.equalsIgnoreCase(value));
                    break;
            }
        }
        return filteredLaptops;
    }
}