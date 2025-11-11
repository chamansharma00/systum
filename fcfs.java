public class fcfs {
    public static void main(String args[]) {
        int n = 4;

        int[] pid = {1, 2, 3, 4};
        int[] at  = {10, 0, 8, 5};
        int[] bt  = {2, 10, 4, 5};

        int[] ct  = new int[n];
        int[] tat = new int[n];
        int[] wt  = new int[n];

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (at[j] > at[j + 1]) {
                    int tmp;
                    tmp = at[j]; at[j] = at[j + 1]; at[j + 1] = tmp;
                    tmp = bt[j]; bt[j] = bt[j + 1]; bt[j + 1] = tmp;
                    tmp = pid[j]; pid[j] = pid[j + 1]; pid[j + 1] = tmp;
                }
            }
        }

        int time = 0;
        for (int i = 0; i < n; i++) {
            if (time < at[i]) time = at[i];    
            ct[i] = time + bt[i];              
            time = ct[i];                      
            tat[i] = ct[i] - at[i];            
            wt[i] = tat[i] - bt[i];           
        }

        System.out.println("PID\tAT\tBT\tCT\tTAT\tWT");
        for (int i = 0; i < n; i++) {
            System.out.println("P" + pid[i] + "\t" + at[i] + "\t" + bt[i]
                    + "\t" + ct[i] + "\t" + tat[i] + "\t" + wt[i]);
        }

        double sumTAT = 0, sumWT = 0;
        for (int i = 0; i < n; i++) { sumTAT += tat[i]; sumWT += wt[i]; }
        System.out.printf("\nAvg TAT = %.2f, Avg WT = %.2f\n", sumTAT / n, sumWT / n);
    }
}
