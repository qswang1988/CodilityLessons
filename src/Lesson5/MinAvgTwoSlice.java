package Lesson5;


// check the problem :    https://app.codility.com/programmers/lessons/5-prefix_sums/min_avg_two_slice/
// the code could be improved because it was done in hurry. It got 100% total score.
public class MinAvgTwoSlice {
    public static void main(String[] args) {
        int [] test = {4,2,2,1,1,5,8};
        int [] test2 = {-3, -5, -8, -4, -10};
        int pos = new MinAvgTwoSlice().solution(test2);
        System.out.println(pos);
    }

    public int solution(int[] A) {
        // write your code in Java SE 8
        double last_round_avg = Double.MAX_VALUE;
        int min_pos = -1;
        int current_len = 2; // we start with length of 2

        while(current_len<=A.length){
            double this_round_min = Double.MAX_VALUE;
            int this_pos = 0;
            for(int i = 0;i<=A.length-current_len;i++){
                int sum = 0;
                for(int j = i;i+current_len<=A.length&&j<i+current_len;j++){
                    //System.out.println("current_len: "+current_len+" i: "+i+",j: "+j);
                    sum+= A [j];
                }
                //System.out.println("sum: "+sum);
                double avg = (double)sum/current_len;
                if(avg<this_round_min){
                    this_round_min = avg;
                    this_pos = i;
                }
            }
            //System.out.println("current len: "+current_len+", this_pos: "+this_pos+"this_round_main: "+this_round_min);

            if(this_round_min<last_round_avg){
                min_pos = this_pos;
                last_round_avg = this_round_min;
            }else{
                break;
            }

            current_len++;
        }

        return min_pos;
    }
}
