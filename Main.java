import java.util.*;

public class Main
{
    protected static String lattersCarNumber = "АВЕКМНОРСТУХ";
    public static ArrayList<String> arrayCarNumberVip = new ArrayList<>();
    public static HashSet<String> hashCarNumberVip = new HashSet<>();
    public static TreeMap<String, Integer> treeCarNumberVip = new TreeMap<>();
    public static void main(String[] args)
    {

            creatCarNumberVip();
            Scanner scanner = new Scanner(System.in);
            for (;;)
            {
                String userLine = scanner.nextLine();


                long start = System.nanoTime();
                 System.out.println(arrayCarNumberVip.contains(userLine));
                 System.out.print("Прямой поиск ");
                System.out.println(System.nanoTime() - start);

                start = System.nanoTime();
                 System.out.println(Collections.binarySearch(arrayCarNumberVip, userLine));
                System.out.print("Бинарный поиск ");
                System.out.println(System.nanoTime() - start);


                start = System.nanoTime();
                 System.out.println(hashCarNumberVip.contains(userLine));
                System.out.print("Хэш мап ");
                System.out.println(System.nanoTime() - start);


                start = System.nanoTime();
                 System.out.println(treeCarNumberVip.containsKey(userLine));
                System.out.print("Дерево ");
                System.out.println(System.nanoTime() - start);


        }
    }

    public static void creatCarNumberVip()
    {
        int id = 0;
        for (int i = 0; i < lattersCarNumber.length(); i++)
        {
            String letters = Character.toString(lattersCarNumber.charAt(i));
            for (int j = 0; j < 10; j++)
            {
                String numbers = Integer.toString(j) + Integer.toString(j) + Integer.toString(j);
                for (int region = 0; region < 197; region++)
                {
                    String regionNumber = String.format("%03d", region);
                    String numberCar = letters + numbers + letters + letters + regionNumber;

                    arrayCarNumberVip.add(numberCar);
                    hashCarNumberVip.add(numberCar);
                    treeCarNumberVip.put(numberCar, id++);
                }
            }
        }
    }


}
