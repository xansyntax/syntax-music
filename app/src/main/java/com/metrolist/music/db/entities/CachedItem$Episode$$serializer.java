package com.metrolist.music.db.entities;

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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CachedItem$Episode$$serializer implements GeneratedSerializer {
    public static final CachedItem$Episode$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        CachedItem$Episode$$serializer cachedItem$Episode$$serializer = new CachedItem$Episode$$serializer();
        INSTANCE = cachedItem$Episode$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("episode", cachedItem$Episode$$serializer, 7);
        pluginGeneratedSerialDescriptor.addElement("id", false);
        pluginGeneratedSerialDescriptor.addElement(LinkHeader.Parameters.Title, false);
        pluginGeneratedSerialDescriptor.addElement("thumbnail", false);
        pluginGeneratedSerialDescriptor.addElement("explicit", true);
        pluginGeneratedSerialDescriptor.addElement("author", true);
        pluginGeneratedSerialDescriptor.addElement("album", true);
        pluginGeneratedSerialDescriptor.addElement("duration", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        KSerializer nullable = HexFormatKt.getNullable(CachedArtist$$serializer.INSTANCE);
        KSerializer nullable2 = HexFormatKt.getNullable(CachedAlbum$$serializer.INSTANCE);
        KSerializer nullable3 = HexFormatKt.getNullable(IntSerializer.INSTANCE);
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, stringSerializer, stringSerializer, BooleanSerializer.INSTANCE, nullable, nullable2, nullable3};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        String strDecodeStringElement;
        Integer num;
        CachedAlbum cachedAlbum;
        boolean z;
        CachedArtist cachedArtist;
        String str;
        String str2;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Object obj = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
            String strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 1);
            String strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 2);
            boolean zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 3);
            CachedArtist cachedArtist2 = (CachedArtist) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, CachedArtist$$serializer.INSTANCE, null);
            CachedAlbum cachedAlbum2 = (CachedAlbum) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, CachedAlbum$$serializer.INSTANCE, null);
            num = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, IntSerializer.INSTANCE, null);
            cachedAlbum = cachedAlbum2;
            z = zDecodeBooleanElement;
            cachedArtist = cachedArtist2;
            str = strDecodeStringElement3;
            str2 = strDecodeStringElement2;
            i = 127;
        } else {
            boolean z2 = true;
            boolean zDecodeBooleanElement2 = false;
            int i2 = 0;
            strDecodeStringElement = null;
            Integer num2 = null;
            CachedAlbum cachedAlbum3 = null;
            CachedArtist cachedArtist3 = null;
            String strDecodeStringElement4 = null;
            String strDecodeStringElement5 = null;
            while (z2) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case ImageHeaderParser.UNKNOWN_ORIENTATION /* -1 */:
                        z2 = false;
                        continue;
                    case 0:
                        strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
                        i2 |= 1;
                        break;
                    case 1:
                        strDecodeStringElement5 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 1);
                        i2 |= 2;
                        break;
                    case 2:
                        strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 2);
                        i2 |= 4;
                        break;
                    case 3:
                        zDecodeBooleanElement2 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 3);
                        i2 |= 8;
                        break;
                    case 4:
                        cachedArtist3 = (CachedArtist) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, CachedArtist$$serializer.INSTANCE, cachedArtist3);
                        i2 |= 16;
                        break;
                    case 5:
                        cachedAlbum3 = (CachedAlbum) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, CachedAlbum$$serializer.INSTANCE, cachedAlbum3);
                        i2 |= 32;
                        break;
                    case 6:
                        num2 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, IntSerializer.INSTANCE, num2);
                        i2 |= 64;
                        break;
                    default:
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return obj;
                }
                obj = null;
            }
            num = num2;
            cachedAlbum = cachedAlbum3;
            z = zDecodeBooleanElement2;
            cachedArtist = cachedArtist3;
            str = strDecodeStringElement4;
            str2 = strDecodeStringElement5;
            i = i2;
        }
        String str3 = strDecodeStringElement;
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new CachedItem.Episode(i, str3, str2, str, z, cachedArtist, cachedAlbum, num);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        CachedItem.Episode episode = (CachedItem.Episode) obj;
        episode.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        String str = episode.id;
        Integer num = episode.duration;
        CachedAlbum cachedAlbum = episode.album;
        CachedArtist cachedArtist = episode.author;
        boolean z = episode.explicit;
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 0, str);
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 1, episode.title);
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 2, episode.thumbnail);
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 3) || z) {
            compositeEncoderBeginStructure.encodeBooleanElement(serialDescriptor, 3, z);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 4) || cachedArtist != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 4, CachedArtist$$serializer.INSTANCE, cachedArtist);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 5) || cachedAlbum != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 5, CachedAlbum$$serializer.INSTANCE, cachedAlbum);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 6) || num != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 6, IntSerializer.INSTANCE, num);
        }
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
