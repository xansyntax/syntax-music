package androidx.media3.session;

import android.os.Trace;
import android.util.Pair;
import androidx.compose.animation.core.FloatTweenSpec;
import androidx.compose.runtime.snapshots.MutableSnapshot;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.ui.text.AndroidParagraphIntrinsics;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter$SafeFuture;
import androidx.media3.exoplayer.ExoPlayerImpl$$ExternalSyntheticLambda5;
import androidx.media3.exoplayer.MediaSourceList;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MediaSource$MediaPeriodId;
import coil3.util.UtilsKt;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import kotlin.collections.EmptyList;
import okio.PriorityQueue;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MediaNotificationManager$$ExternalSyntheticLambda6 implements Runnable {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ boolean f$4;
    public final /* synthetic */ Object f$5;

    public /* synthetic */ MediaNotificationManager$$ExternalSyntheticLambda6(MediaNotificationManager mediaNotificationManager, MediaLibraryService.MediaLibrarySession mediaLibrarySession, ImmutableList immutableList, ExoPlayerImpl$$ExternalSyntheticLambda5 exoPlayerImpl$$ExternalSyntheticLambda5, boolean z, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        this.$r8$classId = (byte) 0;
        this.f$0 = mediaNotificationManager;
        this.f$1 = mediaLibrarySession;
        this.f$2 = immutableList;
        this.f$3 = exoPlayerImpl$$ExternalSyntheticLambda5;
        this.f$4 = z;
        this.f$5 = callbackToFutureAdapter$Completer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MutableSnapshot mutableSnapshotTakeNestedMutableSnapshot;
        byte b = this.$r8$classId;
        Object obj = this.f$5;
        Object obj2 = this.f$3;
        Object obj3 = this.f$2;
        Object obj4 = this.f$1;
        Object obj5 = this.f$0;
        switch (b) {
            case 0:
                MediaNotificationManager mediaNotificationManager = (MediaNotificationManager) obj5;
                MediaLibraryService.MediaLibrarySession mediaLibrarySession = (MediaLibraryService.MediaLibrarySession) obj4;
                ImmutableList immutableList = (ImmutableList) obj3;
                ExoPlayerImpl$$ExternalSyntheticLambda5 exoPlayerImpl$$ExternalSyntheticLambda5 = (ExoPlayerImpl$$ExternalSyntheticLambda5) obj2;
                boolean z = this.f$4;
                CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer = (CallbackToFutureAdapter$Completer) obj;
                try {
                    PriorityQueue priorityQueueCreateNotification = mediaNotificationManager.mediaNotificationProvider.createNotification(mediaLibrarySession, immutableList, mediaNotificationManager.actionFactory, exoPlayerImpl$$ExternalSyntheticLambda5);
                    UtilsKt.checkState("notification ID 20938 is already used internally.", priorityQueueCreateNotification.size != 20938);
                    mediaNotificationManager.mainExecutor.execute(new MediaNotificationManager$$ExternalSyntheticLambda7(mediaNotificationManager, mediaLibrarySession, priorityQueueCreateNotification, z, callbackToFutureAdapter$Completer));
                    return;
                } catch (RuntimeException e) {
                    callbackToFutureAdapter$Completer.attemptedSetting = true;
                    CallbackToFutureAdapter$SafeFuture callbackToFutureAdapter$SafeFuture = callbackToFutureAdapter$Completer.future;
                    if (callbackToFutureAdapter$SafeFuture == null || !callbackToFutureAdapter$SafeFuture.delegate.setException(e)) {
                        return;
                    }
                    callbackToFutureAdapter$Completer.tag = null;
                    callbackToFutureAdapter$Completer.future = null;
                    callbackToFutureAdapter$Completer.cancellationFuture = null;
                    return;
                }
            case 1:
                TextStyle textStyle = (TextStyle) obj5;
                LayoutDirection layoutDirection = (LayoutDirection) obj4;
                String str = (String) obj3;
                Density density = (Density) obj2;
                FontFamily.Resolver resolver = (FontFamily.Resolver) obj;
                boolean z2 = this.f$4;
                Trace.beginSection("BackgroundTextMeasurement");
                try {
                    Snapshot snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
                    MutableSnapshot mutableSnapshot = snapshotCurrentSnapshot instanceof MutableSnapshot ? (MutableSnapshot) snapshotCurrentSnapshot : null;
                    if (mutableSnapshot == null || (mutableSnapshotTakeNestedMutableSnapshot = mutableSnapshot.takeNestedMutableSnapshot(null, null)) == null) {
                        throw new IllegalStateException("Cannot create a mutable snapshot of an read-only snapshot");
                    }
                    try {
                        Snapshot snapshotMakeCurrent = mutableSnapshotTakeNestedMutableSnapshot.makeCurrent();
                        try {
                            TextStyle textStyleResolveDefaults = TextRangeKt.resolveDefaults(textStyle, layoutDirection);
                            EmptyList emptyList = EmptyList.INSTANCE;
                            AndroidParagraphIntrinsics androidParagraphIntrinsics = new AndroidParagraphIntrinsics(str, textStyleResolveDefaults, emptyList, emptyList, resolver, density, z2);
                            androidParagraphIntrinsics.getMaxIntrinsicWidth();
                            androidParagraphIntrinsics.getMinIntrinsicWidth();
                            Snapshot.restoreCurrent(snapshotMakeCurrent);
                            mutableSnapshotTakeNestedMutableSnapshot.apply().check();
                            mutableSnapshotTakeNestedMutableSnapshot.dispose();
                            Trace.endSection();
                            return;
                        } catch (Throwable th) {
                            Snapshot.restoreCurrent(snapshotMakeCurrent);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        try {
                            throw th2;
                        } catch (Throwable th3) {
                            mutableSnapshotTakeNestedMutableSnapshot.dispose();
                            throw th3;
                        }
                    }
                } catch (Throwable th4) {
                    Trace.endSection();
                    throw th4;
                }
            default:
                Pair pair = (Pair) obj4;
                MediaSourceList.this.eventListener.onLoadError(((Integer) pair.first).intValue(), (MediaSource$MediaPeriodId) pair.second, (LoadEventInfo) obj3, (FloatTweenSpec) obj2, (IOException) obj, this.f$4);
                return;
        }
    }

    public /* synthetic */ MediaNotificationManager$$ExternalSyntheticLambda6(byte b, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, boolean z) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
        this.f$3 = obj4;
        this.f$5 = obj5;
        this.f$4 = z;
    }
}
