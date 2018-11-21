import java.util.UUID;

public class Test {

    @org.junit.Test
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            UUID uuid = UUID.randomUUID();
            System.out.println(uuid);
        }

    }

}
