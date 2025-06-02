package Stack;

import java.util.Stack;

public class AsteroidCollision735 {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int ast : asteroids) {
            while (!stack.isEmpty() && stack.peek() > 0 && ast < 0) {
                int top = stack.pop();
                if (Math.abs(top) > Math.abs(ast)) {
                    ast = top;
                } else if (Math.abs(top) == Math.abs(ast)) {
                    ast = 0;
                    break;
                }
            }
            if (ast != 0) {
                stack.push(ast);
            }
        }

        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}
