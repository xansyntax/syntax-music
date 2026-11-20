package kotlinx.coroutines.channels;

import android.content.res.Resources;
import androidx.compose.ui.draganddrop.ComposeDragShadowBuilder;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.Api24Impl;
import androidx.compose.ui.unit.DensityImpl;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.internal.InlineList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class BufferedChannel$bindCancellationFun$2 extends FunctionReferenceImpl implements Function3 {
    public final /* synthetic */ byte $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BufferedChannel$bindCancellationFun$2(int i, Object obj, Class cls, String str, String str2, int i2, byte b) {
        super(i, obj, cls, str, str2, i2);
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                Function1 function1 = ((BufferedChannel) this.receiver).onUndeliveredElement;
                function1.getClass();
                InlineList.callUndeliveredElement(function1, obj2, (CoroutineContext) obj3);
                return unit;
            case 1:
                if (obj != null) {
                    PathKt$$ExternalSyntheticBUOutline0.m();
                    return null;
                }
                AndroidComposeView androidComposeView = (AndroidComposeView) this.receiver;
                Resources resources = androidComposeView.getContext().getResources();
                return Boolean.valueOf(Api24Impl.startDragAndDrop(androidComposeView, null, new ComposeDragShadowBuilder(new DensityImpl(resources.getDisplayMetrics().density, resources.getConfiguration().fontScale), ((Size) obj2).packedValue, (Function1) obj3)));
            default:
                Object obj4 = ((ChannelResult) obj2).holder;
                Function1 function2 = ((BufferedChannel) this.receiver).onUndeliveredElement;
                function2.getClass();
                Object objM1903getOrNullimpl = ChannelResult.m1903getOrNullimpl(obj4);
                objM1903getOrNullimpl.getClass();
                InlineList.callUndeliveredElement(function2, objM1903getOrNullimpl, (CoroutineContext) obj3);
                return unit;
        }
    }
}
