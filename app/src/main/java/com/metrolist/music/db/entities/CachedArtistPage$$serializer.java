package com.metrolist.music.db.entities;

import com.yalantis.ucrop.util.ImageHeaderParser;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.List;
import kotlin.Lazy;
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
public final /* synthetic */ class CachedArtistPage$$serializer implements GeneratedSerializer {
    public static final CachedArtistPage$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        CachedArtistPage$$serializer cachedArtistPage$$serializer = new CachedArtistPage$$serializer();
        INSTANCE = cachedArtistPage$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.music.db.entities.CachedArtistPage", cachedArtistPage$$serializer, 6);
        pluginGeneratedSerialDescriptor.addElement("artist", true);
        pluginGeneratedSerialDescriptor.addElement("sections", false);
        pluginGeneratedSerialDescriptor.addElement("description", true);
        pluginGeneratedSerialDescriptor.addElement("subscriberCountText", true);
        pluginGeneratedSerialDescriptor.addElement("monthlyListenerCount", true);
        pluginGeneratedSerialDescriptor.addElement("isSubscribed", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        Lazy[] lazyArr = CachedArtistPage.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{HexFormatKt.getNullable(CachedArtistItem$$serializer.INSTANCE), lazyArr[1].getValue(), HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(stringSerializer), BooleanSerializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        List list;
        CachedArtistItem cachedArtistItem;
        boolean zDecodeBooleanElement;
        String str;
        String str2;
        String str3;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = CachedArtistPage.$childSerializers;
        int i2 = 5;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            CachedArtistItem cachedArtistItem2 = (CachedArtistItem) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, CachedArtistItem$$serializer.INSTANCE, null);
            List list2 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), null);
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            String str4 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, stringSerializer, null);
            String str5 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, stringSerializer, null);
            String str6 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, stringSerializer, null);
            list = list2;
            cachedArtistItem = cachedArtistItem2;
            zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 5);
            str = str5;
            str2 = str6;
            str3 = str4;
            i = 63;
        } else {
            boolean z = true;
            boolean zDecodeBooleanElement2 = false;
            int i3 = 0;
            List list3 = null;
            CachedArtistItem cachedArtistItem3 = null;
            String str7 = null;
            String str8 = null;
            String str9 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case ImageHeaderParser.UNKNOWN_ORIENTATION /* -1 */:
                        z = false;
                        continue;
                    case 0:
                        cachedArtistItem3 = (CachedArtistItem) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, CachedArtistItem$$serializer.INSTANCE, cachedArtistItem3);
                        i3 |= 1;
                        break;
                    case 1:
                        list3 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), list3);
                        i3 |= 2;
                        break;
                    case 2:
                        str9 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str9);
                        i3 |= 4;
                        break;
                    case 3:
                        str7 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str7);
                        i3 |= 8;
                        break;
                    case 4:
                        str8 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str8);
                        i3 |= 16;
                        break;
                    case 5:
                        zDecodeBooleanElement2 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, i2);
                        i3 |= 32;
                        continue;
                    default:
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                }
                i2 = 5;
            }
            list = list3;
            cachedArtistItem = cachedArtistItem3;
            zDecodeBooleanElement = zDecodeBooleanElement2;
            str = str7;
            str2 = str8;
            str3 = str9;
            i = i3;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new CachedArtistPage(i, cachedArtistItem, list, str3, str, str2, zDecodeBooleanElement);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        CachedArtistPage cachedArtistPage = (CachedArtistPage) obj;
        cachedArtistPage.getClass();
        CachedArtistItem cachedArtistItem = cachedArtistPage.artist;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = CachedArtistPage.$childSerializers;
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 0) || cachedArtistItem != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, CachedArtistItem$$serializer.INSTANCE, cachedArtistItem);
        }
        SerializationStrategy serializationStrategy = (SerializationStrategy) lazyArr[1].getValue();
        List list = cachedArtistPage.sections;
        boolean z = cachedArtistPage.isSubscribed;
        String str = cachedArtistPage.monthlyListenerCount;
        String str2 = cachedArtistPage.subscriberCountText;
        String str3 = cachedArtistPage.description;
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 1, serializationStrategy, list);
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 2) || str3 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str3);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 3) || str2 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str2);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 4) || str != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 5) || z) {
            compositeEncoderBeginStructure.encodeBooleanElement(serialDescriptor, 5, z);
        }
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
