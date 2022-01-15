class Solution {
    public int minJumps(int[] arr) {
        Map<Integer,List<Integer>> occ=new HashMap<>();
        for(int i=0;i<arr.length;i++) {
            List<Integer> ls=occ.getOrDefault(arr[i], new ArrayList<>());
            ls.add(i);
            occ.put(arr[i],ls);
        }
        Map<Integer,List<Integer>> map=new HashMap<>();
        Queue<Integer> q=new LinkedList<>();
        boolean[] visited=new boolean[arr.length];
        q.add(0);
        int steps=0;
        while(!q.isEmpty()){
            int size=q.size();
            while(size!=0){
            int index=q.poll();
            if(index == arr.length-1)
                return steps;
             visited[index]=true;
            if(index-1 >=0 && !visited[index-1]) q.add(index-1);
            if(index+1<arr.length && !visited[index+1]) q.add(index+1);
            if(occ.containsKey(arr[index])){
            for(int ele:occ.get(arr[index])) if(!visited[ele]) q.add(ele);
            occ.remove(arr[index]);    
            }
            size--;
        }
               steps++;
        }
        return -1;
    }
    }
