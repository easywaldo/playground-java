import java.util.Collection;
import java.util.List;

public class PrintOfficer {
    public static void printOfficer(List<? extends Officer> staff) {
        for (int i = 0; i < staff.size(); i++) {
            Officer o = staff.get(i);
            System.out.println("salary is : " + o.getSalary());
        }
    }

    public static void printDeveloper(List<? super BackendDeveloper> developer) {
        for (int i = 0; i < developer.size(); i++) {
            Officer d = (Officer) developer.get(i);
            System.out.println("salary is : " + d.getSalary());
        }
    }

    public static <T> void printAnything(T t) {
        System.out.println(t.getClass().getPackageName());
        System.out.println(t.getClass().getTypeName());
    }

}
