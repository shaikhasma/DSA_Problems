class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<String>();

        if(s.length() > 12)
           return ans;

        String str = s;
        validIp(str, "", 0, 0, ans);
        return ans;
    }

    void validIp(String str, String  path, int index, int dots, List<String> ans){
        if(dots > 4) 
            return;
        if(dots == 4 && index >= str.length()){
            ans.add(path.substring(0, path.length() - 1));
            return;
        }

        for(int length = 1; length <= 3 && index + length <= str.length(); length++ ){
            
            String num = str.substring(index, index + length);
            
            if( num.charAt(0) == '0' && length != 1 ){
                break;
            }     
            else if(Integer.parseInt(num) <= 255){
                validIp(str, 
                path + num + "." , 
                index + length, 
                dots + 1, 
                ans );
            }
        }
    }
}