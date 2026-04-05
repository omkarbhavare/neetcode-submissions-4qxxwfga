class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }

        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();

        for(int i=0; i<s.length();i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            map1.put(c1,map1.getOrDefault(c1,0)+1);
            map2.put(c2,map2.getOrDefault(c2,0)+1);
        }

        for(int i=0 ; i<s.length();i++){
            char ch = s.charAt(i);

            if (!map1.get(ch).equals(map2.get(ch))) {
        return false;
    }
        }
        return true;
    }
}
