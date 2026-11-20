package com.charleskorn.kaml;

import androidx.sqlite.SQLite;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.PrimitiveSerialDescriptor;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class YamlScalarSerializer implements KSerializer {
    public static final YamlScalarSerializer INSTANCE = new YamlScalarSerializer();
    public static final PrimitiveSerialDescriptor descriptor = StringsKt__IndentKt.PrimitiveSerialDescriptor("com.charleskorn.kaml.YamlScalar");

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        throw new IllegalStateException(("This serializer can be used only with Yaml format. Expected Decoder to be " + Reflection.getOrCreateKotlinClass(YamlScalarInput.class).getSimpleName() + ", got " + Reflection.getOrCreateKotlinClass(decoder.getClass())).toString());
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        ((YamlScalar) obj).getClass();
        SQLite.asYamlOutput(encoder);
        throw null;
    }
}
