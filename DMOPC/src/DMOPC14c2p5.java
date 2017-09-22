import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.io.BufferedReader;
public class DMOPC14c2p5 {

    private static Map<Integer, ArrayList<Integer>> map = new HashMap<>();
    private static double[] probList;

    public static void main (String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = in.readLine().split(" ");
        int numLake = Integer.parseInt(tokens[0]);
        int numRiver = Integer.parseInt(tokens[1]);

        probList = new double[numLake+1];

        for (int i=0; i<=numLake; i++) {
        	map.put(i, new ArrayList<Integer>());
        }

        for (int i=0; i<numRiver; i++) {
            tokens = in.readLine().split(" ");
            int start = Integer.parseInt(tokens[0]);
            int end = Integer.parseInt(tokens[1]);
            map.get(start).add(end);
        }

        getProb(1, 1.0d);

        for (int i=1; i<probList.length; i++) {
            if (probList[i] != -1) {
                //System.out.println(graph.edgesFrom(i));
                if (map.get(i).size() == 0) {
                    System.out.println(probList[i]);
                }
            }
        }
    }

    private static void getProb(int node, double prob) {
        ArrayList<Integer> curNode = map.get(node);
        //System.out.println("Exploring: " + node);
        //System.out.println("Current Node: " + curNode);
        //System.out.println("Probability: " + prob);
        int size = curNode.size();
        //System.out.println("Size: " + size);
        if (size == 0) {
            //System.out.println("Added final prob " + prob);
            probList[node] += prob;
            //System.out.println("Updated node: " + probList[node]);
        } else {
            for (int i=0; i<size; i++) {
                probList[node] = -1;
                //System.out.println("Exploring prob " + (((double)(1)/(double)(size))*prob) + " at location " + curNode.get(i));
                getProb(curNode.get(i), (((double)(1)/(double)(size))*prob));
            }
        }
    }
}
