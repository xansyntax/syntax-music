package com.metrolist.innertube.models;

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

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Tabs$Tab$TabRenderer$Content$$serializer implements GeneratedSerializer {
    public static final Tabs$Tab$TabRenderer$Content$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        Tabs$Tab$TabRenderer$Content$$serializer tabs$Tab$TabRenderer$Content$$serializer = new Tabs$Tab$TabRenderer$Content$$serializer();
        INSTANCE = tabs$Tab$TabRenderer$Content$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.Tabs.Tab.TabRenderer.Content", tabs$Tab$TabRenderer$Content$$serializer, 2);
        pluginGeneratedSerialDescriptor.addElement("sectionListRenderer", false);
        pluginGeneratedSerialDescriptor.addElement("musicQueueRenderer", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{HexFormatKt.getNullable(SectionListRenderer$$serializer.INSTANCE), HexFormatKt.getNullable(MusicQueueRenderer$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        SectionListRenderer sectionListRenderer;
        MusicQueueRenderer musicQueueRenderer;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            sectionListRenderer = (SectionListRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, SectionListRenderer$$serializer.INSTANCE, null);
            musicQueueRenderer = (MusicQueueRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, MusicQueueRenderer$$serializer.INSTANCE, null);
            i = 3;
        } else {
            boolean z = true;
            int i2 = 0;
            sectionListRenderer = null;
            MusicQueueRenderer musicQueueRenderer2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    sectionListRenderer = (SectionListRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, SectionListRenderer$$serializer.INSTANCE, sectionListRenderer);
                    i2 |= 1;
                } else {
                    if (iDecodeElementIndex != 1) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    musicQueueRenderer2 = (MusicQueueRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, MusicQueueRenderer$$serializer.INSTANCE, musicQueueRenderer2);
                    i2 |= 2;
                }
            }
            musicQueueRenderer = musicQueueRenderer2;
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new Tabs.Tab.TabRenderer.Content(i, sectionListRenderer, musicQueueRenderer);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        Tabs.Tab.TabRenderer.Content content = (Tabs.Tab.TabRenderer.Content) obj;
        content.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, SectionListRenderer$$serializer.INSTANCE, content.sectionListRenderer);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, MusicQueueRenderer$$serializer.INSTANCE, content.musicQueueRenderer);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
