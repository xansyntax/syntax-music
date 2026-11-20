package kotlin.io;

import dagger.hilt.EntryPoints;
import io.ktor.util.collections.TreeLike;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;
import kotlin.UIntArray;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt$sequenceOf$1$1;
import kotlin.text.LinesIterator;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class LinesSequence implements Sequence {
    public final /* synthetic */ byte $r8$classId;
    public final Object reader;

    /* JADX INFO: renamed from: kotlin.io.LinesSequence$iterator$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 implements Iterator, KMappedMarker {
        public boolean done;
        public String nextValue;

        public AnonymousClass1() {
        }

        @Override // java.util.Iterator
        public final boolean hasNext() throws IOException {
            String line = this.nextValue;
            if (line == null && !this.done) {
                line = ((BufferedReader) LinesSequence.this.reader).readLine();
                this.nextValue = line;
                if (line == null) {
                    this.done = true;
                }
            }
            return line != null;
        }

        @Override // java.util.Iterator
        public final Object next() {
            if (!hasNext()) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1();
                return null;
            }
            String str = this.nextValue;
            this.nextValue = null;
            str.getClass();
            return str;
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public /* synthetic */ LinesSequence(byte b, Object obj) {
        this.$r8$classId = b;
        this.reader = obj;
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        byte b = this.$r8$classId;
        Object obj = this.reader;
        switch (b) {
            case 0:
                return new AnonymousClass1();
            case 1:
                return new UIntArray.Iterator((Object[]) obj);
            case 2:
                return ((Iterable) obj).iterator();
            case 3:
                return EntryPoints.iterator((Function2) obj);
            case 4:
                return new SequencesKt__SequencesKt$sequenceOf$1$1((TreeLike) obj);
            default:
                return new LinesIterator((CharSequence) obj);
        }
    }
}
