public class LinkedListDeque<T> {

    private class TNode{
        private T item;
        private TNode prev;
        private TNode next;

        private TNode(T x, TNode p, TNode n){
            item = x;
            prev = p;
            next = n;
        }
    }

    private TNode sentinel;
    private int size;

    public LinkedListDeque(){
        sentinel = new TNode(null,null,null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void addFirst(T item){
        sentinel.next = new TNode(item, sentinel, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size++;
    }

    public void addLast(T item){
        sentinel.prev = new TNode(item, sentinel.prev, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size++;
    }

    public T removeFirst(){
        T remove = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        if(!isEmpty()){
            size--;
        }
        return remove;
    }

    public T removeLast(){
        T remove = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        if ((!isEmpty())){
            size--;
        }
        return remove;
    }

    public void printDeque(){
        TNode toPrint = sentinel.next;
        for(int i = 0; i < size; i++){
            System.out.print(toPrint.item + " ");
            toPrint = toPrint.next;
        }

        System.out.println();
    }

    public T get(int index){
        TNode toGet = sentinel.next;
        for (int i = 0; i < index; i++) {
            toGet = toGet.next;
        }
        return toGet.item;
    }

    private  T getRecursive(int index, TNode curr){
        if(index == 0){
            return curr.item;
        }
        return getRecursive(index - 1, curr.next);
    }

    public  T getRecursive(int index){
        return getRecursive(index, sentinel.next);
    }

    public LinkedListDeque(LinkedListDeque other){
        sentinel = new TNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;

        for (int i = 0; i < other.size(); i++) {
            addLast((T) other.get(i));
        }
    }

}
