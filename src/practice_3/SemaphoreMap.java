package practice_3;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Semaphore;

public class SemaphoreMap<K, V> implements Map<K, V> {
    private final Map<K, V> map = new HashMap<>();
    private static final Semaphore semaphore = new Semaphore(1);

    @Override
    public int size() {
        try {
            semaphore.acquire();
            int size = map.size();
            semaphore.release();
            return size;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        try {
            semaphore.acquire();
            boolean isEmpty = map.isEmpty();
            semaphore.release();
            return isEmpty;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return map.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        try {
            semaphore.acquire();
            boolean containsKey = map.containsKey(key);
            semaphore.release();
            return containsKey;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        try {
            semaphore.acquire();
            boolean containsValue = map.containsValue(value);
            semaphore.release();
            return containsValue;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return map.containsValue(value);
    }

    @Override
    public V get(Object key) {
        try {
            semaphore.acquire();
            V value = map.get(key);
            semaphore.release();
            return value;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return map.get(key);
    }

    @Override
    public V put(K key, V value) {
        try {
            semaphore.acquire();
            V resValue = map.put(key, value);
            semaphore.release();
            return resValue;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return map.put(key, value);
    }

    @Override
    public V remove(Object key) {
        try {
            semaphore.acquire();
            V value = map.remove(key);
            semaphore.release();
            return value;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return map.remove(key);
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        try {
            semaphore.acquire();
            map.putAll(m);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void clear() {
        try {
            semaphore.acquire();
            map.clear();
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Set<K> keySet() {
        try {
            semaphore.acquire();
            Set<K> keySet = map.keySet();
            semaphore.release();
            return keySet;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        try {
            semaphore.acquire();
            Collection<V> values = map.values();
            semaphore.release();
            return values;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return map.values();
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        try {
            semaphore.acquire();
            Set<Entry<K, V>> entrySet = map.entrySet();
            semaphore.release();
            return entrySet;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return map.entrySet();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("{");

        for (var entry : entrySet()) {
            res.append(entry.getKey())
                    .append(": ")
                    .append(entry.getValue())
                    .append(", ");
        }

        res.delete(res.length() - 2, res.length())
                .append("}");
        return res.toString();
    }

    public static void main(String[] args) throws Exception {
        SemaphoreMap<Integer, Integer> map = new SemaphoreMap<>();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                map.put(i, i * i);
            }
            System.out.println(map);
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                map.put(i, i * 100);
            }
            System.out.println(map);
        });

        thread1.start();
        thread2.start();
    }
}
