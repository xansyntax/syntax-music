package androidx.compose.ui.window;

import android.view.ActionMode;
import android.view.View;
import androidx.activity.OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0;
import androidx.activity.compose.ActivityResultLauncherHolder;
import androidx.activity.result.ActivityResultRegistry;
import androidx.compose.animation.core.SeekableTransitionState;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionInstance;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory;
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnableItem;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.foundation.text.contextmenu.internal.AndroidTextContextMenuToolbarProvider;
import androidx.compose.foundation.text.contextmenu.provider.BasicTextContextMenuProvider;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.material3.ExposedDropdownMenu_androidKt$SoftKeyboardListener$1$1$listener$1;
import androidx.compose.material3.ModalBottomSheetDialogWrapper;
import androidx.compose.material3.TooltipStateImpl;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.Latch;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import androidx.media3.extractor.flv.TagPayloadReader;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.yalantis.ucrop.R;
import kotlinx.coroutines.CancellableContinuationImpl;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidPopup_androidKt$Popup$lambda$3$0$$inlined$onDispose$1 implements DisposableEffectResult {
    public final /* synthetic */ Object $popupLayout$inlined;
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ AndroidPopup_androidKt$Popup$lambda$3$0$$inlined$onDispose$1(byte b, Object obj) {
        this.$r8$classId = b;
        this.$popupLayout$inlined = obj;
    }

    @Override // androidx.compose.runtime.DisposableEffectResult
    public final void dispose() {
        byte b = this.$r8$classId;
        Object obj = this.$popupLayout$inlined;
        switch (b) {
            case 0:
                PopupLayout popupLayout = (PopupLayout) obj;
                popupLayout.disposeComposition();
                popupLayout.setTag(R.id.view_tree_lifecycle_owner, null);
                popupLayout.windowManager.removeViewImmediate(popupLayout);
                break;
            case 1:
                ActivityResultRegistry.AnonymousClass2 anonymousClass2 = ((ActivityResultLauncherHolder) obj).launcher;
                if (anonymousClass2 == null) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Launcher has not been initialized");
                } else {
                    anonymousClass2.unregister();
                }
                break;
            case 2:
                ((SeekableTransitionState) ((TagPayloadReader) obj)).setSnapshotStateObserver$animation_core(null);
                break;
            case 3:
                Transition transition = (Transition) obj;
                transition.onTransitionEnd$animation_core();
                transition.transitionState.transitionRemoved$animation_core();
                break;
            case 4:
                TransitionInstance transitionInstance = (TransitionInstance) obj;
                transitionInstance.onTransitionEnd$animation_core();
                transitionInstance.transitionState.transitionRemoved$animation_core();
                break;
            case 5:
                ((LazyLayoutItemContentFactory.CachedItemContent) obj)._content = null;
                break;
            case 6:
                LazyLayoutPrefetchState lazyLayoutPrefetchState = (LazyLayoutPrefetchState) obj;
                Latch latch = lazyLayoutPrefetchState.prefetchHandleProvider;
                if (latch != null) {
                    latch._isOpen = false;
                }
                lazyLayoutPrefetchState.prefetchHandleProvider = null;
                break;
            case 7:
                LazyLayoutPinnableItem lazyLayoutPinnableItem = (LazyLayoutPinnableItem) obj;
                lazyLayoutPinnableItem.isDisposed = true;
                lazyLayoutPinnableItem.pinsCount = 0;
                lazyLayoutPinnableItem.pinnedItemList.items.remove(lazyLayoutPinnableItem);
                LazyLayoutPinnableItem lazyLayoutPinnableItem2 = lazyLayoutPinnableItem.parentHandle;
                if (lazyLayoutPinnableItem2 != null) {
                    lazyLayoutPinnableItem2.release();
                }
                lazyLayoutPinnableItem.parentHandle = null;
                break;
            case 8:
                ((TextFieldSelectionManager) obj).hideSelectionToolbar$foundation();
                break;
            case 9:
                AndroidTextContextMenuToolbarProvider androidTextContextMenuToolbarProvider = (AndroidTextContextMenuToolbarProvider) obj;
                SnapshotStateObserver snapshotStateObserver = androidTextContextMenuToolbarProvider.snapshotStateObserver;
                OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0 onBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0 = snapshotStateObserver.applyUnsubscribe;
                if (onBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0 != null) {
                    onBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0.dispose();
                }
                snapshotStateObserver.clear();
                ActionMode actionMode = androidTextContextMenuToolbarProvider.actionMode;
                if (actionMode != null) {
                    actionMode.finish();
                }
                androidTextContextMenuToolbarProvider.actionMode = null;
                break;
            case 10:
                BasicTextContextMenuProvider.SessionImpl sessionImpl = (BasicTextContextMenuProvider.SessionImpl) ((BasicTextContextMenuProvider) obj).session$delegate.getValue();
                if (sessionImpl != null) {
                    sessionImpl.close();
                }
                break;
            case 11:
                ExposedDropdownMenu_androidKt$SoftKeyboardListener$1$1$listener$1 exposedDropdownMenu_androidKt$SoftKeyboardListener$1$1$listener$1 = (ExposedDropdownMenu_androidKt$SoftKeyboardListener$1$1$listener$1) obj;
                View view = exposedDropdownMenu_androidKt$SoftKeyboardListener$1$1$listener$1.$view;
                if (exposedDropdownMenu_androidKt$SoftKeyboardListener$1$1$listener$1.isListeningToGlobalLayout) {
                    view.getViewTreeObserver().removeOnGlobalLayoutListener(exposedDropdownMenu_androidKt$SoftKeyboardListener$1$1$listener$1);
                    exposedDropdownMenu_androidKt$SoftKeyboardListener$1$1$listener$1.isListeningToGlobalLayout = false;
                }
                view.removeOnAttachStateChangeListener(exposedDropdownMenu_androidKt$SoftKeyboardListener$1$1$listener$1);
                break;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                ModalBottomSheetDialogWrapper modalBottomSheetDialogWrapper = (ModalBottomSheetDialogWrapper) obj;
                modalBottomSheetDialogWrapper.dismiss();
                modalBottomSheetDialogWrapper.dialogLayout.disposeComposition();
                break;
            case 13:
                CancellableContinuationImpl cancellableContinuationImpl = ((TooltipStateImpl) obj).job;
                if (cancellableContinuationImpl != null) {
                    cancellableContinuationImpl.cancel(null);
                }
                break;
            default:
                DialogWrapper dialogWrapper = (DialogWrapper) obj;
                dialogWrapper.dismiss();
                dialogWrapper.dialogLayout.disposeComposition();
                break;
        }
    }
}
