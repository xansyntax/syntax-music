package coil3.size;

import android.view.KeyEvent;
import android.view.ViewTreeObserver;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListState$requestScrollToItem$1;
import androidx.compose.material3.TooltipStateImpl;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.draganddrop.AndroidDragAndDropManager;
import androidx.compose.ui.draganddrop.DragAndDropNode;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNode$Companion$TraverseDescendantsAction;
import androidx.compose.ui.platform.AndroidComposeView;
import coil3.util.LifecyclesKt;
import coil3.util.UtilsKt;
import com.metrolist.innertube.YouTube;
import com.metrolist.music.ui.screens.settings.AiSettingsKt;
import com.metrolist.music.ui.screens.settings.AndroidAutoSection;
import com.metrolist.music.viewmodels.OnlineSearchViewModel;
import io.ktor.http.MimesKt$$ExternalSyntheticLambda0;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ViewSizeResolver$size$3$1 implements Function1 {
    public final /* synthetic */ Object $preDrawListener;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object $viewTreeObserver;
    public final /* synthetic */ Object this$0;

    public /* synthetic */ ViewSizeResolver$size$3$1(Object obj, Object obj2, Object obj3, byte b) {
        this.$r8$classId = b;
        this.this$0 = obj;
        this.$viewTreeObserver = obj2;
        this.$preDrawListener = obj3;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj2 = this.this$0;
        Object obj3 = this.$preDrawListener;
        Object obj4 = this.$viewTreeObserver;
        switch (b) {
            case 0:
                RealViewSizeResolver realViewSizeResolver = (RealViewSizeResolver) obj2;
                ViewTreeObserver viewTreeObserver = (ViewTreeObserver) obj4;
                ViewSizeResolver$size$3$preDrawListener$1 viewSizeResolver$size$3$preDrawListener$1 = (ViewSizeResolver$size$3$preDrawListener$1) obj3;
                if (viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnPreDrawListener(viewSizeResolver$size$3$preDrawListener$1);
                } else {
                    realViewSizeResolver.view.getViewTreeObserver().removeOnPreDrawListener(viewSizeResolver$size$3$preDrawListener$1);
                }
                return unit;
            case 1:
                KeyEvent keyEvent = ((androidx.compose.ui.input.key.KeyEvent) obj).nativeKeyEvent;
                MutableState mutableState = (MutableState) obj4;
                TooltipStateImpl tooltipStateImpl = (TooltipStateImpl) obj2;
                if (!tooltipStateImpl.isVisible()) {
                    mutableState.setValue(Boolean.FALSE);
                } else if (Key.m581getTypeZmokQxo(keyEvent) == 2 && Key.m579equalsimpl0(((long) keyEvent.getKeyCode()) << 32, 476741369856L)) {
                    ((MutableState) obj3).setValue(Boolean.FALSE);
                    tooltipStateImpl.dismiss();
                    return Boolean.TRUE;
                }
                return Boolean.FALSE;
            case 2:
                TraversableNode traversableNode = (TraversableNode) obj;
                DragAndDropNode dragAndDropNode = (DragAndDropNode) traversableNode;
                if (!((AndroidDragAndDropManager) ((AndroidComposeView) HitTestResultKt.requireOwner((DragAndDropNode) obj4)).m695getDragAndDropManager()).interestedTargets.contains(dragAndDropNode) || !LifecyclesKt.m885containsUv8p0NA(dragAndDropNode, UtilsKt.getPositionInRoot((DrawResult) obj3))) {
                    return TraversableNode$Companion$TraverseDescendantsAction.ContinueTraversal;
                }
                ((Ref$ObjectRef) obj2).element = traversableNode;
                return TraversableNode$Companion$TraverseDescendantsAction.CancelTraversal;
            case 3:
                YouTube.SearchFilter searchFilter = (YouTube.SearchFilter) obj;
                Continuation continuation = null;
                String str = searchFilter != null ? searchFilter.value : null;
                StateFlowImpl stateFlowImpl = ((OnlineSearchViewModel) obj2).filter;
                YouTube.SearchFilter searchFilter2 = (YouTube.SearchFilter) stateFlowImpl.getValue();
                String str2 = searchFilter2 != null ? searchFilter2.value : null;
                byte b2 = 1;
                boolean zEquals = false;
                if (str2 == null) {
                    if (str == null) {
                        zEquals = true;
                    }
                } else if (str != null) {
                    zEquals = str2.equals(str);
                }
                if (!zEquals) {
                    stateFlowImpl.setValue(str != null ? new YouTube.SearchFilter(str) : null);
                }
                AwaitKt.launch$default((CoroutineScope) obj4, null, null, new LazyListState$requestScrollToItem$1((LazyListState) obj3, continuation, b2), 3);
                return unit;
            default:
                Boolean bool = (Boolean) obj;
                bool.getClass();
                MutableState mutableState2 = (MutableState) obj4;
                List<Pair> list = (List) mutableState2.getValue();
                AndroidAutoSection androidAutoSection = (AndroidAutoSection) obj3;
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                for (Pair pair : list) {
                    AndroidAutoSection androidAutoSection2 = (AndroidAutoSection) pair.first;
                    Boolean bool2 = (Boolean) pair.second;
                    bool2.getClass();
                    arrayList.add(androidAutoSection2 == androidAutoSection ? new Pair(androidAutoSection2, bool) : new Pair(androidAutoSection2, bool2));
                }
                mutableState2.setValue(arrayList);
                ((MimesKt$$ExternalSyntheticLambda0) obj2).invoke(AiSettingsKt.serializeSections((List) mutableState2.getValue()));
                return unit;
        }
    }
}
