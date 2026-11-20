package com.metrolist.innertube.models;

import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
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
public final /* synthetic */ class GridRenderer$Header$$serializer implements GeneratedSerializer {
    public static final GridRenderer$Header$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        GridRenderer$Header$$serializer gridRenderer$Header$$serializer = new GridRenderer$Header$$serializer();
        INSTANCE = gridRenderer$Header$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.GridRenderer.Header", gridRenderer$Header$$serializer, 1);
        pluginGeneratedSerialDescriptor.addElement("gridHeaderRenderer", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{GridRenderer$Header$GridHeaderRenderer$$serializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        GridRenderer.Header.GridHeaderRenderer gridHeaderRenderer;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        int i = 1;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            gridHeaderRenderer = (GridRenderer.Header.GridHeaderRenderer) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, GridRenderer$Header$GridHeaderRenderer$$serializer.INSTANCE, null);
        } else {
            boolean z = true;
            int i2 = 0;
            gridHeaderRenderer = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else {
                    if (iDecodeElementIndex != 0) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    gridHeaderRenderer = (GridRenderer.Header.GridHeaderRenderer) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, GridRenderer$Header$GridHeaderRenderer$$serializer.INSTANCE, gridHeaderRenderer);
                    i2 = 1;
                }
            }
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new GridRenderer.Header(i, gridHeaderRenderer);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        GridRenderer.Header header = (GridRenderer.Header) obj;
        header.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 0, GridRenderer$Header$GridHeaderRenderer$$serializer.INSTANCE, header.gridHeaderRenderer);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
