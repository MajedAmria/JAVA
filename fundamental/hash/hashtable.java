public class hashtable {

    linkedlist [] hash;
    int size;

    public hashtable(int hashsize){
        hash=new linkedlist[hashsize];

    }
    public boolean isEmpty(){
        if(size==0){
            return true;
        }
       else{
        return false;
       }
    }
}
