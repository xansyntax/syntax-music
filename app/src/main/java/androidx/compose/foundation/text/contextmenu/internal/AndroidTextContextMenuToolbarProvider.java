package androidx.compose.foundation.text.contextmenu.internal;

import android.R;
import android.os.Build;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuComponent;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuData;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuItem;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuKeys;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSeparator;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSession;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuTextClassificationItem;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuDataProvider;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuProvider;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import androidx.media3.common.util.Util$$ExternalSyntheticLambda1;
import com.metrolist.innertubex.InnerTube$executeMutation$2$1;
import dagger.hilt.EntryPoints;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferedChannel;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidTextContextMenuToolbarProvider implements TextContextMenuProvider {
    public ActionMode actionMode;
    public final Function1 callbackInjector;
    public final Function0 coordinatesProvider;
    public Runnable finishActionModeRunnable;
    public Util$$ExternalSyntheticLambda1 startActionModeRunnable;
    public final View view;
    public final MutatorMutex mutatorMutex = new MutatorMutex();
    public final SnapshotStateObserver snapshotStateObserver = new SnapshotStateObserver(new AndroidTextContextMenuToolbarProvider$$ExternalSyntheticLambda0(this, 0));
    public final AndroidTextContextMenuToolbarProvider$$ExternalSyntheticLambda0 onDataChange = new AndroidTextContextMenuToolbarProvider$$ExternalSyntheticLambda0(this, 1);
    public final AndroidTextContextMenuToolbarProvider$$ExternalSyntheticLambda0 onPositionChange = new AndroidTextContextMenuToolbarProvider$$ExternalSyntheticLambda0(this, 2);

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class TextActionModeCallbackImpl {
        public final AndroidTextContextMenuToolbarProvider$$ExternalSyntheticLambda3 dataBuilder;
        public final AndroidTextContextMenuToolbarProvider$$ExternalSyntheticLambda3 positioner;
        public final TextContextMenuSessionImpl session;
        public final View view;

        public TextActionModeCallbackImpl(TextContextMenuSessionImpl textContextMenuSessionImpl, AndroidTextContextMenuToolbarProvider$$ExternalSyntheticLambda3 androidTextContextMenuToolbarProvider$$ExternalSyntheticLambda3, AndroidTextContextMenuToolbarProvider$$ExternalSyntheticLambda3 androidTextContextMenuToolbarProvider$$ExternalSyntheticLambda4, View view) {
            this.session = textContextMenuSessionImpl;
            this.dataBuilder = androidTextContextMenuToolbarProvider$$ExternalSyntheticLambda3;
            this.positioner = androidTextContextMenuToolbarProvider$$ExternalSyntheticLambda4;
            this.view = view;
        }

        public final boolean updateMenuItems(Menu menu) {
            int i;
            TextContextMenuData textContextMenuData = (TextContextMenuData) this.dataBuilder.invoke();
            if (Intrinsics.areEqual(textContextMenuData, (Object) null)) {
                return false;
            }
            menu.clear();
            List list = textContextMenuData.components;
            int size = list.size();
            int i2 = 1;
            int i3 = 1;
            for (int i4 = 0; i4 < size; i4++) {
                TextContextMenuComponent textContextMenuComponent = (TextContextMenuComponent) list.get(i4);
                if (textContextMenuComponent instanceof TextContextMenuItem) {
                    int i5 = i2 + 1;
                    Object obj = textContextMenuComponent.key;
                    if (Intrinsics.areEqual(obj, TextContextMenuKeys.CutKey)) {
                        i = R.id.cut;
                    } else if (Intrinsics.areEqual(obj, TextContextMenuKeys.CopyKey)) {
                        i = R.id.copy;
                    } else if (Intrinsics.areEqual(obj, TextContextMenuKeys.PasteKey)) {
                        i = R.id.paste;
                    } else if (Intrinsics.areEqual(obj, TextContextMenuKeys.SelectAllKey)) {
                        i = R.id.selectAll;
                    } else {
                        i = Intrinsics.areEqual(obj, TextContextMenuKeys.AutofillKey) ? R.id.autofill : i2;
                    }
                    TextContextMenuItem textContextMenuItem = (TextContextMenuItem) textContextMenuComponent;
                    MenuItem menuItemAdd = menu.add(i3, i, i2, textContextMenuItem.label);
                    menuItemAdd.setShowAsAction(2);
                    menuItemAdd.setOnMenuItemClickListener(new TextToolbarHelperApi28$$ExternalSyntheticLambda0(textContextMenuItem, this, (byte) 1));
                    i2 = i5;
                } else if (textContextMenuComponent instanceof TextContextMenuTextClassificationItem) {
                    if (Build.VERSION.SDK_INT >= 28) {
                        TextContextMenuTextClassificationItem textContextMenuTextClassificationItem = (TextContextMenuTextClassificationItem) textContextMenuComponent;
                        TextToolbarHelperApi28.addMenuItem(menu, i2, this.view.getContext(), textContextMenuTextClassificationItem.textClassification, textContextMenuTextClassificationItem.index, textContextMenuTextClassificationItem.icon);
                        i2++;
                    }
                } else if (textContextMenuComponent instanceof TextContextMenuSeparator) {
                    i3++;
                }
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class TextContextMenuSessionImpl implements TextContextMenuSession {
        public final BufferedChannel channel = EntryPoints.Channel$default(0, 7, null);

        @Override // androidx.compose.foundation.text.contextmenu.data.TextContextMenuSession
        public final void close() {
            this.channel.mo1712trySendJP2dKIU(Unit.INSTANCE);
        }
    }

    public AndroidTextContextMenuToolbarProvider(View view, Function1 function1, Function0 function0) {
        this.view = view;
        this.callbackInjector = function1;
        this.coordinatesProvider = function0;
    }

    @Override // androidx.compose.foundation.text.contextmenu.provider.TextContextMenuProvider
    public final Object showTextContextMenu(TextContextMenuDataProvider textContextMenuDataProvider, SuspendLambda suspendLambda) {
        Object objMutate = this.mutatorMutex.mutate(MutatePriority.Default, new InnerTube$executeMutation$2$1(this, textContextMenuDataProvider, null, (byte) 2), suspendLambda);
        return objMutate == CoroutineSingletons.COROUTINE_SUSPENDED ? objMutate : Unit.INSTANCE;
    }
}
