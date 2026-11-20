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
public final /* synthetic */ class MusicQueueRenderer$$serializer implements GeneratedSerializer {
    public static final MusicQueueRenderer$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        MusicQueueRenderer$$serializer musicQueueRenderer$$serializer = new MusicQueueRenderer$$serializer();
        INSTANCE = musicQueueRenderer$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.MusicQueueRenderer", musicQueueRenderer$$serializer, 2);
        pluginGeneratedSerialDescriptor.addElement("content", false);
        pluginGeneratedSerialDescriptor.addElement("header", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{HexFormatKt.getNullable(MusicQueueRenderer$Content$$serializer.INSTANCE), HexFormatKt.getNullable(MusicQueueRenderer$Header$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        MusicQueueRenderer.Content content;
        MusicQueueRenderer.Header header;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            content = (MusicQueueRenderer.Content) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, MusicQueueRenderer$Content$$serializer.INSTANCE, null);
            header = (MusicQueueRenderer.Header) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, MusicQueueRenderer$Header$$serializer.INSTANCE, null);
            i = 3;
        } else {
            boolean z = true;
            int i2 = 0;
            content = null;
            MusicQueueRenderer.Header header2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    content = (MusicQueueRenderer.Content) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, MusicQueueRenderer$Content$$serializer.INSTANCE, content);
                    i2 |= 1;
                } else {
                    if (iDecodeElementIndex != 1) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    header2 = (MusicQueueRenderer.Header) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, MusicQueueRenderer$Header$$serializer.INSTANCE, header2);
                    i2 |= 2;
                }
            }
            header = header2;
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new MusicQueueRenderer(i, content, header);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        MusicQueueRenderer musicQueueRenderer = (MusicQueueRenderer) obj;
        musicQueueRenderer.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, MusicQueueRenderer$Content$$serializer.INSTANCE, musicQueueRenderer.content);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, MusicQueueRenderer$Header$$serializer.INSTANCE, musicQueueRenderer.header);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
