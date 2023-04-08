import java.util.*;

public class TopWords {
    public static void main(String[] args) {
        top3("In a village of La Mancha, the name of which I have no desire to call to mind, there lived not long since one of those gentlemen that keep a lance in the lance-rack, an old buckler, a lean hack, and a greyhound for coursing. An olla of rather more beef than mutton, a salad on most nights, scraps on Saturdays, lentils on Fridays, and a pigeon or so extra on Sundays, made away with three-quarters of his income.");
    }
    public static List<String> top3(String s) {
        s = s.toLowerCase().replaceAll("[^a-zA-Z\\s']", "");
        List<String> wordList = Arrays.asList(s.split(" "));
        ArrayList<String> top3List = new ArrayList<>();
        Map<String, Integer> top3Map = new HashMap<>();
        if(wordList.size() < 2) return wordList;
        for(String str : wordList) {
            if(top3Map.containsKey(str)) {
                top3Map.put(str, top3Map.get(str) + 1);
            }
            else {
                top3Map.put(str, 1);
            }
        }
        for(int i = 0; i < 3; i++) {
            String key = "";
            int value = 0;
            for(Map.Entry<String, Integer> set : top3Map.entrySet()) {
                if(set.getValue() > value) {
                    value = set.getValue();
                    key = set.getKey();
                }
            }
            top3List.add(key);
            top3Map.remove(key);
        }
        for(String str : top3List) System.out.println(str);
        return top3List;
    }
}
