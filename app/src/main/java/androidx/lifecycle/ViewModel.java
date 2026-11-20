package androidx.lifecycle;

import androidx.lifecycle.viewmodel.internal.ViewModelImpl;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ViewModel {
    public final ViewModelImpl impl = new ViewModelImpl();

    public final void addCloseable(String str, AutoCloseable autoCloseable) {
        AutoCloseable autoCloseable2;
        ViewModelImpl viewModelImpl = this.impl;
        if (viewModelImpl.isCleared) {
            ViewModelImpl.closeWithRuntimeException(autoCloseable);
            return;
        }
        synchronized (viewModelImpl.lock) {
            autoCloseable2 = (AutoCloseable) viewModelImpl.keyToCloseables.put(str, autoCloseable);
        }
        ViewModelImpl.closeWithRuntimeException(autoCloseable2);
    }

    public final void clear$lifecycle_viewmodel() {
        ViewModelImpl viewModelImpl = this.impl;
        if (!viewModelImpl.isCleared) {
            viewModelImpl.isCleared = true;
            synchronized (viewModelImpl.lock) {
                try {
                    Iterator it = viewModelImpl.keyToCloseables.values().iterator();
                    while (it.hasNext()) {
                        ViewModelImpl.closeWithRuntimeException((AutoCloseable) it.next());
                    }
                    Iterator it2 = viewModelImpl.closeables.iterator();
                    while (it2.hasNext()) {
                        ViewModelImpl.closeWithRuntimeException((AutoCloseable) it2.next());
                    }
                    viewModelImpl.closeables.clear();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        onCleared();
    }

    public final AutoCloseable getCloseable(String str) {
        AutoCloseable autoCloseable;
        ViewModelImpl viewModelImpl = this.impl;
        synchronized (viewModelImpl.lock) {
            autoCloseable = (AutoCloseable) viewModelImpl.keyToCloseables.get(str);
        }
        return autoCloseable;
    }

    public void onCleared() {
    }
}
