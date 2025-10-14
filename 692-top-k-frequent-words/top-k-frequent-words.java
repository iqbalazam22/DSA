class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            map.put(words[i], map.getOrDefault(words[i], 0)+1);
        }
        PriorityQueue<String> heap = new PriorityQueue<>((a, b)->{
            int fA = map.get(a);
            int fB = map.get(b);

            if(fA == fB) return b.compareTo(a);
            return fA - fB;
        });
        for(String word : map.keySet()){
            heap.add(word);

            if(heap.size() > k) heap.remove();
        }
        List<String> list = new ArrayList<>();

        while(!heap.isEmpty()){
            list.add(heap.remove());
        }
        Collections.reverse(list);
        return list;
    }
}