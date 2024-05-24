import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        String line = "--------------------------";
        String separator = "\n\n" + line.repeat(5) + "\n\n";
        clear_file();

        messageDigest("MD5", "\n\n");
        messageDigest("SHA-1", "\n\n");
        messageDigest("SHA-256", separator);

        secureRandom("MD5", "\n\n");
        secureRandom("SHA-256", "\n\n");
        secureRandom("SHA-512", separator);

        correct_class_for_hashing("\n\n");
        incorrect_class_for_hashing("\n\n");
        print_hash_explanation();

    }

    public static void messageDigest(String alg, String ending) throws NoSuchAlgorithmException, IOException {
        MessageDigest md = MessageDigest.getInstance(alg);
        String str1 = "flopper";
        byte[] digest1 = md.digest(str1.getBytes(StandardCharsets.UTF_8));

        write_to_file_and_print("MessageDigest(" + alg + "):");
        write_to_file_and_print("\n\tStr: " + str1);
        write_to_file_and_print("\n\tStr as bytes: " + Arrays.toString(str1.getBytes()));
        write_to_file_and_print("\n\tHashed str as bytes: " + Arrays.toString(digest1));

        write_to_file_and_print(ending);
    }

    public static void secureRandom(String alg, String ending) throws NoSuchAlgorithmException, IOException {
        String password = ".flopper123/?";
        SecureRandom random = new SecureRandom();
        random.setSeed(password.getBytes());
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        MessageDigest md = MessageDigest.getInstance(alg);
        md.update(salt);
        byte[] secured_password = md.digest(password.getBytes(StandardCharsets.UTF_8));

        write_to_file_and_print("SecureRandom + MessageDigest(" + alg + "):");
        write_to_file_and_print("\n\tPassword: " + password);
        write_to_file_and_print("\n\tPassword as bytes: " + Arrays.toString(password.getBytes()));
        write_to_file_and_print("\n\tHashed Password as bytes: " + Arrays.toString(secured_password));

        write_to_file_and_print(ending);
    }

    public static void correct_class_for_hashing(String ending) throws IOException {
        HashMap<WaterBottle_Correct, String> map = new HashMap<>();
        map.put(new WaterBottle_Correct("Evian", 1, "Litre"), "Evian");
        map.put(new WaterBottle_Correct("Voss", 1, "Litre"), "Voss");
        map.put(new WaterBottle_Correct("San Pellegrino", 1, "Litre"), "San Pellegrino");
        map.put(new WaterBottle_Correct("Smartwater", 1, "Litre"), "Smartwater");

        int size = map.keySet().size();
        int i = 0;
        for (WaterBottle_Correct w : map.keySet()) {
            write_to_file_and_print(w + " -> " + map.get(w));
            if(i++ != size - 1)
                write_to_file_and_print("\n");
        }
        write_to_file_and_print(ending);
    }

    public static void incorrect_class_for_hashing(String ending) throws IOException {
        HashMap<WaterBottle_InCorrect, String> map = new HashMap<>();
        map.put(new WaterBottle_InCorrect("Evian", 1, "Litre"), "Evian");
        map.put(new WaterBottle_InCorrect("Voss", 1, "Litre"), "Voss");
        map.put(new WaterBottle_InCorrect("San Pellegrino", 1, "Litre"), "San Pellegrino");
        map.put(new WaterBottle_InCorrect("Smartwater", 1, "Litre"), "Smartwater");

        int size = map.keySet().size();
        int i = 0;
        for (WaterBottle_InCorrect w : map.keySet()) {
            write_to_file_and_print(w + " -> " + map.get(w));
            if(i++ != size - 1)
                write_to_file_and_print("\n");
        }
        write_to_file_and_print(ending);
    }

    public static void print_hash_explanation() throws IOException {
        write_to_file_and_print("Hashing in CorrectWatterBottle:");
        write_to_file_and_print(" \n\t~Default hashing is handled by java.");
        write_to_file_and_print("\n\t~Returns int value of the first char of the water brand.");
        write_to_file_and_print("\n\t~eg: Hash(\"Smartwater\") == Hash(\"San Pellegrino\") == 'S'.");
    }

    public static void write_to_file_and_print(String str) throws IOException {
        FileWriter writer = new FileWriter("Hash codes.txt", true);
        writer.write(str);
        writer.close();
        System.out.print(str);
        // efficiency doesn't really matter here
    }

    public static void clear_file() throws IOException {
        FileWriter writer = new FileWriter("Hash codes.txt", false);
        writer.close();
    }

}
