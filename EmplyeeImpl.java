import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.maxBy;

public class EmplyeeImpl {

    public static void main(String[] args) {
        Emplyee e1 = new Emplyee(1, "CS", 10);
        Emplyee e2 = new Emplyee(2, "CS", 20);
        Emplyee e3 = new Emplyee(3, "CS", 30);
        Emplyee e4 = new Emplyee(4, "IT", 40);
        Emplyee e5 = new Emplyee(5, "IT", 50);
        Emplyee e6 = new Emplyee(6, "IT", 60);

        List<Emplyee> list = Arrays.asList(e1, e2, e3, e4, e5, e6);

        Map<String,Optional<Emplyee>> map = list.stream().collect(Collectors.groupingBy(Emplyee::getDept,maxBy(Comparator.comparing(Emplyee::getCommitCount))));

        map.entrySet().stream().forEach(i-> System.out.println(i.getKey()+":"+i.getValue().get()));




    }
}
