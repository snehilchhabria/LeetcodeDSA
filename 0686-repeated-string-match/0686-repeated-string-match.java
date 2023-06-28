class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder();
        sb.append(a);
        int cnt = 1;
        while(sb.indexOf(b) <0){
            if(sb.length() - a.length() > b.length()) return -1;
            
            cnt ++;
            sb.append(a);
        }
        return cnt;
    }
}