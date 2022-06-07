import java.util.Arrays;

public class MergeSortExample {
    public int[] mergesort(int r[], int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergesort(r, start, mid);
            mergesort(r, mid + 1, end);
            merge(r, start, mid, end);
        }
        return r;
    }

    void merge(int[] r, int start, int mid, int end) {
        int a[] = new int[mid - start + 1];
        for (int indx = 0; indx < a.length; indx++) {
            a[indx] = r[start + indx];
        }
        int b[] = new int[end - mid];
        for (int indx = 0; indx < b.length; indx++) {
            b[indx] = r[mid + 1 + indx];
        }

        int i = 0;
        int j = 0;
        int k = start;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                r[k] = a[i];
                i++;
                k++;
            } else {
                r[k] = b[j];
                j++;
                k++;
            }
        }
        while (i < a.length) {
            r[k] = a[i];
            i++;
            k++;
        }
        while (j < b.length) {
            r[k] = b[j];
            j++;
            k++;
        }
    }
    public static void main(String[] args) {
        MergeSortExample obj = new MergeSortExample();
        int[] r = {2, 4, 1, 5, 3, 7};
        System.out.println(Arrays.toString(obj.mergesort(r, 0, r.length - 1)));
    }

}
