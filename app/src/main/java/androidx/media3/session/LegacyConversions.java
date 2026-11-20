package androidx.media3.session;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.emoji2.text.EmojiProcessor;
import androidx.media3.common.HeartRating;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.PercentageRating;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.Rating;
import androidx.media3.common.StarRating;
import androidx.media3.common.ThumbRating;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.session.legacy.MediaBrowserCompat;
import androidx.media3.session.legacy.MediaDescriptionCompat;
import androidx.media3.session.legacy.MediaMetadataCompat;
import androidx.media3.session.legacy.PlaybackStateCompat;
import androidx.media3.session.legacy.RatingCompat;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.util.concurrent.ListenableFuture;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.client.utils.CIOKt;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class LegacyConversions {
    public static final ImmutableSet KNOWN_METADATA_COMPAT_KEYS = ImmutableSet.of((Object) "android.media.metadata.TITLE", (Object) "android.media.metadata.ARTIST", (Object) "android.media.metadata.DURATION", (Object) "android.media.metadata.ALBUM", (Object) "android.media.metadata.AUTHOR", (Object) "android.media.metadata.WRITER", (Object[]) new String[]{"android.media.metadata.COMPOSER", "android.media.metadata.COMPILATION", "android.media.metadata.DATE", "android.media.metadata.YEAR", "android.media.metadata.GENRE", "android.media.metadata.TRACK_NUMBER", "android.media.metadata.NUM_TRACKS", "android.media.metadata.DISC_NUMBER", "android.media.metadata.ALBUM_ARTIST", "android.media.metadata.ART", "android.media.metadata.ART_URI", "android.media.metadata.ALBUM_ART", "android.media.metadata.ALBUM_ART_URI", "android.media.metadata.USER_RATING", "android.media.metadata.RATING", "android.media.metadata.DISPLAY_TITLE", "android.media.metadata.DISPLAY_SUBTITLE", "android.media.metadata.DISPLAY_DESCRIPTION", "android.media.metadata.DISPLAY_ICON", "android.media.metadata.DISPLAY_ICON_URI", "android.media.metadata.MEDIA_ID", "android.media.metadata.MEDIA_URI", "android.media.metadata.BT_FOLDER_TYPE", "android.media.metadata.ADVERTISEMENT", "android.media.metadata.DOWNLOAD_STATUS", "androidx.media3.session.EXTRAS_KEY_MEDIA_TYPE_COMPAT"});

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ConversionException extends Exception {
    }

    public static MediaBrowserCompat.MediaItem convertToBrowserItem(MediaItem mediaItem, Bitmap bitmap) {
        MediaDescriptionCompat mediaDescriptionCompatConvertToMediaDescriptionCompat = convertToMediaDescriptionCompat(mediaItem, bitmap);
        MediaMetadata mediaMetadata = mediaItem.mediaMetadata;
        Boolean bool = mediaMetadata.isBrowsable;
        int i = (bool == null || !bool.booleanValue()) ? 0 : 1;
        Boolean bool2 = mediaMetadata.isPlayable;
        if (bool2 != null && bool2.booleanValue()) {
            i |= 2;
        }
        return new MediaBrowserCompat.MediaItem(mediaDescriptionCompatConvertToMediaDescriptionCompat, i);
    }

    public static long convertToBufferedPositionMs(PlaybackStateCompat playbackStateCompat, MediaMetadataCompat mediaMetadataCompat, long j) {
        long j2 = playbackStateCompat == null ? 0L : playbackStateCompat.bufferedPosition;
        long jConvertToCurrentPositionMs = convertToCurrentPositionMs(playbackStateCompat, mediaMetadataCompat, j);
        long jConvertToDurationMs = convertToDurationMs(mediaMetadataCompat);
        return jConvertToDurationMs == -9223372036854775807L ? Math.max(jConvertToCurrentPositionMs, j2) : Util.constrainValue(j2, jConvertToCurrentPositionMs, jConvertToDurationMs);
    }

    public static long convertToCurrentPositionMs(PlaybackStateCompat playbackStateCompat, MediaMetadataCompat mediaMetadataCompat, long j) {
        if (playbackStateCompat == null) {
            return 0L;
        }
        long jMax = playbackStateCompat.position;
        if (playbackStateCompat.state == 3) {
            Long lValueOf = j == -9223372036854775807L ? null : Long.valueOf(j);
            jMax = Math.max(0L, jMax + ((long) (playbackStateCompat.speed * (lValueOf != null ? lValueOf.longValue() : SystemClock.elapsedRealtime() - playbackStateCompat.updateTime))));
        }
        long j2 = jMax;
        long jConvertToDurationMs = convertToDurationMs(mediaMetadataCompat);
        return jConvertToDurationMs == -9223372036854775807L ? Math.max(0L, j2) : Util.constrainValue(j2, 0L, jConvertToDurationMs);
    }

    public static long convertToDurationMs(MediaMetadataCompat mediaMetadataCompat) {
        if (mediaMetadataCompat == null || !mediaMetadataCompat.bundle.containsKey("android.media.metadata.DURATION")) {
            return -9223372036854775807L;
        }
        long j = mediaMetadataCompat.getLong("android.media.metadata.DURATION");
        if (j <= 0) {
            return -9223372036854775807L;
        }
        return j;
    }

    public static long convertToExtraBtFolderType(int i) {
        switch (i) {
            case 0:
                return 0L;
            case 1:
                return 1L;
            case 2:
                return 2L;
            case 3:
                return 3L;
            case 4:
                return 4L;
            case 5:
                return 5L;
            case 6:
                return 6L;
            default:
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1(IntIntPair$$ExternalSyntheticOutline0.m(i, "Unrecognized FolderType: "));
                return 0L;
        }
    }

    public static int convertToFolderType(long j) {
        if (j == 0) {
            return 0;
        }
        if (j == 1) {
            return 1;
        }
        if (j == 2) {
            return 2;
        }
        if (j == 3) {
            return 3;
        }
        if (j == 4) {
            return 4;
        }
        if (j == 5) {
            return 5;
        }
        return j == 6 ? 6 : 0;
    }

    public static int convertToLegacyErrorCode(int i) {
        if (i == -110) {
            return 8;
        }
        if (i == -109) {
            return 11;
        }
        if (i == -6) {
            return 2;
        }
        if (i == -2) {
            return 1;
        }
        if (i == 1) {
            return 10;
        }
        switch (i) {
            case -107:
                return 9;
            case -106:
                return 7;
            case -105:
                return 6;
            case -104:
                return 5;
            case -103:
                return 4;
            case -102:
                return 3;
            default:
                return 0;
        }
    }

    public static MediaLibraryService.LibraryParams convertToLibraryParams(Context context, Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        try {
            bundle.setClassLoader(context.getClassLoader());
            int i = bundle.getInt("androidx.media.MediaBrowserCompat.Extras.KEY_ROOT_CHILDREN_SUPPORTED_FLAGS", -1);
            if (i >= 0) {
                bundle.remove("androidx.media.MediaBrowserCompat.Extras.KEY_ROOT_CHILDREN_SUPPORTED_FLAGS");
                boolean z = true;
                if (i != 1) {
                    z = false;
                }
                bundle.putBoolean("androidx.media3.session.LibraryParams.Extras.KEY_ROOT_CHILDREN_BROWSABLE_ONLY", z);
            }
            Bundle bundle2 = Bundle.EMPTY;
            return new MediaLibraryService.LibraryParams(bundle, bundle.getBoolean("android.service.media.extra.RECENT"), bundle.getBoolean("android.service.media.extra.OFFLINE"), bundle.getBoolean("android.service.media.extra.SUGGESTED"));
        } catch (Exception unused) {
            Bundle bundle3 = Bundle.EMPTY;
            return new MediaLibraryService.LibraryParams(bundle, false, false, false);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:51:0x00bf  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static MediaDescriptionCompat convertToMediaDescriptionCompat(MediaItem mediaItem, Bitmap bitmap) {
        int i;
        CharSequence charSequence;
        String str = mediaItem.mediaId.equals("") ? null : mediaItem.mediaId;
        MediaMetadata mediaMetadata = mediaItem.mediaMetadata;
        Bitmap bitmap2 = bitmap != null ? bitmap : null;
        Bundle bundle = mediaMetadata.extras;
        CharSequence charSequence2 = mediaMetadata.title;
        CharSequence charSequence3 = mediaMetadata.description;
        CharSequence charSequence4 = mediaMetadata.subtitle;
        ImmutableList immutableList = mediaMetadata.supportedCommands;
        Integer num = mediaMetadata.mediaType;
        Integer num2 = mediaMetadata.folderType;
        if (bundle != null) {
            bundle = new Bundle(bundle);
        }
        boolean z = (num2 == null || num2.intValue() == -1) ? false : true;
        boolean z2 = num != null;
        if (z || z2) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            if (z) {
                num2.getClass();
                i = 0;
                bundle.putLong("android.media.extra.BT_FOLDER_TYPE", convertToExtraBtFolderType(num2.intValue()));
            } else {
                i = 0;
            }
            if (z2) {
                num.getClass();
                bundle.putLong("androidx.media3.session.EXTRAS_KEY_MEDIA_TYPE_COMPAT", num.intValue());
            }
        } else {
            i = 0;
        }
        if (!immutableList.isEmpty()) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putStringArrayList("androidx.media.utils.extras.CUSTOM_BROWSER_ACTION_ID_LIST", new ArrayList<>(immutableList));
        }
        CharSequence charSequence5 = mediaMetadata.displayTitle;
        if (charSequence5 != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putCharSequence("androidx.media3.mediadescriptioncompat.title", charSequence2);
        } else {
            int i2 = 3;
            CharSequence[] charSequenceArr = new CharSequence[3];
            int i3 = i;
            int i4 = i3;
            while (true) {
                int i5 = 2;
                if (i3 < i2) {
                    String[] strArr = MediaMetadataCompat.PREFERRED_DESCRIPTION_ORDER;
                    if (i4 < strArr.length) {
                        int i6 = i4 + 1;
                        String str2 = strArr[i4];
                        str2.getClass();
                        switch (str2.hashCode()) {
                            case -1853648227:
                                if (!str2.equals("android.media.metadata.ARTIST")) {
                                    i5 = -1;
                                } else {
                                    i5 = i;
                                }
                                break;
                            case -1850878751:
                                if (!str2.equals("android.media.metadata.AUTHOR")) {
                                    i5 = -1;
                                } else {
                                    i5 = 1;
                                }
                                break;
                            case -1224124471:
                                if (!str2.equals("android.media.metadata.WRITER")) {
                                    i5 = -1;
                                }
                                break;
                            case 194702059:
                                if (!str2.equals("android.media.metadata.DISPLAY_SUBTITLE")) {
                                    i5 = -1;
                                } else {
                                    i5 = 3;
                                }
                                break;
                            case 1058837545:
                                if (!str2.equals("android.media.metadata.DISPLAY_DESCRIPTION")) {
                                    i5 = -1;
                                } else {
                                    i5 = 4;
                                }
                                break;
                            case 1684534006:
                                if (!str2.equals("android.media.metadata.COMPOSER")) {
                                    i5 = -1;
                                } else {
                                    i5 = 5;
                                }
                                break;
                            case 1879671865:
                                if (!str2.equals("android.media.metadata.ALBUM")) {
                                    i5 = -1;
                                } else {
                                    i5 = 6;
                                }
                                break;
                            case 1897146402:
                                if (!str2.equals("android.media.metadata.TITLE")) {
                                    i5 = -1;
                                } else {
                                    i5 = 7;
                                }
                                break;
                            case 1965214221:
                                if (!str2.equals("android.media.metadata.ALBUM_ARTIST")) {
                                    i5 = -1;
                                } else {
                                    i5 = 8;
                                }
                                break;
                            default:
                                i5 = -1;
                                break;
                        }
                        switch (i5) {
                            case 0:
                                charSequence = mediaMetadata.artist;
                                break;
                            case 1:
                            default:
                                charSequence = null;
                                break;
                            case 2:
                                charSequence = mediaMetadata.writer;
                                break;
                            case 3:
                                charSequence = charSequence4;
                                break;
                            case 4:
                                charSequence = charSequence3;
                                break;
                            case 5:
                                charSequence = mediaMetadata.composer;
                                break;
                            case 6:
                                charSequence = mediaMetadata.albumTitle;
                                break;
                            case 7:
                                charSequence = charSequence2;
                                break;
                            case 8:
                                charSequence = mediaMetadata.albumArtist;
                                break;
                        }
                        if (!TextUtils.isEmpty(charSequence)) {
                            charSequenceArr[i3] = charSequence;
                            i3++;
                        }
                        i4 = i6;
                        i2 = 3;
                    }
                }
            }
            charSequence5 = charSequenceArr[i];
            charSequence4 = charSequenceArr[1];
            charSequence3 = charSequenceArr[2];
        }
        return new MediaDescriptionCompat(str, charSequence5, charSequence4, charSequence3, bitmap2, mediaMetadata.artworkUri, bundle, mediaItem.requestMetadata.mediaUri);
    }

    public static MediaItem convertToMediaItem(String str, MediaMetadataCompat mediaMetadataCompat, int i) {
        MediaItem.Builder builder = new MediaItem.Builder();
        if (str != null) {
            builder.mediaId = str;
        }
        CharSequence charSequence = mediaMetadataCompat.bundle.getCharSequence("android.media.metadata.MEDIA_URI");
        String string = charSequence != null ? charSequence.toString() : null;
        if (string != null) {
            EmojiProcessor emojiProcessor = new EmojiProcessor((byte) 20);
            emojiProcessor.mSpanFactory = Uri.parse(string);
            builder.requestMetadata = new MediaItem.RequestMetadata(emojiProcessor);
        }
        builder.mediaMetadata = convertToMediaMetadata(mediaMetadataCompat, i);
        return builder.build();
    }

    public static MediaMetadata convertToMediaMetadata(MediaMetadataCompat mediaMetadataCompat, int i) {
        CharSequence charSequence;
        CharSequence charSequence2;
        RatingCompat ratingCompatFromRating;
        RatingCompat ratingCompatFromRating2;
        RatingCompat ratingCompat;
        String[] strArr;
        int i2;
        String string;
        if (mediaMetadataCompat == null) {
            return MediaMetadata.EMPTY;
        }
        Bundle bundle = mediaMetadataCompat.bundle;
        MediaMetadata.Builder builder = new MediaMetadata.Builder();
        CharSequence charSequence3 = bundle.getCharSequence("android.media.metadata.DISPLAY_TITLE");
        if (charSequence3 != null) {
            charSequence2 = bundle.getCharSequence("android.media.metadata.DISPLAY_SUBTITLE");
            charSequence = bundle.getCharSequence("android.media.metadata.DISPLAY_DESCRIPTION");
        } else {
            CharSequence[] charSequenceArr = new CharSequence[3];
            int i3 = 0;
            int i4 = 0;
            while (i3 < 3) {
                String[] strArr2 = MediaMetadataCompat.PREFERRED_DESCRIPTION_ORDER;
                if (i4 >= strArr2.length) {
                    break;
                }
                int i5 = i4 + 1;
                CharSequence charSequence4 = bundle.getCharSequence(strArr2[i4]);
                if (!TextUtils.isEmpty(charSequence4)) {
                    charSequenceArr[i3] = charSequence4;
                    i3++;
                }
                i4 = i5;
            }
            CharSequence charSequence5 = charSequenceArr[0];
            CharSequence charSequence6 = charSequenceArr[1];
            charSequence = charSequenceArr[2];
            charSequence3 = charSequence5;
            charSequence2 = charSequence6;
        }
        CharSequence charSequence7 = bundle.getCharSequence("android.media.metadata.TITLE");
        if (charSequence7 == null) {
            charSequence7 = charSequence3;
        }
        builder.title = charSequence7;
        builder.displayTitle = charSequence3;
        builder.subtitle = charSequence2;
        builder.description = charSequence;
        builder.artist = bundle.getCharSequence("android.media.metadata.ARTIST");
        builder.albumTitle = bundle.getCharSequence("android.media.metadata.ALBUM");
        builder.albumArtist = bundle.getCharSequence("android.media.metadata.ALBUM_ARTIST");
        byte[] bArr = null;
        try {
            ratingCompatFromRating = RatingCompat.fromRating(bundle.getParcelable("android.media.metadata.RATING"));
        } catch (Exception e) {
            Log.w("MediaMetadata", "Failed to retrieve a key as Rating.", e);
            ratingCompatFromRating = null;
        }
        builder.overallRating = convertToRating(ratingCompatFromRating);
        if (bundle.containsKey("android.media.metadata.DURATION")) {
            long j = mediaMetadataCompat.getLong("android.media.metadata.DURATION");
            if (j >= 0) {
                builder.setDurationMs(Long.valueOf(j));
            }
        }
        try {
            ratingCompatFromRating2 = RatingCompat.fromRating(bundle.getParcelable("android.media.metadata.USER_RATING"));
            while (true) {
                if (i2 < 3) {
                    String str = strArr[i2];
                    if (bundle.containsKey(str)) {
                        CharSequence charSequence8 = bundle.getCharSequence(str);
                        if (charSequence8 != null) {
                            string = charSequence8.toString();
                        }
                    } else {
                        i2++;
                    }
                }
                string = null;
            }
        } catch (Exception e2) {
            Log.w("MediaMetadata", "Failed to retrieve a key as Rating.", e2);
            ratingCompatFromRating2 = null;
        }
        Rating ratingConvertToRating = convertToRating(ratingCompatFromRating2);
        if (ratingConvertToRating != null) {
            builder.userRating = ratingConvertToRating;
        } else {
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    ratingCompat = new RatingCompat(i, -1.0f);
                    break;
                default:
                    ratingCompat = null;
                    break;
            }
            builder.userRating = convertToRating(ratingCompat);
        }
        if (bundle.containsKey("android.media.metadata.YEAR")) {
            builder.recordingYear = Integer.valueOf((int) mediaMetadataCompat.getLong("android.media.metadata.YEAR"));
        }
        strArr = new String[]{"android.media.metadata.DISPLAY_ICON_URI", "android.media.metadata.ALBUM_ART_URI", "android.media.metadata.ART_URI"};
        i2 = 0;
        Uri uri = string != null ? Uri.parse(string) : null;
        if (uri != null) {
            builder.artworkUri = uri;
        }
        Bitmap mostRelevantArtworkBitmap = mediaMetadataCompat.getMostRelevantArtworkBitmap();
        if (mostRelevantArtworkBitmap != null) {
            if (mediaMetadataCompat.compressedArtworkData == null) {
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        mostRelevantArtworkBitmap.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
                        mediaMetadataCompat.compressedArtworkData = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.close();
                    } catch (Throwable th) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                } catch (IOException e3) {
                    Log.w("MediaMetadata", "Failed to compress MediaMetadataCompat artwork", e3);
                }
            }
            bArr = mediaMetadataCompat.compressedArtworkData;
        }
        if (bArr != null) {
            builder.setArtworkData(bArr, 3);
        }
        boolean zContainsKey = bundle.containsKey("android.media.metadata.BT_FOLDER_TYPE");
        builder.isBrowsable = Boolean.valueOf(zContainsKey);
        if (zContainsKey) {
            builder.folderType = Integer.valueOf(convertToFolderType(mediaMetadataCompat.getLong("android.media.metadata.BT_FOLDER_TYPE")));
        }
        if (bundle.containsKey("androidx.media3.session.EXTRAS_KEY_MEDIA_TYPE_COMPAT")) {
            builder.mediaType = Integer.valueOf((int) mediaMetadataCompat.getLong("androidx.media3.session.EXTRAS_KEY_MEDIA_TYPE_COMPAT"));
        }
        builder.isPlayable = Boolean.TRUE;
        Bundle bundle2 = new Bundle(bundle);
        UnmodifiableIterator it = KNOWN_METADATA_COMPAT_KEYS.iterator();
        while (it.hasNext()) {
            bundle2.remove((String) it.next());
        }
        if (!bundle2.isEmpty()) {
            builder.extras = bundle2;
        }
        return new MediaMetadata(builder);
    }

    public static MediaMetadataCompat convertToMediaMetadataCompat(MediaMetadata mediaMetadata, String str, Uri uri, long j, Bitmap bitmap) {
        Long l;
        MediaBrowserCompat mediaBrowserCompat = new MediaBrowserCompat();
        mediaBrowserCompat.impl = new Bundle();
        mediaBrowserCompat.putString("android.media.metadata.MEDIA_ID", str);
        CharSequence charSequence = mediaMetadata.title;
        Bundle bundle = mediaMetadata.extras;
        Integer num = mediaMetadata.folderType;
        Uri uri2 = mediaMetadata.artworkUri;
        if (charSequence != null) {
            mediaBrowserCompat.putText(charSequence, "android.media.metadata.TITLE");
        }
        CharSequence charSequence2 = mediaMetadata.displayTitle;
        if (charSequence2 != null) {
            mediaBrowserCompat.putText(charSequence2, "android.media.metadata.DISPLAY_TITLE");
        }
        CharSequence charSequence3 = mediaMetadata.subtitle;
        if (charSequence3 != null) {
            mediaBrowserCompat.putText(charSequence3, "android.media.metadata.DISPLAY_SUBTITLE");
        }
        CharSequence charSequence4 = mediaMetadata.description;
        if (charSequence4 != null) {
            mediaBrowserCompat.putText(charSequence4, "android.media.metadata.DISPLAY_DESCRIPTION");
        }
        CharSequence charSequence5 = mediaMetadata.artist;
        if (charSequence5 != null) {
            mediaBrowserCompat.putText(charSequence5, "android.media.metadata.ARTIST");
        }
        CharSequence charSequence6 = mediaMetadata.albumTitle;
        if (charSequence6 != null) {
            mediaBrowserCompat.putText(charSequence6, "android.media.metadata.ALBUM");
        }
        CharSequence charSequence7 = mediaMetadata.albumArtist;
        if (charSequence7 != null) {
            mediaBrowserCompat.putText(charSequence7, "android.media.metadata.ALBUM_ARTIST");
        }
        Integer num2 = mediaMetadata.recordingYear;
        if (num2 != null) {
            mediaBrowserCompat.putLong(num2.intValue(), "android.media.metadata.YEAR");
        }
        CharSequence charSequence8 = mediaMetadata.writer;
        if (charSequence8 != null) {
            mediaBrowserCompat.putText(charSequence8, "android.media.metadata.WRITER");
        }
        CharSequence charSequence9 = mediaMetadata.composer;
        if (charSequence9 != null) {
            mediaBrowserCompat.putText(charSequence9, "android.media.metadata.COMPOSER");
        }
        if (uri != null) {
            mediaBrowserCompat.putString("android.media.metadata.MEDIA_URI", uri.toString());
        }
        if (uri2 != null) {
            mediaBrowserCompat.putString("android.media.metadata.DISPLAY_ICON_URI", uri2.toString());
            mediaBrowserCompat.putString("android.media.metadata.ALBUM_ART_URI", uri2.toString());
            mediaBrowserCompat.putString("android.media.metadata.ART_URI", uri2.toString());
        }
        if (bitmap != null) {
            mediaBrowserCompat.putBitmap("android.media.metadata.DISPLAY_ICON", bitmap);
            mediaBrowserCompat.putBitmap("android.media.metadata.ALBUM_ART", bitmap);
        }
        if (num != null && num.intValue() != -1) {
            mediaBrowserCompat.putLong(convertToExtraBtFolderType(num.intValue()), "android.media.metadata.BT_FOLDER_TYPE");
        }
        if (j == -9223372036854775807L && (l = mediaMetadata.durationMs) != null) {
            j = l.longValue();
        }
        if (j == -9223372036854775807L) {
            j = -1;
        }
        mediaBrowserCompat.putLong(j, "android.media.metadata.DURATION");
        RatingCompat ratingCompatConvertToRatingCompat = convertToRatingCompat(mediaMetadata.userRating);
        if (ratingCompatConvertToRatingCompat != null) {
            mediaBrowserCompat.putRating("android.media.metadata.USER_RATING", ratingCompatConvertToRatingCompat);
        }
        RatingCompat ratingCompatConvertToRatingCompat2 = convertToRatingCompat(mediaMetadata.overallRating);
        if (ratingCompatConvertToRatingCompat2 != null) {
            mediaBrowserCompat.putRating("android.media.metadata.RATING", ratingCompatConvertToRatingCompat2);
        }
        Integer num3 = mediaMetadata.mediaType;
        if (num3 != null) {
            mediaBrowserCompat.putLong(num3.intValue(), "androidx.media3.session.EXTRAS_KEY_MEDIA_TYPE_COMPAT");
        }
        if (bundle != null) {
            for (String str2 : bundle.keySet()) {
                Object obj = bundle.get(str2);
                if (obj == null || (obj instanceof CharSequence)) {
                    mediaBrowserCompat.putText((CharSequence) obj, str2);
                } else if ((obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long)) {
                    mediaBrowserCompat.putLong(((Number) obj).longValue(), str2);
                }
            }
        }
        return new MediaMetadataCompat((Bundle) mediaBrowserCompat.impl);
    }

    public static PlaybackException convertToPlaybackException(PlaybackStateCompat playbackStateCompat, Context context) {
        if (playbackStateCompat != null) {
            int i = playbackStateCompat.errorCode;
            if (playbackStateCompat.state == 7) {
                CharSequence sessionErrorMessage = playbackStateCompat.errorMessage;
                if (sessionErrorMessage == null) {
                    sessionErrorMessage = getSessionErrorMessage(context, convertToSessionErrorCode(i));
                }
                Bundle bundle = playbackStateCompat.extras;
                String string = sessionErrorMessage != null ? sessionErrorMessage.toString() : null;
                int iConvertToSessionErrorCode = convertToSessionErrorCode(i);
                if (iConvertToSessionErrorCode == -5) {
                    iConvertToSessionErrorCode = 2000;
                } else if (iConvertToSessionErrorCode == -1) {
                    iConvertToSessionErrorCode = CIOKt.DEFAULT_HTTP_POOL_SIZE;
                }
                int i2 = iConvertToSessionErrorCode;
                if (bundle == null) {
                    bundle = Bundle.EMPTY;
                }
                return new PlaybackException(string, null, i2, bundle, SystemClock.elapsedRealtime());
            }
        }
        return null;
    }

    public static int convertToPlaybackStateCompatRepeatMode(int i) {
        if (i == 0) {
            return 0;
        }
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                Log.w("LegacyConversions", "Unrecognized RepeatMode: " + i + " was converted to `PlaybackStateCompat.REPEAT_MODE_NONE`");
                return 0;
            }
        }
        return i2;
    }

    public static Rating convertToRating(RatingCompat ratingCompat) {
        if (ratingCompat == null) {
            return null;
        }
        float f = ratingCompat.ratingValue;
        int i = ratingCompat.ratingStyle;
        switch (i) {
            case 1:
                if (ratingCompat.isRated()) {
                    return new HeartRating(i == 1 && f == 1.0f);
                }
                return new HeartRating();
            case 2:
                if (ratingCompat.isRated()) {
                    return new ThumbRating(i == 2 && f == 1.0f);
                }
                return new ThumbRating();
            case 3:
                return ratingCompat.isRated() ? new StarRating(3, ratingCompat.getStarRating()) : new StarRating(3);
            case 4:
                return ratingCompat.isRated() ? new StarRating(4, ratingCompat.getStarRating()) : new StarRating(4);
            case 5:
                return ratingCompat.isRated() ? new StarRating(5, ratingCompat.getStarRating()) : new StarRating(5);
            case 6:
                if (!ratingCompat.isRated()) {
                    return new PercentageRating();
                }
                if (i != 6 || !ratingCompat.isRated()) {
                    f = -1.0f;
                }
                return new PercentageRating(f);
            default:
                return null;
        }
    }

    public static RatingCompat convertToRatingCompat(Rating rating) {
        if (rating != null) {
            int ratingCompatStyle = getRatingCompatStyle(rating);
            if (!rating.isRated()) {
                switch (ratingCompatStyle) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        return new RatingCompat(ratingCompatStyle, -1.0f);
                    default:
                        return null;
                }
            }
            float f = CropImageView.DEFAULT_ASPECT_RATIO;
            switch (ratingCompatStyle) {
                case 1:
                    if (((HeartRating) rating).isHeart) {
                        f = 1.0f;
                    }
                    return new RatingCompat(1, f);
                case 2:
                    if (((ThumbRating) rating).isThumbsUp) {
                        f = 1.0f;
                    }
                    return new RatingCompat(2, f);
                case 3:
                case 4:
                case 5:
                    return RatingCompat.newStarRating(ratingCompatStyle, ((StarRating) rating).starRating);
                case 6:
                    return RatingCompat.newPercentageRating(((PercentageRating) rating).percent);
            }
        }
        return null;
    }

    public static int convertToRepeatMode(int i) {
        if (i == -1 || i == 0) {
            return 0;
        }
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2 && i != 3) {
                Log.w("LegacyConversions", "Unrecognized PlaybackStateCompat.RepeatMode: " + i + " was converted to `Player.REPEAT_MODE_OFF`");
                return 0;
            }
        }
        return i2;
    }

    public static int convertToSessionErrorCode(int i) {
        switch (i) {
            case 1:
                return -2;
            case 2:
                return -6;
            case 3:
                return -102;
            case 4:
                return -103;
            case 5:
                return -104;
            case 6:
                return -105;
            case 7:
                return -106;
            case 8:
                return -110;
            case 9:
                return -107;
            case 10:
                return 1;
            case 11:
                return -109;
            default:
                return -1;
        }
    }

    public static boolean convertToShuffleModeEnabled(int i) {
        if (i == -1 || i == 0) {
            return false;
        }
        if (i == 1 || i == 2) {
            return true;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1(IntIntPair$$ExternalSyntheticOutline0.m(i, "Unrecognized ShuffleMode: "));
        return false;
    }

    public static void getFutureResult(ListenableFuture listenableFuture) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        boolean z = false;
        long j = 3000;
        while (true) {
            try {
                try {
                    listenableFuture.get(j, TimeUnit.MILLISECONDS);
                    if (z) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                    return;
                } catch (InterruptedException unused) {
                    z = true;
                    long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                    if (jElapsedRealtime2 >= 3000) {
                        throw new TimeoutException();
                    }
                    j = 3000 - jElapsedRealtime2;
                }
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
    }

    public static int getRatingCompatStyle(Rating rating) {
        if (rating instanceof HeartRating) {
            return 1;
        }
        if (rating instanceof ThumbRating) {
            return 2;
        }
        if (!(rating instanceof StarRating)) {
            return rating instanceof PercentageRating ? 6 : 0;
        }
        int i = ((StarRating) rating).maxStars;
        int i2 = 3;
        if (i != 3) {
            i2 = 4;
            if (i != 4) {
                i2 = 5;
                if (i != 5) {
                    return 0;
                }
            }
        }
        return i2;
    }

    public static String getSessionErrorMessage(Context context, int i) {
        if (i == -100) {
            return context.getString(R.string.error_message_disconnected);
        }
        if (i == 1) {
            return context.getString(R.string.error_message_info_cancelled);
        }
        if (i == -6) {
            return context.getString(R.string.error_message_not_supported);
        }
        if (i == -5) {
            return context.getString(R.string.error_message_io);
        }
        if (i == -4) {
            return context.getString(R.string.error_message_permission_denied);
        }
        if (i == -3) {
            return context.getString(R.string.error_message_bad_value);
        }
        if (i == -2) {
            return context.getString(R.string.error_message_invalid_state);
        }
        switch (i) {
            case -110:
                return context.getString(R.string.error_message_content_already_playing);
            case -109:
                return context.getString(R.string.error_message_end_of_playlist);
            case -108:
                return context.getString(R.string.error_message_setup_required);
            case -107:
                return context.getString(R.string.error_message_skip_limit_reached);
            case -106:
                return context.getString(R.string.error_message_not_available_in_region);
            case -105:
                return context.getString(R.string.error_message_parental_control_restricted);
            case -104:
                return context.getString(R.string.error_message_concurrent_stream_limit);
            case -103:
                return context.getString(R.string.error_message_premium_account_required);
            case -102:
                return context.getString(R.string.error_message_authentication_expired);
            default:
                return context.getString(R.string.error_message_fallback);
        }
    }

    public static boolean hasAction(long j, long j2) {
        return (j & j2) != 0;
    }

    public static MediaItem convertToMediaItem(MediaDescriptionCompat mediaDescriptionCompat) {
        mediaDescriptionCompat.getClass();
        String str = mediaDescriptionCompat.mediaId;
        MediaItem.Builder builder = new MediaItem.Builder();
        if (str == null) {
            str = "";
        }
        builder.mediaId = str;
        EmojiProcessor emojiProcessor = new EmojiProcessor((byte) 20);
        emojiProcessor.mSpanFactory = mediaDescriptionCompat.mediaUri;
        builder.requestMetadata = new MediaItem.RequestMetadata(emojiProcessor);
        builder.mediaMetadata = convertToMediaMetadata(mediaDescriptionCompat, 0);
        return builder.build();
    }

    public static MediaMetadata convertToMediaMetadata(MediaDescriptionCompat mediaDescriptionCompat, int i) {
        RatingCompat ratingCompat;
        byte[] bArr;
        if (mediaDescriptionCompat == null) {
            return MediaMetadata.EMPTY;
        }
        CharSequence charSequence = mediaDescriptionCompat.title;
        MediaMetadata.Builder builder = new MediaMetadata.Builder();
        builder.subtitle = mediaDescriptionCompat.subtitle;
        builder.description = mediaDescriptionCompat.description;
        builder.artworkUri = mediaDescriptionCompat.iconUri;
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                ratingCompat = new RatingCompat(i, -1.0f);
                break;
            default:
                ratingCompat = null;
                break;
        }
        builder.userRating = convertToRating(ratingCompat);
        Bitmap bitmap = mediaDescriptionCompat.icon;
        if (bitmap == null) {
            bArr = null;
        } else {
            if (mediaDescriptionCompat.compressedIcon == null) {
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        bitmap.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
                        mediaDescriptionCompat.compressedIcon = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.close();
                    } catch (Throwable th) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                } catch (IOException e) {
                    Log.w("MediaDescriptionCompat", "Failed to compress MediaDescriptionCompat artwork", e);
                }
            }
            bArr = mediaDescriptionCompat.compressedIcon;
        }
        if (bArr != null) {
            builder.setArtworkData(bArr, 3);
        }
        Bundle bundle = mediaDescriptionCompat.extras;
        Bundle bundle2 = bundle != null ? new Bundle(bundle) : null;
        if (bundle2 != null && bundle2.containsKey("android.media.extra.BT_FOLDER_TYPE")) {
            builder.folderType = Integer.valueOf(convertToFolderType(bundle2.getLong("android.media.extra.BT_FOLDER_TYPE")));
            bundle2.remove("android.media.extra.BT_FOLDER_TYPE");
        }
        builder.isBrowsable = Boolean.FALSE;
        if (bundle2 != null && bundle2.containsKey("androidx.media3.session.EXTRAS_KEY_MEDIA_TYPE_COMPAT")) {
            builder.mediaType = Integer.valueOf((int) bundle2.getLong("androidx.media3.session.EXTRAS_KEY_MEDIA_TYPE_COMPAT"));
            bundle2.remove("androidx.media3.session.EXTRAS_KEY_MEDIA_TYPE_COMPAT");
        }
        if (bundle2 != null && bundle2.containsKey("androidx.media.utils.extras.CUSTOM_BROWSER_ACTION_ID_LIST")) {
            ArrayList<String> stringArrayList = bundle2.getStringArrayList("androidx.media.utils.extras.CUSTOM_BROWSER_ACTION_ID_LIST");
            stringArrayList.getClass();
            builder.supportedCommands = ImmutableList.copyOf((Collection) ImmutableList.copyOf((Collection) stringArrayList));
        }
        if (bundle2 != null && bundle2.containsKey("androidx.media3.mediadescriptioncompat.title")) {
            builder.title = bundle2.getCharSequence("androidx.media3.mediadescriptioncompat.title");
            builder.displayTitle = charSequence;
            bundle2.remove("androidx.media3.mediadescriptioncompat.title");
        } else {
            builder.title = charSequence;
        }
        if (bundle2 != null && !bundle2.isEmpty()) {
            builder.extras = bundle2;
        }
        builder.isPlayable = Boolean.TRUE;
        return new MediaMetadata(builder);
    }
}
