import java.util.Stack;

// https://leetcode.com/problems/implement-queue-using-stacks/description/

class MyQueue {
// Реалиазция очереди через стек... Если использовать один стек, то при извлечении элементов из очереди,
// нужно будет достать самый первый добавленный элемент, который находится внизу стека,
// т.е. O(n), если к примеру его перекладывать в другой стек ради этого.
// Поэтому два стека - под добавление и извлечение элементов.
// Таким образом, когда outputStack пуст, все элементы из перекладываются из inputStack в outputStack,
// что инвертирует их порядок, т.е. верхний элемент outputStack будет самым старым элементом очереди,
// как и должно быть для FIFO.

    private Stack<Integer> inputStack;
    private Stack<Integer> outputStack;

    public MyQueue() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }

    public void push(int x) {
        inputStack.push(x);
    }

    // Каждый элемент перемещается между стеками не более двух раз:
    // один раз в outputStack, один раз из него. Вот амортизация

    public int pop() {
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
        return outputStack.pop();
    }

    public int peek() {
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
        return outputStack.peek();
    }

    public boolean empty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */