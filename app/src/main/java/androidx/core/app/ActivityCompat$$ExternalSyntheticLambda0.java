package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.os.Trace;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.ActionMode;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import androidx.collection.MutableIntObjectMap;
import androidx.compose.foundation.text.contextmenu.internal.AndroidTextContextMenuToolbarProvider;
import androidx.compose.material3.ripple.RippleHostView;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.contentcapture.AndroidContentCaptureManager;
import androidx.compose.ui.contentcapture.ContentCaptureEvent;
import androidx.compose.ui.contentcapture.ContentCaptureEventType;
import androidx.compose.ui.node.RulerTrackingMap;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat;
import androidx.compose.ui.text.input.TextInputServiceAndroid;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.os.HandlerCompat$Api28Impl;
import androidx.core.os.TraceCompat;
import androidx.core.provider.FontsContractCompat$FontInfo;
import androidx.core.view.insets.SystemBarStateMonitor;
import androidx.datastore.core.AtomicInt;
import androidx.emoji2.text.EmojiProcessor;
import androidx.emoji2.text.FontRequestEmojiCompatConfig;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ProcessLifecycleOwner;
import androidx.media3.common.audio.AudioBecomingNoisyManager$AudioBecomingNoisyReceiver;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.NetworkTypeObserver;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.ExoPlayerImpl;
import androidx.media3.exoplayer.ExoPlayerImplInternal;
import androidx.media3.exoplayer.PlayerMessage;
import androidx.media3.exoplayer.StreamVolumeManager$StreamVolumeState;
import androidx.media3.exoplayer.analytics.DefaultAnalyticsCollector;
import androidx.media3.exoplayer.analytics.DefaultAnalyticsCollector$$ExternalSyntheticLambda0;
import androidx.media3.exoplayer.analytics.DefaultAnalyticsCollector$$ExternalSyntheticLambda4;
import androidx.media3.exoplayer.audio.AudioCapabilitiesReceiver;
import androidx.media3.exoplayer.audio.DefaultAudioSink;
import androidx.media3.exoplayer.audio.MediaCodecAudioRenderer;
import androidx.media3.exoplayer.drm.DefaultDrmSession;
import androidx.media3.exoplayer.drm.DefaultDrmSessionManager;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.drm.FrameworkMediaDrm$$ExternalSyntheticLambda0;
import androidx.media3.exoplayer.mediacodec.AsynchronousMediaCodecCallback;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import androidx.media3.exoplayer.upstream.DefaultBandwidthMeter;
import androidx.media3.exoplayer.upstream.DefaultBandwidthMeter$$ExternalSyntheticLambda0;
import androidx.media3.exoplayer.upstream.SlidingPercentile;
import androidx.media3.exoplayer.video.DefaultVideoSink;
import androidx.media3.exoplayer.video.PlaybackVideoGraphWrapper;
import coil3.size.SizeKt;
import coil3.util.LifecyclesKt;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.math.IntMath;
import com.metrolist.music.db.DatabaseDao_Impl;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.lang.reflect.Method;
import java.nio.MappedByteBuffer;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import okhttp3.ConnectionSpec;
import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ActivityCompat$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ ActivityCompat$$ExternalSyntheticLambda0(ExoPlayerImplInternal exoPlayerImplInternal, int i) {
        this.$r8$classId = (byte) 16;
        this.f$0 = exoPlayerImplInternal;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x005c A[Catch: all -> 0x0021, TryCatch #0 {, blocks: (B:6:0x0017, B:8:0x001b, B:15:0x0027, B:19:0x002d, B:25:0x0039, B:27:0x003d, B:29:0x0043, B:31:0x004d, B:33:0x0057, B:35:0x0068, B:34:0x005c, B:36:0x006a, B:38:0x007e, B:40:0x0086), top: B:48:0x0017 }] */
    private final void run$androidx$media3$common$util$NetworkTypeObserver$ListenerHolder$$ExternalSyntheticLambda0() {
        String upperCase;
        TelephonyManager telephonyManager;
        NetworkTypeObserver.ListenerHolder listenerHolder = (NetworkTypeObserver.ListenerHolder) this.f$0;
        DefaultBandwidthMeter$$ExternalSyntheticLambda0 defaultBandwidthMeter$$ExternalSyntheticLambda0 = (DefaultBandwidthMeter$$ExternalSyntheticLambda0) listenerHolder.listener.get();
        if (defaultBandwidthMeter$$ExternalSyntheticLambda0 != null) {
            int networkType = NetworkTypeObserver.this.getNetworkType();
            DefaultBandwidthMeter defaultBandwidthMeter = defaultBandwidthMeter$$ExternalSyntheticLambda0.f$0;
            synchronized (defaultBandwidthMeter) {
                int i = defaultBandwidthMeter.networkType;
                if (i == 0 || defaultBandwidthMeter.resetOnNetworkTypeChange) {
                    if (i != networkType || defaultBandwidthMeter.countryCode == null) {
                        defaultBandwidthMeter.networkType = networkType;
                        if (networkType != 1 && networkType != 0 && networkType != 8) {
                            if (defaultBandwidthMeter.countryCode == null) {
                                Context context = defaultBandwidthMeter.context;
                                String str = Util.DEVICE_DEBUG_INFO;
                                if (context == null || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null) {
                                    upperCase = LifecyclesKt.toUpperCase(Locale.getDefault().getCountry());
                                } else {
                                    String networkCountryIso = telephonyManager.getNetworkCountryIso();
                                    if (TextUtils.isEmpty(networkCountryIso)) {
                                        upperCase = LifecyclesKt.toUpperCase(Locale.getDefault().getCountry());
                                    } else {
                                        upperCase = LifecyclesKt.toUpperCase(networkCountryIso);
                                    }
                                }
                                defaultBandwidthMeter.countryCode = upperCase;
                            }
                            defaultBandwidthMeter.bitrateEstimate = defaultBandwidthMeter.getInitialBitrateEstimateForNetworkType(networkType);
                            defaultBandwidthMeter.clock.getClass();
                            long jElapsedRealtime = SystemClock.elapsedRealtime();
                            defaultBandwidthMeter.maybeNotifyBandwidthSample(defaultBandwidthMeter.streamCount > 0 ? (int) (jElapsedRealtime - defaultBandwidthMeter.sampleStartTimeMs) : 0, defaultBandwidthMeter.sampleBytesTransferred, defaultBandwidthMeter.bitrateEstimate);
                            defaultBandwidthMeter.sampleStartTimeMs = jElapsedRealtime;
                            defaultBandwidthMeter.sampleBytesTransferred = 0L;
                            defaultBandwidthMeter.totalBytesTransferred = 0L;
                            defaultBandwidthMeter.totalElapsedTimeMs = 0L;
                            SlidingPercentile slidingPercentile = defaultBandwidthMeter.slidingPercentile;
                            slidingPercentile.samples.clear();
                            slidingPercentile.currentSortOrder = -1;
                            slidingPercentile.nextSampleIndex = 0;
                            slidingPercentile.totalWeight = 0;
                        }
                    }
                }
            }
        }
    }

    private final void run$androidx$media3$exoplayer$mediacodec$AsynchronousMediaCodecCallback$$ExternalSyntheticLambda0() {
        AsynchronousMediaCodecCallback asynchronousMediaCodecCallback = (AsynchronousMediaCodecCallback) this.f$0;
        synchronized (asynchronousMediaCodecCallback.lock) {
            try {
                if (asynchronousMediaCodecCallback.shutDown) {
                    return;
                }
                long j = asynchronousMediaCodecCallback.pendingFlushCount - 1;
                asynchronousMediaCodecCallback.pendingFlushCount = j;
                if (j > 0) {
                    return;
                }
                if (j >= 0) {
                    asynchronousMediaCodecCallback.flushInternal();
                    return;
                }
                IllegalStateException illegalStateException = new IllegalStateException();
                synchronized (asynchronousMediaCodecCallback.lock) {
                    asynchronousMediaCodecCallback.internalException = illegalStateException;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:220:0x03c8  */
    /* JADX WARN: Code duplicated, block: B:223:0x03d2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:224:0x03d4 A[Catch: all -> 0x0403, LOOP:1: B:211:0x0379->B:224:0x03d4, LOOP_END, TryCatch #2 {all -> 0x0403, blocks: (B:208:0x036b, B:211:0x0379, B:213:0x0389, B:215:0x0395, B:217:0x039e, B:219:0x03ad, B:221:0x03ca, B:224:0x03d4, B:225:0x03d8, B:227:0x03ea, B:231:0x03ff, B:232:0x0402, B:226:0x03dd), top: B:293:0x036b, inners: #15 }] */
    /* JADX WARN: Code duplicated, block: B:322:0x03d8 A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v30 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v5 */
    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        ?? r4;
        ?? r3;
        View viewFindFocus;
        Boolean bool = null;
        byte b = 3;
        byte b2 = 2;
        boolean z = true;
        int i = 0;
        switch (this.$r8$classId) {
            case 0:
                Activity activity = (Activity) this.f$0;
                if (activity.isFinishing()) {
                    return;
                }
                Handler handler = ActivityRecreator.mainHandler;
                Method method = ActivityRecreator.requestRelaunchActivityMethod;
                Application application = Build.VERSION.SDK_INT;
                if (application >= 28) {
                    activity.recreate();
                    return;
                }
                ActivityRecreator.LifecycleCheckCallbacks lifecycleCheckCallbacks = 27;
                if (((application != 26 && application != 27) || method != null) && (ActivityRecreator.performStopActivity2ParamsMethod != null || ActivityRecreator.performStopActivity3ParamsMethod != null)) {
                    try {
                        Object obj2 = ActivityRecreator.tokenField.get(activity);
                        if (obj2 != null && (obj = ActivityRecreator.mainThreadField.get(activity)) != null) {
                            application = activity.getApplication();
                            lifecycleCheckCallbacks = new ActivityRecreator.LifecycleCheckCallbacks(activity);
                            application.registerActivityLifecycleCallbacks(lifecycleCheckCallbacks);
                            handler.post(new ActivityRecreator.AnonymousClass1(lifecycleCheckCallbacks, obj2, (byte) 0));
                            if (application != 26 && application != 27) {
                                z = false;
                            }
                            try {
                                if (z) {
                                    try {
                                        Boolean bool2 = Boolean.FALSE;
                                        method.invoke(obj, obj2, null, null, 0, bool2, null, null, bool2, bool2);
                                    } catch (Throwable th) {
                                        th = th;
                                        r3 = application;
                                        r4 = lifecycleCheckCallbacks;
                                        handler.post(new ActivityRecreator.AnonymousClass1(r3, false, r4, b2));
                                        throw th;
                                    }
                                } else {
                                    activity.recreate();
                                }
                                handler.post(new ActivityRecreator.AnonymousClass1(application, false, lifecycleCheckCallbacks, b2));
                                return;
                            } catch (Throwable th2) {
                                th = th2;
                                r3 = application;
                                r4 = lifecycleCheckCallbacks;
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
                activity.recreate();
                return;
            case 1:
                androidx.activity.ComponentActivity.ReportFullyDrawnExecutorImpl reportFullyDrawnExecutorImpl = (androidx.activity.ComponentActivity.ReportFullyDrawnExecutorImpl) this.f$0;
                Runnable runnable = reportFullyDrawnExecutorImpl.currentRunnable;
                if (runnable != null) {
                    runnable.run();
                    reportFullyDrawnExecutorImpl.currentRunnable = null;
                    return;
                }
                return;
            case 2:
                super/*android.app.Dialog*/.onBackPressed();
                return;
            case 3:
                ActionMode actionMode = ((AndroidTextContextMenuToolbarProvider) this.f$0).actionMode;
                if (actionMode != null) {
                    actionMode.finish();
                    return;
                }
                return;
            case 4:
                RippleHostView.setRippleState$lambda$1((RippleHostView) this.f$0);
                return;
            case 5:
                AndroidContentCaptureManager androidContentCaptureManager = (AndroidContentCaptureManager) this.f$0;
                boolean zIsEnabled$ui = androidContentCaptureManager.isEnabled$ui();
                AndroidComposeView androidComposeView = androidContentCaptureManager.view;
                if (zIsEnabled$ui) {
                    if (!androidComposeView.isAttachedToWindow()) {
                        androidContentCaptureManager.checkingForSemanticsChanges = false;
                        return;
                    }
                    Trace.beginSection("ContentCapture:changeChecker");
                    try {
                        androidComposeView.measureAndLayout(true);
                        MutableIntObjectMap mutableIntObjectMap = androidContentCaptureManager.previousSemanticsNodes;
                        int[] iArr = mutableIntObjectMap.keys;
                        long[] jArr = mutableIntObjectMap.metadata;
                        int length = jArr.length - 2;
                        if (length >= 0) {
                            int i2 = 0;
                            while (true) {
                                long j = jArr[i2];
                                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                                    int i3 = 8 - ((~(i2 - length)) >>> 31);
                                    for (int i4 = i; i4 < i3; i4++) {
                                        if ((255 & j) < 128) {
                                            int i5 = iArr[(i2 << 3) + i4];
                                            if (!androidContentCaptureManager.getCurrentSemanticsNodes$ui().containsKey(i5)) {
                                                androidContentCaptureManager.bufferedEvents.add(new ContentCaptureEvent(i5, androidContentCaptureManager.currentSemanticsNodesSnapshotTimestampMillis, ContentCaptureEventType.VIEW_DISAPPEAR, null));
                                                androidContentCaptureManager.boundsUpdateChannel.mo1712trySendJP2dKIU(Unit.INSTANCE);
                                            }
                                        }
                                        j >>= 8;
                                    }
                                    if (i3 == 8) {
                                        if (i2 != length) {
                                            i2++;
                                            i = 0;
                                        }
                                    }
                                } else if (i2 != length) {
                                    i2++;
                                    i = 0;
                                }
                            }
                        }
                        Trace.beginSection("ContentCapture:sendAppearEvents");
                        try {
                            androidContentCaptureManager.sendContentCaptureAppearEvents(androidComposeView.getSemanticsOwner().getUnmergedRootSemanticsNode(), androidContentCaptureManager.previousSemanticsRoot);
                            Trace.endSection();
                            androidContentCaptureManager.checkForContentCapturePropertyChanges(androidContentCaptureManager.getCurrentSemanticsNodes$ui());
                            androidContentCaptureManager.updateSemanticsCopy();
                            androidContentCaptureManager.checkingForSemanticsChanges = false;
                            return;
                        } finally {
                            Trace.endSection();
                        }
                    } catch (Throwable th3) {
                        Trace.endSection();
                        throw th3;
                    }
                }
                return;
            case 6:
                ((AbstractComposeView) this.f$0).attachedToWindow();
                return;
            case 7:
                AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = (AndroidComposeViewAccessibilityDelegateCompat) this.f$0;
                AndroidComposeView androidComposeView2 = androidComposeViewAccessibilityDelegateCompat.view;
                if (!androidComposeView2.isAttachedToWindow()) {
                    androidComposeViewAccessibilityDelegateCompat.checkingForSemanticsChanges = false;
                    return;
                }
                Trace.beginSection("Compose:semantics:measureAndLayout");
                try {
                    androidComposeView2.measureAndLayout(true);
                    Trace.endSection();
                    Trace.beginSection("Compose:semantics:checkForSemanticsChanges");
                    try {
                        androidComposeViewAccessibilityDelegateCompat.checkForSemanticsChanges();
                        Trace.endSection();
                        androidComposeViewAccessibilityDelegateCompat.checkingForSemanticsChanges = false;
                        return;
                    } catch (Throwable th4) {
                        Trace.endSection();
                        throw th4;
                    }
                } catch (Throwable th5) {
                    Trace.endSection();
                    throw th5;
                }
            case 8:
                TextInputServiceAndroid textInputServiceAndroid = (TextInputServiceAndroid) this.f$0;
                EmojiProcessor emojiProcessor = textInputServiceAndroid.inputMethodManager;
                textInputServiceAndroid.frameCallback = null;
                MutableVector mutableVector = textInputServiceAndroid.textInputCommandQueue;
                View view = textInputServiceAndroid.view;
                if (!view.isFocused() && (viewFindFocus = view.getRootView().findFocus()) != null && viewFindFocus.onCheckIsTextEditor()) {
                    mutableVector.clear();
                    return;
                }
                Object[] objArr = mutableVector.content;
                int i6 = mutableVector.size;
                Boolean boolValueOf = null;
                for (int i7 = 0; i7 < i6; i7++) {
                    TextInputServiceAndroid.TextInputCommand textInputCommand = (TextInputServiceAndroid.TextInputCommand) objArr[i7];
                    int iOrdinal = textInputCommand.ordinal();
                    if (iOrdinal != 0) {
                        if (iOrdinal == 1) {
                            bool = Boolean.FALSE;
                        } else if (iOrdinal != 2 && iOrdinal != 3) {
                            PathKt$$ExternalSyntheticBUOutline0.m$1();
                            return;
                        } else if (!Intrinsics.areEqual(bool, Boolean.FALSE)) {
                            boolValueOf = Boolean.valueOf(textInputCommand == TextInputServiceAndroid.TextInputCommand.ShowKeyboard);
                        }
                    } else {
                        bool = Boolean.TRUE;
                    }
                    boolValueOf = bool;
                }
                mutableVector.clear();
                if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                    ((InputMethodManager) ((Lazy) emojiProcessor.mMetadataRepo).getValue()).restartInput((View) emojiProcessor.mSpanFactory);
                }
                if (boolValueOf != null) {
                    if (boolValueOf.booleanValue()) {
                        ((AtomicInt) ((AtomicInt) emojiProcessor.mGlyphChecker).delegate).show();
                    } else {
                        ((AtomicInt) ((AtomicInt) emojiProcessor.mGlyphChecker).delegate).hide();
                    }
                }
                if (Intrinsics.areEqual(bool, Boolean.FALSE)) {
                    ((InputMethodManager) ((Lazy) emojiProcessor.mMetadataRepo).getValue()).restartInput((View) emojiProcessor.mSpanFactory);
                    return;
                }
                return;
            case 9:
                View view2 = (View) this.f$0;
                ((InputMethodManager) view2.getContext().getSystemService("input_method")).showSoftInput(view2, 0);
                return;
            case 10:
                SystemBarStateMonitor.AnonymousClass1 anonymousClass1 = ((SystemBarStateMonitor) this.f$0).mDetector;
                ViewParent parent = anonymousClass1.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(anonymousClass1);
                    return;
                }
                return;
            case 11:
                FontRequestEmojiCompatConfig.FontRequestMetadataLoader fontRequestMetadataLoader = (FontRequestEmojiCompatConfig.FontRequestMetadataLoader) this.f$0;
                synchronized (fontRequestMetadataLoader.mLock) {
                    try {
                        if (fontRequestMetadataLoader.mCallback == null) {
                            return;
                        }
                        try {
                            FontsContractCompat$FontInfo fontsContractCompat$FontInfoRetrieveFontInfo = fontRequestMetadataLoader.retrieveFontInfo();
                            int i8 = fontsContractCompat$FontInfoRetrieveFontInfo.mResultCode;
                            if (i8 == 2) {
                                synchronized (fontRequestMetadataLoader.mLock) {
                                }
                            }
                            if (i8 != 0) {
                                throw new RuntimeException("fetchFonts result is not OK. (" + i8 + ")");
                            }
                            try {
                                int i9 = TraceCompat.$r8$clinit;
                                Trace.beginSection("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
                                Context context = fontRequestMetadataLoader.mContext;
                                FontsContractCompat$FontInfo[] fontsContractCompat$FontInfoArr = {fontsContractCompat$FontInfoRetrieveFontInfo};
                                SizeKt sizeKt = TypefaceCompat.sTypefaceCompatImpl;
                                Trace.beginSection(DatabaseDao_Impl.AnonymousClass17.truncatedTraceSectionLabel("TypefaceCompat.createFromFontInfo"));
                                try {
                                    Typeface typefaceCreateFromFontInfo = TypefaceCompat.sTypefaceCompatImpl.createFromFontInfo(context, fontsContractCompat$FontInfoArr, 0);
                                    Trace.endSection();
                                    MappedByteBuffer mappedByteBufferMmap = IntMath.mmap(fontRequestMetadataLoader.mContext, fontsContractCompat$FontInfoRetrieveFontInfo.mUri);
                                    if (mappedByteBufferMmap == null || typefaceCreateFromFontInfo == null) {
                                        throw new RuntimeException("Unable to open file.");
                                    }
                                    try {
                                        Trace.beginSection("EmojiCompat.MetadataRepo.create");
                                        Dispatcher dispatcher = new Dispatcher(typefaceCreateFromFontInfo, MathKt.read(mappedByteBufferMmap));
                                        Trace.endSection();
                                        Trace.endSection();
                                        synchronized (fontRequestMetadataLoader.mLock) {
                                            try {
                                                SizeKt sizeKt2 = fontRequestMetadataLoader.mCallback;
                                                if (sizeKt2 != null) {
                                                    sizeKt2.onLoaded(dispatcher);
                                                }
                                            } catch (Throwable th6) {
                                                throw th6;
                                            }
                                            break;
                                        }
                                        fontRequestMetadataLoader.cleanUp();
                                        return;
                                    } catch (Throwable th7) {
                                        int i10 = TraceCompat.$r8$clinit;
                                        Trace.endSection();
                                        throw th7;
                                    }
                                } catch (Throwable th8) {
                                    Trace.endSection();
                                    throw th8;
                                }
                            } catch (Throwable th9) {
                                int i11 = TraceCompat.$r8$clinit;
                                Trace.endSection();
                                throw th9;
                            }
                            break;
                        } catch (Throwable th10) {
                            synchronized (fontRequestMetadataLoader.mLock) {
                                try {
                                    SizeKt sizeKt3 = fontRequestMetadataLoader.mCallback;
                                    if (sizeKt3 != null) {
                                        sizeKt3.onFailed(th10);
                                    }
                                    fontRequestMetadataLoader.cleanUp();
                                    return;
                                } catch (Throwable th11) {
                                    throw th11;
                                }
                            }
                        }
                    } catch (Throwable th12) {
                        throw th12;
                    }
                }
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                ProcessLifecycleOwner processLifecycleOwner = (ProcessLifecycleOwner) this.f$0;
                LifecycleRegistry lifecycleRegistry = processLifecycleOwner.registry;
                if (processLifecycleOwner.resumedCounter == 0) {
                    processLifecycleOwner.pauseSent = true;
                    lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
                }
                if (processLifecycleOwner.startedCounter == 0 && processLifecycleOwner.pauseSent) {
                    lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
                    processLifecycleOwner.stopSent = true;
                    return;
                }
                return;
            case 13:
                AudioBecomingNoisyManager$AudioBecomingNoisyReceiver audioBecomingNoisyManager$AudioBecomingNoisyReceiver = (AudioBecomingNoisyManager$AudioBecomingNoisyReceiver) this.f$0;
                if (audioBecomingNoisyManager$AudioBecomingNoisyReceiver.this$0._isOpen) {
                    ExoPlayerImpl.this.updatePlayWhenReady(3, false);
                    return;
                }
                return;
            case 14:
                run$androidx$media3$common$util$NetworkTypeObserver$ListenerHolder$$ExternalSyntheticLambda0();
                return;
            case 15:
                ExoPlayerImpl exoPlayerImpl = (ExoPlayerImpl) this.f$0;
                RulerTrackingMap rulerTrackingMap = exoPlayerImpl.audioSessionIdState;
                Context context2 = exoPlayerImpl.applicationContext;
                String str = Util.DEVICE_DEBUG_INFO;
                int iGenerateAudioSessionId = HandlerCompat$Api28Impl.getAudioManager(context2).generateAudioSessionId();
                i = iGenerateAudioSessionId != -1 ? iGenerateAudioSessionId : 0;
                if (((Integer) rulerTrackingMap.get()).intValue() != i) {
                    rulerTrackingMap.setStateInBackground(Integer.valueOf(i));
                    exoPlayerImpl.sendRendererMessage(1, 10, Integer.valueOf(i));
                    exoPlayerImpl.sendRendererMessage(2, 10, Integer.valueOf(i));
                    return;
                }
                return;
            case 16:
                DefaultAnalyticsCollector defaultAnalyticsCollector = ((ExoPlayerImplInternal) this.f$0).analyticsCollector;
                defaultAnalyticsCollector.sendEvent(defaultAnalyticsCollector.generateCurrentPlayerMediaPeriodEventTime(), 1034, new DefaultAnalyticsCollector$$ExternalSyntheticLambda0((byte) 20));
                return;
            case 17:
                try {
                    ExoPlayerImplInternal.deliverMessage((PlayerMessage) this.f$0);
                    return;
                } catch (ExoPlaybackException e) {
                    Log.e("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", e);
                    throw new RuntimeException(e);
                }
            case 18:
                RulerTrackingMap rulerTrackingMap2 = (RulerTrackingMap) ((NetworkTypeObserver.Receiver) this.f$0).this$0;
                NetworkTypeObserver.Receiver receiver = (NetworkTypeObserver.Receiver) rulerTrackingMap2.newRulers;
                RulerTrackingMap rulerTrackingMap3 = (RulerTrackingMap) rulerTrackingMap2.accessFlags;
                if (receiver == null) {
                    return;
                }
                rulerTrackingMap3.setStateInBackground(rulerTrackingMap2.generateState(((StreamVolumeManager$StreamVolumeState) rulerTrackingMap3.get()).streamType));
                return;
            case 19:
                DefaultAnalyticsCollector defaultAnalyticsCollector2 = (DefaultAnalyticsCollector) this.f$0;
                defaultAnalyticsCollector2.sendEvent(defaultAnalyticsCollector2.generateCurrentPlayerMediaPeriodEventTime(), 1028, new DefaultAnalyticsCollector$$ExternalSyntheticLambda4((byte) 5));
                defaultAnalyticsCollector2.listeners.release();
                return;
            case 20:
                ((AudioCapabilitiesReceiver) this.f$0).updateCurrentAudioCapabilities();
                return;
            case 21:
                ListenerSet listenerSet = (ListenerSet) this.f$0;
                listenerSet.getClass();
                if (Thread.currentThread() == listenerSet.thread) {
                    listenerSet.sendEvent(-1, new FrameworkMediaDrm$$ExternalSyntheticLambda0(b));
                    return;
                }
                return;
            case 22:
                DefaultAudioSink defaultAudioSink = (DefaultAudioSink) this.f$0;
                if (defaultAudioSink.accumulatedSkippedSilenceDurationUs >= 300000) {
                    ((MediaCodecAudioRenderer) defaultAudioSink.listener.delegate).hasPendingReportedSkippedSilence = true;
                    defaultAudioSink.accumulatedSkippedSilenceDurationUs = 0L;
                    return;
                }
                return;
            case 23:
                DefaultDrmSessionManager.PreacquiredSessionReference preacquiredSessionReference = (DefaultDrmSessionManager.PreacquiredSessionReference) this.f$0;
                if (preacquiredSessionReference.isReleased) {
                    return;
                }
                DrmSession drmSession = preacquiredSessionReference.session;
                if (drmSession != null) {
                    drmSession.release(preacquiredSessionReference.eventDispatcher);
                }
                DefaultDrmSessionManager.this.preacquiredSessionReferences.remove(preacquiredSessionReference);
                preacquiredSessionReference.isReleased = true;
                return;
            case 24:
                ((DefaultDrmSession) this.f$0).release(null);
                return;
            case 25:
                run$androidx$media3$exoplayer$mediacodec$AsynchronousMediaCodecCallback$$ExternalSyntheticLambda0();
                return;
            case 26:
                ((ConnectionSpec.Builder) this.f$0).update();
                return;
            case 27:
                ((DefaultTrackSelector) this.f$0).maybeInvalidateForAudioChannelCountConstraints();
                return;
            case 28:
                ((DefaultVideoSink) this.f$0).listener.onFrameAvailableForRendering();
                return;
            default:
                ((PlaybackVideoGraphWrapper) this.f$0).pendingFlushCount--;
                return;
        }
    }

    public /* synthetic */ ActivityCompat$$ExternalSyntheticLambda0(byte b, Object obj) {
        this.$r8$classId = b;
        this.f$0 = obj;
    }

    public /* synthetic */ ActivityCompat$$ExternalSyntheticLambda0(ExoPlayerImplInternal exoPlayerImplInternal, PlayerMessage playerMessage) {
        this.$r8$classId = (byte) 17;
        this.f$0 = playerMessage;
    }
}
