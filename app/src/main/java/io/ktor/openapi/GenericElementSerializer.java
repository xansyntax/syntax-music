package io.ktor.openapi;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind$CONTEXTUAL;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0096\u0080\u0004¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0096\u0080\u0004¢\u0006\u0004\b\r\u0010\u000eR!\u0010\u0010\u001a\u00020\u000f8\u0016X\u0096\u0084\b¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u0012\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lio/ktor/openapi/GenericElementSerializer;", "Lkotlinx/serialization/KSerializer;", "Lio/ktor/openapi/GenericElement;", "<init>", "()V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lio/ktor/openapi/GenericElement;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lio/ktor/openapi/GenericElement;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor$annotations", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GenericElementSerializer implements KSerializer {
    private final SerialDescriptor descriptor = StringsKt__IndentKt.buildSerialDescriptor$default("io.ktor.openapi.GenericElement", SerialKind$CONTEXTUAL.INSTANCE, new SerialDescriptor[0]);

    @Override // kotlinx.serialization.DeserializationStrategy
    public GenericElement deserialize(Decoder decoder) {
        GenericElement genericElementTryDeserialize;
        decoder.getClass();
        Iterator<T> it = GenericElement_jvmKt.getGenericElementSerialAdapters().iterator();
        do {
            if (!it.hasNext()) {
                genericElementTryDeserialize = null;
                break;
            }
            genericElementTryDeserialize = ((GenericElementSerialAdapter) it.next()).tryDeserialize(decoder);
        } while (genericElementTryDeserialize == null);
        if (genericElementTryDeserialize != null) {
            return genericElementTryDeserialize;
        }
        GenericElementKt.serialError("No generic element adapter for " + Reflection.getOrCreateKotlinClass(decoder.getClass()).getSimpleName());
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
        return null;
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, GenericElement value) {
        encoder.getClass();
        value.getClass();
        KSerializer elementSerializer = value.getElementSerializer();
        elementSerializer.getClass();
        encoder.encodeSerializableValue(elementSerializer, value.getElement());
    }

    public static /* synthetic */ void getDescriptor$annotations() {
    }
}
