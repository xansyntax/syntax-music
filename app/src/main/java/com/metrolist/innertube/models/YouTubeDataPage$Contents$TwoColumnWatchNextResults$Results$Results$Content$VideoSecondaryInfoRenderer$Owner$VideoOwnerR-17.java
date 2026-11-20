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
public final /* synthetic */ class YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$Owner$VideoOwnerRenderer$$serializer implements GeneratedSerializer {
    public static final YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$Owner$VideoOwnerRenderer$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$Owner$VideoOwnerRenderer$$serializer youTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$Owner$VideoOwnerRenderer$$serializer = new YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$Owner$VideoOwnerRenderer$$serializer();
        INSTANCE = youTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$Owner$VideoOwnerRenderer$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.YouTubeDataPage.Contents.TwoColumnWatchNextResults.Results.Results.Content.VideoSecondaryInfoRenderer.Owner.VideoOwnerRenderer", youTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$Owner$VideoOwnerRenderer$$serializer, 4);
        pluginGeneratedSerialDescriptor.addElement("thumbnail", true);
        pluginGeneratedSerialDescriptor.addElement("subscriberCountText", true);
        pluginGeneratedSerialDescriptor.addElement(LinkHeader.Parameters.Title, true);
        pluginGeneratedSerialDescriptor.addElement("navigationEndpoint", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{HexFormatKt.getNullable(YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$Owner$VideoOwnerRenderer$Thumbnail$$serializer.INSTANCE), HexFormatKt.getNullable(YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$Owner$VideoOwnerRenderer$SubscriberCountText$$serializer.INSTANCE), HexFormatKt.getNullable(YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$Owner$VideoOwnerRenderer$Title$$serializer.INSTANCE), HexFormatKt.getNullable(NavigationEndpoint$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoSecondaryInfoRenderer.Owner.VideoOwnerRenderer.Thumbnail thumbnail;
        NavigationEndpoint navigationEndpoint;
        YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoSecondaryInfoRenderer.Owner.VideoOwnerRenderer.Title title;
        YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoSecondaryInfoRenderer.Owner.VideoOwnerRenderer.SubscriberCountText subscriberCountText;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            thumbnail = (YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoSecondaryInfoRenderer.Owner.VideoOwnerRenderer.Thumbnail) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$Owner$VideoOwnerRenderer$Thumbnail$$serializer.INSTANCE, null);
            YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoSecondaryInfoRenderer.Owner.VideoOwnerRenderer.SubscriberCountText subscriberCountText2 = (YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoSecondaryInfoRenderer.Owner.VideoOwnerRenderer.SubscriberCountText) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$Owner$VideoOwnerRenderer$SubscriberCountText$$serializer.INSTANCE, null);
            YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoSecondaryInfoRenderer.Owner.VideoOwnerRenderer.Title title2 = (YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoSecondaryInfoRenderer.Owner.VideoOwnerRenderer.Title) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$Owner$VideoOwnerRenderer$Title$$serializer.INSTANCE, null);
            navigationEndpoint = (NavigationEndpoint) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, NavigationEndpoint$$serializer.INSTANCE, null);
            title = title2;
            subscriberCountText = subscriberCountText2;
            i = 15;
        } else {
            boolean z = true;
            int i2 = 0;
            thumbnail = null;
            NavigationEndpoint navigationEndpoint2 = null;
            YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoSecondaryInfoRenderer.Owner.VideoOwnerRenderer.Title title3 = null;
            YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoSecondaryInfoRenderer.Owner.VideoOwnerRenderer.SubscriberCountText subscriberCountText3 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    thumbnail = (YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoSecondaryInfoRenderer.Owner.VideoOwnerRenderer.Thumbnail) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$Owner$VideoOwnerRenderer$Thumbnail$$serializer.INSTANCE, thumbnail);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    subscriberCountText3 = (YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoSecondaryInfoRenderer.Owner.VideoOwnerRenderer.SubscriberCountText) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$Owner$VideoOwnerRenderer$SubscriberCountText$$serializer.INSTANCE, subscriberCountText3);
                    i2 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    title3 = (YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoSecondaryInfoRenderer.Owner.VideoOwnerRenderer.Title) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$Owner$VideoOwnerRenderer$Title$$serializer.INSTANCE, title3);
                    i2 |= 4;
                } else {
                    if (iDecodeElementIndex != 3) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    navigationEndpoint2 = (NavigationEndpoint) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, NavigationEndpoint$$serializer.INSTANCE, navigationEndpoint2);
                    i2 |= 8;
                }
            }
            navigationEndpoint = navigationEndpoint2;
            title = title3;
            subscriberCountText = subscriberCountText3;
            i = i2;
        }
        YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoSecondaryInfoRenderer.Owner.VideoOwnerRenderer.Thumbnail thumbnail2 = thumbnail;
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoSecondaryInfoRenderer.Owner.VideoOwnerRenderer(i, thumbnail2, subscriberCountText, title, navigationEndpoint);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoSecondaryInfoRenderer.Owner.VideoOwnerRenderer videoOwnerRenderer = (YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoSecondaryInfoRenderer.Owner.VideoOwnerRenderer) obj;
        videoOwnerRenderer.getClass();
        NavigationEndpoint navigationEndpoint = videoOwnerRenderer.navigationEndpoint;
        YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoSecondaryInfoRenderer.Owner.VideoOwnerRenderer.Title title = videoOwnerRenderer.title;
        YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoSecondaryInfoRenderer.Owner.VideoOwnerRenderer.SubscriberCountText subscriberCountText = videoOwnerRenderer.subscriberCountText;
        YouTubeDataPage$Contents$TwoColumnWatchNextResults.Results.C0002Results.Content.VideoSecondaryInfoRenderer.Owner.VideoOwnerRenderer.Thumbnail thumbnail = videoOwnerRenderer.thumbnail;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 0) || thumbnail != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$Owner$VideoOwnerRenderer$Thumbnail$$serializer.INSTANCE, thumbnail);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 1) || subscriberCountText != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$Owner$VideoOwnerRenderer$SubscriberCountText$$serializer.INSTANCE, subscriberCountText);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 2) || title != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 2, YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$Owner$VideoOwnerRenderer$Title$$serializer.INSTANCE, title);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 3) || navigationEndpoint != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 3, NavigationEndpoint$$serializer.INSTANCE, navigationEndpoint);
        }
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
