package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Daily49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> answer = new ArrayList<>();
        answer.add(new ArrayList<>(List.of(strs[0])));

        var map = groupWords(strs);

        for(int i=1;i<strs.length;i++){
            var currentWord = strs[i];
            var wasAdded = false;
            for(List<String> currentGroup : answer){
                var groupRepresentative = currentGroup.getFirst();
                if(isAnagram(currentWord,groupRepresentative)){
                    currentGroup.add(currentWord);
                    wasAdded = true;
                    break;
                }
            }
            if(!wasAdded){
                answer.add(new ArrayList<>(List.of(currentWord)));
            }
        }
        return answer;
    }

    private List<List<String>> groupWords(String[] strings) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String current: strings){
            var sortedString = sortString(current);
            map.computeIfAbsent(sortedString,k -> new ArrayList<>()).add(current) ;
        }
        return new ArrayList<>(map.values());
    }

    private String sortString(String original) {
        char[] chars = original.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }


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
