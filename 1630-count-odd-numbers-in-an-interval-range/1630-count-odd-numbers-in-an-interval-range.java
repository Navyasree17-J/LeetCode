class Solution {
    public int countOdds(int low, int high) {
        int c = ((high+1)/2 - low/2);
        return c;
    }
}


//class Solution {
//    public int countOdds(int low, int high) {
  //      if(low%2 == 0) low++;
    //    int count =0;
      //  for(int i = low; i <= high; i+2){
        //    if(i%2!=0){
          //      count++;
            //}
        //}
        //return count;
   // }
//}
