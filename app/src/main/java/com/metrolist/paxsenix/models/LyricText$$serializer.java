package com.metrolist.paxsenix.models;

import io.ktor.http.ContentType;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LyricText$$serializer implements GeneratedSerializer {
    public static final LyricText$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        LyricText$$serializer lyricText$$serializer = new LyricText$$serializer();
        INSTANCE = lyricText$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.paxsenix.models.LyricText", lyricText$$serializer, 5);
        pluginGeneratedSerialDescriptor.addElement(ContentType.Text.TYPE, false);
        pluginGeneratedSerialDescriptor.addElement("timestamp", false);
        pluginGeneratedSerialDescriptor.addElement("endtime", false);
        pluginGeneratedSerialDescriptor.addElement("duration", false);
        pluginGeneratedSerialDescriptor.addElement("part", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        LongSerializer longSerializer = LongSerializer.INSTANCE;
        return new KSerializer[]{StringSerializer.INSTANCE, longSerializer, longSerializer, longSerializer, BooleanSerializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        String str;
        boolean zDecodeBooleanElement;
        int i;
        long j;
        long j2;
        long j3;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
            long jDecodeLongElement = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, 1);
            long jDecodeLongElement2 = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, 2);
            long jDecodeLongElement3 = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, 3);
            str = strDecodeStringElement;
            zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 4);
            i = 31;
            j = jDecodeLongElement;
            j2 = jDecodeLongElement2;
            j3 = jDecodeLongElement3;
        } else {
            boolean z = true;
            int i2 = 0;
            long jDecodeLongElement4 = 0;
            long jDecodeLongElement5 = 0;
            long jDecodeLongElement6 = 0;
            String strDecodeStringElement2 = null;
            boolean zDecodeBooleanElement2 = false;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    jDecodeLongElement4 = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, 1);
                    i2 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    jDecodeLongElement5 = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, 2);
                    i2 |= 4;
                } else if (iDecodeElementIndex == 3) {
                    jDecodeLongElement6 = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, 3);
                    i2 |= 8;
                } else {
                    if (iDecodeElementIndex != 4) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    zDecodeBooleanElement2 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 4);
                    i2 |= 16;
                }
            }
            str = strDecodeStringElement2;
            zDecodeBooleanElement = zDecodeBooleanElement2;
            i = i2;
            j = jDecodeLongElement4;
            j2 = jDecodeLongElement5;
            j3 = jDecodeLongElement6;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new LyricText(i, str, j, j2, j3, zDecodeBooleanElement);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        LyricText lyricText = (LyricText) obj;
        lyricText.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        String str = lyricText.text;
        boolean z = lyricText.part;
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 0, str);
        compositeEncoderBeginStructure.encodeLongElement(serialDescriptor, 1, lyricText.timestamp);
        compositeEncoderBeginStructure.encodeLongElement(serialDescriptor, 2, lyricText.endtime);
        compositeEncoderBeginStructure.encodeLongElement(serialDescriptor, 3, lyricText.duration);
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 4) || z) {
            compositeEncoderBeginStructure.encodeBooleanElement(serialDescriptor, 4, z);
        }
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
