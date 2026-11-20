package com.metrolist.innertube.models.response;

import com.metrolist.innertube.models.Button;
import com.metrolist.innertube.models.Button$$serializer;
import com.metrolist.innertube.models.Menu;
import com.metrolist.innertube.models.Menu$$serializer;
import com.metrolist.innertube.models.Runs;
import com.metrolist.innertube.models.Runs$$serializer;
import com.metrolist.innertube.models.SubscriptionButton;
import com.metrolist.innertube.models.SubscriptionButton$$serializer;
import com.metrolist.innertube.models.ThumbnailRenderer;
import com.metrolist.innertube.models.ThumbnailRenderer$$serializer;
import com.yalantis.ucrop.util.ImageHeaderParser;
import io.ktor.http.LinkHeader;
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
public final /* synthetic */ class BrowseResponse$Header$MusicImmersiveHeaderRenderer$$serializer implements GeneratedSerializer {
    public static final BrowseResponse$Header$MusicImmersiveHeaderRenderer$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        BrowseResponse$Header$MusicImmersiveHeaderRenderer$$serializer browseResponse$Header$MusicImmersiveHeaderRenderer$$serializer = new BrowseResponse$Header$MusicImmersiveHeaderRenderer$$serializer();
        INSTANCE = browseResponse$Header$MusicImmersiveHeaderRenderer$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.response.BrowseResponse.Header.MusicImmersiveHeaderRenderer", browseResponse$Header$MusicImmersiveHeaderRenderer$$serializer, 9);
        pluginGeneratedSerialDescriptor.addElement(LinkHeader.Parameters.Title, false);
        pluginGeneratedSerialDescriptor.addElement("description", false);
        pluginGeneratedSerialDescriptor.addElement("thumbnail", false);
        pluginGeneratedSerialDescriptor.addElement("playButton", false);
        pluginGeneratedSerialDescriptor.addElement("startRadioButton", false);
        pluginGeneratedSerialDescriptor.addElement("subscriptionButton", false);
        pluginGeneratedSerialDescriptor.addElement("menu", false);
        pluginGeneratedSerialDescriptor.addElement("subscriptionButton2", false);
        pluginGeneratedSerialDescriptor.addElement("monthlyListenerCount", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        Runs$$serializer runs$$serializer = Runs$$serializer.INSTANCE;
        KSerializer nullable = HexFormatKt.getNullable(runs$$serializer);
        KSerializer nullable2 = HexFormatKt.getNullable(ThumbnailRenderer$$serializer.INSTANCE);
        Button$$serializer button$$serializer = Button$$serializer.INSTANCE;
        return new KSerializer[]{runs$$serializer, nullable, nullable2, HexFormatKt.getNullable(button$$serializer), HexFormatKt.getNullable(button$$serializer), HexFormatKt.getNullable(SubscriptionButton$$serializer.INSTANCE), Menu$$serializer.INSTANCE, HexFormatKt.getNullable(BrowseResponse$Header$MusicImmersiveHeaderRenderer$SubscriptionButton2$$serializer.INSTANCE), HexFormatKt.getNullable(runs$$serializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        Runs runs;
        ThumbnailRenderer thumbnailRenderer;
        Runs runs2;
        Runs runs3;
        Button button;
        int i;
        Button button2;
        BrowseResponse.Header.MusicImmersiveHeaderRenderer.SubscriptionButton2 subscriptionButton2;
        Menu menu;
        SubscriptionButton subscriptionButton;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        int i2 = 7;
        int i3 = 6;
        int i4 = 5;
        int i5 = 3;
        char c = 2;
        int i6 = 0;
        Button button3 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            Runs$$serializer runs$$serializer = Runs$$serializer.INSTANCE;
            Runs runs4 = (Runs) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, runs$$serializer, null);
            Runs runs5 = (Runs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, runs$$serializer, null);
            ThumbnailRenderer thumbnailRenderer2 = (ThumbnailRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, ThumbnailRenderer$$serializer.INSTANCE, null);
            Button$$serializer button$$serializer = Button$$serializer.INSTANCE;
            Button button4 = (Button) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, button$$serializer, null);
            Button button5 = (Button) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, button$$serializer, null);
            SubscriptionButton subscriptionButton3 = (SubscriptionButton) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, SubscriptionButton$$serializer.INSTANCE, null);
            Menu menu2 = (Menu) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 6, Menu$$serializer.INSTANCE, null);
            BrowseResponse.Header.MusicImmersiveHeaderRenderer.SubscriptionButton2 subscriptionButton4 = (BrowseResponse.Header.MusicImmersiveHeaderRenderer.SubscriptionButton2) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 7, BrowseResponse$Header$MusicImmersiveHeaderRenderer$SubscriptionButton2$$serializer.INSTANCE, null);
            runs = (Runs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 8, runs$$serializer, null);
            subscriptionButton2 = subscriptionButton4;
            menu = menu2;
            subscriptionButton = subscriptionButton3;
            button2 = button4;
            i = 511;
            button = button5;
            thumbnailRenderer = thumbnailRenderer2;
            runs2 = runs5;
            runs3 = runs4;
        } else {
            boolean z = true;
            runs = null;
            Button button6 = null;
            BrowseResponse.Header.MusicImmersiveHeaderRenderer.SubscriptionButton2 subscriptionButton5 = null;
            Menu menu3 = null;
            SubscriptionButton subscriptionButton6 = null;
            ThumbnailRenderer thumbnailRenderer3 = null;
            Runs runs6 = null;
            Runs runs7 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case ImageHeaderParser.UNKNOWN_ORIENTATION /* -1 */:
                        z = false;
                        i2 = 7;
                        i3 = 6;
                        i4 = 5;
                        i5 = 3;
                        continue;
                    case 0:
                        runs7 = (Runs) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, Runs$$serializer.INSTANCE, runs7);
                        i6 |= 1;
                        i2 = 7;
                        i3 = 6;
                        i4 = 5;
                        i5 = 3;
                        break;
                    case 1:
                        runs6 = (Runs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, Runs$$serializer.INSTANCE, runs6);
                        i6 |= 2;
                        i2 = 7;
                        i3 = 6;
                        i4 = 5;
                        break;
                    case 2:
                        i6 |= 4;
                        thumbnailRenderer3 = (ThumbnailRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, ThumbnailRenderer$$serializer.INSTANCE, thumbnailRenderer3);
                        c = 2;
                        i2 = 7;
                        i3 = 6;
                        continue;
                    case 3:
                        button3 = (Button) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i5, Button$$serializer.INSTANCE, button3);
                        i6 |= 8;
                        break;
                    case 4:
                        button6 = (Button) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, Button$$serializer.INSTANCE, button6);
                        i6 |= 16;
                        break;
                    case 5:
                        subscriptionButton6 = (SubscriptionButton) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i4, SubscriptionButton$$serializer.INSTANCE, subscriptionButton6);
                        i6 |= 32;
                        break;
                    case 6:
                        menu3 = (Menu) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, i3, Menu$$serializer.INSTANCE, menu3);
                        i6 |= 64;
                        break;
                    case 7:
                        subscriptionButton5 = (BrowseResponse.Header.MusicImmersiveHeaderRenderer.SubscriptionButton2) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i2, BrowseResponse$Header$MusicImmersiveHeaderRenderer$SubscriptionButton2$$serializer.INSTANCE, subscriptionButton5);
                        i6 |= 128;
                        break;
                    case 8:
                        runs = (Runs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 8, Runs$$serializer.INSTANCE, runs);
                        i6 |= 256;
                        break;
                    default:
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                }
                c = 2;
            }
            thumbnailRenderer = thumbnailRenderer3;
            runs2 = runs6;
            runs3 = runs7;
            button = button6;
            i = i6;
            button2 = button3;
            subscriptionButton2 = subscriptionButton5;
            menu = menu3;
            subscriptionButton = subscriptionButton6;
        }
        Runs runs8 = runs;
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new BrowseResponse.Header.MusicImmersiveHeaderRenderer(i, runs3, runs2, thumbnailRenderer, button2, button, subscriptionButton, menu, subscriptionButton2, runs8);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        BrowseResponse.Header.MusicImmersiveHeaderRenderer musicImmersiveHeaderRenderer = (BrowseResponse.Header.MusicImmersiveHeaderRenderer) obj;
        musicImmersiveHeaderRenderer.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        Runs$$serializer runs$$serializer = Runs$$serializer.INSTANCE;
        Runs runs = musicImmersiveHeaderRenderer.title;
        Runs runs2 = musicImmersiveHeaderRenderer.monthlyListenerCount;
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 0, runs$$serializer, runs);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, runs$$serializer, musicImmersiveHeaderRenderer.description);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 2, ThumbnailRenderer$$serializer.INSTANCE, musicImmersiveHeaderRenderer.thumbnail);
        Button$$serializer button$$serializer = Button$$serializer.INSTANCE;
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 3, button$$serializer, musicImmersiveHeaderRenderer.playButton);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 4, button$$serializer, musicImmersiveHeaderRenderer.startRadioButton);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 5, SubscriptionButton$$serializer.INSTANCE, musicImmersiveHeaderRenderer.subscriptionButton);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 6, Menu$$serializer.INSTANCE, musicImmersiveHeaderRenderer.menu);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 7, BrowseResponse$Header$MusicImmersiveHeaderRenderer$SubscriptionButton2$$serializer.INSTANCE, musicImmersiveHeaderRenderer.subscriptionButton2);
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 8) || runs2 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 8, runs$$serializer, runs2);
        }
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
