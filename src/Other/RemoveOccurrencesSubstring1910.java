package Other;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveOccurrencesSubstring1910 {

    public static String removeOccurrences(String s, String part) {
        while (s.length() != 0) {
            int index = s.indexOf(part);
            if (index == -1) {
                break;
            }
            s = s.substring(0, index) + s.substring(index + part.length());
        }
        return s;
    }

    @Test
    public void test() {
        assertEquals("dab", removeOccurrences("daabcbaabcbc","abc"));
        assertEquals("ab", removeOccurrences("axxxxyyyyb","xy"));
    }
}
