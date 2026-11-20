package com.metrolist.lrclib.models;

import com.yalantis.ucrop.util.ImageHeaderParser;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlin.text.HexFormatKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Track$$serializer implements GeneratedSerializer {
    public static final Track$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        Track$$serializer track$$serializer = new Track$$serializer();
        INSTANCE = track$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.lrclib.models.Track", track$$serializer, 6);
        pluginGeneratedSerialDescriptor.addElement("id", false);
        pluginGeneratedSerialDescriptor.addElement("trackName", false);
        pluginGeneratedSerialDescriptor.addElement("artistName", false);
        pluginGeneratedSerialDescriptor.addElement("duration", false);
        pluginGeneratedSerialDescriptor.addElement("plainLyrics", false);
        pluginGeneratedSerialDescriptor.addElement("syncedLyrics", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{IntSerializer.INSTANCE, stringSerializer, stringSerializer, DoubleSerializer.INSTANCE, HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(stringSerializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        int iDecodeIntElement;
        String str;
        int i;
        String str2;
        String str3;
        String str4;
        double d;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Object obj = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            iDecodeIntElement = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 0);
            String strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 1);
            String strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 2);
            double dDecodeDoubleElement = compositeDecoderBeginStructure.decodeDoubleElement(serialDescriptor, 3);
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            String str5 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, stringSerializer, null);
            str = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, stringSerializer, null);
            i = 63;
            str2 = str5;
            str3 = strDecodeStringElement2;
            str4 = strDecodeStringElement;
            d = dDecodeDoubleElement;
        } else {
            boolean z = true;
            iDecodeIntElement = 0;
            String str6 = null;
            String strDecodeStringElement3 = null;
            String strDecodeStringElement4 = null;
            double dDecodeDoubleElement2 = 0.0d;
            int i2 = 0;
            String str7 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case ImageHeaderParser.UNKNOWN_ORIENTATION /* -1 */:
                        z = false;
                        continue;
                    case 0:
                        iDecodeIntElement = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 0);
                        i2 |= 1;
                        break;
                    case 1:
                        strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 1);
                        i2 |= 2;
                        break;
                    case 2:
                        strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 2);
                        i2 |= 4;
                        break;
                    case 3:
                        dDecodeDoubleElement2 = compositeDecoderBeginStructure.decodeDoubleElement(serialDescriptor, 3);
                        i2 |= 8;
                        break;
                    case 4:
                        str6 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str6);
                        i2 |= 16;
                        break;
                    case 5:
                        str7 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, str7);
                        i2 |= 32;
                        break;
                    default:
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return obj;
                }
                obj = null;
            }
            str = str7;
            i = i2;
            str2 = str6;
            str3 = strDecodeStringElement3;
            str4 = strDecodeStringElement4;
            d = dDecodeDoubleElement2;
        }
        int i3 = iDecodeIntElement;
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new Track(i, i3, str4, str3, d, str2, str);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        Track track = (Track) obj;
        track.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeIntElement(serialDescriptor, 0, track.id);
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 1, track.trackName);
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 2, track.artistName);
        compositeEncoderBeginStructure.encodeDoubleElement(serialDescriptor, 3, track.duration);
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 4, stringSerializer, track.plainLyrics);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 5, stringSerializer, track.syncedLyrics);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
