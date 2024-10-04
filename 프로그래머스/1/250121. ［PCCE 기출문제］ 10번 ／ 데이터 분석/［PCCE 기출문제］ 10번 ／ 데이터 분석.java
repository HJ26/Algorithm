import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        // 정렬 기준과 인덱스 관계를 저장
        Map<String, Integer> order = new HashMap<>();
        order.put("code", 0);
        order.put("date", 1);
        order.put("maximum", 2);
        order.put("remain", 3);
        
        // 기준에 맞춰 정렬
        int[][] filterData = Arrays.stream(data).filter( x -> x[order.get(ext)] < val_ext).toArray(int[][]::new);
        Arrays.sort(filterData, (o1, o2) -> o1[order.get(sort_by)] - o2[order.get(sort_by)]);
        
        
        
        return filterData;
        
        
    }
}