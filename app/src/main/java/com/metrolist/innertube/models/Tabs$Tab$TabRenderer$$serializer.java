package com.metrolist.innertube.models;

import io.ktor.http.LinkHeader;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlin.text.HexFormatKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Tabs$Tab$TabRenderer$$serializer implements GeneratedSerializer {
    public static final Tabs$Tab$TabRenderer$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        Tabs$Tab$TabRenderer$$serializer tabs$Tab$TabRenderer$$serializer = new Tabs$Tab$TabRenderer$$serializer();
        INSTANCE = tabs$Tab$TabRenderer$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.Tabs.Tab.TabRenderer", tabs$Tab$TabRenderer$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement(LinkHeader.Parameters.Title, false);
        pluginGeneratedSerialDescriptor.addElement("content", false);
        pluginGeneratedSerialDescriptor.addElement("endpoint", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{HexFormatKt.getNullable(StringSerializer.INSTANCE), HexFormatKt.getNullable(Tabs$Tab$TabRenderer$Content$$serializer.INSTANCE), HexFormatKt.getNullable(NavigationEndpoint$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        String str;
        NavigationEndpoint navigationEndpoint;
        Tabs.Tab.TabRenderer.Content content;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            str = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, null);
            content = (Tabs.Tab.TabRenderer.Content) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, Tabs$Tab$TabRenderer$Content$$serializer.INSTANCE, null);
            navigationEndpoint = (NavigationEndpoint) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, NavigationEndpoint$$serializer.INSTANCE, null);
            i = 7;
        } else {
            boolean z = true;
            int i2 = 0;
            str = null;
            NavigationEndpoint navigationEndpoint2 = null;
            Tabs.Tab.TabRenderer.Content content2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    str = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    content2 = (Tabs.Tab.TabRenderer.Content) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, Tabs$Tab$TabRenderer$Content$$serializer.INSTANCE, content2);
                    i2 |= 2;
                } else {
                    if (iDecodeElementIndex != 2) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    navigationEndpoint2 = (NavigationEndpoint) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, NavigationEndpoint$$serializer.INSTANCE, navigationEndpoint2);
                    i2 |= 4;
                }
            }
            navigationEndpoint = navigationEndpoint2;
            content = content2;
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new Tabs.Tab.TabRenderer(i, str, content, navigationEndpoint);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        Tabs.Tab.TabRenderer tabRenderer = (Tabs.Tab.TabRenderer) obj;
        tabRenderer.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, tabRenderer.title);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, Tabs$Tab$TabRenderer$Content$$serializer.INSTANCE, tabRenderer.content);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 2, NavigationEndpoint$$serializer.INSTANCE, tabRenderer.endpoint);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
