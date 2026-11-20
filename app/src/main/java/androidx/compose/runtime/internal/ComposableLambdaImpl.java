package androidx.compose.runtime.internal;

import androidx.compose.foundation.gestures.ScrollableNode;
import androidx.compose.foundation.gestures.ScrollableNode$onKeyEvent$1;
import androidx.compose.material3.SnackbarHostKt$$ExternalSyntheticLambda7;
import androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda0;
import androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda25;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.ui.unit.Velocity;
import androidx.lifecycle.compose.LifecycleEffectKt$$ExternalSyntheticLambda0;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function18;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function20;
import kotlin.jvm.functions.Function21;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.AwaitKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ComposableLambdaImpl implements Function2, Function3, Function4, Function5, Function6, Function7, Function8, Function9, Function10, Function11, Function13, Function14, Function15, Function16, Function17, Function18, Function19, Function20, Function21 {
    public Object _block;
    public final int key;
    public RecomposeScopeImpl scope;
    public ArrayList scopes;
    public final boolean tracked;

    /* JADX INFO: renamed from: androidx.compose.runtime.internal.ComposableLambdaImpl$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final /* synthetic */ class AnonymousClass1 extends AdaptedFunctionReference implements Function2 {
        public final /* synthetic */ byte $r8$classId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass1(int i, Object obj, Class cls, String str, String str2, int i2, byte b) {
            super(i, obj, cls, str, str2, i2);
            this.$r8$classId = b;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            switch (b) {
                case 0:
                    int iIntValue = ((Number) obj2).intValue();
                    ((ComposableLambdaImpl) this.receiver).invoke(iIntValue, (Composer) obj);
                    break;
                case 1:
                    long j = ((Velocity) obj).packedValue;
                    ScrollableNode scrollableNode = (ScrollableNode) this.receiver;
                    AwaitKt.launch$default(scrollableNode.nestedScrollDispatcher.getCoroutineScope(), null, null, new ScrollableNode$onKeyEvent$1(scrollableNode, j, null, (byte) 2), 3);
                    break;
                default:
                    long j2 = ((Velocity) obj).packedValue;
                    ScrollableNode scrollableNode2 = (ScrollableNode) this.receiver;
                    AwaitKt.launch$default(scrollableNode2.nestedScrollDispatcher.getCoroutineScope(), null, null, new ScrollableNode$onKeyEvent$1(scrollableNode2, j2, null, (byte) 3), 3);
                    break;
            }
            return unit;
        }
    }

    public ComposableLambdaImpl(boolean z, int i, Object obj) {
        this.key = i;
        this.tracked = z;
        this._block = obj;
    }

    public final Object invoke(Object obj, Boolean bool, Object obj2, Object obj3, Object obj4, Composer composer, int i) {
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(this.key);
        trackRead(gapComposer);
        int iBitsForSlot = gapComposer.changed(this) ? Expect_jvmKt.bitsForSlot(2, 6) : Expect_jvmKt.bitsForSlot(1, 6);
        Object obj5 = this._block;
        TypeIntrinsics.beforeCheckcastToFunctionOfArity(8, obj5);
        Object objInvoke = ((Function8) obj5).invoke(obj, bool, obj2, obj3, obj4, gapComposer, Integer.valueOf(i | iBitsForSlot));
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new TimePickerKt$$ExternalSyntheticLambda25(this, obj, bool, obj2, obj3, obj4, i);
        }
        return objInvoke;
    }

    public final void trackRead(Composer composer) {
        RecomposeScopeImpl currentRecomposeScope$runtime;
        if (!this.tracked || (currentRecomposeScope$runtime = ((GapComposer) composer).getCurrentRecomposeScope$runtime()) == null) {
            return;
        }
        currentRecomposeScope$runtime.setUsed();
        RecomposeScopeImpl recomposeScopeImpl = this.scope;
        if (recomposeScopeImpl == null || !recomposeScopeImpl.getValid() || recomposeScopeImpl == currentRecomposeScope$runtime || Intrinsics.areEqual(recomposeScopeImpl.anchor, currentRecomposeScope$runtime.anchor)) {
            this.scope = currentRecomposeScope$runtime;
            return;
        }
        ArrayList arrayList = this.scopes;
        if (arrayList == null) {
            ArrayList arrayList2 = new ArrayList();
            this.scopes = arrayList2;
            arrayList2.add(currentRecomposeScope$runtime);
            return;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) arrayList.get(i);
            if (recomposeScopeImpl2 == null || !recomposeScopeImpl2.getValid() || recomposeScopeImpl2 == currentRecomposeScope$runtime || Intrinsics.areEqual(recomposeScopeImpl2.anchor, currentRecomposeScope$runtime.anchor)) {
                arrayList.set(i, currentRecomposeScope$runtime);
                return;
            }
        }
        arrayList.add(currentRecomposeScope$runtime);
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Number) obj2).intValue(), (Composer) obj);
    }

    @Override // kotlin.jvm.functions.Function3
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke(obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    @Override // kotlin.jvm.functions.Function4
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        return invoke(obj, obj2, (Composer) obj3, ((Number) obj4).intValue());
    }

    @Override // kotlin.jvm.functions.Function5
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return invoke(obj, obj2, obj3, (Composer) obj4, ((Number) obj5).intValue());
    }

    public final Object invoke(int i, Composer composer) {
        int iBitsForSlot;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(this.key);
        trackRead(gapComposer);
        if (gapComposer.changed(this)) {
            iBitsForSlot = Expect_jvmKt.bitsForSlot(2, 0);
        } else {
            iBitsForSlot = Expect_jvmKt.bitsForSlot(1, 0);
        }
        int i2 = i | iBitsForSlot;
        Object obj = this._block;
        TypeIntrinsics.beforeCheckcastToFunctionOfArity(2, obj);
        Object objInvoke = ((Function2) obj).invoke(gapComposer, Integer.valueOf(i2));
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new AnonymousClass1(2, this, ComposableLambdaImpl.class, "invoke", "invoke(Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;", 8, (byte) 0);
        }
        return objInvoke;
    }

    public final Object invoke(Object obj, Composer composer, int i) {
        int iBitsForSlot;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(this.key);
        trackRead(gapComposer);
        if (gapComposer.changed(this)) {
            iBitsForSlot = Expect_jvmKt.bitsForSlot(2, 1);
        } else {
            iBitsForSlot = Expect_jvmKt.bitsForSlot(1, 1);
        }
        Object obj2 = this._block;
        TypeIntrinsics.beforeCheckcastToFunctionOfArity(3, obj2);
        Object objInvoke = ((Function3) obj2).invoke(obj, gapComposer, Integer.valueOf(iBitsForSlot | i));
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new SnackbarHostKt$$ExternalSyntheticLambda7(this, obj, i, (byte) 9);
        }
        return objInvoke;
    }

    public final Object invoke(Object obj, Object obj2, Composer composer, int i) {
        int iBitsForSlot;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(this.key);
        trackRead(gapComposer);
        if (gapComposer.changed(this)) {
            iBitsForSlot = Expect_jvmKt.bitsForSlot(2, 2);
        } else {
            iBitsForSlot = Expect_jvmKt.bitsForSlot(1, 2);
        }
        Object obj3 = this._block;
        TypeIntrinsics.beforeCheckcastToFunctionOfArity(4, obj3);
        Object objInvoke = ((Function4) obj3).invoke(obj, obj2, gapComposer, Integer.valueOf(iBitsForSlot | i));
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new TimePickerKt$$ExternalSyntheticLambda0((byte) 9, i, (Object) this, obj, obj2);
        }
        return objInvoke;
    }

    public final Object invoke(Object obj, Object obj2, Object obj3, Composer composer, int i) {
        int iBitsForSlot;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(this.key);
        trackRead(gapComposer);
        if (gapComposer.changed(this)) {
            iBitsForSlot = Expect_jvmKt.bitsForSlot(2, 3);
        } else {
            iBitsForSlot = Expect_jvmKt.bitsForSlot(1, 3);
        }
        Object obj4 = this._block;
        TypeIntrinsics.beforeCheckcastToFunctionOfArity(5, obj4);
        Object objInvoke = ((Function5) obj4).invoke(obj, obj2, obj3, gapComposer, Integer.valueOf(iBitsForSlot | i));
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new LifecycleEffectKt$$ExternalSyntheticLambda0(this, obj, obj2, obj3, i, (byte) 2);
        }
        return objInvoke;
    }

    @Override // kotlin.jvm.functions.Function8
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Boolean bool, Object obj2, Object obj3, Object obj4, GapComposer gapComposer, Integer num) {
        return invoke(obj, bool, obj2, obj3, obj4, gapComposer, num.intValue());
    }
}
