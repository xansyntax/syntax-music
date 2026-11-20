package com.metrolist.innertubex.models;

import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.yalantis.ucrop.util.ImageHeaderParser;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import io.ktor.utils.io.ByteChannelKt;
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
public final /* synthetic */ class YouTubeClient$$serializer implements GeneratedSerializer {
    public static final YouTubeClient$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        YouTubeClient$$serializer youTubeClient$$serializer = new YouTubeClient$$serializer();
        INSTANCE = youTubeClient$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertubex.models.YouTubeClient", youTubeClient$$serializer, 25);
        pluginGeneratedSerialDescriptor.addElement("clientName", false);
        pluginGeneratedSerialDescriptor.addElement("clientVersion", false);
        pluginGeneratedSerialDescriptor.addElement("clientId", false);
        pluginGeneratedSerialDescriptor.addElement("userAgent", false);
        pluginGeneratedSerialDescriptor.addElement("osName", true);
        pluginGeneratedSerialDescriptor.addElement("osVersion", true);
        pluginGeneratedSerialDescriptor.addElement("deviceMake", true);
        pluginGeneratedSerialDescriptor.addElement("deviceModel", true);
        pluginGeneratedSerialDescriptor.addElement("androidSdkVersion", true);
        pluginGeneratedSerialDescriptor.addElement("platform", true);
        pluginGeneratedSerialDescriptor.addElement("buildId", true);
        pluginGeneratedSerialDescriptor.addElement("cronetVersion", true);
        pluginGeneratedSerialDescriptor.addElement("packageName", true);
        pluginGeneratedSerialDescriptor.addElement("friendlyName", true);
        pluginGeneratedSerialDescriptor.addElement("loginSupported", true);
        pluginGeneratedSerialDescriptor.addElement("loginRequired", true);
        pluginGeneratedSerialDescriptor.addElement("useSignatureTimestamp", true);
        pluginGeneratedSerialDescriptor.addElement("isEmbedded", true);
        pluginGeneratedSerialDescriptor.addElement("useWebPoTokens", true);
        pluginGeneratedSerialDescriptor.addElement("requirePoToken", true);
        pluginGeneratedSerialDescriptor.addElement("poTokenBinding", true);
        pluginGeneratedSerialDescriptor.addElement("includeUserAgentInContext", true);
        pluginGeneratedSerialDescriptor.addElement("useSabr", true);
        pluginGeneratedSerialDescriptor.addElement("useMusicPlayerEndpoint", true);
        pluginGeneratedSerialDescriptor.addElement("skipPlayerResponseValidation", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        Lazy[] lazyArr = YouTubeClient.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        BooleanSerializer booleanSerializer = BooleanSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, stringSerializer, stringSerializer, stringSerializer, HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(stringSerializer), booleanSerializer, booleanSerializer, booleanSerializer, booleanSerializer, booleanSerializer, booleanSerializer, lazyArr[20].getValue(), booleanSerializer, booleanSerializer, booleanSerializer, booleanSerializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        String str;
        String str2;
        String str3;
        String str4;
        int i;
        String str5;
        String str6;
        String str7;
        String str8;
        PoTokenBinding poTokenBinding;
        String str9;
        String str10;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean zDecodeBooleanElement;
        String str11;
        boolean z5;
        boolean z6;
        String str12;
        String str13;
        String str14;
        boolean z7;
        boolean zDecodeBooleanElement2;
        boolean z8;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = YouTubeClient.$childSerializers;
        int i2 = 10;
        int i3 = 9;
        char c = '\b';
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
            String strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 1);
            String strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 2);
            String strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 3);
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            String str15 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, stringSerializer, null);
            String str16 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, stringSerializer, null);
            String str17 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, stringSerializer, null);
            String str18 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 7, stringSerializer, null);
            String str19 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 8, stringSerializer, null);
            String str20 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 9, stringSerializer, null);
            String str21 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 10, stringSerializer, null);
            String str22 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 11, stringSerializer, null);
            String str23 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 12, stringSerializer, null);
            String str24 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 13, stringSerializer, null);
            boolean zDecodeBooleanElement3 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 14);
            boolean zDecodeBooleanElement4 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 15);
            boolean zDecodeBooleanElement5 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 16);
            boolean zDecodeBooleanElement6 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 17);
            boolean zDecodeBooleanElement7 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 18);
            boolean zDecodeBooleanElement8 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 19);
            PoTokenBinding poTokenBinding2 = (PoTokenBinding) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 20, (DeserializationStrategy) lazyArr[20].getValue(), null);
            boolean zDecodeBooleanElement9 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 21);
            boolean zDecodeBooleanElement10 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 22);
            z7 = zDecodeBooleanElement3;
            zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 23);
            z5 = zDecodeBooleanElement9;
            z6 = zDecodeBooleanElement10;
            str7 = str20;
            str8 = str18;
            str6 = str17;
            str3 = str16;
            str12 = strDecodeStringElement4;
            str5 = str19;
            str4 = str15;
            str13 = strDecodeStringElement3;
            str14 = strDecodeStringElement2;
            zDecodeBooleanElement2 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 24);
            z8 = zDecodeBooleanElement4;
            poTokenBinding = poTokenBinding2;
            i = 33554431;
            str11 = strDecodeStringElement;
            z3 = zDecodeBooleanElement7;
            z2 = zDecodeBooleanElement6;
            z = zDecodeBooleanElement5;
            str = str24;
            z4 = zDecodeBooleanElement8;
            str9 = str21;
            str10 = str23;
            str2 = str22;
        } else {
            int i4 = 24;
            int i5 = 0;
            boolean zDecodeBooleanElement11 = false;
            boolean zDecodeBooleanElement12 = false;
            boolean zDecodeBooleanElement13 = false;
            boolean zDecodeBooleanElement14 = false;
            boolean zDecodeBooleanElement15 = false;
            boolean zDecodeBooleanElement16 = false;
            boolean zDecodeBooleanElement17 = false;
            boolean zDecodeBooleanElement18 = false;
            boolean zDecodeBooleanElement19 = false;
            boolean zDecodeBooleanElement20 = false;
            boolean z9 = true;
            String str25 = null;
            String str26 = null;
            String str27 = null;
            String str28 = null;
            String str29 = null;
            String str30 = null;
            PoTokenBinding poTokenBinding3 = null;
            String str31 = null;
            String str32 = null;
            String strDecodeStringElement5 = null;
            String str33 = null;
            String strDecodeStringElement6 = null;
            String str34 = null;
            String strDecodeStringElement7 = null;
            String strDecodeStringElement8 = null;
            while (z9) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case ImageHeaderParser.UNKNOWN_ORIENTATION /* -1 */:
                        z9 = false;
                        i2 = 10;
                        i3 = 9;
                        c = '\b';
                        i4 = 24;
                        break;
                    case 0:
                        strDecodeStringElement5 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
                        i5 |= 1;
                        i2 = 10;
                        i3 = 9;
                        c = '\b';
                        i4 = 24;
                        break;
                    case 1:
                        strDecodeStringElement8 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 1);
                        i5 |= 2;
                        i2 = 10;
                        i3 = 9;
                        c = '\b';
                        i4 = 24;
                        break;
                    case 2:
                        strDecodeStringElement7 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 2);
                        i5 |= 4;
                        i2 = 10;
                        i3 = 9;
                        c = '\b';
                        i4 = 24;
                        break;
                    case 3:
                        strDecodeStringElement6 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 3);
                        i5 |= 8;
                        i2 = 10;
                        i3 = 9;
                        c = '\b';
                        i4 = 24;
                        break;
                    case 4:
                        str34 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str34);
                        i5 |= 16;
                        i2 = 10;
                        i3 = 9;
                        c = '\b';
                        i4 = 24;
                        break;
                    case 5:
                        str33 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, str33);
                        i5 |= 32;
                        i2 = 10;
                        i3 = 9;
                        c = '\b';
                        i4 = 24;
                        break;
                    case 6:
                        str28 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, str28);
                        i5 |= 64;
                        i2 = 10;
                        c = '\b';
                        i4 = 24;
                        break;
                    case 7:
                        str30 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, str30);
                        i5 |= 128;
                        i2 = 10;
                        c = '\b';
                        i4 = 24;
                        break;
                    case 8:
                        str27 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, str27);
                        i5 |= 256;
                        c = '\b';
                        i2 = 10;
                        i4 = 24;
                        break;
                    case 9:
                        str29 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i3, StringSerializer.INSTANCE, str29);
                        i5 |= 512;
                        c = '\b';
                        i4 = 24;
                        break;
                    case 10:
                        str31 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i2, StringSerializer.INSTANCE, str31);
                        i5 |= 1024;
                        c = '\b';
                        i4 = 24;
                        break;
                    case 11:
                        str26 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 11, StringSerializer.INSTANCE, str26);
                        i5 |= 2048;
                        c = '\b';
                        i4 = 24;
                        break;
                    case DictionaryEntry.PRONUNCIATION /* 12 */:
                        str32 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 12, StringSerializer.INSTANCE, str32);
                        i5 |= 4096;
                        c = '\b';
                        i4 = 24;
                        break;
                    case 13:
                        str25 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 13, StringSerializer.INSTANCE, str25);
                        i5 |= 8192;
                        c = '\b';
                        i4 = 24;
                        break;
                    case 14:
                        zDecodeBooleanElement18 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 14);
                        i5 |= 16384;
                        c = '\b';
                        i4 = 24;
                        break;
                    case 15:
                        zDecodeBooleanElement20 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 15);
                        i5 |= 32768;
                        c = '\b';
                        i4 = 24;
                        break;
                    case 16:
                        zDecodeBooleanElement11 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 16);
                        i5 |= 65536;
                        c = '\b';
                        i4 = 24;
                        break;
                    case 17:
                        zDecodeBooleanElement12 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 17);
                        i5 |= 131072;
                        c = '\b';
                        i4 = 24;
                        break;
                    case 18:
                        zDecodeBooleanElement13 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 18);
                        i5 |= 262144;
                        c = '\b';
                        i4 = 24;
                        break;
                    case 19:
                        zDecodeBooleanElement14 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 19);
                        i5 |= 524288;
                        c = '\b';
                        i4 = 24;
                        break;
                    case 20:
                        poTokenBinding3 = (PoTokenBinding) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 20, (DeserializationStrategy) lazyArr[20].getValue(), poTokenBinding3);
                        i5 |= ByteChannelKt.CHANNEL_MAX_SIZE;
                        c = '\b';
                        i4 = 24;
                        break;
                    case 21:
                        zDecodeBooleanElement16 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 21);
                        i5 |= 2097152;
                        i4 = 24;
                        break;
                    case 22:
                        zDecodeBooleanElement17 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 22);
                        i5 |= 4194304;
                        i4 = 24;
                        break;
                    case 23:
                        zDecodeBooleanElement15 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 23);
                        i5 |= 8388608;
                        i4 = 24;
                        break;
                    case 24:
                        zDecodeBooleanElement19 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, i4);
                        i5 |= 16777216;
                        break;
                    default:
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                }
            }
            str = str25;
            str2 = str26;
            str3 = str33;
            str4 = str34;
            i = i5;
            str5 = str27;
            str6 = str28;
            str7 = str29;
            str8 = str30;
            poTokenBinding = poTokenBinding3;
            str9 = str31;
            str10 = str32;
            z = zDecodeBooleanElement11;
            z2 = zDecodeBooleanElement12;
            z3 = zDecodeBooleanElement13;
            z4 = zDecodeBooleanElement14;
            zDecodeBooleanElement = zDecodeBooleanElement15;
            str11 = strDecodeStringElement5;
            z5 = zDecodeBooleanElement16;
            z6 = zDecodeBooleanElement17;
            str12 = strDecodeStringElement6;
            str13 = strDecodeStringElement7;
            str14 = strDecodeStringElement8;
            z7 = zDecodeBooleanElement18;
            zDecodeBooleanElement2 = zDecodeBooleanElement19;
            z8 = zDecodeBooleanElement20;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new YouTubeClient(i, str11, str14, str13, str12, str4, str3, str6, str8, str5, str7, str9, str2, str10, str, z7, z8, z, z2, z3, z4, poTokenBinding, z5, z6, zDecodeBooleanElement, zDecodeBooleanElement2);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x019d  */
    /* JADX WARN: Code duplicated, block: B:107:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:113:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:95:0x018c  */
    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        PoTokenBinding poTokenBinding;
        YouTubeClient youTubeClient = (YouTubeClient) obj;
        youTubeClient.getClass();
        boolean z = youTubeClient.skipPlayerResponseValidation;
        boolean z2 = youTubeClient.useMusicPlayerEndpoint;
        boolean z3 = youTubeClient.useSabr;
        boolean z4 = youTubeClient.includeUserAgentInContext;
        PoTokenBinding poTokenBinding2 = youTubeClient.poTokenBinding;
        boolean z5 = youTubeClient.requirePoToken;
        boolean z6 = youTubeClient.useWebPoTokens;
        boolean z7 = youTubeClient.isEmbedded;
        boolean z8 = youTubeClient.useSignatureTimestamp;
        boolean z9 = youTubeClient.loginRequired;
        boolean z10 = youTubeClient.loginSupported;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = YouTubeClient.$childSerializers;
        String str = youTubeClient.clientName;
        String str2 = youTubeClient.friendlyName;
        String str3 = youTubeClient.packageName;
        String str4 = youTubeClient.cronetVersion;
        String str5 = youTubeClient.buildId;
        String str6 = youTubeClient.platform;
        String str7 = youTubeClient.androidSdkVersion;
        String str8 = youTubeClient.deviceModel;
        String str9 = youTubeClient.deviceMake;
        String str10 = youTubeClient.osVersion;
        String str11 = youTubeClient.osName;
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 0, str);
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 1, youTubeClient.clientVersion);
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 2, youTubeClient.clientId);
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 3, youTubeClient.userAgent);
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 4) || str11 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str11);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 5) || str10 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, str10);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 6) || str9 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, str9);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 7) || str8 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, str8);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 8) || str7 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, str7);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 9) || str6 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 9, StringSerializer.INSTANCE, str6);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 10) || str5 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 10, StringSerializer.INSTANCE, str5);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 11) || str4 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 11, StringSerializer.INSTANCE, str4);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 12) || str3 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 12, StringSerializer.INSTANCE, str3);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 13) || str2 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 13, StringSerializer.INSTANCE, str2);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 14) || z10) {
            compositeEncoderBeginStructure.encodeBooleanElement(serialDescriptor, 14, z10);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 15) || z9) {
            compositeEncoderBeginStructure.encodeBooleanElement(serialDescriptor, 15, z9);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 16) || z8) {
            compositeEncoderBeginStructure.encodeBooleanElement(serialDescriptor, 16, z8);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 17) || z7) {
            compositeEncoderBeginStructure.encodeBooleanElement(serialDescriptor, 17, z7);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 18) || z6) {
            compositeEncoderBeginStructure.encodeBooleanElement(serialDescriptor, 18, z6);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 19) || z5) {
            compositeEncoderBeginStructure.encodeBooleanElement(serialDescriptor, 19, z5);
        }
        if (!compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 20)) {
            poTokenBinding = poTokenBinding2;
            if (poTokenBinding != PoTokenBinding.VIDEO_ID) {
            }
            if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 21) || z4) {
                compositeEncoderBeginStructure.encodeBooleanElement(serialDescriptor, 21, z4);
            }
            if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 22) || z3) {
                compositeEncoderBeginStructure.encodeBooleanElement(serialDescriptor, 22, z3);
            }
            if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 23) || z2) {
                compositeEncoderBeginStructure.encodeBooleanElement(serialDescriptor, 23, z2);
            }
            if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 24) || z) {
                compositeEncoderBeginStructure.encodeBooleanElement(serialDescriptor, 24, z);
            }
            compositeEncoderBeginStructure.endStructure(serialDescriptor);
        }
        poTokenBinding = poTokenBinding2;
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 20, (SerializationStrategy) lazyArr[20].getValue(), poTokenBinding);
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 21)) {
            compositeEncoderBeginStructure.encodeBooleanElement(serialDescriptor, 21, z4);
        } else {
            compositeEncoderBeginStructure.encodeBooleanElement(serialDescriptor, 21, z4);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 22)) {
            compositeEncoderBeginStructure.encodeBooleanElement(serialDescriptor, 22, z3);
        } else {
            compositeEncoderBeginStructure.encodeBooleanElement(serialDescriptor, 22, z3);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 23)) {
            compositeEncoderBeginStructure.encodeBooleanElement(serialDescriptor, 23, z2);
        } else {
            compositeEncoderBeginStructure.encodeBooleanElement(serialDescriptor, 23, z2);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 24)) {
            compositeEncoderBeginStructure.encodeBooleanElement(serialDescriptor, 24, z);
        } else {
            compositeEncoderBeginStructure.encodeBooleanElement(serialDescriptor, 24, z);
        }
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
