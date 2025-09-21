import java.util.*;

class MovieRentingSystem {

    Map<Integer, TreeSet<Pair>> system;  // movie -> available shops
    TreeSet<Pair> rented;                // rented movies
    Map<String, Pair> lookup;            // (shop,movie) -> Pair

    Comparator<Pair> systemComp = (p1, p2) -> {
        if (p1.price != p2.price) return Integer.compare(p1.price, p2.price);
        return Integer.compare(p1.shop, p2.shop);
    };

    Comparator<Pair> rentComp = (p1, p2) -> {
        if (p1.price != p2.price) return Integer.compare(p1.price, p2.price);
        if (p1.shop != p2.shop) return Integer.compare(p1.shop, p2.shop);
        return Integer.compare(p1.movie, p2.movie);
    };

    public MovieRentingSystem(int n, int[][] entries) {
        system = new HashMap<>();
        rented = new TreeSet<>(rentComp);
        lookup = new HashMap<>();

        for (int[] e : entries) {
            int shop = e[0], movie = e[1], price = e[2];
            Pair pair = new Pair(shop, movie, price);

            system.putIfAbsent(movie, new TreeSet<>(systemComp));
            system.get(movie).add(pair);

            lookup.put(key(shop, movie), pair);
        }
    }

    // return up to 5 cheapest shops
    public List<Integer> search(int movie) {
        List<Integer> ans = new ArrayList<>();
        if (!system.containsKey(movie)) return ans;

        int count = 0;
        for (Pair p : system.get(movie)) {
            ans.add(p.shop);
            if (++count == 5) break;
        }
        return ans;
    }

    public void rent(int shop, int movie) {
        Pair p = lookup.get(key(shop, movie));
        system.get(movie).remove(p);
        rented.add(p);
    }

    public void drop(int shop, int movie) {
        Pair p = lookup.get(key(shop, movie));
        rented.remove(p);
        system.get(movie).add(p);
    }

    // return up to 5 rented movies
    public List<List<Integer>> report() {
        List<List<Integer>> ans = new ArrayList<>();
        int count = 0;
        for (Pair p : rented) {
            ans.add(Arrays.asList(p.shop, p.movie));
            if (++count == 5) break;
        }
        return ans;
    }

    private String key(int shop, int movie) {
        return shop + "#" + movie;
    }

    class Pair {
        int shop, movie, price;
        Pair(int shop, int movie, int price) {
            this.shop = shop;
            this.movie = movie;
            this.price = price;
        }
    }
}
