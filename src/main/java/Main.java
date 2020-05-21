import model.OrderData;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        // write your code here
        List nums = List.of(1,2,3);
        System.out.println(nums);

        List<OrderData> orderList = new ArrayList<OrderData>();
        orderList.add(new OrderData("order-1010"));
        orderList.add(new OrderData("order-2020"));

        List<OrderData> result = orderList.stream().filter(o ->
                o.OrderId().equals("order-1010")).collect(Collectors.toList());

        OrderData target = result.stream().findFirst().get();
        OrderData last = orderList.stream().reduce((a, b) -> b).orElse(null);


        //Immutable Array
        List<String> names = new ArrayList(Arrays.asList("foo", "bar"));
        names.add("alpha");
        List<String> unmodifiableList = List.of(names.toArray(new String[]{}));
        //unmodifiableList.add("bravo");


        //Lombok Test
        OrderData orderData1 = OrderData.builder().OrderId("ORD-001").build();
        OrderData orderData2 = OrderData.builder().OrderId("ORD-002").build();
        orderList.add(orderData1);
        orderList.add(orderData2);


        System.out.println(result);
        System.out.println(target.OrderId());
        System.out.println(last.OrderId());
        System.out.println(orderList.stream().count());


        //Interfaces Conflicted
        Employee empl = new Employee();
        System.out.println("empl's id : " + empl.getId());
        System.out.println("empl's secret id : " + empl.getSecretId());


        // Thread
        Runnable helloTask = new HelloTask();
        Thread helloThread = new Thread(helloTask);
        helloThread.start();
        System.out.println("thread is working...");

        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("thread name : " + threadName);
        };
        task.run();
        System.out.println("task is running..");
        Thread thread = new Thread(task);
        thread.start();
        System.out.println("thread is starting..");


        // Lambda
        BiFunction<Integer, Integer, Integer> sum = (a, b) -> a + b;
        System.out.println("lambda sample");
        System.out.println(sum.apply(50, 50));
        Comparator<Integer> myCompare = (a, b) -> {
          if (a > b) {
              return -1;
          }
          else if (a == b) {
              return 0;
          }
          else {
              return 1;
          }
        };
        System.out.println(myCompare.compare(1,5));
        System.out.println(myCompare.compare(4,2));

        // Predicate Sample
        Predicate<Integer> greaterThan1000 = (num) -> {
            if (num > 1000) {
                return  true;
            }
            return false;
        };
        Predicate<Integer> smallerThan4 = (num) -> {
            if (num < 4) return true;
            return false;
        };
        Predicate<Integer> isEvenNumber = (num) -> {
            if (num == 1) return false;
            if (num % 2 == 0) return true;
            return false;
        };
        System.out.println(greaterThan1000.test(1000));
        List<Integer> numList = Arrays.asList(1,2,3,4,2000,5000,10000, 3721);
        List<Integer> greaterList = numList.stream().filter(greaterThan1000).collect(Collectors.toList());
        System.out.println(greaterList);
        List<Integer> smallerList = numList.stream().filter(x -> x < 4).collect(Collectors.toList());
        System.out.println(smallerList);
        List<Integer> compositList = numList.stream().filter(
                smallerThan4.and(isEvenNumber)).collect(Collectors.toList());
        List<Integer> orList = numList.stream().filter(
                isEvenNumber.or(greaterThan1000)).collect(Collectors.toList());
        List<Integer> negateList = numList.stream().filter(
                smallerThan4.or(isEvenNumber).negate()).collect(Collectors.toList());

        List<String> testString = List.of("apple", "lemon", "vanilla", "car", "morning", "labtop", "city");
        List<String> resultString = StringProcessor.filter(testString, x -> x.length() <= 4).stream().collect(Collectors.toList());

        System.out.println(compositList);
        System.out.println(orList);
        System.out.println(negateList);
        System.out.println(resultString);

        Officer officer = new Developer(1000);
        officer.setSalary(500);
        System.out.println(officer.getSalary());
        System.out.println(officer.getRole());

        for (String item : testString) {
            System.out.println(String.format("item is %s", item));
        }

        int count = 1;
        Runnable action = new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable with captured variables: " + count);
            }
        };
        action.run();

        String name1 = "Tom";
        String name2 = "Tom";
        System.out.println(name1.equals(name2));
        System.out.println(name1.hashCode());
        System.out.println(name2.hashCode());

        Officer o1 = new Developer(200);
        Officer o2 = new Developer(200);
        System.out.println(o1.hashCode());
        System.out.println(o2.hashCode());
        System.out.println(o1.equals(o2));

        ArrayList<String> arrayList = new ArrayList<String>(100);
        arrayList.add("hello");
        arrayList.add("world");
        System.out.println(arrayList.hashCode());

        ArrayList<String> deepCopy = arrayList;
        ArrayList<String> shallowCopy = (ArrayList<String>) arrayList.clone();

        System.out.println(arrayList.equals(shallowCopy));
        arrayList.add("foo");
        arrayList.add("bar");
        System.out.println(arrayList.hashCode());
        System.out.println(shallowCopy);
        System.out.println(arrayList.equals(shallowCopy));

        System.out.println(deepCopy);
        System.out.println(deepCopy.hashCode());
        System.out.println(deepCopy.equals(arrayList));

        Product product = Product.builder().itemGrade(ItemGradeEnum.BEST).build();
        System.out.println(product.itemGrade);

        // Static Context
        System.out.println(ItemGradeEnum.getMask());

        String[] greetings = Main.repeat(7, "hello world", String[]::new);
        System.out.println(Arrays.stream(greetings).collect(Collectors.toList()));
        Integer[] numberArray = Main.repeat(11, 300, Integer[]::new);
        System.out.println(Arrays.stream(numberArray).collect(Collectors.toList()));


        // Set
        Set<String> mySet = new HashSet<String>();
        mySet.add("apple");
        mySet.add("water");
        System.out.println(mySet);
        mySet.add("apple");
        mySet.add("melon");
        mySet.add("cherry");

        // TreeSet
        TreeSet<String> myTreeSet = new TreeSet();
        myTreeSet = new TreeSet<>((a, b) -> a.equals(b) ? 0 : a.equals("kakao") ? -1 : 1);
        myTreeSet.add("cherry");
        myTreeSet.add("apple");
        myTreeSet.add("melon");
        myTreeSet.add("water");
        myTreeSet.add("kakao");
        System.out.println(myTreeSet);

        // Iterable
        Iterator<String> myIter = myTreeSet.iterator();
        while(myIter.hasNext()) {
            System.out.println(myIter.next());
            myIter.remove();
        }
        System.out.println("after removed : " + myTreeSet);

        // Linked List
        List<String> friends = new LinkedList<>();
        ListIterator<String> listIterator = friends.listIterator();
        listIterator.add("tom");
        listIterator.add("berry");
        listIterator.previous();
        listIterator.add("bob");
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }


        // HashMap
        Map<String, Integer> counts = new HashMap<>();
        counts.put("Team", 1);
        counts.put("Bob", 20);
        System.out.println(counts.get("Team"));
        System.out.println(counts.getOrDefault("Roa", 0));
        System.out.println(counts.merge("james", 100, Integer::sum));
        System.out.println(counts);
        counts.merge("james", 100, Integer::sum);
        System.out.println(counts);


        // Stack
        Stack<String> myStack = new Stack<String>();
        myStack.push("apple");
        myStack.add("banana");
        System.out.println(myStack);
        System.out.println(myStack.pop());
        System.out.println(myStack);


        // Priority Queue
        PriorityQueue<Integer> myPriority = new PriorityQueue<>();
        myPriority.add(10);
        myPriority.add(3);
        myPriority.add(7);
        myPriority.add(2);
        myPriority.add(1);
        System.out.println(myPriority);
        for(Integer q : myPriority) {
            System.out.println(q);
        }
        System.out.println("");
        while (myPriority.size() > 0) {
            System.out.println(myPriority.remove());
        }


        // Map
        Map<Integer, String> myMap = Map.of(1, "start", 20, "moon", 5, "earth", 7, "sun");
//        myMap.put(1, "star");
//        myMap.put(20, "moon");
//        myMap.put(5, "earth");
//        myMap.put(7, "sun");
        System.out.println(myMap);

        // Set
        Set<Integer> nList = Set.of(1,10, 5, 7, 9, 20, 100, 900, 200, 600, 500);
        List<Integer> sortedList = nList.stream().sorted().collect(Collectors.toList());
        System.out.println(nList);
        System.out.println(sortedList);

        // Sub List
        List<Integer> subList = sortedList.subList(0, 3);
        System.out.println(subList);
        //sortedList.add(1000);

        // ArrayList
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        arrayList1.add(10);
        arrayList1.add(5);
        arrayList1.add(7);
        System.out.println(arrayList1);
        List<Integer> subList1 = arrayList1.subList(arrayList1.size() -3, arrayList1.size() -1);
        System.out.println(subList1);
        subList1.add(100);
        //arrayList1.add(100);  //error raised  // why??
        System.out.println(subList1);


        List<Developer> developers = List.of(new Developer(5000), new Developer( 7000));
        List<BackendDeveloper> backendDevelopers = List.of(new BackendDeveloper(6000), new BackendDeveloper(8000));
        PrintOfficer.printOfficer(developers);
        PrintOfficer.printDeveloper(backendDevelopers);



    }

    public static <T> T[] repeat(int n, T obj, IntFunction<T[]> constr) {
        T[] result = constr.apply(n);
        for (int i = 0; i < n; i++) result[i] = obj;
        return result;
    }
}