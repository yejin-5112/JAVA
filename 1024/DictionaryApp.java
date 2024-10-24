package OpenChallenge4;

abstract class PairMap {
    protected String keyArray[];
    protected String valueArray[];

    abstract public String get(String key);
    abstract public void put(String key, String value);
    abstract public String delete(String key);
    abstract public int length();
}

class Dictionary extends PairMap {
    private int size;

    public Dictionary(int capacity) {
        keyArray = new String[capacity];
        valueArray = new String[capacity];
        size = 0;
    }

    @Override
    public String get(String key) {
        for (int i = 0; i < size; i++) {
            if (keyArray[i].equals(key)) {
                return valueArray[i];
            }
        }
        return null;
    }

    @Override
    public void put(String key, String value) {
        for (int i = 0; i < size; i++) {
            if (keyArray[i].equals(key)) {
                valueArray[i] = value;
                return;
            }
        }
        if (size < keyArray.length) {
            keyArray[size] = key;
            valueArray[size] = value;
            size++;
        }
    }

    @Override
    public String delete(String key) {
        for (int i = 0; i < size; i++) {
            if (keyArray[i].equals(key)) {
                String value = valueArray[i];
                for (int j = i; j < size - 1; j++) {
                    keyArray[j] = keyArray[j + 1];
                    valueArray[j] = valueArray[j + 1];
                }
                keyArray[size - 1] = null;
                valueArray[size - 1] = null;
                size--;
                return value;
            }
        }
        return null;
    }

    @Override
    public int length() {
        return size;
    }
}

public class DictionaryApp {
    public static void main(String[] args) {
        Dictionary dic = new Dictionary(10);
        dic.put("황기태", "자바");
        dic.put("이재문", "파이선");
        dic.put("이재문", "C++");
        
        System.out.println("이재문의 값은 " + dic.get("이재문"));
        System.out.println("황기태의 값은 " + dic.get("황기태"));
        dic.delete("황기태");
        System.out.println("황기태의 값은 " + dic.get("황기태"));
    }
}
