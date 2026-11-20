package kotlinx.serialization.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractCollectionSerializer implements KSerializer {
    public Object builder() {
        return new ArrayList();
    }

    public int builderSize(Object obj) {
        PrimitiveArrayBuilder primitiveArrayBuilder = (PrimitiveArrayBuilder) obj;
        primitiveArrayBuilder.getClass();
        return primitiveArrayBuilder.getPosition$kotlinx_serialization_core();
    }

    public void checkCapacity(int i, Object obj) {
        PrimitiveArrayBuilder primitiveArrayBuilder = (PrimitiveArrayBuilder) obj;
        primitiveArrayBuilder.getClass();
        primitiveArrayBuilder.ensureCapacity$kotlinx_serialization_core(i);
    }

    public Iterator collectionIterator(Object obj) {
        Collection collection = (Collection) obj;
        collection.getClass();
        return collection.iterator();
    }

    public int collectionSize(Object obj) {
        Collection collection = (Collection) obj;
        collection.getClass();
        return collection.size();
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public Object deserialize(Decoder decoder) {
        return merge(decoder);
    }

    public final Object merge(Decoder decoder) {
        Object objBuilder = builder();
        int iBuilderSize = builderSize(objBuilder);
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(getDescriptor());
        if (!compositeDecoderBeginStructure.decodeSequentially()) {
            while (true) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(getDescriptor());
                if (iDecodeElementIndex == -1) {
                    break;
                }
                readElement(compositeDecoderBeginStructure, iDecodeElementIndex + iBuilderSize, objBuilder);
            }
        } else {
            int iDecodeCollectionSize = compositeDecoderBeginStructure.decodeCollectionSize(getDescriptor());
            checkCapacity(iDecodeCollectionSize, objBuilder);
            readAll(compositeDecoderBeginStructure, objBuilder, iBuilderSize, iDecodeCollectionSize);
        }
        compositeDecoderBeginStructure.endStructure(getDescriptor());
        return toResult(objBuilder);
    }

    public abstract void readAll(CompositeDecoder compositeDecoder, Object obj, int i, int i2);

    public abstract void readElement(CompositeDecoder compositeDecoder, int i, Object obj);

    public Object toBuilder(Object obj) {
        boolean[] zArr = (boolean[]) obj;
        zArr.getClass();
        BooleanArrayBuilder booleanArrayBuilder = new BooleanArrayBuilder();
        booleanArrayBuilder.buffer = zArr;
        booleanArrayBuilder.position = zArr.length;
        booleanArrayBuilder.ensureCapacity$kotlinx_serialization_core(10);
        return booleanArrayBuilder;
    }

    public Object toResult(Object obj) {
        PrimitiveArrayBuilder primitiveArrayBuilder = (PrimitiveArrayBuilder) obj;
        primitiveArrayBuilder.getClass();
        return primitiveArrayBuilder.build$kotlinx_serialization_core();
    }
}
