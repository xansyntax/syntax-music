package com.google.common.collect;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Objects;
import okhttp3.internal.http.StatusLine;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class ImmutableListMultimap extends ImmutableMultimap {
    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        int i = objectInputStream.readInt();
        if (i < 0) {
            throw new InvalidObjectException(IntIntPair$$ExternalSyntheticOutline0.m(i, "Invalid key count "));
        }
        StatusLine statusLine = new StatusLine(4);
        for (int i2 = 0; i2 < i; i2++) {
            Object object = objectInputStream.readObject();
            Objects.requireNonNull(object);
            int i3 = objectInputStream.readInt();
            if (i3 <= 0) {
                throw new InvalidObjectException(IntIntPair$$ExternalSyntheticOutline0.m(i3, "Invalid value count "));
            }
            ImmutableList.Builder builder = ImmutableList.builder();
            for (int i4 = 0; i4 < i3; i4++) {
                Object object2 = objectInputStream.readObject();
                Objects.requireNonNull(object2);
                builder.add(object2);
            }
            statusLine.put(object, builder.build());
        }
        try {
            statusLine.build(true);
        } catch (IllegalArgumentException e) {
            throw ((InvalidObjectException) new InvalidObjectException(e.getMessage()).initCause(e));
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        Maps.writeMultimap(this, objectOutputStream);
    }

    @Override // com.google.common.collect.Multimap
    public final Collection get(Object obj) {
        ImmutableList immutableList = (ImmutableList) this.map.get(obj);
        if (immutableList != null) {
            return immutableList;
        }
        ImmutableList.Itr itr = ImmutableList.EMPTY_ITR;
        return RegularImmutableList.EMPTY;
    }
}
