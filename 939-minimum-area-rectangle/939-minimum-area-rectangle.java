class Solution {
    public int minAreaRect(int[][] points) {
        Map<Integer,HashSet<Integer>> map=new HashMap<>();
        for(int[] point:points){
            if(!map.containsKey(point[0]))
                map.put(point[0] , new HashSet<>());
            map.get(point[0]).add(point[1]);
            
        }
        int min=Integer.MAX_VALUE;
        for(int[] point1:points){
            for(int[] point2:points){
                int x1=point1[0];
                int x2=point2[0];
                int y1=point1[1];
                int y2=point2[1];
                if(x1!=x2 && y1!=y2){
                    if(map.get(x2).contains(y1) && map.get(x1).contains(y2)) {
                        min=Math.min(min,Math.abs(x2 - x1) * Math.abs(y2 -y1));
                        
                    }
                }
            }
        }
        return min != Integer.MAX_VALUE ? min : 0; 
    }
}