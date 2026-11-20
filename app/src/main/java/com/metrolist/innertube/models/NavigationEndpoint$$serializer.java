package com.metrolist.innertube.models;

import com.yalantis.ucrop.util.ImageHeaderParser;
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
public final /* synthetic */ class NavigationEndpoint$$serializer implements GeneratedSerializer {
    public static final NavigationEndpoint$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        NavigationEndpoint$$serializer navigationEndpoint$$serializer = new NavigationEndpoint$$serializer();
        INSTANCE = navigationEndpoint$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.NavigationEndpoint", navigationEndpoint$$serializer, 10);
        pluginGeneratedSerialDescriptor.addElement("watchEndpoint", true);
        pluginGeneratedSerialDescriptor.addElement("watchPlaylistEndpoint", true);
        pluginGeneratedSerialDescriptor.addElement("browseEndpoint", true);
        pluginGeneratedSerialDescriptor.addElement("searchEndpoint", true);
        pluginGeneratedSerialDescriptor.addElement("queueAddEndpoint", true);
        pluginGeneratedSerialDescriptor.addElement("shareEntityEndpoint", true);
        pluginGeneratedSerialDescriptor.addElement("feedbackEndpoint", true);
        pluginGeneratedSerialDescriptor.addElement("urlEndpoint", true);
        pluginGeneratedSerialDescriptor.addElement("deletePrivatelyOwnedEntityCommand", true);
        pluginGeneratedSerialDescriptor.addElement("confirmDialogEndpoint", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        WatchEndpoint$$serializer watchEndpoint$$serializer = WatchEndpoint$$serializer.INSTANCE;
        return new KSerializer[]{HexFormatKt.getNullable(watchEndpoint$$serializer), HexFormatKt.getNullable(watchEndpoint$$serializer), HexFormatKt.getNullable(BrowseEndpoint$$serializer.INSTANCE), HexFormatKt.getNullable(SearchEndpoint$$serializer.INSTANCE), HexFormatKt.getNullable(QueueAddEndpoint$$serializer.INSTANCE), HexFormatKt.getNullable(ShareEntityEndpoint$$serializer.INSTANCE), HexFormatKt.getNullable(FeedbackEndpoint$$serializer.INSTANCE), HexFormatKt.getNullable(UrlEndpoint$$serializer.INSTANCE), HexFormatKt.getNullable(NavigationEndpoint$DeletePrivatelyOwnedEntityCommand$$serializer.INSTANCE), HexFormatKt.getNullable(NavigationEndpoint$ConfirmDialogEndpoint$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        WatchEndpoint watchEndpoint;
        BrowseEndpoint browseEndpoint;
        WatchEndpoint watchEndpoint2;
        QueueAddEndpoint queueAddEndpoint;
        int i;
        NavigationEndpoint.DeletePrivatelyOwnedEntityCommand deletePrivatelyOwnedEntityCommand;
        SearchEndpoint searchEndpoint;
        ShareEntityEndpoint shareEntityEndpoint;
        FeedbackEndpoint feedbackEndpoint;
        NavigationEndpoint.ConfirmDialogEndpoint confirmDialogEndpoint;
        UrlEndpoint urlEndpoint;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        int i2 = 9;
        int i3 = 7;
        int i4 = 6;
        char c = 5;
        FeedbackEndpoint feedbackEndpoint2 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            WatchEndpoint$$serializer watchEndpoint$$serializer = WatchEndpoint$$serializer.INSTANCE;
            WatchEndpoint watchEndpoint3 = (WatchEndpoint) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, watchEndpoint$$serializer, null);
            watchEndpoint = (WatchEndpoint) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, watchEndpoint$$serializer, null);
            BrowseEndpoint browseEndpoint2 = (BrowseEndpoint) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, BrowseEndpoint$$serializer.INSTANCE, null);
            SearchEndpoint searchEndpoint2 = (SearchEndpoint) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, SearchEndpoint$$serializer.INSTANCE, null);
            QueueAddEndpoint queueAddEndpoint2 = (QueueAddEndpoint) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, QueueAddEndpoint$$serializer.INSTANCE, null);
            ShareEntityEndpoint shareEntityEndpoint2 = (ShareEntityEndpoint) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, ShareEntityEndpoint$$serializer.INSTANCE, null);
            FeedbackEndpoint feedbackEndpoint3 = (FeedbackEndpoint) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, FeedbackEndpoint$$serializer.INSTANCE, null);
            UrlEndpoint urlEndpoint2 = (UrlEndpoint) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 7, UrlEndpoint$$serializer.INSTANCE, null);
            NavigationEndpoint.DeletePrivatelyOwnedEntityCommand deletePrivatelyOwnedEntityCommand2 = (NavigationEndpoint.DeletePrivatelyOwnedEntityCommand) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 8, NavigationEndpoint$DeletePrivatelyOwnedEntityCommand$$serializer.INSTANCE, null);
            confirmDialogEndpoint = (NavigationEndpoint.ConfirmDialogEndpoint) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 9, NavigationEndpoint$ConfirmDialogEndpoint$$serializer.INSTANCE, null);
            urlEndpoint = urlEndpoint2;
            feedbackEndpoint = feedbackEndpoint3;
            shareEntityEndpoint = shareEntityEndpoint2;
            searchEndpoint = searchEndpoint2;
            deletePrivatelyOwnedEntityCommand = deletePrivatelyOwnedEntityCommand2;
            queueAddEndpoint = queueAddEndpoint2;
            browseEndpoint = browseEndpoint2;
            i = 1023;
            watchEndpoint2 = watchEndpoint3;
        } else {
            boolean z = true;
            int i5 = 0;
            watchEndpoint = null;
            QueueAddEndpoint queueAddEndpoint3 = null;
            NavigationEndpoint.DeletePrivatelyOwnedEntityCommand deletePrivatelyOwnedEntityCommand3 = null;
            SearchEndpoint searchEndpoint3 = null;
            ShareEntityEndpoint shareEntityEndpoint3 = null;
            NavigationEndpoint.ConfirmDialogEndpoint confirmDialogEndpoint2 = null;
            UrlEndpoint urlEndpoint3 = null;
            BrowseEndpoint browseEndpoint3 = null;
            WatchEndpoint watchEndpoint4 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case ImageHeaderParser.UNKNOWN_ORIENTATION /* -1 */:
                        z = false;
                        i2 = 9;
                        i3 = 7;
                        i4 = 6;
                        break;
                    case 0:
                        watchEndpoint4 = (WatchEndpoint) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, WatchEndpoint$$serializer.INSTANCE, watchEndpoint4);
                        i5 |= 1;
                        i2 = 9;
                        i3 = 7;
                        i4 = 6;
                        c = 5;
                        break;
                    case 1:
                        watchEndpoint = (WatchEndpoint) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, WatchEndpoint$$serializer.INSTANCE, watchEndpoint);
                        i5 |= 2;
                        i2 = 9;
                        i3 = 7;
                        c = 5;
                        break;
                    case 2:
                        browseEndpoint3 = (BrowseEndpoint) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, BrowseEndpoint$$serializer.INSTANCE, browseEndpoint3);
                        i5 |= 4;
                        i2 = 9;
                        i3 = 7;
                        c = 5;
                        break;
                    case 3:
                        searchEndpoint3 = (SearchEndpoint) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, SearchEndpoint$$serializer.INSTANCE, searchEndpoint3);
                        i5 |= 8;
                        i2 = 9;
                        c = 5;
                        break;
                    case 4:
                        queueAddEndpoint3 = (QueueAddEndpoint) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, QueueAddEndpoint$$serializer.INSTANCE, queueAddEndpoint3);
                        i5 |= 16;
                        i2 = 9;
                        c = 5;
                        break;
                    case 5:
                        shareEntityEndpoint3 = (ShareEntityEndpoint) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, ShareEntityEndpoint$$serializer.INSTANCE, shareEntityEndpoint3);
                        i5 |= 32;
                        c = 5;
                        i2 = 9;
                        break;
                    case 6:
                        feedbackEndpoint2 = (FeedbackEndpoint) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i4, FeedbackEndpoint$$serializer.INSTANCE, feedbackEndpoint2);
                        i5 |= 64;
                        c = 5;
                        break;
                    case 7:
                        urlEndpoint3 = (UrlEndpoint) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i3, UrlEndpoint$$serializer.INSTANCE, urlEndpoint3);
                        i5 |= 128;
                        c = 5;
                        break;
                    case 8:
                        deletePrivatelyOwnedEntityCommand3 = (NavigationEndpoint.DeletePrivatelyOwnedEntityCommand) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 8, NavigationEndpoint$DeletePrivatelyOwnedEntityCommand$$serializer.INSTANCE, deletePrivatelyOwnedEntityCommand3);
                        i5 |= 256;
                        c = 5;
                        break;
                    case 9:
                        confirmDialogEndpoint2 = (NavigationEndpoint.ConfirmDialogEndpoint) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i2, NavigationEndpoint$ConfirmDialogEndpoint$$serializer.INSTANCE, confirmDialogEndpoint2);
                        i5 |= 512;
                        c = 5;
                        break;
                    default:
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                }
            }
            browseEndpoint = browseEndpoint3;
            watchEndpoint2 = watchEndpoint4;
            queueAddEndpoint = queueAddEndpoint3;
            i = i5;
            deletePrivatelyOwnedEntityCommand = deletePrivatelyOwnedEntityCommand3;
            searchEndpoint = searchEndpoint3;
            shareEntityEndpoint = shareEntityEndpoint3;
            feedbackEndpoint = feedbackEndpoint2;
            confirmDialogEndpoint = confirmDialogEndpoint2;
            urlEndpoint = urlEndpoint3;
        }
        WatchEndpoint watchEndpoint5 = watchEndpoint;
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new NavigationEndpoint(i, watchEndpoint2, watchEndpoint5, browseEndpoint, searchEndpoint, queueAddEndpoint, shareEntityEndpoint, feedbackEndpoint, urlEndpoint, deletePrivatelyOwnedEntityCommand, confirmDialogEndpoint);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        NavigationEndpoint navigationEndpoint = (NavigationEndpoint) obj;
        navigationEndpoint.getClass();
        NavigationEndpoint.ConfirmDialogEndpoint confirmDialogEndpoint = navigationEndpoint.confirmDialogEndpoint;
        NavigationEndpoint.DeletePrivatelyOwnedEntityCommand deletePrivatelyOwnedEntityCommand = navigationEndpoint.deletePrivatelyOwnedEntityCommand;
        UrlEndpoint urlEndpoint = navigationEndpoint.urlEndpoint;
        FeedbackEndpoint feedbackEndpoint = navigationEndpoint.feedbackEndpoint;
        ShareEntityEndpoint shareEntityEndpoint = navigationEndpoint.shareEntityEndpoint;
        QueueAddEndpoint queueAddEndpoint = navigationEndpoint.queueAddEndpoint;
        SearchEndpoint searchEndpoint = navigationEndpoint.searchEndpoint;
        BrowseEndpoint browseEndpoint = navigationEndpoint.browseEndpoint;
        WatchEndpoint watchEndpoint = navigationEndpoint.watchPlaylistEndpoint;
        WatchEndpoint watchEndpoint2 = navigationEndpoint.watchEndpoint;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 0) || watchEndpoint2 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, WatchEndpoint$$serializer.INSTANCE, watchEndpoint2);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 1) || watchEndpoint != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, WatchEndpoint$$serializer.INSTANCE, watchEndpoint);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 2) || browseEndpoint != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 2, BrowseEndpoint$$serializer.INSTANCE, browseEndpoint);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 3) || searchEndpoint != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 3, SearchEndpoint$$serializer.INSTANCE, searchEndpoint);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 4) || queueAddEndpoint != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 4, QueueAddEndpoint$$serializer.INSTANCE, queueAddEndpoint);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 5) || shareEntityEndpoint != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 5, ShareEntityEndpoint$$serializer.INSTANCE, shareEntityEndpoint);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 6) || feedbackEndpoint != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 6, FeedbackEndpoint$$serializer.INSTANCE, feedbackEndpoint);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 7) || urlEndpoint != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 7, UrlEndpoint$$serializer.INSTANCE, urlEndpoint);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 8) || deletePrivatelyOwnedEntityCommand != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 8, NavigationEndpoint$DeletePrivatelyOwnedEntityCommand$$serializer.INSTANCE, deletePrivatelyOwnedEntityCommand);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 9) || confirmDialogEndpoint != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 9, NavigationEndpoint$ConfirmDialogEndpoint$$serializer.INSTANCE, confirmDialogEndpoint);
        }
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
