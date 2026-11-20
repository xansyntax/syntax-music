package com.metrolist.innertube.models.response;

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
public final /* synthetic */ class PlayerResponse$StreamingData$Format$AudioTrack$$serializer implements GeneratedSerializer {
    public static final PlayerResponse$StreamingData$Format$AudioTrack$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        PlayerResponse$StreamingData$Format$AudioTrack$$serializer playerResponse$StreamingData$Format$AudioTrack$$serializer = new PlayerResponse$StreamingData$Format$AudioTrack$$serializer();
        INSTANCE = playerResponse$StreamingData$Format$AudioTrack$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.response.PlayerResponse.StreamingData.Format.AudioTrack", playerResponse$StreamingData$Format$AudioTrack$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement("displayName", false);
        pluginGeneratedSerialDescriptor.addElement("id", false);
        pluginGeneratedSerialDescriptor.addElement("isAutoDubbed", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(BooleanSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        String str;
        Boolean bool;
        int i;
        String str2;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            str2 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, stringSerializer, null);
            str = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, stringSerializer, null);
            bool = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, BooleanSerializer.INSTANCE, null);
            i = 7;
        } else {
            boolean z = true;
            int i2 = 0;
            str = null;
            Boolean bool2 = null;
            String str3 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    str3 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str3);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    str = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str);
                    i2 |= 2;
                } else {
                    if (iDecodeElementIndex != 2) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    bool2 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, BooleanSerializer.INSTANCE, bool2);
                    i2 |= 4;
                }
            }
            bool = bool2;
            i = i2;
            str2 = str3;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new PlayerResponse$StreamingData$Format.AudioTrack(i, str2, str, bool);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        PlayerResponse$StreamingData$Format.AudioTrack audioTrack = (PlayerResponse$StreamingData$Format.AudioTrack) obj;
        audioTrack.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, stringSerializer, audioTrack.displayName);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, stringSerializer, audioTrack.id);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 2, BooleanSerializer.INSTANCE, audioTrack.isAutoDubbed);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
