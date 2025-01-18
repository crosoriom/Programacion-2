package data;

public interface Chair<T> {
    public String getReference();
    public float getPrice();
    public float getQualification();

    @Override
    String toString();
}
