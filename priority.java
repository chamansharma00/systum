import java.util.*;

class Proc {
    String name;
    int at, bt, rem, pr; // arrival, burst, remaining (unused here), priority
    int ct, tat, wt;
    boolean done = false;
    Proc(String n, int a, int b, int p) { name=n; at=a; bt=b; rem=b; pr=p; }
}

public class priority {
    public static void main(String[] args) {
        // processes in order P1..P4
        List<Proc> procs = Arrays.asList(
            new Proc("P1", 10, 2, 2),
            new Proc("P2", 0, 10, 1),
            new Proc("P3", 8, 4, 3),
            new Proc("P4", 5, 5, 2)
        );

        int n = procs.size();
        int time = 0, completed = 0;
        StringBuilder gantt = new StringBuilder();

        // run until all processes are completed
        while (completed < n) {
            // find eligible processes (arrived && not done)
            Proc best = null;
            for (Proc p : procs) {
                if (!p.done && p.at <= time) {
                    if (best == null
                        || p.pr < best.pr // higher priority (lower number)
                        || (p.pr == best.pr && p.at < best.at) // tie-breaker by arrival time
                    ) {
                        best = p;
                    }
                }
            }

            if (best == null) {
                // no process has arrived yet -> advance time
                time++;
                continue;
            }

            // execute best process fully (non-preemptive)
            gantt.append("| ").append(best.name).append(" ");
            time += best.bt;
            best.ct = time;
            best.tat = best.ct - best.at;
            best.wt = best.tat - best.bt;
            best.done = true;
            completed++;
        }
        gantt.append("|");

        // print Gantt chart and table
        System.out.println("Gantt Chart:");
        System.out.println(gantt.toString());
        System.out.println("\nProcess\tAT\tBT\tPr\tCT\tTAT\tWT");
        double totalTAT = 0, totalWT = 0;
        for (Proc p : procs) {
            System.out.printf("%s\t%d\t%d\t%d\t%d\t%d\t%d\n",
                p.name, p.at, p.bt, p.pr, p.ct, p.tat, p.wt);
            totalTAT += p.tat;
            totalWT += p.wt;
        }
        System.out.printf("\nAverage Turnaround Time: %.2f\n", totalTAT / n);
        System.out.printf("Average Waiting Time: %.2f\n", totalWT / n);
    }
}
