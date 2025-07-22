class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for(int num = left; num <= right; num++){
            int f = 0;
            int n= num;
            while(n>0){
                int x = n%10;
                if(x==0 || num % x != 0){
                    f=1;
                    break;
                }
                n/=10;
            }
            if(f==0){
                result.add(num);
            }
        }
        return result;
    }
}