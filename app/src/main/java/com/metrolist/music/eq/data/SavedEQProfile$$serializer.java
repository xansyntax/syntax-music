package com.metrolist.music.eq.data;

import com.yalantis.ucrop.util.ImageHeaderParser;
import io.ktor.http.ContentDisposition;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SavedEQProfile$$serializer implements GeneratedSerializer {
    public static final SavedEQProfile$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        SavedEQProfile$$serializer savedEQProfile$$serializer = new SavedEQProfile$$serializer();
        INSTANCE = savedEQProfile$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.music.eq.data.SavedEQProfile", savedEQProfile$$serializer, 10);
        pluginGeneratedSerialDescriptor.addElement("id", false);
        pluginGeneratedSerialDescriptor.addElement(ContentDisposition.Parameters.Name, false);
        pluginGeneratedSerialDescriptor.addElement("deviceModel", false);
        pluginGeneratedSerialDescriptor.addElement("bands", false);
        pluginGeneratedSerialDescriptor.addElement("preamp", true);
        pluginGeneratedSerialDescriptor.addElement("source", true);
        pluginGeneratedSerialDescriptor.addElement("rig", true);
        pluginGeneratedSerialDescriptor.addElement("isCustom", true);
        pluginGeneratedSerialDescriptor.addElement("isActive", true);
        pluginGeneratedSerialDescriptor.addElement("addedTimestamp", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        Lazy[] lazyArr = SavedEQProfile.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        BooleanSerializer booleanSerializer = BooleanSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, stringSerializer, stringSerializer, lazyArr[3].getValue(), DoubleSerializer.INSTANCE, stringSerializer, stringSerializer, booleanSerializer, booleanSerializer, LongSerializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        List list;
        int i;
        String str;
        boolean zDecodeBooleanElement;
        String str2;
        String str3;
        boolean zDecodeBooleanElement2;
        String str4;
        String str5;
        double d;
        long jDecodeLongElement;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = SavedEQProfile.$childSerializers;
        int i2 = 9;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
            String strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 1);
            String strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 2);
            List list2 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 3, (DeserializationStrategy) lazyArr[3].getValue(), null);
            double dDecodeDoubleElement = compositeDecoderBeginStructure.decodeDoubleElement(serialDescriptor, 4);
            String strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 5);
            String strDecodeStringElement5 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 6);
            list = list2;
            str = strDecodeStringElement;
            i = 1023;
            zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 7);
            str2 = strDecodeStringElement5;
            str3 = strDecodeStringElement4;
            zDecodeBooleanElement2 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 8);
            str4 = strDecodeStringElement3;
            str5 = strDecodeStringElement2;
            d = dDecodeDoubleElement;
            jDecodeLongElement = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, 9);
        } else {
            boolean z = true;
            boolean zDecodeBooleanElement3 = false;
            List list3 = null;
            String strDecodeStringElement6 = null;
            String strDecodeStringElement7 = null;
            double dDecodeDoubleElement2 = 0.0d;
            long jDecodeLongElement2 = 0;
            int i3 = 0;
            boolean zDecodeBooleanElement4 = false;
            String strDecodeStringElement8 = null;
            String strDecodeStringElement9 = null;
            String strDecodeStringElement10 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case ImageHeaderParser.UNKNOWN_ORIENTATION /* -1 */:
                        z = false;
                        continue;
                    case 0:
                        strDecodeStringElement8 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
                        i3 |= 1;
                        break;
                    case 1:
                        strDecodeStringElement7 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 1);
                        i3 |= 2;
                        break;
                    case 2:
                        strDecodeStringElement6 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 2);
                        i3 |= 4;
                        break;
                    case 3:
                        list3 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 3, (DeserializationStrategy) lazyArr[3].getValue(), list3);
                        i3 |= 8;
                        break;
                    case 4:
                        dDecodeDoubleElement2 = compositeDecoderBeginStructure.decodeDoubleElement(serialDescriptor, 4);
                        i3 |= 16;
                        continue;
                    case 5:
                        strDecodeStringElement10 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 5);
                        i3 |= 32;
                        continue;
                    case 6:
                        strDecodeStringElement9 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 6);
                        i3 |= 64;
                        continue;
                    case 7:
                        zDecodeBooleanElement4 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 7);
                        i3 |= 128;
                        continue;
                    case 8:
                        zDecodeBooleanElement3 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 8);
                        i3 |= 256;
                        continue;
                    case 9:
                        jDecodeLongElement2 = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, i2);
                        i3 |= 512;
                        continue;
                    default:
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                }
                i2 = 9;
            }
            list = list3;
            i = i3;
            str = strDecodeStringElement8;
            zDecodeBooleanElement = zDecodeBooleanElement4;
            str2 = strDecodeStringElement9;
            str3 = strDecodeStringElement10;
            zDecodeBooleanElement2 = zDecodeBooleanElement3;
            str4 = strDecodeStringElement6;
            str5 = strDecodeStringElement7;
            d = dDecodeDoubleElement2;
            jDecodeLongElement = jDecodeLongElement2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new SavedEQProfile(i, str, str5, str4, list, d, str3, str2, zDecodeBooleanElement, zDecodeBooleanElement2, jDecodeLongElement);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        SavedEQProfile savedEQProfile = (SavedEQProfile) obj;
        savedEQProfile.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = SavedEQProfile.$childSerializers;
        String str = savedEQProfile.id;
        long j = savedEQProfile.addedTimestamp;
        boolean z = savedEQProfile.isActive;
        boolean z2 = savedEQProfile.isCustom;
        String str2 = savedEQProfile.rig;
        String str3 = savedEQProfile.source;
        double d = savedEQProfile.preamp;
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 0, str);
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 1, savedEQProfile.name);
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 2, savedEQProfile.deviceModel);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 3, (SerializationStrategy) lazyArr[3].getValue(), savedEQProfile.bands);
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 4) || Double.compare(d, 0.0d) != 0) {
            compositeEncoderBeginStructure.encodeDoubleElement(serialDescriptor, 4, d);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 5) || !Intrinsics.areEqual(str3, "unknown")) {
            compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 5, str3);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 6) || !Intrinsics.areEqual(str2, "unknown")) {
            compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 6, str2);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 7) || z2) {
            compositeEncoderBeginStructure.encodeBooleanElement(serialDescriptor, 7, z2);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 8) || z) {
            compositeEncoderBeginStructure.encodeBooleanElement(serialDescriptor, 8, z);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 9) || j != System.currentTimeMillis()) {
            compositeEncoderBeginStructure.encodeLongElement(serialDescriptor, 9, j);
        }
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
