class FoodRatings {

    Map<String, PriorityQueue<Pair>> cuisinePQ = new HashMap<>();
Map<String, Integer> foodRating = new HashMap<>();
Map<String, String> foodCuisine = new HashMap<>();
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
    for (int i=0;i<foods.length;i++) {
        foodRating.put(foods[i], ratings[i]);
        foodCuisine.put(foods[i], cuisines[i]);
        cuisinePQ.computeIfAbsent(cuisines[i], k -> new PriorityQueue<>(
            (a,b) -> a.rating==b.rating ? a.food.compareTo(b.food) : b.rating-a.rating
        )).add(new Pair(foods[i], ratings[i]));
    }
}

public void changeRating(String food, int newRating) {
    foodRating.put(food, newRating);
    cuisinePQ.get(foodCuisine.get(food)).add(new Pair(food, newRating));
}

public String highestRated(String cuisine) {
    PriorityQueue<Pair> pq = cuisinePQ.get(cuisine);
    while (true) {
        Pair top = pq.peek();
        if (foodRating.get(top.food) == top.rating) return top.food;
        pq.poll(); // remove stale entry
    }
}

class Pair{ String food; int rating; Pair(String food, int rating){ this.food = food; this.rating = rating; } }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */