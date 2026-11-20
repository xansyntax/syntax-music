package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class BufferIterator extends AbstractListIterator {
    public final /* synthetic */ byte $r8$classId = 1;
    public final Object buffer;

    public BufferIterator(Object[] objArr, int i, int i2) {
        super(i, i2);
        this.buffer = objArr;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        byte b = this.$r8$classId;
        Object obj = this.buffer;
        switch (b) {
            case 0:
                if (!hasNext()) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1();
                    return null;
                }
                int i = this.index;
                this.index = i + 1;
                return ((Object[]) obj)[i];
            default:
                if (hasNext()) {
                    this.index++;
                    return obj;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1();
                return null;
        }
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        byte b = this.$r8$classId;
        Object obj = this.buffer;
        switch (b) {
            case 0:
                if (!hasPrevious()) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1();
                    return null;
                }
                int i = this.index - 1;
                this.index = i;
                return ((Object[]) obj)[i];
            default:
                if (hasPrevious()) {
                    this.index--;
                    return obj;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1();
                return null;
        }
    }

    public BufferIterator(int i, Object obj) {
        super(i, 1);
        this.buffer = obj;
    }
}
