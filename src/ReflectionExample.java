import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Company {
    private String name;

    public Company(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void displayName() {
        System.out.println
                ("Private Method Invoked to display Company Name: " + name);
    }

}

public class ReflectionExample {

    // Using reflection to set a private field and invoke a private method
    public static void main(String[] args) throws Exception{

        // Create an instance of Company
        Company company = new Company("Youtube");
        System.out.println("Company Name: " + company.getName());

        // Change the name from Youtube to You-Tube
        Field name = Company.class.getDeclaredField("name");
        name.setAccessible(true);
        name.set(company, "You-Tube");
        System.out.println("Company Name: " + company.getName());

        // Invoke the private method 'displayName'
        Method display = Company.class.getDeclaredMethod("displayName");
        display.setAccessible(true);
        display.invoke(company);


    }
}
