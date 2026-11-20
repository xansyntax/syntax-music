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
public final /* synthetic */ class NavigationEndpoint$ConfirmDialogEndpoint$ConfirmCommand$$serializer implements GeneratedSerializer {
    public static final NavigationEndpoint$ConfirmDialogEndpoint$ConfirmCommand$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        NavigationEndpoint$ConfirmDialogEndpoint$ConfirmCommand$$serializer navigationEndpoint$ConfirmDialogEndpoint$ConfirmCommand$$serializer = new NavigationEndpoint$ConfirmDialogEndpoint$ConfirmCommand$$serializer();
        INSTANCE = navigationEndpoint$ConfirmDialogEndpoint$ConfirmCommand$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.NavigationEndpoint.ConfirmDialogEndpoint.ConfirmCommand", navigationEndpoint$ConfirmDialogEndpoint$ConfirmCommand$$serializer, 1);
        pluginGeneratedSerialDescriptor.addElement("musicDeletePrivatelyOwnedEntityCommand", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{HexFormatKt.getNullable(NavigationEndpoint$DeletePrivatelyOwnedEntityCommand$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        NavigationEndpoint.DeletePrivatelyOwnedEntityCommand deletePrivatelyOwnedEntityCommand;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        int i = 1;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            deletePrivatelyOwnedEntityCommand = (NavigationEndpoint.DeletePrivatelyOwnedEntityCommand) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, NavigationEndpoint$DeletePrivatelyOwnedEntityCommand$$serializer.INSTANCE, null);
        } else {
            boolean z = true;
            int i2 = 0;
            deletePrivatelyOwnedEntityCommand = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else {
                    if (iDecodeElementIndex != 0) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    deletePrivatelyOwnedEntityCommand = (NavigationEndpoint.DeletePrivatelyOwnedEntityCommand) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, NavigationEndpoint$DeletePrivatelyOwnedEntityCommand$$serializer.INSTANCE, deletePrivatelyOwnedEntityCommand);
                    i2 = 1;
                }
            }
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new NavigationEndpoint.ConfirmDialogEndpoint.ConfirmCommand(i, deletePrivatelyOwnedEntityCommand);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        NavigationEndpoint.ConfirmDialogEndpoint.ConfirmCommand confirmCommand = (NavigationEndpoint.ConfirmDialogEndpoint.ConfirmCommand) obj;
        confirmCommand.getClass();
        NavigationEndpoint.DeletePrivatelyOwnedEntityCommand deletePrivatelyOwnedEntityCommand = confirmCommand.musicDeletePrivatelyOwnedEntityCommand;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 0) || deletePrivatelyOwnedEntityCommand != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, NavigationEndpoint$DeletePrivatelyOwnedEntityCommand$$serializer.INSTANCE, deletePrivatelyOwnedEntityCommand);
        }
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
