package androidx.media3.common.util;

import android.content.Intent;
import android.content.IntentSender;
import android.os.RemoteException;
import androidx.activity.ComponentActivity$activityResultRegistry$1;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultRegistry;
import androidx.media3.session.IMediaSession;
import androidx.media3.session.MediaControllerImplBase;
import androidx.media3.session.SessionResult;
import coil3.Extras;
import coil3.util.UtilsKt;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ListenerSet$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ Object f$2;

    public /* synthetic */ ListenerSet$$ExternalSyntheticLambda1(MediaControllerImplBase mediaControllerImplBase, ListenableFuture listenableFuture, int i) {
        this.$r8$classId = (byte) 3;
        this.f$0 = mediaControllerImplBase;
        this.f$2 = listenableFuture;
        this.f$1 = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SessionResult sessionResult;
        byte b = this.$r8$classId;
        int i = this.f$1;
        Object obj = this.f$2;
        Object obj2 = this.f$0;
        switch (b) {
            case 0:
                ListenerSet.Event event = (ListenerSet.Event) obj;
                for (ListenerSet.ListenerHolder listenerHolder : (CopyOnWriteArraySet) obj2) {
                    if (!listenerHolder.released) {
                        if (i != -1) {
                            listenerHolder.flagsBuilder.add(i);
                        }
                        listenerHolder.needsIterationFinishedEvent = true;
                        event.invoke(listenerHolder.listener);
                    }
                }
                break;
            case 1:
                ComponentActivity$activityResultRegistry$1 componentActivity$activityResultRegistry$1 = (ComponentActivity$activityResultRegistry$1) obj2;
                Object obj3 = ((Extras.Key) obj).f9default;
                String str = (String) componentActivity$activityResultRegistry$1.rcToKey.get(Integer.valueOf(i));
                if (str != null) {
                    ActivityResultRegistry.CallbackAndContract callbackAndContract = (ActivityResultRegistry.CallbackAndContract) componentActivity$activityResultRegistry$1.keyToCallback.get(str);
                    if ((callbackAndContract != null ? callbackAndContract.callback : null) == null) {
                        componentActivity$activityResultRegistry$1.pendingResults.remove(str);
                        componentActivity$activityResultRegistry$1.parsedPendingResults.put(str, obj3);
                    } else {
                        ActivityResultCallback activityResultCallback = callbackAndContract.callback;
                        activityResultCallback.getClass();
                        if (componentActivity$activityResultRegistry$1.launchedKeys.remove(str)) {
                            activityResultCallback.onActivityResult(obj3);
                        }
                    }
                    break;
                }
                break;
            case 2:
                ((ComponentActivity$activityResultRegistry$1) obj2).dispatchResult(i, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", (IntentSender.SendIntentException) obj));
                break;
            default:
                MediaControllerImplBase mediaControllerImplBase = (MediaControllerImplBase) obj2;
                try {
                    sessionResult = (SessionResult) ((ListenableFuture) obj).get();
                    UtilsKt.checkNotNull(sessionResult, "SessionResult must not be null");
                } catch (InterruptedException e) {
                    e = e;
                    Log.w("MCImplBase", "Session operation failed", e);
                    sessionResult = new SessionResult(-1);
                } catch (CancellationException e2) {
                    Log.w("MCImplBase", "Session operation cancelled", e2);
                    sessionResult = new SessionResult(1);
                } catch (ExecutionException e3) {
                    e = e3;
                    Log.w("MCImplBase", "Session operation failed", e);
                    sessionResult = new SessionResult(-1);
                }
                IMediaSession iMediaSession = mediaControllerImplBase.iSession;
                if (iMediaSession != null) {
                    try {
                        iMediaSession.onControllerResult(mediaControllerImplBase.controllerStub, i, sessionResult.toBundle());
                    } catch (RemoteException unused) {
                        Log.w("MCImplBase", "Error in sending");
                    }
                    break;
                }
                break;
        }
    }

    public /* synthetic */ ListenerSet$$ExternalSyntheticLambda1(Object obj, int i, Object obj2, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = i;
        this.f$2 = obj2;
    }
}
