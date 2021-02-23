//Imports
import java.util.ArrayList;

public class Algorithms {
    //Swap numbers to sort list
    private static void switchNums(ArrayList<Integer> L, int i, int j)
    {
        int t = L.get(i);
        L.set(i, L.get(j));
        L.set(j, t);
    }
    public static ArrayList<Integer> selectInsert(ArrayList<Integer> L, int k)
    {
        //InsertionSort
        for (int i = 0; i < L.size(); i++)
        {
            int j = i;
            while (j > 0 && L.get(j - 1) > L.get(j))
            {
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
    private static ArrayList<Integer> merge(ArrayList<Integer> A, ArrayList<Integer> B)
    {
        int iA=0;
        int iB=0;
        ArrayList<Integer> C = new ArrayList<>();
        while (iA < A.size() && iB < B.size()){
            if (A.get(iA) < B.get(iB)){
                C.add(A.get(iA));
                iA++;
            }
            else{
                C.add(B.get(iB));
                iB++;
            }
        }
        while (iA < A.size()){
            C.add(A.get(iA));
            iA++;
        }
        while (iB < B.size()){
            C.add(B.get(iB));
            iB++;
        }
        return C;   
    }

    public static int partition(ArrayList<Integer> L, int left, int right, int pivotIndex)
    {
        int pivotValue = L.get(pivotIndex);
        switchNums(L, L.get(pivotIndex), L.get(right));
        int storeIndex = left;
        for (int i = 0; i < right)
        {
            if (L.get(i) < pivotValue)
            {
                switchNums(L, L.get(storeIndex), L.get(i));
                storeIndex ++;
            }
        }
        switchNums(L, L.get(right), L.get(storeIndex));
        return storeIndex;
    }
    public static ArrayList<Integer> quickSelect(ArrayList<Integer> L, int left, int right, int k)
    {
        //If list only has 1 element
        if (left == right)
            return L.get(left);
        int pivotIndex = right;
        pivotIndex = partition(L, left, right, pivotIndex);
        if (k = pivotIndex)
            return L.get(k);
        else if (k < pivotIndex)
            return quickSelect(L, left, pivotIndex -1, k);
        else   
            return select(L, pivotIndex + 1, right, k);
    }
}