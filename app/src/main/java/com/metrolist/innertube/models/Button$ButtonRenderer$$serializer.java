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

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Button$ButtonRenderer$$serializer implements GeneratedSerializer {
    public static final Button$ButtonRenderer$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        Button$ButtonRenderer$$serializer button$ButtonRenderer$$serializer = new Button$ButtonRenderer$$serializer();
        INSTANCE = button$ButtonRenderer$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.Button.ButtonRenderer", button$ButtonRenderer$$serializer, 4);
        pluginGeneratedSerialDescriptor.addElement(ContentType.Text.TYPE, false);
        pluginGeneratedSerialDescriptor.addElement("navigationEndpoint", false);
        pluginGeneratedSerialDescriptor.addElement("command", false);
        pluginGeneratedSerialDescriptor.addElement("icon", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        NavigationEndpoint$$serializer navigationEndpoint$$serializer = NavigationEndpoint$$serializer.INSTANCE;
        return new KSerializer[]{Runs$$serializer.INSTANCE, HexFormatKt.getNullable(navigationEndpoint$$serializer), HexFormatKt.getNullable(navigationEndpoint$$serializer), HexFormatKt.getNullable(Icon$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        Runs runs;
        Icon icon;
        NavigationEndpoint navigationEndpoint;
        NavigationEndpoint navigationEndpoint2;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            runs = (Runs) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, Runs$$serializer.INSTANCE, null);
            NavigationEndpoint$$serializer navigationEndpoint$$serializer = NavigationEndpoint$$serializer.INSTANCE;
            NavigationEndpoint navigationEndpoint3 = (NavigationEndpoint) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, navigationEndpoint$$serializer, null);
            NavigationEndpoint navigationEndpoint4 = (NavigationEndpoint) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, navigationEndpoint$$serializer, null);
            icon = (Icon) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, Icon$$serializer.INSTANCE, null);
            navigationEndpoint = navigationEndpoint4;
            navigationEndpoint2 = navigationEndpoint3;
            i = 15;
        } else {
            boolean z = true;
            int i2 = 0;
            runs = null;
            Icon icon2 = null;
            NavigationEndpoint navigationEndpoint5 = null;
            NavigationEndpoint navigationEndpoint6 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    runs = (Runs) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, Runs$$serializer.INSTANCE, runs);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    navigationEndpoint6 = (NavigationEndpoint) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, NavigationEndpoint$$serializer.INSTANCE, navigationEndpoint6);
                    i2 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    navigationEndpoint5 = (NavigationEndpoint) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, NavigationEndpoint$$serializer.INSTANCE, navigationEndpoint5);
                    i2 |= 4;
                } else {
                    if (iDecodeElementIndex != 3) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    icon2 = (Icon) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, Icon$$serializer.INSTANCE, icon2);
                    i2 |= 8;
                }
            }
            icon = icon2;
            navigationEndpoint = navigationEndpoint5;
            navigationEndpoint2 = navigationEndpoint6;
            i = i2;
        }
        Runs runs2 = runs;
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new Button.ButtonRenderer(i, runs2, navigationEndpoint2, navigationEndpoint, icon);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        Button.ButtonRenderer buttonRenderer = (Button.ButtonRenderer) obj;
        buttonRenderer.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 0, Runs$$serializer.INSTANCE, buttonRenderer.text);
        NavigationEndpoint$$serializer navigationEndpoint$$serializer = NavigationEndpoint$$serializer.INSTANCE;
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, navigationEndpoint$$serializer, buttonRenderer.navigationEndpoint);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 2, navigationEndpoint$$serializer, buttonRenderer.command);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 3, Icon$$serializer.INSTANCE, buttonRenderer.icon);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
