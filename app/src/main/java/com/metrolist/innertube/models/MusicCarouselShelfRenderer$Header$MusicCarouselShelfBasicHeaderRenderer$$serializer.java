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

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MusicCarouselShelfRenderer$Header$MusicCarouselShelfBasicHeaderRenderer$$serializer implements GeneratedSerializer {
    public static final MusicCarouselShelfRenderer$Header$MusicCarouselShelfBasicHeaderRenderer$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        MusicCarouselShelfRenderer$Header$MusicCarouselShelfBasicHeaderRenderer$$serializer musicCarouselShelfRenderer$Header$MusicCarouselShelfBasicHeaderRenderer$$serializer = new MusicCarouselShelfRenderer$Header$MusicCarouselShelfBasicHeaderRenderer$$serializer();
        INSTANCE = musicCarouselShelfRenderer$Header$MusicCarouselShelfBasicHeaderRenderer$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.MusicCarouselShelfRenderer.Header.MusicCarouselShelfBasicHeaderRenderer", musicCarouselShelfRenderer$Header$MusicCarouselShelfBasicHeaderRenderer$$serializer, 4);
        pluginGeneratedSerialDescriptor.addElement("strapline", false);
        pluginGeneratedSerialDescriptor.addElement(LinkHeader.Parameters.Title, false);
        pluginGeneratedSerialDescriptor.addElement("thumbnail", false);
        pluginGeneratedSerialDescriptor.addElement("moreContentButton", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        Runs$$serializer runs$$serializer = Runs$$serializer.INSTANCE;
        return new KSerializer[]{HexFormatKt.getNullable(runs$$serializer), runs$$serializer, HexFormatKt.getNullable(ThumbnailRenderer$$serializer.INSTANCE), HexFormatKt.getNullable(Button$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        Runs runs;
        Button button;
        ThumbnailRenderer thumbnailRenderer;
        int i;
        Runs runs2;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            Runs$$serializer runs$$serializer = Runs$$serializer.INSTANCE;
            Runs runs3 = (Runs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, runs$$serializer, null);
            runs = (Runs) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, runs$$serializer, null);
            ThumbnailRenderer thumbnailRenderer2 = (ThumbnailRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, ThumbnailRenderer$$serializer.INSTANCE, null);
            button = (Button) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, Button$$serializer.INSTANCE, null);
            thumbnailRenderer = thumbnailRenderer2;
            i = 15;
            runs2 = runs3;
        } else {
            boolean z = true;
            int i2 = 0;
            runs = null;
            Button button2 = null;
            ThumbnailRenderer thumbnailRenderer3 = null;
            Runs runs4 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    runs4 = (Runs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, Runs$$serializer.INSTANCE, runs4);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    runs = (Runs) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, Runs$$serializer.INSTANCE, runs);
                    i2 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    thumbnailRenderer3 = (ThumbnailRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, ThumbnailRenderer$$serializer.INSTANCE, thumbnailRenderer3);
                    i2 |= 4;
                } else {
                    if (iDecodeElementIndex != 3) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    button2 = (Button) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, Button$$serializer.INSTANCE, button2);
                    i2 |= 8;
                }
            }
            button = button2;
            thumbnailRenderer = thumbnailRenderer3;
            i = i2;
            runs2 = runs4;
        }
        Runs runs5 = runs;
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new MusicCarouselShelfRenderer.Header.MusicCarouselShelfBasicHeaderRenderer(i, runs2, runs5, thumbnailRenderer, button);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        MusicCarouselShelfRenderer.Header.MusicCarouselShelfBasicHeaderRenderer musicCarouselShelfBasicHeaderRenderer = (MusicCarouselShelfRenderer.Header.MusicCarouselShelfBasicHeaderRenderer) obj;
        musicCarouselShelfBasicHeaderRenderer.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        Runs$$serializer runs$$serializer = Runs$$serializer.INSTANCE;
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, runs$$serializer, musicCarouselShelfBasicHeaderRenderer.strapline);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 1, runs$$serializer, musicCarouselShelfBasicHeaderRenderer.title);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 2, ThumbnailRenderer$$serializer.INSTANCE, musicCarouselShelfBasicHeaderRenderer.thumbnail);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 3, Button$$serializer.INSTANCE, musicCarouselShelfBasicHeaderRenderer.moreContentButton);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
