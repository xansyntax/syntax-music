package kotlinx.serialization.internal;

import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class FloatArraySerializer extends PrimitiveArraySerializer {
    public static final FloatArraySerializer INSTANCE = new FloatArraySerializer(FloatSerializer.INSTANCE);

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final int collectionSize(Object obj) {
        float[] fArr = (float[]) obj;
        fArr.getClass();
        return fArr.length;
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public final Object empty() {
        return new float[0];
    }

    @Override // kotlinx.serialization.internal.CollectionLikeSerializer, kotlinx.serialization.internal.AbstractCollectionSerializer
    public final void readElement(CompositeDecoder compositeDecoder, int i, Object obj) {
        FloatArrayBuilder floatArrayBuilder = (FloatArrayBuilder) obj;
        floatArrayBuilder.getClass();
        float fDecodeFloatElement = compositeDecoder.decodeFloatElement(this.descriptor, i);
        floatArrayBuilder.ensureCapacity$kotlinx_serialization_core(floatArrayBuilder.getPosition$kotlinx_serialization_core() + 1);
        float[] fArr = floatArrayBuilder.buffer;
        int i2 = floatArrayBuilder.position;
        floatArrayBuilder.position = i2 + 1;
        fArr[i2] = fDecodeFloatElement;
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final Object toBuilder(Object obj) {
        float[] fArr = (float[]) obj;
        fArr.getClass();
        FloatArrayBuilder floatArrayBuilder = new FloatArrayBuilder();
        floatArrayBuilder.buffer = fArr;
        floatArrayBuilder.position = fArr.length;
        floatArrayBuilder.ensureCapacity$kotlinx_serialization_core(10);
        return floatArrayBuilder;
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public final void writeContent(CompositeEncoder compositeEncoder, Object obj, int i) {
        float[] fArr = (float[]) obj;
        compositeEncoder.getClass();
        fArr.getClass();
        for (int i2 = 0; i2 < i; i2++) {
            compositeEncoder.encodeFloatElement(this.descriptor, i2, fArr[i2]);
        }
    }
}
