package androidx.compose.ui.layout;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.node.ComposeUiNode;
import coil3.compose.AsyncImageKt;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.ui.component.MenuKt;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LayoutKt$$ExternalSyntheticLambda0 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ List f$0;

    public /* synthetic */ LayoutKt$$ExternalSyntheticLambda0(int i, List list) {
        this.$r8$classId = (byte) 1;
        this.f$0 = list;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        List list = this.f$0;
        Composer composer = (Composer) obj;
        Integer num = (Integer) obj2;
        switch (b) {
            case 0:
                int iIntValue = num.intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        Function2 function2 = (Function2) list.get(i);
                        int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
                        ComposeUiNode.Companion.getClass();
                        gapComposer.startReusableNode();
                        if (gapComposer.inserting) {
                            gapComposer.createNode(ComposeUiNode.Companion.VirtualConstructor);
                        } else {
                            gapComposer.useNode();
                        }
                        Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
                        function2.invoke(gapComposer, 0);
                        gapComposer.end(true);
                    }
                } else {
                    gapComposer.skipToGroupEnd();
                }
                break;
            case 1:
                num.getClass();
                MenuKt.Material3MenuGroup(list, composer, Stack.updateChangedFlags(1));
                break;
            case 2:
                int iIntValue2 = num.intValue();
                GapComposer gapComposer2 = (GapComposer) composer;
                if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    AsyncImageKt.m849AsyncImage10Xjiaw(((Song) list.get(0)).song.thumbnailUrl, SizeKt.FillWholeMaxSize, ContentScale.Companion.Crop, gapComposer2, 1573296, 1976);
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                break;
            case 3:
                int iIntValue3 = num.intValue();
                GapComposer gapComposer3 = (GapComposer) composer;
                if (gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                    AsyncImageKt.m849AsyncImage10Xjiaw(((Song) CollectionsKt.first(list)).song.thumbnailUrl, SizeKt.FillWholeMaxSize, ContentScale.Companion.Crop, gapComposer3, 1573296, 1976);
                } else {
                    gapComposer3.skipToGroupEnd();
                }
                break;
            default:
                int iIntValue4 = num.intValue();
                GapComposer gapComposer4 = (GapComposer) composer;
                if (gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 3) != 2)) {
                    AsyncImageKt.m849AsyncImage10Xjiaw(((Song) list.get(0)).song.thumbnailUrl, SizeKt.FillWholeMaxSize, ContentScale.Companion.Crop, gapComposer4, 1573296, 1976);
                } else {
                    gapComposer4.skipToGroupEnd();
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ LayoutKt$$ExternalSyntheticLambda0(List list, byte b) {
        this.$r8$classId = b;
        this.f$0 = list;
    }
}
