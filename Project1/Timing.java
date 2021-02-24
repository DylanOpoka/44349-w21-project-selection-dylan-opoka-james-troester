import java.util.ArrayList;
import java.util.Random;

public class Timing {
    static Random rng = new Random();
    public static double timeInsertion(ArrayList<Integer> l, int k)
    {
        double avg = 0;
        for (int i=0; i<30; i++)
        {
            long start = System.nanoTime();
            Algorithms.selectInsert(l, k);
            long end = System.nanoTime();
            avg += (end - start) / 1000000000.0;
        }
        return avg;
    }   
    public static double timeMerge(ArrayList<Integer> l, int k)
    {
        double avg = 0;
        for (int i=0; i<30; i++)
        {
            long start = System.nanoTime();
            Algorithms.selectMerge(l, k);
            long end = System.nanoTime();
            avg += (end - start) / 1000000000.0;
        }
        return avg;
    }
    public static double timeQuickSelect(ArrayList<Integer> l, int size, int k)
    {
        double avg = 0;
        for (int i=0; i<30; i++)
        {
            long start = System.nanoTime();
            Algorithms.quickSelect(l, 0, size, k);
            long end = System.nanoTime();
            avg += (end - start) / 1000000000.0;
        }
        return avg;
    }

    public static ArrayList<Integer> randomList(int n)
    {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0; i<n; i++)
            list.add(rng.nextInt());
        return list;
    }

    public static void main(String[] args)
    {
        int sizes[] = {5, 10, 50, 100, 1000, 10000, 100000};
        System.out.println("\tInsertion\tSelection\tMerge");
        for (int size:sizes)
        {
            ArrayList<Integer> randList = randomList(size);
            int rand = rng.nextInt();
            System.out.println(size + "\t" + timeInsertion(randList, rand)
                    + "\t" + timeMerge(randList, rand)
                    + "\t" + timeQuickSelect(randList, size, rand));
        }
    }
}
