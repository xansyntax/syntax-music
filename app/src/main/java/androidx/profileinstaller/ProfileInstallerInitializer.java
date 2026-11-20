package androidx.profileinstaller;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import androidx.appcompat.app.AppCompatDelegate$$ExternalSyntheticLambda0;
import androidx.media3.extractor.text.CueDecoder;
import androidx.startup.Initializer;
import io.ktor.client.utils.CIOKt;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class ProfileInstallerInitializer implements Initializer {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract class Handler28Impl {
        public static Handler createAsync(Looper looper) {
            return Handler.createAsync(looper);
        }
    }

    @Override // androidx.startup.Initializer
    public final Object create(Context context) {
        final Context applicationContext = context.getApplicationContext();
        Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback(this) { // from class: androidx.profileinstaller.ProfileInstallerInitializer$$ExternalSyntheticLambda0
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j) {
                (Build.VERSION.SDK_INT >= 28 ? ProfileInstallerInitializer.Handler28Impl.createAsync(Looper.getMainLooper()) : new Handler(Looper.getMainLooper())).postDelayed(new AppCompatDelegate$$ExternalSyntheticLambda0(applicationContext, (byte) 1), new Random().nextInt(Math.max(CIOKt.DEFAULT_HTTP_POOL_SIZE, 1)) + 5000);
            }
        });
        return new CueDecoder((byte) 22);
    }

    @Override // androidx.startup.Initializer
    public final List dependencies() {
        return Collections.EMPTY_LIST;
    }
}
