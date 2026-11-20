package androidx.media3.session;

import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import androidx.media3.common.util.NetworkTypeObserver;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AndroidAutoConnectionStateObserver$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ AndroidAutoConnectionStateObserver f$0;

    public /* synthetic */ AndroidAutoConnectionStateObserver$$ExternalSyntheticLambda0(AndroidAutoConnectionStateObserver androidAutoConnectionStateObserver, byte b) {
        this.$r8$classId = b;
        this.f$0 = androidAutoConnectionStateObserver;
    }

    @Override // java.lang.Runnable
    public final void run() {
        byte b = this.$r8$classId;
        AndroidAutoConnectionStateObserver androidAutoConnectionStateObserver = this.f$0;
        switch (b) {
            case 0:
                androidAutoConnectionStateObserver.context.unregisterReceiver(androidAutoConnectionStateObserver.changeReceiver);
                break;
            case 1:
                NetworkTypeObserver.Receiver receiver = androidAutoConnectionStateObserver.changeReceiver;
                IntentFilter intentFilter = new IntentFilter("androidx.car.app.connection.action.CAR_CONNECTION_UPDATED");
                int i = Build.VERSION.SDK_INT;
                Context context = androidAutoConnectionStateObserver.context;
                if (i >= 33) {
                    context.registerReceiver(receiver, intentFilter, 2);
                } else {
                    context.registerReceiver(receiver, intentFilter);
                }
                androidAutoConnectionStateObserver.updateConnectionState();
                break;
            default:
                Uri uri = AndroidAutoConnectionStateObserver.QUERY_URI;
                androidAutoConnectionStateObserver.updateConnectionState();
                break;
        }
    }
}
