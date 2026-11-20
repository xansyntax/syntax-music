package androidx.media3.session;

import android.os.Bundle;
import androidx.media3.common.util.Util;
import coil3.util.UtilsKt;
import io.ktor.client.utils.CIOKt;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SessionError {
    public static final String FIELD_CODE;
    public static final String FIELD_EXTRAS;
    public static final String FIELD_MESSAGE;
    public final int code;
    public final Bundle extras;
    public final String message;

    static {
        String str = Util.DEVICE_DEBUG_INFO;
        FIELD_CODE = Integer.toString(0, 36);
        FIELD_MESSAGE = Integer.toString(1, 36);
        FIELD_EXTRAS = Integer.toString(2, 36);
    }

    public SessionError(String str, int i, Bundle bundle) {
        boolean z = true;
        if (i >= 0 && i != 1) {
            z = false;
        }
        UtilsKt.checkArgument(z);
        this.code = i;
        this.message = str;
        this.extras = bundle;
    }

    public static SessionError fromBundle(Bundle bundle) {
        int i = bundle.getInt(FIELD_CODE, CIOKt.DEFAULT_HTTP_POOL_SIZE);
        String string = bundle.getString(FIELD_MESSAGE, "");
        Bundle bundleConvertToNullIfInvalid = Util.convertToNullIfInvalid(bundle.getBundle(FIELD_EXTRAS));
        if (bundleConvertToNullIfInvalid == null) {
            bundleConvertToNullIfInvalid = Bundle.EMPTY;
        }
        return new SessionError(string, i, bundleConvertToNullIfInvalid);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SessionError)) {
            return false;
        }
        SessionError sessionError = (SessionError) obj;
        return this.code == sessionError.code && Objects.equals(this.message, sessionError.message);
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.code), this.message);
    }

    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(FIELD_CODE, this.code);
        bundle.putString(FIELD_MESSAGE, this.message);
        Bundle bundle2 = this.extras;
        if (!bundle2.isEmpty()) {
            bundle.putBundle(FIELD_EXTRAS, bundle2);
        }
        return bundle;
    }

    public SessionError(int i) {
        this("no error message provided", i, Bundle.EMPTY);
    }
}
