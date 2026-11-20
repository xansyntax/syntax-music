package com.metrolist.innertube.models;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import com.yalantis.ucrop.util.ImageHeaderParser;
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
public final /* synthetic */ class SectionListRenderer$Content$$serializer implements GeneratedSerializer {
    public static final SectionListRenderer$Content$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        SectionListRenderer$Content$$serializer sectionListRenderer$Content$$serializer = new SectionListRenderer$Content$$serializer();
        INSTANCE = sectionListRenderer$Content$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.SectionListRenderer.Content", sectionListRenderer$Content$$serializer, 9);
        pluginGeneratedSerialDescriptor.addElement("musicCarouselShelfRenderer", false);
        final String[] strArr = {"musicImmersiveCarouselShelfRenderer"};
        pluginGeneratedSerialDescriptor.pushAnnotation(new JsonNames() { // from class: com.metrolist.innertube.models.SectionListRenderer$Content$$serializer$annotationImpl$kotlinx_serialization_json_JsonNames$0
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
        pluginGeneratedSerialDescriptor.addElement("musicShelfRenderer", false);
        pluginGeneratedSerialDescriptor.addElement("musicCardShelfRenderer", false);
        pluginGeneratedSerialDescriptor.addElement("musicPlaylistShelfRenderer", false);
        pluginGeneratedSerialDescriptor.addElement("musicDescriptionShelfRenderer", false);
        pluginGeneratedSerialDescriptor.addElement("musicResponsiveHeaderRenderer", false);
        pluginGeneratedSerialDescriptor.addElement("musicEditablePlaylistDetailHeaderRenderer", false);
        pluginGeneratedSerialDescriptor.addElement("gridRenderer", false);
        pluginGeneratedSerialDescriptor.addElement("itemSectionRenderer", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{HexFormatKt.getNullable(MusicCarouselShelfRenderer$$serializer.INSTANCE), HexFormatKt.getNullable(MusicShelfRenderer$$serializer.INSTANCE), HexFormatKt.getNullable(MusicCardShelfRenderer$$serializer.INSTANCE), HexFormatKt.getNullable(MusicPlaylistShelfRenderer$$serializer.INSTANCE), HexFormatKt.getNullable(MusicDescriptionShelfRenderer$$serializer.INSTANCE), HexFormatKt.getNullable(MusicResponsiveHeaderRenderer$$serializer.INSTANCE), HexFormatKt.getNullable(MusicEditablePlaylistDetailHeaderRenderer$$serializer.INSTANCE), HexFormatKt.getNullable(GridRenderer$$serializer.INSTANCE), HexFormatKt.getNullable(ItemSectionRenderer$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        MusicCarouselShelfRenderer musicCarouselShelfRenderer;
        MusicCardShelfRenderer musicCardShelfRenderer;
        MusicShelfRenderer musicShelfRenderer;
        int i;
        MusicDescriptionShelfRenderer musicDescriptionShelfRenderer;
        ItemSectionRenderer itemSectionRenderer;
        MusicPlaylistShelfRenderer musicPlaylistShelfRenderer;
        GridRenderer gridRenderer;
        MusicEditablePlaylistDetailHeaderRenderer musicEditablePlaylistDetailHeaderRenderer;
        MusicResponsiveHeaderRenderer musicResponsiveHeaderRenderer;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        int i2 = 7;
        int i3 = 6;
        int i4 = 5;
        char c = 3;
        MusicPlaylistShelfRenderer musicPlaylistShelfRenderer2 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            musicCarouselShelfRenderer = (MusicCarouselShelfRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, MusicCarouselShelfRenderer$$serializer.INSTANCE, null);
            MusicShelfRenderer musicShelfRenderer2 = (MusicShelfRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, MusicShelfRenderer$$serializer.INSTANCE, null);
            MusicCardShelfRenderer musicCardShelfRenderer2 = (MusicCardShelfRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, MusicCardShelfRenderer$$serializer.INSTANCE, null);
            MusicPlaylistShelfRenderer musicPlaylistShelfRenderer3 = (MusicPlaylistShelfRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, MusicPlaylistShelfRenderer$$serializer.INSTANCE, null);
            MusicDescriptionShelfRenderer musicDescriptionShelfRenderer2 = (MusicDescriptionShelfRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, MusicDescriptionShelfRenderer$$serializer.INSTANCE, null);
            MusicResponsiveHeaderRenderer musicResponsiveHeaderRenderer2 = (MusicResponsiveHeaderRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, MusicResponsiveHeaderRenderer$$serializer.INSTANCE, null);
            MusicEditablePlaylistDetailHeaderRenderer musicEditablePlaylistDetailHeaderRenderer2 = (MusicEditablePlaylistDetailHeaderRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, MusicEditablePlaylistDetailHeaderRenderer$$serializer.INSTANCE, null);
            gridRenderer = (GridRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 7, GridRenderer$$serializer.INSTANCE, null);
            musicEditablePlaylistDetailHeaderRenderer = musicEditablePlaylistDetailHeaderRenderer2;
            musicResponsiveHeaderRenderer = musicResponsiveHeaderRenderer2;
            musicPlaylistShelfRenderer = musicPlaylistShelfRenderer3;
            itemSectionRenderer = (ItemSectionRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 8, ItemSectionRenderer$$serializer.INSTANCE, null);
            musicDescriptionShelfRenderer = musicDescriptionShelfRenderer2;
            musicCardShelfRenderer = musicCardShelfRenderer2;
            musicShelfRenderer = musicShelfRenderer2;
            i = 511;
        } else {
            boolean z = true;
            int i5 = 0;
            musicCarouselShelfRenderer = null;
            MusicDescriptionShelfRenderer musicDescriptionShelfRenderer3 = null;
            ItemSectionRenderer itemSectionRenderer2 = null;
            GridRenderer gridRenderer2 = null;
            MusicEditablePlaylistDetailHeaderRenderer musicEditablePlaylistDetailHeaderRenderer3 = null;
            MusicResponsiveHeaderRenderer musicResponsiveHeaderRenderer3 = null;
            MusicCardShelfRenderer musicCardShelfRenderer3 = null;
            MusicShelfRenderer musicShelfRenderer3 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case ImageHeaderParser.UNKNOWN_ORIENTATION /* -1 */:
                        z = false;
                        i2 = 7;
                        i3 = 6;
                        i4 = 5;
                        break;
                    case 0:
                        musicCarouselShelfRenderer = (MusicCarouselShelfRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, MusicCarouselShelfRenderer$$serializer.INSTANCE, musicCarouselShelfRenderer);
                        i5 |= 1;
                        i2 = 7;
                        i3 = 6;
                        i4 = 5;
                        c = 3;
                        break;
                    case 1:
                        musicShelfRenderer3 = (MusicShelfRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, MusicShelfRenderer$$serializer.INSTANCE, musicShelfRenderer3);
                        i5 |= 2;
                        i2 = 7;
                        i3 = 6;
                        i4 = 5;
                        c = 3;
                        break;
                    case 2:
                        i5 |= 4;
                        musicCardShelfRenderer3 = (MusicCardShelfRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, MusicCardShelfRenderer$$serializer.INSTANCE, musicCardShelfRenderer3);
                        i2 = 7;
                        i3 = 6;
                        c = 3;
                        break;
                    case 3:
                        musicPlaylistShelfRenderer2 = (MusicPlaylistShelfRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, MusicPlaylistShelfRenderer$$serializer.INSTANCE, musicPlaylistShelfRenderer2);
                        i5 |= 8;
                        c = 3;
                        i2 = 7;
                        break;
                    case 4:
                        musicDescriptionShelfRenderer3 = (MusicDescriptionShelfRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, MusicDescriptionShelfRenderer$$serializer.INSTANCE, musicDescriptionShelfRenderer3);
                        i5 |= 16;
                        c = 3;
                        break;
                    case 5:
                        musicResponsiveHeaderRenderer3 = (MusicResponsiveHeaderRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i4, MusicResponsiveHeaderRenderer$$serializer.INSTANCE, musicResponsiveHeaderRenderer3);
                        i5 |= 32;
                        c = 3;
                        break;
                    case 6:
                        musicEditablePlaylistDetailHeaderRenderer3 = (MusicEditablePlaylistDetailHeaderRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i3, MusicEditablePlaylistDetailHeaderRenderer$$serializer.INSTANCE, musicEditablePlaylistDetailHeaderRenderer3);
                        i5 |= 64;
                        c = 3;
                        break;
                    case 7:
                        gridRenderer2 = (GridRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i2, GridRenderer$$serializer.INSTANCE, gridRenderer2);
                        i5 |= 128;
                        c = 3;
                        break;
                    case 8:
                        itemSectionRenderer2 = (ItemSectionRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 8, ItemSectionRenderer$$serializer.INSTANCE, itemSectionRenderer2);
                        i5 |= 256;
                        c = 3;
                        break;
                    default:
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                }
            }
            musicCardShelfRenderer = musicCardShelfRenderer3;
            musicShelfRenderer = musicShelfRenderer3;
            i = i5;
            musicDescriptionShelfRenderer = musicDescriptionShelfRenderer3;
            itemSectionRenderer = itemSectionRenderer2;
            musicPlaylistShelfRenderer = musicPlaylistShelfRenderer2;
            gridRenderer = gridRenderer2;
            musicEditablePlaylistDetailHeaderRenderer = musicEditablePlaylistDetailHeaderRenderer3;
            musicResponsiveHeaderRenderer = musicResponsiveHeaderRenderer3;
        }
        MusicCarouselShelfRenderer musicCarouselShelfRenderer2 = musicCarouselShelfRenderer;
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new SectionListRenderer.Content(i, musicCarouselShelfRenderer2, musicShelfRenderer, musicCardShelfRenderer, musicPlaylistShelfRenderer, musicDescriptionShelfRenderer, musicResponsiveHeaderRenderer, musicEditablePlaylistDetailHeaderRenderer, gridRenderer, itemSectionRenderer);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        SectionListRenderer.Content content = (SectionListRenderer.Content) obj;
        content.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, MusicCarouselShelfRenderer$$serializer.INSTANCE, content.musicCarouselShelfRenderer);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, MusicShelfRenderer$$serializer.INSTANCE, content.musicShelfRenderer);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 2, MusicCardShelfRenderer$$serializer.INSTANCE, content.musicCardShelfRenderer);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 3, MusicPlaylistShelfRenderer$$serializer.INSTANCE, content.musicPlaylistShelfRenderer);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 4, MusicDescriptionShelfRenderer$$serializer.INSTANCE, content.musicDescriptionShelfRenderer);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 5, MusicResponsiveHeaderRenderer$$serializer.INSTANCE, content.musicResponsiveHeaderRenderer);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 6, MusicEditablePlaylistDetailHeaderRenderer$$serializer.INSTANCE, content.musicEditablePlaylistDetailHeaderRenderer);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 7, GridRenderer$$serializer.INSTANCE, content.gridRenderer);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 8, ItemSectionRenderer$$serializer.INSTANCE, content.itemSectionRenderer);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
