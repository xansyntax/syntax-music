package com.metrolist.music.playback;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Result;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class StreamUrlCache {
    public final Object currentTimeMillis;
    public final Object entries;
    public final Object generations;
    public final short maxEntries;

    /* JADX INFO: renamed from: com.metrolist.music.playback.StreamUrlCache$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0 {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1(0, System.class, "currentTimeMillis", "currentTimeMillis()J", 0);

        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return Long.valueOf(System.currentTimeMillis());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Entry {
        public final long expiresAtMillis;
        public final CachedStreamUrl stream;

        public Entry(CachedStreamUrl cachedStreamUrl, long j) {
            this.stream = cachedStreamUrl;
            this.expiresAtMillis = j;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            return this.stream.equals(entry.stream) && this.expiresAtMillis == entry.expiresAtMillis;
        }

        public final int hashCode() {
            return Long.hashCode(this.expiresAtMillis) + (this.stream.hashCode() * 31);
        }

        public final String toString() {
            return "Entry(stream=" + this.stream + ", expiresAtMillis=" + this.expiresAtMillis + ")";
        }
    }

    public StreamUrlCache() {
        AnonymousClass1 anonymousClass1 = AnonymousClass1.INSTANCE;
        this.maxEntries = (short) 500;
        this.currentTimeMillis = anonymousClass1;
        this.entries = new StreamUrlCache$entries$1(this);
        this.generations = new HashMap();
    }

    public String clientName(String str) {
        String str2;
        str.getClass();
        synchronized (((StreamUrlCache$entries$1) this.entries)) {
            Entry entry = (Entry) ((StreamUrlCache$entries$1) this.entries).get(str);
            str2 = entry != null ? entry.stream.clientName : null;
        }
        return str2;
    }

    public long generation(String str) {
        long jLongValue;
        str.getClass();
        synchronized (((StreamUrlCache$entries$1) this.entries)) {
            Long l = (Long) ((HashMap) this.generations).get(str);
            jLongValue = l != null ? l.longValue() : 0L;
        }
        return jLongValue;
    }

    public CachedStreamUrl get(String str) {
        CachedStreamUrl cachedStreamUrl;
        str.getClass();
        synchronized (((StreamUrlCache$entries$1) this.entries)) {
            try {
                Entry entry = (Entry) ((StreamUrlCache$entries$1) this.entries).get(str);
                cachedStreamUrl = null;
                if (entry != null) {
                    if (entry.expiresAtMillis <= ((Number) ((Function0) this.currentTimeMillis).invoke()).longValue()) {
                        ((StreamUrlCache$entries$1) this.entries).remove(str);
                        HashMap map = (HashMap) this.generations;
                        Long l = (Long) map.get(str);
                        map.put(str, Long.valueOf((l != null ? l.longValue() : 0L) + 1));
                    } else {
                        cachedStreamUrl = entry.stream;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cachedStreamUrl;
    }

    public void invalidate(String str) {
        str.getClass();
        synchronized (((StreamUrlCache$entries$1) this.entries)) {
            ((StreamUrlCache$entries$1) this.entries).remove(str);
            HashMap map = (HashMap) this.generations;
            Long l = (Long) map.get(str);
            map.put(str, Long.valueOf((l != null ? l.longValue() : 0L) + 1));
        }
    }

    public void put(String str, String str2, Map map, String str3, int i, boolean z, long j, boolean z2, long j2) {
        Object failure;
        str.getClass();
        str2.getClass();
        map.getClass();
        str3.getClass();
        try {
            failure = Long.valueOf(Math.addExact(((Number) ((Function0) this.currentTimeMillis).invoke()).longValue(), ((long) (i < 0 ? 0 : i)) * 1000));
        } catch (Throwable th) {
            failure = new Result.Failure(th);
        }
        if (failure instanceof Result.Failure) {
            failure = Long.MAX_VALUE;
        }
        long jLongValue = ((Number) failure).longValue();
        synchronized (((StreamUrlCache$entries$1) this.entries)) {
            Long l = (Long) ((HashMap) this.generations).get(str);
            if ((l != null ? l.longValue() : 0L) != j2) {
                return;
            }
            ((StreamUrlCache$entries$1) this.entries).put(str, new Entry(new CachedStreamUrl(str2, MapsKt__MapsKt.toMap(map), str3, z, j, z2), jLongValue));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StreamUrlCache(UUID uuid, int i, byte[] bArr, UUID[] uuidArr) {
        this.currentTimeMillis = uuid;
        this.maxEntries = i;
        this.entries = bArr;
        this.generations = uuidArr;
    }
}
