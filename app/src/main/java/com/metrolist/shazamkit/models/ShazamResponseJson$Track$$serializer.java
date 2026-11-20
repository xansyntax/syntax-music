package com.metrolist.shazamkit.models;

import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.yalantis.ucrop.util.ImageHeaderParser;
import io.ktor.http.ContentType;
import io.ktor.http.LinkHeader;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.text.HexFormatKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006H\u0086\u0080\u0004¢\u0006\u0002\u0010\bJ\u0012\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0086\u0080\u0004J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0086\u0080\u0004R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014Ê\u0001\u0018\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\n\b\u0019\u0012\u0006\b\n0\u001a8\u001bÊ\u0001\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0015"}, d2 = {"com/metrolist/shazamkit/models/ShazamResponseJson.Track.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "app", "Lkotlin/Deprecated;", ContentType.Message.TYPE, "This synthesized declaration should not be used directly", "level", "Lkotlin/DeprecationLevel;", "HIDDEN", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Deprecated
public final /* synthetic */ class ShazamResponseJson$Track$$serializer implements GeneratedSerializer {
    public static final int $stable = 0;
    public static final ShazamResponseJson$Track$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        ShazamResponseJson$Track$$serializer shazamResponseJson$Track$$serializer = new ShazamResponseJson$Track$$serializer();
        INSTANCE = shazamResponseJson$Track$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.shazamkit.models.ShazamResponseJson.Track", shazamResponseJson$Track$$serializer, 15);
        pluginGeneratedSerialDescriptor.addElement("layout", true);
        pluginGeneratedSerialDescriptor.addElement(LinkHeader.Parameters.Type, true);
        pluginGeneratedSerialDescriptor.addElement("key", true);
        pluginGeneratedSerialDescriptor.addElement(LinkHeader.Parameters.Title, true);
        pluginGeneratedSerialDescriptor.addElement("subtitle", true);
        pluginGeneratedSerialDescriptor.addElement("images", true);
        pluginGeneratedSerialDescriptor.addElement("share", true);
        pluginGeneratedSerialDescriptor.addElement("hub", true);
        pluginGeneratedSerialDescriptor.addElement("sections", true);
        pluginGeneratedSerialDescriptor.addElement("url", true);
        pluginGeneratedSerialDescriptor.addElement("artists", true);
        pluginGeneratedSerialDescriptor.addElement("isrc", true);
        pluginGeneratedSerialDescriptor.addElement("genres", true);
        pluginGeneratedSerialDescriptor.addElement("relatedtracksurl", true);
        pluginGeneratedSerialDescriptor.addElement("albumadamid", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ShazamResponseJson$Track$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        Lazy[] lazyArr = ShazamResponseJson.Track.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(ShazamResponseJson$Track$Images$$serializer.INSTANCE), HexFormatKt.getNullable(ShazamResponseJson$Track$Share$$serializer.INSTANCE), HexFormatKt.getNullable(ShazamResponseJson$Track$Hub$$serializer.INSTANCE), HexFormatKt.getNullable((KSerializer) lazyArr[8].getValue()), HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable((KSerializer) lazyArr[10].getValue()), HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(ShazamResponseJson$Track$Genres$$serializer.INSTANCE), HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(stringSerializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final ShazamResponseJson.Track deserialize(Decoder decoder) {
        String str;
        ShazamResponseJson.Track.Share share;
        List list;
        ShazamResponseJson.Track.Genres genres;
        ShazamResponseJson.Track.Images images;
        String str2;
        String str3;
        ShazamResponseJson.Track.Hub hub;
        int i;
        String str4;
        String str5;
        List list2;
        String str6;
        String str7;
        String str8;
        String str9;
        decoder.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = ShazamResponseJson.Track.$childSerializers;
        int i2 = 9;
        char c = 7;
        int i3 = 8;
        ShazamResponseJson.Track.Genres genres2 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            String str10 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, stringSerializer, null);
            String str11 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, stringSerializer, null);
            String str12 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, stringSerializer, null);
            String str13 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, stringSerializer, null);
            String str14 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, stringSerializer, null);
            ShazamResponseJson.Track.Images images2 = (ShazamResponseJson.Track.Images) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, ShazamResponseJson$Track$Images$$serializer.INSTANCE, null);
            ShazamResponseJson.Track.Share share2 = (ShazamResponseJson.Track.Share) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, ShazamResponseJson$Track$Share$$serializer.INSTANCE, null);
            ShazamResponseJson.Track.Hub hub2 = (ShazamResponseJson.Track.Hub) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 7, ShazamResponseJson$Track$Hub$$serializer.INSTANCE, null);
            List list3 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 8, (DeserializationStrategy) lazyArr[8].getValue(), null);
            String str15 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 9, stringSerializer, null);
            List list4 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 10, (DeserializationStrategy) lazyArr[10].getValue(), null);
            String str16 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 11, stringSerializer, null);
            ShazamResponseJson.Track.Genres genres3 = (ShazamResponseJson.Track.Genres) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 12, ShazamResponseJson$Track$Genres$$serializer.INSTANCE, null);
            String str17 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 13, stringSerializer, null);
            str = str10;
            genres = genres3;
            str9 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 14, stringSerializer, null);
            str5 = str17;
            str6 = str11;
            i = 32767;
            str4 = str15;
            hub = hub2;
            share = share2;
            images = images2;
            str8 = str13;
            str2 = str14;
            str7 = str12;
            str3 = str16;
            list2 = list4;
            list = list3;
        } else {
            int i4 = 14;
            int i5 = 0;
            boolean z = true;
            String str18 = null;
            List list5 = null;
            String str19 = null;
            ShazamResponseJson.Track.Hub hub3 = null;
            String str20 = null;
            String str21 = null;
            List list6 = null;
            String str22 = null;
            String str23 = null;
            ShazamResponseJson.Track.Share share3 = null;
            ShazamResponseJson.Track.Images images3 = null;
            String str24 = null;
            String str25 = null;
            String str26 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case ImageHeaderParser.UNKNOWN_ORIENTATION /* -1 */:
                        z = false;
                        str18 = str18;
                        lazyArr = lazyArr;
                        i3 = 8;
                        i2 = 9;
                        c = 7;
                        break;
                    case 0:
                        str23 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str23);
                        i5 |= 1;
                        str22 = str22;
                        str18 = str18;
                        lazyArr = lazyArr;
                        i3 = 8;
                        i4 = 14;
                        i2 = 9;
                        c = 7;
                        break;
                    case 1:
                        str22 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str22);
                        i5 |= 2;
                        str26 = str26;
                        str18 = str18;
                        lazyArr = lazyArr;
                        i3 = 8;
                        i4 = 14;
                        i2 = 9;
                        c = 7;
                        break;
                    case 2:
                        str26 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str26);
                        i5 |= 4;
                        str24 = str24;
                        str18 = str18;
                        lazyArr = lazyArr;
                        i3 = 8;
                        i4 = 14;
                        i2 = 9;
                        c = 7;
                        break;
                    case 3:
                        str24 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str24);
                        i5 |= 8;
                        str18 = str18;
                        lazyArr = lazyArr;
                        i3 = 8;
                        i4 = 14;
                        i2 = 9;
                        c = 7;
                        break;
                    case 4:
                        lazyArr = lazyArr;
                        str25 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str25);
                        i5 |= 16;
                        lazyArr = lazyArr;
                        i3 = 8;
                        i4 = 14;
                        i2 = 9;
                        c = 7;
                        break;
                    case 5:
                        images3 = (ShazamResponseJson.Track.Images) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, ShazamResponseJson$Track$Images$$serializer.INSTANCE, images3);
                        i5 |= 32;
                        i3 = 8;
                        i4 = 14;
                        i2 = 9;
                        c = 7;
                        break;
                    case 6:
                        i5 |= 64;
                        share3 = (ShazamResponseJson.Track.Share) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, ShazamResponseJson$Track$Share$$serializer.INSTANCE, share3);
                        i3 = 8;
                        i4 = 14;
                        i2 = 9;
                        c = 7;
                        break;
                    case 7:
                        hub3 = (ShazamResponseJson.Track.Hub) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 7, ShazamResponseJson$Track$Hub$$serializer.INSTANCE, hub3);
                        i5 |= 128;
                        c = 7;
                        i3 = 8;
                        i4 = 14;
                        break;
                    case 8:
                        list5 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i3, (DeserializationStrategy) lazyArr[i3].getValue(), list5);
                        i5 |= 256;
                        i4 = 14;
                        c = 7;
                        break;
                    case 9:
                        str20 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i2, StringSerializer.INSTANCE, str20);
                        i5 |= 512;
                        i4 = 14;
                        c = 7;
                        break;
                    case 10:
                        list6 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 10, (DeserializationStrategy) lazyArr[10].getValue(), list6);
                        i5 |= 1024;
                        i4 = 14;
                        c = 7;
                        break;
                    case 11:
                        str19 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 11, StringSerializer.INSTANCE, str19);
                        i5 |= 2048;
                        i4 = 14;
                        c = 7;
                        break;
                    case DictionaryEntry.PRONUNCIATION /* 12 */:
                        genres2 = (ShazamResponseJson.Track.Genres) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 12, ShazamResponseJson$Track$Genres$$serializer.INSTANCE, genres2);
                        i5 |= 4096;
                        i4 = 14;
                        c = 7;
                        break;
                    case 13:
                        str21 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 13, StringSerializer.INSTANCE, str21);
                        i5 |= 8192;
                        i4 = 14;
                        c = 7;
                        break;
                    case 14:
                        str18 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i4, StringSerializer.INSTANCE, str18);
                        i5 |= 16384;
                        c = 7;
                        break;
                    default:
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                }
            }
            str = str23;
            share = share3;
            list = list5;
            genres = genres2;
            images = images3;
            str2 = str25;
            str3 = str19;
            hub = hub3;
            i = i5;
            str4 = str20;
            str5 = str21;
            list2 = list6;
            str6 = str22;
            str7 = str26;
            str8 = str24;
            str9 = str18;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new ShazamResponseJson.Track(i, str, str6, str7, str8, str2, images, share, hub, list, str4, list2, str3, genres, str5, str9, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, ShazamResponseJson.Track value) {
        encoder.getClass();
        value.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        ShazamResponseJson.Track.write$Self$app(value, compositeEncoderBeginStructure, serialDescriptor);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public /* bridge */ KSerializer[] typeParametersSerializers() {
        return EnumsKt.EMPTY_SERIALIZER_ARRAY;
    }
}
