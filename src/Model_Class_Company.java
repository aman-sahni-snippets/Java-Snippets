public class Model_Class_Company {
    private String name;

    public Model_Class_Company(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void displayName() {
        System.out.println("Private Method Invoked to display Company Name: " + name);
    }

}
