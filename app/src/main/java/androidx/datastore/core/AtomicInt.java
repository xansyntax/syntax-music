package androidx.datastore.core;

import android.R;
import android.media.MediaCodec;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.inputmethod.InputMethodManager;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.text.platform.ImmutableBool;
import androidx.core.app.ActivityCompat$$ExternalSyntheticLambda0;
import androidx.core.provider.CallbackWrapper;
import androidx.core.view.SoftwareKeyboardControllerCompat$Impl30;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.datastore.core.AtomicInt;
import androidx.datastore.preferences.core.PreferencesKt$edit$2;
import androidx.emoji2.text.EmojiCompat;
import androidx.media3.common.util.Log;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DefaultHttpDataSource;
import androidx.media3.decoder.CryptoInfo;
import androidx.media3.exoplayer.audio.AudioRendererEventListener$EventDispatcher;
import androidx.media3.exoplayer.audio.AudioRendererEventListener$EventDispatcher$$ExternalSyntheticLambda0;
import androidx.media3.exoplayer.audio.MediaCodecAudioRenderer;
import androidx.media3.exoplayer.mediacodec.MediaCodecBufferEnqueuer;
import androidx.media3.exoplayer.text.SubtitleDecoderFactory;
import androidx.media3.extractor.text.CueDecoder;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.SettableFuture;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class AtomicInt implements DataStore, DataSource.Factory, Callback, MediaCodecBufferEnqueuer, SubtitleDecoderFactory {
    public Object delegate;

    public AtomicInt(byte b) {
        switch (b) {
            case 6:
                this.delegate = new AccessibilityNodeProvider(this) { // from class: androidx.core.view.accessibility.AccessibilityNodeProviderCompat$AccessibilityNodeProviderApi26
                    public final AtomicInt mCompat;

                    {
                        this.mCompat = this;
                    }

                    @Override // android.view.accessibility.AccessibilityNodeProvider
                    public final void addExtraDataToAccessibilityNodeInfo(int i, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
                        this.mCompat.addExtraDataToAccessibilityNodeInfo(i, new AccessibilityNodeInfoCompat(accessibilityNodeInfo), str, bundle);
                    }

                    @Override // android.view.accessibility.AccessibilityNodeProvider
                    public final AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
                        AccessibilityNodeInfoCompat accessibilityNodeInfoCompatCreateAccessibilityNodeInfo = this.mCompat.createAccessibilityNodeInfo(i);
                        if (accessibilityNodeInfoCompatCreateAccessibilityNodeInfo == null) {
                            return null;
                        }
                        return accessibilityNodeInfoCompatCreateAccessibilityNodeInfo.mInfo;
                    }

                    @Override // android.view.accessibility.AccessibilityNodeProvider
                    public final List findAccessibilityNodeInfosByText(String str, int i) {
                        return null;
                    }

                    @Override // android.view.accessibility.AccessibilityNodeProvider
                    public final AccessibilityNodeInfo findFocus(int i) {
                        AccessibilityNodeInfoCompat accessibilityNodeInfoCompatFindFocus = this.mCompat.findFocus(i);
                        if (accessibilityNodeInfoCompatFindFocus == null) {
                            return null;
                        }
                        return accessibilityNodeInfoCompatFindFocus.mInfo;
                    }

                    @Override // android.view.accessibility.AccessibilityNodeProvider
                    public final boolean performAction(int i, int i2, Bundle bundle) {
                        return this.mCompat.performAction(i, i2, bundle);
                    }
                };
                break;
            case 14:
                this.delegate = new AtomicReference(null);
                break;
            case 17:
                this.delegate = new CallbackWrapper((byte) 17);
                break;
            case 19:
                this.delegate = new HashMap();
                break;
            case 24:
                this.delegate = ImmutableList.builder();
                break;
            case 27:
                this.delegate = new CueDecoder((byte) 15);
                break;
            case 28:
                this.delegate = new CopyOnWriteArrayList();
                break;
            default:
                this.delegate = new AtomicInteger(0);
                break;
        }
    }

    public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int i) {
        return null;
    }

    @Override // androidx.media3.datasource.DataSource.Factory
    public DataSource createDataSource() {
        return new DefaultHttpDataSource((CallbackWrapper) this.delegate);
    }

    public AccessibilityNodeInfoCompat findFocus(int i) {
        return null;
    }

    @Override // androidx.datastore.core.DataStore
    public Flow getData() {
        return ((DataStore) this.delegate).getData();
    }

    public androidx.compose.runtime.State getFontLoadState() {
        EmojiCompat emojiCompat = EmojiCompat.get();
        if (emojiCompat.getLoadState() == 1) {
            return new ImmutableBool(true);
        }
        final ParcelableSnapshotMutableState parcelableSnapshotMutableStateMutableStateOf$default = Stack.mutableStateOf$default(Boolean.FALSE);
        emojiCompat.registerInitCallback(new EmojiCompat.InitCallback() { // from class: androidx.compose.ui.text.platform.DefaultImpl$getFontLoadState$initCallback$1
            @Override // androidx.emoji2.text.EmojiCompat.InitCallback
            public final void onFailed() {
                this.delegate = AndroidTextPaint_androidKt.Falsey;
            }

            @Override // androidx.emoji2.text.EmojiCompat.InitCallback
            public final void onInitialized() {
                parcelableSnapshotMutableStateMutableStateOf$default.setValue(Boolean.TRUE);
                this.delegate = new ImmutableBool(true);
            }
        });
        return parcelableSnapshotMutableStateMutableStateOf$default;
    }

    public void hide() {
        View view = (View) this.delegate;
        if (view != null) {
            ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public void onAudioSinkError(Exception exc) {
        Log.e("MediaCodecAudioRenderer", "Audio sink error", exc);
        AudioRendererEventListener$EventDispatcher audioRendererEventListener$EventDispatcher = ((MediaCodecAudioRenderer) this.delegate).eventDispatcher;
        Handler handler = audioRendererEventListener$EventDispatcher.handler;
        if (handler != null) {
            handler.post(new AudioRendererEventListener$EventDispatcher$$ExternalSyntheticLambda0(audioRendererEventListener$EventDispatcher, (Object) exc, (byte) 8));
        }
    }

    @Override // okhttp3.Callback
    public void onFailure(Call call, IOException iOException) {
        ((SettableFuture) this.delegate).setException(iOException);
    }

    @Override // okhttp3.Callback
    public void onResponse(Call call, Response response) {
        ((SettableFuture) this.delegate).set(response);
    }

    public boolean performAction(int i, int i2, Bundle bundle) {
        return false;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecBufferEnqueuer
    public void queueInputBuffer(int i, int i2, int i3, long j) {
        ((MediaCodec) this.delegate).queueInputBuffer(i, 0, i2, j, i3);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecBufferEnqueuer
    public void queueSecureInputBuffer(int i, CryptoInfo cryptoInfo, long j, int i2) {
        ((MediaCodec) this.delegate).queueSecureInputBuffer(i, 0, cryptoInfo.frameworkCryptoInfo, j, i2);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecBufferEnqueuer
    public void setParameters(Bundle bundle) {
        ((MediaCodec) this.delegate).setParameters(bundle);
    }

    public void show() {
        View viewFindViewById;
        View view = (View) this.delegate;
        if (view == null) {
            return;
        }
        if (view.isInEditMode() || view.onCheckIsTextEditor()) {
            view.requestFocus();
            viewFindViewById = view;
        } else {
            viewFindViewById = view.getRootView().findFocus();
        }
        if (viewFindViewById == null) {
            viewFindViewById = view.getRootView().findViewById(R.id.content);
        }
        if (viewFindViewById == null || !viewFindViewById.hasWindowFocus()) {
            return;
        }
        viewFindViewById.post(new ActivityCompat$$ExternalSyntheticLambda0((byte) 9, (Object) viewFindViewById));
    }

    @Override // androidx.datastore.core.DataStore
    public Object updateData(Function2 function2, ContinuationImpl continuationImpl) {
        return ((DataStore) this.delegate).updateData(new PreferencesKt$edit$2(function2, null, (byte) 1), continuationImpl);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecBufferEnqueuer
    public void flush() {
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecBufferEnqueuer
    public void maybeThrowException() {
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecBufferEnqueuer
    public void shutdown() {
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecBufferEnqueuer
    public void start() {
    }

    public /* synthetic */ AtomicInt(Object obj) {
        this.delegate = obj;
    }

    public AtomicInt(View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            SoftwareKeyboardControllerCompat$Impl30 softwareKeyboardControllerCompat$Impl30 = new SoftwareKeyboardControllerCompat$Impl30(view);
            softwareKeyboardControllerCompat$Impl30.mView = view;
            this.delegate = softwareKeyboardControllerCompat$Impl30;
            return;
        }
        this.delegate = new AtomicInt((Object) view);
    }

    public void addExtraDataToAccessibilityNodeInfo(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, String str, Bundle bundle) {
    }
}
