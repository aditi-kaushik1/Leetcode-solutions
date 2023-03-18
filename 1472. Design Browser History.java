class BrowserHistory {
    Stack<String> history;
    Stack<String> forwardHistory;
    public BrowserHistory(String homepage) {
        history = new Stack<>();
        forwardHistory = new Stack<>();
        history.push(homepage);
    }
    
    public void visit(String url) {
        history.push(url);
        forwardHistory.clear();
    }
    
    public String back(int steps) {
        updateStacks(forwardHistory, history, 1, steps);
        return history.peek();
    }
    
    public String forward(int steps) {
        updateStacks(history, forwardHistory, 0, steps);
        return history.peek();
    }

    private void updateStacks(Stack toPush, Stack toRemove, int minimumLengthRequired, int steps) {
        while((toRemove.size() > minimumLengthRequired) && (steps-- != 0)) {
            toPush.push(toRemove.pop());
        }
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
