package com.metrolist.music.lyrics;

import io.ktor.http.ContentDisposition;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlin.text.HexFormatKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SongPart$$serializer implements GeneratedSerializer {
    public static final SongPart$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        SongPart$$serializer songPart$$serializer = new SongPart$$serializer();
        INSTANCE = songPart$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.music.lyrics.SongPart", songPart$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement(ContentDisposition.Parameters.Name, true);
        pluginGeneratedSerialDescriptor.addElement("time", true);
        pluginGeneratedSerialDescriptor.addElement("duration", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        KSerializer nullable = HexFormatKt.getNullable(StringSerializer.INSTANCE);
        LongSerializer longSerializer = LongSerializer.INSTANCE;
        return new KSerializer[]{nullable, HexFormatKt.getNullable(longSerializer), HexFormatKt.getNullable(longSerializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        String str;
        Long l;
        Long l2;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            str = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, null);
            LongSerializer longSerializer = LongSerializer.INSTANCE;
            l2 = (Long) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, longSerializer, null);
            l = (Long) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, longSerializer, null);
            i = 7;
        } else {
            boolean z = true;
            int i2 = 0;
            str = null;
            Long l3 = null;
            Long l4 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    str = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    l4 = (Long) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, LongSerializer.INSTANCE, l4);
                    i2 |= 2;
                } else {
                    if (iDecodeElementIndex != 2) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    l3 = (Long) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, LongSerializer.INSTANCE, l3);
                    i2 |= 4;
                }
            }
            l = l3;
            l2 = l4;
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new SongPart(i, str, l2, l);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        SongPart songPart = (SongPart) obj;
        songPart.getClass();
        Long l = songPart.duration;
        Long l2 = songPart.time;
        String str = songPart.name;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 0) || str != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 1) || l2 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, LongSerializer.INSTANCE, l2);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 2) || l != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 2, LongSerializer.INSTANCE, l);
        }
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
