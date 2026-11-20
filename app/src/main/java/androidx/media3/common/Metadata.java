package androidx.media3.common;

import androidx.media3.common.util.Util;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Metadata {
    public final Entry[] entries;
    public final long presentationTimeUs;

    public Metadata(List list) {
        this((Entry[]) list.toArray(new Entry[0]));
    }

    public final Metadata copyWithAppendedEntries(Entry... entryArr) {
        if (entryArr.length == 0) {
            return this;
        }
        String str = Util.DEVICE_DEBUG_INFO;
        Entry[] entryArr2 = this.entries;
        Object[] objArrCopyOf = Arrays.copyOf(entryArr2, entryArr2.length + entryArr.length);
        System.arraycopy(entryArr, 0, objArrCopyOf, entryArr2.length, entryArr.length);
        return new Metadata(this.presentationTimeUs, (Entry[]) objArrCopyOf);
    }

    public final Metadata copyWithAppendedEntriesFrom(Metadata metadata) {
        return metadata == null ? this : copyWithAppendedEntries(metadata.entries);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && Metadata.class == obj.getClass()) {
            Metadata metadata = (Metadata) obj;
            if (Arrays.equals(this.entries, metadata.entries) && this.presentationTimeUs == metadata.presentationTimeUs) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.presentationTimeUs) + (Arrays.hashCode(this.entries) * 31);
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("entries=");
        sb.append(Arrays.toString(this.entries));
        long j = this.presentationTimeUs;
        if (j == -9223372036854775807L) {
            str = "";
        } else {
            str = ", presentationTimeUs=" + j;
        }
        sb.append(str);
        return sb.toString();
    }

    public Metadata(long j, Entry... entryArr) {
        this.presentationTimeUs = j;
        this.entries = entryArr;
    }

    public Metadata(Entry... entryArr) {
        this(-9223372036854775807L, entryArr);
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface Entry {
        default byte[] getWrappedMetadataBytes() {
            return null;
        }

        default Format getWrappedMetadataFormat() {
            return null;
        }

        default void populateMediaMetadata(MediaMetadata.Builder builder) {
        }
    }
}
