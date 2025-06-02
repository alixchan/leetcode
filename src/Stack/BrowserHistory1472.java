package Stack;

import java.util.LinkedList;
import java.util.Stack;

public class BrowserHistory1472 {

    private LinkedList<String> history = new LinkedList<>();
    private int pointer = 0;

    public BrowserHistory1472(String homepage) {
        history.add(homepage);
    }

    public void visit(String url) {
        while (history.size() > pointer + 1) {
            history.removeLast();
        }
        history.add(url);
        pointer++;
    }

    public String back(int steps) {
        pointer -= Math.min(steps, pointer);
        return history.get(pointer);
    }

    public String forward(int steps) {
        pointer += Math.min(steps, history.size() - 1 - pointer);
        return history.get(pointer);
    }

    public static class RemoveKDigits402 {

        public String removeKdigits(String num, int k) {
            if (k == num.length()) {
                return "0";
            }
            Stack<Character> stack = new Stack<>();

            for (char digit : num.toCharArray()) {
                while (k > 0 && !stack.isEmpty() && stack.peek() > digit) {
                    stack.pop();
                    k--;
                }
                stack.push(digit);
            }

            while (k > 0) {
                stack.pop();
                k--;
            }

            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            sb.reverse();

            while (sb.length() > 1 && sb.charAt(0) == '0') {
                sb.deleteCharAt(0);
            }

            return sb.toString();
        }
    }
}



