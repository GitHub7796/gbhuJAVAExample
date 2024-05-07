package oopCore;

public abstract class AbClass {
    private final String name;

    protected AbClass(String name) {
        this.name = name;
    }

    public final String getName() {
        return this.name;
    }
}
