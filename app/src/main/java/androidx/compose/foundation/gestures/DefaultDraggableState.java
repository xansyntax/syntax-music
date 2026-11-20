package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatorMutex;
import androidx.compose.material3.SliderState;
import androidx.compose.material3.SliderState$dragScope$1;
import androidx.navigation.compose.NavHostKt$NavHost$29$1;
import com.metrolist.innertubex.InnerTube$feedback$2;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.AwaitKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultDraggableState implements DraggableState {
    public final Function1 onDelta;
    public final SliderState$dragScope$1 dragScope = new SliderState$dragScope$1(this, (byte) 1);
    public final MutatorMutex scrollMutex = new MutatorMutex();

    public DefaultDraggableState(Function1 function1) {
        this.onDelta = function1;
    }

    @Override // androidx.compose.foundation.gestures.DraggableState
    public final Object drag(InnerTube$feedback$2 innerTube$feedback$2, NavHostKt$NavHost$29$1 navHostKt$NavHost$29$1) {
        Object objCoroutineScope = AwaitKt.coroutineScope(new SliderState.AnonymousClass2(this, innerTube$feedback$2, null, (byte) 4), navHostKt$NavHost$29$1);
        return objCoroutineScope == CoroutineSingletons.COROUTINE_SUSPENDED ? objCoroutineScope : Unit.INSTANCE;
    }
}
