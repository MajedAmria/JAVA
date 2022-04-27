import java.util.ArrayList;

public class mid {


    public static double median(int []arr1, int []arr2){
        ArrayList<Integer>newArr= new ArrayList<Integer>();

        int size1=arr1.length;
        int size2=arr2.length;
        int index1=0;
        int index2=0;
        while(index1<size1 && index2<size2){
            if(arr1[index1]<arr2[index2]){
                newArr.add(arr1[index1]);
                index1++;
            }
            else if(arr1[index1]>arr2[index2]){
                newArr.add(arr2[index2]);
                index2++;
            }
            else{
                newArr.add(arr2[index2]);
                index2++;
            }
        }
        if(index2<arr2.length){
            for(int i=index2; i<arr2.length;i++){
                newArr.add(arr2[i]);
            }
        }
        if(index1<arr1.length){
            for(int i=index1; i<arr1.length;i++){
                newArr.add(arr1[i]);
            }
        }

        System.out.println(newArr);

        if(newArr.size()%2==0){

            int num1=newArr.get(newArr.size()/2);
            int num2=newArr.get((newArr.size()/2)-1);
            int sum=num1+num2;
            return (sum)/2;
        }
        else{

            int index=newArr.size()/2;
            int num1=newArr.get(index);

            return num1;
        }

    }
    public static void main(String []args){
       

        int []arr1={1,5,9};
        int []arr2={1,2,3,4,5};

        double median=median(arr1, arr2);
        System.out.println(median);

    }
}