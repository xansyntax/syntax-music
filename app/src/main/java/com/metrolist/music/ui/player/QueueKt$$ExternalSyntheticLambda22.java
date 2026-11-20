package com.metrolist.music.ui.player;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.foundation.ScrollNode$$ExternalSyntheticLambda2;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.runtime.snapshots.StateListIterator;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.menu.YouTubeAlbumMenuKt;
import com.metrolist.music.ui.screens.playlist.AutoPlaylistScreenKt$AutoPlaylistScreen$12$1;
import com.yalantis.ucrop.R;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.math.MathKt;
import kotlin.reflect.KFunction;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class QueueKt$$ExternalSyntheticLambda22 implements Function3 {
    public final /* synthetic */ byte $r8$classId = 0;
    public final /* synthetic */ List f$0;
    public final /* synthetic */ SnapshotStateList f$1;
    public final /* synthetic */ Function0 f$2;
    public final /* synthetic */ MenuState f$3;

    public /* synthetic */ QueueKt$$ExternalSyntheticLambda22(List list, SnapshotStateList snapshotStateList, Function0 function0, MenuState menuState) {
        this.f$0 = list;
        this.f$1 = snapshotStateList;
        this.f$2 = function0;
        this.f$3 = menuState;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        Object obj4;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        SnapshotStateList snapshotStateList = this.f$1;
        List list = this.f$0;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((AnimatedVisibilityScope) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    boolean zChanged = gapComposer.changed(CollectionsKt.toList(list));
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (zChanged || objRememberedValue == neverEqualPolicy) {
                        obj4 = objRememberedValue;
                        ArrayList arrayList = new ArrayList();
                        ListIterator listIterator = snapshotStateList.listIterator();
                        while (true) {
                            StateListIterator stateListIterator = (StateListIterator) listIterator;
                            if (stateListIterator.hasNext()) {
                                Object next = stateListIterator.next();
                                if (list.contains(((Timeline.Window) next).mediaItem.mediaId)) {
                                    arrayList.add(next);
                                }
                            } else {
                                ArrayList arrayList2 = new ArrayList();
                                int size = arrayList.size();
                                int i = 0;
                                while (i < size) {
                                    Object obj5 = arrayList.get(i);
                                    i++;
                                    MediaItem mediaItem = ((Timeline.Window) obj5).mediaItem;
                                    mediaItem.getClass();
                                    MediaMetadata metadata = UuidKt.getMetadata(mediaItem);
                                    if (metadata != null) {
                                        arrayList2.add(metadata);
                                    }
                                }
                                gapComposer.updateRememberedValue(arrayList2);
                                obj4 = arrayList2;
                            }
                        }
                    }
                    List list2 = (List) obj4;
                    boolean zChanged2 = gapComposer.changed(CollectionsKt.toList(list));
                    Object objRememberedValue2 = gapComposer.rememberedValue();
                    Object obj6 = objRememberedValue2;
                    if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                        ArrayList arrayList3 = new ArrayList();
                        ListIterator listIterator2 = snapshotStateList.listIterator();
                        while (true) {
                            StateListIterator stateListIterator2 = (StateListIterator) listIterator2;
                            if (stateListIterator2.hasNext()) {
                                Object next2 = stateListIterator2.next();
                                if (list.contains(((Timeline.Window) next2).mediaItem.mediaId)) {
                                    arrayList3.add(next2);
                                }
                            } else {
                                gapComposer.updateRememberedValue(arrayList3);
                                obj6 = arrayList3;
                            }
                        }
                    }
                    List list3 = (List) obj6;
                    int size2 = list.size();
                    Modifier modifierM145height3ABfNKs = SizeKt.m145height3ABfNKs(Modifier.Companion.$$INSTANCE, 48.0f);
                    RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(OffsetKt.Start, Alignment.Companion.CenterVertically, gapComposer, 48);
                    int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierM145height3ABfNKs);
                    ComposeUiNode.Companion.getClass();
                    gapComposer.startReusableNode();
                    if (gapComposer.inserting) {
                        gapComposer.createNode(LayoutNode.Constructor);
                    } else {
                        gapComposer.useNode();
                    }
                    Stack.m390setimpl(gapComposer, rowMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                    Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                    Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
                    Stack.m389reconcileimpl(gapComposer);
                    Stack.m390setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                    ComposableLambdaImpl composableLambdaImpl = QueueKt.lambda$12398022;
                    Function0 function0 = this.f$2;
                    CardKt.IconButton(function0, null, false, null, null, composableLambdaImpl, gapComposer, 1572864, 62);
                    TextKt.m352TextNvy7gAk(MathKt.pluralStringResource(R.plurals.n_selected, size2, new Object[]{Integer.valueOf(size2)}, gapComposer), new LayoutWeightElement(1.0f, true), 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer, 0, 0, 262140);
                    boolean z = size2 == snapshotStateList.size() && size2 > 0;
                    boolean zChanged3 = gapComposer.changed(size2) | gapComposer.changedInstance(list);
                    Object objRememberedValue3 = gapComposer.rememberedValue();
                    if (zChanged3 || objRememberedValue3 == neverEqualPolicy) {
                        objRememberedValue3 = new ScrollNode$$ExternalSyntheticLambda2(size2, snapshotStateList, list);
                        gapComposer.updateRememberedValue(objRememberedValue3);
                    }
                    CardKt.Checkbox(z, (Function1) objRememberedValue3, null, false, null, gapComposer, 0);
                    boolean z2 = size2 > 0;
                    MenuState menuState = this.f$3;
                    boolean zChanged4 = gapComposer.changed(menuState) | gapComposer.changedInstance(list2) | gapComposer.changedInstance(list3) | gapComposer.changed(function0);
                    Object objRememberedValue4 = gapComposer.rememberedValue();
                    if (zChanged4 || objRememberedValue4 == neverEqualPolicy) {
                        objRememberedValue4 = new QueueKt$$ExternalSyntheticLambda34(menuState, list2, list3, function0);
                        gapComposer.updateRememberedValue(objRememberedValue4);
                    }
                    CardKt.IconButton((Function0) objRememberedValue4, null, z2, null, null, QueueKt.lambda$616998205, gapComposer, 1572864, 58);
                    gapComposer.end(true);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                break;
            default:
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                ((ColumnScopeInstance) obj).getClass();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    ArrayList arrayList4 = new ArrayList();
                    for (Object obj7 : list) {
                        if (snapshotStateList.contains(((SongItem) ((Pair) obj7).second).id)) {
                            arrayList4.add(obj7);
                        }
                    }
                    ArrayList arrayList5 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList4, 10));
                    int size3 = arrayList4.size();
                    int i2 = 0;
                    while (i2 < size3) {
                        Object obj8 = arrayList4.get(i2);
                        i2++;
                        arrayList5.add((SongItem) ((Pair) obj8).second);
                    }
                    MenuState menuState2 = this.f$3;
                    boolean zChanged5 = gapComposer2.changed(menuState2);
                    Object objRememberedValue5 = gapComposer2.rememberedValue();
                    if (zChanged5 || objRememberedValue5 == neverEqualPolicy) {
                        AutoPlaylistScreenKt$AutoPlaylistScreen$12$1 autoPlaylistScreenKt$AutoPlaylistScreen$12$1 = new AutoPlaylistScreenKt$AutoPlaylistScreen$12$1(0, menuState2, MenuState.class, "dismiss", "dismiss()V", 0, (byte) 20);
                        gapComposer2.updateRememberedValue(autoPlaylistScreenKt$AutoPlaylistScreen$12$1);
                        objRememberedValue5 = autoPlaylistScreenKt$AutoPlaylistScreen$12$1;
                    }
                    YouTubeAlbumMenuKt.YouTubeSelectionSongMenu(arrayList5, (Function0) ((KFunction) objRememberedValue5), this.f$2, gapComposer2, 384);
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ QueueKt$$ExternalSyntheticLambda22(List list, MenuState menuState, Function0 function0, SnapshotStateList snapshotStateList) {
        this.f$0 = list;
        this.f$3 = menuState;
        this.f$2 = function0;
        this.f$1 = snapshotStateList;
    }
}
