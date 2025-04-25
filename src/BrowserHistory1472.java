import java.util.LinkedList;

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

}



