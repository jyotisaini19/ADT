class Item {
    int rank;
    int parent;

    Item(int rank, int parent) {
        this.rank = rank;
        this.parent = parent;
    }
}

/**
 * This is DSU with path compression in find operation and union by rank.
 * Union by rank will ensure minimum height and a single query will not take more then
 * O(log(n)) time.
 *
 */
public class DSUByRank {

    Item [] items;

    DSUByRank(int n) {
        items = new Item[n];

        for (int i= 0; i< n ;i++) {
            items[i] = new Item(0, i);
        }
    }

    // Implementation with path compression.
    int find(int x) {

        if (items[x].parent != x) {
            items[x].parent = find(items[x].parent);
        }

        return items[x].parent;
    }

    //Union by rank.
    void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);

        if (items[xRoot].rank < items[yRoot].rank) {
            items[xRoot].parent = yRoot;
        } else if (items[yRoot].rank < items[xRoot].rank) {
            items[yRoot].parent = xRoot;
        } else {
            items[xRoot].parent = yRoot;
            items[yRoot].rank++;
        }
    }
}
