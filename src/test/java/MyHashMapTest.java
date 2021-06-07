import com.magic.datastructures.MyHashMap;
import com.magic.datastructures.MyHashTable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyHashMapTest {

    @Test
    public void giveASentence_whenWordsAreAddedToList_ShouldReturnWordFrequency() {
        String sentence = "To be or not to be be";
        MyHashMap<String, Integer> myHashMap = new MyHashMap<>();
        String[] words = sentence.toLowerCase().split(" ");
        for (String word : words) {
            Integer value = myHashMap.get(word);
            if (value == null)
                value = 1;
            else
                value = value + 1;
            myHashMap.add(word, value);
        }
        int frequency = myHashMap.get("be");
        System.out.println(frequency);
        myHashMap.print();
        Assertions.assertEquals(3, frequency);
    }

    @Test
    public void giveASentence_whenWordsAreAddedToList_ShouldReturnParanoidFrequency() {
        String sentence = "Paranoids are not paranoid because they are paranoid but because they keep " +
                "putting themselves into paranoid avoidable situations";
        MyHashTable<String, Integer> myHashTable = new MyHashTable<>();
        String[] words = sentence.toLowerCase().split(" ");
        for (String word : words) {
            Integer value = myHashTable.get(word);
            if (value == null)
                value = 1;
            else
                value = value + 1;
            myHashTable.add(word, value);
        }
        int frequency = myHashTable.get("paranoid");
        myHashTable.print();
        Assertions.assertEquals(3, frequency);
    }

    @Test
    public void giveASentence_whenWordIsRemovedFromHashMap_ShouldReturnNull() {
        String sentence = "Paranoids are not paranoid because they are paranoid but because they keep " +
                "putting themselves into paranoid avoidable situations";
        MyHashTable<String, Integer> myHashTable = new MyHashTable<>();
        String[] words = sentence.toLowerCase().split(" ");
        for (String word : words) {
            Integer value = myHashTable.get(word);
            if (value == null)
                value = 1;
            else
                value = value + 1;
            myHashTable.add(word, value);
        }
        myHashTable.remove("avoidable");
        Integer frequency = myHashTable.get("avoidable");
        Assertions.assertNull(frequency);
    }
}
