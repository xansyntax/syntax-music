package androidx.compose.foundation.text.selection;

import android.view.textclassifier.TextClassifier;
import androidx.compose.material3.SliderState;
import com.metrolist.music.utils.SyncUtils;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.time.Duration;
import kotlin.time.DurationUnit;
import kotlin.time.InstantKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PlatformSelectionBehaviorsImpl$requireTextClassificationSession$2 extends SuspendLambda implements Function2 {
    public final /* synthetic */ Function2 $block;
    public Mutex L$0;
    public PlatformSelectionBehaviorsImpl L$1;
    public byte label;
    public final /* synthetic */ PlatformSelectionBehaviorsImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlatformSelectionBehaviorsImpl$requireTextClassificationSession$2(PlatformSelectionBehaviorsImpl platformSelectionBehaviorsImpl, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.this$0 = platformSelectionBehaviorsImpl;
        this.$block = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new PlatformSelectionBehaviorsImpl$requireTextClassificationSession$2(this.this$0, this.$block, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((PlatformSelectionBehaviorsImpl$requireTextClassificationSession$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0092 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        PlatformSelectionBehaviorsImpl platformSelectionBehaviorsImpl;
        Mutex mutex;
        Mutex mutex2;
        TextClassifier textClassifier;
        Object objM1899withTimeoutOrNullKLykuaI;
        byte b = this.label;
        DurationUnit durationUnit = DurationUnit.MILLISECONDS;
        byte b2 = 1;
        Continuation continuation = null;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (b == 0) {
                ResultKt.throwOnFailure(obj);
                platformSelectionBehaviorsImpl = this.this$0;
                mutex = platformSelectionBehaviorsImpl.mutex;
                this.L$0 = mutex;
                this.L$1 = platformSelectionBehaviorsImpl;
                this.label = (byte) 1;
                if (mutex.lock(this) != coroutineSingletons) {
                }
                return coroutineSingletons;
            }
            if (b != 1) {
                if (b != 2) {
                    if (b == 3) {
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                mutex2 = this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    textClassifier = (TextClassifier) obj;
                    mutex = mutex2;
                    mutex.unlock(null);
                    Path.Companion companion = Duration.Companion;
                    long duration = InstantKt.toDuration(200L, durationUnit);
                    SliderState.AnonymousClass2 anonymousClass2 = new SliderState.AnonymousClass2(textClassifier, this.$block, continuation, (byte) 13);
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = (byte) 3;
                    objM1899withTimeoutOrNullKLykuaI = AwaitKt.m1899withTimeoutOrNullKLykuaI(duration, anonymousClass2, this);
                    if (objM1899withTimeoutOrNullKLykuaI == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    return objM1899withTimeoutOrNullKLykuaI;
                } catch (Throwable th) {
                    th = th;
                    mutex2.unlock(null);
                    throw th;
                }
            }
            platformSelectionBehaviorsImpl = this.L$1;
            Mutex mutex3 = this.L$0;
            ResultKt.throwOnFailure(obj);
            mutex = mutex3;
            textClassifier = platformSelectionBehaviorsImpl.textClassificationSession;
            if (textClassifier == null || textClassifier.isDestroyed()) {
                Path.Companion companion2 = Duration.Companion;
                long duration2 = InstantKt.toDuration(300L, durationUnit);
                SyncUtils.AnonymousClass3 anonymousClass3 = new SyncUtils.AnonymousClass3(platformSelectionBehaviorsImpl, continuation, b2);
                this.L$0 = mutex;
                this.L$1 = null;
                this.label = (byte) 2;
                Object objM1899withTimeoutOrNullKLykuaI2 = AwaitKt.m1899withTimeoutOrNullKLykuaI(duration2, anonymousClass3, this);
                if (objM1899withTimeoutOrNullKLykuaI2 != coroutineSingletons) {
                    mutex2 = mutex;
                    obj = objM1899withTimeoutOrNullKLykuaI2;
                    textClassifier = (TextClassifier) obj;
                    mutex = mutex2;
                    mutex.unlock(null);
                    Path.Companion companion3 = Duration.Companion;
                    long duration3 = InstantKt.toDuration(200L, durationUnit);
                    SliderState.AnonymousClass2 anonymousClass4 = new SliderState.AnonymousClass2(textClassifier, this.$block, continuation, (byte) 13);
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = (byte) 3;
                    objM1899withTimeoutOrNullKLykuaI = AwaitKt.m1899withTimeoutOrNullKLykuaI(duration3, anonymousClass4, this);
                    if (objM1899withTimeoutOrNullKLykuaI == coroutineSingletons) {
                        return objM1899withTimeoutOrNullKLykuaI;
                    }
                }
            } else {
                mutex.unlock(null);
                Path.Companion companion4 = Duration.Companion;
                long duration4 = InstantKt.toDuration(200L, durationUnit);
                SliderState.AnonymousClass2 anonymousClass5 = new SliderState.AnonymousClass2(textClassifier, this.$block, continuation, (byte) 13);
                this.L$0 = null;
                this.L$1 = null;
                this.label = (byte) 3;
                objM1899withTimeoutOrNullKLykuaI = AwaitKt.m1899withTimeoutOrNullKLykuaI(duration4, anonymousClass5, this);
                if (objM1899withTimeoutOrNullKLykuaI == coroutineSingletons) {
                    return objM1899withTimeoutOrNullKLykuaI;
                }
            }
            return coroutineSingletons;
        } catch (Throwable th2) {
            th = th2;
            mutex2 = mutex;
            mutex2.unlock(null);
            throw th;
        }
    }
}
