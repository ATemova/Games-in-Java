public class TowerOfHanoi {
    public static void main(String[] args) {
        int n = 4; // Number of disks
        solveHanoi(n, 'A', 'C', 'B');
    }

    private static void solveHanoi(int n, char from, char to, char aux) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + from + " to " + to);
            return;
        }
        solveHanoi(n - 1, from, aux, to);
        System.out.println("Move disk " + n + " from " + from + " to " + to);
        solveHanoi(n - 1, aux, to, from);
    }
}
