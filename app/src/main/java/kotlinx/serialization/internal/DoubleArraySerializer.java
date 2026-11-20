package kotlinx.serialization.internal;

import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class DoubleArraySerializer extends PrimitiveArraySerializer {
    public static final DoubleArraySerializer INSTANCE = new DoubleArraySerializer(DoubleSerializer.INSTANCE);

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final int collectionSize(Object obj) {
        double[] dArr = (double[]) obj;
        dArr.getClass();
        return dArr.length;
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public final Object empty() {
        return new double[0];
    }

    @Override // kotlinx.serialization.internal.CollectionLikeSerializer, kotlinx.serialization.internal.AbstractCollectionSerializer
    public final void readElement(CompositeDecoder compositeDecoder, int i, Object obj) {
        DoubleArrayBuilder doubleArrayBuilder = (DoubleArrayBuilder) obj;
        doubleArrayBuilder.getClass();
        double dDecodeDoubleElement = compositeDecoder.decodeDoubleElement(this.descriptor, i);
        doubleArrayBuilder.ensureCapacity$kotlinx_serialization_core(doubleArrayBuilder.getPosition$kotlinx_serialization_core() + 1);
        double[] dArr = doubleArrayBuilder.buffer;
        int i2 = doubleArrayBuilder.position;
        doubleArrayBuilder.position = i2 + 1;
        dArr[i2] = dDecodeDoubleElement;
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final Object toBuilder(Object obj) {
        double[] dArr = (double[]) obj;
        dArr.getClass();
        DoubleArrayBuilder doubleArrayBuilder = new DoubleArrayBuilder();
        doubleArrayBuilder.buffer = dArr;
        doubleArrayBuilder.position = dArr.length;
        doubleArrayBuilder.ensureCapacity$kotlinx_serialization_core(10);
        return doubleArrayBuilder;
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public final void writeContent(CompositeEncoder compositeEncoder, Object obj, int i) {
        double[] dArr = (double[]) obj;
        compositeEncoder.getClass();
        dArr.getClass();
        for (int i2 = 0; i2 < i; i2++) {
            compositeEncoder.encodeDoubleElement(this.descriptor, i2, dArr[i2]);
        }
    }
}
