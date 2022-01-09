class ProductOfNumbers {
    int[] prefix;
    int lastZero=-1;
    int currIndex=0;
    public ProductOfNumbers() {
        prefix=new int[40000];
    }
    
    public void add(int num) {
        if(num==0) lastZero=currIndex;
        prefix[currIndex]=currIndex==0 || prefix[currIndex-1] ==0 ?num:num*prefix[currIndex-1];
        // System.out.println(prefix[currIndex]);
        currIndex++;
    }
    
    public int getProduct(int k) {
        if(lastZero == -1){
            int prod=prefix[currIndex-1];
            if(k>=currIndex) return prod;
            prod/=prefix[currIndex-k-1];
            return prod;
        }
        else{
        int distance=currIndex-lastZero - 1;
        if(distance<k) return 0;
        int prod=prefix[currIndex-1];
        int hamming=currIndex-k-1;
        if(prefix[hamming]!=0) prod/=prefix[hamming]; 
        return prod;
        }
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */