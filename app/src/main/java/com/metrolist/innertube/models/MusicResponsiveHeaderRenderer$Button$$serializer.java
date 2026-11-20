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
public final /* synthetic */ class MusicResponsiveHeaderRenderer$Button$$serializer implements GeneratedSerializer {
    public static final MusicResponsiveHeaderRenderer$Button$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        MusicResponsiveHeaderRenderer$Button$$serializer musicResponsiveHeaderRenderer$Button$$serializer = new MusicResponsiveHeaderRenderer$Button$$serializer();
        INSTANCE = musicResponsiveHeaderRenderer$Button$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.MusicResponsiveHeaderRenderer.Button", musicResponsiveHeaderRenderer$Button$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement("musicPlayButtonRenderer", true);
        pluginGeneratedSerialDescriptor.addElement("menuRenderer", true);
        pluginGeneratedSerialDescriptor.addElement("toggleButtonRenderer", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{HexFormatKt.getNullable(MusicResponsiveHeaderRenderer$Button$MusicPlayButtonRenderer$$serializer.INSTANCE), HexFormatKt.getNullable(Menu$MenuRenderer$$serializer.INSTANCE), HexFormatKt.getNullable(MusicResponsiveHeaderRenderer$Button$ToggleButtonRenderer$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        MusicResponsiveHeaderRenderer.Button.MusicPlayButtonRenderer musicPlayButtonRenderer;
        MusicResponsiveHeaderRenderer.Button.ToggleButtonRenderer toggleButtonRenderer;
        Menu.MenuRenderer menuRenderer;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            musicPlayButtonRenderer = (MusicResponsiveHeaderRenderer.Button.MusicPlayButtonRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, MusicResponsiveHeaderRenderer$Button$MusicPlayButtonRenderer$$serializer.INSTANCE, null);
            menuRenderer = (Menu.MenuRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, Menu$MenuRenderer$$serializer.INSTANCE, null);
            toggleButtonRenderer = (MusicResponsiveHeaderRenderer.Button.ToggleButtonRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, MusicResponsiveHeaderRenderer$Button$ToggleButtonRenderer$$serializer.INSTANCE, null);
            i = 7;
        } else {
            boolean z = true;
            int i2 = 0;
            musicPlayButtonRenderer = null;
            MusicResponsiveHeaderRenderer.Button.ToggleButtonRenderer toggleButtonRenderer2 = null;
            Menu.MenuRenderer menuRenderer2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    musicPlayButtonRenderer = (MusicResponsiveHeaderRenderer.Button.MusicPlayButtonRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, MusicResponsiveHeaderRenderer$Button$MusicPlayButtonRenderer$$serializer.INSTANCE, musicPlayButtonRenderer);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    menuRenderer2 = (Menu.MenuRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, Menu$MenuRenderer$$serializer.INSTANCE, menuRenderer2);
                    i2 |= 2;
                } else {
                    if (iDecodeElementIndex != 2) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    toggleButtonRenderer2 = (MusicResponsiveHeaderRenderer.Button.ToggleButtonRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, MusicResponsiveHeaderRenderer$Button$ToggleButtonRenderer$$serializer.INSTANCE, toggleButtonRenderer2);
                    i2 |= 4;
                }
            }
            toggleButtonRenderer = toggleButtonRenderer2;
            menuRenderer = menuRenderer2;
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new MusicResponsiveHeaderRenderer.Button(i, musicPlayButtonRenderer, menuRenderer, toggleButtonRenderer);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        MusicResponsiveHeaderRenderer.Button button = (MusicResponsiveHeaderRenderer.Button) obj;
        button.getClass();
        MusicResponsiveHeaderRenderer.Button.ToggleButtonRenderer toggleButtonRenderer = button.toggleButtonRenderer;
        Menu.MenuRenderer menuRenderer = button.menuRenderer;
        MusicResponsiveHeaderRenderer.Button.MusicPlayButtonRenderer musicPlayButtonRenderer = button.musicPlayButtonRenderer;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 0) || musicPlayButtonRenderer != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, MusicResponsiveHeaderRenderer$Button$MusicPlayButtonRenderer$$serializer.INSTANCE, musicPlayButtonRenderer);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 1) || menuRenderer != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, Menu$MenuRenderer$$serializer.INSTANCE, menuRenderer);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 2) || toggleButtonRenderer != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 2, MusicResponsiveHeaderRenderer$Button$ToggleButtonRenderer$$serializer.INSTANCE, toggleButtonRenderer);
        }
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
