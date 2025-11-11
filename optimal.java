import java.util.*;

public class optimal {
    public static void main(String[] args) {
        int[] refs = {2, 3, 2, 1, 5, 2, 4, 5, 3, 2, 5, 2};
        int framesCount = 3;

        List<Integer> frames = new ArrayList<>();
        int pageFaults = 0;

        System.out.println("Ref\tFrames\t\tResult");
        for (int i = 0; i < refs.length; i++) {
            int page = refs[i];
            boolean hit = frames.contains(page);

            if (!hit) {
                pageFaults++;

                if (frames.size() < framesCount) {
                    frames.add(page);
                } else {
                    int farthestIndex = -1;
                    int replaceIndex = -1;

                    for (int j = 0; j < frames.size(); j++) {
                        int nextUse = Integer.MAX_VALUE;
                        for (int k = i + 1; k < refs.length; k++) {
                            if (frames.get(j) == refs[k]) {
                                nextUse = k;
                                break;
                            }
                        }
                        if (nextUse > farthestIndex) {
                            farthestIndex = nextUse;
                            replaceIndex = j;
                        }
                    }
                    frames.set(replaceIndex, page);
                }
            }
            System.out.printf("%d\t%s\t%s\n", page, frames.toString(), hit ? "Hit" : "Page Fault");
        }

        int total = refs.length;
        System.out.println("\nTotal Page Faults: " + pageFaults);
        System.out.printf("Hit Ratio: %.2f\n", (double) (total - pageFaults) / total);
    }
}
