class Solution {
    public int findLucky(int[] arr) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int ele:arr) map.put(ele,map.getOrDefault(ele,0) + 1);
        int ans=-1;
        for(int ele:arr)
            if(map.get(ele) == ele) ans=Math.max(ans,ele);
            
        return ans;
    }
}