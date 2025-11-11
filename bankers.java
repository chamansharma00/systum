
public class bankers {

    public static void main(String[] args) {
        int n = 3;
        int m = 2;

        
    int alloc[][] ={
        {1,0},
        {0,1},
        {1,1}
    };

    int max[][]={
        {2,2},
        {1,2},
        {1,3}
    };


    int avail[] = {1,1};

    int need[][] = new int[n][m];
    for(int i = 0;i<n;i++){
        for(int j=0;j<m;j++){
            need[i][j] = max[i][j] - alloc[i][j];
        }
    }

    boolean[] finished = new boolean[n];
    int[] safeSeq = new int[n];
    int count =0;
    int[] work = avail.clone();

    while(count<n){
        boolean found = false;
        for(int i=0;i<n;i++){
            if(!finished[i])
            {
                boolean canRun = true;

                for(int j=0;j<m;j++){
                    if(need[i][j] > work[j]){
                        canRun = false;
                        break;
                    }
                }

                if(canRun){
                    for(int j=0;j<m;j++){
                        work[j] +=alloc[i][j];
                    }

                    safeSeq[count++]=i;
                    finished[i] = true;
                    found = true;
                }
            }
        }

        if(!found){
            System.out.println("Not in Safe State");
            return;
        }
    }          

    System.out.println("Safe Sequence");
    for(int i=0;i<n;i++){
        System.out.println("p" + safeSeq[i]);
        if(i <= n-1)
            System.out.println("->");
    }
    System.out.println();
}
    
}
