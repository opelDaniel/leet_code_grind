package medium;

import java.util.Arrays;

import static java.lang.Math.sqrt;

public class Daily3296 {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {

        long lo = 1;
        long hi = (long) Arrays.stream(workerTimes).min().getAsInt() * mountainHeight * (mountainHeight +1) / 2;

        while(lo<hi){
            long mid = (lo+hi) / 2;
            if(canFinishIn(mid,mountainHeight,workerTimes)){
                hi=mid;
            }else {
                lo = mid+1;
            }
        }
        return lo;
    }

    private boolean canFinishIn(long mid,int mountainHeight, int[] workerTimes) {
        long sum = 0;

        for (long w : workerTimes){
            sum+= getBiggestNumber(w,mid);
            if(sum>= mountainHeight) return true;
        }
        return false;
    }

    private long getBiggestNumber(long w, long T) {
        return (long) (-1 + sqrt(1 + 8*T/w)) / 2;
    }
}
