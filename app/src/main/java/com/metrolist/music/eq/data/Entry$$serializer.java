package com.metrolist.music.eq.data;

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
public final /* synthetic */ class Entry$$serializer implements GeneratedSerializer {
    public static final Entry$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        Entry$$serializer entry$$serializer = new Entry$$serializer();
        INSTANCE = entry$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.music.eq.data.Entry", entry$$serializer, 5);
        pluginGeneratedSerialDescriptor.addElement("label", false);
        pluginGeneratedSerialDescriptor.addElement("form", false);
        pluginGeneratedSerialDescriptor.addElement("rig", false);
        pluginGeneratedSerialDescriptor.addElement("source", false);
        pluginGeneratedSerialDescriptor.addElement("formDirectory", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, stringSerializer, stringSerializer, stringSerializer, stringSerializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        String str;
        String strDecodeStringElement;
        String strDecodeStringElement2;
        String str2;
        String str3;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
            String strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 1);
            String strDecodeStringElement5 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 2);
            str = strDecodeStringElement3;
            strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 3);
            strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 4);
            str2 = strDecodeStringElement5;
            str3 = strDecodeStringElement4;
            i = 31;
        } else {
            boolean z = true;
            int i2 = 0;
            String strDecodeStringElement6 = null;
            String strDecodeStringElement7 = null;
            String strDecodeStringElement8 = null;
            String strDecodeStringElement9 = null;
            String strDecodeStringElement10 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    strDecodeStringElement6 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    strDecodeStringElement10 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 1);
                    i2 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    strDecodeStringElement9 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 2);
                    i2 |= 4;
                } else if (iDecodeElementIndex == 3) {
                    strDecodeStringElement7 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 3);
                    i2 |= 8;
                } else {
                    if (iDecodeElementIndex != 4) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    strDecodeStringElement8 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 4);
                    i2 |= 16;
                }
            }
            str = strDecodeStringElement6;
            strDecodeStringElement = strDecodeStringElement7;
            strDecodeStringElement2 = strDecodeStringElement8;
            str2 = strDecodeStringElement9;
            str3 = strDecodeStringElement10;
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new Entry(i, str, str3, str2, strDecodeStringElement, strDecodeStringElement2);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        Entry entry = (Entry) obj;
        entry.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 0, entry.label);
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 1, entry.form);
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 2, entry.rig);
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 3, entry.source);
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 4, entry.formDirectory);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
