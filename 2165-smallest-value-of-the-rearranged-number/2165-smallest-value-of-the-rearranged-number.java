class Solution {
    public long smallestNumber(long num) {
        boolean inc = false;
        if(num<0) {
            inc=true;
            num*=-1;
        }
        int[] dig=calcDigits(num);
        if(inc) return createHigher(dig);
        return createSmall(dig);
    }
    public int[] calcDigits(long num){
        int[] res=new int[10];
        while(num!=0){
            int last = (int) Math.abs(num%10);
            res[last]+=1;
            num/=10;
        }
        return res;
    }
    public long createHigher(int[] dig){
       long newNum=0;
        for(int i=9;i>=1;i--){
           int freq=dig[i];
           while(freq!=0){
               newNum=newNum*10+i;
               freq--;
           }
        }
        int zeroFreq=dig[0];
        while(zeroFreq!=0){
            newNum=newNum*10;
            zeroFreq--;
        }
        return newNum * -1;
    }
    public long createSmall(int[] dig){
        long newNum=0;
        boolean zero=false;
        boolean set=false;
        for(int i=1;i<=9;i++){
            int freq=dig[i];
            while(freq!=0){
                if(!zero && set){
                    zero=true;
                    int zeroFreq=dig[0];
                    while(zeroFreq!=0){
                    newNum=newNum*10;
                    zeroFreq--;
                }
                }
                newNum=newNum*10+i;
                freq--;
                set=true;
            }
           
            
        }
        if(!zero) {
            int zeroFreq=dig[0];
                    while(zeroFreq!=0){
                    newNum=newNum*10;
                    zeroFreq--;
        }
        }
        return newNum;
    }
}