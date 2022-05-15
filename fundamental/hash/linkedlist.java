class linkedlist<T>{
  
    int key;
    T value;
    linkedlist next;

    public linkedlist(int key,T value) {
        this.key=key;
        this.value=value;
        next=null;
    }
    public linkedlist() {
        next=null;
    }
  public int getkey(){
      return key;
  }

  public T getvalue(){
      return value;
  }
    
}