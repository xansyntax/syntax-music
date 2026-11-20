package kotlinx.serialization.internal;

import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class ByteArraySerializer extends PrimitiveArraySerializer {
    public static final ByteArraySerializer INSTANCE = new ByteArraySerializer(ByteSerializer.INSTANCE);

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final int collectionSize(Object obj) {
        byte[] bArr = (byte[]) obj;
        bArr.getClass();
        return bArr.length;
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public final Object empty() {
        return new byte[0];
    }

    @Override // kotlinx.serialization.internal.CollectionLikeSerializer, kotlinx.serialization.internal.AbstractCollectionSerializer
    public final void readElement(CompositeDecoder compositeDecoder, int i, Object obj) {
        ByteArrayBuilder byteArrayBuilder = (ByteArrayBuilder) obj;
        byteArrayBuilder.getClass();
        byte bDecodeByteElement = compositeDecoder.decodeByteElement(this.descriptor, i);
        byteArrayBuilder.ensureCapacity$kotlinx_serialization_core(byteArrayBuilder.getPosition$kotlinx_serialization_core() + 1);
        byte[] bArr = byteArrayBuilder.buffer;
        int i2 = byteArrayBuilder.position;
        byteArrayBuilder.position = i2 + 1;
        bArr[i2] = bDecodeByteElement;
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final Object toBuilder(Object obj) {
        byte[] bArr = (byte[]) obj;
        bArr.getClass();
        ByteArrayBuilder byteArrayBuilder = new ByteArrayBuilder();
        byteArrayBuilder.buffer = bArr;
        byteArrayBuilder.position = bArr.length;
        byteArrayBuilder.ensureCapacity$kotlinx_serialization_core(10);
        return byteArrayBuilder;
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public final void writeContent(CompositeEncoder compositeEncoder, Object obj, int i) {
        byte[] bArr = (byte[]) obj;
        compositeEncoder.getClass();
        bArr.getClass();
        for (int i2 = 0; i2 < i; i2++) {
            compositeEncoder.encodeByteElement(this.descriptor, i2, bArr[i2]);
        }
    }
}
