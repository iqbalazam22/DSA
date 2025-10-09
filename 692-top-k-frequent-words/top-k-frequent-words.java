class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            map.put(words[i], map.getOrDefault(words[i], 0)+1);
        }
        PriorityQueue<String> q = new PriorityQueue<>((a, b)->{
            int fa = map.get(a), fb = map.get(b);
            if (fa == fb) return b.compareTo(a); // lexicographically larger last
            return fa - fb; // lower freq first
        });
        for(String word : map.keySet()){
            q.add(word);
            if(q.size() > k) q.remove();
        }
        List<String> list = new ArrayList<>();
        
        while(!q.isEmpty()){
            list.add(q.remove());
        }
        Collections.reverse(list);
        return list;
    }
}