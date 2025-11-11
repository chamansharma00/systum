import java.util.*;

class Job {
    String name;
    int at, bt;
    int ct, tat, wt;
    boolean done = false;
    Job(String n, int a, int b) { name=n; at=a; bt=b; }
}

public class SJFNonPreemptive {
    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
            new Job("P1", 10, 2),
            new Job("P2", 0, 10),
            new Job("P3", 8, 4),
            new Job("P4", 5, 5)
        );

        // sort by arrival to make scanning predictable
        jobs.sort(Comparator.comparingInt(j -> j.at));

        int time = 0, completed = 0, n = jobs.size();
        StringBuilder gantt = new StringBuilder();

        // run until all jobs completed
        while (completed < n) {
            // collect arrived & not done jobs
            Job next = null;
            for (Job j : jobs) {
                if (!j.done && j.at <= time) {
                    if (next == null || j.bt < next.bt || (j.bt == next.bt && j.at < next.at))
                        next = j;
                }
            }

            if (next == null) { // no job available now -> advance time
                time++;
                continue;
            }

            // schedule next job (non-preemptive) until completion
            gantt.append("| ").append(next.name).append(" ");
            time += next.bt;
            next.ct = time;
            next.tat = next.ct - next.at;
            next.wt = next.tat - next.bt;
            next.done = true;
            completed++;
        }
        gantt.append("|");

        // Print results
        System.out.println("Gantt Chart:");
        System.out.println(gantt.toString());
        System.out.println("\nProcess\tAT\tBT\tCT\tTAT\tWT");
        double totalTAT = 0, totalWT = 0;
        // print in original process order (P1..P4)
        jobs.sort(Comparator.comparing(j -> j.name));
        for (Job j : jobs) {
            System.out.printf("%s\t%d\t%d\t%d\t%d\t%d\n",
                j.name, j.at, j.bt, j.ct, j.tat, j.wt);
            totalTAT += j.tat;
            totalWT += j.wt;
        }
        System.out.printf("\nAverage Turnaround Time: %.2f\n", totalTAT / n);
        System.out.printf("Average Waiting Time: %.2f\n", totalWT / n);
    }
}
