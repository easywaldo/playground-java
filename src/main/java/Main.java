import model.OrderData;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
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




    }
}