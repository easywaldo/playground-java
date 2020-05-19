import java.util.Random;

public interface Person {
    String getName();
    default int getId()  {
        return this.getSecretNumber() + 0;
    }

    private int getSecretNumber() {
        return new Random().nextInt();
    }
}
