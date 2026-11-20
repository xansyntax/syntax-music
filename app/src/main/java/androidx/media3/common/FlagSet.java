package androidx.media3.common;

import android.util.SparseBooleanArray;
import androidx.appcompat.app.ToolbarActionBar;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.appcompat.widget.ActionMenuView;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode;
import coil3.util.UtilsKt;
import java.util.Collections;
import kotlinx.serialization.json.internal.InternalJsonWriter;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FlagSet {
    public final SparseBooleanArray flags;

    public FlagSet(SparseBooleanArray sparseBooleanArray) {
        this.flags = sparseBooleanArray;
    }

    public final boolean containsAny(int... iArr) {
        for (int i : iArr) {
            if (this.flags.get(i)) {
                return true;
            }
        }
        return false;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FlagSet) {
            return this.flags.equals(((FlagSet) obj).flags);
        }
        return false;
    }

    public final int get(int i) {
        SparseBooleanArray sparseBooleanArray = this.flags;
        UtilsKt.checkElementIndex(i, sparseBooleanArray.size());
        return sparseBooleanArray.keyAt(i);
    }

    public final int hashCode() {
        return this.flags.hashCode();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public class Builder implements MenuPresenter.Callback {
        public boolean buildCalled;
        public Object flags;

        public Builder(byte b) {
            switch (b) {
                case 3:
                    this.buildCalled = true;
                    this.flags = Collections.singletonList(null);
                    break;
                default:
                    this.flags = new SparseBooleanArray();
                    break;
            }
        }

        public void add(int i) {
            UtilsKt.checkState(!this.buildCalled);
            ((SparseBooleanArray) this.flags).append(i, true);
        }

        public void addAll(FlagSet flagSet) {
            for (int i = 0; i < flagSet.flags.size(); i++) {
                add(flagSet.get(i));
            }
        }

        public FlagSet build() {
            UtilsKt.checkState(!this.buildCalled);
            this.buildCalled = true;
            return new FlagSet((SparseBooleanArray) this.flags);
        }

        public void indent() {
            this.buildCalled = true;
        }

        public void nextItem() {
            this.buildCalled = false;
        }

        public void nextItemIfNotFirst() {
            this.buildCalled = false;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
            ActionMenuPresenter actionMenuPresenter;
            ToolbarActionBar toolbarActionBar = (ToolbarActionBar) this.flags;
            if (this.buildCalled) {
                return;
            }
            this.buildCalled = true;
            ActionMenuView actionMenuView = toolbarActionBar.mDecorToolbar.mToolbar.mMenuView;
            if (actionMenuView != null && (actionMenuPresenter = actionMenuView.mPresenter) != null) {
                actionMenuPresenter.hideOverflowMenu();
                ActionMenuPresenter.OverflowPopup overflowPopup = actionMenuPresenter.mActionButtonPopup;
                if (overflowPopup != null && overflowPopup.isShowing()) {
                    overflowPopup.mPopup.dismiss();
                }
            }
            toolbarActionBar.mWindowCallback.onPanelClosed(108, menuBuilder);
            this.buildCalled = false;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            ((ToolbarActionBar) this.flags).mWindowCallback.onMenuOpened(108, menuBuilder);
            return true;
        }

        public void print(byte b) {
            ((InternalJsonWriter) this.flags).writeLong(b);
        }

        public void printQuoted(String str) {
            str.getClass();
            ((InternalJsonWriter) this.flags).writeQuoted(str);
        }

        public void print(char c) {
            ((InternalJsonWriter) this.flags).writeChar(c);
        }

        public void print(short s) {
            ((InternalJsonWriter) this.flags).writeLong(s);
        }

        public void print(int i) {
            ((InternalJsonWriter) this.flags).writeLong(i);
        }

        public void print(long j) {
            ((InternalJsonWriter) this.flags).writeLong(j);
        }

        public void space() {
        }

        public void unIndent() {
        }

        public void addAll(int... iArr) {
            for (int i : iArr) {
                add(i);
            }
        }

        public /* synthetic */ Builder(Object obj) {
            this.buildCalled = true;
            this.flags = obj;
        }

        public Builder(String str, boolean z) {
            this.buildCalled = z;
            this.flags = str;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Builder(TrieNode trieNode, int i) {
            this.flags = trieNode;
            this.buildCalled = i;
        }
    }
}
