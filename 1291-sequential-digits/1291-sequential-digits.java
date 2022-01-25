class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        Queue<Integer> q=new LinkedList<>();
        for(int i=1;i<=9;i++) q.add(i);
        List<Integer> ls=new ArrayList<>();
        while(!q.isEmpty()){
            Integer p=q.poll();
            if(p>high) break;
            int lastDig=(p%10);
            if(lastDig==9) continue;
            int newNo= p*10 + (lastDig + 1);
            if(newNo>=low && newNo<=high) ls.add(newNo);
            q.add(newNo);
            
        }
        return ls; 
    }
}