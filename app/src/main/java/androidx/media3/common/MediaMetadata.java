package androidx.media3.common;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import androidx.media3.common.util.Util;
import coil3.util.UtilsKt;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import io.ktor.client.utils.CIOKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MediaMetadata {
    public static final MediaMetadata EMPTY = new MediaMetadata(new Builder());
    public static final String FIELD_ALBUM_ARTIST;
    public static final String FIELD_ALBUM_TITLE;
    public static final String FIELD_ARTIST;
    public static final String FIELD_ARTWORK_DATA;
    public static final String FIELD_ARTWORK_DATA_TYPE;
    public static final String FIELD_ARTWORK_URI;
    public static final String FIELD_COMPILATION;
    public static final String FIELD_COMPOSER;
    public static final String FIELD_CONDUCTOR;
    public static final String FIELD_DESCRIPTION;
    public static final String FIELD_DISC_NUMBER;
    public static final String FIELD_DISPLAY_TITLE;
    public static final String FIELD_DURATION_MS;
    public static final String FIELD_EXTRAS;
    public static final String FIELD_FOLDER_TYPE;
    public static final String FIELD_GENRE;
    public static final String FIELD_IS_BROWSABLE;
    public static final String FIELD_IS_PLAYABLE;
    public static final String FIELD_MEDIA_TYPE;
    public static final String FIELD_OVERALL_RATING;
    public static final String FIELD_RECORDING_DAY;
    public static final String FIELD_RECORDING_MONTH;
    public static final String FIELD_RECORDING_YEAR;
    public static final String FIELD_RELEASE_DAY;
    public static final String FIELD_RELEASE_MONTH;
    public static final String FIELD_RELEASE_YEAR;
    public static final String FIELD_STATION;
    public static final String FIELD_SUBTITLE;
    public static final String FIELD_SUPPORTED_COMMANDS;
    public static final String FIELD_TITLE;
    public static final String FIELD_TOTAL_DISC_COUNT;
    public static final String FIELD_TOTAL_TRACK_COUNT;
    public static final String FIELD_TRACK_NUMBER;
    public static final String FIELD_USER_RATING;
    public static final String FIELD_WRITER;
    public final CharSequence albumArtist;
    public final CharSequence albumTitle;
    public final CharSequence artist;
    public final byte[] artworkData;
    public final Integer artworkDataType;
    public final Uri artworkUri;
    public BundleableByteArray bundleableArtworkData;
    public final CharSequence compilation;
    public final CharSequence composer;
    public final CharSequence conductor;
    public final CharSequence description;
    public final Integer discNumber;
    public final CharSequence displayTitle;
    public final Long durationMs;
    public final Bundle extras;
    public final Integer folderType;
    public final CharSequence genre;
    public final Boolean isBrowsable;
    public final Boolean isPlayable;
    public final Integer mediaType;
    public final Rating overallRating;
    public final Integer recordingDay;
    public final Integer recordingMonth;
    public final Integer recordingYear;
    public final Integer releaseDay;
    public final Integer releaseMonth;
    public final Integer releaseYear;
    public final CharSequence station;
    public final CharSequence subtitle;
    public final ImmutableList supportedCommands;
    public final CharSequence title;
    public final Integer totalDiscCount;
    public final Integer totalTrackCount;
    public final Integer trackNumber;
    public final Rating userRating;
    public final CharSequence writer;
    public final Integer year;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Builder {
        public CharSequence albumArtist;
        public CharSequence albumTitle;
        public CharSequence artist;
        public byte[] artworkData;
        public Integer artworkDataType;
        public Uri artworkUri;
        public BundleableByteArray bundleableArtworkData;
        public CharSequence compilation;
        public CharSequence composer;
        public CharSequence conductor;
        public CharSequence description;
        public Integer discNumber;
        public CharSequence displayTitle;
        public Long durationMs;
        public Bundle extras;
        public Integer folderType;
        public CharSequence genre;
        public Boolean isBrowsable;
        public Boolean isPlayable;
        public Integer mediaType;
        public Rating overallRating;
        public Integer recordingDay;
        public Integer recordingMonth;
        public Integer recordingYear;
        public Integer releaseDay;
        public Integer releaseMonth;
        public Integer releaseYear;
        public CharSequence station;
        public CharSequence subtitle;
        public ImmutableList supportedCommands;
        public CharSequence title;
        public Integer totalDiscCount;
        public Integer totalTrackCount;
        public Integer trackNumber;
        public Rating userRating;
        public CharSequence writer;

        public Builder() {
            ImmutableList.Itr itr = ImmutableList.EMPTY_ITR;
            this.supportedCommands = RegularImmutableList.EMPTY;
        }

        public final void maybeSetArtworkData(byte[] bArr, int i) {
            if (this.artworkData == null || i == 3 || !Objects.equals(this.artworkDataType, 3)) {
                this.artworkData = (byte[]) bArr.clone();
                this.bundleableArtworkData = null;
                this.artworkDataType = Integer.valueOf(i);
            }
        }

        public final void setArtworkData(byte[] bArr, Integer num) {
            this.artworkData = bArr == null ? null : (byte[]) bArr.clone();
            this.bundleableArtworkData = null;
            this.artworkDataType = num;
        }

        public final void setDurationMs(Long l) {
            UtilsKt.checkArgument(l == null || l.longValue() >= 0);
            this.durationMs = l;
        }
    }

    static {
        String str = Util.DEVICE_DEBUG_INFO;
        FIELD_TITLE = Integer.toString(0, 36);
        FIELD_ARTIST = Integer.toString(1, 36);
        FIELD_ALBUM_TITLE = Integer.toString(2, 36);
        FIELD_ALBUM_ARTIST = Integer.toString(3, 36);
        FIELD_DISPLAY_TITLE = Integer.toString(4, 36);
        FIELD_SUBTITLE = Integer.toString(5, 36);
        FIELD_DESCRIPTION = Integer.toString(6, 36);
        FIELD_USER_RATING = Integer.toString(8, 36);
        FIELD_OVERALL_RATING = Integer.toString(9, 36);
        FIELD_ARTWORK_DATA = Integer.toString(10, 36);
        FIELD_ARTWORK_URI = Integer.toString(11, 36);
        FIELD_TRACK_NUMBER = Integer.toString(12, 36);
        FIELD_TOTAL_TRACK_COUNT = Integer.toString(13, 36);
        FIELD_FOLDER_TYPE = Integer.toString(14, 36);
        FIELD_IS_PLAYABLE = Integer.toString(15, 36);
        FIELD_RECORDING_YEAR = Integer.toString(16, 36);
        FIELD_RECORDING_MONTH = Integer.toString(17, 36);
        FIELD_RECORDING_DAY = Integer.toString(18, 36);
        FIELD_RELEASE_YEAR = Integer.toString(19, 36);
        FIELD_RELEASE_MONTH = Integer.toString(20, 36);
        FIELD_RELEASE_DAY = Integer.toString(21, 36);
        FIELD_WRITER = Integer.toString(22, 36);
        FIELD_COMPOSER = Integer.toString(23, 36);
        FIELD_CONDUCTOR = Integer.toString(24, 36);
        FIELD_DISC_NUMBER = Integer.toString(25, 36);
        FIELD_TOTAL_DISC_COUNT = Integer.toString(26, 36);
        FIELD_GENRE = Integer.toString(27, 36);
        FIELD_COMPILATION = Integer.toString(28, 36);
        FIELD_ARTWORK_DATA_TYPE = Integer.toString(29, 36);
        FIELD_STATION = Integer.toString(30, 36);
        FIELD_MEDIA_TYPE = Integer.toString(31, 36);
        FIELD_IS_BROWSABLE = Integer.toString(32, 36);
        FIELD_DURATION_MS = Integer.toString(33, 36);
        FIELD_SUPPORTED_COMMANDS = Integer.toString(34, 36);
        FIELD_EXTRAS = Integer.toString(CIOKt.DEFAULT_HTTP_POOL_SIZE, 36);
    }

    public MediaMetadata(Builder builder) {
        Boolean boolValueOf = builder.isBrowsable;
        Integer numValueOf = builder.folderType;
        Integer numValueOf2 = builder.mediaType;
        int i = 1;
        int i2 = 0;
        int i3 = 0;
        if (boolValueOf != null) {
            if (!boolValueOf.booleanValue()) {
                numValueOf = -1;
            } else if (numValueOf == null || numValueOf.intValue() == -1) {
                if (numValueOf2 != null) {
                    switch (numValueOf2.intValue()) {
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                        case 11:
                        case DictionaryEntry.PRONUNCIATION /* 12 */:
                        case 13:
                        case 14:
                        case 15:
                        case 16:
                        case 17:
                        case 18:
                        case 19:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                            break;
                        case 20:
                        case 26:
                        case 27:
                        case 28:
                        case 29:
                        case 30:
                        default:
                            i = 0;
                            break;
                        case 21:
                            i = 2;
                            break;
                        case 22:
                            i = 3;
                            break;
                        case 23:
                            i = 4;
                            break;
                        case 24:
                            i = 5;
                            break;
                        case 25:
                            i = 6;
                            break;
                    }
                    i3 = i;
                }
                numValueOf = Integer.valueOf(i3);
            }
        } else if (numValueOf != null) {
            boolean z = numValueOf.intValue() != -1;
            boolValueOf = Boolean.valueOf(z);
            if (z && numValueOf2 == null) {
                switch (numValueOf.intValue()) {
                    case 1:
                        break;
                    case 2:
                        i2 = 21;
                        break;
                    case 3:
                        i2 = 22;
                        break;
                    case 4:
                        i2 = 23;
                        break;
                    case 5:
                        i2 = 24;
                        break;
                    case 6:
                        i2 = 25;
                        break;
                    default:
                        i2 = 20;
                        break;
                }
                numValueOf2 = Integer.valueOf(i2);
            }
        }
        this.title = builder.title;
        this.artist = builder.artist;
        this.albumTitle = builder.albumTitle;
        this.albumArtist = builder.albumArtist;
        this.displayTitle = builder.displayTitle;
        this.subtitle = builder.subtitle;
        this.description = builder.description;
        this.durationMs = builder.durationMs;
        this.userRating = builder.userRating;
        this.overallRating = builder.overallRating;
        this.artworkData = builder.artworkData;
        this.bundleableArtworkData = builder.bundleableArtworkData;
        this.artworkDataType = builder.artworkDataType;
        this.artworkUri = builder.artworkUri;
        this.trackNumber = builder.trackNumber;
        this.totalTrackCount = builder.totalTrackCount;
        this.folderType = numValueOf;
        this.isBrowsable = boolValueOf;
        this.isPlayable = builder.isPlayable;
        Integer num = builder.recordingYear;
        this.year = num;
        this.recordingYear = num;
        this.recordingMonth = builder.recordingMonth;
        this.recordingDay = builder.recordingDay;
        this.releaseYear = builder.releaseYear;
        this.releaseMonth = builder.releaseMonth;
        this.releaseDay = builder.releaseDay;
        this.writer = builder.writer;
        this.composer = builder.composer;
        this.conductor = builder.conductor;
        this.discNumber = builder.discNumber;
        this.totalDiscCount = builder.totalDiscCount;
        this.genre = builder.genre;
        this.compilation = builder.compilation;
        this.station = builder.station;
        this.mediaType = numValueOf2;
        this.supportedCommands = builder.supportedCommands;
        this.extras = builder.extras;
    }

    public static MediaMetadata fromBundle(int i, Bundle bundle) {
        Bundle bundle2;
        Bundle bundle3;
        Builder builder = new Builder();
        builder.title = bundle.getCharSequence(FIELD_TITLE);
        builder.artist = bundle.getCharSequence(FIELD_ARTIST);
        builder.albumTitle = bundle.getCharSequence(FIELD_ALBUM_TITLE);
        builder.albumArtist = bundle.getCharSequence(FIELD_ALBUM_ARTIST);
        builder.displayTitle = bundle.getCharSequence(FIELD_DISPLAY_TITLE);
        builder.subtitle = bundle.getCharSequence(FIELD_SUBTITLE);
        builder.description = bundle.getCharSequence(FIELD_DESCRIPTION);
        builder.artworkUri = (Uri) bundle.getParcelable(FIELD_ARTWORK_URI);
        builder.writer = bundle.getCharSequence(FIELD_WRITER);
        builder.composer = bundle.getCharSequence(FIELD_COMPOSER);
        builder.conductor = bundle.getCharSequence(FIELD_CONDUCTOR);
        builder.genre = bundle.getCharSequence(FIELD_GENRE);
        builder.compilation = bundle.getCharSequence(FIELD_COMPILATION);
        builder.station = bundle.getCharSequence(FIELD_STATION);
        builder.extras = Util.convertToNullIfInvalid(bundle.getBundle(FIELD_EXTRAS));
        String str = FIELD_ARTWORK_DATA;
        if (bundle.containsKey(str)) {
            String str2 = FIELD_ARTWORK_DATA_TYPE;
            byte[] fromBundle = null;
            Integer numValueOf = bundle.containsKey(str2) ? Integer.valueOf(bundle.getInt(str2)) : null;
            if (i >= 9) {
                Bundle bundle4 = bundle.getBundle(str);
                if (bundle4 != null) {
                    IBinder binder = bundle4.getBinder(BundleableByteArray.FIELD_IN_PROCESS_BINDER);
                    if (binder != null) {
                        if (binder instanceof BundleableByteArray.InProcessBinder) {
                            int i2 = BundleableByteArray.InProcessBinder.$r8$clinit;
                            fromBundle = BundleableByteArray.this.byteArray;
                        } else if (Build.VERSION.SDK_INT < 27 || (fromBundle = BundleableByteArray.SharedMemoryApi27.readFromBundle(bundle4)) == null) {
                            fromBundle = BundleableByteArray.SplitArrayRetriever.readFromBundle(bundle4);
                        }
                    }
                    builder.setArtworkData(fromBundle, numValueOf);
                }
            } else {
                builder.setArtworkData(bundle.getByteArray(str), numValueOf);
            }
        }
        String str3 = FIELD_USER_RATING;
        if (bundle.containsKey(str3) && (bundle3 = bundle.getBundle(str3)) != null) {
            builder.userRating = Rating.fromBundle(bundle3);
        }
        String str4 = FIELD_OVERALL_RATING;
        if (bundle.containsKey(str4) && (bundle2 = bundle.getBundle(str4)) != null) {
            builder.overallRating = Rating.fromBundle(bundle2);
        }
        String str5 = FIELD_DURATION_MS;
        if (bundle.containsKey(str5)) {
            builder.setDurationMs(Long.valueOf(bundle.getLong(str5)));
        }
        String str6 = FIELD_TRACK_NUMBER;
        if (bundle.containsKey(str6)) {
            builder.trackNumber = Integer.valueOf(bundle.getInt(str6));
        }
        String str7 = FIELD_TOTAL_TRACK_COUNT;
        if (bundle.containsKey(str7)) {
            builder.totalTrackCount = Integer.valueOf(bundle.getInt(str7));
        }
        String str8 = FIELD_FOLDER_TYPE;
        if (bundle.containsKey(str8)) {
            builder.folderType = Integer.valueOf(bundle.getInt(str8));
        }
        String str9 = FIELD_IS_BROWSABLE;
        if (bundle.containsKey(str9)) {
            builder.isBrowsable = Boolean.valueOf(bundle.getBoolean(str9));
        }
        String str10 = FIELD_IS_PLAYABLE;
        if (bundle.containsKey(str10)) {
            builder.isPlayable = Boolean.valueOf(bundle.getBoolean(str10));
        }
        String str11 = FIELD_RECORDING_YEAR;
        if (bundle.containsKey(str11)) {
            builder.recordingYear = Integer.valueOf(bundle.getInt(str11));
        }
        String str12 = FIELD_RECORDING_MONTH;
        if (bundle.containsKey(str12)) {
            builder.recordingMonth = Integer.valueOf(bundle.getInt(str12));
        }
        String str13 = FIELD_RECORDING_DAY;
        if (bundle.containsKey(str13)) {
            builder.recordingDay = Integer.valueOf(bundle.getInt(str13));
        }
        String str14 = FIELD_RELEASE_YEAR;
        if (bundle.containsKey(str14)) {
            builder.releaseYear = Integer.valueOf(bundle.getInt(str14));
        }
        String str15 = FIELD_RELEASE_MONTH;
        if (bundle.containsKey(str15)) {
            builder.releaseMonth = Integer.valueOf(bundle.getInt(str15));
        }
        String str16 = FIELD_RELEASE_DAY;
        if (bundle.containsKey(str16)) {
            builder.releaseDay = Integer.valueOf(bundle.getInt(str16));
        }
        String str17 = FIELD_DISC_NUMBER;
        if (bundle.containsKey(str17)) {
            builder.discNumber = Integer.valueOf(bundle.getInt(str17));
        }
        String str18 = FIELD_TOTAL_DISC_COUNT;
        if (bundle.containsKey(str18)) {
            builder.totalDiscCount = Integer.valueOf(bundle.getInt(str18));
        }
        String str19 = FIELD_MEDIA_TYPE;
        if (bundle.containsKey(str19)) {
            builder.mediaType = Integer.valueOf(bundle.getInt(str19));
        }
        ArrayList<String> stringArrayList = bundle.getStringArrayList(FIELD_SUPPORTED_COMMANDS);
        if (stringArrayList != null) {
            builder.supportedCommands = ImmutableList.copyOf((Collection) stringArrayList);
        }
        return new MediaMetadata(builder);
    }

    public final Builder buildUpon() {
        Builder builder = new Builder();
        builder.title = this.title;
        builder.artist = this.artist;
        builder.albumTitle = this.albumTitle;
        builder.albumArtist = this.albumArtist;
        builder.displayTitle = this.displayTitle;
        builder.subtitle = this.subtitle;
        builder.description = this.description;
        builder.durationMs = this.durationMs;
        builder.userRating = this.userRating;
        builder.overallRating = this.overallRating;
        builder.artworkData = this.artworkData;
        builder.bundleableArtworkData = this.bundleableArtworkData;
        builder.artworkDataType = this.artworkDataType;
        builder.artworkUri = this.artworkUri;
        builder.trackNumber = this.trackNumber;
        builder.totalTrackCount = this.totalTrackCount;
        builder.folderType = this.folderType;
        builder.isBrowsable = this.isBrowsable;
        builder.isPlayable = this.isPlayable;
        builder.recordingYear = this.recordingYear;
        builder.recordingMonth = this.recordingMonth;
        builder.recordingDay = this.recordingDay;
        builder.releaseYear = this.releaseYear;
        builder.releaseMonth = this.releaseMonth;
        builder.releaseDay = this.releaseDay;
        builder.writer = this.writer;
        builder.composer = this.composer;
        builder.conductor = this.conductor;
        builder.discNumber = this.discNumber;
        builder.totalDiscCount = this.totalDiscCount;
        builder.genre = this.genre;
        builder.compilation = this.compilation;
        builder.station = this.station;
        builder.mediaType = this.mediaType;
        builder.supportedCommands = this.supportedCommands;
        builder.extras = this.extras;
        return builder;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && MediaMetadata.class == obj.getClass()) {
            MediaMetadata mediaMetadata = (MediaMetadata) obj;
            if (TextUtils.equals(this.title, mediaMetadata.title) && TextUtils.equals(this.artist, mediaMetadata.artist) && TextUtils.equals(this.albumTitle, mediaMetadata.albumTitle) && TextUtils.equals(this.albumArtist, mediaMetadata.albumArtist) && TextUtils.equals(this.displayTitle, mediaMetadata.displayTitle) && TextUtils.equals(this.subtitle, mediaMetadata.subtitle) && TextUtils.equals(this.description, mediaMetadata.description) && Objects.equals(this.durationMs, mediaMetadata.durationMs) && Objects.equals(this.userRating, mediaMetadata.userRating) && Objects.equals(this.overallRating, mediaMetadata.overallRating) && Arrays.equals(this.artworkData, mediaMetadata.artworkData) && Objects.equals(this.artworkDataType, mediaMetadata.artworkDataType) && Objects.equals(this.artworkUri, mediaMetadata.artworkUri) && Objects.equals(this.trackNumber, mediaMetadata.trackNumber) && Objects.equals(this.totalTrackCount, mediaMetadata.totalTrackCount) && Objects.equals(this.folderType, mediaMetadata.folderType) && Objects.equals(this.isBrowsable, mediaMetadata.isBrowsable) && Objects.equals(this.isPlayable, mediaMetadata.isPlayable) && Objects.equals(this.recordingYear, mediaMetadata.recordingYear) && Objects.equals(this.recordingMonth, mediaMetadata.recordingMonth) && Objects.equals(this.recordingDay, mediaMetadata.recordingDay) && Objects.equals(this.releaseYear, mediaMetadata.releaseYear) && Objects.equals(this.releaseMonth, mediaMetadata.releaseMonth) && Objects.equals(this.releaseDay, mediaMetadata.releaseDay) && TextUtils.equals(this.writer, mediaMetadata.writer) && TextUtils.equals(this.composer, mediaMetadata.composer) && TextUtils.equals(this.conductor, mediaMetadata.conductor) && Objects.equals(this.discNumber, mediaMetadata.discNumber) && Objects.equals(this.totalDiscCount, mediaMetadata.totalDiscCount) && TextUtils.equals(this.genre, mediaMetadata.genre) && TextUtils.equals(this.compilation, mediaMetadata.compilation) && TextUtils.equals(this.station, mediaMetadata.station) && Objects.equals(this.mediaType, mediaMetadata.mediaType) && Objects.equals(this.supportedCommands, mediaMetadata.supportedCommands)) {
                if ((this.extras == null) == (mediaMetadata.extras == null)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.title, this.artist, this.albumTitle, this.albumArtist, this.displayTitle, this.subtitle, this.description, this.durationMs, this.userRating, this.overallRating, Integer.valueOf(Arrays.hashCode(this.artworkData)), this.artworkDataType, this.artworkUri, this.trackNumber, this.totalTrackCount, this.folderType, this.isBrowsable, this.isPlayable, this.recordingYear, this.recordingMonth, this.recordingDay, this.releaseYear, this.releaseMonth, this.releaseDay, this.writer, this.composer, this.conductor, this.discNumber, this.totalDiscCount, this.genre, this.compilation, this.station, this.mediaType, Boolean.valueOf(this.extras == null), this.supportedCommands);
    }

    /* JADX WARN: Code duplicated, block: B:42:0x0091  */
    /* JADX WARN: Code duplicated, block: B:44:0x0095  */
    public final Bundle toBundle(int i) {
        BundleableByteArray.SplitArrayRetriever splitArrayRetriever;
        Bundle bundle = new Bundle();
        CharSequence charSequence = this.title;
        if (charSequence != null) {
            bundle.putCharSequence(FIELD_TITLE, charSequence);
        }
        CharSequence charSequence2 = this.artist;
        if (charSequence2 != null) {
            bundle.putCharSequence(FIELD_ARTIST, charSequence2);
        }
        CharSequence charSequence3 = this.albumTitle;
        if (charSequence3 != null) {
            bundle.putCharSequence(FIELD_ALBUM_TITLE, charSequence3);
        }
        CharSequence charSequence4 = this.albumArtist;
        if (charSequence4 != null) {
            bundle.putCharSequence(FIELD_ALBUM_ARTIST, charSequence4);
        }
        CharSequence charSequence5 = this.displayTitle;
        if (charSequence5 != null) {
            bundle.putCharSequence(FIELD_DISPLAY_TITLE, charSequence5);
        }
        CharSequence charSequence6 = this.subtitle;
        if (charSequence6 != null) {
            bundle.putCharSequence(FIELD_SUBTITLE, charSequence6);
        }
        CharSequence charSequence7 = this.description;
        if (charSequence7 != null) {
            bundle.putCharSequence(FIELD_DESCRIPTION, charSequence7);
        }
        Long l = this.durationMs;
        if (l != null) {
            bundle.putLong(FIELD_DURATION_MS, l.longValue());
        }
        byte[] bArr = this.artworkData;
        if (bArr != null) {
            String str = FIELD_ARTWORK_DATA;
            if (i >= 9) {
                BundleableByteArray bundleableByteArray = this.bundleableArtworkData;
                if (bundleableByteArray == null) {
                    bundleableByteArray = new BundleableByteArray(bArr);
                    this.bundleableArtworkData = bundleableByteArray;
                }
                byte[] bArr2 = bundleableByteArray.byteArray;
                Bundle bundle2 = new Bundle();
                bundle2.putBinder(BundleableByteArray.FIELD_IN_PROCESS_BINDER, bundleableByteArray.inProcessBinder);
                if (Build.VERSION.SDK_INT < 27 || bArr2.length <= 0) {
                    splitArrayRetriever = bundleableByteArray.splitArrayRetriever;
                    if (splitArrayRetriever == null) {
                        splitArrayRetriever = new BundleableByteArray.SplitArrayRetriever(bArr2);
                        bundleableByteArray.splitArrayRetriever = splitArrayRetriever;
                    }
                    int i2 = BundleableByteArray.SplitArrayRetriever.CHUNK_SIZE;
                    bundle2.putBinder(BundleableByteArray.FIELD_SPLIT_ARRAY_RETRIEVER, splitArrayRetriever.bundleListRetriever);
                } else {
                    BundleableByteArray.SharedMemoryApi27 sharedMemoryApi27Create = bundleableByteArray.sharedMemoryApi27;
                    if (sharedMemoryApi27Create == null) {
                        sharedMemoryApi27Create = BundleableByteArray.SharedMemoryApi27.create(bArr2);
                        bundleableByteArray.sharedMemoryApi27 = sharedMemoryApi27Create;
                    }
                    if (sharedMemoryApi27Create != null) {
                        bundle2.putParcelable(BundleableByteArray.FIELD_SHARED_MEMORY, sharedMemoryApi27Create.sharedMemory);
                    } else {
                        splitArrayRetriever = bundleableByteArray.splitArrayRetriever;
                        if (splitArrayRetriever == null) {
                            splitArrayRetriever = new BundleableByteArray.SplitArrayRetriever(bArr2);
                            bundleableByteArray.splitArrayRetriever = splitArrayRetriever;
                        }
                        int i3 = BundleableByteArray.SplitArrayRetriever.CHUNK_SIZE;
                        bundle2.putBinder(BundleableByteArray.FIELD_SPLIT_ARRAY_RETRIEVER, splitArrayRetriever.bundleListRetriever);
                    }
                }
                bundle.putBundle(str, bundle2);
            } else if (bArr.length <= 500000) {
                bundle.putByteArray(str, bArr);
            }
        }
        Uri uri = this.artworkUri;
        if (uri != null) {
            bundle.putParcelable(FIELD_ARTWORK_URI, uri);
        }
        CharSequence charSequence8 = this.writer;
        if (charSequence8 != null) {
            bundle.putCharSequence(FIELD_WRITER, charSequence8);
        }
        CharSequence charSequence9 = this.composer;
        if (charSequence9 != null) {
            bundle.putCharSequence(FIELD_COMPOSER, charSequence9);
        }
        CharSequence charSequence10 = this.conductor;
        if (charSequence10 != null) {
            bundle.putCharSequence(FIELD_CONDUCTOR, charSequence10);
        }
        CharSequence charSequence11 = this.genre;
        if (charSequence11 != null) {
            bundle.putCharSequence(FIELD_GENRE, charSequence11);
        }
        CharSequence charSequence12 = this.compilation;
        if (charSequence12 != null) {
            bundle.putCharSequence(FIELD_COMPILATION, charSequence12);
        }
        CharSequence charSequence13 = this.station;
        if (charSequence13 != null) {
            bundle.putCharSequence(FIELD_STATION, charSequence13);
        }
        Rating rating = this.userRating;
        if (rating != null) {
            bundle.putBundle(FIELD_USER_RATING, rating.toBundle());
        }
        Rating rating2 = this.overallRating;
        if (rating2 != null) {
            bundle.putBundle(FIELD_OVERALL_RATING, rating2.toBundle());
        }
        Integer num = this.trackNumber;
        if (num != null) {
            bundle.putInt(FIELD_TRACK_NUMBER, num.intValue());
        }
        Integer num2 = this.totalTrackCount;
        if (num2 != null) {
            bundle.putInt(FIELD_TOTAL_TRACK_COUNT, num2.intValue());
        }
        Integer num3 = this.folderType;
        if (num3 != null) {
            bundle.putInt(FIELD_FOLDER_TYPE, num3.intValue());
        }
        Boolean bool = this.isBrowsable;
        if (bool != null) {
            bundle.putBoolean(FIELD_IS_BROWSABLE, bool.booleanValue());
        }
        Boolean bool2 = this.isPlayable;
        if (bool2 != null) {
            bundle.putBoolean(FIELD_IS_PLAYABLE, bool2.booleanValue());
        }
        Integer num4 = this.recordingYear;
        if (num4 != null) {
            bundle.putInt(FIELD_RECORDING_YEAR, num4.intValue());
        }
        Integer num5 = this.recordingMonth;
        if (num5 != null) {
            bundle.putInt(FIELD_RECORDING_MONTH, num5.intValue());
        }
        Integer num6 = this.recordingDay;
        if (num6 != null) {
            bundle.putInt(FIELD_RECORDING_DAY, num6.intValue());
        }
        Integer num7 = this.releaseYear;
        if (num7 != null) {
            bundle.putInt(FIELD_RELEASE_YEAR, num7.intValue());
        }
        Integer num8 = this.releaseMonth;
        if (num8 != null) {
            bundle.putInt(FIELD_RELEASE_MONTH, num8.intValue());
        }
        Integer num9 = this.releaseDay;
        if (num9 != null) {
            bundle.putInt(FIELD_RELEASE_DAY, num9.intValue());
        }
        Integer num10 = this.discNumber;
        if (num10 != null) {
            bundle.putInt(FIELD_DISC_NUMBER, num10.intValue());
        }
        Integer num11 = this.totalDiscCount;
        if (num11 != null) {
            bundle.putInt(FIELD_TOTAL_DISC_COUNT, num11.intValue());
        }
        Integer num12 = this.artworkDataType;
        if (num12 != null) {
            bundle.putInt(FIELD_ARTWORK_DATA_TYPE, num12.intValue());
        }
        Integer num13 = this.mediaType;
        if (num13 != null) {
            bundle.putInt(FIELD_MEDIA_TYPE, num13.intValue());
        }
        ImmutableList immutableList = this.supportedCommands;
        if (!immutableList.isEmpty()) {
            bundle.putStringArrayList(FIELD_SUPPORTED_COMMANDS, new ArrayList<>(immutableList));
        }
        Bundle bundle3 = this.extras;
        if (bundle3 != null) {
            bundle.putBundle(FIELD_EXTRAS, bundle3);
        }
        return bundle;
    }
}
