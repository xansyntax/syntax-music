package io.ktor.openapi;

import androidx.navigation.NavGraphNavigator$$ExternalSyntheticLambda0;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonEncoder;
import kotlinx.serialization.json.internal.JsonTreeEncoder;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\u000b\u001a\u0004\u0018\u00010\n\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00028\u00002\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lio/ktor/openapi/JsonElementSerialAdapter;", "Lio/ktor/openapi/GenericElementSerialAdapter;", "<init>", "()V", "T", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "Lkotlinx/serialization/KSerializer;", "serializer", "Lio/ktor/openapi/GenericElement;", "trySerializeToElement", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;Lkotlinx/serialization/KSerializer;)Lio/ktor/openapi/GenericElement;", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "tryDeserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lio/ktor/openapi/GenericElement;", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class JsonElementSerialAdapter implements GenericElementSerialAdapter {
    public static final JsonElementSerialAdapter INSTANCE = new JsonElementSerialAdapter();

    private JsonElementSerialAdapter() {
    }

    @Override // io.ktor.openapi.GenericElementSerialAdapter
    public GenericElement tryDeserialize(Decoder decoder) {
        decoder.getClass();
        if (!(decoder instanceof JsonDecoder)) {
            return null;
        }
        KSerializer kSerializerSerializer = JsonElement.INSTANCE.serializer();
        return new JsonGenericElement((JsonElement) decoder.decodeSerializableValue(kSerializerSerializer), ((JsonDecoder) decoder).getJson(), kSerializerSerializer);
    }

    @Override // io.ktor.openapi.GenericElementSerialAdapter
    public <T> GenericElement trySerializeToElement(Encoder encoder, T value, KSerializer serializer) {
        encoder.getClass();
        serializer.getClass();
        if (!(encoder instanceof JsonEncoder)) {
            return null;
        }
        JsonEncoder jsonEncoder = (JsonEncoder) encoder;
        Json json = jsonEncoder.getJson();
        json.getClass();
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        new JsonTreeEncoder(json, (Function1) new NavGraphNavigator$$ExternalSyntheticLambda0(ref$ObjectRef, (byte) 7), (byte) 0).encodeSerializableValue(serializer, value);
        Object obj = ref$ObjectRef.element;
        if (obj != null) {
            return new JsonGenericElement((JsonElement) obj, jsonEncoder.getJson(), JsonElement.INSTANCE.serializer());
        }
        Intrinsics.throwUninitializedPropertyAccessException("result");
        throw null;
    }
}
