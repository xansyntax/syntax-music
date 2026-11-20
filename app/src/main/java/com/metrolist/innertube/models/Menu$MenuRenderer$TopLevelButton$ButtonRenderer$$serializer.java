package com.metrolist.innertube.models;

import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
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
public final /* synthetic */ class Menu$MenuRenderer$TopLevelButton$ButtonRenderer$$serializer implements GeneratedSerializer {
    public static final Menu$MenuRenderer$TopLevelButton$ButtonRenderer$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        Menu$MenuRenderer$TopLevelButton$ButtonRenderer$$serializer menu$MenuRenderer$TopLevelButton$ButtonRenderer$$serializer = new Menu$MenuRenderer$TopLevelButton$ButtonRenderer$$serializer();
        INSTANCE = menu$MenuRenderer$TopLevelButton$ButtonRenderer$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.Menu.MenuRenderer.TopLevelButton.ButtonRenderer", menu$MenuRenderer$TopLevelButton$ButtonRenderer$$serializer, 2);
        pluginGeneratedSerialDescriptor.addElement("icon", false);
        pluginGeneratedSerialDescriptor.addElement("navigationEndpoint", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{Icon$$serializer.INSTANCE, NavigationEndpoint$$serializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        Icon icon;
        NavigationEndpoint navigationEndpoint;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            icon = (Icon) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, Icon$$serializer.INSTANCE, null);
            navigationEndpoint = (NavigationEndpoint) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, NavigationEndpoint$$serializer.INSTANCE, null);
            i = 3;
        } else {
            boolean z = true;
            int i2 = 0;
            icon = null;
            NavigationEndpoint navigationEndpoint2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    icon = (Icon) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, Icon$$serializer.INSTANCE, icon);
                    i2 |= 1;
                } else {
                    if (iDecodeElementIndex != 1) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    navigationEndpoint2 = (NavigationEndpoint) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, NavigationEndpoint$$serializer.INSTANCE, navigationEndpoint2);
                    i2 |= 2;
                }
            }
            navigationEndpoint = navigationEndpoint2;
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new Menu.MenuRenderer.TopLevelButton.ButtonRenderer(i, icon, navigationEndpoint);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        Menu.MenuRenderer.TopLevelButton.ButtonRenderer buttonRenderer = (Menu.MenuRenderer.TopLevelButton.ButtonRenderer) obj;
        buttonRenderer.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 0, Icon$$serializer.INSTANCE, buttonRenderer.icon);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 1, NavigationEndpoint$$serializer.INSTANCE, buttonRenderer.navigationEndpoint);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
