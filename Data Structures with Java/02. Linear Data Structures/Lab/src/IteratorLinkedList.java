import java.util.Iterator;
import java.util.LinkedList;

public class IteratorLinkedList {

    public static void main(String[] args) {
        LinkedList<String> people = new LinkedList<>();
        people.add("joro");
        people.add("pesho");
        people.add("misho");
        people.add("grisho");

        Iterator<String> iterator = people.iterator();
        while (iterator.hasNext()) {
            String person = iterator.next();
            if (person.equals("pesho")) {
                iterator.remove();
            } else {
                System.out.println(person);
            }

        }
    }
}
