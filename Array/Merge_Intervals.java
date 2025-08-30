class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;

        if(n <= 1){
            return intervals;
        }
        
        //  Sort intervals based on start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> answer = new ArrayList<>();

        answer.add(intervals[0]);

        for(int i = 1; i < n; i++){
            int lastIntervals[] = answer.get(answer.size() -1);


            if(intervals[i][0] <= lastIntervals[1]){
                lastIntervals[1] = Math.max(lastIntervals[1], intervals[i][1]);

            }else{
                answer.add(intervals[i]);
            }
        }


        return answer.toArray(new int[answer.size()][]);

    }
}







*******************************************************************************************************************************



Detailed dry run (example)

Input: [[1,3],[2,6],[8,10],[15,18]]

Step A — sort by start (line 10)
Sorted intervals: [[1,3], [2,6], [8,10], [15,18]] (already sorted)

Step B — init (line 14)
answer = [[1,3]] (we added intervals[0])

Loop i = 1 (interval = [2,6])

lastIntervals = answer.get(last) = [1,3]

check intervals[1][0] <= lastIntervals[1] → 2 <= 3 → true (overlap)

merge: lastIntervals[1] = max(3, 6) = 6

answer is now [[1,6]] (we mutated the first interval)

Loop i = 2 (interval = [8,10])

lastIntervals = [1,6]

check 8 <= 6 → false

no overlap → answer.add([8,10])

answer = [[1,6], [8,10]]

Loop i = 3 (interval = [15,18])

lastIntervals = [8,10]

check 15 <= 10 → false

add [15,18]

answer = [[1,6], [8,10], [15,18]]

Finish → convert to int[][] and return [[1,6],[8,10],[15,18]].

