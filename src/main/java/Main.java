import model.OrderData;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
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

        Predicate<Integer> myPred = (num) -> {
            if (num > 1000) {
                return  true;
            }
            return false;
        };
        System.out.println(myPred.test(1000));





    }
}