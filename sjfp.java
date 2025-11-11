public class sjfp{
    public static void main(String[] args){
        int n=4;
        int pid[] = {1,2,3,4};
        int at[] = {10,0,8,5};
        int bt[] = {2,10,4,5};
        int ct[] = new int[n],tat[] = new int[n],wt[]=new int[n];
        boolean done[]=new boolean[n];
        int time = 0,completed=0;

        while(completed<n){
            int idx = -1,minBT=9999;
            for(int i=0;i<n;i++){
                if(!done[i] && at[i] <= time && bt[i] < minBT){
                    minBT = bt[i];
                    idx=i;
                }
            }


            if(idx==-1){
                time++;
                continue;
            }

            time += bt[idx];
            ct[idx]=time;
            tat[idx]=ct[idx]-at[idx];
            wt[idx]=tat[idx]-bt[idx];
            done[idx]=true;
            completed++;
        }

        System.out.println("PID\tAT\tBT\tCT\tTAT\tWT");
        for(int i=0;i<n;i++){
            System.out.println("p"+pid[i]+"\t"+at[i]+"\t"+bt[i]+"\t"+ct[i]+"\t"+tat[i]+"\t"+wt[i]);
        }
    }
}