package com.metrolist.innertube.models.response;

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
public final /* synthetic */ class BrowseResponse$Header$MusicImmersiveHeaderRenderer$SubscriptionButton2$$serializer implements GeneratedSerializer {
    public static final BrowseResponse$Header$MusicImmersiveHeaderRenderer$SubscriptionButton2$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        BrowseResponse$Header$MusicImmersiveHeaderRenderer$SubscriptionButton2$$serializer browseResponse$Header$MusicImmersiveHeaderRenderer$SubscriptionButton2$$serializer = new BrowseResponse$Header$MusicImmersiveHeaderRenderer$SubscriptionButton2$$serializer();
        INSTANCE = browseResponse$Header$MusicImmersiveHeaderRenderer$SubscriptionButton2$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.response.BrowseResponse.Header.MusicImmersiveHeaderRenderer.SubscriptionButton2", browseResponse$Header$MusicImmersiveHeaderRenderer$SubscriptionButton2$$serializer, 1);
        pluginGeneratedSerialDescriptor.addElement("subscribeButtonRenderer", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{HexFormatKt.getNullable(BrowseResponse$Header$MusicImmersiveHeaderRenderer$SubscriptionButton2$SubscribeButtonRenderer$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        BrowseResponse.Header.MusicImmersiveHeaderRenderer.SubscriptionButton2.SubscribeButtonRenderer subscribeButtonRenderer;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        int i = 1;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            subscribeButtonRenderer = (BrowseResponse.Header.MusicImmersiveHeaderRenderer.SubscriptionButton2.SubscribeButtonRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, BrowseResponse$Header$MusicImmersiveHeaderRenderer$SubscriptionButton2$SubscribeButtonRenderer$$serializer.INSTANCE, null);
        } else {
            boolean z = true;
            int i2 = 0;
            subscribeButtonRenderer = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else {
                    if (iDecodeElementIndex != 0) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    subscribeButtonRenderer = (BrowseResponse.Header.MusicImmersiveHeaderRenderer.SubscriptionButton2.SubscribeButtonRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, BrowseResponse$Header$MusicImmersiveHeaderRenderer$SubscriptionButton2$SubscribeButtonRenderer$$serializer.INSTANCE, subscribeButtonRenderer);
                    i2 = 1;
                }
            }
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new BrowseResponse.Header.MusicImmersiveHeaderRenderer.SubscriptionButton2(i, subscribeButtonRenderer);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        BrowseResponse.Header.MusicImmersiveHeaderRenderer.SubscriptionButton2 subscriptionButton2 = (BrowseResponse.Header.MusicImmersiveHeaderRenderer.SubscriptionButton2) obj;
        subscriptionButton2.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, BrowseResponse$Header$MusicImmersiveHeaderRenderer$SubscriptionButton2$SubscribeButtonRenderer$$serializer.INSTANCE, subscriptionButton2.subscribeButtonRenderer);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
