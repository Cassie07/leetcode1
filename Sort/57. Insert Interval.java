/**
57. Insert Interval
DescriptionHintsSubmissionsDiscussSolution
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        intervals.add(newInterval);
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
