import java.util.Scanner;

public class Find2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số cần tìm: ");
        int key = sc.nextInt();
        int[] list = {1,2,3,4,5,6,7,8,9};
        int index = binarySearch(list,key);
        System.out.println("Số " + key + "\nVị Trí " + index);

    }

    static int binarySearch(int[] list, int key) {
        int low = 0;
        int high = list.length - 1;
        while (high >= low) {
            int mid = (low + high) / 2;
            if (key < list[mid])
                high = mid - 1;
            else if (key == list[mid])
                return mid;
            else
                low = mid + 1;
        }
        return -1;
    }
}
