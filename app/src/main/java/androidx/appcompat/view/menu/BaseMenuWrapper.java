package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.IntentFilter;
import android.view.MenuItem;
import androidx.activity.BackEventCompat;
import androidx.activity.compose.internal.BackHandlerCompat$navigationEventHandler$1;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.collection.SimpleArrayMap;
import androidx.core.internal.view.SupportMenuItem;
import androidx.fragment.app.FragmentManager;
import androidx.media3.common.util.NetworkTypeObserver;
import androidx.navigationevent.NavigationEvent;
import androidx.navigationevent.NavigationEventHandler;
import coil3.util.UtilsKt;
import io.ktor.http.ContentType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class BaseMenuWrapper {
    public Object mContext;
    public Object mMenuItems;

    public BaseMenuWrapper(final UtilsKt utilsKt) {
        this.mContext = new FragmentManager.AnonymousClass1((byte) 2, this);
        this.mMenuItems = new NavigationEventHandler(utilsKt) { // from class: androidx.activity.compose.internal.BackHandlerCompat$navigationEventHandler$1
            {
                this.currentInfo = utilsKt;
                this.isBackEnabled = false;
            }

            @Override // androidx.navigationevent.NavigationEventHandler
            public final void onBackCancelled() {
                this.this$0.onBackCancelled();
            }

            @Override // androidx.navigationevent.NavigationEventHandler
            public final void onBackCompleted() {
                this.this$0.onBackCompleted();
            }

            @Override // androidx.navigationevent.NavigationEventHandler
            public final void onBackProgressed(NavigationEvent navigationEvent) {
                this.this$0.onBackProgressed(new BackEventCompat(navigationEvent));
            }

            @Override // androidx.navigationevent.NavigationEventHandler
            public final void onBackStarted(NavigationEvent navigationEvent) {
                navigationEvent.getClass();
                this.this$0.onBackStarted();
            }
        };
    }

    public void cleanup() {
        NetworkTypeObserver.Receiver receiver = (NetworkTypeObserver.Receiver) this.mContext;
        if (receiver != null) {
            try {
                ((AppCompatDelegateImpl) this.mMenuItems).mContext.unregisterReceiver(receiver);
            } catch (IllegalArgumentException unused) {
            }
            this.mContext = null;
        }
    }

    public abstract IntentFilter createIntentFilterForBroadcastReceiver();

    public abstract int[] following(int i);

    public abstract int getApplyableNightMode();

    public MenuItem getMenuItemWrapper(MenuItem menuItem) {
        if (!(menuItem instanceof SupportMenuItem)) {
            return menuItem;
        }
        SupportMenuItem supportMenuItem = (SupportMenuItem) menuItem;
        SimpleArrayMap simpleArrayMap = (SimpleArrayMap) this.mMenuItems;
        if (simpleArrayMap == null) {
            simpleArrayMap = new SimpleArrayMap(0);
            this.mMenuItems = simpleArrayMap;
        }
        MenuItem menuItem2 = (MenuItem) simpleArrayMap.get(supportMenuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        MenuItemWrapperICS menuItemWrapperICS = new MenuItemWrapperICS((Context) this.mContext, supportMenuItem);
        ((SimpleArrayMap) this.mMenuItems).put(supportMenuItem, menuItemWrapperICS);
        return menuItemWrapperICS;
    }

    public int[] getRange(int i, int i2) {
        if (i < 0 || i2 < 0 || i == i2) {
            return null;
        }
        int[] iArr = (int[]) this.mMenuItems;
        iArr[0] = i;
        iArr[1] = i2;
        return iArr;
    }

    public String getText() {
        String str = (String) this.mContext;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException(ContentType.Text.TYPE);
        throw null;
    }

    public boolean isBackEnabled() {
        return ((FragmentManager.AnonymousClass1) this.mContext).isEnabled && ((BackHandlerCompat$navigationEventHandler$1) this.mMenuItems).isBackEnabled;
    }

    public abstract void onBackCompleted();

    public abstract void onChange();

    public abstract int[] preceding(int i);

    public void setup() {
        cleanup();
        IntentFilter intentFilterCreateIntentFilterForBroadcastReceiver = createIntentFilterForBroadcastReceiver();
        if (intentFilterCreateIntentFilterForBroadcastReceiver.countActions() == 0) {
            return;
        }
        NetworkTypeObserver.Receiver receiver = (NetworkTypeObserver.Receiver) this.mContext;
        if (receiver == null) {
            receiver = new NetworkTypeObserver.Receiver((byte) 1, this);
            this.mContext = receiver;
        }
        ((AppCompatDelegateImpl) this.mMenuItems).mContext.registerReceiver(receiver, intentFilterCreateIntentFilterForBroadcastReceiver);
    }

    public void onBackCancelled() {
    }

    public void onBackStarted() {
    }

    public BaseMenuWrapper(Context context) {
        this.mContext = context;
    }

    public BaseMenuWrapper() {
        this.mMenuItems = new int[2];
    }

    public BaseMenuWrapper(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.mMenuItems = appCompatDelegateImpl;
    }

    public void onBackProgressed(BackEventCompat backEventCompat) {
    }
}
