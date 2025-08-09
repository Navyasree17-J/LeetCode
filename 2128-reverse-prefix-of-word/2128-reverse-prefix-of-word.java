class Solution {
    public String reversePrefix(String word, char ch) {
        Stack<Character> stack=new Stack<>();
        String res="";
        for(int i=0;i<word.length();i++)
        {
         if(word.charAt(i)!=ch){
          stack.push(word.charAt(i));
         }
         else{
           res+=word.charAt(i);
           while(!stack.isEmpty()){
            res+=stack.pop();
           
           }
           res+=word.substring(i+1);
           return res.toString();
         }
        }
      return word;
    }
}