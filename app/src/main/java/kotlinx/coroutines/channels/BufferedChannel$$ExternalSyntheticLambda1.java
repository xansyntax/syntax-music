package kotlinx.coroutines.channels;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import com.google.common.math.IntMath;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.viewmodels.CachePlaylistViewModel$$ExternalSyntheticLambda0;
import com.yalantis.ucrop.R;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.math.MathKt;
import kotlinx.coroutines.internal.InlineList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class BufferedChannel$$ExternalSyntheticLambda1 implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ BufferedChannel$$ExternalSyntheticLambda1(Object obj, Object obj2, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = obj2;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        String str;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        byte b2 = 1;
        Object obj4 = this.f$1;
        Object obj5 = this.f$0;
        switch (b) {
            case 0:
                InlineList.callUndeliveredElement((Function1) obj5, obj4, (CoroutineContext) obj3);
                break;
            case 1:
                Playlist playlist = (Playlist) obj5;
                String str2 = (String) obj4;
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((RowScope) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    TextKt.m352TextNvy7gAk((playlist == null || (str = playlist.playlist.name) == null) ? str2 : str, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer, 0, 0, 262142);
                }
                break;
            default:
                List list = (List) obj5;
                LazyListState lazyListState = (LazyListState) obj4;
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    Modifier modifierM145height3ABfNKs = SizeKt.m145height3ABfNKs(SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f), 350.0f);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
                    int iHashCode = Long.hashCode(gapComposer2.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer2, modifierM145height3ABfNKs);
                    ComposeUiNode.Companion.getClass();
                    gapComposer2.startReusableNode();
                    boolean z = gapComposer2.inserting;
                    TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = LayoutNode.Constructor;
                    if (z) {
                        gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
                    } else {
                        gapComposer2.useNode();
                    }
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = ComposeUiNode.Companion.SetMeasurePolicy;
                    Stack.m390setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy, updater$$ExternalSyntheticLambda0);
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                    Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope, updater$$ExternalSyntheticLambda1);
                    Integer numValueOf = Integer.valueOf(iHashCode);
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda2 = ComposeUiNode.Companion.SetCompositeKeyHash;
                    Stack.m390setimpl(gapComposer2, numValueOf, updater$$ExternalSyntheticLambda2);
                    Stack.m389reconcileimpl(gapComposer2);
                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda3 = ComposeUiNode.Companion.SetModifier;
                    Stack.m390setimpl(gapComposer2, modifierMaterializeModifier, updater$$ExternalSyntheticLambda3);
                    if (list.isEmpty()) {
                        gapComposer2.startReplaceGroup(701756670);
                        FillElement fillElement = SizeKt.FillWholeMaxSize;
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
                        int iHashCode2 = Long.hashCode(gapComposer2.compositeKeyHashCode);
                        PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope2 = gapComposer2.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier2 = ZIndexModifierKt.materializeModifier(gapComposer2, fillElement);
                        gapComposer2.startReusableNode();
                        if (gapComposer2.inserting) {
                            gapComposer2.createNode(textKt$$ExternalSyntheticLambda3);
                        } else {
                            gapComposer2.useNode();
                        }
                        Stack.m390setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy2, updater$$ExternalSyntheticLambda0);
                        Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope2, updater$$ExternalSyntheticLambda1);
                        IntIntPair$$ExternalSyntheticOutline0.m(iHashCode2, gapComposer2, updater$$ExternalSyntheticLambda2, gapComposer2);
                        Stack.m390setimpl(gapComposer2, modifierMaterializeModifier2, updater$$ExternalSyntheticLambda3);
                        TextKt.m352TextNvy7gAk(MathKt.stringResource(R.string.listen_together_no_logs, gapComposer2), null, ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.onSurfaceVariant, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer2, 0, 0, 262138);
                        gapComposer2.end(true);
                        gapComposer2.end(false);
                    } else {
                        gapComposer2.startReplaceGroup(702163917);
                        FillElement fillElement2 = SizeKt.FillWholeMaxSize;
                        boolean zChangedInstance = gapComposer2.changedInstance(list);
                        Object objRememberedValue = gapComposer2.rememberedValue();
                        if (zChangedInstance || objRememberedValue == Composer.Companion.Empty) {
                            objRememberedValue = new CachePlaylistViewModel$$ExternalSyntheticLambda0(list, b2);
                            gapComposer2.updateRememberedValue(objRememberedValue);
                        }
                        IntMath.LazyColumn(fillElement2, lazyListState, null, null, null, null, false, null, (Function1) objRememberedValue, gapComposer2, 6, 508);
                        gapComposer2.end(false);
                    }
                    gapComposer2.end(true);
                }
                break;
        }
        return unit;
    }
}
