class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> indegree = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> recipeSet = new HashSet<>();
        List<String> result = new ArrayList<>();

        for(int i=0;i<recipes.length;i++){
            recipeSet.add(recipes[i]);
            for(String ingredient : ingredients.get(i)){
                graph.putIfAbsent(ingredient, new ArrayList<>());
                graph.putIfAbsent(recipes[i], new ArrayList<>());
                indegree.putIfAbsent(ingredient, 0);
                indegree.putIfAbsent(recipes[i], 0);
                graph.get(ingredient).add(recipes[i]);
                indegree.put(recipes[i], indegree.get(recipes[i])+1);
            }
        }

        for(String supply : supplies){
            if(indegree.containsKey(supply) && indegree.get(supply)==0){
                queue.offer(supply);
            }
        }

        while(!queue.isEmpty()){
            String item = queue.poll();
            if(recipeSet.contains(item)) result.add(item);

            if(graph.containsKey(item)){
                for(String dependents : graph.get(item)){
                    indegree.put(dependents, indegree.get(dependents)-1);
                    if(indegree.get(dependents)==0){
                        queue.offer(dependents);
                    }
                }
            }
        }
        return result;
    }
}