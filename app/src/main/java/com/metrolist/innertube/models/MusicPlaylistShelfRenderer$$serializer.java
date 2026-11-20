package com.metrolist.innertube.models;

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
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MusicPlaylistShelfRenderer$$serializer implements GeneratedSerializer {
    public static final MusicPlaylistShelfRenderer$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        MusicPlaylistShelfRenderer$$serializer musicPlaylistShelfRenderer$$serializer = new MusicPlaylistShelfRenderer$$serializer();
        INSTANCE = musicPlaylistShelfRenderer$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.MusicPlaylistShelfRenderer", musicPlaylistShelfRenderer$$serializer, 4);
        pluginGeneratedSerialDescriptor.addElement("playlistId", false);
        pluginGeneratedSerialDescriptor.addElement("contents", true);
        pluginGeneratedSerialDescriptor.addElement("collapsedItemCount", true);
        pluginGeneratedSerialDescriptor.addElement("continuations", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        Lazy[] lazyArr = MusicPlaylistShelfRenderer.$childSerializers;
        return new KSerializer[]{HexFormatKt.getNullable(StringSerializer.INSTANCE), lazyArr[1].getValue(), HexFormatKt.getNullable(IntSerializer.INSTANCE), HexFormatKt.getNullable((KSerializer) lazyArr[3].getValue())};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        List list;
        String str;
        Integer num;
        int i;
        List list2;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = MusicPlaylistShelfRenderer.$childSerializers;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String str2 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, null);
            List list3 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), null);
            Integer num2 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, IntSerializer.INSTANCE, null);
            list = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, (DeserializationStrategy) lazyArr[3].getValue(), null);
            str = str2;
            num = num2;
            i = 15;
            list2 = list3;
        } else {
            boolean z = true;
            int i2 = 0;
            List list4 = null;
            String str3 = null;
            Integer num3 = null;
            List list5 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    str3 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str3);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    list5 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), list5);
                    i2 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    num3 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, IntSerializer.INSTANCE, num3);
                    i2 |= 4;
                } else {
                    if (iDecodeElementIndex != 3) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    list4 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, (DeserializationStrategy) lazyArr[3].getValue(), list4);
                    i2 |= 8;
                }
            }
            list = list4;
            str = str3;
            num = num3;
            i = i2;
            list2 = list5;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new MusicPlaylistShelfRenderer(i, str, list2, num, list);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        MusicPlaylistShelfRenderer musicPlaylistShelfRenderer = (MusicPlaylistShelfRenderer) obj;
        musicPlaylistShelfRenderer.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = MusicPlaylistShelfRenderer.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        String str = musicPlaylistShelfRenderer.playlistId;
        List list = musicPlaylistShelfRenderer.continuations;
        Integer num = musicPlaylistShelfRenderer.collapsedItemCount;
        List list2 = musicPlaylistShelfRenderer.contents;
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, stringSerializer, str);
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 1) || !Intrinsics.areEqual(list2, EmptyList.INSTANCE)) {
            compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 1, (SerializationStrategy) lazyArr[1].getValue(), list2);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 2) || num != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 2, IntSerializer.INSTANCE, num);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 3) || list != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 3, (SerializationStrategy) lazyArr[3].getValue(), list);
        }
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
