class Solution {
    Map<Integer,List<Integer>> map=new HashMap<>();
    Stack<Integer> stack=new Stack<>();
    int[] color;
    boolean stop=false;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        color=new int[numCourses];
        for(int[] preq: prerequisites){
            List<Integer> ls=map.getOrDefault(preq[1],new ArrayList<>());
            ls.add(preq[0]);
            map.put(preq[1],ls);
        }
        for(int i=0;i<numCourses;i++)
            if(color[i]==0) dfs(map,i);
        if(stop) return new int[0];
        int[] res=new int[numCourses];
        for(int i=0;i<numCourses;i++) res[i]=stack.pop();
        return res;
        
    }
    public void dfs(Map<Integer,List<Integer>> map,int vertex){
        if(stop) return;
        color[vertex]=2;
        List<Integer> ls=map.getOrDefault(vertex,new ArrayList<>());
        for(int ele:ls) {
            if (color[ele] == 2) stop=true;
            else if(color[ele] == 0 ) dfs(map,ele);
        }
        stack.add(vertex);
        color[vertex]=1;
    }
        
}