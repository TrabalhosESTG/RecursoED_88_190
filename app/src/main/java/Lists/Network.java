package Lists;


import Interfaces.NetworkADT;

public class Network<T> extends ArrayGraph<T> implements NetworkADT<T>{
    private ArrayList<ArrayList<Double>> weights;

    public Network() {
        super();
        weights = new ArrayList<ArrayList<Double>>();
    }

    @Override
    public void addEdge(T vertex1, T vertex2, double weight) {
        if(getVertices().contains(vertex1) && getVertices().contains(vertex2)) {
            getEdges().get(indexOf(vertex1)).add(vertex2);
            getEdges().get(indexOf(vertex2)).add(vertex1);
            weights.get(indexOf(vertex1)).add(weight);
            weights.get(indexOf(vertex2)).add(weight);
        }
        
    }

    @Override
    public double shortestPathWeight(T startVertex, T targetVertex) {
        int startIndex = indexOf(startVertex);
        int targetIndex = indexOf(targetVertex);
        if (startIndex == -1 || targetIndex == -1) {
            throw new IllegalArgumentException("Both vertices must be in the graph");
        }
        ArrayList<Integer> path = shortestPath(startIndex, targetIndex);
        double result = 0;
        for(int i = 0; i < path.size() - 1; i++) {
            result += weights.get(path.get(i)).get(path.get(i+1));
        }
        return result;
    }

    //shortest path between two vertices considering weights
    private ArrayList<Integer> shortestPath(int startIndex, int targetIndex) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        ArrayList<Integer> visited = new ArrayList<Integer>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        ArrayList<Double> distance = new ArrayList<Double>();
        for(int i = 0; i < getVertices().size(); i++) {
            distance.add(Double.MAX_VALUE);
        }
        distance.set(startIndex, 0.0);
        path.add(startIndex);
        while(!path.isEmpty()) {
            int current = path.remove(0);
            visited.add(current);
            for(int i = 0; i < getEdges().get(current).size(); i++) {
                int neighbor = indexOf(getEdges().get(current).get(i));
                if(!visited.contains(neighbor)) {
                    if(distance.get(neighbor) > distance.get(current) + weights.get(current).get(i)) {
                        distance.set(neighbor, distance.get(current) + weights.get(current).get(i));
                        path.add(neighbor);
                    }
                }
            }
        }
        int current = targetIndex;
        while(current != startIndex) {
            result.add(current);
            double min = Double.MAX_VALUE;
            int minIndex = -1;
            for(int i = 0; i < getEdges().get(current).size(); i++) {
                int neighbor = indexOf(getEdges().get(current).get(i));
                if(distance.get(neighbor) < min) {
                    min = distance.get(neighbor);
                    minIndex = neighbor;
                }
            }
            current = minIndex;
        }
        result.add(startIndex);
        result = reverseOrder(result);
        return result;
    }

    public ArrayList<Integer> reverseOrder(ArrayList<Integer> list) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i = list.size() - 1; i >= 0; i--) {
            result.add(list.get(i));
        }
        return result;
    } 
}
