class Solution {
    public boolean validMountainArray(int[] arr) {
        int b=0;
        if(arr.length<3){
            return false;
        }
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]>arr[i+1]){
                b=i;
                break;
            }
            else if(arr[i]==arr[i+1]){
                return false;
            }
        }
        if(b==0)
            return false;
       for(int i=b+1;i<arr.length-1;i++){
           if(arr[i]<=arr[i+1]){
               return false;
           }
       }
        return true;
    }
}