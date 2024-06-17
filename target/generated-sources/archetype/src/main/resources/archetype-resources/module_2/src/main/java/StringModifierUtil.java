#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import com.google.common.base.Strings;

public class StringModifierUtil {
    public String multiplyString(String str, int count) {
        return Strings.repeat(str,count);
    }

    public String addNumberToChars(String input, int numberToAdd) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char originalChar = input.charAt(i);
            char modifiedChar = (char) (originalChar + numberToAdd);
            result.append(modifiedChar);
        }
        return result.toString();
    }
}
