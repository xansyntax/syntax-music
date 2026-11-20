package kotlinx.serialization.internal;

import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class ShortArraySerializer extends PrimitiveArraySerializer {
    public static final ShortArraySerializer INSTANCE = new ShortArraySerializer(ShortSerializer.INSTANCE);

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final int collectionSize(Object obj) {
        short[] sArr = (short[]) obj;
        sArr.getClass();
        return sArr.length;
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public final Object empty() {
        return new short[0];
    }

    @Override // kotlinx.serialization.internal.CollectionLikeSerializer, kotlinx.serialization.internal.AbstractCollectionSerializer
    public final void readElement(CompositeDecoder compositeDecoder, int i, Object obj) {
        ShortArrayBuilder shortArrayBuilder = (ShortArrayBuilder) obj;
        shortArrayBuilder.getClass();
        short sDecodeShortElement = compositeDecoder.decodeShortElement(this.descriptor, i);
        shortArrayBuilder.ensureCapacity$kotlinx_serialization_core(shortArrayBuilder.getPosition$kotlinx_serialization_core() + 1);
        short[] sArr = shortArrayBuilder.buffer;
        int i2 = shortArrayBuilder.position;
        shortArrayBuilder.position = i2 + 1;
        sArr[i2] = sDecodeShortElement;
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final Object toBuilder(Object obj) {
        short[] sArr = (short[]) obj;
        sArr.getClass();
        ShortArrayBuilder shortArrayBuilder = new ShortArrayBuilder();
        shortArrayBuilder.buffer = sArr;
        shortArrayBuilder.position = sArr.length;
        shortArrayBuilder.ensureCapacity$kotlinx_serialization_core(10);
        return shortArrayBuilder;
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public final void writeContent(CompositeEncoder compositeEncoder, Object obj, int i) {
        short[] sArr = (short[]) obj;
        compositeEncoder.getClass();
        sArr.getClass();
        for (int i2 = 0; i2 < i; i2++) {
            compositeEncoder.encodeShortElement(this.descriptor, i2, sArr[i2]);
        }
    }
}
