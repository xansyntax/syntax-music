package com.metrolist.innertube.models.response;

import com.metrolist.innertube.models.Runs;
import com.metrolist.innertube.models.Runs$$serializer;
import com.yalantis.ucrop.util.ImageHeaderParser;
import io.ktor.http.LinkHeader;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.List;
import kotlin.Lazy;
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
public final /* synthetic */ class BrowseResponse$Header$MusicHeaderRenderer$$serializer implements GeneratedSerializer {
    public static final BrowseResponse$Header$MusicHeaderRenderer$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        BrowseResponse$Header$MusicHeaderRenderer$$serializer browseResponse$Header$MusicHeaderRenderer$$serializer = new BrowseResponse$Header$MusicHeaderRenderer$$serializer();
        INSTANCE = browseResponse$Header$MusicHeaderRenderer$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.response.BrowseResponse.Header.MusicHeaderRenderer", browseResponse$Header$MusicHeaderRenderer$$serializer, 7);
        pluginGeneratedSerialDescriptor.addElement("buttons", false);
        pluginGeneratedSerialDescriptor.addElement(LinkHeader.Parameters.Title, false);
        pluginGeneratedSerialDescriptor.addElement("thumbnail", false);
        pluginGeneratedSerialDescriptor.addElement("subtitle", false);
        pluginGeneratedSerialDescriptor.addElement("secondSubtitle", false);
        pluginGeneratedSerialDescriptor.addElement("straplineTextOne", false);
        pluginGeneratedSerialDescriptor.addElement("straplineThumbnail", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        KSerializer nullable = HexFormatKt.getNullable((KSerializer) BrowseResponse.Header.MusicHeaderRenderer.$childSerializers[0].getValue());
        Runs$$serializer runs$$serializer = Runs$$serializer.INSTANCE;
        KSerializer nullable2 = HexFormatKt.getNullable(runs$$serializer);
        BrowseResponse$Header$MusicThumbnailRenderer$$serializer browseResponse$Header$MusicThumbnailRenderer$$serializer = BrowseResponse$Header$MusicThumbnailRenderer$$serializer.INSTANCE;
        return new KSerializer[]{nullable, nullable2, HexFormatKt.getNullable(browseResponse$Header$MusicThumbnailRenderer$$serializer), HexFormatKt.getNullable(runs$$serializer), HexFormatKt.getNullable(runs$$serializer), HexFormatKt.getNullable(runs$$serializer), HexFormatKt.getNullable(browseResponse$Header$MusicThumbnailRenderer$$serializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        List list;
        Runs runs;
        BrowseResponse.Header.MusicThumbnailRenderer musicThumbnailRenderer;
        Runs runs2;
        Runs runs3;
        BrowseResponse.Header.MusicThumbnailRenderer musicThumbnailRenderer2;
        int i;
        Runs runs4;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = BrowseResponse.Header.MusicHeaderRenderer.$childSerializers;
        int i2 = 6;
        int i3 = 5;
        boolean z = true;
        Runs runs5 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            List list2 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, (DeserializationStrategy) lazyArr[0].getValue(), null);
            Runs$$serializer runs$$serializer = Runs$$serializer.INSTANCE;
            Runs runs6 = (Runs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, runs$$serializer, null);
            BrowseResponse$Header$MusicThumbnailRenderer$$serializer browseResponse$Header$MusicThumbnailRenderer$$serializer = BrowseResponse$Header$MusicThumbnailRenderer$$serializer.INSTANCE;
            BrowseResponse.Header.MusicThumbnailRenderer musicThumbnailRenderer3 = (BrowseResponse.Header.MusicThumbnailRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, browseResponse$Header$MusicThumbnailRenderer$$serializer, null);
            Runs runs7 = (Runs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, runs$$serializer, null);
            Runs runs8 = (Runs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, runs$$serializer, null);
            list = list2;
            runs3 = (Runs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, runs$$serializer, null);
            musicThumbnailRenderer2 = (BrowseResponse.Header.MusicThumbnailRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, browseResponse$Header$MusicThumbnailRenderer$$serializer, null);
            i = 127;
            runs4 = runs7;
            runs2 = runs8;
            musicThumbnailRenderer = musicThumbnailRenderer3;
            runs = runs6;
        } else {
            boolean z2 = true;
            int i4 = 0;
            List list3 = null;
            BrowseResponse.Header.MusicThumbnailRenderer musicThumbnailRenderer4 = null;
            Runs runs9 = null;
            BrowseResponse.Header.MusicThumbnailRenderer musicThumbnailRenderer5 = null;
            Runs runs10 = null;
            Runs runs11 = null;
            while (z2) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case ImageHeaderParser.UNKNOWN_ORIENTATION /* -1 */:
                        z2 = false;
                        i2 = 6;
                        i3 = 5;
                        break;
                    case 0:
                        list3 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, (DeserializationStrategy) lazyArr[0].getValue(), list3);
                        i4 |= 1;
                        i2 = 6;
                        i3 = 5;
                        z = true;
                        break;
                    case 1:
                        i4 |= 2;
                        runs11 = (Runs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, Runs$$serializer.INSTANCE, runs11);
                        z = true;
                        i2 = 6;
                        i3 = 5;
                        break;
                    case 2:
                        musicThumbnailRenderer4 = (BrowseResponse.Header.MusicThumbnailRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, BrowseResponse$Header$MusicThumbnailRenderer$$serializer.INSTANCE, musicThumbnailRenderer4);
                        i4 |= 4;
                        z = true;
                        break;
                    case 3:
                        runs10 = (Runs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, Runs$$serializer.INSTANCE, runs10);
                        i4 |= 8;
                        z = true;
                        break;
                    case 4:
                        runs5 = (Runs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, Runs$$serializer.INSTANCE, runs5);
                        i4 |= 16;
                        z = true;
                        break;
                    case 5:
                        runs9 = (Runs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i3, Runs$$serializer.INSTANCE, runs9);
                        i4 |= 32;
                        z = true;
                        break;
                    case 6:
                        musicThumbnailRenderer5 = (BrowseResponse.Header.MusicThumbnailRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i2, BrowseResponse$Header$MusicThumbnailRenderer$$serializer.INSTANCE, musicThumbnailRenderer5);
                        i4 |= 64;
                        z = true;
                        break;
                    default:
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                }
            }
            list = list3;
            runs = runs11;
            musicThumbnailRenderer = musicThumbnailRenderer4;
            runs2 = runs5;
            runs3 = runs9;
            musicThumbnailRenderer2 = musicThumbnailRenderer5;
            i = i4;
            runs4 = runs10;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new BrowseResponse.Header.MusicHeaderRenderer(i, list, runs, musicThumbnailRenderer, runs4, runs2, runs3, musicThumbnailRenderer2);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        BrowseResponse.Header.MusicHeaderRenderer musicHeaderRenderer = (BrowseResponse.Header.MusicHeaderRenderer) obj;
        musicHeaderRenderer.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, (SerializationStrategy) BrowseResponse.Header.MusicHeaderRenderer.$childSerializers[0].getValue(), musicHeaderRenderer.buttons);
        Runs$$serializer runs$$serializer = Runs$$serializer.INSTANCE;
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, runs$$serializer, musicHeaderRenderer.title);
        BrowseResponse$Header$MusicThumbnailRenderer$$serializer browseResponse$Header$MusicThumbnailRenderer$$serializer = BrowseResponse$Header$MusicThumbnailRenderer$$serializer.INSTANCE;
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 2, browseResponse$Header$MusicThumbnailRenderer$$serializer, musicHeaderRenderer.thumbnail);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 3, runs$$serializer, musicHeaderRenderer.subtitle);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 4, runs$$serializer, musicHeaderRenderer.secondSubtitle);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 5, runs$$serializer, musicHeaderRenderer.straplineTextOne);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 6, browseResponse$Header$MusicThumbnailRenderer$$serializer, musicHeaderRenderer.straplineThumbnail);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
