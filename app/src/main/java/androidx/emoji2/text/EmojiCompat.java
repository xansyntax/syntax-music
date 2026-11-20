package androidx.emoji2.text;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.view.inputmethod.EditorInfo;
import androidx.collection.ArraySet;
import androidx.collection.internal.Lock;
import androidx.compose.ui.platform.WeakCache;
import androidx.emoji2.text.flatbuffer.MetadataList;
import coil3.size.SizeKt;
import com.google.common.math.IntMath;
import com.metrolist.music.db.DatabaseDao_Impl;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import okhttp3.Dispatcher;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class EmojiCompat {
    public static final Object INSTANCE_LOCK = new Object();
    public static volatile EmojiCompat sInstance;
    public final DefaultGlyphChecker mGlyphChecker;
    public final CompatInternal19 mHelper;
    public final ArraySet mInitCallbacks;
    public final ReentrantReadWriteLock mInitLock;
    public volatile byte mLoadState;
    public final Handler mMainHandler;
    public final boolean mMetadataLoadStrategy;
    public final MetadataRepoLoader mMetadataLoader;
    public final Lock mSpanFactory;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class CompatInternal19 {
        public final EmojiCompat mEmojiCompat;
        public volatile Dispatcher mMetadataRepo;
        public volatile EmojiProcessor mProcessor;

        /* JADX INFO: renamed from: androidx.emoji2.text.EmojiCompat$CompatInternal19$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public final class AnonymousClass1 extends SizeKt {
            public AnonymousClass1() {
            }

            @Override // coil3.size.SizeKt
            public final void onFailed(Throwable th) {
                CompatInternal19.this.mEmojiCompat.onMetadataLoadFailed(th);
            }

            @Override // coil3.size.SizeKt
            public final void onLoaded(Dispatcher dispatcher) {
                CompatInternal19 compatInternal19 = CompatInternal19.this;
                compatInternal19.mMetadataRepo = dispatcher;
                Dispatcher dispatcher2 = compatInternal19.mMetadataRepo;
                EmojiCompat emojiCompat = compatInternal19.mEmojiCompat;
                compatInternal19.mProcessor = new EmojiProcessor(dispatcher2, emojiCompat.mSpanFactory, emojiCompat.mGlyphChecker, Build.VERSION.SDK_INT >= 34 ? EmojiExclusions$EmojiExclusions_Api34.getExclusions() : IntMath.getExclusions());
                EmojiCompat emojiCompat2 = compatInternal19.mEmojiCompat;
                ArrayList arrayList = new ArrayList();
                emojiCompat2.mInitLock.writeLock().lock();
                try {
                    emojiCompat2.mLoadState = (byte) 1;
                    arrayList.addAll(emojiCompat2.mInitCallbacks);
                    emojiCompat2.mInitCallbacks.clear();
                    emojiCompat2.mInitLock.writeLock().unlock();
                    emojiCompat2.mMainHandler.post(new ListenerDispatcher(arrayList, emojiCompat2.mLoadState, null));
                } catch (Throwable th) {
                    emojiCompat2.mInitLock.writeLock().unlock();
                    throw th;
                }
            }
        }

        public CompatInternal19(EmojiCompat emojiCompat) {
            this.mEmojiCompat = emojiCompat;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ListenerDispatcher implements Runnable {
        public final ArrayList mInitCallbacks;
        public final byte mLoadState;

        /* JADX WARN: Multi-variable type inference failed */
        public ListenerDispatcher(List list, int i, Throwable th) {
            DatabaseDao_Impl.AnonymousClass17.checkNotNull(list, "initCallbacks cannot be null");
            this.mInitCallbacks = new ArrayList(list);
            this.mLoadState = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ArrayList arrayList = this.mInitCallbacks;
            int size = arrayList.size();
            int i = 0;
            if (this.mLoadState != 1) {
                while (i < size) {
                    ((InitCallback) arrayList.get(i)).onFailed();
                    i++;
                }
            } else {
                while (i < size) {
                    ((InitCallback) arrayList.get(i)).onInitialized();
                    i++;
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface MetadataRepoLoader {
        void load(SizeKt sizeKt);
    }

    public EmojiCompat(FontRequestEmojiCompatConfig fontRequestEmojiCompatConfig) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.mInitLock = reentrantReadWriteLock;
        this.mLoadState = (byte) 3;
        MetadataRepoLoader metadataRepoLoader = fontRequestEmojiCompatConfig.mMetadataLoader;
        this.mMetadataLoader = metadataRepoLoader;
        boolean z = fontRequestEmojiCompatConfig.mMetadataLoadStrategy;
        this.mMetadataLoadStrategy = z;
        this.mGlyphChecker = fontRequestEmojiCompatConfig.mGlyphChecker;
        this.mMainHandler = new Handler(Looper.getMainLooper());
        this.mInitCallbacks = new ArraySet(0);
        this.mSpanFactory = new Lock((byte) 14);
        CompatInternal19 compatInternal19 = new CompatInternal19(this);
        this.mHelper = compatInternal19;
        reentrantReadWriteLock.writeLock().lock();
        if (!z) {
            try {
                this.mLoadState = (byte) 0;
            } catch (Throwable th) {
                this.mInitLock.writeLock().unlock();
                throw th;
            }
        }
        reentrantReadWriteLock.writeLock().unlock();
        if (getLoadState() == 0) {
            try {
                metadataRepoLoader.load(compatInternal19.new AnonymousClass1());
            } catch (Throwable th2) {
                onMetadataLoadFailed(th2);
            }
        }
    }

    public static EmojiCompat get() {
        EmojiCompat emojiCompat;
        synchronized (INSTANCE_LOCK) {
            emojiCompat = sInstance;
            DatabaseDao_Impl.AnonymousClass17.checkState("EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.", emojiCompat != null);
        }
        return emojiCompat;
    }

    public static boolean isConfigured() {
        return sInstance != null;
    }

    public final int getEmojiStart(CharSequence charSequence, int i) {
        DatabaseDao_Impl.AnonymousClass17.checkState("Not initialized yet", getLoadState() == 1);
        DatabaseDao_Impl.AnonymousClass17.checkNotNull(charSequence, "charSequence cannot be null");
        EmojiProcessor emojiProcessor = this.mHelper.mProcessor;
        emojiProcessor.getClass();
        if (i < 0 || i >= charSequence.length()) {
            return -1;
        }
        if (charSequence instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence;
            TypefaceEmojiSpan[] typefaceEmojiSpanArr = (TypefaceEmojiSpan[]) spanned.getSpans(i, i + 1, TypefaceEmojiSpan.class);
            if (typefaceEmojiSpanArr.length > 0) {
                return spanned.getSpanStart(typefaceEmojiSpanArr[0]);
            }
        }
        return ((EmojiProcessor.EmojiProcessLookupCallback) emojiProcessor.process(charSequence, Math.max(0, i - 16), Math.min(charSequence.length(), i + 16), Integer.MAX_VALUE, true, new EmojiProcessor.EmojiProcessLookupCallback(i))).start;
    }

    public final int getLoadState() {
        this.mInitLock.readLock().lock();
        try {
            return this.mLoadState;
        } finally {
            this.mInitLock.readLock().unlock();
        }
    }

    public final void load() {
        DatabaseDao_Impl.AnonymousClass17.checkState("Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading", this.mMetadataLoadStrategy);
        if (getLoadState() == 1) {
            return;
        }
        this.mInitLock.writeLock().lock();
        try {
            if (this.mLoadState == 0) {
                this.mInitLock.writeLock().unlock();
                return;
            }
            this.mLoadState = (byte) 0;
            this.mInitLock.writeLock().unlock();
            CompatInternal19 compatInternal19 = this.mHelper;
            EmojiCompat emojiCompat = compatInternal19.mEmojiCompat;
            try {
                emojiCompat.mMetadataLoader.load(compatInternal19.new AnonymousClass1());
            } catch (Throwable th) {
                emojiCompat.onMetadataLoadFailed(th);
            }
        } catch (Throwable th2) {
            this.mInitLock.writeLock().unlock();
            throw th2;
        }
    }

    public final void onMetadataLoadFailed(Throwable th) {
        ArrayList arrayList = new ArrayList();
        this.mInitLock.writeLock().lock();
        try {
            this.mLoadState = (byte) 2;
            arrayList.addAll(this.mInitCallbacks);
            this.mInitCallbacks.clear();
            this.mInitLock.writeLock().unlock();
            this.mMainHandler.post(new ListenerDispatcher(arrayList, this.mLoadState, th));
        } catch (Throwable th2) {
            this.mInitLock.writeLock().unlock();
            throw th2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:105:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:107:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:57:0x009f A[Catch: all -> 0x0082, TryCatch #0 {all -> 0x0082, blocks: (B:37:0x005a, B:40:0x005f, B:42:0x0063, B:44:0x0070, B:51:0x008f, B:53:0x0099, B:55:0x009c, B:57:0x009f, B:59:0x00af, B:60:0x00b2), top: B:98:0x005a }] */
    /* JADX WARN: Code duplicated, block: B:59:0x00af A[Catch: all -> 0x0082, TryCatch #0 {all -> 0x0082, blocks: (B:37:0x005a, B:40:0x005f, B:42:0x0063, B:44:0x0070, B:51:0x008f, B:53:0x0099, B:55:0x009c, B:57:0x009f, B:59:0x00af, B:60:0x00b2), top: B:98:0x005a }] */
    /* JADX WARN: Code duplicated, block: B:66:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:85:0x00ff  */
    public final CharSequence process(int i, int i2, int i3, CharSequence charSequence) throws Throwable {
        Throwable th;
        CharSequence charSequence2;
        int i4;
        int i5;
        TypefaceEmojiSpan[] typefaceEmojiSpanArr;
        int spanStart;
        DatabaseDao_Impl.AnonymousClass17.checkState("Not initialized yet", getLoadState() == 1);
        UnprecomputeTextOnModificationSpannable unprecomputeTextOnModificationSpannable = null;
        if (i < 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("start cannot be negative");
            return null;
        }
        if (i2 < 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("end cannot be negative");
            return null;
        }
        if (!(i <= i2)) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("start should be <= than end");
            return null;
        }
        if (charSequence == null) {
            return null;
        }
        if (!(i <= charSequence.length())) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("start should be < than charSequence length");
            return null;
        }
        if (!(i2 <= charSequence.length())) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("end should be < than charSequence length");
            return null;
        }
        if (charSequence.length() == 0 || i == i2) {
            return charSequence;
        }
        boolean z = i3 == 1;
        EmojiProcessor emojiProcessor = this.mHelper.mProcessor;
        emojiProcessor.getClass();
        boolean z2 = charSequence instanceof SpannableBuilder;
        if (z2) {
            ((SpannableBuilder) charSequence).blockWatchers();
        }
        if (z2) {
            unprecomputeTextOnModificationSpannable = new UnprecomputeTextOnModificationSpannable((Spannable) charSequence);
            if (unprecomputeTextOnModificationSpannable != null) {
                for (TypefaceEmojiSpan typefaceEmojiSpan : typefaceEmojiSpanArr) {
                    spanStart = unprecomputeTextOnModificationSpannable.mDelegate.getSpanStart(typefaceEmojiSpan);
                    int spanEnd = unprecomputeTextOnModificationSpannable.mDelegate.getSpanEnd(typefaceEmojiSpan);
                    if (spanStart != i2) {
                        unprecomputeTextOnModificationSpannable.removeSpan(typefaceEmojiSpan);
                    }
                    i = Math.min(spanStart, i);
                    i2 = Math.max(spanEnd, i2);
                }
            }
            i4 = i;
            i5 = i2;
            if (i4 != i5) {
                charSequence2 = charSequence;
                if (!z2) {
                    return charSequence2;
                }
            } else {
                charSequence2 = charSequence;
                if (!z2) {
                    return charSequence2;
                }
            }
            ((SpannableBuilder) charSequence2).endBatchEdit();
            return charSequence2;
        }
        try {
            if (charSequence instanceof Spannable) {
                try {
                    unprecomputeTextOnModificationSpannable = new UnprecomputeTextOnModificationSpannable((Spannable) charSequence);
                } catch (Throwable th2) {
                    th = th2;
                    charSequence2 = charSequence;
                    th = th;
                    if (!z2) {
                        throw th;
                    }
                    ((SpannableBuilder) charSequence2).endBatchEdit();
                    throw th;
                }
            } else if ((charSequence instanceof Spanned) && ((Spanned) charSequence).nextSpanTransition(i - 1, i2 + 1, TypefaceEmojiSpan.class) <= i2) {
                unprecomputeTextOnModificationSpannable = new UnprecomputeTextOnModificationSpannable();
                unprecomputeTextOnModificationSpannable.mSafeToWrite = false;
                unprecomputeTextOnModificationSpannable.mDelegate = new SpannableString(charSequence);
            }
            if (unprecomputeTextOnModificationSpannable != null && (typefaceEmojiSpanArr = (TypefaceEmojiSpan[]) unprecomputeTextOnModificationSpannable.mDelegate.getSpans(i, i2, TypefaceEmojiSpan.class)) != null && typefaceEmojiSpanArr.length > 0) {
                while (i < r2) {
                    spanStart = unprecomputeTextOnModificationSpannable.mDelegate.getSpanStart(typefaceEmojiSpan);
                    int spanEnd2 = unprecomputeTextOnModificationSpannable.mDelegate.getSpanEnd(typefaceEmojiSpan);
                    if (spanStart != i2) {
                        unprecomputeTextOnModificationSpannable.removeSpan(typefaceEmojiSpan);
                    }
                    i = Math.min(spanStart, i);
                    i2 = Math.max(spanEnd2, i2);
                }
            }
            i4 = i;
            i5 = i2;
            if (i4 != i5 || i4 >= charSequence.length()) {
                charSequence2 = charSequence;
                if (!z2) {
                    return charSequence2;
                }
            } else {
                charSequence2 = charSequence;
                try {
                    UnprecomputeTextOnModificationSpannable unprecomputeTextOnModificationSpannable2 = (UnprecomputeTextOnModificationSpannable) emojiProcessor.process(charSequence2, i4, i5, Integer.MAX_VALUE, z, new WeakCache((Object) unprecomputeTextOnModificationSpannable, emojiProcessor.mSpanFactory, (byte) 15));
                    if (unprecomputeTextOnModificationSpannable2 != null) {
                        Spannable spannable = unprecomputeTextOnModificationSpannable2.mDelegate;
                        if (z2) {
                            ((SpannableBuilder) charSequence2).endBatchEdit();
                        }
                        return spannable;
                    }
                    if (!z2) {
                        return charSequence2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    th = th;
                    if (!z2) {
                        throw th;
                    }
                    ((SpannableBuilder) charSequence2).endBatchEdit();
                    throw th;
                }
            }
            ((SpannableBuilder) charSequence2).endBatchEdit();
            return charSequence2;
        } catch (Throwable th4) {
            th = th4;
            charSequence2 = charSequence;
        }
        if (!z2) {
            throw th;
        }
        ((SpannableBuilder) charSequence2).endBatchEdit();
        throw th;
    }

    public final void registerInitCallback(InitCallback initCallback) {
        this.mInitLock.writeLock().lock();
        try {
            if (this.mLoadState == 1 || this.mLoadState == 2) {
                this.mMainHandler.post(new ListenerDispatcher(Arrays.asList(initCallback), this.mLoadState, null));
            } else {
                this.mInitCallbacks.add(initCallback);
            }
        } finally {
            this.mInitLock.writeLock().unlock();
        }
    }

    public final void updateEditorInfo(EditorInfo editorInfo) {
        if (getLoadState() != 1 || editorInfo == null) {
            return;
        }
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        CompatInternal19 compatInternal19 = this.mHelper;
        compatInternal19.getClass();
        Bundle bundle = editorInfo.extras;
        MetadataList metadataList = (MetadataList) compatInternal19.mMetadataRepo.executorServiceOrNull;
        int i__offset = metadataList.__offset(4);
        bundle.putInt("android.support.text.emoji.emojiCompat_metadataVersion", i__offset != 0 ? ((ByteBuffer) metadataList.bb).getInt(i__offset + metadataList.bb_pos) : 0);
        editorInfo.extras.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", false);
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract class InitCallback {
        public abstract void onInitialized();

        public void onFailed() {
        }
    }
}
