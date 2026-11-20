package androidx.compose.material3;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.state.ToggleableState;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda9;
import io.ktor.util.StringValuesKt$$ExternalSyntheticLambda0;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MenuKt$$ExternalSyntheticLambda0 implements Function2 {
    public final /* synthetic */ byte $r8$classId = 1;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ boolean f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$5;

    public /* synthetic */ MenuKt$$ExternalSyntheticLambda0(int i, CheckboxColors checkboxColors, Modifier modifier, ToggleableState toggleableState, Function0 function0, boolean z) {
        this.f$0 = toggleableState;
        this.f$3 = function0;
        this.f$1 = modifier;
        this.f$2 = z;
        this.f$5 = checkboxColors;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj3 = this.f$5;
        Object obj4 = this.f$1;
        Object obj5 = this.f$3;
        Object obj6 = this.f$0;
        switch (b) {
            case 0:
                Function2 function2 = (Function2) obj6;
                MenuItemColors menuItemColors = (MenuItemColors) obj4;
                Function2 function3 = (Function2) obj5;
                ComposableLambdaImpl composableLambdaImpl = (ComposableLambdaImpl) obj3;
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(1 & iIntValue, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    boolean z = this.f$2;
                    if (function2 != null) {
                        gapComposer.startReplaceGroup(-864613344);
                        Stack.CompositionLocalProvider(Fragment$5$$ExternalSyntheticOutline0.m(z ? menuItemColors.leadingIconColor : menuItemColors.disabledLeadingIconColor, ContentColorKt.LocalContentColor), Expect_jvmKt.rememberComposableLambda(1241781204, new StringValuesKt$$ExternalSyntheticLambda0(function2, (byte) 3), gapComposer), gapComposer, 56);
                        gapComposer.end(false);
                    } else {
                        gapComposer.startReplaceGroup(-864297175);
                        gapComposer.end(false);
                    }
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = ContentColorKt.LocalContentColor;
                    Stack.CompositionLocalProvider(Fragment$5$$ExternalSyntheticOutline0.m(z ? menuItemColors.textColor : menuItemColors.disabledTextColor, staticProvidableCompositionLocal), Expect_jvmKt.rememberComposableLambda(-893579015, new MainActivity$$ExternalSyntheticLambda9((Object) function2, (Object) function3, (Object) composableLambdaImpl, (byte) 6), gapComposer), gapComposer, 56);
                    if (function3 == null) {
                        gapComposer.startReplaceGroup(-863079991);
                        gapComposer.end(false);
                    } else {
                        gapComposer.startReplaceGroup(-863399043);
                        Stack.CompositionLocalProvider(Fragment$5$$ExternalSyntheticOutline0.m(z ? menuItemColors.trailingIconColor : menuItemColors.disabledTrailingIconColor, staticProvidableCompositionLocal), Expect_jvmKt.rememberComposableLambda(-782441013, new StringValuesKt$$ExternalSyntheticLambda0(function3, (byte) 4), gapComposer), gapComposer, 56);
                        gapComposer.end(false);
                    }
                }
                break;
            case 1:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags = Stack.updateChangedFlags(1);
                CardKt.TriStateCheckbox(iUpdateChangedFlags, (CheckboxColors) obj3, (Composer) obj, (Modifier) obj4, (ToggleableState) obj6, (Function0) obj5, this.f$2);
                break;
            case 2:
                ((Integer) obj2).getClass();
                CardKt.FilledIconButton((Function0) obj6, (Modifier) obj5, this.f$2, (Shape) obj4, (IconButtonColors) obj3, (Composer) obj, Stack.updateChangedFlags(1572865));
                break;
            default:
                ((Integer) obj2).getClass();
                ((TextFieldDefaults) obj6).m349Container4EFweAY(this.f$2, (InteractionSource) obj5, (TextFieldColors) obj4, (Shape) obj3, (Composer) obj, Stack.updateChangedFlags(114822145));
                break;
        }
        return unit;
    }

    public /* synthetic */ MenuKt$$ExternalSyntheticLambda0(TextFieldDefaults textFieldDefaults, boolean z, InteractionSource interactionSource, TextFieldColors textFieldColors, Shape shape, int i) {
        this.f$0 = textFieldDefaults;
        this.f$2 = z;
        this.f$3 = interactionSource;
        this.f$1 = textFieldColors;
        this.f$5 = shape;
    }

    public /* synthetic */ MenuKt$$ExternalSyntheticLambda0(Function0 function0, Modifier modifier, boolean z, Shape shape, IconButtonColors iconButtonColors, int i) {
        this.f$0 = function0;
        this.f$3 = modifier;
        this.f$2 = z;
        this.f$1 = shape;
        this.f$5 = iconButtonColors;
    }

    public /* synthetic */ MenuKt$$ExternalSyntheticLambda0(Function2 function2, MenuItemColors menuItemColors, boolean z, Function2 function3, ComposableLambdaImpl composableLambdaImpl) {
        this.f$0 = function2;
        this.f$1 = menuItemColors;
        this.f$2 = z;
        this.f$3 = function3;
        this.f$5 = composableLambdaImpl;
    }
}
