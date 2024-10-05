import java.util.*;

public class Solution
{
    // Helper function to capitalize the first letter of a word
    public static String capitalize(String word)
    {
        if (word == null || word.isEmpty())
        {
            return word;
        }
        
        return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
    }
    
    public static String split(String formatType, String text)
    {
        if (formatType.equals("M"))
        {
            // Remove '()' for methods
            text = text.substring(0, text.length() - 2);
        }
        
        StringBuilder result = new StringBuilder();
        StringBuilder currentWord = new StringBuilder(text.substring(0, 1).toLowerCase());
        
        for (int i = 1; i < text.length(); i++)
        {
            char ch = text.charAt(i);
            if (Character.isUpperCase(ch))
            {
                // Add current word to result
                result.append(currentWord).append(" ");
                // Start new word
                currentWord = new StringBuilder("" + Character.toLowerCase(ch));
            }
            else
            {
                currentWord.append(ch);
            }
        }
        // Add last word to result
        result.append(currentWord);
        
        return result.toString().trim();
    }
    
    public static String combine(String formatType, String text)
    {
        String[] words = text.split(" ");
        StringBuilder result = new StringBuilder();
        
        // Process the first word
        if (formatType.equals("C"))
        {
            // Capitalize first word for class names
            result.append(capitalize(words[0]));
        }
        else
        {
            result.append(words[0].toLowerCase());
        }
        
        // Process the remaining words
        for (int i = 1; i < words.length; i++)
        {
            // Capitalize each subsequent word
            result.append(capitalize(words[i]));
        }
        
        if (formatType.equals("M"))
        {
            // Append '()' for methods
            result.append("()");
        }
        
        return result.toString();
    }
    
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        
        while(scanner.hasNextLine())
        {
            String line = scanner.nextLine().trim();
            
            String[] parts = line.split(";");
            String operation = parts[0];
            String formatType = parts[1];
            String text = parts[2];
            
            String result = operation.equals("S")
                            ? split(formatType, text)
                            : combine(formatType, text);
            
            System.out.println(result);
        }
        
        scanner.close();
    }
}
