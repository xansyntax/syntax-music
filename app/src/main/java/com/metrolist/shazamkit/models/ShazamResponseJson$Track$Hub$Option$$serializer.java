package com.metrolist.shazamkit.models;

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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006H\u0086\u0080\u0004¢\u0006\u0002\u0010\bJ\u0012\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0086\u0080\u0004J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0086\u0080\u0004R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014Ê\u0001\u0018\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\n\b\u0019\u0012\u0006\b\n0\u001a8\u001bÊ\u0001\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0015"}, d2 = {"com/metrolist/shazamkit/models/ShazamResponseJson.Track.Hub.Option.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/metrolist/shazamkit/models/ShazamResponseJson$Track$Hub$Option;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "app", "Lkotlin/Deprecated;", ContentType.Message.TYPE, "This synthesized declaration should not be used directly", "level", "Lkotlin/DeprecationLevel;", "HIDDEN", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Deprecated
public final /* synthetic */ class ShazamResponseJson$Track$Hub$Option$$serializer implements GeneratedSerializer {
    public static final int $stable = 0;
    public static final ShazamResponseJson$Track$Hub$Option$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        ShazamResponseJson$Track$Hub$Option$$serializer shazamResponseJson$Track$Hub$Option$$serializer = new ShazamResponseJson$Track$Hub$Option$$serializer();
        INSTANCE = shazamResponseJson$Track$Hub$Option$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.shazamkit.models.ShazamResponseJson.Track.Hub.Option", shazamResponseJson$Track$Hub$Option$$serializer, 9);
        pluginGeneratedSerialDescriptor.addElement("caption", true);
        pluginGeneratedSerialDescriptor.addElement("actions", true);
        pluginGeneratedSerialDescriptor.addElement("beacondata", true);
        pluginGeneratedSerialDescriptor.addElement(ContentType.Image.TYPE, true);
        pluginGeneratedSerialDescriptor.addElement(LinkHeader.Parameters.Type, true);
        pluginGeneratedSerialDescriptor.addElement("listcaption", true);
        pluginGeneratedSerialDescriptor.addElement("overflowimage", true);
        pluginGeneratedSerialDescriptor.addElement("colouroverflowimage", true);
        pluginGeneratedSerialDescriptor.addElement("providername", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ShazamResponseJson$Track$Hub$Option$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        Lazy[] lazyArr = ShazamResponseJson.Track.Hub.Option.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable((KSerializer) lazyArr[1].getValue()), HexFormatKt.getNullable(ShazamResponseJson$Track$Hub$Option$Beacondata$$serializer.INSTANCE), HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(BooleanSerializer.INSTANCE), HexFormatKt.getNullable(stringSerializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final ShazamResponseJson.Track.Hub.Option deserialize(Decoder decoder) {
        List list;
        ShazamResponseJson.Track.Hub.Option.Beacondata beacondata;
        String str;
        String str2;
        int i;
        String str3;
        String str4;
        String str5;
        String str6;
        Boolean bool;
        decoder.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = ShazamResponseJson.Track.Hub.Option.$childSerializers;
        int i2 = 7;
        int i3 = 6;
        int i4 = 5;
        char c = 4;
        String str7 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            String str8 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, stringSerializer, null);
            List list2 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), null);
            ShazamResponseJson.Track.Hub.Option.Beacondata beacondata2 = (ShazamResponseJson.Track.Hub.Option.Beacondata) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, ShazamResponseJson$Track$Hub$Option$Beacondata$$serializer.INSTANCE, null);
            String str9 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, stringSerializer, null);
            String str10 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, stringSerializer, null);
            String str11 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, stringSerializer, null);
            String str12 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, stringSerializer, null);
            Boolean bool2 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 7, BooleanSerializer.INSTANCE, null);
            list = list2;
            str6 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 8, stringSerializer, null);
            bool = bool2;
            str5 = str12;
            str4 = str11;
            str3 = str9;
            i = 511;
            str2 = str10;
            beacondata = beacondata2;
            str = str8;
        } else {
            int i5 = 1;
            boolean z = true;
            int i6 = 0;
            List list3 = null;
            String str13 = null;
            String str14 = null;
            String str15 = null;
            String str16 = null;
            Boolean bool3 = null;
            ShazamResponseJson.Track.Hub.Option.Beacondata beacondata3 = null;
            String str17 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case ImageHeaderParser.UNKNOWN_ORIENTATION /* -1 */:
                        z = false;
                        i2 = 7;
                        i3 = 6;
                        i4 = 5;
                        i5 = 1;
                        break;
                    case 0:
                        str17 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str17);
                        i6 |= 1;
                        i2 = 7;
                        i3 = 6;
                        i4 = 5;
                        c = 4;
                        i5 = 1;
                        break;
                    case 1:
                        list3 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i5, (DeserializationStrategy) lazyArr[i5].getValue(), list3);
                        i6 |= 2;
                        i2 = 7;
                        i3 = 6;
                        c = 4;
                        break;
                    case 2:
                        beacondata3 = (ShazamResponseJson.Track.Hub.Option.Beacondata) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, ShazamResponseJson$Track$Hub$Option$Beacondata$$serializer.INSTANCE, beacondata3);
                        i6 |= 4;
                        i2 = 7;
                        i3 = 6;
                        c = 4;
                        break;
                    case 3:
                        str14 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str14);
                        i6 |= 8;
                        i2 = 7;
                        c = 4;
                        break;
                    case 4:
                        str13 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str13);
                        i6 |= 16;
                        c = 4;
                        i2 = 7;
                        break;
                    case 5:
                        str15 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i4, StringSerializer.INSTANCE, str15);
                        i6 |= 32;
                        c = 4;
                        break;
                    case 6:
                        str7 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i3, StringSerializer.INSTANCE, str7);
                        i6 |= 64;
                        c = 4;
                        break;
                    case 7:
                        bool3 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i2, BooleanSerializer.INSTANCE, bool3);
                        i6 |= 128;
                        c = 4;
                        break;
                    case 8:
                        str16 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, str16);
                        i6 |= 256;
                        c = 4;
                        break;
                    default:
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                }
            }
            list = list3;
            beacondata = beacondata3;
            str = str17;
            str2 = str13;
            i = i6;
            str3 = str14;
            str4 = str15;
            str5 = str7;
            str6 = str16;
            bool = bool3;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new ShazamResponseJson.Track.Hub.Option(i, str, list, beacondata, str3, str2, str4, str5, bool, str6, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, ShazamResponseJson.Track.Hub.Option value) {
        encoder.getClass();
        value.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        ShazamResponseJson.Track.Hub.Option.write$Self$app(value, compositeEncoderBeginStructure, serialDescriptor);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public /* bridge */ KSerializer[] typeParametersSerializers() {
        return EnumsKt.EMPTY_SERIALIZER_ARRAY;
    }
}
