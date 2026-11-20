package androidx.loader.app;

import androidx.collection.SparseArrayCompat;
import androidx.fragment.app.FragmentManagerViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.io.PrintWriter;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Reflection;
import okhttp3.Dispatcher;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LoaderManagerImpl extends LoaderManager {
    public final LifecycleOwner mLifecycleOwner;
    public final LoaderViewModel mLoaderViewModel;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public class LoaderViewModel extends ViewModel {
        public static final FragmentManagerViewModel.AnonymousClass1 FACTORY = new FragmentManagerViewModel.AnonymousClass1(1);
        public final SparseArrayCompat mLoaders = new SparseArrayCompat(0);

        @Override // androidx.lifecycle.ViewModel
        public final void onCleared() {
            SparseArrayCompat sparseArrayCompat = this.mLoaders;
            if (sparseArrayCompat.size() > 0) {
                sparseArrayCompat.valueAt(0).getClass();
                PathKt$$ExternalSyntheticBUOutline0.m();
                return;
            }
            int i = sparseArrayCompat.size;
            Object[] objArr = sparseArrayCompat.values;
            for (int i2 = 0; i2 < i; i2++) {
                objArr[i2] = null;
            }
            sparseArrayCompat.size = 0;
            sparseArrayCompat.garbage = false;
        }
    }

    public LoaderManagerImpl(LifecycleOwner lifecycleOwner, ViewModelStore viewModelStore) {
        this.mLifecycleOwner = lifecycleOwner;
        viewModelStore.getClass();
        CreationExtras.Empty empty = CreationExtras.Empty.INSTANCE;
        empty.getClass();
        Dispatcher dispatcher = new Dispatcher(viewModelStore, LoaderViewModel.FACTORY, empty);
        ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(LoaderViewModel.class);
        String qualifiedName = orCreateKotlinClass.getQualifiedName();
        if (qualifiedName != null) {
            this.mLoaderViewModel = (LoaderViewModel) dispatcher.getViewModel$lifecycle_viewmodel(orCreateKotlinClass, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(qualifiedName));
        } else {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Local and anonymous classes can not be ViewModels");
            throw null;
        }
    }

    public final void dump(String str, PrintWriter printWriter) {
        SparseArrayCompat sparseArrayCompat = this.mLoaderViewModel.mLoaders;
        if (sparseArrayCompat.size() > 0) {
            printWriter.print(str);
            printWriter.println("Loaders:");
            if (sparseArrayCompat.size() <= 0) {
                return;
            }
            if (sparseArrayCompat.valueAt(0) != null) {
                PathKt$$ExternalSyntheticBUOutline0.m();
                return;
            }
            printWriter.print(str);
            printWriter.print("  #");
            printWriter.print(sparseArrayCompat.keyAt(0));
            printWriter.print(": ");
            throw null;
        }
    }

    public final String toString() {
        int iLastIndexOf;
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        LifecycleOwner lifecycleOwner = this.mLifecycleOwner;
        String simpleName = lifecycleOwner.getClass().getSimpleName();
        if (simpleName.length() <= 0 && (iLastIndexOf = (simpleName = lifecycleOwner.getClass().getName()).lastIndexOf(46)) > 0) {
            simpleName = simpleName.substring(iLastIndexOf + 1);
        }
        sb.append(simpleName);
        sb.append('{');
        sb.append(Integer.toHexString(System.identityHashCode(lifecycleOwner)));
        sb.append("}}");
        return sb.toString();
    }
}
