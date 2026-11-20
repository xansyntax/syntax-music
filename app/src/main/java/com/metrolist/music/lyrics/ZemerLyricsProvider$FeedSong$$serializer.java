package com.metrolist.music.lyrics;

import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.List;
import kotlin.Lazy;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.HexFormatKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ZemerLyricsProvider$FeedSong$$serializer implements GeneratedSerializer {
    public static final ZemerLyricsProvider$FeedSong$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        ZemerLyricsProvider$FeedSong$$serializer zemerLyricsProvider$FeedSong$$serializer = new ZemerLyricsProvider$FeedSong$$serializer();
        INSTANCE = zemerLyricsProvider$FeedSong$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.music.lyrics.ZemerLyricsProvider.FeedSong", zemerLyricsProvider$FeedSong$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement("id", false);
        pluginGeneratedSerialDescriptor.addElement("duration", true);
        pluginGeneratedSerialDescriptor.addElement("lyrics", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{LongSerializer.INSTANCE, HexFormatKt.getNullable(IntSerializer.INSTANCE), ZemerLyricsProvider.FeedSong.$childSerializers[2].getValue()};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        List list;
        Integer num;
        int i;
        long j;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = ZemerLyricsProvider.FeedSong.$childSerializers;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            long jDecodeLongElement = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, 0);
            Integer num2 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, IntSerializer.INSTANCE, null);
            list = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), null);
            num = num2;
            i = 7;
            j = jDecodeLongElement;
        } else {
            boolean z = true;
            List list2 = null;
            long jDecodeLongElement2 = 0;
            int i2 = 0;
            Integer num3 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    jDecodeLongElement2 = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, 0);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    num3 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, IntSerializer.INSTANCE, num3);
                    i2 |= 2;
                } else {
                    if (iDecodeElementIndex != 2) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    list2 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), list2);
                    i2 |= 4;
                }
            }
            list = list2;
            num = num3;
            i = i2;
            j = jDecodeLongElement2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new ZemerLyricsProvider.FeedSong(i, j, num, list);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        ZemerLyricsProvider.FeedSong feedSong = (ZemerLyricsProvider.FeedSong) obj;
        feedSong.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = ZemerLyricsProvider.FeedSong.$childSerializers;
        long j = feedSong.id;
        List list = feedSong.lyrics;
        Integer num = feedSong.duration;
        compositeEncoderBeginStructure.encodeLongElement(serialDescriptor, 0, j);
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 1) || num != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, IntSerializer.INSTANCE, num);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 2) || !Intrinsics.areEqual(list, EmptyList.INSTANCE)) {
            compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 2, (SerializationStrategy) lazyArr[2].getValue(), list);
        }
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
