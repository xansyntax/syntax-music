package androidx.emoji2.text;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.core.app.ActivityCompat$$ExternalSyntheticLambda0;
import androidx.core.provider.FontProvider;
import androidx.core.provider.FontRequest;
import androidx.core.provider.FontsContractCompat$FontInfo;
import androidx.media3.common.FlagSet;
import androidx.media3.common.util.Util$$ExternalSyntheticLambda2;
import coil3.size.SizeKt;
import com.metrolist.music.db.DatabaseDao_Impl;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FontRequestEmojiCompatConfig {
    public final EmojiCompat.MetadataRepoLoader mMetadataLoader;
    public boolean mMetadataLoadStrategy = false;
    public final DefaultGlyphChecker mGlyphChecker = new DefaultGlyphChecker();

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class FontRequestMetadataLoader implements EmojiCompat.MetadataRepoLoader {
        public SizeKt mCallback;
        public final Context mContext;
        public ThreadPoolExecutor mExecutor;
        public final Object mLock = new Object();
        public Handler mMainHandler;
        public ThreadPoolExecutor mMyThreadPoolExecutor;
        public final FontRequest mRequest;

        public FontRequestMetadataLoader(Context context, FontRequest fontRequest) {
            DatabaseDao_Impl.AnonymousClass17.checkNotNull(context, "Context cannot be null");
            this.mContext = context.getApplicationContext();
            this.mRequest = fontRequest;
        }

        public final void cleanUp() {
            synchronized (this.mLock) {
                try {
                    this.mCallback = null;
                    Handler handler = this.mMainHandler;
                    if (handler != null) {
                        handler.removeCallbacks(null);
                    }
                    this.mMainHandler = null;
                    ThreadPoolExecutor threadPoolExecutor = this.mMyThreadPoolExecutor;
                    if (threadPoolExecutor != null) {
                        threadPoolExecutor.shutdown();
                    }
                    this.mExecutor = null;
                    this.mMyThreadPoolExecutor = null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoader
        public final void load(SizeKt sizeKt) {
            synchronized (this.mLock) {
                this.mCallback = sizeKt;
            }
            synchronized (this.mLock) {
                try {
                    if (this.mCallback == null) {
                        return;
                    }
                    ThreadPoolExecutor threadPoolExecutor = this.mExecutor;
                    if (threadPoolExecutor == null) {
                        ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new Util$$ExternalSyntheticLambda2("emojiCompat", (byte) 1));
                        threadPoolExecutor2.allowCoreThreadTimeOut(true);
                        this.mMyThreadPoolExecutor = threadPoolExecutor2;
                        this.mExecutor = threadPoolExecutor2;
                        threadPoolExecutor = threadPoolExecutor2;
                    }
                    threadPoolExecutor.execute(new ActivityCompat$$ExternalSyntheticLambda0((byte) 11, (Object) this));
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final FontsContractCompat$FontInfo retrieveFontInfo() {
            try {
                Context context = this.mContext;
                Object[] objArr = {this.mRequest};
                ArrayList arrayList = new ArrayList(1);
                Object obj = objArr[0];
                Objects.requireNonNull(obj);
                arrayList.add(obj);
                FlagSet.Builder fontFamilyResult = FontProvider.getFontFamilyResult(context, Collections.unmodifiableList(arrayList));
                boolean z = fontFamilyResult.buildCalled;
                if (z) {
                    throw new RuntimeException(IntIntPair$$ExternalSyntheticOutline0.m(z ? 1 : 0, "fetchFonts failed (", ")"));
                }
                FontsContractCompat$FontInfo[] fontsContractCompat$FontInfoArr = (FontsContractCompat$FontInfo[]) ((List) fontFamilyResult.flags).get(0);
                if (fontsContractCompat$FontInfoArr == null || fontsContractCompat$FontInfoArr.length == 0) {
                    throw new RuntimeException("fetchFonts failed (empty result)");
                }
                return fontsContractCompat$FontInfoArr[0];
            } catch (PackageManager.NameNotFoundException e) {
                PathKt$$ExternalSyntheticBUOutline0.m("provider not found", (Throwable) e);
                return null;
            }
        }
    }

    public FontRequestEmojiCompatConfig(EmojiCompat.MetadataRepoLoader metadataRepoLoader) {
        this.mMetadataLoader = metadataRepoLoader;
    }
}
