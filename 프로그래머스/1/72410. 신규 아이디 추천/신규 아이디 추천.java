class Solution {
    public String solution(String new_id) {
        
        // 1
        String id = new_id.toLowerCase();
        // 2
        id = id.replaceAll("[^a-z0-9-_.]", "");
        // 3
        id = id.replaceAll("[.]{2,}", ".");
        //4
        id = id.replaceAll("^[.]|[.]$", "");
        
        //5~7
        if( id.length() >= 16 ){
            id = id.substring(0, 15);
            id = id.replaceAll("[.]$", "");
        } else if(id.length() <= 2){
            if(id.isEmpty()) id += "a";
            while(id.length() < 3){
                id += id.charAt(id.length() - 1);
            }
        }
        
        return id;
    }
}