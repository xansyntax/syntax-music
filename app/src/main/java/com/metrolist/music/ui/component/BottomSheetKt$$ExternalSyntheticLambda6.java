package com.metrolist.music.ui.component;

import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.EnterTransitionImpl;
import androidx.compose.animation.ExitTransitionImpl;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.Modifier;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class BottomSheetKt$$ExternalSyntheticLambda6 implements Function2 {
    public final /* synthetic */ byte $r8$classId = 1;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Modifier f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ ComposableLambdaImpl f$4;
    public final /* synthetic */ boolean f$5;
    public final /* synthetic */ Object f$6;
    public final /* synthetic */ int f$7;
    public final /* synthetic */ byte f$8;

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ BottomSheetKt$$ExternalSyntheticLambda6(ColumnScopeInstance columnScopeInstance, boolean z, Modifier modifier, EnterTransitionImpl enterTransitionImpl, ExitTransitionImpl exitTransitionImpl, String str, ComposableLambdaImpl composableLambdaImpl, int i, int i2) {
        this.f$0 = columnScopeInstance;
        this.f$5 = z;
        this.f$1 = modifier;
        this.f$2 = enterTransitionImpl;
        this.f$3 = exitTransitionImpl;
        this.f$6 = str;
        this.f$4 = composableLambdaImpl;
        this.f$7 = i;
        this.f$8 = i2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        int i = this.f$7;
        Object obj3 = this.f$6;
        Object obj4 = this.f$3;
        Object obj5 = this.f$2;
        Object obj6 = this.f$0;
        switch (b) {
            case 0:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                DialogKt.BottomSheet((BottomSheetState) obj6, this.f$1, (Function3) obj5, (Function0) obj4, this.f$4, this.f$5, (ComposableLambdaImpl) obj3, (Composer) obj, iUpdateChangedFlags, this.f$8);
                break;
            default:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags2 = Stack.updateChangedFlags(i | 1);
                CrossfadeKt.AnimatedVisibility((ColumnScopeInstance) obj6, this.f$5, this.f$1, (EnterTransitionImpl) obj5, (ExitTransitionImpl) obj4, (String) obj3, this.f$4, (Composer) obj, iUpdateChangedFlags2, this.f$8);
                break;
        }
        return unit;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ BottomSheetKt$$ExternalSyntheticLambda6(BottomSheetState bottomSheetState, Modifier modifier, Function3 function3, Function0 function0, ComposableLambdaImpl composableLambdaImpl, boolean z, ComposableLambdaImpl composableLambdaImpl2, int i, int i2) {
        this.f$0 = bottomSheetState;
        this.f$1 = modifier;
        this.f$2 = function3;
        this.f$3 = function0;
        this.f$4 = composableLambdaImpl;
        this.f$5 = z;
        this.f$6 = composableLambdaImpl2;
        this.f$7 = i;
        this.f$8 = i2;
    }
}
