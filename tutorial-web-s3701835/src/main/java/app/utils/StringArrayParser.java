package app.utils;

/**
 * Utility class to parse a string representation to an array of Integers.
 * Format is comma separate list of integers
 *
 * Valid format example: 1, 34, -4, 15
 */
public class StringArrayParser {

    /**
     * Parse a string into an array of integers
     * @param input string representation
     * @return array of integers
     */
    public static Integer[] parse(String input){
        String delimiter = ",";
        String splitInput [] = input.split(",");
        Integer result [] = new Integer[splitInput.length];
        for (int i = 0; i < splitInput.length; i++){
            result[i] = Integer.parseInt(splitInput[i].trim());
        }
        return result;
    }
}
