package com.metrolist.innertube.models;

import io.ktor.http.ContentType;
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
public final /* synthetic */ class Run$$serializer implements GeneratedSerializer {
    public static final Run$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        Run$$serializer run$$serializer = new Run$$serializer();
        INSTANCE = run$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.Run", run$$serializer, 2);
        pluginGeneratedSerialDescriptor.addElement(ContentType.Text.TYPE, false);
        pluginGeneratedSerialDescriptor.addElement("navigationEndpoint", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{StringSerializer.INSTANCE, HexFormatKt.getNullable(NavigationEndpoint$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        String strDecodeStringElement;
        NavigationEndpoint navigationEndpoint;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
            navigationEndpoint = (NavigationEndpoint) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, NavigationEndpoint$$serializer.INSTANCE, null);
            i = 3;
        } else {
            boolean z = true;
            int i2 = 0;
            strDecodeStringElement = null;
            NavigationEndpoint navigationEndpoint2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
                    i2 |= 1;
                } else {
                    if (iDecodeElementIndex != 1) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    navigationEndpoint2 = (NavigationEndpoint) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, NavigationEndpoint$$serializer.INSTANCE, navigationEndpoint2);
                    i2 |= 2;
                }
            }
            navigationEndpoint = navigationEndpoint2;
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new Run(i, strDecodeStringElement, navigationEndpoint);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        Run run = (Run) obj;
        run.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 0, run.text);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, NavigationEndpoint$$serializer.INSTANCE, run.navigationEndpoint);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
