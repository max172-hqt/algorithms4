import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private final WeightedQuickUnionUF uf;
    private int numberOfOpenSites;
    private final boolean[] open;
    private final int n; // grid size
    private final int entry;
    private final int exit;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) throw new IllegalArgumentException();

        open = new boolean[n*n + 2];
        for (int i = 0; i <= n*n + 1; i++) {
            if (i == 0 || i == n*n + 1) open[i] = true; // dummy site
            open[i] = false;
        }

        uf = new WeightedQuickUnionUF(n*n + 2);
        numberOfOpenSites = 0;
        this.n = n;
        entry = 0;
        exit = this.n * this.n + 1;
    }

    private int getIndex(int row, int col) {
        return (row - 1) * n + col;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (row < 1 || row > n || col < 1 || col > n) {
            throw new IllegalArgumentException();
        }
        if (isOpen(row, col)) return;
        int index = getIndex(row, col);
        open[index] = true;

        if (row == 1) {
            uf.union(entry, index);
        }
        if (row == n) {
            uf.union(exit, index);
        }

        // upper
        if (row > 1 && isOpen(row-1, col)) {
            int upper = getIndex(row-1, col);
            uf.union(index, upper);
        }
        // left
        if (col > 1 && isOpen(row, col-1)) {
            int left = getIndex(row, col-1);
            uf.union(index, left);
        }
        // right
        if (col < n && isOpen(row, col+1)) {
            int right = getIndex(row, col+1);
            uf.union(index, right);
        }
        // down
        if (row < n && isOpen(row+1, col)) {
            int down = getIndex(row+1, col);
            uf.union(index, down);
        }
        numberOfOpenSites++;
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (row < 1 || row > n || col < 1 || col > n) {
            throw new IllegalArgumentException();
        }

        int id = getIndex(row, col);
        return open[id];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if (row < 1 || row > n || col < 1 || col > n) {
            throw new IllegalArgumentException();
        }
        int index = getIndex(row, col);
        return isOpen(row, col) && uf.find(index) == uf.find(entry);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return numberOfOpenSites;
    }

    // does the system percolate?
    public boolean percolates() {
        return uf.find(entry) == uf.find(exit);
    }

    // test client (optional)
    public static void main(String[] args) {
        int n = 10;
        Percolation p = new Percolation(n);
        while (!p.percolates()) {
            int row = StdRandom.uniform(1, n+1);
            int col = StdRandom.uniform(1, n+1);
            p.open(row, col);
        }
        StdOut.println("Number of open sites: " + p.numberOfOpenSites());
        StdOut.printf("Threshold: %5.3f", p.numberOfOpenSites / (double) n / (double) n);
        StdOut.println();
    }
}
