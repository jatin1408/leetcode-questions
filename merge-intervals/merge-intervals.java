class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> {
           if(a[0] == b[0]) return a[1] - b[1];
            return a[0] -b[0];
            });
        Stack<int[]> stack=new Stack<>();
        for(int[] ele:intervals){
            if(stack.isEmpty()) stack.push(ele);
            else{
                int[] p=stack.peek();
                if(p[1]>=ele[0]) {
                    if(p[1]<ele[1]){
                        stack.pop();
                        stack.push(new int[] {p[0] , ele[1]});
                    }
                }
                else if(p[1]<ele[0]) stack.push(ele);
            }
        }
        int[][] res=new int[stack.size()][2];
        for(int i=0;i<res.length;i++) res[i]=stack.pop();
        return res;
    }
}