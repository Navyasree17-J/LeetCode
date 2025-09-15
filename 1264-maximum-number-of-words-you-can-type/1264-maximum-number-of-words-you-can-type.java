class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String words[] = text.split(" ");
        int cnt = 0;
        outer:
        for(int i = 0; i < words.length; i++){
            inner:
            for(char c: brokenLetters.toCharArray()){
                if(words[i].indexOf(c) >= 0){
                    continue outer;
                }
            }
            cnt++;
        }
        return cnt;
    }
}