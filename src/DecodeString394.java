import java.util.Stack;

public class DecodeString394 {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        String currentStr = "";
        StringBuilder currentNum = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '[') {
                stack.push(currentStr);
                stack.push(currentNum.toString());
                currentStr = "";
                currentNum = new StringBuilder();
            } else if (c == ']') {
                int num = Integer.parseInt(stack.pop());
                String prevStr = stack.pop();
                currentStr = prevStr + currentStr.repeat(num);
            } else if (Character.isDigit(c)) {
                currentNum.append(c);
            } else {
                currentStr += c;
            }
        }

        return currentStr;
    }

}
