class Solution {
    Set<Integer> set=new HashSet<>();  
    public int[] fairCandySwap(int[] al, int[] bob) {
        int sum1=calcSum(al,true);
        int sum2=calcSum(bob,false);
        int total=sum1+sum2;
        int half=total/2;
        // System.out.println(half);
        // System.out.println(sum2);
        int[] res=new int[2];
        for(int ele:bob){
            int s1 = half - (sum2 - ele);
            // System.out.println(s1);
            if(set.contains(s1)) {
                if(sum1-s1 + ele == sum2-ele + s1){
                res[0] = s1;
                res[1] = ele;
                 break;   
                }
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