package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.datastore.preferences.core.MutablePreferences;
import com.metrolist.music.constants.PreferenceKeysKt;
import com.metrolist.music.ui.component.LensController;
import com.metrolist.music.ui.component.LensController$slideTo$1;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LazyListState$scrollToItem$2 extends SuspendLambda implements Function2 {
    public final /* synthetic */ int $index;
    public final /* synthetic */ byte $r8$classId;
    public /* synthetic */ Object this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LazyListState$scrollToItem$2(Object obj, int i, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.this$0 = obj;
        this.$index = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        int i = this.$index;
        switch (b) {
            case 0:
                return new LazyListState$scrollToItem$2((LazyListState) this.this$0, i, continuation, (byte) 0);
            case 1:
                return new LazyListState$scrollToItem$2((LazyGridState) this.this$0, i, continuation, (byte) 1);
            case 2:
                LazyListState$scrollToItem$2 lazyListState$scrollToItem$2 = new LazyListState$scrollToItem$2(i, continuation);
                lazyListState$scrollToItem$2.this$0 = obj;
                return lazyListState$scrollToItem$2;
            default:
                return new LazyListState$scrollToItem$2((LensController) this.this$0, i, continuation, (byte) 3);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                ((LazyListState$scrollToItem$2) create((ScrollScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                break;
            case 1:
                ((LazyListState$scrollToItem$2) create((ScrollScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                break;
            case 2:
                ((LazyListState$scrollToItem$2) create((MutablePreferences) obj, (Continuation) obj2)).invokeSuspend(unit);
                break;
            default:
                ((LazyListState$scrollToItem$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
                break;
        }
        return unit;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        byte b2 = 0;
        Unit unit = Unit.INSTANCE;
        int i = this.$index;
        switch (b) {
            case 0:
                ResultKt.throwOnFailure(obj);
                ((LazyListState) this.this$0).snapToItemIndexInternal$foundation(i, true, 0);
                break;
            case 1:
                ResultKt.throwOnFailure(obj);
                ((LazyGridState) this.this$0).snapToItemIndexInternal$foundation(i, true, 0);
                break;
            case 2:
                MutablePreferences mutablePreferences = (MutablePreferences) this.this$0;
                ResultKt.throwOnFailure(obj);
                mutablePreferences.set(PreferenceKeysKt.RepeatModeKey, new Integer(i));
                break;
            default:
                ResultKt.throwOnFailure(obj);
                LensController lensController = (LensController) this.this$0;
                if (!lensController.getDragging()) {
                    AwaitKt.launch$default(lensController.scope, null, null, new LensController$slideTo$1(lensController, i, null, b2), 3);
                }
                break;
        }
        return unit;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyListState$scrollToItem$2(int i, Continuation continuation) {
        super(2, continuation);
        this.$r8$classId = (byte) 2;
        this.$index = i;
    }
}
