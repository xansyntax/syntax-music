package androidx.media3.session;

import android.os.Bundle;
import android.os.SystemClock;
import androidx.media3.common.util.Util;
import coil3.util.UtilsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SessionResult {
    public static final String FIELD_COMPLETION_TIME_MS;
    public static final String FIELD_EXTRAS;
    public static final String FIELD_RESULT_CODE;
    public static final String FIELD_SESSION_ERROR;
    public final long completionTimeMs;
    public final Bundle extras;
    public final int resultCode;
    public final SessionError sessionError;

    static {
        String str = Util.DEVICE_DEBUG_INFO;
        FIELD_RESULT_CODE = Integer.toString(0, 36);
        FIELD_EXTRAS = Integer.toString(1, 36);
        FIELD_COMPLETION_TIME_MS = Integer.toString(2, 36);
        FIELD_SESSION_ERROR = Integer.toString(3, 36);
    }

    public SessionResult(int i, Bundle bundle, long j, SessionError sessionError) {
        UtilsKt.checkArgument(sessionError == null || i < 0);
        this.resultCode = i;
        this.extras = new Bundle(bundle);
        this.completionTimeMs = j;
        if (sessionError == null && i < 0) {
            sessionError = new SessionError(i);
        }
        this.sessionError = sessionError;
    }

    public static SessionResult fromBundle(Bundle bundle) {
        SessionError sessionError;
        int i = bundle.getInt(FIELD_RESULT_CODE, -1);
        Bundle bundleConvertToNullIfInvalid = Util.convertToNullIfInvalid(bundle.getBundle(FIELD_EXTRAS));
        long j = bundle.getLong(FIELD_COMPLETION_TIME_MS, SystemClock.elapsedRealtime());
        Bundle bundle2 = bundle.getBundle(FIELD_SESSION_ERROR);
        if (bundle2 != null) {
            sessionError = SessionError.fromBundle(bundle2);
        } else {
            sessionError = i != 0 ? new SessionError(i) : null;
        }
        SessionError sessionError2 = sessionError;
        if (bundleConvertToNullIfInvalid == null) {
            bundleConvertToNullIfInvalid = Bundle.EMPTY;
        }
        return new SessionResult(i, bundleConvertToNullIfInvalid, j, sessionError2);
    }

    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(FIELD_RESULT_CODE, this.resultCode);
        bundle.putBundle(FIELD_EXTRAS, this.extras);
        bundle.putLong(FIELD_COMPLETION_TIME_MS, this.completionTimeMs);
        SessionError sessionError = this.sessionError;
        if (sessionError != null) {
            bundle.putBundle(FIELD_SESSION_ERROR, sessionError.toBundle());
        }
        return bundle;
    }

    public SessionResult(int i) {
        this(i, Bundle.EMPTY, SystemClock.elapsedRealtime(), null);
    }
}
