package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.foundation.text.input.internal.LegacyTextInputMethodRequest;
import androidx.compose.material3.SliderState;
import androidx.compose.ui.ZIndexNode$$ExternalSyntheticLambda0;
import androidx.compose.ui.text.input.TextInputService;
import androidx.navigation.compose.NavHostKt$NavHost$29$1;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidPlatformTextInputSession implements CoroutineScope {
    public final CoroutineScope coroutineScope;
    public final AtomicReference methodSessionMutex = new AtomicReference(null);
    public final TextInputService textInputService;
    public final View view;

    /* JADX INFO: renamed from: androidx.compose.ui.platform.AndroidPlatformTextInputSession$startInputMethod$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            AndroidPlatformTextInputSession.this.startInputMethod(null, this);
            return CoroutineSingletons.COROUTINE_SUSPENDED;
        }
    }

    public AndroidPlatformTextInputSession(View view, TextInputService textInputService, CoroutineScope coroutineScope) {
        this.view = view;
        this.textInputService = textInputService;
        this.coroutineScope = coroutineScope;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.coroutineScope.getCoroutineContext();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final void startInputMethod(LegacyTextInputMethodRequest legacyTextInputMethodRequest, ContinuationImpl continuationImpl) {
        AnonymousClass1 anonymousClass1;
        if (continuationImpl instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuationImpl;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuationImpl);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuationImpl);
        }
        Object obj = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            ZIndexNode$$ExternalSyntheticLambda0 zIndexNode$$ExternalSyntheticLambda0 = new ZIndexNode$$ExternalSyntheticLambda0((Object) legacyTextInputMethodRequest, (Object) this, (byte) 28);
            Continuation continuation = null;
            SliderState.AnonymousClass2 anonymousClass2 = new SliderState.AnonymousClass2(this, continuation, (byte) 25);
            anonymousClass1.label = 1;
            if (AwaitKt.coroutineScope(new NavHostKt$NavHost$29$1((Object) zIndexNode$$ExternalSyntheticLambda0, (Object) this.methodSessionMutex, (Object) anonymousClass2, continuation, (byte) 3), anonymousClass1) == CoroutineSingletons.COROUTINE_SUSPENDED) {
                return;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return;
            }
            ResultKt.throwOnFailure(obj);
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
    }
}
