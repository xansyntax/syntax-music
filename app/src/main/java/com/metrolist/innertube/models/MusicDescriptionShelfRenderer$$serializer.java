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
public final /* synthetic */ class MusicDescriptionShelfRenderer$$serializer implements GeneratedSerializer {
    public static final MusicDescriptionShelfRenderer$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        MusicDescriptionShelfRenderer$$serializer musicDescriptionShelfRenderer$$serializer = new MusicDescriptionShelfRenderer$$serializer();
        INSTANCE = musicDescriptionShelfRenderer$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.MusicDescriptionShelfRenderer", musicDescriptionShelfRenderer$$serializer, 4);
        pluginGeneratedSerialDescriptor.addElement("header", false);
        pluginGeneratedSerialDescriptor.addElement("subheader", false);
        pluginGeneratedSerialDescriptor.addElement("description", false);
        pluginGeneratedSerialDescriptor.addElement("footer", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        Runs$$serializer runs$$serializer = Runs$$serializer.INSTANCE;
        return new KSerializer[]{HexFormatKt.getNullable(runs$$serializer), HexFormatKt.getNullable(runs$$serializer), HexFormatKt.getNullable(runs$$serializer), HexFormatKt.getNullable(runs$$serializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        Runs runs;
        int i;
        Runs runs2;
        Runs runs3;
        Runs runs4;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            Runs$$serializer runs$$serializer = Runs$$serializer.INSTANCE;
            Runs runs5 = (Runs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, runs$$serializer, null);
            Runs runs6 = (Runs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, runs$$serializer, null);
            Runs runs7 = (Runs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, runs$$serializer, null);
            runs = (Runs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, runs$$serializer, null);
            i = 15;
            runs2 = runs7;
            runs3 = runs6;
            runs4 = runs5;
        } else {
            boolean z = true;
            int i2 = 0;
            runs = null;
            Runs runs8 = null;
            Runs runs9 = null;
            Runs runs10 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    runs10 = (Runs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, Runs$$serializer.INSTANCE, runs10);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    runs9 = (Runs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, Runs$$serializer.INSTANCE, runs9);
                    i2 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    runs8 = (Runs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, Runs$$serializer.INSTANCE, runs8);
                    i2 |= 4;
                } else {
                    if (iDecodeElementIndex != 3) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    runs = (Runs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, Runs$$serializer.INSTANCE, runs);
                    i2 |= 8;
                }
            }
            i = i2;
            runs2 = runs8;
            runs3 = runs9;
            runs4 = runs10;
        }
        Runs runs11 = runs;
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new MusicDescriptionShelfRenderer(i, runs4, runs3, runs2, runs11);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        MusicDescriptionShelfRenderer musicDescriptionShelfRenderer = (MusicDescriptionShelfRenderer) obj;
        musicDescriptionShelfRenderer.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        Runs$$serializer runs$$serializer = Runs$$serializer.INSTANCE;
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, runs$$serializer, musicDescriptionShelfRenderer.header);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, runs$$serializer, musicDescriptionShelfRenderer.subheader);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 2, runs$$serializer, musicDescriptionShelfRenderer.description);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 3, runs$$serializer, musicDescriptionShelfRenderer.footer);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
