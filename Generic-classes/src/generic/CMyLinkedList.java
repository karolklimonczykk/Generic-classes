package generic;

import javax.swing.*;

public class CMyLinkedList<T extends Number, U>{
    private class CElement{
        public CElement prev;
        public CElement next;
        public T id;
        public U data;

        public CElement(CElement p, CElement n, T id, U d) {
            this.prev = p;
            this.next = n;
            this.id = id;
            this.data = d;
        }
    }
    private CElement head;
    private int count;

    public CMyLinkedList() {
        head = null;
        count = 0;
    }
    public CMyLinkedList(T id, U elem){
        head = new CElement(null,null,id,elem);
        count = 1;
    }
    public int size(){
        return count;
    }
    public void clear(){
        head = null;
        count = 0;
    }
    public void add(T id, U elem){
        CElement last = head;
        if (last == null){
            head = new CElement(null,null,id,elem);
        }else {
            while (last.next != null){
                if (last.id.equals(id))
                    throw new IllegalArgumentException("Id = " + id + " exists.");
                last = last.next;
            }
            if (last.id.equals(id))
                throw new IllegalArgumentException("Id = " + id + " exists.");
            last.next = new CElement(last,null,id,elem);
        }
        count++;
    }
    public U getByIndex(int idx) throws IndexOutOfBoundsException{
        if(head == null)
            throw new IndexOutOfBoundsException("Index out of range");
        if (idx<0)
            throw new IndexOutOfBoundsException("Index out of range");
        CElement last = head;
        int i = 0;
        while (i++ < idx){
            last = last.next;
            if(last == null)
                throw new IndexOutOfBoundsException("Index out of range");
        }
        return last.data;
    }
    public U getById(T id){
        CElement last = head;
        while (last != null){
            if (last.id.equals(id)) return last.data;
            last = last.next;
        }
        return null;
    }
    public void printToList(DefaultListModel<Object> model){
        CElement last = head;
        model.clear();
        while (last != null){
            model.addElement(last.id+".  "+last.data);
            last = last.next;
        }
    }
}
