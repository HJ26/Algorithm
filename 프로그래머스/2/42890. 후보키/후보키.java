import java.util.*;

class Solution {
	
	static ArrayList<HashSet<Integer>> candidateKey;
	
	public int solution(String[][] relation){
		candidateKey = new ArrayList<>();
		int colSize = relation[0].length;
		
		for(int i = 1 ; i <= colSize ; ++i) {
			makeKeySet(-1, colSize - 1, 0, i, new HashSet<>(), relation);
		}
		
		return candidateKey.size();
	}

	private void makeKeySet(int attr, int maxAttr, int idx, int size, HashSet<Integer> keySet, String[][] relation) {
		if(idx == size) {
			
			for(HashSet<Integer> key : candidateKey) {
				if(keySet.containsAll(key)) return;
            }
			
			if(isUnique(keySet, relation)) candidateKey.add(keySet);
	
			return;
		}
		
		for(int i = attr + 1 ; i <= maxAttr ; ++i) {
			HashSet<Integer> newKeySet = new HashSet<>(keySet);
			newKeySet.add(i);
			makeKeySet(i, maxAttr, idx + 1, size, newKeySet, relation);
		}
	}

	private boolean isUnique(HashSet<Integer> keySet, String[][] relation) {
		HashMap<String, String> map = new HashMap<>();
		
		for(int r = 0 ; r < relation.length ; ++r) {
			String key = "";
			
			for(int c : keySet) {
				key += relation[r][c];
			}
			
			if(map.containsKey(key)) return false;
			else map.put(key, key);
		}	
		return true;
	}
}