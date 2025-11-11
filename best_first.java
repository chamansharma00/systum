import java.util.*;

public class best_first {
    static void bestFit(int[] blockSize, int[] processSize) {
        int m = blockSize.length, n = processSize.length;
        int[] allocation = new int[n];
        Arrays.fill(allocation, -1);
        int[] blocks = blockSize.clone();

        for (int i = 0; i < n; i++) {
            int bestIdx = -1;
            for (int j = 0; j < m; j++) {
                if (blocks[j] >= processSize[i]) {
                    if (bestIdx == -1 || blocks[j] < blocks[bestIdx])
                        bestIdx = j;
                }
            }
            if (bestIdx != -1) {
                allocation[i] = bestIdx;
                blocks[bestIdx] -= processSize[i];
            }
        }

        System.out.println("\n--- Best Fit Allocation ---");
        printResult(allocation, processSize);
    }

    static void firstFit(int[] blockSize, int[] processSize) {
        int m = blockSize.length, n = processSize.length;
        int[] allocation = new int[n];
        Arrays.fill(allocation, -1);
        int[] blocks = blockSize.clone();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (blocks[j] >= processSize[i]) {
                    allocation[i] = j;
                    blocks[j] -= processSize[i];
                    break;
                }
            }
        }

        System.out.println("\n--- First Fit Allocation ---");
        printResult(allocation, processSize);
    }

    static void printResult(int[] allocation, int[] processSize) {
        System.out.println("Process\tSize\tBlock Allocated");
        for (int i = 0; i < processSize.length; i++) {
            if (allocation[i] != -1)
                System.out.println("P" + (i+1) + "\t" + processSize[i] + "\tB" + (allocation[i]+1));
            else
                System.out.println("P" + (i+1) + "\t" + processSize[i] + "\tNot Allocated");
        }
    }

    public static void main(String[] args) {
        int[] blockSize = {100, 500, 200, 300, 600};
        int[] processSize = {212, 417, 112, 426};

        System.out.println("Memory Blocks: " + Arrays.toString(blockSize));
        System.out.println("Processes: " + Arrays.toString(processSize));

        firstFit(blockSize, processSize);
        bestFit(blockSize, processSize);
    }
}
