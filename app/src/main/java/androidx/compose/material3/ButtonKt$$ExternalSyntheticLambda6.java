package androidx.compose.material3;

import androidx.compose.animation.CrossfadeKt$$ExternalSyntheticLambda3;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.navigation.NavHostController;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda39;
import com.metrolist.music.constants.LibraryViewType;
import com.metrolist.music.ui.component.AppNavigationKt;
import com.metrolist.music.ui.component.DialogKt;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda32;
import com.metrolist.music.ui.screens.LoginScreenKt$$ExternalSyntheticLambda3;
import com.metrolist.music.ui.screens.Screens;
import com.metrolist.music.ui.screens.equalizer.EqScreenKt;
import com.metrolist.music.ui.screens.library.LibraryScreenKt;
import com.metrolist.music.ui.screens.search.SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$2;
import com.metrolist.music.viewmodels.LibraryPlaylistsViewModel;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ButtonKt$$ExternalSyntheticLambda6 implements Function2 {
    public final /* synthetic */ byte $r8$classId = 3;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ boolean f$3;
    public final /* synthetic */ Object f$4;
    public final /* synthetic */ Object f$7;

    public /* synthetic */ ButtonKt$$ExternalSyntheticLambda6(NavHostController navHostController, ComposableLambdaImpl composableLambdaImpl, LibraryViewType libraryViewType, Function1 function1, LibraryPlaylistsViewModel libraryPlaylistsViewModel, boolean z, int i) {
        this.f$0 = navHostController;
        this.f$1 = composableLambdaImpl;
        this.f$2 = libraryViewType;
        this.f$4 = function1;
        this.f$7 = libraryPlaylistsViewModel;
        this.f$3 = z;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        long j;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj3 = this.f$7;
        Object obj4 = this.f$4;
        Object obj5 = this.f$2;
        Object obj6 = this.f$1;
        Object obj7 = this.f$0;
        switch (b) {
            case 0:
                ((Integer) obj2).getClass();
                CardKt.TextButton((Function0) obj7, (ButtonShapes) obj6, (Modifier) obj5, this.f$3, (ButtonColors) obj4, (PaddingValues) obj3, (Composer) obj, Stack.updateChangedFlags(805306369));
                break;
            case 1:
                ((Integer) obj2).getClass();
                AppNavigationKt.NavLongPress((Screens) obj6, (MutableInteractionSourceImpl) obj5, this.f$3, (Function2) obj4, (Function0) obj7, (Function0) obj3, (Composer) obj, Stack.updateChangedFlags(49));
                break;
            case 2:
                Function0 function0 = (Function0) obj7;
                Function0 function1 = (Function0) obj6;
                Function0 function2 = (Function0) obj5;
                Function0 function3 = (Function0) obj4;
                Function0 function4 = (Function0) obj3;
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    com.metrolist.music.ui.component.MenuKt.m1493TopAppBarGHTll3U(EqScreenKt.lambda$1932578738, null, Expect_jvmKt.rememberComposableLambda(-816304656, new MainActivity$$ExternalSyntheticLambda39(function0, (byte) 11), gapComposer), Expect_jvmKt.rememberComposableLambda(-1684869529, new SongMenuKt$$ExternalSyntheticLambda32(function1, this.f$3, function2, function3, function4), gapComposer), CropImageView.DEFAULT_ASPECT_RATIO, null, null, null, gapComposer, 3462, 242);
                }
                break;
            case 3:
                ((Integer) obj2).getClass();
                LibraryScreenKt.LibraryPlaylistsScreen((NavHostController) obj7, (ComposableLambdaImpl) obj6, (LibraryViewType) obj5, (Function1) obj4, (LibraryPlaylistsViewModel) obj3, this.f$3, (Composer) obj, Stack.updateChangedFlags(49));
                break;
            default:
                FocusRequester focusRequester = (FocusRequester) obj7;
                Function1 function5 = (Function1) obj6;
                MutableState mutableState = (MutableState) obj5;
                MutableState mutableState2 = (MutableState) obj4;
                NavHostController navHostController = (NavHostController) obj3;
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    Modifier modifierM1473hairlineBottomiJQMabo = DialogKt.m1473hairlineBottomiJQMabo(Modifier.Companion.$$INSTANCE, gapComposer2, 6);
                    PaddingValuesImpl paddingValuesImpl = TopAppBarDefaults.ContentPadding;
                    if (this.f$3) {
                        gapComposer2.startReplaceGroup(-790498739);
                        gapComposer2.end(false);
                        j = -72057594037927936L;
                    } else {
                        gapComposer2.startReplaceGroup(-790497550);
                        j = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.background;
                        gapComposer2.end(false);
                    }
                    com.metrolist.music.ui.component.MenuKt.m1493TopAppBarGHTll3U(Expect_jvmKt.rememberComposableLambda(-1545158140, new CrossfadeKt$$ExternalSyntheticLambda3(focusRequester, function5, mutableState, mutableState2, (byte) 14), gapComposer2), modifierM1473hairlineBottomiJQMabo, Expect_jvmKt.rememberComposableLambda(2059977666, new LoginScreenKt$$ExternalSyntheticLambda3(navHostController, (byte) 18), gapComposer2), null, CropImageView.DEFAULT_ASPECT_RATIO, null, TopAppBarDefaults.m363topAppBarColors5tl4gsc(j, 0L, 0L, 0L, 0L, gapComposer2, 62), null, gapComposer2, 390, 184);
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ ButtonKt$$ExternalSyntheticLambda6(Screens screens, MutableInteractionSourceImpl mutableInteractionSourceImpl, boolean z, Function2 function2, Function0 function0, Function0 function1, int i) {
        this.f$1 = screens;
        this.f$2 = mutableInteractionSourceImpl;
        this.f$3 = z;
        this.f$4 = function2;
        this.f$0 = function0;
        this.f$7 = function1;
    }

    public /* synthetic */ ButtonKt$$ExternalSyntheticLambda6(Function0 function0, ButtonShapes buttonShapes, Modifier modifier, boolean z, ButtonColors buttonColors, PaddingValues paddingValues, int i) {
        this.f$0 = function0;
        this.f$1 = buttonShapes;
        this.f$2 = modifier;
        this.f$3 = z;
        this.f$4 = buttonColors;
        this.f$7 = paddingValues;
    }

    public /* synthetic */ ButtonKt$$ExternalSyntheticLambda6(Function0 function0, Function0 function1, boolean z, Function0 function2, Function0 function3, Function0 function4) {
        this.f$0 = function0;
        this.f$1 = function1;
        this.f$3 = z;
        this.f$2 = function2;
        this.f$4 = function3;
        this.f$7 = function4;
    }

    public /* synthetic */ ButtonKt$$ExternalSyntheticLambda6(boolean z, FocusRequester focusRequester, Function1 function1, MutableState mutableState, SearchScreenKt$SearchScreen$$inlined$rememberEnumPreference$2 searchScreenKt$SearchScreen$$inlined$rememberEnumPreference$2, NavHostController navHostController) {
        this.f$3 = z;
        this.f$0 = focusRequester;
        this.f$1 = function1;
        this.f$2 = mutableState;
        this.f$4 = searchScreenKt$SearchScreen$$inlined$rememberEnumPreference$2;
        this.f$7 = navHostController;
    }
}
