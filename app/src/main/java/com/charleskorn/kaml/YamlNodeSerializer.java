package com.charleskorn.kaml;

import androidx.room.RoomDatabase$$ExternalSyntheticLambda2;
import androidx.sqlite.SQLite;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PolymorphicKind$OPEN;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.SerialDescriptorForNullable;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class YamlNodeSerializer implements KSerializer {
    public static final YamlNodeSerializer INSTANCE = new YamlNodeSerializer();
    public static final SerialDescriptorForNullable descriptor = new SerialDescriptorForNullable(StringsKt__IndentKt.buildSerialDescriptor("com.charleskorn.kaml.YamlNode", PolymorphicKind$OPEN.INSTANCE$1, new SerialDescriptor[0], new RoomDatabase$$ExternalSyntheticLambda2((byte) 23)));

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        throw new IllegalStateException(("This serializer can be used only with Yaml format. Expected Decoder to be " + Reflection.getOrCreateKotlinClass(YamlInput.class).getSimpleName() + ", got " + Reflection.getOrCreateKotlinClass(decoder.getClass())).toString());
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        ((YamlNode) obj).getClass();
        SQLite.asYamlOutput(encoder);
        throw null;
    }
}
