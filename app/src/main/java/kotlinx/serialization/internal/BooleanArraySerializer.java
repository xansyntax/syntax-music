package kotlinx.serialization.internal;

import kotlinx.serialization.encoding.CompositeDecoder;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class BooleanArraySerializer extends PrimitiveArraySerializer {
    public static final BooleanArraySerializer INSTANCE = new BooleanArraySerializer(BooleanSerializer.INSTANCE);

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final int collectionSize(Object obj) {
        boolean[] zArr = (boolean[]) obj;
        zArr.getClass();
        return zArr.length;
    }

    @Override // kotlinx.serialization.internal.CollectionLikeSerializer, kotlinx.serialization.internal.AbstractCollectionSerializer
    public final void readElement(CompositeDecoder compositeDecoder, int i, Object obj) {
        BooleanArrayBuilder booleanArrayBuilder = (BooleanArrayBuilder) obj;
        booleanArrayBuilder.getClass();
        boolean zDecodeBooleanElement = compositeDecoder.decodeBooleanElement(this.descriptor, i);
        booleanArrayBuilder.ensureCapacity$kotlinx_serialization_core(booleanArrayBuilder.getPosition$kotlinx_serialization_core() + 1);
        boolean[] zArr = booleanArrayBuilder.buffer;
        int i2 = booleanArrayBuilder.position;
        booleanArrayBuilder.position = i2 + 1;
        zArr[i2] = zDecodeBooleanElement;
    }
}
