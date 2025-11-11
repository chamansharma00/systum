import java.util.*;

public class lru {
    public static void main(String[] args) {
        int[] refs = {2,3,2,1,5,2,4,5,3,2,5,2};
        int framesCount = 3;

        List<Integer> frames = new ArrayList<>();
        Map<Integer,Integer> lastUsed = new HashMap<>(); 
        int pageFaults = 0;

        System.out.println("Ref\tFrames\t\tResult");
        for (int i = 0; i < refs.length; i++) {
            int page = refs[i];
            boolean hit = frames.contains(page);

            if (hit) {
                lastUsed.put(page, i); 
            } else {
                pageFaults++;
                if (frames.size() < framesCount) {
                    frames.add(page);
                    lastUsed.put(page, i);
                } else {
                    int lruPage = frames.get(0);
                    int minIdx = lastUsed.getOrDefault(lruPage, Integer.MAX_VALUE);
                    for (int p : frames) {
                        int u = lastUsed.getOrDefault(p, Integer.MAX_VALUE);
                        if (u < minIdx) { minIdx = u; lruPage = p; }
                    }
                    int pos = frames.indexOf(lruPage);
                    frames.set(pos, page);
                    lastUsed.remove(lruPage);
                    lastUsed.put(page, i);
                }
            }

            System.out.printf("%d\t%s\t%s\n", page, frames.toString(), hit ? "Hit" : "Page Fault");
        }

        System.out.println("\nTotal page faults: " + pageFaults);
        System.out.printf("Hit ratio: %.2f\n", (double)(refs.length - pageFaults)/refs.length);
    }
}
