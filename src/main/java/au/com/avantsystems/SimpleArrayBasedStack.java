package au.com.avantsystems;

import java.lang.reflect.Array;

public class SimpleArrayBasedStack<T> implements Stack<T> {

  private T[] contents;
  private int stackPointer;

  @SuppressWarnings("unchecked")
  public SimpleArrayBasedStack(Class<T> tClass, int capacity) {
    contents = (T[]) Array.newInstance(tClass, capacity);
  }

  @Override
  public void push(T t) {
    checkFullStack();
    contents[stackPointer++] = t;
  }

  @Override
  public T pop() {
    checkEmptyStack();
    return contents[--stackPointer];
  }

  @Override
  public int size() {
    return stackPointer;
  }

  private void checkFullStack() {
    if (stackPointer >= contents.length) {
      throw new IllegalArgumentException("Cannot push to a full stack.");
    }
  }

  private void checkEmptyStack() {
    if (stackPointer == 0) {
      throw new IllegalArgumentException("Cannot pop from empty stack.");
    }
  }

  public static void main(String[] args) {
    Stack<String> stack = new SimpleArrayBasedStack<>(String.class, 100);
    stack.push("100");
    stack.push("200");
    stack.push("300");
    stack.push("400");
    System.out.println(stack.size());

    stack.pop();
    stack.pop();
    stack.pop();
    stack.pop();
    // stack.pop();
  }
}