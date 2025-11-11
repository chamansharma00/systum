import java.util.*;

class Process {
    String name;
    int at, bt, rt, ct, wt, tat;

    Process(String name, int at, int bt) {
        this.name = name;
        this.at = at;
        this.bt = bt;
        this.rt = bt;
    }
}

public class rr {
    public static void main(String[] args) {
        int tq = 1; // time quantum
        List<Process> procs = new ArrayList<>(Arrays.asList(
                new Process("P1", 10, 2),
                new Process("P2", 0, 10),
                new Process("P3", 8, 4),
                new Process("P4", 5, 5)
        ));

        // Sort by arrival time
        procs.sort(Comparator.comparingInt(p -> p.at));
        Queue<Process> q = new LinkedList<>();
        int time = 0, completed = 0;
        Set<Process> added = new HashSet<>();

        System.out.println("Gantt Chart:");
        while (completed < procs.size()) {
            for (Process p : procs)
                if (p.at <= time && !added.contains(p) && p.rt > 0) {
                    q.add(p);
                    added.add(p);
                }

            if (q.isEmpty()) {
                time++;
                continue;
            }

            Process cur = q.poll();
            System.out.print("| " + cur.name + " ");
            int exec = Math.min(tq, cur.rt);
            cur.rt -= exec;
            time += exec;

            for (Process p : procs)
                if (p.at <= time && !added.contains(p) && p.rt > 0) {
                    q.add(p);
                    added.add(p);
                }

            if (cur.rt > 0) q.add(cur);
            else {
                cur.ct = time;
                completed++;
            }
        }

        System.out.println("|");
        System.out.println("\n\nProcess\tAT\tBT\tCT\tTAT\tWT");
        double totalTAT = 0, totalWT = 0;
        for (Process p : procs) {
            p.tat = p.ct - p.at;
            p.wt = p.tat - p.bt;
            totalTAT += p.tat;
            totalWT += p.wt;
            System.out.println(p.name + "\t" + p.at + "\t" + p.bt + "\t" + p.ct + "\t" + p.tat + "\t" + p.wt);
        }
        System.out.printf("\nAverage Turnaround Time: %.2f", totalTAT / procs.size());
        System.out.printf("\nAverage Waiting Time: %.2f\n", totalWT / procs.size());
    }
}
