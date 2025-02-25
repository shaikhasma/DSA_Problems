/*
N - number of domain
M - Average length domain 
Travers N domain 
  - split M domain

TC - 0(NM)
SC - 0(NM) subdomain entry in hashmap

*/
class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> counts = new HashMap<>();

        for(String domain : cpdomains){
            //split the string using " " to separate the count and the domain.
            String[] split1 = domain.split("\\s+");
            
            // Extract count
            int freq = Integer.parseInt(split1[0]);

            //Split the domain into parts based on ".".
            String[] split2 = split1[1].split("\\.");
           StringBuilder current = new StringBuilder();

            for( int index = split2.length - 1; index >= 0; index--){
                if (current.length() > 0) 
                      current.insert(0, ".");

                current.insert(0, split2[index]); 
                counts.put(current.toString(), counts.getOrDefault(current.toString(), 0) + freq);
            }
        }

        List<String> ans = new ArrayList<>();
        for(String domain: counts.keySet()){
            ans.add(counts.get(domain) + " " + domain);
        }

        return ans;
    }
}