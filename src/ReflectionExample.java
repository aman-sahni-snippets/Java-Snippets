import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionExample {

    // Using reflection to set a private field and invoke a private method
    public static void main(String[] args) throws Exception{

        // Create an instance of Company
        Model_Class_Company company = new Model_Class_Company("Youtube");
        System.out.println("Company Name: " + company.getName());

        // Change the name from Youtube to Google
        Field name = Model_Class_Company.class.getDeclaredField("name");
        name.setAccessible(true);
        name.set(company, "Google");
        System.out.println("Company Name: " + company.getName());

        // Invoke the private method 'displayName'
        Method display = Model_Class_Company.class.getDeclaredMethod("displayName");
        display.setAccessible(true);
        display.invoke(company);





    }
}
