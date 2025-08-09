import java.util.*;

class Solution {

    private final List<String> answer = new ArrayList<>();
    private final Map<String, Queue<String>> graph = new HashMap<>();

    public String[] solution(String[][] tickets) {
        for (String[] ticket : tickets) {
            String from = ticket[0];
            String to = ticket[1];

            graph.putIfAbsent(from, new PriorityQueue<>());
            graph.get(from).add(to);
        }

        dfs("ICN");

        Collections.reverse(answer);

        return answer.toArray(new String[0]);
    }

    private void dfs(String current) {
        while (graph.containsKey(current) && !graph.get(current).isEmpty()) {
            String next = graph.get(current).poll();
            dfs(next);
        }
        
        answer.add(current);
    }
    
}