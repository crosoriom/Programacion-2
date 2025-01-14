public class Gradetester {
    public static void main(String[] args) {
        Grade n1 = new Grade();
        n1.setValue(3.5);
        n1.setWeight(50);
        System.out.println(n1.getValue());
        System.out.println(n1.getWeight());
    }
}