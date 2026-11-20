package com.charleskorn.kaml;

import androidx.sqlite.SQLite;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.StructureKind$MAP;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.ArrayClassDesc;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class YamlListSerializer implements KSerializer {
    public static final YamlListSerializer INSTANCE = new YamlListSerializer();
    public static final YamlListDescriptor descriptor = YamlListDescriptor.INSTANCE;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    /* JADX INFO: loaded from: classes2.dex */
    public final class YamlListDescriptor implements SerialDescriptor {
        public static final YamlListDescriptor INSTANCE = new YamlListDescriptor();
        public static final String serialName = "com.charleskorn.kaml.YamlList";
        public final /* synthetic */ ArrayClassDesc $$delegate_0;

        public YamlListDescriptor() {
            SerialDescriptor descriptor = YamlNodeSerializer.INSTANCE.getDescriptor();
            descriptor.getClass();
            this.$$delegate_0 = new ArrayClassDesc(descriptor, (byte) 1);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public final List getAnnotations() {
            return EmptyList.INSTANCE;
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public final List getElementAnnotations(int i) {
            this.$$delegate_0.getElementAnnotations(i);
            return EmptyList.INSTANCE;
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public final SerialDescriptor getElementDescriptor(int i) {
            return this.$$delegate_0.getElementDescriptor(i);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public final int getElementIndex(String str) {
            str.getClass();
            return this.$$delegate_0.getElementIndex(str);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public final String getElementName(int i) {
            return String.valueOf(i);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public final int getElementsCount() {
            return 1;
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public final Okio__OkioKt getKind() {
            return StructureKind$MAP.INSTANCE$2;
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public final String getSerialName() {
            return serialName;
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public final boolean isElementOptional(int i) {
            this.$$delegate_0.isElementOptional(i);
            return false;
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public final boolean isInline() {
            return false;
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public final boolean isNullable() {
            return false;
        }
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        throw new IllegalStateException(("This serializer can be used only with Yaml format. Expected Decoder to be " + Reflection.getOrCreateKotlinClass(YamlListInput.class).getSimpleName() + ", got " + Reflection.getOrCreateKotlinClass(decoder.getClass())).toString());
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        ((YamlList) obj).getClass();
        SQLite.asYamlOutput(encoder);
        throw null;
    }
}
