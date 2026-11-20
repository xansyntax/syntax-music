package androidx.navigation;

import android.os.Bundle;
import androidx.compose.foundation.GestureConnection;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.foundation.lazy.layout.TraversablePrefetchStateNode;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.input.pointer.HoverIconModifierNode;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNode$Companion$TraverseDescendantsAction;
import io.ktor.websocket.BoundedChannel;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.serialization.json.JsonElement;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class NavGraphNavigator$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Ref$ObjectRef f$0;

    public /* synthetic */ NavGraphNavigator$$ExternalSyntheticLambda0(Ref$ObjectRef ref$ObjectRef, byte b) {
        this.$r8$classId = b;
        this.f$0 = ref$ObjectRef;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        boolean z = true;
        Ref$ObjectRef ref$ObjectRef = this.f$0;
        switch (b) {
            case 0:
                String str = (String) obj;
                str.getClass();
                Object obj2 = ref$ObjectRef.element;
                if (obj2 != null && ((Bundle) obj2).containsKey(str)) {
                    z = false;
                }
                return Boolean.valueOf(z);
            case 1:
                GestureConnection gestureConnection = (GestureConnection) obj;
                if (Intrinsics.areEqual(gestureConnection.mo22getGestureState7meUWtM(), "waiting")) {
                    ref$ObjectRef.element = gestureConnection;
                    z = false;
                }
                return Boolean.valueOf(z);
            case 2:
                TraversableNode traversableNode = (TraversableNode) obj;
                traversableNode.getClass();
                LazyLayoutPrefetchState lazyLayoutPrefetchState = ((TraversablePrefetchStateNode) traversableNode).prefetchState;
                List listMutableListOf = (List) ref$ObjectRef.element;
                if (listMutableListOf != null) {
                    listMutableListOf.add(lazyLayoutPrefetchState);
                } else {
                    listMutableListOf = CollectionsKt__IterablesKt.mutableListOf(lazyLayoutPrefetchState);
                }
                ref$ObjectRef.element = listMutableListOf;
                return TraversableNode$Companion$TraverseDescendantsAction.SkipSubtreeAndContinueTraversal;
            case 3:
                Object obj3 = (TraversableNode) obj;
                if (((Modifier.Node) obj3).node.isAttached) {
                    ref$ObjectRef.element = obj3;
                    z = false;
                }
                return Boolean.valueOf(z);
            case 4:
                HoverIconModifierNode hoverIconModifierNode = (HoverIconModifierNode) obj;
                Object obj4 = ref$ObjectRef.element;
                if (obj4 == null && hoverIconModifierNode.cursorInBoundsOfNode) {
                    ref$ObjectRef.element = hoverIconModifierNode;
                } else if (obj4 != null) {
                    hoverIconModifierNode.getClass();
                }
                return Boolean.TRUE;
            case 5:
                ref$ObjectRef.element = (FocusTargetNode) obj;
                return Boolean.TRUE;
            case 6:
                return BoundedChannel.Companion.createDelegate$lambda$0(ref$ObjectRef, obj);
            default:
                JsonElement jsonElement = (JsonElement) obj;
                jsonElement.getClass();
                ref$ObjectRef.element = jsonElement;
                return Unit.INSTANCE;
        }
    }
}
