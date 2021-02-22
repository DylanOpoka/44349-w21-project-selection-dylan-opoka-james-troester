//Imports
import java.util.ArrayList;

public class Algorithms {
    //Swap numbers to sort list
    private static void switchNums(ArrayList<Integer> L, int i, int j)
    {
        Integer t = L.get(i);
        L.set(i, L.get(j));
        L.set(j, t);
    }
    public static ArrayList<Integer> selectInsert(ArrayList<Integer> L, integer k)
    {
        //InsertionSort
        for (int i = 0; i < L.size(); i++){
            int j = i;
            while (j > 0 && L.get(j - 1) > L.get(j)){
                switchNums(L, j-1, j);
                j--;
            }
        }
        return L.get(k);
    }

    public static ArrayList<Integer> selectMerge(ArrayList<Integer> L)
    {
        //MergeSort
        if (L.size() <= 1)
            return L;
        ArrayList<Integer> A = new ArrayList<>(L.subList(0, L.size()/2));
        A = mergeSort(A);
        ArrayList<Integer> B = new ArrayList<>(L.subList(L.size()/2, L.size()));
        B = mergeSort(B);
        return merge(A, B);
    }
}