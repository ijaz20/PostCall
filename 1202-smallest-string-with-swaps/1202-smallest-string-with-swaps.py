class UnionFind:
    def __init__(self, size):
        self.root = [i for i in range(size)]
        self.rank = [1] * size
    def find(self, x):
        if x == self.root[x]:
            return x
        self.root[x] = self.find(self.root[x])
        return self.root[x]
    def union(self, x, y):
        rootX = self.find(x)
        rootY = self.find(y)
        if rootX != rootY:
            if self.rank[rootX] > self.rank[rootY]:
                self.root[rootY] = rootX
            elif self.rank[rootX] < self.rank[rootY]:
                self.root[rootX] = rootY
            else:
                self.root[rootY] = rootX
                self.rank[rootX] += 1
    def connected(self, x, y):
        return self.find(x) == self.find(y)

class Solution:
    def smallestStringWithSwaps(self, s: str, pairs: List[List[int]]):
        N=len(s)
        DSU=UnionFind(N)
        for x,y in pairs:
            DSU.union(x,y)
        parent=[DSU.find(i) for i in range(N)]
        dict=defaultdict(deque)
        for i in range(N):
            dict[parent[i]].append(s[i])
        for key in dict:
            dict[key]=deque(sorted(dict[key]))
        ans=""
        for i in range(N):
            dict_key=parent[i]
            ans+=dict[dict_key].popleft()
        return ans