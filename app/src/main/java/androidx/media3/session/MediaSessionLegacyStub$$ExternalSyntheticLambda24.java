package androidx.media3.session;

import android.graphics.Point;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.ResultReceiver;
import androidx.media3.common.Format;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import androidx.room.TransactionExecutor$$ExternalSyntheticLambda0;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.DirectExecutor;
import com.google.common.util.concurrent.ImmediateFuture;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MediaSessionLegacyStub$$ExternalSyntheticLambda24 implements DefaultTrackSelector.TrackInfo.Factory, MediaSessionLegacyStub.SessionTask {
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Cloneable f$2;
    public final /* synthetic */ Parcelable f$3;

    public /* synthetic */ MediaSessionLegacyStub$$ExternalSyntheticLambda24(Object obj, Object obj2, Cloneable cloneable, Parcelable parcelable) {
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = cloneable;
        this.f$3 = parcelable;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0054  */
    @Override // androidx.media3.exoplayer.trackselection.DefaultTrackSelector.TrackInfo.Factory
    public RegularImmutableList create(int i, TrackGroup trackGroup, int[] iArr) {
        int i2;
        int i3;
        int i4;
        int i5;
        TrackGroup trackGroup2 = trackGroup;
        DefaultTrackSelector.Parameters parameters = (DefaultTrackSelector.Parameters) this.f$0;
        String str = (String) this.f$1;
        int[] iArr2 = (int[]) this.f$2;
        Point point = (Point) this.f$3;
        int i6 = iArr2[i];
        int i7 = point != null ? point.x : parameters.viewportWidth;
        int i8 = point != null ? point.y : parameters.viewportHeight;
        boolean z = parameters.viewportOrientationMayChange;
        if (i7 == Integer.MAX_VALUE || i8 == Integer.MAX_VALUE) {
            i2 = Integer.MAX_VALUE;
        } else {
            int i9 = Integer.MAX_VALUE;
            for (int i10 = 0; i10 < trackGroup2.length; i10++) {
                Format format = trackGroup2.formats[i10];
                int i11 = format.width;
                int i12 = format.height;
                if (i11 > 0 && i12 > 0) {
                    if (!z) {
                        i4 = i8;
                        i5 = i7;
                    } else if ((i11 > i12) != (i7 > i8)) {
                        i5 = i8;
                        i4 = i7;
                    } else {
                        i4 = i8;
                        i5 = i7;
                    }
                    int i13 = i11 * i4;
                    int i14 = i12 * i5;
                    Point point2 = i13 >= i14 ? new Point(i5, Util.ceilDivide(i14, i11)) : new Point(Util.ceilDivide(i13, i12), i4);
                    int i15 = format.width;
                    int i16 = i15 * i12;
                    if (i15 >= ((int) (point2.x * 0.98f)) && i12 >= ((int) (point2.y * 0.98f)) && i16 < i9) {
                        i9 = i16;
                    }
                }
            }
            i2 = i9;
        }
        ImmutableList.Builder builder = ImmutableList.builder();
        int i17 = 0;
        while (i17 < trackGroup2.length) {
            Format format2 = trackGroup2.formats[i17];
            int i18 = format2.width;
            int i19 = (i18 == -1 || (i3 = format2.height) == -1) ? -1 : i18 * i3;
            builder.add((Object) new DefaultTrackSelector.VideoTrackInfo(i, trackGroup2, i17, parameters, iArr[i17], str, i6, i2 == Integer.MAX_VALUE || (i19 != -1 && i19 <= i2)));
            i17++;
            trackGroup2 = trackGroup;
        }
        return builder.build();
    }

    @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
    public void run(MediaSession$ControllerInfo mediaSession$ControllerInfo) {
        MediaSessionLegacyStub mediaSessionLegacyStub = (MediaSessionLegacyStub) this.f$0;
        SessionCommand sessionCommand = (SessionCommand) this.f$1;
        Bundle bundle = (Bundle) this.f$2;
        ResultReceiver resultReceiver = (ResultReceiver) this.f$3;
        MediaLibrarySessionImpl mediaLibrarySessionImpl = mediaSessionLegacyStub.sessionImpl;
        if (bundle == null) {
            bundle = Bundle.EMPTY;
        }
        ImmediateFuture immediateFutureOnCustomCommandOnHandler = mediaLibrarySessionImpl.onCustomCommandOnHandler(mediaSession$ControllerInfo, sessionCommand, bundle);
        if (resultReceiver != null) {
            immediateFutureOnCustomCommandOnHandler.addListener(new TransactionExecutor$$ExternalSyntheticLambda0(immediateFutureOnCustomCommandOnHandler, resultReceiver, (byte) 12), DirectExecutor.INSTANCE);
        }
    }
}
