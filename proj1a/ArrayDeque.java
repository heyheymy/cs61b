public class ArrayDeque<T> {

    private  T[] items;
    private  int nextfirst;
    private  int nextlast;
    private  int size;

    public  ArrayDeque(){
        items = (T[]) new Object[8];
        nextfirst = 0;
        nextlast = 1;
        size = 0;
    }

    private int plusone(int index){
        return (index + 1) % items.length;
    }

    private int minusone(int index){
        return (index - 1 + items.length) % items.length;
    }

    private void resize(int cap){

        T[] a = (T[]) new Object[cap];
        int index = plusone(nextfirst);
        for (int i = 0; i < size; i++) {
            a[i] = items[index];
            index = plusone(index);
        }
        items = a;
        nextfirst = cap - 1;
        nextlast = size;
    }

    private boolean isFull(){
        return size == items.length;
    }

    private boolean isSparse(){
        return size < items.length * 0.25 && items.length >= 16;
    }

    public void addFirst(T t){
        if(isFull()){
            resize(size * 2);
        }
        items[nextfirst] = t;
        nextfirst = minusone(nextfirst);
        size++;
    }

    public void addLast(T t){
        if(isFull()){
            resize(size * 2);
        }
        items[nextlast] = t;
        nextlast = plusone(nextlast);
        size++;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        for (int i = plusone(nextfirst); i != nextlast; i = plusone(i)) {
            System.out.print(items[i] +" ");
        }
        System.out.println();

    }

    public T removeFirst(){
        if(isSparse()){
            resize(size / 2);
        }
        nextfirst = plusone(nextfirst);
        T toRemove = items[nextfirst];
        items[nextfirst] = null;
        if(!isEmpty()){
            size--;
        }
        return toRemove;
    }

    public T removeLast(){
        if(isSparse()){
            resize(size / 2);
        }
        nextlast = minusone(nextlast);
        T toRemove = items[nextlast];
        items[nextlast] = null;
        if(!isEmpty()){
            size--;
        }
        return toRemove;
    }

    public T get(int index){
        if(index >= size) {
            return null;
        }
        return items[(plusone(nextfirst) + index) % items.length];
    }

    public ArrayDeque(ArrayDeque other){
        items = (T[]) new Object[other.size];
        nextlast = other.nextlast;
        nextfirst = other.nextfirst;
        size = other.size;

        System.arraycopy(other.items, 0, items, 0, size);
    }

}
