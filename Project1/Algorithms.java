//Imports
import java.util.ArrayList;
import java.util.Random;
import java.lang.Math;

public class Algorithms {
    //Swap numbers to sort list
    private static void switchNums(ArrayList<Integer> L, int i, int j)
    {
        int t = L.get(i);
        L.set(i, L.get(j));
        L.set(j, t);
    }
    public static ArrayList<Integer> insertionSort(ArrayList<Integer> L)
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
        return L;
    }
    public static int selectQuadraticSort(ArrayList<Integer> l, int k)
    {
        l = insertionSort(l);
        return l.get(k);
    }

    public static ArrayList<Integer> mergeSort(ArrayList<Integer> L)
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

    public static int selectLogarithmicSort(ArrayList<Integer> l, int k)
    {
        l = mergeSort(l);
        return l.get(k);
    }
    public static int partition(ArrayList<Integer> L, int left, int right, int pivotIndex)
    {
        int pivotValue = L.get(pivotIndex);
        switchNums(L, pivotIndex, right);
        int storeIndex = left;
        for (int i = 0; i <= right; i++)
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

    public static int quickSelect(ArrayList<Integer> L, int left, int right, int k)
    {
        Random randNum = new Random();
        //If list only has 1 element
        while (true)
        {
            if (left == right)
                return L.get(left);
            int pivotIndex = (int) (left + Math.floor(randNum.nextInt(right) % (right - left + 1)));
            pivotIndex = partition(L, left, right, pivotIndex);
            if (k == pivotIndex)
                return L.get(k);
            else if (k < pivotIndex)
                right = pivotIndex - 1;
            else   
                left = pivotIndex + 1;
        }
    } 
}