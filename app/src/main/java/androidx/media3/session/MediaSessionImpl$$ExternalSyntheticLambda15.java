package androidx.media3.session;

import android.content.res.Resources;
import android.os.Build;
import android.util.Base64;
import androidx.compose.ui.text.input.GapBuffer;
import androidx.media3.exoplayer.DefaultLoadControl;
import androidx.media3.exoplayer.analytics.DefaultPlaybackSessionManager;
import com.google.common.base.Supplier;
import com.google.common.collect.RegularImmutableMap;
import com.google.common.util.concurrent.MoreExecutors$ListeningDecorator;
import com.google.common.util.concurrent.MoreExecutors$ScheduledListeningDecorator;
import io.ktor.client.utils.CIOKt;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MediaSessionImpl$$ExternalSyntheticLambda15 implements Supplier {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ MediaSessionImpl$$ExternalSyntheticLambda15(byte b) {
        this.$r8$classId = b;
    }

    @Override // com.google.common.base.Supplier
    public final Object get() {
        int dimensionPixelSize;
        switch (this.$r8$classId) {
            case 0:
                Resources system = Resources.getSystem();
                int dimensionPixelSize2 = system.getDisplayMetrics().widthPixels;
                try {
                    dimensionPixelSize2 = system.getDimensionPixelSize(system.getIdentifier("config_mediaMetadataBitmapMaxSize", "dimen", "android"));
                    break;
                } catch (Resources.NotFoundException unused) {
                }
                return Integer.valueOf(dimensionPixelSize2);
            case 1:
                ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
                if (executorServiceNewSingleThreadExecutor instanceof MoreExecutors$ListeningDecorator) {
                    return (MoreExecutors$ListeningDecorator) executorServiceNewSingleThreadExecutor;
                }
                return executorServiceNewSingleThreadExecutor instanceof ScheduledExecutorService ? new MoreExecutors$ScheduledListeningDecorator((ScheduledExecutorService) executorServiceNewSingleThreadExecutor) : new MoreExecutors$ListeningDecorator(executorServiceNewSingleThreadExecutor);
            case 2:
                return new DefaultLoadControl(new GapBuffer((byte) 6), CIOKt.DEFAULT_HTTP_POOL_SIZE, CIOKt.DEFAULT_HTTP_POOL_SIZE, CIOKt.DEFAULT_HTTP_POOL_SIZE, CIOKt.DEFAULT_HTTP_POOL_SIZE, true, RegularImmutableMap.EMPTY);
            case 3:
                byte[] bArr = new byte[12];
                DefaultPlaybackSessionManager.RANDOM.nextBytes(bArr);
                return Base64.encodeToString(bArr, 10);
            case 4:
                try {
                    return Class.forName("androidx.media3.effect.DefaultVideoFrameProcessor$Factory$Builder");
                } catch (Exception e) {
                    throw new IllegalStateException(e);
                }
            default:
                Resources system2 = Resources.getSystem();
                try {
                    dimensionPixelSize = system2.getDimensionPixelSize(system2.getIdentifier("notification_right_icon_size", "dimen", "android"));
                    if (Build.VERSION.SDK_INT < 31) {
                        dimensionPixelSize = Integer.max(Integer.max(dimensionPixelSize, system2.getDimensionPixelSize(system2.getIdentifier("notification_media_image_max_width", "dimen", "android"))), system2.getDimensionPixelSize(system2.getIdentifier("notification_media_image_max_height", "dimen", "android")));
                    }
                    break;
                } catch (Resources.NotFoundException unused2) {
                    dimensionPixelSize = (int) ((Build.VERSION.SDK_INT < 31 ? 280 : 48) * system2.getDisplayMetrics().density);
                }
                return Integer.valueOf(dimensionPixelSize);
        }
    }
}
