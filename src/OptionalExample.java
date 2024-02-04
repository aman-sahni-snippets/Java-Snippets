import java.util.Optional;

public class OptionalExample {
    public Optional<String> findUserNameById(int userId) {

        if(userId == 0)
        {
            // Simulate a database lookup
            return Optional.empty();
        }
        else {
            // Simulate a database lookup
            return Optional.ofNullable("Aman");
        }
    }

    public String findUserNameByIdWithoutOptional(int userId) {

        if(userId == 0)
        {
            // Simulate a database lookup
            return null;
        }
        else {
            // Simulate a database lookup
            return "Aman";
        }
    }

    public static void main(String[] args) {
        OptionalExample userDatabase =
                new OptionalExample();

        // Without Optional
        String userNameWithoutOptional = userDatabase.findUserNameByIdWithoutOptional(0);
        System.out.println("Without Optional: " + userNameWithoutOptional);

        //With Optional
        Optional<String> userName =
                userDatabase.findUserNameById(0);

        userName.ifPresentOrElse(
                uname -> System.out.println(uname),
                () -> System.out.println("UserName Not Found")
        );


    }
}
