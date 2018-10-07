/**
56. Merge Intervals
DescriptionHintsSubmissionsDiscussSolution
Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considerred overlapping.
*/

import java.util.*; 

class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        // dictionary={start:index}
        //Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        //for(int i=0;i<intervals.size();i++){
        //    check[i]=intervals.get(i)
        //    map.put(intervals.get(i).start,i);
        //}
        // array=[start]
        //int[] starts=new int[intervals.size()];
        //for(int i=0;i<intervals.size();i++){
        //    starts[i]=intervals.get(i).start;
        //}
        //int[] nums=InsertSort(starts);
        
        // Sort each interval by its start
        //List<Interval> new_int = new ArrayList();
        //for(int i=0;i<intervals.size();i++){
        //    int index=map.get(nums[i]);
        //    new_int.add(intervals.get(index));
        //}
        

        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start)); //!!! Sort the intervals by its start elem
        List<Interval> result = new ArrayList();
        int i=0;
        for(i=0;i<intervals.size();i++){
            if (i+1==intervals.size()){         // when i is the last element(avoid out of index)
                result.add(intervals.get(i));
                break;
            }
            if (intervals.get(i).end>=intervals.get(i+1).start&&intervals.get(i).end<=intervals.get(i+1).end){
                int start=intervals.get(i).start;
                int end=intervals.get(i+1).end;
                intervals.get(i+1).start=start;
                intervals.get(i+1).end=end;
                intervals.remove(intervals.get(i));
                i=i-1;
            }else if(intervals.get(i).end>=intervals.get(i+1).start&&intervals.get(i).end>intervals.get(i+1).end){
                intervals.remove(intervals.get(i+1));
                i=i-1;
            }else{
                continue;
            }
        }
        return intervals;
    }
}

