class Solution {
    public int[][] merge(int[][] intervals) {
        
        if(intervals.length<=1) return intervals;
        
        // sort the element by first number in the array
        Arrays.sort(intervals,(array1,array2) -> Integer.compare(array1[0],array2[0]));
        
        List<int[]> list=new ArrayList<>(); // because we dont know the merging numbers
        
        list.add(intervals[0]);
        
        // check final interval with coming interval
        for(int[] next:intervals){
            int i=list.size()-1;;
            int[]arr=list.get(i);
            
            if(next[0]<=arr[1]){
               list.remove(i);
                int []newarr={arr[0],Math.max(arr[1],next[1])};
                list.add(newarr);
            }else{
                list.add(next);
            }
        }
       return  list.toArray(new int[list.size()][]);
    }
}
