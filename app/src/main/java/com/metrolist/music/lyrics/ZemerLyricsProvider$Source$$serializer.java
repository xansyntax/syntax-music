package com.metrolist.music.lyrics;

import com.yalantis.ucrop.util.ImageHeaderParser;
import io.ktor.http.LinkHeader;
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
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ZemerLyricsProvider$Source$$serializer implements GeneratedSerializer {
    public static final ZemerLyricsProvider$Source$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        ZemerLyricsProvider$Source$$serializer zemerLyricsProvider$Source$$serializer = new ZemerLyricsProvider$Source$$serializer();
        INSTANCE = zemerLyricsProvider$Source$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.music.lyrics.ZemerLyricsProvider.Source", zemerLyricsProvider$Source$$serializer, 8);
        pluginGeneratedSerialDescriptor.addElement(LinkHeader.Parameters.Type, false);
        pluginGeneratedSerialDescriptor.addElement("url", true);
        pluginGeneratedSerialDescriptor.addElement("songId", true);
        pluginGeneratedSerialDescriptor.addElement("feedUrl", true);
        pluginGeneratedSerialDescriptor.addElement("trackId", true);
        pluginGeneratedSerialDescriptor.addElement("plain", true);
        pluginGeneratedSerialDescriptor.addElement("syncedLrc", true);
        pluginGeneratedSerialDescriptor.addElement("synced", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        KSerializer nullable = HexFormatKt.getNullable(stringSerializer);
        LongSerializer longSerializer = LongSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, nullable, HexFormatKt.getNullable(longSerializer), HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(longSerializer), HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(stringSerializer), BooleanSerializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        String strDecodeStringElement;
        String str;
        int i;
        Long l;
        Long l2;
        boolean zDecodeBooleanElement;
        String str2;
        String str3;
        String str4;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        int i2 = 7;
        int i3 = 6;
        int i4 = 5;
        Long l3 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            String str5 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, stringSerializer, null);
            LongSerializer longSerializer = LongSerializer.INSTANCE;
            Long l4 = (Long) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, longSerializer, null);
            String str6 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, stringSerializer, null);
            Long l5 = (Long) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, longSerializer, null);
            String str7 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, stringSerializer, null);
            String str8 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, stringSerializer, null);
            zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 7);
            str2 = str8;
            str3 = str7;
            str4 = str6;
            l2 = l5;
            l = l4;
            str = str5;
            i = 255;
        } else {
            boolean z = true;
            int i5 = 0;
            boolean zDecodeBooleanElement2 = false;
            strDecodeStringElement = null;
            Long l6 = null;
            String str9 = null;
            String str10 = null;
            String str11 = null;
            String str12 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case ImageHeaderParser.UNKNOWN_ORIENTATION /* -1 */:
                        z = false;
                        i2 = 7;
                        i3 = 6;
                        break;
                    case 0:
                        strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
                        i5 |= 1;
                        i2 = 7;
                        i3 = 6;
                        i4 = 5;
                        break;
                    case 1:
                        i5 |= 2;
                        str12 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str12);
                        i2 = 7;
                        i3 = 6;
                        i4 = 5;
                        break;
                    case 2:
                        l6 = (Long) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, LongSerializer.INSTANCE, l6);
                        i5 |= 4;
                        i2 = 7;
                        break;
                    case 3:
                        str11 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str11);
                        i5 |= 8;
                        i2 = 7;
                        break;
                    case 4:
                        l3 = (Long) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, LongSerializer.INSTANCE, l3);
                        i5 |= 16;
                        i2 = 7;
                        break;
                    case 5:
                        str10 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i4, StringSerializer.INSTANCE, str10);
                        i5 |= 32;
                        i2 = 7;
                        break;
                    case 6:
                        str9 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i3, StringSerializer.INSTANCE, str9);
                        i5 |= 64;
                        i2 = 7;
                        break;
                    case 7:
                        zDecodeBooleanElement2 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, i2);
                        i5 |= 128;
                        break;
                    default:
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                }
            }
            str = str12;
            i = i5;
            l = l6;
            l2 = l3;
            zDecodeBooleanElement = zDecodeBooleanElement2;
            str2 = str9;
            str3 = str10;
            str4 = str11;
        }
        String str13 = strDecodeStringElement;
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new ZemerLyricsProvider.Source(i, str13, str, l, str4, l2, str3, str2, zDecodeBooleanElement);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        ZemerLyricsProvider.Source source = (ZemerLyricsProvider.Source) obj;
        source.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        String str = source.type;
        boolean z = source.synced;
        String str2 = source.syncedLrc;
        String str3 = source.plain;
        Long l = source.trackId;
        String str4 = source.feedUrl;
        Long l2 = source.songId;
        String str5 = source.url;
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 0, str);
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 1) || str5 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str5);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 2) || l2 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 2, LongSerializer.INSTANCE, l2);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 3) || str4 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str4);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 4) || l != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 4, LongSerializer.INSTANCE, l);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 5) || str3 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, str3);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 6) || str2 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, str2);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 7) || z) {
            compositeEncoderBeginStructure.encodeBooleanElement(serialDescriptor, 7, z);
        }
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
