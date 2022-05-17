public class sensor{
    public static String convertsensor(String input,String[] badword){
        String[] list_input=input.split(" ");

        String after="";
        for(int i=0;i<badword.length;i++){
            if(list_input[i].compareTo(badword[i])==0){
                list_input[i]="x";
                after+= list_input[i];
            }
        }
      
      return  after;
    }

    public static void main(String[] arg){
        String[] str1={"hello","hi"};
         String str="hello world";
         System.out.println( convertsensor(str,str1));
    }

  
}