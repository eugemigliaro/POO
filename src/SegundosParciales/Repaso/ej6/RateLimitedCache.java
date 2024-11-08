package SegundosParciales.Repaso.ej6;

import java.util.HashMap;
import java.util.Map;

public class RateLimitedCache<K, V> extends BaseCache<K, V> {
    private Map<String, Map<String, UserData>> readsAndWrites;
    private Map<String, QuotaType> quotaTypeByUser;

    public RateLimitedCache() {
        this.readsAndWrites = new HashMap<>();
        this.quotaTypeByUser = new HashMap<>();
    }

    public void register(String user, QuotaType quotaType) {
        this.quotaTypeByUser.put(user, quotaType);
        this.readsAndWrites.put(user, new HashMap<>());
    }

    @Override
    public void put(String user, String date, K key, V value) {
        readsAndWrites.get(user).putIfAbsent(date, new UserData());

        if(quotaTypeByUser.get(user).canWrite(readsAndWrites.get(user).get(date).getWrites())){
            super.put(user, date, key, value);
            readsAndWrites.get(user).get(date).incrementWrites();
        } else {
            throw new RateLimitedException();
        }
    }

    @Override
    public V get(String user, String date, K key) {
        if(quotaTypeByUser.get(user).canRead(readsAndWrites.get(user).get(date).getReads())){
            readsAndWrites.get(user).get(date).incrementReads();
            return super.get(user, date, key);
        } else {
            throw new RateLimitedException();
        }
    }
}
