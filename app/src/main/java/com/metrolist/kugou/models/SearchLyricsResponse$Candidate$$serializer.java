package com.metrolist.kugou.models;

import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SearchLyricsResponse$Candidate$$serializer implements GeneratedSerializer {
    public static final SearchLyricsResponse$Candidate$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        SearchLyricsResponse$Candidate$$serializer searchLyricsResponse$Candidate$$serializer = new SearchLyricsResponse$Candidate$$serializer();
        INSTANCE = searchLyricsResponse$Candidate$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.kugou.models.SearchLyricsResponse.Candidate", searchLyricsResponse$Candidate$$serializer, 4);
        pluginGeneratedSerialDescriptor.addElement("id", false);
        pluginGeneratedSerialDescriptor.addElement("product_from", false);
        pluginGeneratedSerialDescriptor.addElement("duration", false);
        pluginGeneratedSerialDescriptor.addElement("accesskey", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        LongSerializer longSerializer = LongSerializer.INSTANCE;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{longSerializer, stringSerializer, longSerializer, stringSerializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        String str;
        String strDecodeStringElement;
        long j;
        long j2;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            long jDecodeLongElement = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, 0);
            String strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 1);
            long jDecodeLongElement2 = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, 2);
            str = strDecodeStringElement2;
            strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 3);
            j = jDecodeLongElement2;
            j2 = jDecodeLongElement;
            i = 15;
        } else {
            boolean z = true;
            int i2 = 0;
            long jDecodeLongElement3 = 0;
            long jDecodeLongElement4 = 0;
            String strDecodeStringElement3 = null;
            String strDecodeStringElement4 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    jDecodeLongElement4 = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, 0);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 1);
                    i2 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    jDecodeLongElement3 = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, 2);
                    i2 |= 4;
                } else {
                    if (iDecodeElementIndex != 3) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 3);
                    i2 |= 8;
                }
            }
            str = strDecodeStringElement3;
            strDecodeStringElement = strDecodeStringElement4;
            j = jDecodeLongElement3;
            j2 = jDecodeLongElement4;
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new SearchLyricsResponse.Candidate(i, j2, str, j, strDecodeStringElement);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        SearchLyricsResponse.Candidate candidate = (SearchLyricsResponse.Candidate) obj;
        candidate.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeLongElement(serialDescriptor, 0, candidate.id);
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 1, candidate.productFrom);
        compositeEncoderBeginStructure.encodeLongElement(serialDescriptor, 2, candidate.duration);
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 3, candidate.accesskey);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
