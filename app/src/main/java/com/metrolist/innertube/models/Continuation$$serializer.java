package com.metrolist.innertube.models;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.Arrays;
import kotlin.text.HexFormatKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.json.JsonNames;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Continuation$$serializer implements GeneratedSerializer {
    public static final Continuation$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        Continuation$$serializer continuation$$serializer = new Continuation$$serializer();
        INSTANCE = continuation$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.Continuation", continuation$$serializer, 1);
        pluginGeneratedSerialDescriptor.addElement("nextContinuationData", false);
        final String[] strArr = {"nextContinuationData", "nextRadioContinuationData"};
        pluginGeneratedSerialDescriptor.pushAnnotation(new JsonNames() { // from class: com.metrolist.innertube.models.Continuation$$serializer$annotationImpl$kotlinx_serialization_json_JsonNames$0
            @Override // java.lang.annotation.Annotation
            public final /* synthetic */ Class annotationType() {
                return JsonNames.class;
            }

            @Override // java.lang.annotation.Annotation
            public final boolean equals(Object obj) {
                return (obj instanceof JsonNames) && Arrays.equals(strArr, ((JsonNames) obj).names());
            }

            @Override // java.lang.annotation.Annotation
            public final int hashCode() {
                return Arrays.hashCode(strArr) ^ 397397176;
            }

            @Override // kotlinx.serialization.json.JsonNames
            public final /* synthetic */ String[] names() {
                return strArr;
            }

            @Override // java.lang.annotation.Annotation
            public final String toString() {
                return IntIntPair$$ExternalSyntheticOutline0.m("@kotlinx.serialization.json.JsonNames(names=", Arrays.toString(strArr), ")");
            }
        });
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{HexFormatKt.getNullable(Continuation$NextContinuationData$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        Continuation.NextContinuationData nextContinuationData;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        int i = 1;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            nextContinuationData = (Continuation.NextContinuationData) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, Continuation$NextContinuationData$$serializer.INSTANCE, null);
        } else {
            boolean z = true;
            int i2 = 0;
            nextContinuationData = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else {
                    if (iDecodeElementIndex != 0) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    nextContinuationData = (Continuation.NextContinuationData) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, Continuation$NextContinuationData$$serializer.INSTANCE, nextContinuationData);
                    i2 = 1;
                }
            }
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new Continuation(i, nextContinuationData);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        Continuation continuation = (Continuation) obj;
        continuation.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, Continuation$NextContinuationData$$serializer.INSTANCE, continuation.nextContinuationData);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
