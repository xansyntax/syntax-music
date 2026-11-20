package com.metrolist.music.lyrics;

import io.ktor.http.ContentType;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlin.jvm.internal.Intrinsics;
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
public final /* synthetic */ class LyricWord$$serializer implements GeneratedSerializer {
    public static final LyricWord$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        LyricWord$$serializer lyricWord$$serializer = new LyricWord$$serializer();
        INSTANCE = lyricWord$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.music.lyrics.LyricWord", lyricWord$$serializer, 4);
        pluginGeneratedSerialDescriptor.addElement("time", true);
        pluginGeneratedSerialDescriptor.addElement("duration", true);
        pluginGeneratedSerialDescriptor.addElement(ContentType.Text.TYPE, true);
        pluginGeneratedSerialDescriptor.addElement("isBackground", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        LongSerializer longSerializer = LongSerializer.INSTANCE;
        return new KSerializer[]{longSerializer, longSerializer, StringSerializer.INSTANCE, BooleanSerializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        String strDecodeStringElement;
        boolean zDecodeBooleanElement;
        int i;
        long j;
        long j2;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            long jDecodeLongElement = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, 0);
            long jDecodeLongElement2 = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, 1);
            strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 2);
            zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 3);
            i = 15;
            j = jDecodeLongElement;
            j2 = jDecodeLongElement2;
        } else {
            boolean z = true;
            int i2 = 0;
            long jDecodeLongElement3 = 0;
            long jDecodeLongElement4 = 0;
            String strDecodeStringElement2 = null;
            boolean zDecodeBooleanElement2 = false;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    jDecodeLongElement3 = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, 0);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    jDecodeLongElement4 = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, 1);
                    i2 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 2);
                    i2 |= 4;
                } else {
                    if (iDecodeElementIndex != 3) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    zDecodeBooleanElement2 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 3);
                    i2 |= 8;
                }
            }
            strDecodeStringElement = strDecodeStringElement2;
            zDecodeBooleanElement = zDecodeBooleanElement2;
            i = i2;
            j = jDecodeLongElement3;
            j2 = jDecodeLongElement4;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new LyricWord(i, j, j2, strDecodeStringElement, zDecodeBooleanElement);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        LyricWord lyricWord = (LyricWord) obj;
        lyricWord.getClass();
        boolean z = lyricWord.isBackground;
        String str = lyricWord.text;
        long j = lyricWord.duration;
        long j2 = lyricWord.time;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 0) || j2 != 0) {
            compositeEncoderBeginStructure.encodeLongElement(serialDescriptor, 0, j2);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 1) || j != 0) {
            compositeEncoderBeginStructure.encodeLongElement(serialDescriptor, 1, j);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 2) || !Intrinsics.areEqual(str, "")) {
            compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 2, str);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 3) || z) {
            compositeEncoderBeginStructure.encodeBooleanElement(serialDescriptor, 3, z);
        }
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
