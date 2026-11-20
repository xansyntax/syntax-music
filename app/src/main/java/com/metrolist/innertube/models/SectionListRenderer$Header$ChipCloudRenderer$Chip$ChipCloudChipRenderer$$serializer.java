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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SectionListRenderer$Header$ChipCloudRenderer$Chip$ChipCloudChipRenderer$$serializer implements GeneratedSerializer {
    public static final SectionListRenderer$Header$ChipCloudRenderer$Chip$ChipCloudChipRenderer$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        SectionListRenderer$Header$ChipCloudRenderer$Chip$ChipCloudChipRenderer$$serializer sectionListRenderer$Header$ChipCloudRenderer$Chip$ChipCloudChipRenderer$$serializer = new SectionListRenderer$Header$ChipCloudRenderer$Chip$ChipCloudChipRenderer$$serializer();
        INSTANCE = sectionListRenderer$Header$ChipCloudRenderer$Chip$ChipCloudChipRenderer$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.SectionListRenderer.Header.ChipCloudRenderer.Chip.ChipCloudChipRenderer", sectionListRenderer$Header$ChipCloudRenderer$Chip$ChipCloudChipRenderer$$serializer, 5);
        pluginGeneratedSerialDescriptor.addElement("isSelected", true);
        pluginGeneratedSerialDescriptor.addElement("navigationEndpoint", true);
        pluginGeneratedSerialDescriptor.addElement("onDeselectedCommand", true);
        pluginGeneratedSerialDescriptor.addElement(ContentType.Text.TYPE, false);
        pluginGeneratedSerialDescriptor.addElement("uniqueId", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        NavigationEndpoint$$serializer navigationEndpoint$$serializer = NavigationEndpoint$$serializer.INSTANCE;
        return new KSerializer[]{BooleanSerializer.INSTANCE, HexFormatKt.getNullable(navigationEndpoint$$serializer), HexFormatKt.getNullable(navigationEndpoint$$serializer), HexFormatKt.getNullable(Runs$$serializer.INSTANCE), HexFormatKt.getNullable(StringSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        boolean zDecodeBooleanElement;
        Runs runs;
        String str;
        NavigationEndpoint navigationEndpoint;
        NavigationEndpoint navigationEndpoint2;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Object obj = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 0);
            NavigationEndpoint$$serializer navigationEndpoint$$serializer = NavigationEndpoint$$serializer.INSTANCE;
            NavigationEndpoint navigationEndpoint3 = (NavigationEndpoint) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, navigationEndpoint$$serializer, null);
            NavigationEndpoint navigationEndpoint4 = (NavigationEndpoint) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, navigationEndpoint$$serializer, null);
            runs = (Runs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, Runs$$serializer.INSTANCE, null);
            str = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, null);
            navigationEndpoint = navigationEndpoint4;
            navigationEndpoint2 = navigationEndpoint3;
            i = 31;
        } else {
            boolean z = true;
            zDecodeBooleanElement = false;
            int i2 = 0;
            Runs runs2 = null;
            String str2 = null;
            NavigationEndpoint navigationEndpoint5 = null;
            NavigationEndpoint navigationEndpoint6 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                obj = obj;
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 0);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    navigationEndpoint6 = (NavigationEndpoint) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, NavigationEndpoint$$serializer.INSTANCE, navigationEndpoint6);
                    i2 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    navigationEndpoint5 = (NavigationEndpoint) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, NavigationEndpoint$$serializer.INSTANCE, navigationEndpoint5);
                    i2 |= 4;
                } else if (iDecodeElementIndex == 3) {
                    runs2 = (Runs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, Runs$$serializer.INSTANCE, runs2);
                    i2 |= 8;
                } else {
                    if (iDecodeElementIndex != 4) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return obj;
                    }
                    str2 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str2);
                    i2 |= 16;
                }
            }
            runs = runs2;
            str = str2;
            navigationEndpoint = navigationEndpoint5;
            navigationEndpoint2 = navigationEndpoint6;
            i = i2;
        }
        boolean z2 = zDecodeBooleanElement;
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new SectionListRenderer.Header.ChipCloudRenderer.Chip.ChipCloudChipRenderer(i, z2, navigationEndpoint2, navigationEndpoint, runs, str);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        SectionListRenderer.Header.ChipCloudRenderer.Chip.ChipCloudChipRenderer chipCloudChipRenderer = (SectionListRenderer.Header.ChipCloudRenderer.Chip.ChipCloudChipRenderer) obj;
        chipCloudChipRenderer.getClass();
        NavigationEndpoint navigationEndpoint = chipCloudChipRenderer.onDeselectedCommand;
        NavigationEndpoint navigationEndpoint2 = chipCloudChipRenderer.navigationEndpoint;
        boolean z = chipCloudChipRenderer.isSelected;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 0) || z) {
            compositeEncoderBeginStructure.encodeBooleanElement(serialDescriptor, 0, z);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 1) || navigationEndpoint2 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, NavigationEndpoint$$serializer.INSTANCE, navigationEndpoint2);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 2) || navigationEndpoint != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 2, NavigationEndpoint$$serializer.INSTANCE, navigationEndpoint);
        }
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 3, Runs$$serializer.INSTANCE, chipCloudChipRenderer.text);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, chipCloudChipRenderer.uniqueId);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
