package easy;

import java.util.HashMap;

public class Daily242 {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        var map = new HashMap<Character,Integer>();

        for(int i =0;i< s.length();i++){
            handleMap(s.charAt(i),1,map);
            handleMap(t.charAt(i),-1,map);
        }
        return map.isEmpty();
    }

    private void handleMap(char c, int i, HashMap<Character, Integer> map) {
        if(map.containsKey(c)){
            var newValue =  map.merge(c,i,Integer::sum);
            if(newValue == 0 ) map.remove(c);
        }else {
            map.put(c,i);
        }
    }
}
