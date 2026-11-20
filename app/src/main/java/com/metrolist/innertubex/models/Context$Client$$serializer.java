package com.metrolist.innertubex.models;

import com.yalantis.ucrop.util.ImageHeaderParser;
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
public final /* synthetic */ class Context$Client$$serializer implements GeneratedSerializer {
    public static final Context$Client$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        Context$Client$$serializer context$Client$$serializer = new Context$Client$$serializer();
        INSTANCE = context$Client$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertubex.models.Context.Client", context$Client$$serializer, 12);
        pluginGeneratedSerialDescriptor.addElement("clientName", false);
        pluginGeneratedSerialDescriptor.addElement("clientVersion", false);
        pluginGeneratedSerialDescriptor.addElement("userAgent", true);
        pluginGeneratedSerialDescriptor.addElement("osName", true);
        pluginGeneratedSerialDescriptor.addElement("osVersion", true);
        pluginGeneratedSerialDescriptor.addElement("deviceMake", true);
        pluginGeneratedSerialDescriptor.addElement("deviceModel", true);
        pluginGeneratedSerialDescriptor.addElement("androidSdkVersion", true);
        pluginGeneratedSerialDescriptor.addElement("platform", true);
        pluginGeneratedSerialDescriptor.addElement("gl", false);
        pluginGeneratedSerialDescriptor.addElement("hl", false);
        pluginGeneratedSerialDescriptor.addElement("visitorData", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, stringSerializer, HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(stringSerializer), stringSerializer, stringSerializer, HexFormatKt.getNullable(stringSerializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        String strDecodeStringElement;
        String str;
        String str2;
        String str3;
        String str4;
        int i;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        int i2 = 11;
        int i3 = 10;
        int i4 = 9;
        int i5 = 7;
        char c = 5;
        String str12 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
            String strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 1);
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            String str13 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, stringSerializer, null);
            String str14 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, stringSerializer, null);
            String str15 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, stringSerializer, null);
            String str16 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, stringSerializer, null);
            String str17 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, stringSerializer, null);
            String str18 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 7, stringSerializer, null);
            String str19 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 8, stringSerializer, null);
            String strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 9);
            String strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 10);
            str8 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 11, stringSerializer, null);
            str9 = strDecodeStringElement4;
            str10 = strDecodeStringElement3;
            str7 = str18;
            str6 = str17;
            str5 = str16;
            str2 = str14;
            str4 = str19;
            str = str15;
            str3 = str13;
            str11 = strDecodeStringElement2;
            i = 4095;
        } else {
            boolean z = true;
            int i6 = 0;
            strDecodeStringElement = null;
            String str20 = null;
            String str21 = null;
            String str22 = null;
            String str23 = null;
            String strDecodeStringElement5 = null;
            String strDecodeStringElement6 = null;
            String str24 = null;
            String str25 = null;
            String str26 = null;
            String strDecodeStringElement7 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case ImageHeaderParser.UNKNOWN_ORIENTATION /* -1 */:
                        z = false;
                        i2 = 11;
                        i3 = 10;
                        i4 = 9;
                        i5 = 7;
                        c = 5;
                        break;
                    case 0:
                        i6 |= 1;
                        strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
                        i2 = 11;
                        i3 = 10;
                        i4 = 9;
                        i5 = 7;
                        c = 5;
                        break;
                    case 1:
                        strDecodeStringElement7 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 1);
                        i6 |= 2;
                        i2 = 11;
                        i3 = 10;
                        i4 = 9;
                        i5 = 7;
                        c = 5;
                        break;
                    case 2:
                        str26 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str26);
                        i6 |= 4;
                        i2 = 11;
                        i3 = 10;
                        i4 = 9;
                        i5 = 7;
                        c = 5;
                        break;
                    case 3:
                        i6 |= 8;
                        str24 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str24);
                        i2 = 11;
                        i3 = 10;
                        i4 = 9;
                        c = 5;
                        break;
                    case 4:
                        i6 |= 16;
                        str25 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str25);
                        i2 = 11;
                        i3 = 10;
                        c = 5;
                        break;
                    case 5:
                        str21 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, str21);
                        i6 |= 32;
                        c = 5;
                        i2 = 11;
                        break;
                    case 6:
                        str22 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, str22);
                        i6 |= 64;
                        c = 5;
                        break;
                    case 7:
                        str23 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i5, StringSerializer.INSTANCE, str23);
                        i6 |= 128;
                        c = 5;
                        break;
                    case 8:
                        str20 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, str20);
                        i6 |= 256;
                        c = 5;
                        break;
                    case 9:
                        strDecodeStringElement6 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, i4);
                        i6 |= 512;
                        c = 5;
                        break;
                    case 10:
                        strDecodeStringElement5 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, i3);
                        i6 |= 1024;
                        c = 5;
                        break;
                    case 11:
                        str12 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i2, StringSerializer.INSTANCE, str12);
                        i6 |= 2048;
                        c = 5;
                        break;
                    default:
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                }
            }
            str = str25;
            str2 = str24;
            str3 = str26;
            str4 = str20;
            i = i6;
            str5 = str21;
            str6 = str22;
            str7 = str23;
            str8 = str12;
            str9 = strDecodeStringElement5;
            str10 = strDecodeStringElement6;
            str11 = strDecodeStringElement7;
        }
        String str27 = strDecodeStringElement;
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new Context.Client(i, str27, str11, str3, str2, str, str5, str6, str7, str4, str10, str9, str8);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        Context.Client client = (Context.Client) obj;
        client.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        String str = client.clientName;
        String str2 = client.platform;
        String str3 = client.androidSdkVersion;
        String str4 = client.deviceModel;
        String str5 = client.deviceMake;
        String str6 = client.osVersion;
        String str7 = client.osName;
        String str8 = client.userAgent;
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 0, str);
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 1, client.clientVersion);
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 2) || str8 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str8);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 3) || str7 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str7);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 4) || str6 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str6);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 5) || str5 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, str5);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 6) || str4 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, str4);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 7) || str3 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, str3);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 8) || str2 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, str2);
        }
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 9, client.gl);
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 10, client.hl);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 11, StringSerializer.INSTANCE, client.visitorData);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
