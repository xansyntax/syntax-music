package androidx.compose.ui.scrollcapture;

import android.app.Notification;
import android.content.ClipData;
import android.content.Context;
import android.graphics.Point;
import android.media.metrics.LogSessionId;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.ContentInfo;
import android.view.ScrollCaptureTarget;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.semantics.SemanticsOwner;
import androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda2;
import androidx.compose.ui.unit.IntRect;
import androidx.core.graphics.TypefaceCompat$$ExternalSyntheticApiModelOutline0;
import androidx.core.view.ContentInfoCompat;
import androidx.media3.exoplayer.offline.Download;
import coil3.util.FileSystemsKt;
import coil3.util.UtilsKt;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.text.RegexKt;
import kotlinx.coroutines.AwaitKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ScrollCapture implements ContentInfoCompat.BuilderCompat, ContentInfoCompat.Compat {
    public final /* synthetic */ byte $r8$classId;
    public Object scrollCaptureInProgress$delegate;

    /* JADX INFO: renamed from: androidx.compose.ui.scrollcapture.ScrollCapture$onScrollCaptureSearch$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final /* synthetic */ class AnonymousClass1 extends AdaptedFunctionReference implements Function1 {
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            ((MutableVector) this.receiver).add((ScrollCaptureCandidate) obj);
            return Unit.INSTANCE;
        }
    }

    public ScrollCapture(byte b) {
        this.$r8$classId = b;
        switch (b) {
            case 3:
                this.scrollCaptureInProgress$delegate = LogSessionId.LOG_SESSION_ID_NONE;
                break;
            default:
                this.scrollCaptureInProgress$delegate = Stack.mutableStateOf$default(Boolean.FALSE);
                break;
        }
    }

    @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
    public ContentInfoCompat build() {
        return new ContentInfoCompat(new ScrollCapture(((ContentInfo.Builder) this.scrollCaptureInProgress$delegate).build()));
    }

    /* JADX WARN: Code duplicated, block: B:15:0x002a  */
    /* JADX WARN: Code duplicated, block: B:17:0x0034  */
    /* JADX WARN: Code duplicated, block: B:20:0x0040  */
    /* JADX WARN: Code duplicated, block: B:21:0x0042  */
    /* JADX WARN: Code duplicated, block: B:42:0x0076  */
    /* JADX WARN: Code duplicated, block: B:44:0x007a  */
    /* JADX WARN: Code duplicated, block: B:48:0x0083  */
    /* JADX WARN: Code duplicated, block: B:50:0x0087  */
    /* JADX WARN: Code duplicated, block: B:51:0x008c  */
    /* JADX WARN: Code duplicated, block: B:54:0x009e  */
    /* JADX WARN: Code duplicated, block: B:55:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:59:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:62:0x00cc  */
    public Notification buildProgressNotification(int i, Context context, String str, List list) {
        int i2;
        boolean z;
        int i3;
        boolean z2;
        int i4;
        Notification.Builder builder;
        String string;
        float f;
        boolean z3;
        float f2 = CropImageView.DEFAULT_ASPECT_RATIO;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        int i5 = 0;
        boolean z8 = true;
        for (int i6 = 0; i6 < list.size(); i6++) {
            Download download = (Download) list.get(i6);
            int i7 = download.state;
            if (i7 == 0) {
                z5 = true;
            } else if (i7 == 2) {
                f = download.progress.percentDownloaded;
                if (f != -1.0f) {
                    f2 += f;
                    z8 = false;
                }
                if (download.progress.bytesDownloaded > 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                z6 |= z3;
                i5++;
                z4 = true;
            } else if (i7 == 5) {
                z7 = true;
            } else if (i7 == 7) {
                f = download.progress.percentDownloaded;
                if (f != -1.0f) {
                    f2 += f;
                    z8 = false;
                }
                if (download.progress.bytesDownloaded > 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                z6 |= z3;
                i5++;
                z4 = true;
            }
        }
        if (!z4) {
            if (!z5 || i == 0) {
                i2 = z7 ? R.string.exo_download_removing : 0;
            } else {
                i2 = (i & 2) != 0 ? R.string.exo_download_paused_for_wifi : (i & 1) != 0 ? R.string.exo_download_paused_for_network : R.string.exo_download_paused;
                z = false;
            }
            if (z) {
                i4 = 100;
                if (z4) {
                    i3 = (int) (f2 / i5);
                    if (z8 || !z6) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                } else {
                    i3 = 0;
                    z2 = true;
                }
            } else {
                i3 = 0;
                z2 = false;
                i4 = 0;
            }
            builder = (Notification.Builder) this.scrollCaptureInProgress$delegate;
            builder.setSmallIcon(R.drawable.download);
            if (i2 == 0) {
                string = null;
            } else {
                string = context.getResources().getString(i2);
            }
            builder.setContentTitle(string);
            builder.setContentIntent(null);
            builder.setStyle(str != null ? new Notification.BigTextStyle().bigText(str) : null);
            builder.setProgress(i4, i3, z2);
            builder.setOngoing(true);
            builder.setShowWhen(false);
            if (Build.VERSION.SDK_INT >= 31) {
                builder.setForegroundServiceBehavior(1);
            }
            return builder.build();
        }
        i2 = R.string.exo_download_downloading;
        z = true;
        if (z) {
            i4 = 100;
            if (z4) {
                i3 = (int) (f2 / i5);
                if (z8) {
                    z2 = false;
                } else {
                    z2 = false;
                }
            } else {
                i3 = 0;
                z2 = true;
            }
        } else {
            i3 = 0;
            z2 = false;
            i4 = 0;
        }
        builder = (Notification.Builder) this.scrollCaptureInProgress$delegate;
        builder.setSmallIcon(R.drawable.download);
        if (i2 == 0) {
            string = null;
        } else {
            string = context.getResources().getString(i2);
        }
        builder.setContentTitle(string);
        builder.setContentIntent(null);
        builder.setStyle(str != null ? new Notification.BigTextStyle().bigText(str) : null);
        builder.setProgress(i4, i3, z2);
        builder.setOngoing(true);
        builder.setShowWhen(false);
        if (Build.VERSION.SDK_INT >= 31) {
            builder.setForegroundServiceBehavior(1);
        }
        return builder.build();
    }

    @Override // androidx.core.view.ContentInfoCompat.Compat
    public ClipData getClip() {
        return ((ContentInfo) this.scrollCaptureInProgress$delegate).getClip();
    }

    @Override // androidx.core.view.ContentInfoCompat.Compat
    public int getFlags() {
        return ((ContentInfo) this.scrollCaptureInProgress$delegate).getFlags();
    }

    @Override // androidx.core.view.ContentInfoCompat.Compat
    public int getSource() {
        return ((ContentInfo) this.scrollCaptureInProgress$delegate).getSource();
    }

    @Override // androidx.core.view.ContentInfoCompat.Compat
    public ContentInfo getWrapped() {
        return (ContentInfo) this.scrollCaptureInProgress$delegate;
    }

    public void onScrollCaptureSearch(AndroidComposeView androidComposeView, SemanticsOwner semanticsOwner, CoroutineContext coroutineContext, Consumer consumer) {
        MutableVector mutableVector = new MutableVector(new ScrollCaptureCandidate[16]);
        FileSystemsKt.visitScrollCaptureCandidates(semanticsOwner.getUnmergedRootSemanticsNode(), 0, new AnonymousClass1(1, mutableVector, MutableVector.class, "add", "add(Ljava/lang/Object;)Z", 8));
        Arrays.sort(mutableVector.content, 0, mutableVector.size, RegexKt.compareBy(new SaversKt$$ExternalSyntheticLambda2((byte) 4), new SaversKt$$ExternalSyntheticLambda2((byte) 5)));
        int i = mutableVector.size;
        ScrollCaptureCandidate scrollCaptureCandidate = (ScrollCaptureCandidate) (i == 0 ? null : mutableVector.content[i - 1]);
        if (scrollCaptureCandidate == null) {
            return;
        }
        IntRect intRect = scrollCaptureCandidate.viewportBoundsInWindow;
        ComposeScrollCaptureCallback composeScrollCaptureCallback = new ComposeScrollCaptureCallback(scrollCaptureCandidate.node, intRect, AwaitKt.CoroutineScope(coroutineContext), this, androidComposeView);
        NodeCoordinator nodeCoordinator = scrollCaptureCandidate.coordinates;
        Rect rectLocalBoundingBoxOf = RulerKt.findRootCoordinates(nodeCoordinator).localBoundingBoxOf(nodeCoordinator, true);
        long jM809getTopLeftnOccac = intRect.m809getTopLeftnOccac();
        ScrollCaptureTarget scrollCaptureTarget = new ScrollCaptureTarget(androidComposeView, ColorKt.toAndroidRect(DatabaseDao_Impl.AnonymousClass17.roundToIntRect(rectLocalBoundingBoxOf)), new Point((int) (jM809getTopLeftnOccac >> 32), (int) (jM809getTopLeftnOccac & 4294967295L)), composeScrollCaptureCallback);
        scrollCaptureTarget.setScrollBounds(ColorKt.toAndroidRect(intRect));
        consumer.accept(scrollCaptureTarget);
    }

    @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
    public void setExtras(Bundle bundle) {
        ((ContentInfo.Builder) this.scrollCaptureInProgress$delegate).setExtras(bundle);
    }

    @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
    public void setFlags(int i) {
        ((ContentInfo.Builder) this.scrollCaptureInProgress$delegate).setFlags(i);
    }

    @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
    public void setLinkUri(Uri uri) {
        ((ContentInfo.Builder) this.scrollCaptureInProgress$delegate).setLinkUri(uri);
    }

    public void setLogSessionId(LogSessionId logSessionId) {
        UtilsKt.checkState(((LogSessionId) this.scrollCaptureInProgress$delegate).equals(LogSessionId.LOG_SESSION_ID_NONE));
        this.scrollCaptureInProgress$delegate = logSessionId;
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 2:
                return "ContentInfoCompat{" + ((ContentInfo) this.scrollCaptureInProgress$delegate) + "}";
            default:
                return super.toString();
        }
    }

    public ScrollCapture(Context context) {
        this.$r8$classId = (byte) 4;
        this.scrollCaptureInProgress$delegate = new Notification.Builder(context.getApplicationContext(), "download");
    }

    public ScrollCapture(ContentInfo contentInfo) {
        this.$r8$classId = (byte) 2;
        contentInfo.getClass();
        this.scrollCaptureInProgress$delegate = contentInfo;
    }

    public ScrollCapture(ClipData clipData, int i) {
        this.$r8$classId = (byte) 1;
        this.scrollCaptureInProgress$delegate = TypefaceCompat$$ExternalSyntheticApiModelOutline0.m(clipData, i);
    }
}
