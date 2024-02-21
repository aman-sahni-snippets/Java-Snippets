import javax.crypto.KeyGenerator;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;
import java.security.KeyStore;


//Symmetric Keys (Secret Keys)
//Asymmetric Keys(Public and Private Keys)
//Trusted Certificates
public class AuthorizationVerifier {
    private static KeyStore keystore;

    // Initialize the keystore
    public static void createNewKeystore() {
        try {
            KeyStore ks = KeyStore.getInstance
                    (KeyStore.getDefaultType());
            char[] pwdArray = "password".toCharArray();
            ks.load(null, pwdArray);
            try (FileOutputStream fos =
                         new FileOutputStream("demo.jks"))
            {
                //Generate Secret Key
                //AES stands for Advanced Encryption Standard.
                //It is a symmetric encryption algorithm used for securing sensitive data.
                KeyGenerator keyGen = KeyGenerator.getInstance("AES");
                keyGen.init(256);

                KeyStore.SecretKeyEntry secret
                        = new KeyStore.SecretKeyEntry(keyGen.generateKey());
                KeyStore.ProtectionParameter password
                        = new KeyStore.PasswordProtection(pwdArray);
                //password cannot be null
                ks.setEntry("login-key", secret, password);

                ks.store(fos, pwdArray);
            }
            System.out.println(ks);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Key loadKeystore() {
        try {
            KeyStore ks = KeyStore.getInstance("JKS");
            char[] pwdArray = "password".toCharArray();
            ks.load(new FileInputStream("demo.jks"), pwdArray);
            System.out.println(ks.getKey("login-key", pwdArray));
            return ks.getKey("login-key", pwdArray);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean isAuthorized(Key serverKey,
                                       Key consumerKey) {
        return serverKey.equals(consumerKey);
    }

    public static void main(String[] args) {

        // Initialize the keystore
        createNewKeystore();

        //load key
        Key loginKey = loadKeystore();

        // Check if request is from an authorized source
        boolean isAuthorized = isAuthorized
                (loginKey, loginKey);

        if (isAuthorized) {
            System.out.println("Request is from an authorized source.");
        } else {
            System.out.println("Request is not from an authorized source.");
        }


    }

}
