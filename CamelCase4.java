import java.io.*;
import java.util.*;

public class Solution {
    public static String split(String type, String str) {
        if (type.equals("M")) {
            str = str.substring(0, str.length() - 2);
        }

        ArrayList<String> words = new ArrayList<>();
        String newWord = "" + Character.toLowerCase(str.charAt(0));
        
        for (int i = 1; i < str.length(); i++) {
            if (Character.isUpperCase(str.charAt(i))) {
                words.add(newWord);
                newWord = "" + Character.toLowerCase(str.charAt(i));
            } else {
                newWord += str.charAt(i);
            }
        }
        
        words.add(newWord);
        
        String result = "";
        
        for (String word : words) {
            result += word + " ";
        }
        
        if (result.length() > 0) {
            result = result.substring(0, result.length() - 1);
        }
        
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(";");
            if (parts[0].equals("S")) {
                System.out.println(Solution.split(parts[1], parts[2]));
            }
        }
        scanner.close();
    }
}
