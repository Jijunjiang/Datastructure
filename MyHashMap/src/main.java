/**
 * Created by apple on 05/05/2017.
 */

public class main {
    public static void main(String arg[]) {
        MyHashMap map = new MyHashMap<Integer, String>();
        map.put(1, "caoyikun");
        map.put(2, "jiangjijun");
        map.put(3, "caojijun");
        map.put(11, "caojun");
        map.put(19, "caoj");

        System.out.println(map.remove(11));
        System.out.println(map.get(11));
        System.out.println(map.get(19));
    }

}
