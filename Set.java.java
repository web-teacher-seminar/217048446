import java.util.Arrays;
import java.util.LinkedList;

public class Set {
    private int key;
    private LinkedList<Integer>[]array;

    public Set() {
        this.array =new LinkedList[10];
        for (int i = 0; i < 10; i++) {
            array[i] = new LinkedList<>();
        }
    }

    public int Hash(int key) {
        return key % 10;
    }
    public void Add(int key) {
        if(Find(key)){
            return;
        }
        LinkedList<Integer> list = array[Hash(key)];
        if(list == null){
            list = new LinkedList<>();
            list.add(key);
            array[Hash(key)] = list;
        }
        else{
            array[Hash(key)].add(key);

        }


    }
    public boolean Find(int key) {
        LinkedList<Integer> list = array[Hash(key)];
        for(int o:list){
            if(o == key){
                return true;
            }
        }
        return false;

    }
    public void remove(int key) {
        if(!Find(key)){
            return;
        }
        array[Hash(key)].remove(key);
    }

    @Override
    public String toString() {
        return "Set{" +
                "key=" + key +
                ", array=" + Arrays.toString(array) +
                '}';
    }
}
