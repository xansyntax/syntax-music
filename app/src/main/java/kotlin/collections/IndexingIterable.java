package kotlin.collections;

import java.util.Iterator;
import kotlin.UIntArray;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.text.DelimitedRangesSequence;
import kotlin.text.DelimitedRangesSequence.AnonymousClass1;
import kotlinx.serialization.descriptors.SerialDescriptor;
import okio.internal.ResourceFileSystem$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class IndexingIterable implements Iterable, KMappedMarker {
    public final /* synthetic */ byte $r8$classId;
    public final Object iteratorFactory;

    public /* synthetic */ IndexingIterable(byte b, Object obj) {
        this.$r8$classId = b;
        this.iteratorFactory = obj;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        byte b = this.$r8$classId;
        Object obj = this.iteratorFactory;
        switch (b) {
            case 0:
                Object[] objArr = (Object[]) ((ResourceFileSystem$$ExternalSyntheticLambda0) obj).f$0;
                objArr.getClass();
                return new IndexingIterator(new UIntArray.Iterator(objArr));
            case 1:
                Object[] objArr2 = (Object[]) obj;
                objArr2.getClass();
                return new UIntArray.Iterator(objArr2);
            case 2:
                return ((DelimitedRangesSequence) obj).new AnonymousClass1();
            case 3:
                final String str = (String) obj;
                return new IntIterator() { // from class: kotlin.text.StringsKt__StringsKt$iterator$1
                    public int index;

                    {
                        super((byte) 1);
                    }

                    @Override // java.util.Iterator
                    public final boolean hasNext() {
                        return this.index < str.length();
                    }

                    @Override // kotlin.collections.IntIterator
                    public final char nextChar() {
                        int i = this.index;
                        this.index = i + 1;
                        return str.charAt(i);
                    }
                };
            default:
                return new UIntArray.Iterator((SerialDescriptor) obj);
        }
    }
}
