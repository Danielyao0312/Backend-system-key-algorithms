public class Solution {
      public List<Integer> topKFrequent(int[] nums, int k) {

        List<Integer> res = new ArrayList<>();

        // minHeap
        PriorityQueue<Wrapper> pq = new PriorityQueue<>(k, new Comparator<Wrapper>() {
            @Override
            public int compare(Wrapper o1, Wrapper o2) {
                return o1.count - o2.count;
            }
        });

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }
        

        for (int key : map.keySet()) {
            int value = map.get(key);
            
            if (pq.size() < k) {
                pq.add(new Wrapper(key, value));
            }
            else if (value >= pq.peek().count) {
                pq.poll();
                pq.add(new Wrapper(key, value));
            }

        }

        while (!pq.isEmpty()) {
            int key = pq.poll().val;
            res.add(key);
        }
        Collections.reverse(res);

        return res;
    }


    class Wrapper {
        int count;
        int val;
        public Wrapper(int val, int count) {
            this.count = count;
            this.val = val;
        }
    }
}