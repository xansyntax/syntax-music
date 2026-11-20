package com.metrolist.innertubex.models.body;

import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlin.text.HexFormatKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PlayerBody$PlaybackContext$ContentPlaybackContext$$serializer implements GeneratedSerializer {
    public static final PlayerBody$PlaybackContext$ContentPlaybackContext$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        PlayerBody$PlaybackContext$ContentPlaybackContext$$serializer playerBody$PlaybackContext$ContentPlaybackContext$$serializer = new PlayerBody$PlaybackContext$ContentPlaybackContext$$serializer();
        INSTANCE = playerBody$PlaybackContext$ContentPlaybackContext$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertubex.models.body.PlayerBody.PlaybackContext.ContentPlaybackContext", playerBody$PlaybackContext$ContentPlaybackContext$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement("html5Preference", true);
        pluginGeneratedSerialDescriptor.addElement("signatureTimestamp", true);
        pluginGeneratedSerialDescriptor.addElement("encryptedHostFlags", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(IntSerializer.INSTANCE), HexFormatKt.getNullable(stringSerializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        String str;
        int i;
        Integer num;
        String str2;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            str2 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, stringSerializer, null);
            num = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, IntSerializer.INSTANCE, null);
            str = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, stringSerializer, null);
            i = 7;
        } else {
            boolean z = true;
            int i2 = 0;
            str = null;
            Integer num2 = null;
            String str3 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    str3 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str3);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    num2 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, IntSerializer.INSTANCE, num2);
                    i2 |= 2;
                } else {
                    if (iDecodeElementIndex != 2) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    str = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str);
                    i2 |= 4;
                }
            }
            i = i2;
            num = num2;
            str2 = str3;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new PlayerBody.PlaybackContext.ContentPlaybackContext(i, num, str2, str);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        PlayerBody.PlaybackContext.ContentPlaybackContext contentPlaybackContext = (PlayerBody.PlaybackContext.ContentPlaybackContext) obj;
        contentPlaybackContext.getClass();
        String str = contentPlaybackContext.encryptedHostFlags;
        Integer num = contentPlaybackContext.signatureTimestamp;
        String str2 = contentPlaybackContext.html5Preference;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 0) || str2 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str2);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 1) || num != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, IntSerializer.INSTANCE, num);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 2) || str != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str);
        }
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
