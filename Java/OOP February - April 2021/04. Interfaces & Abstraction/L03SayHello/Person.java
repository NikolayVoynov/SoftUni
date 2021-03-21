package L03SayHello;

public interface Person {
    String getName();

    default String sayHello() {
        return "Hello";
    }

    ;
}
