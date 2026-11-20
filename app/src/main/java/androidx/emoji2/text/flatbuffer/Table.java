package androidx.emoji2.text.flatbuffer;

import androidx.collection.internal.Lock;
import androidx.compose.foundation.MarqueeSpacing$Companion$$ExternalSyntheticLambda0;
import java.nio.ByteBuffer;
import kotlin.collections.builders.MapBuilder;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class Table {
    public Object bb;
    public int bb_pos;
    public int vtable_size;
    public int vtable_start;

    public Table() {
        if (Lock.DEFAULT == null) {
            Lock.DEFAULT = new Lock((byte) 17);
        }
    }

    public int __offset(int i) {
        if (i < this.vtable_size) {
            return ((ByteBuffer) this.bb).getShort(this.vtable_start + i);
        }
        return 0;
    }

    public void checkForComodification$kotlin_stdlib() {
        if (((MapBuilder) this.bb).modCount == this.vtable_size) {
            return;
        }
        MarqueeSpacing$Companion$$ExternalSyntheticLambda0.m52m();
    }

    public boolean hasNext() {
        return this.bb_pos < ((MapBuilder) this.bb).length;
    }

    public void initNext$kotlin_stdlib() {
        while (true) {
            int i = this.bb_pos;
            MapBuilder mapBuilder = (MapBuilder) this.bb;
            if (i >= mapBuilder.length || mapBuilder.presenceArray[i] >= 0) {
                return;
            } else {
                this.bb_pos = i + 1;
            }
        }
    }

    public void remove() {
        MapBuilder mapBuilder = (MapBuilder) this.bb;
        checkForComodification$kotlin_stdlib();
        if (this.vtable_start == -1) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Call next() before removing element from the iterator.");
            return;
        }
        mapBuilder.checkIsMutable$kotlin_stdlib();
        mapBuilder.removeEntryAt(this.vtable_start);
        this.vtable_start = -1;
        this.vtable_size = mapBuilder.modCount;
    }
}
