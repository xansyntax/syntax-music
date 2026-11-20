package androidx.media3.exoplayer;

import android.media.MediaFormat;
import androidx.datastore.core.AtomicInt;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class CodecParameters {
    public static final CodecParameters EMPTY = new CodecParameters(new HashMap());
    public final Map params;

    public CodecParameters(HashMap map) {
        this.params = Collections.unmodifiableMap(map);
    }

    public static AtomicInt createFrom(MediaFormat mediaFormat, Set set) {
        AtomicInt atomicInt = new AtomicInt((byte) 19);
        HashMap map = (HashMap) atomicInt.delegate;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (mediaFormat.containsKey(str)) {
                int valueTypeForKey = mediaFormat.getValueTypeForKey(str);
                if (valueTypeForKey == 1) {
                    map.put(str, Integer.valueOf(mediaFormat.getInteger(str)));
                } else if (valueTypeForKey == 2) {
                    map.put(str, Long.valueOf(mediaFormat.getLong(str)));
                } else if (valueTypeForKey == 3) {
                    map.put(str, Float.valueOf(mediaFormat.getFloat(str)));
                } else if (valueTypeForKey == 4) {
                    map.put(str, mediaFormat.getString(str));
                } else if (valueTypeForKey == 5) {
                    ByteBuffer byteBuffer = mediaFormat.getByteBuffer(str);
                    if (byteBuffer == null) {
                        map.put(str, null);
                    } else {
                        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBuffer.remaining());
                        byteBufferAllocate.put(byteBuffer.duplicate());
                        byteBufferAllocate.flip();
                        map.put(str, byteBufferAllocate);
                    }
                }
            }
        }
        return atomicInt;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CodecParameters) {
            return this.params.equals(((CodecParameters) obj).params);
        }
        return false;
    }

    public final int hashCode() {
        return this.params.hashCode();
    }
}
