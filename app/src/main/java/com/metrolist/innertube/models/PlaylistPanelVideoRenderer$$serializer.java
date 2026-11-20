package com.metrolist.innertube.models;

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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PlaylistPanelVideoRenderer$$serializer implements GeneratedSerializer {
    public static final PlaylistPanelVideoRenderer$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        PlaylistPanelVideoRenderer$$serializer playlistPanelVideoRenderer$$serializer = new PlaylistPanelVideoRenderer$$serializer();
        INSTANCE = playlistPanelVideoRenderer$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.PlaylistPanelVideoRenderer", playlistPanelVideoRenderer$$serializer, 12);
        pluginGeneratedSerialDescriptor.addElement(LinkHeader.Parameters.Title, false);
        pluginGeneratedSerialDescriptor.addElement("lengthText", false);
        pluginGeneratedSerialDescriptor.addElement("longBylineText", false);
        pluginGeneratedSerialDescriptor.addElement("shortBylineText", false);
        pluginGeneratedSerialDescriptor.addElement("badges", false);
        pluginGeneratedSerialDescriptor.addElement("videoId", false);
        pluginGeneratedSerialDescriptor.addElement("playlistSetVideoId", false);
        pluginGeneratedSerialDescriptor.addElement("selected", false);
        pluginGeneratedSerialDescriptor.addElement("thumbnail", false);
        pluginGeneratedSerialDescriptor.addElement("unplayableText", false);
        pluginGeneratedSerialDescriptor.addElement("menu", false);
        pluginGeneratedSerialDescriptor.addElement("navigationEndpoint", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        Lazy[] lazyArr = PlaylistPanelVideoRenderer.$childSerializers;
        Runs$$serializer runs$$serializer = Runs$$serializer.INSTANCE;
        KSerializer nullable = HexFormatKt.getNullable(runs$$serializer);
        KSerializer nullable2 = HexFormatKt.getNullable(runs$$serializer);
        KSerializer nullable3 = HexFormatKt.getNullable(runs$$serializer);
        KSerializer nullable4 = HexFormatKt.getNullable(runs$$serializer);
        KSerializer nullable5 = HexFormatKt.getNullable((KSerializer) lazyArr[4].getValue());
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{nullable, nullable2, nullable3, nullable4, nullable5, HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(stringSerializer), BooleanSerializer.INSTANCE, Thumbnails$$serializer.INSTANCE, HexFormatKt.getNullable(runs$$serializer), HexFormatKt.getNullable(Menu$$serializer.INSTANCE), NavigationEndpoint$$serializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        String str;
        List list;
        Runs runs;
        Runs runs2;
        Runs runs3;
        Thumbnails thumbnails;
        int i;
        Runs runs4;
        Menu menu;
        String str2;
        NavigationEndpoint navigationEndpoint;
        Runs runs5;
        boolean z;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = PlaylistPanelVideoRenderer.$childSerializers;
        int i2 = 10;
        int i3 = 9;
        int i4 = 7;
        char c = 6;
        int i5 = 8;
        List list2 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            Runs$$serializer runs$$serializer = Runs$$serializer.INSTANCE;
            Runs runs6 = (Runs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, runs$$serializer, null);
            Runs runs7 = (Runs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, runs$$serializer, null);
            Runs runs8 = (Runs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, runs$$serializer, null);
            Runs runs9 = (Runs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, runs$$serializer, null);
            List list3 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, (DeserializationStrategy) lazyArr[4].getValue(), null);
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            String str3 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, stringSerializer, null);
            String str4 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, stringSerializer, null);
            boolean zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 7);
            Thumbnails thumbnails2 = (Thumbnails) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 8, Thumbnails$$serializer.INSTANCE, null);
            Runs runs10 = (Runs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 9, runs$$serializer, null);
            Menu menu2 = (Menu) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 10, Menu$$serializer.INSTANCE, null);
            list = list3;
            runs5 = runs10;
            navigationEndpoint = (NavigationEndpoint) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 11, NavigationEndpoint$$serializer.INSTANCE, null);
            menu = menu2;
            i = 4095;
            z = zDecodeBooleanElement;
            str2 = str4;
            str = str3;
            runs = runs9;
            thumbnails = thumbnails2;
            runs2 = runs8;
            runs3 = runs7;
            runs4 = runs6;
        } else {
            int i6 = 11;
            Thumbnails thumbnails3 = null;
            Menu menu3 = null;
            String str5 = null;
            Runs runs11 = null;
            Runs runs12 = null;
            Runs runs13 = null;
            Runs runs14 = null;
            int i7 = 4;
            boolean z2 = true;
            int i8 = 0;
            boolean zDecodeBooleanElement2 = false;
            String str6 = null;
            NavigationEndpoint navigationEndpoint2 = null;
            Runs runs15 = null;
            while (z2) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case ImageHeaderParser.UNKNOWN_ORIENTATION /* -1 */:
                        z2 = false;
                        i6 = 11;
                        i2 = 10;
                        i3 = 9;
                        i4 = 7;
                        i5 = 8;
                        i7 = 4;
                        lazyArr = lazyArr;
                        break;
                    case 0:
                        runs14 = (Runs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, Runs$$serializer.INSTANCE, runs14);
                        i8 |= 1;
                        lazyArr = lazyArr;
                        i6 = 11;
                        i2 = 10;
                        i3 = 9;
                        i4 = 7;
                        c = 6;
                        i5 = 8;
                        i7 = 4;
                        break;
                    case 1:
                        runs13 = (Runs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, Runs$$serializer.INSTANCE, runs13);
                        i8 |= 2;
                        i6 = 11;
                        i2 = 10;
                        i3 = 9;
                        i4 = 7;
                        c = 6;
                        i5 = 8;
                        i7 = 4;
                        break;
                    case 2:
                        runs12 = (Runs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, Runs$$serializer.INSTANCE, runs12);
                        i8 |= 4;
                        i6 = 11;
                        i2 = 10;
                        i3 = 9;
                        i4 = 7;
                        c = 6;
                        i7 = 4;
                        break;
                    case 3:
                        runs11 = (Runs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, Runs$$serializer.INSTANCE, runs11);
                        i8 |= 8;
                        i6 = 11;
                        i2 = 10;
                        i3 = 9;
                        c = 6;
                        i7 = 4;
                        break;
                    case 4:
                        list2 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i7, (DeserializationStrategy) lazyArr[i7].getValue(), list2);
                        i8 |= 16;
                        i6 = 11;
                        i2 = 10;
                        c = 6;
                        break;
                    case 5:
                        i8 |= 32;
                        str5 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, str5);
                        i6 = 11;
                        i2 = 10;
                        c = 6;
                        break;
                    case 6:
                        str6 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, str6);
                        i8 |= 64;
                        c = 6;
                        i6 = 11;
                        break;
                    case 7:
                        zDecodeBooleanElement2 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, i4);
                        i8 |= 128;
                        c = 6;
                        break;
                    case 8:
                        thumbnails3 = (Thumbnails) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, i5, Thumbnails$$serializer.INSTANCE, thumbnails3);
                        i8 |= 256;
                        c = 6;
                        break;
                    case 9:
                        runs15 = (Runs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i3, Runs$$serializer.INSTANCE, runs15);
                        i8 |= 512;
                        c = 6;
                        break;
                    case 10:
                        menu3 = (Menu) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i2, Menu$$serializer.INSTANCE, menu3);
                        i8 |= 1024;
                        c = 6;
                        break;
                    case 11:
                        navigationEndpoint2 = (NavigationEndpoint) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, i6, NavigationEndpoint$$serializer.INSTANCE, navigationEndpoint2);
                        i8 |= 2048;
                        c = 6;
                        break;
                    default:
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                }
            }
            str = str5;
            list = list2;
            runs = runs11;
            runs2 = runs12;
            runs3 = runs13;
            thumbnails = thumbnails3;
            i = i8;
            runs4 = runs14;
            menu = menu3;
            str2 = str6;
            navigationEndpoint = navigationEndpoint2;
            runs5 = runs15;
            z = zDecodeBooleanElement2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new PlaylistPanelVideoRenderer(i, runs4, runs3, runs2, runs, list, str, str2, z, thumbnails, runs5, menu, navigationEndpoint);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        PlaylistPanelVideoRenderer playlistPanelVideoRenderer = (PlaylistPanelVideoRenderer) obj;
        playlistPanelVideoRenderer.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = PlaylistPanelVideoRenderer.$childSerializers;
        Runs$$serializer runs$$serializer = Runs$$serializer.INSTANCE;
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, runs$$serializer, playlistPanelVideoRenderer.title);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, runs$$serializer, playlistPanelVideoRenderer.lengthText);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 2, runs$$serializer, playlistPanelVideoRenderer.longBylineText);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 3, runs$$serializer, playlistPanelVideoRenderer.shortBylineText);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 4, (SerializationStrategy) lazyArr[4].getValue(), playlistPanelVideoRenderer.badges);
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 5, stringSerializer, playlistPanelVideoRenderer.videoId);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 6, stringSerializer, playlistPanelVideoRenderer.playlistSetVideoId);
        compositeEncoderBeginStructure.encodeBooleanElement(serialDescriptor, 7, playlistPanelVideoRenderer.selected);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 8, Thumbnails$$serializer.INSTANCE, playlistPanelVideoRenderer.thumbnail);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 9, runs$$serializer, playlistPanelVideoRenderer.unplayableText);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 10, Menu$$serializer.INSTANCE, playlistPanelVideoRenderer.menu);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 11, NavigationEndpoint$$serializer.INSTANCE, playlistPanelVideoRenderer.navigationEndpoint);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
