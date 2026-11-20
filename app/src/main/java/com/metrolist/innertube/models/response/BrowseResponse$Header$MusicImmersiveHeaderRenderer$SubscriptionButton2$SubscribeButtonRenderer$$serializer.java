package com.metrolist.innertube.models.response;

import com.metrolist.innertube.models.Runs;
import com.metrolist.innertube.models.Runs$$serializer;
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
public final /* synthetic */ class BrowseResponse$Header$MusicImmersiveHeaderRenderer$SubscriptionButton2$SubscribeButtonRenderer$$serializer implements GeneratedSerializer {
    public static final BrowseResponse$Header$MusicImmersiveHeaderRenderer$SubscriptionButton2$SubscribeButtonRenderer$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        BrowseResponse$Header$MusicImmersiveHeaderRenderer$SubscriptionButton2$SubscribeButtonRenderer$$serializer browseResponse$Header$MusicImmersiveHeaderRenderer$SubscriptionButton2$SubscribeButtonRenderer$$serializer = new BrowseResponse$Header$MusicImmersiveHeaderRenderer$SubscriptionButton2$SubscribeButtonRenderer$$serializer();
        INSTANCE = browseResponse$Header$MusicImmersiveHeaderRenderer$SubscriptionButton2$SubscribeButtonRenderer$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.response.BrowseResponse.Header.MusicImmersiveHeaderRenderer.SubscriptionButton2.SubscribeButtonRenderer", browseResponse$Header$MusicImmersiveHeaderRenderer$SubscriptionButton2$SubscribeButtonRenderer$$serializer, 1);
        pluginGeneratedSerialDescriptor.addElement("subscriberCountWithSubscribeText", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{HexFormatKt.getNullable(Runs$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        Runs runs;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        int i = 1;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            runs = (Runs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, Runs$$serializer.INSTANCE, null);
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
                    runs = (Runs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, Runs$$serializer.INSTANCE, runs);
                    i2 = 1;
                }
            }
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new BrowseResponse.Header.MusicImmersiveHeaderRenderer.SubscriptionButton2.SubscribeButtonRenderer(i, runs);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        BrowseResponse.Header.MusicImmersiveHeaderRenderer.SubscriptionButton2.SubscribeButtonRenderer subscribeButtonRenderer = (BrowseResponse.Header.MusicImmersiveHeaderRenderer.SubscriptionButton2.SubscribeButtonRenderer) obj;
        subscribeButtonRenderer.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, Runs$$serializer.INSTANCE, subscribeButtonRenderer.subscriberCountWithSubscribeText);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
