package kotlinx.serialization.internal;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlinx.io.SourcesJvmKt$$ExternalSyntheticLambda0;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class ObjectSerializer implements KSerializer {
    public final Lazy descriptor$delegate = ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new SourcesJvmKt$$ExternalSyntheticLambda0(this));

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        int iDecodeElementIndex;
        SerialDescriptor descriptor = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor);
        if (!compositeDecoderBeginStructure.decodeSequentially() && (iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(getDescriptor())) != -1) {
            throw new SerializationException(IntIntPair$$ExternalSyntheticOutline0.m(iDecodeElementIndex, "Unexpected index "));
        }
        compositeDecoderBeginStructure.endStructure(descriptor);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return (SerialDescriptor) this.descriptor$delegate.getValue();
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        obj.getClass();
        encoder.beginStructure(getDescriptor()).endStructure(getDescriptor());
    }
}
