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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ZemerLyricsProvider$Resolved$$serializer implements GeneratedSerializer {
    public static final ZemerLyricsProvider$Resolved$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        ZemerLyricsProvider$Resolved$$serializer zemerLyricsProvider$Resolved$$serializer = new ZemerLyricsProvider$Resolved$$serializer();
        INSTANCE = zemerLyricsProvider$Resolved$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.music.lyrics.ZemerLyricsProvider.Resolved", zemerLyricsProvider$Resolved$$serializer, 5);
        pluginGeneratedSerialDescriptor.addElement("videoId", false);
        pluginGeneratedSerialDescriptor.addElement("lang", true);
        pluginGeneratedSerialDescriptor.addElement("verified", true);
        pluginGeneratedSerialDescriptor.addElement("hasSynced", true);
        pluginGeneratedSerialDescriptor.addElement("sources", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        Lazy[] lazyArr = ZemerLyricsProvider.Resolved.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        BooleanSerializer booleanSerializer = BooleanSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, HexFormatKt.getNullable(stringSerializer), booleanSerializer, booleanSerializer, lazyArr[4].getValue()};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        List list;
        String str;
        boolean z;
        boolean z2;
        int i;
        String str2;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = ZemerLyricsProvider.Resolved.$childSerializers;
        Object obj = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
            String str3 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, null);
            boolean zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 2);
            boolean zDecodeBooleanElement2 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 3);
            list = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 4, (DeserializationStrategy) lazyArr[4].getValue(), null);
            str = strDecodeStringElement;
            z = zDecodeBooleanElement2;
            z2 = zDecodeBooleanElement;
            i = 31;
            str2 = str3;
        } else {
            boolean z3 = true;
            boolean zDecodeBooleanElement3 = false;
            boolean zDecodeBooleanElement4 = false;
            int i2 = 0;
            List list2 = null;
            String strDecodeStringElement2 = null;
            String str4 = null;
            while (z3) {
                obj = obj;
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z3 = false;
                } else if (iDecodeElementIndex == 0) {
                    strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    str4 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str4);
                    i2 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    zDecodeBooleanElement4 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 2);
                    i2 |= 4;
                } else if (iDecodeElementIndex == 3) {
                    zDecodeBooleanElement3 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 3);
                    i2 |= 8;
                } else {
                    if (iDecodeElementIndex != 4) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return obj;
                    }
                    list2 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 4, (DeserializationStrategy) lazyArr[4].getValue(), list2);
                    i2 |= 16;
                }
            }
            list = list2;
            str = strDecodeStringElement2;
            z = zDecodeBooleanElement3;
            z2 = zDecodeBooleanElement4;
            i = i2;
            str2 = str4;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new ZemerLyricsProvider.Resolved(i, str, str2, z2, z, list);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        ZemerLyricsProvider.Resolved resolved = (ZemerLyricsProvider.Resolved) obj;
        resolved.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = ZemerLyricsProvider.Resolved.$childSerializers;
        String str = resolved.videoId;
        List list = resolved.sources;
        boolean z = resolved.hasSynced;
        boolean z2 = resolved.verified;
        String str2 = resolved.lang;
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 0, str);
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 1) || str2 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str2);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 2) || z2) {
            compositeEncoderBeginStructure.encodeBooleanElement(serialDescriptor, 2, z2);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 3) || z) {
            compositeEncoderBeginStructure.encodeBooleanElement(serialDescriptor, 3, z);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 4) || !Intrinsics.areEqual(list, EmptyList.INSTANCE)) {
            compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 4, (SerializationStrategy) lazyArr[4].getValue(), list);
        }
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
