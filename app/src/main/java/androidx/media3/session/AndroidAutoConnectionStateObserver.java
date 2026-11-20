package androidx.media3.session;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.NetworkTypeObserver;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidAutoConnectionStateObserver {
    public static final Uri QUERY_URI = Uri.parse("content://androidx.car.app.connection");
    public final Executor backgroundExecutor;
    public final NetworkTypeObserver.Receiver changeReceiver;
    public final Context context;
    public final AtomicBoolean isConnected;
    public final AtomicBoolean isReleased;
    public final MediaSessionLegacyStub$$ExternalSyntheticLambda0 listener;

    public AndroidAutoConnectionStateObserver(Context context, MediaSessionLegacyStub$$ExternalSyntheticLambda0 mediaSessionLegacyStub$$ExternalSyntheticLambda0) {
        this.context = context.getApplicationContext();
        this.listener = mediaSessionLegacyStub$$ExternalSyntheticLambda0;
        Executor executor = Log.get();
        this.backgroundExecutor = executor;
        this.changeReceiver = new NetworkTypeObserver.Receiver((byte) 5, this);
        this.isConnected = new AtomicBoolean();
        this.isReleased = new AtomicBoolean();
        executor.execute(new AndroidAutoConnectionStateObserver$$ExternalSyntheticLambda0(this, (byte) 1));
    }

    public final void updateConnectionState() {
        AtomicBoolean atomicBoolean = this.isConnected;
        boolean z = atomicBoolean.get();
        boolean z2 = false;
        try {
            Cursor cursorQuery = this.context.getContentResolver().query(QUERY_URI, new String[]{"CarConnectionState"}, null, null, null);
            if (cursorQuery != null) {
                try {
                    int columnIndex = cursorQuery.getColumnIndex("CarConnectionState");
                    if (columnIndex != -1 && cursorQuery.moveToNext()) {
                        boolean z3 = cursorQuery.getInt(columnIndex) != 0;
                        cursorQuery.close();
                        z2 = z3;
                    } else {
                        cursorQuery.close();
                    }
                } catch (Throwable th) {
                    try {
                        cursorQuery.close();
                        throw th;
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                        throw th;
                    }
                }
            } else if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Exception unused) {
        }
        atomicBoolean.set(z2);
        if (z == z2 || this.isReleased.get()) {
            return;
        }
        this.listener.run();
    }
}
