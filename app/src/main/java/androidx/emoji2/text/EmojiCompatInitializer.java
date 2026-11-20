package androidx.emoji2.text;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Trace;
import androidx.core.os.TraceCompat;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleInitializer;
import androidx.navigation.internal.NavContext;
import androidx.startup.AppInitializer;
import androidx.startup.Initializer;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class EmojiCompatInitializer implements Initializer {
    @Override // androidx.startup.Initializer
    public final Object create(Context context) {
        Object objDoInitialize;
        FontRequestEmojiCompatConfig fontRequestEmojiCompatConfig = new FontRequestEmojiCompatConfig(new NavContext(context, (byte) 2));
        fontRequestEmojiCompatConfig.mMetadataLoadStrategy = true;
        if (EmojiCompat.sInstance == null) {
            synchronized (EmojiCompat.INSTANCE_LOCK) {
                try {
                    if (EmojiCompat.sInstance == null) {
                        EmojiCompat.sInstance = new EmojiCompat(fontRequestEmojiCompatConfig);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        AppInitializer appInitializer = AppInitializer.getInstance(context);
        appInitializer.getClass();
        synchronized (AppInitializer.sLock) {
            try {
                objDoInitialize = appInitializer.mInitialized.get(ProcessLifecycleInitializer.class);
                if (objDoInitialize == null) {
                    objDoInitialize = appInitializer.doInitialize(ProcessLifecycleInitializer.class, new HashSet());
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        final Lifecycle lifecycle = ((LifecycleOwner) objDoInitialize).getLifecycle();
        lifecycle.addObserver(new DefaultLifecycleObserver(this) { // from class: androidx.emoji2.text.EmojiCompatInitializer.1
            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public final void onResume(LifecycleOwner lifecycleOwner) {
                (Build.VERSION.SDK_INT >= 28 ? ConcurrencyHelpers$Handler28Impl.createAsync(Looper.getMainLooper()) : new Handler(Looper.getMainLooper())).postDelayed(new LoadEmojiCompatRunnable((byte) 0), 500L);
                lifecycle.removeObserver(this);
            }
        });
        return Boolean.TRUE;
    }

    @Override // androidx.startup.Initializer
    public final List dependencies() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class LoadEmojiCompatRunnable implements Runnable {
        public final /* synthetic */ byte $r8$classId;

        public /* synthetic */ LoadEmojiCompatRunnable(byte b) {
            this.$r8$classId = b;
        }

        @Override // java.lang.Runnable
        public final void run() {
            switch (this.$r8$classId) {
                case 0:
                    try {
                        int i = TraceCompat.$r8$clinit;
                        Trace.beginSection("EmojiCompat.EmojiCompatInitializer.run");
                        if (EmojiCompat.isConfigured()) {
                            EmojiCompat.get().load();
                            break;
                        }
                        return;
                    } finally {
                        int i2 = TraceCompat.$r8$clinit;
                        Trace.endSection();
                    }
                default:
                    return;
            }
        }

        private final void run$com$google$common$util$concurrent$InterruptibleTask$DoNothingRunnable() {
        }
    }
}
