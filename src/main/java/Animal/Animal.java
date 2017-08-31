package Animal;

public interface Animal {
    public default String getName() {
        return null;
    }

   // public String getName();
}
