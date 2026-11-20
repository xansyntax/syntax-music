package com.metrolist.paxsenix.models;

import com.yalantis.ucrop.util.ImageHeaderParser;
import io.ktor.http.ContentType;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.List;
import kotlin.Lazy;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
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
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LyricsContent$$serializer implements GeneratedSerializer {
    public static final LyricsContent$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        LyricsContent$$serializer lyricsContent$$serializer = new LyricsContent$$serializer();
        INSTANCE = lyricsContent$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.paxsenix.models.LyricsContent", lyricsContent$$serializer, 8);
        pluginGeneratedSerialDescriptor.addElement("timestamp", false);
        pluginGeneratedSerialDescriptor.addElement("endtime", false);
        pluginGeneratedSerialDescriptor.addElement("duration", false);
        pluginGeneratedSerialDescriptor.addElement("structure", true);
        pluginGeneratedSerialDescriptor.addElement(ContentType.Text.TYPE, true);
        pluginGeneratedSerialDescriptor.addElement("background", true);
        pluginGeneratedSerialDescriptor.addElement("backgroundText", true);
        pluginGeneratedSerialDescriptor.addElement("oppositeTurn", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        Lazy[] lazyArr = LyricsContent.$childSerializers;
        LongSerializer longSerializer = LongSerializer.INSTANCE;
        BooleanSerializer booleanSerializer = BooleanSerializer.INSTANCE;
        return new KSerializer[]{longSerializer, longSerializer, longSerializer, HexFormatKt.getNullable(StringSerializer.INSTANCE), lazyArr[4].getValue(), booleanSerializer, lazyArr[6].getValue(), booleanSerializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        List list;
        int i;
        List list2;
        String str;
        boolean zDecodeBooleanElement;
        boolean z;
        long j;
        long j2;
        long j3;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = LyricsContent.$childSerializers;
        int i2 = 7;
        int i3 = 0;
        List list3 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            long jDecodeLongElement = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, 0);
            long jDecodeLongElement2 = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, 1);
            long jDecodeLongElement3 = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, 2);
            String str2 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, null);
            List list4 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 4, (DeserializationStrategy) lazyArr[4].getValue(), null);
            boolean zDecodeBooleanElement2 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 5);
            list = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 6, (DeserializationStrategy) lazyArr[6].getValue(), null);
            str = str2;
            zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 7);
            z = zDecodeBooleanElement2;
            list2 = list4;
            i = 255;
            j = jDecodeLongElement2;
            j2 = jDecodeLongElement;
            j3 = jDecodeLongElement3;
        } else {
            boolean z2 = true;
            boolean zDecodeBooleanElement3 = false;
            List list5 = null;
            long jDecodeLongElement4 = 0;
            long jDecodeLongElement5 = 0;
            long jDecodeLongElement6 = 0;
            boolean zDecodeBooleanElement4 = false;
            String str3 = null;
            while (z2) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case ImageHeaderParser.UNKNOWN_ORIENTATION /* -1 */:
                        z2 = false;
                        break;
                    case 0:
                        jDecodeLongElement5 = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, 0);
                        i3 |= 1;
                        break;
                    case 1:
                        jDecodeLongElement4 = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, 1);
                        i3 |= 2;
                        break;
                    case 2:
                        jDecodeLongElement6 = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, 2);
                        i3 |= 4;
                        break;
                    case 3:
                        str3 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str3);
                        i3 |= 8;
                        break;
                    case 4:
                        list3 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 4, (DeserializationStrategy) lazyArr[4].getValue(), list3);
                        i3 |= 16;
                        break;
                    case 5:
                        zDecodeBooleanElement3 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 5);
                        i3 |= 32;
                        break;
                    case 6:
                        list5 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 6, (DeserializationStrategy) lazyArr[6].getValue(), list5);
                        i3 |= 64;
                        break;
                    case 7:
                        zDecodeBooleanElement4 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, i2);
                        i3 |= 128;
                        continue;
                    default:
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                }
                i2 = 7;
            }
            list = list5;
            i = i3;
            list2 = list3;
            str = str3;
            zDecodeBooleanElement = zDecodeBooleanElement4;
            z = zDecodeBooleanElement3;
            j = jDecodeLongElement4;
            j2 = jDecodeLongElement5;
            j3 = jDecodeLongElement6;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new LyricsContent(i, j2, j, j3, str, list2, z, list, zDecodeBooleanElement);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        LyricsContent lyricsContent = (LyricsContent) obj;
        lyricsContent.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = LyricsContent.$childSerializers;
        long j = lyricsContent.timestamp;
        boolean z = lyricsContent.oppositeTurn;
        List list = lyricsContent.backgroundText;
        boolean z2 = lyricsContent.background;
        List list2 = lyricsContent.text;
        String str = lyricsContent.structure;
        compositeEncoderBeginStructure.encodeLongElement(serialDescriptor, 0, j);
        compositeEncoderBeginStructure.encodeLongElement(serialDescriptor, 1, lyricsContent.endtime);
        compositeEncoderBeginStructure.encodeLongElement(serialDescriptor, 2, lyricsContent.duration);
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 3) || str != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str);
        }
        boolean zShouldEncodeElementDefault = compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 4);
        EmptyList emptyList = EmptyList.INSTANCE;
        if (zShouldEncodeElementDefault || !Intrinsics.areEqual(list2, emptyList)) {
            compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 4, (SerializationStrategy) lazyArr[4].getValue(), list2);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 5) || z2) {
            compositeEncoderBeginStructure.encodeBooleanElement(serialDescriptor, 5, z2);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 6) || !Intrinsics.areEqual(list, emptyList)) {
            compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 6, (SerializationStrategy) lazyArr[6].getValue(), list);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 7) || z) {
            compositeEncoderBeginStructure.encodeBooleanElement(serialDescriptor, 7, z);
        }
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
