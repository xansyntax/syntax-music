package androidx.media3.session;

import android.graphics.Bitmap;
import android.util.Pair;
import androidx.compose.animation.core.FloatTweenSpec;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.Log;
import androidx.media3.exoplayer.MediaSourceList;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MediaSource$MediaPeriodId;
import androidx.media3.session.legacy.MediaControllerCompat$MediaControllerImplApi23;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MediaControllerImplLegacy$$ExternalSyntheticLambda3 implements Runnable {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ int f$4;

    public /* synthetic */ MediaControllerImplLegacy$$ExternalSyntheticLambda3(Object obj, Object obj2, Object obj3, Object obj4, int i, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
        this.f$3 = obj4;
        this.f$4 = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bitmap bitmap;
        byte b = this.$r8$classId;
        Object obj = this.f$3;
        Object obj2 = this.f$2;
        Object obj3 = this.f$1;
        Object obj4 = this.f$0;
        switch (b) {
            case 0:
                MediaControllerImplLegacy mediaControllerImplLegacy = (MediaControllerImplLegacy) obj4;
                List list = (List) obj2;
                ArrayList arrayList = (ArrayList) obj;
                if (((AtomicInteger) obj3).incrementAndGet() == list.size() && !mediaControllerImplLegacy.released && (((MediaControllerCompat$MediaControllerImplApi23) mediaControllerImplLegacy.controllerCompat.mCallback).controllerFwk.getFlags() & 4) != 0) {
                    for (int i = 0; i < arrayList.size(); i++) {
                        ListenableFuture listenableFuture = (ListenableFuture) arrayList.get(i);
                        if (listenableFuture != null) {
                            try {
                                bitmap = (Bitmap) UuidKt.getDone(listenableFuture);
                            } catch (CancellationException | ExecutionException e) {
                                Log.d("Failed to get bitmap", e);
                                bitmap = null;
                            }
                        } else {
                            bitmap = null;
                        }
                        mediaControllerImplLegacy.controllerCompat.addQueueItem(LegacyConversions.convertToMediaDescriptionCompat((MediaItem) list.get(i), bitmap), this.f$4 + i);
                    }
                    break;
                }
                break;
            default:
                Pair pair = (Pair) obj3;
                MediaSourceList.this.eventListener.onLoadStarted(((Integer) pair.first).intValue(), (MediaSource$MediaPeriodId) pair.second, (LoadEventInfo) obj2, (FloatTweenSpec) obj, this.f$4);
                break;
        }
    }
}
