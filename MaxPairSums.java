import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            int[] a = new int[n];
            int[] b = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }

            for (int i = 0; i < n; i++) {
                b[i] = scanner.nextInt();
            }

            List<Integer> elements = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    elements.add(a[i] + b[j]);
                }
            }

            Collections.sort(elements, Collections.reverseOrder());

            for (int i = 0; i < k; i++) {
                System.out.print(elements.get(i) + " ");
            }

            System.out.println();
        }
    }
}