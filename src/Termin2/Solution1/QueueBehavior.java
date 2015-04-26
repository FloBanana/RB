package Termin2.Solution1;

/**
 * Created by florianheiwig on 01/10/14.
 */
public interface QueueBehavior<T> {
    public void push(T e);
    public T pop();
    public T top();
    public boolean isEmpty();
}
