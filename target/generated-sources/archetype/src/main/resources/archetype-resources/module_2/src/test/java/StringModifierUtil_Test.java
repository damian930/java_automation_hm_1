#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class StringModifierUtil_Test {

    @Test
    void test_addNumbersToChar() {
        String str = "aaa";
        assertEquals("bbb", new StringModifierUtil().addNumberToChars(str, 1));
    }

    @Test
    void test_multiplyString() {
        String str = "abc";
        assertEquals("abcabcabc", new StringModifierUtil().multiplyString(str, 3));
    }

}
