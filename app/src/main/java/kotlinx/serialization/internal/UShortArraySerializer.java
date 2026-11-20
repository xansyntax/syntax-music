package kotlinx.serialization.internal;

import kotlin.UShortArray;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class UShortArraySerializer extends PrimitiveArraySerializer {
    public static final UShortArraySerializer INSTANCE = new UShortArraySerializer(UShortSerializer.INSTANCE);

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final int collectionSize(Object obj) {
        return ((UShortArray) obj).storage.length;
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public final Object empty() {
        return new UShortArray(new short[0]);
    }

    @Override // kotlinx.serialization.internal.CollectionLikeSerializer, kotlinx.serialization.internal.AbstractCollectionSerializer
    public final void readElement(CompositeDecoder compositeDecoder, int i, Object obj) {
        UShortArrayBuilder uShortArrayBuilder = (UShortArrayBuilder) obj;
        uShortArrayBuilder.getClass();
        short sDecodeShort = compositeDecoder.decodeInlineElement(this.descriptor, i).decodeShort();
        uShortArrayBuilder.ensureCapacity$kotlinx_serialization_core(uShortArrayBuilder.getPosition$kotlinx_serialization_core() + 1);
        short[] sArr = uShortArrayBuilder.buffer;
        int i2 = uShortArrayBuilder.position;
        uShortArrayBuilder.position = i2 + 1;
        sArr[i2] = sDecodeShort;
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final Object toBuilder(Object obj) {
        short[] sArr = ((UShortArray) obj).storage;
        UShortArrayBuilder uShortArrayBuilder = new UShortArrayBuilder();
        uShortArrayBuilder.buffer = sArr;
        uShortArrayBuilder.position = sArr.length;
        uShortArrayBuilder.ensureCapacity$kotlinx_serialization_core(10);
        return uShortArrayBuilder;
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public final void writeContent(CompositeEncoder compositeEncoder, Object obj, int i) {
        short[] sArr = ((UShortArray) obj).storage;
        compositeEncoder.getClass();
        for (int i2 = 0; i2 < i; i2++) {
            compositeEncoder.encodeInlineElement(this.descriptor, i2).encodeShort(sArr[i2]);
        }
    }
}
