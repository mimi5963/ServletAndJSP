package Collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapEx {

    public static void main(String[] args){

        Map<String,Integer> map = new HashMap<>();

        //객체 저장
        map.put("신용권",85);
        map.put("홍길동",95);
        map.put("동장군",87);
        map.put("홍길동",85);

        //키로 값 얻기
        String key = "홍길동";
        int value = map.get(key);
        System.out.println(key +" : "+value);
        System.out.println();

        //키 Set 컬렉션 얻고, 키와 값 얻기
        Set<String> keySet = map.keySet();
        Iterator<String> keyIterator = keySet.iterator();

        while(keyIterator.hasNext()){
          String k = keyIterator.next();
          Integer v = map.get(k);
          System.out.println(k + ":" + v);
        }
        System.out.println();

        //엔트리 set 컬렉션을 얻고, 반복헤서 키와 값 얻기

        Set<Map.Entry<String,Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<String,Integer>> entryIterator = entrySet.iterator();
        while (entryIterator.hasNext()){
            Map.Entry<String,Integer> ent= entryIterator.next();
            String k = ent.getKey();
            Integer v = ent.getValue();
            System.out.println(k + " : "+ v);
        }
        System.out.println();

        //키로 엔트리 삭제
        map.remove("홍길동");
        System.out.println("총 Entey 수:" + map.size());
        System.out.println();


    }

}
