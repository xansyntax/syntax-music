package androidx.compose.foundation.text.contextmenu.modifier;

import androidx.collection.MutableObjectList;
import androidx.compose.foundation.ScrollState$$ExternalSyntheticLambda0;
import androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda7;
import androidx.compose.foundation.text.contextmenu.builder.TextContextMenuBuilderScope;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuComponent;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuData;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSeparator;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager$contextMenuAreaModifier$3;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager$paste$1;
import androidx.compose.material3.ButtonKt$$ExternalSyntheticLambda1;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.platform.WeakCache;
import coil3.network.NetworkFetcher;
import com.metrolist.music.utils.SyncUtils$executeSyncPlaylist$2;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class TextContextMenuModifierKt {
    public static final Modifier addTextContextMenuComponentsWithContext(Modifier modifier, ButtonKt$$ExternalSyntheticLambda1 buttonKt$$ExternalSyntheticLambda1) {
        return modifier.then(new AddTextContextMenuDataComponentsWithContextElement(buttonKt$$ExternalSyntheticLambda1));
    }

    public static final TextContextMenuData collectTextContextMenuData(DelegatableNode delegatableNode) {
        TextContextMenuSeparator textContextMenuSeparator;
        TextContextMenuBuilderScope textContextMenuBuilderScope = new TextContextMenuBuilderScope();
        HitTestResultKt.traverseAncestors(delegatableNode, TextContextMenuDataTraverseKey.INSTANCE, new ScrollState$$ExternalSyntheticLambda0(new ScrollState$$ExternalSyntheticLambda0((byte) 25, textContextMenuBuilderScope), new NetworkFetcher.AnonymousClass2(1, textContextMenuBuilderScope, TextContextMenuBuilderScope.class, "addFilter", "addFilter$foundation(Lkotlin/jvm/functions/Function1;)V", 0, (byte) 4), (byte) 26));
        MutableObjectList mutableObjectList = new MutableObjectList();
        MutableObjectList mutableObjectList2 = textContextMenuBuilderScope.components;
        Object[] objArr = mutableObjectList2.content;
        int i = mutableObjectList2._size;
        int i2 = 0;
        boolean z = true;
        TextContextMenuComponent textContextMenuComponent = null;
        while (true) {
            textContextMenuSeparator = TextContextMenuSeparator.INSTANCE;
            if (i2 >= i) {
                break;
            }
            TextContextMenuComponent textContextMenuComponent2 = (TextContextMenuComponent) objArr[i2];
            if (!z || textContextMenuComponent2 != textContextMenuSeparator) {
                if (textContextMenuComponent2 == textContextMenuSeparator && textContextMenuComponent == textContextMenuSeparator) {
                    z = false;
                } else {
                    if (textContextMenuComponent2 != textContextMenuSeparator) {
                        MutableObjectList mutableObjectList3 = textContextMenuBuilderScope.filters;
                        Object[] objArr2 = mutableObjectList3.content;
                        int i3 = mutableObjectList3._size;
                        int i4 = 0;
                        while (true) {
                            if (i4 < i3) {
                                if (((Boolean) ((Function1) objArr2[i4]).invoke(textContextMenuComponent2)).booleanValue()) {
                                    i4++;
                                } else {
                                    z = false;
                                }
                            }
                        }
                    }
                    mutableObjectList.add(textContextMenuComponent2);
                    z = false;
                    textContextMenuComponent = textContextMenuComponent2;
                }
            }
            i2++;
        }
        if (((TextContextMenuComponent) (mutableObjectList.isEmpty() ? null : mutableObjectList.content[mutableObjectList._size - 1])) == textContextMenuSeparator) {
            mutableObjectList.removeAt(mutableObjectList._size - 1);
        }
        MutableObjectList.ObjectListMutableList objectListMutableList = mutableObjectList.list;
        if (objectListMutableList == null) {
            objectListMutableList = new MutableObjectList.ObjectListMutableList((byte) 0, mutableObjectList);
            mutableObjectList.list = objectListMutableList;
        }
        return new TextContextMenuData(objectListMutableList);
    }

    public static final Modifier showTextContextMenuOnSecondaryClick(TextFieldSelectionManager$paste$1 textFieldSelectionManager$paste$1) {
        return new TextContextMenuGestureElement(textFieldSelectionManager$paste$1);
    }

    public static final Modifier textContextMenuToolbarHandler(Modifier modifier, WeakCache weakCache, SyncUtils$executeSyncPlaylist$2.AnonymousClass1 anonymousClass1, TextFieldSelectionManager$contextMenuAreaModifier$3 textFieldSelectionManager$contextMenuAreaModifier$3, CoreTextFieldKt$$ExternalSyntheticLambda7 coreTextFieldKt$$ExternalSyntheticLambda7) {
        return modifier.then(new TextContextMenuToolbarHandlerElement(weakCache, anonymousClass1, textFieldSelectionManager$contextMenuAreaModifier$3, coreTextFieldKt$$ExternalSyntheticLambda7));
    }
}
