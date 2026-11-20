package io.ktor.openapi;

import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J5\u0010\t\u001a\u0004\u0018\u00010\b\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00028\u00002\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lio/ktor/openapi/GenericElementSerialAdapter;", "", "T", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "Lkotlinx/serialization/KSerializer;", "serializer", "Lio/ktor/openapi/GenericElement;", "trySerializeToElement", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;Lkotlinx/serialization/KSerializer;)Lio/ktor/openapi/GenericElement;", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "tryDeserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lio/ktor/openapi/GenericElement;", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface GenericElementSerialAdapter {
    GenericElement tryDeserialize(Decoder decoder);

    <T> GenericElement trySerializeToElement(Encoder encoder, T value, KSerializer serializer);
}
