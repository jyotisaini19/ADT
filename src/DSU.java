/**
 *  This is naive implementation of Disjoint Set Union.
 *  Worst case time complexity of a single query is O(n)
 *  As in case of skewed tree.
 *  1 -> 2 -> 3
 *  union(1, 2) -> 1->2.
 *  union(3, 2) -> 3 -> 1 -> 2 (Skewed in nature). A single query will take O(n) time.
 *
 *
 *  The below implementation of uses path compression in find.
 *  But a single find query can become O(n) as union is doing union by rank thus
 *  above union(3, 2) is very well possible to become skewed.
 *
 */

public class DSU {
    int [] parent;

    public DSU(int n) {
        parent = new int[n];

        for (int i =0; i<n; i++) {
            parent[i]=i;
        }
    }

    /** Find using path compression**/
    // as in 3->1->2. Find(2) will change to 3 -> 1,2
    public int find(int x) {

        if (parent[x]!=x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    // This union does not ensure height. It can become skewed.
    public void union(int x, int y) {
        parent[find(x)] = find(y);
    }
}
