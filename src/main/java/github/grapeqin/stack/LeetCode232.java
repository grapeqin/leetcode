package github.grapeqin.stack;

import java.util.Stack;

/**
 * 用栈实现队列<br/>
 * 初始化2个栈:写栈(wStack)和读栈(rStack),写栈主要用于队列push数据,读栈主要用于pop(peek)数据<br/>
 * 需要注意的是读数据时,需要优先判断rStack是否为空,当rStack不为空时直接取数据,否则,需要把wStack<br/>
 * 中的数据全部搬移到rStack,然后返回数据
 */
public class LeetCode232 {
    //写栈
    private Stack<Integer> wStack;
    //读栈
    private Stack<Integer> rStack;

    public LeetCode232() {
        wStack = new Stack<Integer>();
        rStack = new Stack<Integer>();
    }

    public void push(int x) {
        wStack.push(x);
    }

    public int pop() {
        if(!rStack.isEmpty()){
            return rStack.pop();
        }
        while (!wStack.isEmpty()){
            rStack.push(wStack.pop());
        }
        return rStack.pop();
    }

    public int peek() {
        if(!rStack.isEmpty()){
            return rStack.peek();
        }
        while (!wStack.isEmpty()){
            rStack.push(wStack.pop());
        }
        return rStack.peek();
    }

    public boolean empty() {
        return wStack.isEmpty() && rStack.isEmpty();
    }
}
