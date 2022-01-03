class Solution {
    public int findJudge(int n, int[][] trust) {
        Map<Integer,Integer> map=new HashMap<>();
        Map<Integer,Integer> trustMap=new HashMap<>();
        for(int i=1;i<=n;i++) {
            map.put(i,0);
            trustMap.put(i,0);
        }
        for(int[] edge:trust){
            trustMap.put(edge[1],trustMap.getOrDefault(edge[1],0) + 1);
            map.put(edge[0],map.getOrDefault(edge[1],0) + 1);
        }
        for(int key:map.keySet()) if(map.get(key)==0 && trustMap.get(key) == n-1) return key;
        return -1;
    }
}