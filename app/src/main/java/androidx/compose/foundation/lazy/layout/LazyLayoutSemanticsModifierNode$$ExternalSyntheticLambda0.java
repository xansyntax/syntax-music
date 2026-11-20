package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.pager.PagerState$scrollToPage$2;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.AwaitKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LazyLayoutSemanticsModifierNode$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ LazyLayoutSemanticsModifierNode f$0;

    public /* synthetic */ LazyLayoutSemanticsModifierNode$$ExternalSyntheticLambda0(LazyLayoutSemanticsModifierNode lazyLayoutSemanticsModifierNode, byte b) {
        this.$r8$classId = b;
        this.f$0 = lazyLayoutSemanticsModifierNode;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        LazyLayoutSemanticsModifierNode lazyLayoutSemanticsModifierNode = this.f$0;
        switch (b) {
            case 0:
                LazyLayoutItemProvider lazyLayoutItemProvider = (LazyLayoutItemProvider) lazyLayoutSemanticsModifierNode.itemProviderLambda.invoke();
                int itemCount = lazyLayoutItemProvider.getItemCount();
                int i = 0;
                while (i < itemCount) {
                    if (lazyLayoutItemProvider.getKey(i).equals(obj)) {
                        return Integer.valueOf(i);
                    }
                    i++;
                }
                i = -1;
                return Integer.valueOf(i);
            default:
                int iIntValue = ((Integer) obj).intValue();
                LazyLayoutItemProvider lazyLayoutItemProvider2 = (LazyLayoutItemProvider) lazyLayoutSemanticsModifierNode.itemProviderLambda.invoke();
                if (iIntValue < 0 || iIntValue >= lazyLayoutItemProvider2.getItemCount()) {
                    InlineClassHelperKt.throwIllegalArgumentException("Can't scroll to index " + iIntValue + ", it is out of bounds [0, " + lazyLayoutItemProvider2.getItemCount() + ")");
                }
                AwaitKt.launch$default(lazyLayoutSemanticsModifierNode.getCoroutineScope(), null, null, new PagerState$scrollToPage$2(lazyLayoutSemanticsModifierNode, iIntValue, null, (byte) 1), 3);
                return Boolean.TRUE;
        }
    }
}
