package com.metrolist.innertube.models;

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

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class NavigationEndpoint$ConfirmDialogEndpoint$ConfirmButton$$serializer implements GeneratedSerializer {
    public static final NavigationEndpoint$ConfirmDialogEndpoint$ConfirmButton$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        NavigationEndpoint$ConfirmDialogEndpoint$ConfirmButton$$serializer navigationEndpoint$ConfirmDialogEndpoint$ConfirmButton$$serializer = new NavigationEndpoint$ConfirmDialogEndpoint$ConfirmButton$$serializer();
        INSTANCE = navigationEndpoint$ConfirmDialogEndpoint$ConfirmButton$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.NavigationEndpoint.ConfirmDialogEndpoint.ConfirmButton", navigationEndpoint$ConfirmDialogEndpoint$ConfirmButton$$serializer, 1);
        pluginGeneratedSerialDescriptor.addElement("buttonRenderer", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{HexFormatKt.getNullable(NavigationEndpoint$ConfirmDialogEndpoint$ConfirmButtonRenderer$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        NavigationEndpoint.ConfirmDialogEndpoint.ConfirmButtonRenderer confirmButtonRenderer;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        int i = 1;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            confirmButtonRenderer = (NavigationEndpoint.ConfirmDialogEndpoint.ConfirmButtonRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, NavigationEndpoint$ConfirmDialogEndpoint$ConfirmButtonRenderer$$serializer.INSTANCE, null);
        } else {
            boolean z = true;
            int i2 = 0;
            confirmButtonRenderer = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else {
                    if (iDecodeElementIndex != 0) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    confirmButtonRenderer = (NavigationEndpoint.ConfirmDialogEndpoint.ConfirmButtonRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, NavigationEndpoint$ConfirmDialogEndpoint$ConfirmButtonRenderer$$serializer.INSTANCE, confirmButtonRenderer);
                    i2 = 1;
                }
            }
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new NavigationEndpoint.ConfirmDialogEndpoint.ConfirmButton(i, confirmButtonRenderer);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        NavigationEndpoint.ConfirmDialogEndpoint.ConfirmButton confirmButton = (NavigationEndpoint.ConfirmDialogEndpoint.ConfirmButton) obj;
        confirmButton.getClass();
        NavigationEndpoint.ConfirmDialogEndpoint.ConfirmButtonRenderer confirmButtonRenderer = confirmButton.buttonRenderer;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 0) || confirmButtonRenderer != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, NavigationEndpoint$ConfirmDialogEndpoint$ConfirmButtonRenderer$$serializer.INSTANCE, confirmButtonRenderer);
        }
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
