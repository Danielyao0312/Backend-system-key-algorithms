    /*
    1. find nodes:
        用 BFS 找到所有的 node （queue + hashset）
    2. clone nodes:
        用一个 hashmap， 对于每一个node, 创建一个新 node，并建立 hash 对应关系
    3. clone edges:
        把 旧 node 中 的 neighbor 中的每一个 node 对应的新 node, 加入到 新 node 的 neighbor 中去
    */ 