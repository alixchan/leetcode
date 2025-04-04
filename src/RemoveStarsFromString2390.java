import java.util.Stack;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveStarsFromString2390 {

    //TO_DO: через массив с индексацией
    public String removeStars(String s) {
        StringBuilder result = new StringBuilder(s.length());
        for (char c : s.toCharArray()) {
            if (c == '*') {
                result.deleteCharAt(result.length() - 1);
                continue;
            }
            result.append(c);
        }
        return result.toString();
    }

    public String removeStars_nprf(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '*') {
                stack.pop();
                continue;
            }
            stack.push(c);
        }
        StringBuilder result = new StringBuilder(stack.size());
        for (char c : stack) {
            result.append(c);
        }
        return result.toString();
    }

    @Test
    public void test() {
        assertEquals("lecoe", removeStars("leet**cod*e"));
        assertEquals("", removeStars("erase*****"));
    }
}