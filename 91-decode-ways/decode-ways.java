class Solution {
    public int numDecodings(String s) {
     int n = s.length();
	int[] mem = new int[n];
	Arrays.fill(mem, -1);
	return numDecodings(s, 0, mem);

    }
    public int numDecodings(String s, int index, int[] mem) {
        int n = s.length();
        if(index == n) return 1;
        if(s.charAt(index) == '0') return 0;
        if(mem[index] != -1) return mem[index];
        int count = numDecodings(s, index + 1,mem);
        
        if (index < n - 1 && 
        ((s.charAt(index) - '0') * 10 + 
          (s.charAt(index + 1) - '0')) < 27) 
           count += numDecodings(s, index + 2,mem);
        mem[index] = count;
        return count;

    }
    
}

/*
 226
 2
 2
      --26==1
 6
 ===> 2

 22
 6
 ==> 3



*/