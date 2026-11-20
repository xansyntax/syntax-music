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
public final /* synthetic */ class NavigationEndpoint$ConfirmDialogEndpoint$ConfirmDialogRenderer$$serializer implements GeneratedSerializer {
    public static final NavigationEndpoint$ConfirmDialogEndpoint$ConfirmDialogRenderer$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        NavigationEndpoint$ConfirmDialogEndpoint$ConfirmDialogRenderer$$serializer navigationEndpoint$ConfirmDialogEndpoint$ConfirmDialogRenderer$$serializer = new NavigationEndpoint$ConfirmDialogEndpoint$ConfirmDialogRenderer$$serializer();
        INSTANCE = navigationEndpoint$ConfirmDialogEndpoint$ConfirmDialogRenderer$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.NavigationEndpoint.ConfirmDialogEndpoint.ConfirmDialogRenderer", navigationEndpoint$ConfirmDialogEndpoint$ConfirmDialogRenderer$$serializer, 1);
        pluginGeneratedSerialDescriptor.addElement("confirmButton", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{HexFormatKt.getNullable(NavigationEndpoint$ConfirmDialogEndpoint$ConfirmButton$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        NavigationEndpoint.ConfirmDialogEndpoint.ConfirmButton confirmButton;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        int i = 1;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            confirmButton = (NavigationEndpoint.ConfirmDialogEndpoint.ConfirmButton) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, NavigationEndpoint$ConfirmDialogEndpoint$ConfirmButton$$serializer.INSTANCE, null);
        } else {
            boolean z = true;
            int i2 = 0;
            confirmButton = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else {
                    if (iDecodeElementIndex != 0) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    confirmButton = (NavigationEndpoint.ConfirmDialogEndpoint.ConfirmButton) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, NavigationEndpoint$ConfirmDialogEndpoint$ConfirmButton$$serializer.INSTANCE, confirmButton);
                    i2 = 1;
                }
            }
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new NavigationEndpoint.ConfirmDialogEndpoint.ConfirmDialogRenderer(i, confirmButton);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        NavigationEndpoint.ConfirmDialogEndpoint.ConfirmDialogRenderer confirmDialogRenderer = (NavigationEndpoint.ConfirmDialogEndpoint.ConfirmDialogRenderer) obj;
        confirmDialogRenderer.getClass();
        NavigationEndpoint.ConfirmDialogEndpoint.ConfirmButton confirmButton = confirmDialogRenderer.confirmButton;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 0) || confirmButton != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, NavigationEndpoint$ConfirmDialogEndpoint$ConfirmButton$$serializer.INSTANCE, confirmButton);
        }
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
