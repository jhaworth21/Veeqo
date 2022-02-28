package runlenencoder;

public class RunLenEncoder {

    /**
     * performs run length encoding on a given input string
     *
     * @param s the given input string
     * @return the encoded string
     */
    public String encode(String s) {

        //the return string
        String ret_str = "";
        //sanitises excess spaces from the input string
        String clean_str = s.replaceAll("\\s+", " ");


        for (int i = 0, count = 1; i < clean_str.length(); i++) {

            //checks if the current and next character are the same
            if (i + 1 < clean_str.length() && clean_str.charAt(i) == clean_str.charAt(i + 1)) {
                //if they are increment count
                count++;
            }
            //checks if the character is a space or punctuation
            else if (clean_str.charAt(i) == ' ' || clean_str.charAt(i) == '"' ||
                    "#`~!#$%^".contains(Character.toString(clean_str.charAt(i)))) {

                //adds the character to the string and resets count
                ret_str = ret_str.concat(Character.toString(clean_str.charAt(i)));
                count = 1;
            } else {
                //adds the character and the count to the string
                ret_str = ret_str.concat(Character.toString(clean_str.charAt(i)))
                        .concat(Integer.toString(count));
                //resets count
                count = 1;
            }
        }
        return ret_str;
    }

    /**
     * performs run length decoding on the given input string
     *
     * @param s the input string
     * @return the decoded string
     */
    public String decode(String s) {
        String ret_str = "";

        for (int i = 0; i < s.length() - 1; i++) {
            //check for if a character is a number
            boolean contains = "1234567890".contains(Character.toString(s.charAt(i + 1)));

            //if the next character isn't past the end of the string and a number
            if (i + 1 < s.length() && contains) {

                //repeats the character for the i+1 number of times
                int rep_val = Character.getNumericValue(s.charAt(i + 1));

                //adds the repeated character to the return string
                ret_str = ret_str.concat(String.valueOf(s.charAt(i)).repeat(rep_val));

                //removes the number from the string
                s = s.replaceFirst(String.valueOf(s.charAt(i + 1)), "");

                System.out.println(s);
            } else {
                //adds the character to the string if there isn't a number
                ret_str = ret_str.concat(Character.toString(s.charAt(i)));
            }
        }
        return ret_str;
    }
}