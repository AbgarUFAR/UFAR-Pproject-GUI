package utility;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pair<K, V> {

    private final K key;
    private final V value;

    private Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public static <K, V> Pair<K, V> of(K key, V value) {
        return new Pair<>(key, value);
    }
}
