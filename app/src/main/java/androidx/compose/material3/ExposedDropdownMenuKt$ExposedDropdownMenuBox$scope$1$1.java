package androidx.compose.material3;

import android.view.KeyEvent;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusTraversalKt;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import coil3.compose.internal.UtilsKt$$ExternalSyntheticLambda0;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda29;
import com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda49;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1 {
    public final /* synthetic */ MutableState $alwaysFocusable;
    public final /* synthetic */ MutableState $anchorTypeState;
    public final /* synthetic */ ParcelableSnapshotMutableIntState $anchorWidth$delegate;
    public final /* synthetic */ String $collapsedDescription;
    public final /* synthetic */ boolean $expanded;
    public final /* synthetic */ String $expandedDescription;
    public final /* synthetic */ FocusRequester $focusRequester;
    public final /* synthetic */ SoftwareKeyboardController $keyboardController;
    public final /* synthetic */ ParcelableSnapshotMutableIntState $menuMaxHeight$delegate;
    public final /* synthetic */ Function1 $onExpandedChange;
    public final /* synthetic */ String $toggleDescription;

    public ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1(FocusRequester focusRequester, boolean z, MutableState mutableState, String str, String str2, String str3, SoftwareKeyboardController softwareKeyboardController, MutableState mutableState2, Function1 function1, ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState, ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState2) {
        this.$focusRequester = focusRequester;
        this.$expanded = z;
        this.$alwaysFocusable = mutableState;
        this.$expandedDescription = str;
        this.$collapsedDescription = str2;
        this.$toggleDescription = str3;
        this.$keyboardController = softwareKeyboardController;
        this.$anchorTypeState = mutableState2;
        this.$onExpandedChange = function1;
        this.$anchorWidth$delegate = parcelableSnapshotMutableIntState;
        this.$menuMaxHeight$delegate = parcelableSnapshotMutableIntState2;
    }

    /* JADX INFO: renamed from: menuAnchor-2Hz36ac$default, reason: not valid java name */
    public static Modifier m286menuAnchor2Hz36ac$default(ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1 exposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1) {
        FocusRequester focusRequester = exposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1.$focusRequester;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        Modifier modifierFocusRequester = FocusTraversalKt.focusRequester(companion, focusRequester);
        MutableState mutableState = exposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1.$anchorTypeState;
        Modifier modifierThen = modifierFocusRequester.then(new ExposedDropdownMenuAnchorElement(new MainActivity$$ExternalSyntheticLambda29(mutableState, (byte) 10)));
        final boolean z = exposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1.$expanded;
        final PlayerKt$$ExternalSyntheticLambda49 playerKt$$ExternalSyntheticLambda49 = new PlayerKt$$ExternalSyntheticLambda49(mutableState, exposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1.$onExpandedChange, z);
        final MutableState mutableState2 = exposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1.$alwaysFocusable;
        String str = exposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1.$expandedDescription;
        String str2 = exposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1.$collapsedDescription;
        String str3 = exposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1.$toggleDescription;
        SoftwareKeyboardController softwareKeyboardController = exposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1.$keyboardController;
        return modifierThen.then(SemanticsModifierKt.semantics(Key.onPreviewKeyEvent(SuspendingPointerInputFilterKt.pointerInput(companion, playerKt$$ExternalSyntheticLambda49, new ScrimKt$Scrim$dismissModifier$1$1((byte) 8, playerKt$$ExternalSyntheticLambda49)), new Function1(z, mutableState2) { // from class: androidx.compose.material3.ExposedDropdownMenuKt$expandable$2
            public final /* synthetic */ MutableState $alwaysFocusable;

            {
                this.$alwaysFocusable = mutableState2;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                KeyEvent keyEvent = ((androidx.compose.ui.input.key.KeyEvent) obj).nativeKeyEvent;
                if (Key.m581getTypeZmokQxo(keyEvent) == 1 && (CardKt.m270isEnterMinusSpacebarZmokQxo(keyEvent) || Key.m579equalsimpl0(((long) keyEvent.getKeyCode()) << 32, 266287972352L))) {
                    this.$onExpandedChange.invoke();
                }
                Boolean bool = Boolean.FALSE;
                this.$alwaysFocusable.setValue(bool);
                return bool;
            }
        }), false, new UtilsKt$$ExternalSyntheticLambda0(z, str, str2, str3, exposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1.$focusRequester, playerKt$$ExternalSyntheticLambda49, softwareKeyboardController)));
    }
}
