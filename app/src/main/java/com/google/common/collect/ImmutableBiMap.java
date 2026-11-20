package com.google.common.collect;

import androidx.media3.common.TrackGroup;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Collection;
import okhttp3.internal.http.StatusLine;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ImmutableBiMap extends ImmutableMap {
    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // java.util.Map
    public final Collection values() {
        return ((RegularImmutableBiMap) this).inverse.keySet();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Builder extends StatusLine {
        @Override // okhttp3.internal.http.StatusLine
        public final ImmutableMap buildKeepingLast() {
            throw new UnsupportedOperationException("Not supported for bimaps");
        }

        @Override // okhttp3.internal.http.StatusLine
        public final StatusLine put(Object obj, Object obj2) {
            super.put(obj, obj2);
            return this;
        }

        @Override // okhttp3.internal.http.StatusLine
        public final StatusLine putAll(Iterable iterable) {
            super.putAll(iterable);
            return this;
        }

        public final void put(TrackGroup trackGroup, String str) {
            super.put((Object) trackGroup, (Object) str);
        }
    }
}
