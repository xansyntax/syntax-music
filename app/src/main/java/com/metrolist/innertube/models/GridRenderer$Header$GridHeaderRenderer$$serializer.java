package com.metrolist.innertube.models;

import io.ktor.http.LinkHeader;
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
public final /* synthetic */ class GridRenderer$Header$GridHeaderRenderer$$serializer implements GeneratedSerializer {
    public static final GridRenderer$Header$GridHeaderRenderer$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        GridRenderer$Header$GridHeaderRenderer$$serializer gridRenderer$Header$GridHeaderRenderer$$serializer = new GridRenderer$Header$GridHeaderRenderer$$serializer();
        INSTANCE = gridRenderer$Header$GridHeaderRenderer$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.GridRenderer.Header.GridHeaderRenderer", gridRenderer$Header$GridHeaderRenderer$$serializer, 1);
        pluginGeneratedSerialDescriptor.addElement(LinkHeader.Parameters.Title, false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{Runs$$serializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        Runs runs;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        int i = 1;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            runs = (Runs) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, Runs$$serializer.INSTANCE, null);
        } else {
            boolean z = true;
            int i2 = 0;
            runs = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else {
                    if (iDecodeElementIndex != 0) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    runs = (Runs) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, Runs$$serializer.INSTANCE, runs);
                    i2 = 1;
                }
            }
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new GridRenderer.Header.GridHeaderRenderer(i, runs);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        GridRenderer.Header.GridHeaderRenderer gridHeaderRenderer = (GridRenderer.Header.GridHeaderRenderer) obj;
        gridHeaderRenderer.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 0, Runs$$serializer.INSTANCE, gridHeaderRenderer.title);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
