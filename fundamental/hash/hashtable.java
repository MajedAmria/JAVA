import java.util.LinkedList;

public class hashtable<T> {
linkedlist[] arrhash;
int size;

    public hashtable(int size){
        this.size=size;
        arrhash= new linkedlist[this.size];
        for(int i=0;i<arrhash.length;i++){
            arrhash[i]=new linkedlist<T>();
        }

    }

    public int gethash(int key){
        return key%size;
    }

    public void put(int key,T value){
        int index=gethash(key);
        linkedlist arrvalue=arrhash[index];
        linkedlist newitem=new linkedlist<T>(key,value);
        newitem.next=arrvalue.next;
        arrvalue.next=newitem;
    }
    public T Get(int key){
        T value=null;
        int index=gethash(key);
        linkedlist arrvalue=arrhash[index];
        while(arrvalue.next!=null){
            if(arrvalue.getkey()==key){
                 value=(T)arrvalue.getvalue();
                break;
            }
            arrvalue=arrvalue.next;
        }
        
        return value;
    }

    // public void remove(int key,T value){
    //     int index=gethash(key);
    //     linkedlist arrvalue=arrhash[index];
    //     while(arrvalue.next!=null){
    //         if(arrvalue.getvalue()==value)
    //         arrvalue=arrvalue.next;
    //     }
    // }
    
}
