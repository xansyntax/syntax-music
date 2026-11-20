package androidx.core.app;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.collection.SimpleArrayMap;
import androidx.core.view.KeyEventDispatcher$Component;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ReportFragment;
import coil3.size.SizeKt;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlin.Deprecated;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ComponentActivity extends Activity implements LifecycleOwner, KeyEventDispatcher$Component {
    private final SimpleArrayMap extraDataMap = new SimpleArrayMap(0);
    private final LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this, true);

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract class ExtraData {
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        keyEvent.getClass();
        View decorView = getWindow().getDecorView();
        decorView.getClass();
        if (ViewCompat.dispatchUnhandledKeyEventBeforeHierarchy(decorView, keyEvent)) {
            return true;
        }
        return SizeKt.dispatchKeyEvent(this, decorView, this, keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        keyEvent.getClass();
        View decorView = getWindow().getDecorView();
        decorView.getClass();
        if (ViewCompat.dispatchUnhandledKeyEventBeforeHierarchy(decorView, keyEvent)) {
            return true;
        }
        return super.dispatchKeyShortcutEvent(keyEvent);
    }

    @Deprecated
    public <T extends ExtraData> T getExtraData(Class<T> cls) {
        cls.getClass();
        if (this.extraDataMap.get(cls) == null) {
            return null;
        }
        PathKt$$ExternalSyntheticBUOutline0.m();
        return null;
    }

    public Lifecycle getLifecycle() {
        return this.lifecycleRegistry;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int i = ReportFragment.$r8$clinit;
        ReportFragment.Companion.injectIfNeededIn(this);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.getClass();
        this.lifecycleRegistry.setCurrentState(Lifecycle.State.CREATED);
        super.onSaveInstanceState(bundle);
    }

    @Deprecated
    public void putExtraData(ExtraData extraData) {
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x001b  */
    /* JADX WARN: Code duplicated, block: B:26:0x003f  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final boolean shouldDumpInternalState(String[] strArr) {
        boolean z = false;
        if (strArr != null && strArr.length != 0) {
            String str = strArr[0];
            switch (str.hashCode()) {
                case -645125871:
                    if (str.equals("--translation") && Build.VERSION.SDK_INT >= 31) {
                        z = true;
                    }
                    break;
                case 100470631:
                    if (str.equals("--dump-dumpable")) {
                        if (Build.VERSION.SDK_INT >= 33) {
                            z = true;
                        }
                    }
                    break;
                case 472614934:
                    if (str.equals("--list-dumpables")) {
                        if (Build.VERSION.SDK_INT >= 33) {
                            z = true;
                        }
                    }
                    break;
                case 1159329357:
                    if (str.equals("--contentcapture") && Build.VERSION.SDK_INT >= 29) {
                        z = true;
                    }
                    break;
                case 1455016274:
                    if (str.equals("--autofill")) {
                        z = true;
                    }
                    break;
            }
        }
        return true ^ z;
    }

    @Override // androidx.core.view.KeyEventDispatcher$Component
    public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        keyEvent.getClass();
        return super.dispatchKeyEvent(keyEvent);
    }
}
