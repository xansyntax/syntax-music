package kotlinx.serialization.internal;

import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class IntArraySerializer extends PrimitiveArraySerializer {
    public static final IntArraySerializer INSTANCE = new IntArraySerializer(IntSerializer.INSTANCE);

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final int collectionSize(Object obj) {
        int[] iArr = (int[]) obj;
        iArr.getClass();
        return iArr.length;
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public final Object empty() {
        return new int[0];
    }

    @Override // kotlinx.serialization.internal.CollectionLikeSerializer, kotlinx.serialization.internal.AbstractCollectionSerializer
    public final void readElement(CompositeDecoder compositeDecoder, int i, Object obj) {
        IntArrayBuilder intArrayBuilder = (IntArrayBuilder) obj;
        intArrayBuilder.getClass();
        int iDecodeIntElement = compositeDecoder.decodeIntElement(this.descriptor, i);
        intArrayBuilder.ensureCapacity$kotlinx_serialization_core(intArrayBuilder.getPosition$kotlinx_serialization_core() + 1);
        int[] iArr = intArrayBuilder.buffer;
        int i2 = intArrayBuilder.position;
        intArrayBuilder.position = i2 + 1;
        iArr[i2] = iDecodeIntElement;
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final Object toBuilder(Object obj) {
        int[] iArr = (int[]) obj;
        iArr.getClass();
        IntArrayBuilder intArrayBuilder = new IntArrayBuilder();
        intArrayBuilder.buffer = iArr;
        intArrayBuilder.position = iArr.length;
        intArrayBuilder.ensureCapacity$kotlinx_serialization_core(10);
        return intArrayBuilder;
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public final void writeContent(CompositeEncoder compositeEncoder, Object obj, int i) {
        int[] iArr = (int[]) obj;
        compositeEncoder.getClass();
        iArr.getClass();
        for (int i2 = 0; i2 < i; i2++) {
            compositeEncoder.encodeIntElement(this.descriptor, i2, iArr[i2]);
        }
    }
}
