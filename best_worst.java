import java.util.*;

public class MemoryPlacement {
    static int[] bestFit(int[] blocks, int[] procs) {
        int[] b = blocks.clone();
        int[] alloc = new int[procs.length];
        Arrays.fill(alloc, -1);
        for (int i = 0; i < procs.length; i++) {
            int bestIdx = -1;
            for (int j = 0; j < b.length; j++) {
                if (b[j] >= procs[i]) {
                    if (bestIdx == -1 || b[j] < b[bestIdx]) bestIdx = j;
                }
            }
            if (bestIdx != -1) {
                alloc[i] = bestIdx;
                b[bestIdx] -= procs[i]; 
            }
        }
        System.out.println("Blocks left after Best-Fit: " + Arrays.toString(b));
        return alloc;
    }

    static int[] worstFit(int[] blocks, int[] procs) {
        int[] b = blocks.clone();
        int[] alloc = new int[procs.length];
        Arrays.fill(alloc, -1);
        for (int i = 0; i < procs.length; i++) {
            int worstIdx = -1;
            for (int j = 0; j < b.length; j++) {
                if (b[j] >= procs[i]) {
                    if (worstIdx == -1 || b[j] > b[worstIdx]) worstIdx = j;
                }
            }
            if (worstIdx != -1) {
                alloc[i] = worstIdx;
                b[worstIdx] -= procs[i];
            }
        }
        System.out.println("Blocks left after Worst-Fit: " + Arrays.toString(b));
        return alloc;
    }

    static void printResult(String title, int[] procs, int[] blocks, int[] alloc) {
        System.out.println("\n" + title);
        System.out.println("Proc\tSize\tAllocatedBlock\tBlockSizeBeforeAllocation");
        int[] before = blocks.clone();
        int[] b = blocks.clone();
        for (int i = 0; i < procs.length; i++) {
            int p = procs[i];
            int idx = alloc[i];
            int beforeSize = (idx == -1) ? -1 : b[idx];
            System.out.printf("P%-3d\t%-4d\t%-15s\t%s\n", i, p,
                    (idx == -1 ? "Not Allocated" : ("B" + idx)),
                    (beforeSize == -1 ? "-" : beforeSize));
            if (idx != -1) b[idx] -= p;
        }
    }

    public static void main(String[] args) {
        int[] blocks = {100, 500, 200, 300, 600};              
        int[] procs  = {212, 417, 112, 426};                    

        System.out.println("Initial blocks: " + Arrays.toString(blocks));
        System.out.println("Processes:      " + Arrays.toString(procs));

        int[] bestAlloc = bestFit(blocks, procs);
        printResult("BEST FIT ALLOCATION", procs, blocks, bestAlloc);

        int[] worstAlloc = worstFit(blocks, procs);
        printResult("WORST FIT ALLOCATION", procs, blocks, worstAlloc);
    }
}
