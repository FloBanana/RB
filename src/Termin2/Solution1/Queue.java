package Termin2.Solution1;

/**
 * class description
 */
public class Queue<T> implements QueueBehavior<T> {
    /**variables*/
    private T[] storage;
    private int size;
    private int firstPhysicPositon = 0;
    private int lastPhysicPosition = 0;

    private int START_SIZE = 10;
    private int EXPAND_FACTOR = 10;

    /**constructor*/
    public Queue(){
        this.storage = (T[])new Object[START_SIZE];
        this.size = START_SIZE;
    }

    public Queue(int size){
        this.storage = (T[])new Object[size];
        this.size = size;
    }

    /**getter and setter*/

    /**methods*/
    @Override
    public void push(T e) {
        if (isFull()) {
            //expandArray();
        }
        for(int i = 0; i < size; i++){
            if(this.storage[logicToPhysic(i)] == null){
                this.storage[logicToPhysic(i)] = e;
                this.lastPhysicPosition = logicToPhysic(i);
                i = size;
            }
        }
    }

    @Override
    public T pop() {
        T returnValue = this.storage[logicToPhysic(0)];
        this.storage[logicToPhysic(0)] = null;
        this.firstPhysicPositon++;
        return returnValue;
    }

    @Override
    public T top() {
        return this.storage[logicToPhysic(0)];
    }

    @Override
    public boolean isEmpty() {
        return lastPhysicPosition-firstPhysicPositon == 0;
    }

    public boolean isFull(){
        return physicToLogic(this.firstPhysicPositon) == 0 && physicToLogic(this.lastPhysicPosition) == size-1;
    }

    public void expandArray(){
        T[] newStorage = (T[])new Object[START_SIZE+EXPAND_FACTOR];
        for(int newStorageIndex = 0; newStorageIndex < size-1; newStorageIndex++){
            newStorage[newStorageIndex] = this.storage[logicToPhysic(newStorageIndex)];
        }
        this.storage = newStorage;
    }

    public int logicToPhysic(int logicPosition){
        return (logicPosition + firstPhysicPositon) % size;
    }

    public int physicToLogic(int physicPosition){
        if ((physicPosition - this.firstPhysicPositon) < 0){
            return (physicPosition - this.firstPhysicPositon) + size;
        }else{
            return (physicPosition - this.firstPhysicPositon);
        }
    }

    public String toString(){
        String returnValue = "|";
        for(int i = 0; storage[logicToPhysic(i)] == null && i < size; i++){
            returnValue += storage[logicToPhysic(i)] + "<-";
        }
        return returnValue;
    }
}
