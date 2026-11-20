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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CachedItem$Playlist$$serializer implements GeneratedSerializer {
    public static final CachedItem$Playlist$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        CachedItem$Playlist$$serializer cachedItem$Playlist$$serializer = new CachedItem$Playlist$$serializer();
        INSTANCE = cachedItem$Playlist$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("playlist", cachedItem$Playlist$$serializer, 6);
        pluginGeneratedSerialDescriptor.addElement("id", false);
        pluginGeneratedSerialDescriptor.addElement(LinkHeader.Parameters.Title, false);
        pluginGeneratedSerialDescriptor.addElement("thumbnail", false);
        pluginGeneratedSerialDescriptor.addElement("author", true);
        pluginGeneratedSerialDescriptor.addElement("songCountText", true);
        pluginGeneratedSerialDescriptor.addElement("authorAvatarUrl", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, stringSerializer, stringSerializer, HexFormatKt.getNullable(CachedArtist$$serializer.INSTANCE), HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(stringSerializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        String strDecodeStringElement;
        String str;
        CachedArtist cachedArtist;
        String str2;
        String str3;
        String str4;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Object obj = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
            String strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 1);
            String strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 2);
            CachedArtist cachedArtist2 = (CachedArtist) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, CachedArtist$$serializer.INSTANCE, null);
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            String str5 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, stringSerializer, null);
            str = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, stringSerializer, null);
            cachedArtist = cachedArtist2;
            str2 = str5;
            str3 = strDecodeStringElement3;
            str4 = strDecodeStringElement2;
            i = 63;
        } else {
            boolean z = true;
            int i2 = 0;
            strDecodeStringElement = null;
            String str6 = null;
            CachedArtist cachedArtist3 = null;
            String str7 = null;
            String strDecodeStringElement4 = null;
            String strDecodeStringElement5 = null;
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
                        strDecodeStringElement5 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 1);
                        i2 |= 2;
                        break;
                    case 2:
                        strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 2);
                        i2 |= 4;
                        break;
                    case 3:
                        cachedArtist3 = (CachedArtist) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, CachedArtist$$serializer.INSTANCE, cachedArtist3);
                        i2 |= 8;
                        break;
                    case 4:
                        str7 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str7);
                        i2 |= 16;
                        break;
                    case 5:
                        str6 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, str6);
                        i2 |= 32;
                        break;
                    default:
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return obj;
                }
                obj = null;
            }
            str = str6;
            cachedArtist = cachedArtist3;
            str2 = str7;
            str3 = strDecodeStringElement4;
            str4 = strDecodeStringElement5;
            i = i2;
        }
        String str8 = strDecodeStringElement;
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new CachedItem.Playlist(i, str8, str4, str3, cachedArtist, str2, str);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        CachedItem.Playlist playlist = (CachedItem.Playlist) obj;
        playlist.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        String str = playlist.id;
        String str2 = playlist.authorAvatarUrl;
        String str3 = playlist.songCountText;
        CachedArtist cachedArtist = playlist.author;
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 0, str);
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 1, playlist.title);
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 2, playlist.thumbnail);
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 3) || cachedArtist != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 3, CachedArtist$$serializer.INSTANCE, cachedArtist);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 4) || str3 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str3);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 5) || str2 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, str2);
        }
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
