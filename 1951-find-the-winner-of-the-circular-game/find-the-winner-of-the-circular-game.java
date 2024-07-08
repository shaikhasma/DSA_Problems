/*
 linked  list circular
 1--> 2--> 3--> 4--> 5   k = 2
           =
1--> 3--> 4--> 5  

 5 / 2 == 2
 n 4 
 3-->   
 next start = kth + 1        
 kth remove

 next to kth re


*/
class Solution {
    public int findTheWinner(int n, int k) {
        ArrayList<Integer> players = new ArrayList<Integer>();
        
        for(int index = 1; index <= n; index++)
            players.add(index);

        int currentPlayer = 0;

        while(players.size() > 1){
            int nextPlayer = (currentPlayer + k - 1) % players.size();
            players.remove(nextPlayer);
            currentPlayer = nextPlayer;
        }

        return players.get(0);
        
    }
}