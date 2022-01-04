class Solution {
    public int bitwiseComplement(int num) {
        if(num==0) return 1;
        int bits=count(num);  
      for(int i=0;i<bits;i++){
          int temp=1<<i;
          int set=num&temp;
          if(set==0)
              num=num | (1<<i);
          
          else
              num=(num & ~(1 << (i)));
      }  
        return num;
    }
    public int count(int number)
    {
        return (int)(Math.log(number) /
                     Math.log(2) + 1);
    }
}