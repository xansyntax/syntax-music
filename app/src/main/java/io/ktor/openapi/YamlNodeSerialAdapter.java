package io.ktor.openapi;

import com.charleskorn.kaml.YamlList;
import com.charleskorn.kaml.YamlMap;
import com.charleskorn.kaml.YamlNode;
import com.charleskorn.kaml.YamlScalar;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\u000b\u001a\u0004\u0018\u00010\n\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00028\u00002\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0012\u001a\u00020\n*\u00020\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lio/ktor/openapi/YamlNodeSerialAdapter;", "Lio/ktor/openapi/GenericElementSerialAdapter;", "<init>", "()V", "T", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "Lkotlinx/serialization/KSerializer;", "serializer", "Lio/ktor/openapi/GenericElement;", "trySerializeToElement", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;Lkotlinx/serialization/KSerializer;)Lio/ktor/openapi/GenericElement;", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "tryDeserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lio/ktor/openapi/GenericElement;", "Lcom/charleskorn/kaml/YamlNode;", "toGenericElement", "(Lcom/charleskorn/kaml/YamlNode;)Lio/ktor/openapi/GenericElement;", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class YamlNodeSerialAdapter implements GenericElementSerialAdapter {
    public static final YamlNodeSerialAdapter INSTANCE = new YamlNodeSerialAdapter();

    private YamlNodeSerialAdapter() {
    }

    private final GenericElement toGenericElement(YamlNode yamlNode) {
        if (yamlNode instanceof YamlMap) {
            throw null;
        }
        if (!(yamlNode instanceof YamlList)) {
            return yamlNode instanceof YamlScalar ? new GenericElementString(null, null, 2, null) : GenericElement.INSTANCE.getEmptyObject();
        }
        CollectionsKt__IterablesKt.collectionSizeOrDefault(null, 10);
        throw null;
    }

    @Override // io.ktor.openapi.GenericElementSerialAdapter
    public GenericElement tryDeserialize(Decoder decoder) {
        decoder.getClass();
        String simpleName = Reflection.getOrCreateKotlinClass(decoder.getClass()).getSimpleName();
        if (simpleName == null || !StringsKt__StringsJVMKt.startsWith(simpleName, "Yaml", false)) {
            return null;
        }
        return toGenericElement((YamlNode) decoder.decodeSerializableValue(YamlNode.INSTANCE.serializer()));
    }

    @Override // io.ktor.openapi.GenericElementSerialAdapter
    public <T> GenericElement trySerializeToElement(Encoder encoder, T value, KSerializer serializer) {
        encoder.getClass();
        serializer.getClass();
        String simpleName = Reflection.getOrCreateKotlinClass(encoder.getClass()).getSimpleName();
        if (simpleName == null || !StringsKt__StringsJVMKt.startsWith(simpleName, "Yaml", false) || value == null) {
            return null;
        }
        return new GenericElementWrapper(value, serializer);
    }
}
