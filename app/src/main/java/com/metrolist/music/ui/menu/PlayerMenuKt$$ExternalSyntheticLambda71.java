package com.metrolist.music.ui.menu;

import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda1;
import com.metrolist.music.listentogether.ConnectionState;
import com.metrolist.music.listentogether.ListenTogetherManager;
import com.metrolist.music.ui.screens.ListenTogetherScreenKt;
import com.metrolist.music.ui.screens.ListenTogetherScreenKt$$ExternalSyntheticLambda35;
import com.yalantis.ucrop.view.CropImageView;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PlayerMenuKt$$ExternalSyntheticLambda71 implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ State f$0;
    public final /* synthetic */ ListenTogetherManager f$1;

    public /* synthetic */ PlayerMenuKt$$ExternalSyntheticLambda71(State state, ListenTogetherManager listenTogetherManager) {
        this.$r8$classId = (byte) 0;
        this.f$0 = state;
        this.f$1 = listenTogetherManager;
    }

    /* JADX WARN: Code duplicated, block: B:76:0x01d9  */
    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        long jColor;
        byte b = this.$r8$classId;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        Unit unit = Unit.INSTANCE;
        State state = this.f$0;
        ListenTogetherManager listenTogetherManager = this.f$1;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    Modifier modifierM137paddingVpY3zN4$default = OffsetKt.m137paddingVpY3zN4$default(SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f), 16.0f, CropImageView.DEFAULT_ASPECT_RATIO, 2);
                    RoundedCornerShape roundedCornerShapeM185RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(12.0f);
                    int iOrdinal = ((ConnectionState) state.getValue()).ordinal();
                    if (iOrdinal == 0) {
                        gapComposer.startReplaceGroup(-335106301);
                        jColor = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.surfaceVariant;
                        gapComposer.end(false);
                    } else if (iOrdinal == 1) {
                        gapComposer.startReplaceGroup(-335112792);
                        long j = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.secondary;
                        jColor = ColorKt.Color(Color.m485getRedimpl(j), Color.m484getGreenimpl(j), Color.m482getBlueimpl(j), 0.15f, Color.m483getColorSpaceimpl(j));
                        gapComposer.end(false);
                    } else if (iOrdinal == 2) {
                        gapComposer.startReplaceGroup(-335117272);
                        long j2 = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.primary;
                        jColor = ColorKt.Color(Color.m485getRedimpl(j2), Color.m484getGreenimpl(j2), Color.m482getBlueimpl(j2), 0.15f, Color.m483getColorSpaceimpl(j2));
                        gapComposer.end(false);
                    } else if (iOrdinal == 3) {
                        gapComposer.startReplaceGroup(-335112792);
                        long j3 = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.secondary;
                        jColor = ColorKt.Color(Color.m485getRedimpl(j3), Color.m484getGreenimpl(j3), Color.m482getBlueimpl(j3), 0.15f, Color.m483getColorSpaceimpl(j3));
                        gapComposer.end(false);
                    } else {
                        if (iOrdinal != 4) {
                            throw Format$$ExternalSyntheticOutline0.m(gapComposer, -335120384, false);
                        }
                        gapComposer.startReplaceGroup(-335109560);
                        long j4 = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.error;
                        jColor = ColorKt.Color(Color.m485getRedimpl(j4), Color.m484getGreenimpl(j4), Color.m482getBlueimpl(j4), 0.15f, Color.m483getColorSpaceimpl(j4));
                        gapComposer.end(false);
                    }
                    SurfaceKt.m337SurfaceT9BRK9s(modifierM137paddingVpY3zN4$default, roundedCornerShapeM185RoundedCornerShape0680j_4, jColor, 0L, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, null, Expect_jvmKt.rememberComposableLambda(2120415322, new MainActivity$$ExternalSyntheticLambda1(state, listenTogetherManager, (byte) 17), gapComposer), gapComposer, 12582918, 120);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                return unit;
            case 1:
                Composer composer2 = (Composer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    ConnectionState connectionState = (ConnectionState) state.getValue();
                    boolean zChangedInstance = gapComposer2.changedInstance(listenTogetherManager);
                    Object objRememberedValue = gapComposer2.rememberedValue();
                    if (zChangedInstance || objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new PlayerMenuKt$$ExternalSyntheticLambda117(listenTogetherManager, (byte) 4);
                        gapComposer2.updateRememberedValue(objRememberedValue);
                    }
                    Function0 function0 = (Function0) objRememberedValue;
                    boolean zChangedInstance2 = gapComposer2.changedInstance(listenTogetherManager);
                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new PlayerMenuKt$$ExternalSyntheticLambda117(listenTogetherManager, (byte) 5);
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    }
                    Function0 function1 = (Function0) objRememberedValue2;
                    boolean zChangedInstance3 = gapComposer2.changedInstance(listenTogetherManager);
                    Object objRememberedValue3 = gapComposer2.rememberedValue();
                    if (zChangedInstance3 || objRememberedValue3 == neverEqualPolicy) {
                        objRememberedValue3 = new PlayerMenuKt$$ExternalSyntheticLambda117(listenTogetherManager, (byte) 6);
                        gapComposer2.updateRememberedValue(objRememberedValue3);
                    }
                    ListenTogetherScreenKt.ConnectionStatusCard(connectionState, function0, function1, (Function0) objRememberedValue3, gapComposer2, 0);
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                return unit;
            case 2:
                Composer composer3 = (Composer) obj2;
                int iIntValue3 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                    List list = (List) state.getValue();
                    boolean zChangedInstance4 = gapComposer3.changedInstance(listenTogetherManager);
                    Object objRememberedValue4 = gapComposer3.rememberedValue();
                    if (zChangedInstance4 || objRememberedValue4 == neverEqualPolicy) {
                        objRememberedValue4 = new ListenTogetherScreenKt$$ExternalSyntheticLambda35(listenTogetherManager, (byte) 0);
                        gapComposer3.updateRememberedValue(objRememberedValue4);
                    }
                    Function1 function2 = (Function1) objRememberedValue4;
                    boolean zChangedInstance5 = gapComposer3.changedInstance(listenTogetherManager);
                    Object objRememberedValue5 = gapComposer3.rememberedValue();
                    if (zChangedInstance5 || objRememberedValue5 == neverEqualPolicy) {
                        objRememberedValue5 = new ListenTogetherScreenKt$$ExternalSyntheticLambda35(listenTogetherManager, (byte) 1);
                        gapComposer3.updateRememberedValue(objRememberedValue5);
                    }
                    ListenTogetherScreenKt.PendingJoinRequestsSection(list, function2, (Function1) objRememberedValue5, gapComposer3, 0);
                } else {
                    gapComposer3.skipToGroupEnd();
                }
                return unit;
            default:
                Composer composer4 = (Composer) obj2;
                int iIntValue4 = ((Integer) obj3).intValue();
                ((LazyItemScopeImpl) obj).getClass();
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 17) != 16)) {
                    List list2 = (List) state.getValue();
                    boolean zChangedInstance6 = gapComposer4.changedInstance(listenTogetherManager);
                    Object objRememberedValue6 = gapComposer4.rememberedValue();
                    if (zChangedInstance6 || objRememberedValue6 == neverEqualPolicy) {
                        objRememberedValue6 = new ListenTogetherScreenKt$$ExternalSyntheticLambda35(listenTogetherManager, (byte) 2);
                        gapComposer4.updateRememberedValue(objRememberedValue6);
                    }
                    Function1 function3 = (Function1) objRememberedValue6;
                    boolean zChangedInstance7 = gapComposer4.changedInstance(listenTogetherManager);
                    Object objRememberedValue7 = gapComposer4.rememberedValue();
                    if (zChangedInstance7 || objRememberedValue7 == neverEqualPolicy) {
                        objRememberedValue7 = new ListenTogetherScreenKt$$ExternalSyntheticLambda35(listenTogetherManager, (byte) 3);
                        gapComposer4.updateRememberedValue(objRememberedValue7);
                    }
                    ListenTogetherScreenKt.PendingSuggestionsSection(list2, function3, (Function1) objRememberedValue7, gapComposer4, 0);
                } else {
                    gapComposer4.skipToGroupEnd();
                }
                return unit;
        }
    }

    public /* synthetic */ PlayerMenuKt$$ExternalSyntheticLambda71(ListenTogetherManager listenTogetherManager, State state, byte b) {
        this.$r8$classId = b;
        this.f$1 = listenTogetherManager;
        this.f$0 = state;
    }
}
