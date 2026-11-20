package com.metrolist.paxsenix.models;

import com.yalantis.ucrop.util.ImageHeaderParser;
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
public final /* synthetic */ class AppleMusicSongAttributes$$serializer implements GeneratedSerializer {
    public static final AppleMusicSongAttributes$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        AppleMusicSongAttributes$$serializer appleMusicSongAttributes$$serializer = new AppleMusicSongAttributes$$serializer();
        INSTANCE = appleMusicSongAttributes$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.paxsenix.models.AppleMusicSongAttributes", appleMusicSongAttributes$$serializer, 6);
        pluginGeneratedSerialDescriptor.addElement(ContentDisposition.Parameters.Name, false);
        pluginGeneratedSerialDescriptor.addElement("artistName", false);
        pluginGeneratedSerialDescriptor.addElement("albumName", true);
        pluginGeneratedSerialDescriptor.addElement("artwork", true);
        pluginGeneratedSerialDescriptor.addElement("url", true);
        pluginGeneratedSerialDescriptor.addElement("durationInMillis", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, stringSerializer, HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(AppleMusicArtwork$$serializer.INSTANCE), HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(LongSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        String strDecodeStringElement;
        Long l;
        AppleMusicArtwork appleMusicArtwork;
        String str;
        String str2;
        String str3;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Object obj = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
            String strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 1);
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            String str4 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, stringSerializer, null);
            AppleMusicArtwork appleMusicArtwork2 = (AppleMusicArtwork) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, AppleMusicArtwork$$serializer.INSTANCE, null);
            String str5 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, stringSerializer, null);
            l = (Long) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, LongSerializer.INSTANCE, null);
            appleMusicArtwork = appleMusicArtwork2;
            str = str5;
            str2 = str4;
            str3 = strDecodeStringElement2;
            i = 63;
        } else {
            boolean z = true;
            int i2 = 0;
            strDecodeStringElement = null;
            Long l2 = null;
            AppleMusicArtwork appleMusicArtwork3 = null;
            String str6 = null;
            String str7 = null;
            String strDecodeStringElement3 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case ImageHeaderParser.UNKNOWN_ORIENTATION /* -1 */:
                        z = false;
                        continue;
                    case 0:
                        strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
                        i2 |= 1;
                        break;
                    case 1:
                        strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 1);
                        i2 |= 2;
                        break;
                    case 2:
                        str7 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str7);
                        i2 |= 4;
                        break;
                    case 3:
                        appleMusicArtwork3 = (AppleMusicArtwork) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, AppleMusicArtwork$$serializer.INSTANCE, appleMusicArtwork3);
                        i2 |= 8;
                        break;
                    case 4:
                        str6 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str6);
                        i2 |= 16;
                        break;
                    case 5:
                        l2 = (Long) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, LongSerializer.INSTANCE, l2);
                        i2 |= 32;
                        break;
                    default:
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return obj;
                }
                obj = null;
            }
            l = l2;
            appleMusicArtwork = appleMusicArtwork3;
            str = str6;
            str2 = str7;
            str3 = strDecodeStringElement3;
            i = i2;
        }
        String str8 = strDecodeStringElement;
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new AppleMusicSongAttributes(i, str8, str3, str2, appleMusicArtwork, str, l);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        AppleMusicSongAttributes appleMusicSongAttributes = (AppleMusicSongAttributes) obj;
        appleMusicSongAttributes.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        String str = appleMusicSongAttributes.name;
        Long l = appleMusicSongAttributes.durationInMillis;
        String str2 = appleMusicSongAttributes.url;
        AppleMusicArtwork appleMusicArtwork = appleMusicSongAttributes.artwork;
        String str3 = appleMusicSongAttributes.albumName;
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 0, str);
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 1, appleMusicSongAttributes.artistName);
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 2) || str3 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str3);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 3) || appleMusicArtwork != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 3, AppleMusicArtwork$$serializer.INSTANCE, appleMusicArtwork);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 4) || str2 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str2);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 5) || l != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 5, LongSerializer.INSTANCE, l);
        }
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
