package com.metrolist.innertube.models;

import com.yalantis.ucrop.util.ImageHeaderParser;
import io.ktor.http.LinkHeader;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.List;
import kotlin.Lazy;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.HexFormatKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MusicResponsiveHeaderRenderer$$serializer implements GeneratedSerializer {
    public static final MusicResponsiveHeaderRenderer$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        MusicResponsiveHeaderRenderer$$serializer musicResponsiveHeaderRenderer$$serializer = new MusicResponsiveHeaderRenderer$$serializer();
        INSTANCE = musicResponsiveHeaderRenderer$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.MusicResponsiveHeaderRenderer", musicResponsiveHeaderRenderer$$serializer, 8);
        pluginGeneratedSerialDescriptor.addElement("thumbnail", true);
        pluginGeneratedSerialDescriptor.addElement("buttons", true);
        pluginGeneratedSerialDescriptor.addElement(LinkHeader.Parameters.Title, true);
        pluginGeneratedSerialDescriptor.addElement("subtitle", true);
        pluginGeneratedSerialDescriptor.addElement("secondSubtitle", true);
        pluginGeneratedSerialDescriptor.addElement("straplineTextOne", true);
        pluginGeneratedSerialDescriptor.addElement("description", true);
        pluginGeneratedSerialDescriptor.addElement("facepile", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        Lazy[] lazyArr = MusicResponsiveHeaderRenderer.$childSerializers;
        Runs$$serializer runs$$serializer = Runs$$serializer.INSTANCE;
        return new KSerializer[]{HexFormatKt.getNullable(ThumbnailRenderer$$serializer.INSTANCE), lazyArr[1].getValue(), runs$$serializer, runs$$serializer, HexFormatKt.getNullable(runs$$serializer), HexFormatKt.getNullable(runs$$serializer), HexFormatKt.getNullable(DescriptionWrapper$$serializer.INSTANCE), HexFormatKt.getNullable(FacepileWrapper$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        List list;
        Runs runs;
        int i;
        Runs runs2;
        Runs runs3;
        Runs runs4;
        ThumbnailRenderer thumbnailRenderer;
        FacepileWrapper facepileWrapper;
        DescriptionWrapper descriptionWrapper;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = MusicResponsiveHeaderRenderer.$childSerializers;
        int i2 = 7;
        int i3 = 6;
        char c = 3;
        Runs runs5 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            ThumbnailRenderer thumbnailRenderer2 = (ThumbnailRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, ThumbnailRenderer$$serializer.INSTANCE, null);
            List list2 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), null);
            Runs$$serializer runs$$serializer = Runs$$serializer.INSTANCE;
            Runs runs6 = (Runs) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, runs$$serializer, null);
            Runs runs7 = (Runs) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 3, runs$$serializer, null);
            Runs runs8 = (Runs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, runs$$serializer, null);
            Runs runs9 = (Runs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, runs$$serializer, null);
            DescriptionWrapper descriptionWrapper2 = (DescriptionWrapper) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, DescriptionWrapper$$serializer.INSTANCE, null);
            list = list2;
            thumbnailRenderer = thumbnailRenderer2;
            facepileWrapper = (FacepileWrapper) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 7, FacepileWrapper$$serializer.INSTANCE, null);
            descriptionWrapper = descriptionWrapper2;
            runs4 = runs9;
            runs3 = runs7;
            runs2 = runs8;
            runs = runs6;
            i = 255;
        } else {
            int i4 = 1;
            boolean z = true;
            int i5 = 0;
            List list3 = null;
            Runs runs10 = null;
            Runs runs11 = null;
            ThumbnailRenderer thumbnailRenderer3 = null;
            FacepileWrapper facepileWrapper2 = null;
            DescriptionWrapper descriptionWrapper3 = null;
            Runs runs12 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case ImageHeaderParser.UNKNOWN_ORIENTATION /* -1 */:
                        z = false;
                        i2 = 7;
                        i3 = 6;
                        i4 = 1;
                        break;
                    case 0:
                        thumbnailRenderer3 = (ThumbnailRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, ThumbnailRenderer$$serializer.INSTANCE, thumbnailRenderer3);
                        i5 |= 1;
                        i2 = 7;
                        i3 = 6;
                        c = 3;
                        i4 = 1;
                        break;
                    case 1:
                        list3 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, i4, (DeserializationStrategy) lazyArr[i4].getValue(), list3);
                        i5 |= 2;
                        i2 = 7;
                        i3 = 6;
                        c = 3;
                        break;
                    case 2:
                        i5 |= 4;
                        runs12 = (Runs) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, Runs$$serializer.INSTANCE, runs12);
                        i2 = 7;
                        i3 = 6;
                        c = 3;
                        break;
                    case 3:
                        runs11 = (Runs) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 3, Runs$$serializer.INSTANCE, runs11);
                        i5 |= 8;
                        c = 3;
                        i2 = 7;
                        break;
                    case 4:
                        runs10 = (Runs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, Runs$$serializer.INSTANCE, runs10);
                        i5 |= 16;
                        c = 3;
                        break;
                    case 5:
                        runs5 = (Runs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, Runs$$serializer.INSTANCE, runs5);
                        i5 |= 32;
                        c = 3;
                        break;
                    case 6:
                        descriptionWrapper3 = (DescriptionWrapper) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i3, DescriptionWrapper$$serializer.INSTANCE, descriptionWrapper3);
                        i5 |= 64;
                        c = 3;
                        break;
                    case 7:
                        facepileWrapper2 = (FacepileWrapper) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i2, FacepileWrapper$$serializer.INSTANCE, facepileWrapper2);
                        i5 |= 128;
                        c = 3;
                        break;
                    default:
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                }
            }
            list = list3;
            runs = runs12;
            i = i5;
            runs2 = runs10;
            runs3 = runs11;
            runs4 = runs5;
            thumbnailRenderer = thumbnailRenderer3;
            facepileWrapper = facepileWrapper2;
            descriptionWrapper = descriptionWrapper3;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new MusicResponsiveHeaderRenderer(i, thumbnailRenderer, list, runs, runs3, runs2, runs4, descriptionWrapper, facepileWrapper);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        MusicResponsiveHeaderRenderer musicResponsiveHeaderRenderer = (MusicResponsiveHeaderRenderer) obj;
        musicResponsiveHeaderRenderer.getClass();
        FacepileWrapper facepileWrapper = musicResponsiveHeaderRenderer.facepile;
        DescriptionWrapper descriptionWrapper = musicResponsiveHeaderRenderer.description;
        Runs runs = musicResponsiveHeaderRenderer.straplineTextOne;
        Runs runs2 = musicResponsiveHeaderRenderer.secondSubtitle;
        Runs runs3 = musicResponsiveHeaderRenderer.subtitle;
        Runs runs4 = musicResponsiveHeaderRenderer.title;
        List list = musicResponsiveHeaderRenderer.buttons;
        ThumbnailRenderer thumbnailRenderer = musicResponsiveHeaderRenderer.thumbnail;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = MusicResponsiveHeaderRenderer.$childSerializers;
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 0) || thumbnailRenderer != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, ThumbnailRenderer$$serializer.INSTANCE, thumbnailRenderer);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 1) || !Intrinsics.areEqual(list, EmptyList.INSTANCE)) {
            compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 1, (SerializationStrategy) lazyArr[1].getValue(), list);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 2) || !Intrinsics.areEqual(runs4, new Runs())) {
            compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 2, Runs$$serializer.INSTANCE, runs4);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 3) || !Intrinsics.areEqual(runs3, new Runs())) {
            compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 3, Runs$$serializer.INSTANCE, runs3);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 4) || runs2 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 4, Runs$$serializer.INSTANCE, runs2);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 5) || runs != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 5, Runs$$serializer.INSTANCE, runs);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 6) || descriptionWrapper != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 6, DescriptionWrapper$$serializer.INSTANCE, descriptionWrapper);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 7) || facepileWrapper != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 7, FacepileWrapper$$serializer.INSTANCE, facepileWrapper);
        }
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
