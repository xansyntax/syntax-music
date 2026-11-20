package dagger.hilt.android.internal.lifecycle;

import androidx.activity.ComponentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider$Factory;
import androidx.lifecycle.viewmodel.InitializerViewModelFactory;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.room.concurrent.FileLock;
import com.metrolist.music.DaggerApp_HiltComponents_SingletonC$ActivityCImpl;
import dagger.hilt.EntryPoints;
import dagger.internal.LazyClassKeyMap;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class HiltViewModelFactory implements ViewModelProvider$Factory {
    public static final Path.Companion CREATION_CALLBACK_KEY = new Path.Companion(7);
    public final ViewModelProvider$Factory delegateFactory;
    public final InitializerViewModelFactory hiltViewModelFactory;
    public final LazyClassKeyMap hiltViewModelKeys;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    interface ActivityCreatorEntryPoint {
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface ViewModelFactoriesEntryPoint {
    }

    public HiltViewModelFactory(LazyClassKeyMap lazyClassKeyMap, ViewModelProvider$Factory viewModelProvider$Factory, FileLock fileLock) {
        this.hiltViewModelKeys = lazyClassKeyMap;
        this.delegateFactory = viewModelProvider$Factory;
        this.hiltViewModelFactory = new InitializerViewModelFactory((byte) 1, fileLock);
    }

    public static HiltViewModelFactory createInternal(ComponentActivity componentActivity, ViewModelProvider$Factory viewModelProvider$Factory) {
        DaggerApp_HiltComponents_SingletonC$ActivityCImpl daggerApp_HiltComponents_SingletonC$ActivityCImpl = (DaggerApp_HiltComponents_SingletonC$ActivityCImpl) ((ActivityCreatorEntryPoint) EntryPoints.get(componentActivity, ActivityCreatorEntryPoint.class));
        return new HiltViewModelFactory(daggerApp_HiltComponents_SingletonC$ActivityCImpl.getViewModelKeys(), viewModelProvider$Factory, new FileLock(daggerApp_HiltComponents_SingletonC$ActivityCImpl.singletonCImpl, daggerApp_HiltComponents_SingletonC$ActivityCImpl.activityRetainedCImpl));
    }

    @Override // androidx.lifecycle.ViewModelProvider$Factory
    public final ViewModel create(Class cls, MutableCreationExtras mutableCreationExtras) {
        return this.hiltViewModelKeys.containsKey(cls) ? this.hiltViewModelFactory.create(cls, mutableCreationExtras) : this.delegateFactory.create(cls, mutableCreationExtras);
    }

    @Override // androidx.lifecycle.ViewModelProvider$Factory
    public final ViewModel create(Class cls) {
        if (!this.hiltViewModelKeys.containsKey(cls)) {
            return this.delegateFactory.create(cls);
        }
        PathKt$$ExternalSyntheticBUOutline0.m$2("`Factory.create(String, CreationExtras)` is not implemented. You may need to override the method and provide a custom implementation. Note that using `Factory.create(String)` is not supported and considered an error.");
        return null;
    }
}
