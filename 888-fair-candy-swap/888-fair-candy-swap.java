class Solution {
    Set<Integer> set=new HashSet<>();  
    public int[] fairCandySwap(int[] al, int[] bob) {
        int sum1=calcSum(al,true);
        int sum2=calcSum(bob,false);
        int half=(sum1+sum2)/2;
        int[] res=new int[2];
        for(int ele:bob){
            int s1 = half - (sum2 - ele);
            if(set.contains(s1)) {
                res[0] = s1;
                res[1] = ele;
                break;   
            }
        }   
        return res;
    }
    public int calcSum(int[] arr,boolean add){
        int sum=0;
        for(int ele:arr){
           if(add) set.add(ele);
          sum+=ele;  
         } 
        return sum;
    }
}