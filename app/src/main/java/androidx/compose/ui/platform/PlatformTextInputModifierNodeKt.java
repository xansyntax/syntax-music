package androidx.compose.ui.platform;

import androidx.compose.foundation.text.input.internal.LegacyAdaptingPlatformTextInputModifierNode;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.Owner;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import coil3.disk.UtilsKt$$ExternalSyntheticLambda0;
import com.metrolist.innertubex.InnerTube$feedback$2;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class PlatformTextInputModifierNodeKt {
    public static final StaticProvidableCompositionLocal LocalChainedPlatformTextInputInterceptor = new StaticProvidableCompositionLocal(new UtilsKt$$ExternalSyntheticLambda0((byte) 1), (byte) 0);

    /* JADX INFO: renamed from: androidx.compose.ui.platform.PlatformTextInputModifierNodeKt$establishTextInputSession$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            PlatformTextInputModifierNodeKt.establishTextInputSession(null, null, this);
            return CoroutineSingletons.COROUTINE_SUSPENDED;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.platform.PlatformTextInputModifierNodeKt$interceptedTextInputSession$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00371 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            PlatformTextInputModifierNodeKt.interceptedTextInputSession(null, null, this);
            return CoroutineSingletons.COROUTINE_SUSPENDED;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final void establishTextInputSession(LegacyAdaptingPlatformTextInputModifierNode legacyAdaptingPlatformTextInputModifierNode, InnerTube$feedback$2 innerTube$feedback$2, ContinuationImpl continuationImpl) {
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
        if (i2 != 0) {
            if (i2 == 1) {
                throw Fragment$5$$ExternalSyntheticOutline0.m(obj);
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return;
        }
        ResultKt.throwOnFailure(obj);
        if (!legacyAdaptingPlatformTextInputModifierNode.node.isAttached) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("establishTextInputSession called from an unattached node");
            return;
        }
        Owner ownerRequireOwner = HitTestResultKt.requireOwner(legacyAdaptingPlatformTextInputModifierNode);
        PersistentCompositionLocalHashMap persistentCompositionLocalHashMap = (PersistentCompositionLocalHashMap) HitTestResultKt.requireLayoutNode(legacyAdaptingPlatformTextInputModifierNode).compositionLocalMap;
        persistentCompositionLocalHashMap.getClass();
        if (Stack.read(persistentCompositionLocalHashMap, LocalChainedPlatformTextInputInterceptor) != null) {
            PathKt$$ExternalSyntheticBUOutline0.m();
        } else {
            anonymousClass1.label = 1;
            interceptedTextInputSession(ownerRequireOwner, innerTube$feedback$2, anonymousClass1);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final void interceptedTextInputSession(Owner owner, Function2 function2, ContinuationImpl continuationImpl) {
        C00371 c00371;
        if (continuationImpl instanceof C00371) {
            c00371 = (C00371) continuationImpl;
            int i = c00371.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00371.label = i - Integer.MIN_VALUE;
            } else {
                c00371 = new C00371(continuationImpl);
            }
        } else {
            c00371 = new C00371(continuationImpl);
        }
        Object obj = c00371.result;
        int i2 = c00371.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            c00371.label = 1;
            ((AndroidComposeView) owner).textInputSession(function2, c00371);
        } else {
            if (i2 == 1) {
                throw Fragment$5$$ExternalSyntheticOutline0.m(obj);
            }
            if (i2 == 2) {
                throw Fragment$5$$ExternalSyntheticOutline0.m(obj);
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
