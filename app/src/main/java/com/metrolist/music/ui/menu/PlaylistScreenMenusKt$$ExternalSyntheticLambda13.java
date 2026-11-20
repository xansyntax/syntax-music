package com.metrolist.music.ui.menu;

import android.content.Context;
import android.text.format.Formatter;
import androidx.compose.animation.core.AnimateAsState;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.material3.SliderKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableLongState;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda22;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.ui.screens.settings.StorageSettingsKt$$ExternalSyntheticLambda28;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.http.MimesKt$$ExternalSyntheticLambda0;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.ClosedFloatRange;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PlaylistScreenMenusKt$$ExternalSyntheticLambda13 implements Function2 {
    public final /* synthetic */ byte $r8$classId = 1;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Context f$2;
    public final /* synthetic */ int f$3;
    public final /* synthetic */ Object f$4;
    public final /* synthetic */ Object f$5;
    public final /* synthetic */ Object f$6;
    public final /* synthetic */ Object f$7;
    public final /* synthetic */ Object f$8;
    public final /* synthetic */ Object f$9;

    public /* synthetic */ PlaylistScreenMenusKt$$ExternalSyntheticLambda13(int i, Context context, String str, MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda0, AnimateAsState animateAsState, ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState, ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState2, MutableState mutableState, MutableState mutableState2, MutableState mutableState3) {
        this.f$3 = i;
        this.f$2 = context;
        this.f$0 = str;
        this.f$1 = mimesKt$$ExternalSyntheticLambda0;
        this.f$4 = animateAsState;
        this.f$5 = parcelableSnapshotMutableLongState;
        this.f$6 = parcelableSnapshotMutableLongState2;
        this.f$7 = mutableState;
        this.f$8 = mutableState2;
        this.f$9 = mutableState3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        String shortFileSize;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj3 = this.f$9;
        Object obj4 = this.f$8;
        Object obj5 = this.f$7;
        Object obj6 = this.f$6;
        Object obj7 = this.f$5;
        Object obj8 = this.f$4;
        Object obj9 = this.f$1;
        Object obj10 = this.f$0;
        switch (b) {
            case 0:
                ((Integer) obj2).getClass();
                AlbumMenuKt.LocalPlaylistMenu((Playlist) obj10, (List) obj9, this.f$2, this.f$3, (Function0) obj8, (Function0) obj7, (Function0) obj6, (Function0) obj5, (Function0) obj4, (Function0) obj3, (Composer) obj, Stack.updateChangedFlags(1));
                break;
            default:
                String str = (String) obj10;
                MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda0 = (MimesKt$$ExternalSyntheticLambda0) obj9;
                State state = (State) obj8;
                ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState = (ParcelableSnapshotMutableLongState) obj7;
                ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState2 = (ParcelableSnapshotMutableLongState) obj6;
                MutableState mutableState = (MutableState) obj5;
                MutableState mutableState2 = (MutableState) obj4;
                MutableState mutableState3 = (MutableState) obj3;
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    Object objRememberedValue = gapComposer.rememberedValue();
                    NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                    if (objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = CollectionsKt__IterablesKt.listOf((Object[]) new Integer[]{0, 128, 256, 512, 1024, 2048, 4096, 8192});
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    List list = (List) objRememberedValue;
                    ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(OffsetKt.Top, Alignment.Companion.Start, gapComposer, 0);
                    int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
                    Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, companion);
                    ComposeUiNode.Companion.getClass();
                    gapComposer.startReusableNode();
                    if (gapComposer.inserting) {
                        gapComposer.createNode(LayoutNode.Constructor);
                    } else {
                        gapComposer.useNode();
                    }
                    Stack.m390setimpl(gapComposer, columnMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                    Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                    Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
                    Stack.m389reconcileimpl(gapComposer);
                    Stack.m390setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                    int i = this.f$3;
                    Context context = this.f$2;
                    if (i == 0) {
                        shortFileSize = Format$$ExternalSyntheticOutline0.m(gapComposer, -1777969321, R.string.disable, gapComposer, false);
                    } else {
                        gapComposer.startReplaceGroup(-1777966251);
                        gapComposer.end(false);
                        shortFileSize = Formatter.formatShortFileSize(context, ((long) (i * 1024)) * 1024);
                    }
                    String str2 = shortFileSize;
                    str2.getClass();
                    TextKt.m352TextNvy7gAk(str2, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer, 0, 0, 262142);
                    float fIndexOf = list.indexOf(Integer.valueOf(i));
                    int size = list.size() - 2;
                    ClosedFloatRange closedFloatRange = new ClosedFloatRange(CropImageView.DEFAULT_ASPECT_RATIO, list.size() - 1);
                    boolean zChangedInstance = gapComposer.changedInstance(list) | gapComposer.changed(str) | gapComposer.changed(mimesKt$$ExternalSyntheticLambda0);
                    Object objRememberedValue2 = gapComposer.rememberedValue();
                    if (zChangedInstance || objRememberedValue2 == neverEqualPolicy) {
                        StorageSettingsKt$$ExternalSyntheticLambda28 storageSettingsKt$$ExternalSyntheticLambda28 = new StorageSettingsKt$$ExternalSyntheticLambda28(list, str, mimesKt$$ExternalSyntheticLambda0, parcelableSnapshotMutableLongState, parcelableSnapshotMutableLongState2, mutableState, mutableState2, mutableState3, (byte) 0);
                        gapComposer.updateRememberedValue(storageSettingsKt$$ExternalSyntheticLambda28);
                        objRememberedValue2 = storageSettingsKt$$ExternalSyntheticLambda28;
                    }
                    SliderKt.Slider(fIndexOf, (Function1) objRememberedValue2, null, false, closedFloatRange, size, null, null, gapComposer, 0, 460);
                    boolean zChanged = gapComposer.changed(state);
                    Object objRememberedValue3 = gapComposer.rememberedValue();
                    if (zChanged || objRememberedValue3 == neverEqualPolicy) {
                        objRememberedValue3 = new MainActivity$$ExternalSyntheticLambda22(state, (byte) 19);
                        gapComposer.updateRememberedValue(objRememberedValue3);
                    }
                    ProgressIndicatorKt.m309LinearProgressIndicatorGJbTh5U((Function0) objRememberedValue3, SizeKt.fillMaxWidth(companion, 1.0f), 0L, 0L, 1, CropImageView.DEFAULT_ASPECT_RATIO, null, gapComposer, 48, 108);
                    OffsetKt.Spacer(gapComposer, OffsetKt.m135padding3ABfNKs(companion, 2.0f));
                    TextKt.m352TextNvy7gAk(Fragment$5$$ExternalSyntheticOutline0.m(Formatter.formatShortFileSize(context, parcelableSnapshotMutableLongState.getLongValue()), " / ", Formatter.formatShortFileSize(context, ((long) (i * 1024)) * 1024)), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).typography.bodyMedium, gapComposer, 0, 0, 131070);
                    gapComposer.end(true);
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ PlaylistScreenMenusKt$$ExternalSyntheticLambda13(Playlist playlist, List list, Context context, int i, Function0 function0, Function0 function1, Function0 function2, Function0 function3, Function0 function4, Function0 function5, int i2) {
        this.f$0 = playlist;
        this.f$1 = list;
        this.f$2 = context;
        this.f$3 = i;
        this.f$4 = function0;
        this.f$5 = function1;
        this.f$6 = function2;
        this.f$7 = function3;
        this.f$8 = function4;
        this.f$9 = function5;
    }
}
