package com.metrolist.innertube.models.response;

import com.metrolist.innertube.models.Runs;
import com.metrolist.innertube.models.Runs$$serializer;
import com.metrolist.innertube.models.SubscriptionButton;
import com.metrolist.innertube.models.SubscriptionButton$$serializer;
import com.metrolist.innertube.models.ThumbnailRenderer;
import com.metrolist.innertube.models.ThumbnailRenderer$$serializer;
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
public final /* synthetic */ class BrowseResponse$Header$MusicVisualHeaderRenderer$$serializer implements GeneratedSerializer {
    public static final BrowseResponse$Header$MusicVisualHeaderRenderer$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        BrowseResponse$Header$MusicVisualHeaderRenderer$$serializer browseResponse$Header$MusicVisualHeaderRenderer$$serializer = new BrowseResponse$Header$MusicVisualHeaderRenderer$$serializer();
        INSTANCE = browseResponse$Header$MusicVisualHeaderRenderer$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.response.BrowseResponse.Header.MusicVisualHeaderRenderer", browseResponse$Header$MusicVisualHeaderRenderer$$serializer, 4);
        pluginGeneratedSerialDescriptor.addElement(LinkHeader.Parameters.Title, false);
        pluginGeneratedSerialDescriptor.addElement("foregroundThumbnail", false);
        pluginGeneratedSerialDescriptor.addElement("thumbnail", false);
        pluginGeneratedSerialDescriptor.addElement("subscriptionButton", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        ThumbnailRenderer$$serializer thumbnailRenderer$$serializer = ThumbnailRenderer$$serializer.INSTANCE;
        return new KSerializer[]{Runs$$serializer.INSTANCE, thumbnailRenderer$$serializer, HexFormatKt.getNullable(thumbnailRenderer$$serializer), HexFormatKt.getNullable(SubscriptionButton$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        Runs runs;
        SubscriptionButton subscriptionButton;
        ThumbnailRenderer thumbnailRenderer;
        ThumbnailRenderer thumbnailRenderer2;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            runs = (Runs) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, Runs$$serializer.INSTANCE, null);
            ThumbnailRenderer$$serializer thumbnailRenderer$$serializer = ThumbnailRenderer$$serializer.INSTANCE;
            ThumbnailRenderer thumbnailRenderer3 = (ThumbnailRenderer) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, thumbnailRenderer$$serializer, null);
            ThumbnailRenderer thumbnailRenderer4 = (ThumbnailRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, thumbnailRenderer$$serializer, null);
            subscriptionButton = (SubscriptionButton) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, SubscriptionButton$$serializer.INSTANCE, null);
            thumbnailRenderer = thumbnailRenderer4;
            thumbnailRenderer2 = thumbnailRenderer3;
            i = 15;
        } else {
            boolean z = true;
            int i2 = 0;
            runs = null;
            SubscriptionButton subscriptionButton2 = null;
            ThumbnailRenderer thumbnailRenderer5 = null;
            ThumbnailRenderer thumbnailRenderer6 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    runs = (Runs) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, Runs$$serializer.INSTANCE, runs);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    thumbnailRenderer6 = (ThumbnailRenderer) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, ThumbnailRenderer$$serializer.INSTANCE, thumbnailRenderer6);
                    i2 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    thumbnailRenderer5 = (ThumbnailRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, ThumbnailRenderer$$serializer.INSTANCE, thumbnailRenderer5);
                    i2 |= 4;
                } else {
                    if (iDecodeElementIndex != 3) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    subscriptionButton2 = (SubscriptionButton) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, SubscriptionButton$$serializer.INSTANCE, subscriptionButton2);
                    i2 |= 8;
                }
            }
            subscriptionButton = subscriptionButton2;
            thumbnailRenderer = thumbnailRenderer5;
            thumbnailRenderer2 = thumbnailRenderer6;
            i = i2;
        }
        Runs runs2 = runs;
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new BrowseResponse.Header.MusicVisualHeaderRenderer(i, runs2, thumbnailRenderer2, thumbnailRenderer, subscriptionButton);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        BrowseResponse.Header.MusicVisualHeaderRenderer musicVisualHeaderRenderer = (BrowseResponse.Header.MusicVisualHeaderRenderer) obj;
        musicVisualHeaderRenderer.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 0, Runs$$serializer.INSTANCE, musicVisualHeaderRenderer.title);
        ThumbnailRenderer$$serializer thumbnailRenderer$$serializer = ThumbnailRenderer$$serializer.INSTANCE;
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 1, thumbnailRenderer$$serializer, musicVisualHeaderRenderer.foregroundThumbnail);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 2, thumbnailRenderer$$serializer, musicVisualHeaderRenderer.thumbnail);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 3, SubscriptionButton$$serializer.INSTANCE, musicVisualHeaderRenderer.subscriptionButton);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
