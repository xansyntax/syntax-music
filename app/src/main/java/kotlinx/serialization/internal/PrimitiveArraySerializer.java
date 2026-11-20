package kotlinx.serialization.internal;

import java.util.Iterator;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class PrimitiveArraySerializer extends CollectionLikeSerializer {
    public final PrimitiveArrayDescriptor descriptor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrimitiveArraySerializer(KSerializer kSerializer) {
        super(kSerializer);
        kSerializer.getClass();
        this.descriptor = new PrimitiveArrayDescriptor(kSerializer.getDescriptor());
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final Object builder() {
        return (PrimitiveArrayBuilder) toBuilder(empty());
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final Iterator collectionIterator(Object obj) {
        throw new IllegalStateException("This method lead to boxing and must not be used, use writeContents instead");
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer, kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        return merge(decoder);
    }

    public Object empty() {
        return new boolean[0];
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    @Override // kotlinx.serialization.internal.CollectionLikeSerializer, kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        int iCollectionSize = collectionSize(obj);
        PrimitiveArrayDescriptor primitiveArrayDescriptor = this.descriptor;
        CompositeEncoder compositeEncoderBeginCollection = encoder.beginCollection(primitiveArrayDescriptor, iCollectionSize);
        writeContent(compositeEncoderBeginCollection, obj, iCollectionSize);
        compositeEncoderBeginCollection.endStructure(primitiveArrayDescriptor);
    }

    public void writeContent(CompositeEncoder compositeEncoder, Object obj, int i) {
        boolean[] zArr = (boolean[]) obj;
        compositeEncoder.getClass();
        zArr.getClass();
        for (int i2 = 0; i2 < i; i2++) {
            compositeEncoder.encodeBooleanElement(this.descriptor, i2, zArr[i2]);
        }
    }
}
