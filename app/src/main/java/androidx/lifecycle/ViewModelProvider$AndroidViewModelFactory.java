package androidx.lifecycle;

import android.app.Application;
import androidx.collection.internal.Lock;
import androidx.core.view.DifferentialMotionFlingController$$ExternalSyntheticLambda0;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.sqlite.SQLite;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.lang.reflect.InvocationTargetException;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ViewModelProvider$AndroidViewModelFactory extends ViewModelProvider$NewInstanceFactory {
    public static final Lock APPLICATION_KEY = new Lock((byte) 25);
    public static ViewModelProvider$AndroidViewModelFactory _instance;
    public final Application application;

    public ViewModelProvider$AndroidViewModelFactory(Application application) {
        this.application = application;
    }

    public final ViewModel create(Class cls, Application application) {
        if (!AndroidViewModel.class.isAssignableFrom(cls)) {
            return SQLite.createViewModel(cls);
        }
        try {
            ViewModel viewModel = (ViewModel) cls.getConstructor(Application.class).newInstance(application);
            viewModel.getClass();
            return viewModel;
        } catch (IllegalAccessException e) {
            DifferentialMotionFlingController$$ExternalSyntheticLambda0.m("Cannot create an instance of ", (Object) cls, (Throwable) e);
            return null;
        } catch (InstantiationException e2) {
            DifferentialMotionFlingController$$ExternalSyntheticLambda0.m("Cannot create an instance of ", (Object) cls, (Throwable) e2);
            return null;
        } catch (NoSuchMethodException e3) {
            DifferentialMotionFlingController$$ExternalSyntheticLambda0.m("Cannot create an instance of ", (Object) cls, (Throwable) e3);
            return null;
        } catch (InvocationTargetException e4) {
            DifferentialMotionFlingController$$ExternalSyntheticLambda0.m("Cannot create an instance of ", (Object) cls, (Throwable) e4);
            return null;
        }
    }

    @Override // androidx.lifecycle.ViewModelProvider$NewInstanceFactory, androidx.lifecycle.ViewModelProvider$Factory
    public final ViewModel create(Class cls) {
        Application application = this.application;
        if (application != null) {
            return create(cls, application);
        }
        PathKt$$ExternalSyntheticBUOutline0.m$2("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
        return null;
    }

    @Override // androidx.lifecycle.ViewModelProvider$NewInstanceFactory, androidx.lifecycle.ViewModelProvider$Factory
    public final ViewModel create(Class cls, MutableCreationExtras mutableCreationExtras) {
        if (this.application != null) {
            return create(cls);
        }
        Application application = (Application) mutableCreationExtras.extras.get(APPLICATION_KEY);
        if (application != null) {
            return create(cls, application);
        }
        if (!AndroidViewModel.class.isAssignableFrom(cls)) {
            return SQLite.createViewModel(cls);
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1("CreationExtras must have an application by `APPLICATION_KEY`");
        return null;
    }
}
