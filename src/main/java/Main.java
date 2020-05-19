import model.OrderData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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


        //Interfaces Conflicted
        Employee empl = new Employee();
        System.out.println("empl's id : " + empl.getId());
        System.out.println("empl's secret id : " + empl.getSecretId());

        System.out.println(result);
        System.out.println(target.OrderId());
        System.out.println(last.OrderId());


        System.out.println(orderList.stream().count());
    }
}