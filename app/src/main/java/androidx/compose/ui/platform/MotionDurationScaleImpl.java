package androidx.compose.ui.platform;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Looper;
import android.provider.Settings;
import androidx.collection.MutableScatterMap;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.material3.SliderState;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.ui.MotionDurationScale;
import androidx.sqlite.SQLite;
import com.yalantis.ucrop.view.CropImageView;
import dagger.hilt.EntryPoints;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.flow.SafeFlow;
import kotlinx.coroutines.flow.StartedWhileSubscribed;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.internal.ContextScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MotionDurationScaleImpl implements MotionDurationScale {
    public final ParcelableSnapshotMutableFloatState _scaleFactor$delegate = new ParcelableSnapshotMutableFloatState(1.0f);
    public final Context applicationContext;
    public ContextScope coroutineScope;
    public StandaloneCoroutine job;

    public MotionDurationScaleImpl(Context context) {
        this.applicationContext = context;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final Object fold(Object obj, Function2 function2) {
        return function2.invoke(obj, this);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext.Element get(CoroutineContext.Key key) {
        return StringsKt__IndentKt.get(this, key);
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [androidx.compose.ui.platform.WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1] */
    @Override // androidx.compose.ui.MotionDurationScale
    public final float getScaleFactor() {
        Continuation continuation;
        StateFlow stateFlow;
        if (this.job == null) {
            Context context = this.applicationContext;
            MutableScatterMap mutableScatterMap = WindowRecomposer_androidKt.animationScale;
            synchronized (mutableScatterMap) {
                try {
                    Object objStateIn = mutableScatterMap.get(context);
                    continuation = null;
                    if (objStateIn == null) {
                        ContentResolver contentResolver = context.getContentResolver();
                        Uri uriFor = Settings.Global.getUriFor("animator_duration_scale");
                        final BufferedChannel bufferedChannelChannel$default = EntryPoints.Channel$default(-1, 6, null);
                        objStateIn = StateFlowKt.stateIn(new SafeFlow((byte) 0, new MutatorMutex.AnonymousClass2(contentResolver, uriFor, (WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1) new ContentObserver(SQLite.createAsync(Looper.getMainLooper())) { // from class: androidx.compose.ui.platform.WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1
                            @Override // android.database.ContentObserver
                            public final void onChange(boolean z, Uri uri) {
                                bufferedChannelChannel$default.mo1712trySendJP2dKIU(Unit.INSTANCE);
                            }
                        }, bufferedChannelChannel$default, context, (Continuation) null)), AwaitKt.MainScope(), new StartedWhileSubscribed(0L, Long.MAX_VALUE), Float.valueOf(Settings.Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f)));
                        mutableScatterMap.set(context, objStateIn);
                    }
                    stateFlow = (StateFlow) objStateIn;
                } catch (Throwable th) {
                    throw th;
                }
            }
            this._scaleFactor$delegate.setFloatValue(((Number) stateFlow.getValue()).floatValue());
            ContextScope contextScope = this.coroutineScope;
            if (contextScope == null) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("MotionDurationScale scale factor requested before recomposer loop start");
                return CropImageView.DEFAULT_ASPECT_RATIO;
            }
            this.job = AwaitKt.launch$default(contextScope, null, null, new SliderState.AnonymousClass2(stateFlow, this, continuation, (byte) 26), 3);
        }
        return this._scaleFactor$delegate.getFloatValue();
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext minusKey(CoroutineContext.Key key) {
        return StringsKt__IndentKt.minusKey(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext plus(CoroutineContext coroutineContext) {
        return StringsKt__IndentKt.plus(this, coroutineContext);
    }
}
