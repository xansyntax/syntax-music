package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.layout.Arrangement$Horizontal;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import com.metrolist.music.constants.LibraryViewType;
import com.metrolist.music.constants.PlaylistSortType;
import com.metrolist.music.eq.data.SavedEQProfile;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda16;
import com.metrolist.music.ui.screens.equalizer.EqScreenKt;
import com.metrolist.music.viewmodels.LibraryPlaylistsViewModel;
import com.yalantis.ucrop.view.CropImageView;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.JobKt__JobKt$invokeOnCompletion$1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ChipKt$$ExternalSyntheticLambda0 implements Function2 {
    public final /* synthetic */ byte $r8$classId = 2;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$10;
    public final /* synthetic */ Object f$11;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ boolean f$3;
    public final /* synthetic */ Object f$5;
    public final /* synthetic */ Object f$6;
    public final /* synthetic */ Object f$7;
    public final /* synthetic */ Object f$8;
    public final /* synthetic */ Object f$9;

    public /* synthetic */ ChipKt$$ExternalSyntheticLambda0(LibraryPlaylistsViewModel libraryPlaylistsViewModel, MutableState mutableState, SoftwareKeyboardController softwareKeyboardController, MutableState mutableState2, PlaylistSortType playlistSortType, boolean z, Function1 function1, Function1 function2, List list, Function1 function3, LibraryViewType libraryViewType) {
        this.f$0 = libraryPlaylistsViewModel;
        this.f$1 = mutableState;
        this.f$2 = softwareKeyboardController;
        this.f$5 = mutableState2;
        this.f$6 = playlistSortType;
        this.f$3 = z;
        this.f$7 = function1;
        this.f$8 = function2;
        this.f$9 = list;
        this.f$10 = function3;
        this.f$11 = libraryViewType;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj3 = this.f$11;
        Object obj4 = this.f$10;
        Object obj5 = this.f$9;
        Object obj6 = this.f$8;
        Object obj7 = this.f$7;
        Object obj8 = this.f$6;
        Object obj9 = this.f$5;
        Object obj10 = this.f$2;
        Object obj11 = this.f$1;
        Object obj12 = this.f$0;
        switch (b) {
            case 0:
                ((Integer) obj2).getClass();
                ChipKt.AssistChip((Function0) obj12, (ComposableLambdaImpl) obj11, (Modifier) obj10, this.f$3, (Function2) obj9, (Shape) obj8, (ChipColors) obj7, (ChipElevation) obj6, (BorderStroke) obj5, (Arrangement$Horizontal) obj4, (PaddingValues) obj3, (Composer) obj, Stack.updateChangedFlags(196663));
                break;
            case 1:
                ((Integer) obj2).getClass();
                EqScreenKt.EqScreenContent((List) obj11, (String) obj10, (SavedEQProfile) obj9, (Function1) obj8, (Function0) obj12, this.f$3, (Function0) obj7, (Function0) obj6, (Function0) obj5, (Function0) obj4, (Function1) obj3, (Composer) obj, Stack.updateChangedFlags(14156289));
                break;
            default:
                LibraryPlaylistsViewModel libraryPlaylistsViewModel = (LibraryPlaylistsViewModel) obj12;
                MutableState mutableState = (MutableState) obj11;
                SoftwareKeyboardController softwareKeyboardController = (SoftwareKeyboardController) obj10;
                MutableState mutableState2 = (MutableState) obj9;
                PlaylistSortType playlistSortType = (PlaylistSortType) obj8;
                Function1 function1 = (Function1) obj7;
                Function1 function2 = (Function1) obj6;
                List list = (List) obj5;
                Function1 function3 = (Function1) obj4;
                LibraryViewType libraryViewType = (LibraryViewType) obj3;
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    boolean zBooleanValue = ((Boolean) mutableState.getValue()).booleanValue();
                    String str = (String) mutableState2.getValue();
                    boolean zChangedInstance = gapComposer.changedInstance(libraryPlaylistsViewModel);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                    if (zChangedInstance || objRememberedValue == neverEqualPolicy) {
                        JobKt__JobKt$invokeOnCompletion$1 jobKt__JobKt$invokeOnCompletion$1 = new JobKt__JobKt$invokeOnCompletion$1(1, libraryPlaylistsViewModel, LibraryPlaylistsViewModel.class, "updateSearchQuery", "updateSearchQuery(Ljava/lang/String;)V", 0, (byte) 2);
                        gapComposer.updateRememberedValue(jobKt__JobKt$invokeOnCompletion$1);
                        objRememberedValue = jobKt__JobKt$invokeOnCompletion$1;
                    }
                    Function1 function4 = (Function1) ((KFunction) objRememberedValue);
                    boolean zChanged = gapComposer.changed(mutableState) | gapComposer.changedInstance(libraryPlaylistsViewModel);
                    Object objRememberedValue2 = gapComposer.rememberedValue();
                    if (zChanged || objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new QueueKt$$ExternalSyntheticLambda16(libraryPlaylistsViewModel, mutableState, (byte) 15);
                        gapComposer.updateRememberedValue(objRememberedValue2);
                    }
                    com.metrolist.music.ui.component.MenuKt.LibrarySearchHeader(zBooleanValue, str, function4, (Function0) objRememberedValue2, softwareKeyboardController, OffsetKt.m139paddingqDBjuR0$default(Modifier.Companion.$$INSTANCE, 16.0f, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 14), Expect_jvmKt.rememberComposableLambda(-683505800, new TimePickerKt$$ExternalSyntheticLambda8(playlistSortType, this.f$3, function1, function2, list, mutableState, function3, libraryViewType), gapComposer), gapComposer, 1769472);
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ ChipKt$$ExternalSyntheticLambda0(List list, String str, SavedEQProfile savedEQProfile, Function1 function1, Function0 function0, boolean z, Function0 function2, Function0 function3, Function0 function4, Function0 function5, Function1 function6, int i) {
        this.f$1 = list;
        this.f$2 = str;
        this.f$5 = savedEQProfile;
        this.f$6 = function1;
        this.f$0 = function0;
        this.f$3 = z;
        this.f$7 = function2;
        this.f$8 = function3;
        this.f$9 = function4;
        this.f$10 = function5;
        this.f$11 = function6;
    }

    public /* synthetic */ ChipKt$$ExternalSyntheticLambda0(Function0 function0, ComposableLambdaImpl composableLambdaImpl, Modifier modifier, boolean z, Function2 function2, Shape shape, ChipColors chipColors, ChipElevation chipElevation, BorderStroke borderStroke, Arrangement$Horizontal arrangement$Horizontal, PaddingValues paddingValues, int i) {
        this.f$0 = function0;
        this.f$1 = composableLambdaImpl;
        this.f$2 = modifier;
        this.f$3 = z;
        this.f$5 = function2;
        this.f$6 = shape;
        this.f$7 = chipColors;
        this.f$8 = chipElevation;
        this.f$9 = borderStroke;
        this.f$10 = arrangement$Horizontal;
        this.f$11 = paddingValues;
    }
}
