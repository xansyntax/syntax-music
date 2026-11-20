package io.ktor.openapi;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import io.ktor.http.ContentType;
import kotlin.Metadata;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0096\u0080\u0004¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0096\u0080\u0004¢\u0006\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u00020\u000f8\u0016X\u0096\u0084\b¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lio/ktor/openapi/ContentTypeSerializer;", "Lkotlinx/serialization/KSerializer;", "Lio/ktor/http/ContentType;", "<init>", "()V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lio/ktor/http/ContentType;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lio/ktor/http/ContentType;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ContentTypeSerializer implements KSerializer {
    public static final ContentTypeSerializer INSTANCE = new ContentTypeSerializer();
    private static final SerialDescriptor descriptor = StringsKt__IndentKt.PrimitiveSerialDescriptor("ContentType");

    private ContentTypeSerializer() {
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public ContentType deserialize(Decoder decoder) {
        decoder.getClass();
        String strDecodeString = decoder.decodeString();
        try {
            return ContentType.INSTANCE.parse(strDecodeString);
        } catch (Throwable th) {
            throw new SerializationException(Fragment$5$$ExternalSyntheticOutline0.m("Invalid ContentType: ", strDecodeString), th);
        }
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, ContentType value) {
        encoder.getClass();
        value.getClass();
        encoder.encodeString(value.toString());
    }
}
