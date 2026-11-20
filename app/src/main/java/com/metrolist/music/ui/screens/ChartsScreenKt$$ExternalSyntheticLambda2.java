package com.metrolist.music.ui.screens;

import androidx.compose.foundation.layout.BoxWithConstraintsScopeImpl;
import androidx.compose.foundation.layout.InsetsPaddingValues;
import androidx.compose.foundation.layout.LimitInsets;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.navigation.compose.NavHostKt$$ExternalSyntheticLambda12;
import com.google.common.math.IntMath;
import com.metrolist.innertube.pages.ChartsPage;
import com.metrolist.music.MainActivityKt;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.ui.component.MenuState;
import com.metrolist.music.ui.component.shimmer.ShimmerHostKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ChartsScreenKt$$ExternalSyntheticLambda2 implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ LazyListState f$0;
    public final /* synthetic */ State f$1;
    public final /* synthetic */ State f$2;
    public final /* synthetic */ State f$3;
    public final /* synthetic */ HapticFeedback f$4;
    public final /* synthetic */ MenuState f$5;
    public final /* synthetic */ PlayerConnection f$6;
    public final /* synthetic */ CoroutineScope f$7;
    public final /* synthetic */ State f$8;

    public /* synthetic */ ChartsScreenKt$$ExternalSyntheticLambda2(LazyListState lazyListState, State state, State state2, State state3, HapticFeedback hapticFeedback, MenuState menuState, PlayerConnection playerConnection, CoroutineScope coroutineScope, State state4, byte b) {
        this.$r8$classId = b;
        this.f$0 = lazyListState;
        this.f$1 = state;
        this.f$2 = state2;
        this.f$3 = state3;
        this.f$4 = hapticFeedback;
        this.f$5 = menuState;
        this.f$6 = playerConnection;
        this.f$7 = coroutineScope;
        this.f$8 = state4;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x00bc  */
    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                PaddingValues paddingValues = (PaddingValues) obj;
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                paddingValues.getClass();
                if ((iIntValue & 6) == 0) {
                    iIntValue |= ((GapComposer) composer).changed(paddingValues) ? 4 : 2;
                }
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(1 & iIntValue, (iIntValue & 19) != 18)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    OffsetKt.BoxWithConstraints(OffsetKt.padding(SizeKt.FillWholeMaxSize, paddingValues), null, Expect_jvmKt.rememberComposableLambda(1445020967, new ChartsScreenKt$$ExternalSyntheticLambda2(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, this.f$8, (byte) 1), gapComposer), gapComposer, 3072, 6);
                }
                break;
            default:
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                ((BoxWithConstraintsScopeImpl) obj).getClass();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(1 & iIntValue2, (iIntValue2 & 17) != 16)) {
                    gapComposer2.skipToGroupEnd();
                } else if (!((Boolean) this.f$8.getValue()).booleanValue()) {
                    State state = this.f$1;
                    if (((ChartsPage) state.getValue()) != null) {
                        gapComposer2.startReplaceGroup(167088102);
                        InsetsPaddingValues insetsPaddingValuesAsPaddingValues = OffsetKt.asPaddingValues(new LimitInsets((WindowInsets) gapComposer2.consume(MainActivityKt.LocalPlayerAwareWindowInsets), 47), gapComposer2);
                        boolean zChanged = gapComposer2.changed(state);
                        State state2 = this.f$2;
                        boolean zChanged2 = zChanged | gapComposer2.changed(state2);
                        State state3 = this.f$3;
                        boolean zChanged3 = zChanged2 | gapComposer2.changed(state3);
                        HapticFeedback hapticFeedback = this.f$4;
                        boolean zChangedInstance = zChanged3 | gapComposer2.changedInstance(hapticFeedback);
                        MenuState menuState = this.f$5;
                        boolean zChanged4 = zChangedInstance | gapComposer2.changed(menuState);
                        PlayerConnection playerConnection = this.f$6;
                        boolean zChangedInstance2 = zChanged4 | gapComposer2.changedInstance(playerConnection);
                        CoroutineScope coroutineScope = this.f$7;
                        boolean zChangedInstance3 = zChangedInstance2 | gapComposer2.changedInstance(coroutineScope);
                        Object objRememberedValue = gapComposer2.rememberedValue();
                        if (zChangedInstance3 || objRememberedValue == Composer.Companion.Empty) {
                            NavHostKt$$ExternalSyntheticLambda12 navHostKt$$ExternalSyntheticLambda12 = new NavHostKt$$ExternalSyntheticLambda12(state, (Object) state2, (Object) state3, (Object) hapticFeedback, (Object) menuState, (Object) playerConnection, (Object) coroutineScope, (byte) 4);
                            gapComposer2.updateRememberedValue(navHostKt$$ExternalSyntheticLambda12);
                            objRememberedValue = navHostKt$$ExternalSyntheticLambda12;
                        }
                        IntMath.LazyColumn(null, this.f$0, insetsPaddingValuesAsPaddingValues, null, null, null, false, null, (Function1) objRememberedValue, gapComposer2, 0, 505);
                        gapComposer2.end(false);
                    } else {
                        gapComposer2.startReplaceGroup(162604541);
                        ShimmerHostKt.ShimmerHost(SizeKt.FillWholeMaxSize, null, null, false, AlbumScreenKt.lambda$485265506, gapComposer2, 24582, 14);
                        gapComposer2.end(false);
                    }
                } else {
                    gapComposer2.startReplaceGroup(162604541);
                    ShimmerHostKt.ShimmerHost(SizeKt.FillWholeMaxSize, null, null, false, AlbumScreenKt.lambda$485265506, gapComposer2, 24582, 14);
                    gapComposer2.end(false);
                }
                break;
        }
        return unit;
    }
}
