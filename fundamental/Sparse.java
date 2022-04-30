public class Sparse {
  
    public static int[] sparseArray(String[] inputs,String[] queries){
              
            
            int[] result = new int [queries.length];
            for(int i=0;i<queries.length;i++){
              for(int j=0;j<inputs.length;j++){
                if(queries[i]==inputs[j]){
                    result[i]++;
                  }
                }
            }
            
            return result;
      }
      public static void main(String[] args) {
        String[] inputs={"ab", "ab", "abc"};
        String[] queries={"ab", "abc", "bc"};
        
for(int i=0;i<sparseArray(inputs,queries).length;i++){
        System.out.print(sparseArray(inputs,queries)[i]+" ");
      }
    }
      
  }