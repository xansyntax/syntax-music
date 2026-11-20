package com.metrolist.music.playback;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class StreamUrlCache$entries$1 extends LinkedHashMap {
    public final /* synthetic */ StreamUrlCache this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StreamUrlCache$entries$1(StreamUrlCache streamUrlCache) {
        super(0, 0.75f, true);
        this.this$0 = streamUrlCache;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object obj) {
        if (obj instanceof String) {
            return super.containsKey((String) obj);
        }
        return false;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsValue(Object obj) {
        if (obj instanceof StreamUrlCache.Entry) {
            return super.containsValue((StreamUrlCache.Entry) obj);
        }
        return false;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Object get(Object obj) {
        if (obj instanceof String) {
            return (StreamUrlCache.Entry) super.get((String) obj);
        }
        return null;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
    public final /* bridge */ Object getOrDefault(Object obj, Object obj2) {
        return !(obj instanceof String) ? obj2 : (StreamUrlCache.Entry) super.getOrDefault((String) obj, (StreamUrlCache.Entry) obj2);
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ boolean remove(Object obj, Object obj2) {
        if ((obj instanceof String) && (obj2 instanceof StreamUrlCache.Entry)) {
            return super.remove((String) obj, (StreamUrlCache.Entry) obj2);
        }
        return false;
    }

    @Override // java.util.LinkedHashMap
    public final boolean removeEldestEntry(Map.Entry entry) {
        entry.getClass();
        return super.size() > this.this$0.maxEntries;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Object remove(Object obj) {
        if (obj instanceof String) {
            return (StreamUrlCache.Entry) super.remove((String) obj);
        }
        return null;
    }
}
