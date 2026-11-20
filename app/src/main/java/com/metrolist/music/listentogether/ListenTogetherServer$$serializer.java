package com.metrolist.music.listentogether;

import io.ktor.http.ContentDisposition;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
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
public final /* synthetic */ class ListenTogetherServer$$serializer implements GeneratedSerializer {
    public static final ListenTogetherServer$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        ListenTogetherServer$$serializer listenTogetherServer$$serializer = new ListenTogetherServer$$serializer();
        INSTANCE = listenTogetherServer$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.music.listentogether.ListenTogetherServer", listenTogetherServer$$serializer, 4);
        pluginGeneratedSerialDescriptor.addElement(ContentDisposition.Parameters.Name, false);
        pluginGeneratedSerialDescriptor.addElement("url", false);
        pluginGeneratedSerialDescriptor.addElement("location", false);
        pluginGeneratedSerialDescriptor.addElement("operator", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, stringSerializer, stringSerializer, stringSerializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        String str;
        String strDecodeStringElement;
        String str2;
        String str3;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
            String strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 1);
            String strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 2);
            str = strDecodeStringElement2;
            strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 3);
            str2 = strDecodeStringElement4;
            str3 = strDecodeStringElement3;
            i = 15;
        } else {
            String strDecodeStringElement5 = null;
            String strDecodeStringElement6 = null;
            String strDecodeStringElement7 = null;
            String strDecodeStringElement8 = null;
            boolean z = true;
            int i2 = 0;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    strDecodeStringElement5 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    strDecodeStringElement8 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 1);
                    i2 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    strDecodeStringElement7 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 2);
                    i2 |= 4;
                } else {
                    if (iDecodeElementIndex != 3) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    strDecodeStringElement6 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 3);
                    i2 |= 8;
                }
            }
            str = strDecodeStringElement5;
            strDecodeStringElement = strDecodeStringElement6;
            str2 = strDecodeStringElement7;
            str3 = strDecodeStringElement8;
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new ListenTogetherServer(i, str, str3, str2, strDecodeStringElement);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        ListenTogetherServer listenTogetherServer = (ListenTogetherServer) obj;
        listenTogetherServer.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 0, listenTogetherServer.name);
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 1, listenTogetherServer.url);
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 2, listenTogetherServer.location);
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 3, listenTogetherServer.operator);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
