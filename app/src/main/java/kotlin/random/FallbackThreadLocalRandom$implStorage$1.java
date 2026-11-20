package kotlin.random;

import android.os.Looper;
import android.view.Choreographer;
import androidx.compose.ui.platform.AndroidUiDispatcher;
import androidx.sqlite.SQLite;
import java.text.SimpleDateFormat;
import java.util.Locale;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FallbackThreadLocalRandom$implStorage$1 extends ThreadLocal {
    public final /* synthetic */ byte $r8$classId;

    @Override // java.lang.ThreadLocal
    public final Object initialValue() {
        switch (this.$r8$classId) {
            case 0:
                return new java.util.Random();
            case 1:
                Choreographer choreographer = Choreographer.getInstance();
                Looper looperMyLooper = Looper.myLooper();
                if (looperMyLooper != null) {
                    AndroidUiDispatcher androidUiDispatcher = new AndroidUiDispatcher(choreographer, SQLite.createAsync(looperMyLooper));
                    return androidUiDispatcher.plus(androidUiDispatcher.frameClock);
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("no Looper on this thread");
                return null;
            default:
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
                simpleDateFormat.setLenient(false);
                simpleDateFormat.setTimeZone(_UtilJvmKt.UTC);
                return simpleDateFormat;
        }
    }
}
