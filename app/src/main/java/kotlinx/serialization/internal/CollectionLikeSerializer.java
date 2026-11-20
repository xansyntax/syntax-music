package kotlinx.serialization.internal;

import java.util.Iterator;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class CollectionLikeSerializer extends AbstractCollectionSerializer {
    public final KSerializer elementSerializer;

    public CollectionLikeSerializer(KSerializer kSerializer) {
        this.elementSerializer = kSerializer;
    }

    public void insert(int i, Object obj, Object obj2) {
        ((PrimitiveArrayBuilder) obj).getClass();
        throw new IllegalStateException("This method lead to boxing and must not be used, use Builder.append instead");
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final void readAll(CompositeDecoder compositeDecoder, Object obj, int i, int i2) {
        if (i2 < 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Size must be known in advance when using READ_ALL");
            return;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            readElement(compositeDecoder, i + i3, obj);
        }
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public void readElement(CompositeDecoder compositeDecoder, int i, Object obj) {
        insert(i, obj, compositeDecoder.decodeSerializableElement(getDescriptor(), i, this.elementSerializer, null));
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, Object obj) {
        int iCollectionSize = collectionSize(obj);
        SerialDescriptor descriptor = getDescriptor();
        CompositeEncoder compositeEncoderBeginCollection = encoder.beginCollection(descriptor, iCollectionSize);
        Iterator itCollectionIterator = collectionIterator(obj);
        for (int i = 0; i < iCollectionSize; i++) {
            compositeEncoderBeginCollection.encodeSerializableElement(getDescriptor(), i, this.elementSerializer, itCollectionIterator.next());
        }
        compositeEncoderBeginCollection.endStructure(descriptor);
    }
}
