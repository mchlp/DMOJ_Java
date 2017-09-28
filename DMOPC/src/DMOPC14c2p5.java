import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.io.BufferedReader;
public class DMOPC14c2p5 {

    private static ArrayList<Integer>[] map = new ArrayList[1000001];
    private static double[] dp;

    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) throws IOException {
        FastReader in = new FastReader();
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //String[] tokens = in.readLine().split(" ");
        //int numLake = Integer.parseInt(tokens[0]);
        //int numRiver = Integer.parseInt(tokens[1]);
        int numLake = in.nextInt();
        int numRiver = in.nextInt();

        dp = new double[numLake + 1];

        for (int i=0; i<=numLake; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < numRiver; i++) {
            //tokens = in.readLine().split(" ");
            //map[Integer.parseInt(tokens[0])].add(Integer.parseInt(tokens[1]));
            map[in.nextInt()].add(in.nextInt());
        }

        dp[1] = 1.0d;
        double curDp;
        for (int i=1; i<=numLake; i++) {
            int size = map[i].size();
            if (!(size == 0)) {
                curDp = dp[i];
                ArrayList<Integer> destDp = map[i];
                for (int j=0; j<destDp.size(); j++) {
                    dp[destDp.get(j)] += (1/(double)size)*curDp;
                }
                dp[i] = -1.0d;
            } else {
                System.out.println(dp[i]);
            }
        }
    }
}