package com.metrolist.innertubex.models.body;

import com.metrolist.innertubex.models.Context;
import com.metrolist.innertubex.models.Context$$serializer;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.List;
import kotlin.Lazy;
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

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class FeedbackBody$$serializer implements GeneratedSerializer {
    public static final FeedbackBody$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        FeedbackBody$$serializer feedbackBody$$serializer = new FeedbackBody$$serializer();
        INSTANCE = feedbackBody$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertubex.models.body.FeedbackBody", feedbackBody$$serializer, 4);
        pluginGeneratedSerialDescriptor.addElement("context", false);
        pluginGeneratedSerialDescriptor.addElement("feedbackTokens", false);
        pluginGeneratedSerialDescriptor.addElement("isFeedbackTokenUnencrypted", true);
        pluginGeneratedSerialDescriptor.addElement("shouldMerge", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        Lazy[] lazyArr = FeedbackBody.$childSerializers;
        BooleanSerializer booleanSerializer = BooleanSerializer.INSTANCE;
        return new KSerializer[]{Context$$serializer.INSTANCE, lazyArr[1].getValue(), booleanSerializer, booleanSerializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        List list;
        Context context;
        boolean zDecodeBooleanElement;
        boolean z;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = FeedbackBody.$childSerializers;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            Context context2 = (Context) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, Context$$serializer.INSTANCE, null);
            List list2 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), null);
            boolean zDecodeBooleanElement2 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 2);
            list = list2;
            context = context2;
            zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 3);
            z = zDecodeBooleanElement2;
            i = 15;
        } else {
            boolean z2 = true;
            boolean zDecodeBooleanElement3 = false;
            boolean zDecodeBooleanElement4 = false;
            int i2 = 0;
            List list3 = null;
            Context context3 = null;
            while (z2) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z2 = false;
                } else if (iDecodeElementIndex == 0) {
                    context3 = (Context) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, Context$$serializer.INSTANCE, context3);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    list3 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), list3);
                    i2 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    zDecodeBooleanElement4 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 2);
                    i2 |= 4;
                } else {
                    if (iDecodeElementIndex != 3) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    zDecodeBooleanElement3 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 3);
                    i2 |= 8;
                }
            }
            list = list3;
            context = context3;
            zDecodeBooleanElement = zDecodeBooleanElement3;
            z = zDecodeBooleanElement4;
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new FeedbackBody(i, context, list, z, zDecodeBooleanElement);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        FeedbackBody feedbackBody = (FeedbackBody) obj;
        feedbackBody.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = FeedbackBody.$childSerializers;
        Context$$serializer context$$serializer = Context$$serializer.INSTANCE;
        Context context = feedbackBody.context;
        boolean z = feedbackBody.shouldMerge;
        boolean z2 = feedbackBody.isFeedbackTokenUnencrypted;
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 0, context$$serializer, context);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 1, (SerializationStrategy) lazyArr[1].getValue(), feedbackBody.feedbackTokens);
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 2) || z2) {
            compositeEncoderBeginStructure.encodeBooleanElement(serialDescriptor, 2, z2);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 3) || z) {
            compositeEncoderBeginStructure.encodeBooleanElement(serialDescriptor, 3, z);
        }
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
