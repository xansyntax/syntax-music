package com.metrolist.innertube.models;

import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlin.text.HexFormatKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SubscriptionButton$SubscribeButtonRenderer$$serializer implements GeneratedSerializer {
    public static final SubscriptionButton$SubscribeButtonRenderer$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        SubscriptionButton$SubscribeButtonRenderer$$serializer subscriptionButton$SubscribeButtonRenderer$$serializer = new SubscriptionButton$SubscribeButtonRenderer$$serializer();
        INSTANCE = subscriptionButton$SubscribeButtonRenderer$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.SubscriptionButton.SubscribeButtonRenderer", subscriptionButton$SubscribeButtonRenderer$$serializer, 4);
        pluginGeneratedSerialDescriptor.addElement("subscribed", false);
        pluginGeneratedSerialDescriptor.addElement("channelId", false);
        pluginGeneratedSerialDescriptor.addElement("longSubscriberCountText", true);
        pluginGeneratedSerialDescriptor.addElement("shortSubscriberCountText", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        Runs$$serializer runs$$serializer = Runs$$serializer.INSTANCE;
        return new KSerializer[]{BooleanSerializer.INSTANCE, StringSerializer.INSTANCE, HexFormatKt.getNullable(runs$$serializer), HexFormatKt.getNullable(runs$$serializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        boolean zDecodeBooleanElement;
        Runs runs;
        Runs runs2;
        String str;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 0);
            String strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 1);
            Runs$$serializer runs$$serializer = Runs$$serializer.INSTANCE;
            Runs runs3 = (Runs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, runs$$serializer, null);
            runs = (Runs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, runs$$serializer, null);
            runs2 = runs3;
            str = strDecodeStringElement;
            i = 15;
        } else {
            boolean z = true;
            zDecodeBooleanElement = false;
            int i2 = 0;
            Runs runs4 = null;
            Runs runs5 = null;
            String strDecodeStringElement2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 0);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 1);
                    i2 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    runs5 = (Runs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, Runs$$serializer.INSTANCE, runs5);
                    i2 |= 4;
                } else {
                    if (iDecodeElementIndex != 3) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    runs4 = (Runs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, Runs$$serializer.INSTANCE, runs4);
                    i2 |= 8;
                }
            }
            runs = runs4;
            runs2 = runs5;
            str = strDecodeStringElement2;
            i = i2;
        }
        boolean z2 = zDecodeBooleanElement;
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new SubscriptionButton.SubscribeButtonRenderer(i, z2, str, runs2, runs);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        SubscriptionButton.SubscribeButtonRenderer subscribeButtonRenderer = (SubscriptionButton.SubscribeButtonRenderer) obj;
        subscribeButtonRenderer.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        boolean z = subscribeButtonRenderer.subscribed;
        Runs runs = subscribeButtonRenderer.shortSubscriberCountText;
        Runs runs2 = subscribeButtonRenderer.longSubscriberCountText;
        compositeEncoderBeginStructure.encodeBooleanElement(serialDescriptor, 0, z);
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 1, subscribeButtonRenderer.channelId);
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 2) || runs2 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 2, Runs$$serializer.INSTANCE, runs2);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 3) || runs != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 3, Runs$$serializer.INSTANCE, runs);
        }
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
