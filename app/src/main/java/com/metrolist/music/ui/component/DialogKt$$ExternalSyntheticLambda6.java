package com.metrolist.music.ui.component;

import androidx.compose.animation.CrossfadeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import kotlin.Function;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class DialogKt$$ExternalSyntheticLambda6 implements Function2 {
    public final /* synthetic */ byte $r8$classId = 1;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Function f$3;
    public final /* synthetic */ Object f$4;
    public final /* synthetic */ Object f$5;
    public final /* synthetic */ ComposableLambdaImpl f$6;
    public final /* synthetic */ int f$7;
    public final /* synthetic */ byte f$8;

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ DialogKt$$ExternalSyntheticLambda6(Object obj, Modifier modifier, Function1 function1, Alignment alignment, String str, Function1 function2, ComposableLambdaImpl composableLambdaImpl, int i, int i2) {
        this.f$1 = obj;
        this.f$2 = modifier;
        this.f$3 = function1;
        this.f$4 = alignment;
        this.f$0 = str;
        this.f$5 = function2;
        this.f$6 = composableLambdaImpl;
        this.f$7 = i;
        this.f$8 = i2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Object obj3 = this.f$1;
        Unit unit = Unit.INSTANCE;
        int i = this.f$7;
        Object obj4 = this.f$5;
        Object obj5 = this.f$4;
        Function function = this.f$3;
        Object obj6 = this.f$0;
        Object obj7 = this.f$2;
        switch (b) {
            case 0:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                DialogKt.ActionPromptDialog((String) obj6, (Function3) obj3, (Function0) obj7, (Function0) function, (Function0) obj5, (Function0) obj4, this.f$6, (Composer) obj, iUpdateChangedFlags, this.f$8);
                break;
            case 1:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags2 = Stack.updateChangedFlags(i | 1);
                CrossfadeKt.AnimatedContent(this.f$1, (Modifier) obj7, (Function1) function, (Alignment) obj5, (String) obj6, (Function1) obj4, this.f$6, (Composer) obj, iUpdateChangedFlags2, this.f$8);
                break;
            default:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags3 = Stack.updateChangedFlags(i | 1);
                DialogKt.DefaultDialog((Function0) obj7, (Modifier) obj6, (Function2) function, (Function2) obj5, (Function3) obj3, (Alignment.Horizontal) obj4, this.f$6, (Composer) obj, iUpdateChangedFlags3, this.f$8);
                break;
        }
        return unit;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ DialogKt$$ExternalSyntheticLambda6(String str, Function3 function3, Function0 function0, Function0 function1, Function0 function2, Function0 function4, ComposableLambdaImpl composableLambdaImpl, int i, int i2) {
        this.f$0 = str;
        this.f$1 = function3;
        this.f$2 = function0;
        this.f$3 = function1;
        this.f$4 = function2;
        this.f$5 = function4;
        this.f$6 = composableLambdaImpl;
        this.f$7 = i;
        this.f$8 = i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ DialogKt$$ExternalSyntheticLambda6(Function0 function0, Modifier modifier, Function2 function2, Function2 function3, Function3 function4, Alignment.Horizontal horizontal, ComposableLambdaImpl composableLambdaImpl, int i, int i2) {
        this.f$2 = function0;
        this.f$0 = modifier;
        this.f$3 = function2;
        this.f$4 = function3;
        this.f$1 = function4;
        this.f$5 = horizontal;
        this.f$6 = composableLambdaImpl;
        this.f$7 = i;
        this.f$8 = i2;
    }
}
