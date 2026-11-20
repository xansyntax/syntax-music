package androidx.media3.session;

import android.os.Bundle;
import android.os.IBinder;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.media3.common.BundleListRetriever;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.util.Util;
import coil3.util.UtilsKt;
import com.google.common.collect.ImmutableList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LibraryResult {
    public static final String FIELD_COMPLETION_TIME_MS;
    public static final String FIELD_PARAMS;
    public static final String FIELD_RESULT_CODE;
    public static final String FIELD_SESSION_ERROR;
    public static final String FIELD_VALUE;
    public static final String FIELD_VALUE_TYPE;
    public final long completionTimeMs;
    public final MediaLibraryService.LibraryParams params;
    public final int resultCode;
    public final SessionError sessionError;
    public final Object value;
    public final int valueType;

    static {
        String str = Util.DEVICE_DEBUG_INFO;
        FIELD_RESULT_CODE = Integer.toString(0, 36);
        FIELD_COMPLETION_TIME_MS = Integer.toString(1, 36);
        FIELD_PARAMS = Integer.toString(2, 36);
        FIELD_VALUE = Integer.toString(3, 36);
        FIELD_VALUE_TYPE = Integer.toString(4, 36);
        FIELD_SESSION_ERROR = Integer.toString(5, 36);
    }

    public LibraryResult(int i, long j, MediaLibraryService.LibraryParams libraryParams, SessionError sessionError, Object obj, int i2) {
        this.resultCode = i;
        this.completionTimeMs = j;
        this.params = libraryParams;
        this.sessionError = sessionError;
        this.value = obj;
        this.valueType = i2;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0041  */
    /* JADX WARN: Code duplicated, block: B:17:0x0046  */
    /* JADX WARN: Code duplicated, block: B:19:0x0049  */
    /* JADX WARN: Code duplicated, block: B:22:0x004d  */
    /* JADX WARN: Code duplicated, block: B:24:0x0051  */
    /* JADX WARN: Code duplicated, block: B:27:0x0058  */
    /* JADX WARN: Code duplicated, block: B:30:0x0066 A[LOOP:0: B:28:0x0060->B:30:0x0066, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:33:0x007f  */
    /* JADX WARN: Code duplicated, block: B:36:0x0086  */
    public static LibraryResult fromUnknownBundle(int i, Bundle bundle) {
        SessionError sessionError;
        SessionError sessionError2;
        int i2;
        String str;
        Bundle bundle2;
        IBinder binder;
        ImmutableList list;
        ImmutableList.Builder builder;
        int i3 = bundle.getInt(FIELD_RESULT_CODE, 0);
        long j = bundle.getLong(FIELD_COMPLETION_TIME_MS, SystemClock.elapsedRealtime());
        Bundle bundle3 = bundle.getBundle(FIELD_PARAMS);
        Object objFromBundle = null;
        MediaLibraryService.LibraryParams libraryParamsFromBundle = bundle3 == null ? null : MediaLibraryService.LibraryParams.fromBundle(bundle3);
        Bundle bundle4 = bundle.getBundle(FIELD_SESSION_ERROR);
        if (bundle4 == null) {
            if (i3 != 0) {
                sessionError2 = new SessionError(i3);
            } else {
                sessionError = null;
            }
            i2 = bundle.getInt(FIELD_VALUE_TYPE);
            if (i2 != 1) {
                str = FIELD_VALUE;
                if (i2 != 2) {
                    bundle2 = bundle.getBundle(str);
                    if (bundle2 != null) {
                        objFromBundle = MediaItem.fromBundle(i, bundle2);
                    }
                } else if (i2 != 3) {
                    binder = bundle.getBinder(str);
                    if (binder != null) {
                        list = BundleListRetriever.getList(binder);
                        builder = ImmutableList.builder();
                        for (int i4 = 0; i4 < list.size(); i4++) {
                            Bundle bundle5 = (Bundle) list.get(i4);
                            bundle5.getClass();
                            builder.add((Object) MediaItem.fromBundle(i, bundle5));
                        }
                        objFromBundle = builder.build();
                    }
                } else if (i2 != 4) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m();
                    return null;
                }
            }
            return new LibraryResult(i3, j, libraryParamsFromBundle, sessionError, objFromBundle, i2);
        }
        sessionError2 = SessionError.fromBundle(bundle4);
        sessionError = sessionError2;
        i2 = bundle.getInt(FIELD_VALUE_TYPE);
        if (i2 != 1) {
            str = FIELD_VALUE;
            if (i2 != 2) {
                bundle2 = bundle.getBundle(str);
                if (bundle2 != null) {
                    objFromBundle = MediaItem.fromBundle(i, bundle2);
                }
            } else if (i2 != 3) {
                binder = bundle.getBinder(str);
                if (binder != null) {
                    list = BundleListRetriever.getList(binder);
                    builder = ImmutableList.builder();
                    while (i4 < list.size()) {
                        Bundle bundle6 = (Bundle) list.get(i4);
                        bundle6.getClass();
                        builder.add((Object) MediaItem.fromBundle(i, bundle6));
                    }
                    objFromBundle = builder.build();
                }
            } else if (i2 != 4) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m();
                return null;
            }
        }
        return new LibraryResult(i3, j, libraryParamsFromBundle, sessionError, objFromBundle, i2);
    }

    public static LibraryResult ofError(int i) {
        SessionError sessionError = new SessionError("no error message provided", i, Bundle.EMPTY);
        return new LibraryResult(sessionError.code, SystemClock.elapsedRealtime(), null, sessionError, null, 4);
    }

    public static LibraryResult ofItemList(List list, MediaLibraryService.LibraryParams libraryParams) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            verifyMediaItem((MediaItem) it.next());
        }
        return new LibraryResult(0, SystemClock.elapsedRealtime(), libraryParams, null, ImmutableList.copyOf((Collection) list), 3);
    }

    public static void verifyMediaItem(MediaItem mediaItem) {
        UtilsKt.checkArgument("mediaId must not be empty", !TextUtils.isEmpty(mediaItem.mediaId));
        MediaMetadata mediaMetadata = mediaItem.mediaMetadata;
        UtilsKt.checkArgument("mediaMetadata must specify isBrowsable", mediaMetadata.isBrowsable != null);
        UtilsKt.checkArgument("mediaMetadata must specify isPlayable", mediaMetadata.isPlayable != null);
    }

    public static LibraryResult ofError(int i, MediaLibraryService.LibraryParams libraryParams) {
        return new LibraryResult(i, SystemClock.elapsedRealtime(), libraryParams, new SessionError("no error message provided", i, Bundle.EMPTY), null, 4);
    }
}
