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
            //"google.mail.com" splits into ["9000 google", "mail", "com"].
            String[] split1 = domain.split("\\s+");
            
            // Extract count count part will always be in split1[0]
            int freq = Integer.parseInt(split1[0]);

            //Split the domain into parts based on domain part will always be on split1[1]"."
            String[] split2 = split1[1].split("\\.");
            
           String current = "";
            //"com", "mail", "google".
            //"com", "mail.com", "google.mail.com".
           for (int index = split2.length - 1; index >= 0; index--) {
                current = split2[index] + (current.isEmpty() ? "" : ".") + current;
                counts.put(current, counts.getOrDefault(current, 0) + freq);
            }
        }

        List<String> ans = new ArrayList<>();
        for(Map.Entry<String , Integer> entry : counts.entrySet()){
            ans.add(entry.getValue ()+ " " + entry.getKey());
        }

        return ans;
    }
}