package androidx.lifecycle.viewmodel;

import androidx.core.view.DifferentialMotionFlingController$$ExternalSyntheticLambda0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider$Factory;
import androidx.lifecycle.viewmodel.internal.ViewModelImpl;
import androidx.media3.common.FlagSet;
import androidx.room.concurrent.FileLock;
import com.google.common.collect.Maps;
import com.google.common.collect.RegularImmutableMap;
import com.metrolist.music.DaggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl;
import com.metrolist.music.DaggerApp_HiltComponents_SingletonC$SingletonCImpl;
import com.metrolist.music.DaggerApp_HiltComponents_SingletonC$ViewModelCImpl;
import com.metrolist.music.MainActivity;
import dagger.hilt.EntryPoints;
import dagger.hilt.android.internal.lifecycle.HiltViewModelFactory;
import dagger.hilt.android.internal.lifecycle.RetainedLifecycleImpl;
import dagger.hilt.android.internal.managers.ActivityRetainedComponentManager;
import dagger.internal.Provider;
import java.io.Closeable;
import java.util.Arrays;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Reflection;
import kotlin.text.CharsKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okhttp3.internal.http.StatusLine;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class InitializerViewModelFactory implements ViewModelProvider$Factory {
    public final /* synthetic */ byte $r8$classId;
    public final Object initializers;

    public /* synthetic */ InitializerViewModelFactory(byte b, Object obj) {
        this.$r8$classId = b;
        this.initializers = obj;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:20:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:48:0x01cb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // androidx.lifecycle.ViewModelProvider$Factory
    public final ViewModel create(Class cls, MutableCreationExtras mutableCreationExtras) {
        ViewModelInitializer viewModelInitializer;
        Function1 function1;
        ViewModel viewModel;
        Closeable closeable;
        ViewModelImpl viewModelImpl;
        ViewModel viewModel2 = null;
        switch (this.$r8$classId) {
            case 0:
                ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(cls);
                ViewModelInitializer[] viewModelInitializerArr = (ViewModelInitializer[]) this.initializers;
                ViewModelInitializer[] viewModelInitializerArr2 = (ViewModelInitializer[]) Arrays.copyOf(viewModelInitializerArr, viewModelInitializerArr.length);
                int length = viewModelInitializerArr2.length;
                int i = 0;
                while (true) {
                    if (i < length) {
                        viewModelInitializer = viewModelInitializerArr2[i];
                        if (!viewModelInitializer.clazz.equals(orCreateKotlinClass)) {
                            i++;
                        }
                    } else {
                        viewModelInitializer = null;
                    }
                }
                ViewModel viewModel3 = (viewModelInitializer == null || (function1 = viewModelInitializer.initializer) == null) ? null : (ViewModel) function1.invoke(mutableCreationExtras);
                if (viewModel3 != null) {
                    return viewModel3;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) Fragment$5$$ExternalSyntheticOutline0.m("No initializer set for given class ", orCreateKotlinClass.getQualifiedName()));
                return null;
            case 1:
                final RetainedLifecycleImpl retainedLifecycleImpl = new RetainedLifecycleImpl();
                FileLock fileLock = (FileLock) this.initializers;
                DaggerApp_HiltComponents_SingletonC$ViewModelCImpl daggerApp_HiltComponents_SingletonC$ViewModelCImpl = new DaggerApp_HiltComponents_SingletonC$ViewModelCImpl((DaggerApp_HiltComponents_SingletonC$SingletonCImpl) fileLock.lockFilename, (DaggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl) fileLock.lockChannel, ViewModelKt.createSavedStateHandle(mutableCreationExtras));
                DaggerApp_HiltComponents_SingletonC$ViewModelCImpl daggerApp_HiltComponents_SingletonC$ViewModelCImpl2 = (DaggerApp_HiltComponents_SingletonC$ViewModelCImpl) ((HiltViewModelFactory.ViewModelFactoriesEntryPoint) EntryPoints.get(daggerApp_HiltComponents_SingletonC$ViewModelCImpl, HiltViewModelFactory.ViewModelFactoriesEntryPoint.class));
                daggerApp_HiltComponents_SingletonC$ViewModelCImpl2.getClass();
                Maps.checkNonnegative(36, "expectedSize");
                StatusLine statusLine = new StatusLine(36);
                statusLine.put("com.metrolist.music.viewmodels.AccountSettingsViewModel", daggerApp_HiltComponents_SingletonC$ViewModelCImpl2.accountSettingsViewModelProvider);
                statusLine.put("com.metrolist.music.viewmodels.AccountViewModel", daggerApp_HiltComponents_SingletonC$ViewModelCImpl2.accountViewModelProvider);
                statusLine.put("com.metrolist.music.viewmodels.AlbumViewModel", daggerApp_HiltComponents_SingletonC$ViewModelCImpl2.albumViewModelProvider);
                statusLine.put("com.metrolist.music.viewmodels.ArtistAlbumsViewModel", daggerApp_HiltComponents_SingletonC$ViewModelCImpl2.artistAlbumsViewModelProvider);
                statusLine.put("com.metrolist.music.viewmodels.ArtistItemsViewModel", daggerApp_HiltComponents_SingletonC$ViewModelCImpl2.artistItemsViewModelProvider);
                statusLine.put("com.metrolist.music.viewmodels.ArtistSongsViewModel", daggerApp_HiltComponents_SingletonC$ViewModelCImpl2.artistSongsViewModelProvider);
                statusLine.put("com.metrolist.music.viewmodels.ArtistViewModel", daggerApp_HiltComponents_SingletonC$ViewModelCImpl2.artistViewModelProvider);
                statusLine.put("com.metrolist.music.viewmodels.AutoPlaylistViewModel", daggerApp_HiltComponents_SingletonC$ViewModelCImpl2.autoPlaylistViewModelProvider);
                statusLine.put("com.metrolist.music.viewmodels.BackupRestoreViewModel", daggerApp_HiltComponents_SingletonC$ViewModelCImpl2.backupRestoreViewModelProvider);
                statusLine.put("com.metrolist.music.viewmodels.BrowseViewModel", daggerApp_HiltComponents_SingletonC$ViewModelCImpl2.browseViewModelProvider);
                statusLine.put("com.metrolist.music.viewmodels.CachePlaylistViewModel", daggerApp_HiltComponents_SingletonC$ViewModelCImpl2.cachePlaylistViewModelProvider);
                statusLine.put("com.metrolist.music.viewmodels.ChartsViewModel", daggerApp_HiltComponents_SingletonC$ViewModelCImpl2.chartsViewModelProvider);
                statusLine.put("com.metrolist.music.ui.screens.equalizer.EQViewModel", daggerApp_HiltComponents_SingletonC$ViewModelCImpl2.eQViewModelProvider);
                statusLine.put("com.metrolist.music.viewmodels.HistoryViewModel", daggerApp_HiltComponents_SingletonC$ViewModelCImpl2.historyViewModelProvider);
                statusLine.put("com.metrolist.music.viewmodels.HomeViewModel", daggerApp_HiltComponents_SingletonC$ViewModelCImpl2.homeViewModelProvider);
                statusLine.put("com.metrolist.music.viewmodels.LibraryAlbumsViewModel", daggerApp_HiltComponents_SingletonC$ViewModelCImpl2.libraryAlbumsViewModelProvider);
                statusLine.put("com.metrolist.music.viewmodels.LibraryArtistsViewModel", daggerApp_HiltComponents_SingletonC$ViewModelCImpl2.libraryArtistsViewModelProvider);
                statusLine.put("com.metrolist.music.viewmodels.LibraryMixViewModel", daggerApp_HiltComponents_SingletonC$ViewModelCImpl2.libraryMixViewModelProvider);
                statusLine.put("com.metrolist.music.viewmodels.LibraryPlaylistsViewModel", daggerApp_HiltComponents_SingletonC$ViewModelCImpl2.libraryPlaylistsViewModelProvider);
                statusLine.put("com.metrolist.music.viewmodels.LibraryPodcastsViewModel", daggerApp_HiltComponents_SingletonC$ViewModelCImpl2.libraryPodcastsViewModelProvider);
                statusLine.put("com.metrolist.music.viewmodels.LibrarySongsViewModel", daggerApp_HiltComponents_SingletonC$ViewModelCImpl2.librarySongsViewModelProvider);
                statusLine.put("com.metrolist.music.viewmodels.LocalPlaylistViewModel", daggerApp_HiltComponents_SingletonC$ViewModelCImpl2.localPlaylistViewModelProvider);
                statusLine.put("com.metrolist.music.viewmodels.LocalSearchViewModel", daggerApp_HiltComponents_SingletonC$ViewModelCImpl2.localSearchViewModelProvider);
                statusLine.put("com.metrolist.music.viewmodels.LyricsMenuViewModel", daggerApp_HiltComponents_SingletonC$ViewModelCImpl2.lyricsMenuViewModelProvider);
                statusLine.put("com.metrolist.music.viewmodels.LyricsViewModel", daggerApp_HiltComponents_SingletonC$ViewModelCImpl2.lyricsViewModelProvider);
                statusLine.put("com.metrolist.music.viewmodels.MoodAndGenresViewModel", daggerApp_HiltComponents_SingletonC$ViewModelCImpl2.moodAndGenresViewModelProvider);
                statusLine.put("com.metrolist.music.viewmodels.NewReleaseViewModel", daggerApp_HiltComponents_SingletonC$ViewModelCImpl2.newReleaseViewModelProvider);
                statusLine.put("com.metrolist.music.viewmodels.OnlinePlaylistViewModel", daggerApp_HiltComponents_SingletonC$ViewModelCImpl2.onlinePlaylistViewModelProvider);
                statusLine.put("com.metrolist.music.viewmodels.OnlinePodcastViewModel", daggerApp_HiltComponents_SingletonC$ViewModelCImpl2.onlinePodcastViewModelProvider);
                statusLine.put("com.metrolist.music.viewmodels.OnlineSearchSuggestionViewModel", daggerApp_HiltComponents_SingletonC$ViewModelCImpl2.onlineSearchSuggestionViewModelProvider);
                statusLine.put("com.metrolist.music.viewmodels.OnlineSearchViewModel", daggerApp_HiltComponents_SingletonC$ViewModelCImpl2.onlineSearchViewModelProvider);
                statusLine.put("com.metrolist.music.viewmodels.PlaylistsViewModel", daggerApp_HiltComponents_SingletonC$ViewModelCImpl2.playlistsViewModelProvider);
                statusLine.put("com.metrolist.music.viewmodels.StatsViewModel", daggerApp_HiltComponents_SingletonC$ViewModelCImpl2.statsViewModelProvider);
                statusLine.put("com.metrolist.music.viewmodels.TopPlaylistViewModel", daggerApp_HiltComponents_SingletonC$ViewModelCImpl2.topPlaylistViewModelProvider);
                statusLine.put("com.metrolist.music.ui.screens.equalizer.wizard.WizardViewModel", daggerApp_HiltComponents_SingletonC$ViewModelCImpl2.wizardViewModelProvider);
                statusLine.put("com.metrolist.music.viewmodels.YouTubeBrowseViewModel", daggerApp_HiltComponents_SingletonC$ViewModelCImpl2.youTubeBrowseViewModelProvider);
                Provider provider = (Provider) statusLine.build(true).get(cls.getName());
                Function1 function2 = (Function1) mutableCreationExtras.extras.get(HiltViewModelFactory.CREATION_CALLBACK_KEY);
                ((HiltViewModelFactory.ViewModelFactoriesEntryPoint) EntryPoints.get(daggerApp_HiltComponents_SingletonC$ViewModelCImpl, HiltViewModelFactory.ViewModelFactoriesEntryPoint.class)).getClass();
                Object obj = RegularImmutableMap.EMPTY.get(cls);
                if (obj == null) {
                    if (function2 != null) {
                        DifferentialMotionFlingController$$ExternalSyntheticLambda0.m("Found creation callback but class ", cls.getName(), " does not have an assisted factory specified in @HiltViewModel.");
                    } else if (provider != null) {
                        viewModel = (ViewModel) provider.get();
                        viewModel2 = viewModel;
                        closeable = new Closeable() { // from class: dagger.hilt.android.internal.lifecycle.HiltViewModelFactory$2$$ExternalSyntheticLambda0
                            @Override // java.io.Closeable, java.lang.AutoCloseable
                            public final void close() {
                                retainedLifecycleImpl.dispatchOnCleared();
                            }
                        };
                        viewModel2.getClass();
                        viewModelImpl = viewModel2.impl;
                        if (viewModelImpl.isCleared) {
                            ViewModelImpl.closeWithRuntimeException(closeable);
                        } else {
                            synchronized (viewModelImpl.lock) {
                                viewModelImpl.closeables.add(closeable);
                            }
                        }
                    } else {
                        DifferentialMotionFlingController$$ExternalSyntheticLambda0.m("Expected the @HiltViewModel-annotated class ", cls.getName(), " to be available in the multi-binding of @HiltViewModelMap but none was found.");
                    }
                } else {
                    if (provider != null) {
                        throw new AssertionError("Found the @HiltViewModel-annotated class " + cls.getName() + " in both the multi-bindings of @HiltViewModelMap and @HiltViewModelAssistedMap.");
                    }
                    if (function2 != null) {
                        viewModel = (ViewModel) function2.invoke(obj);
                        viewModel2 = viewModel;
                        closeable = new Closeable() { // from class: dagger.hilt.android.internal.lifecycle.HiltViewModelFactory$2$$ExternalSyntheticLambda0
                            @Override // java.io.Closeable, java.lang.AutoCloseable
                            public final void close() {
                                retainedLifecycleImpl.dispatchOnCleared();
                            }
                        };
                        viewModel2.getClass();
                        viewModelImpl = viewModel2.impl;
                        if (viewModelImpl.isCleared) {
                            ViewModelImpl.closeWithRuntimeException(closeable);
                        } else {
                            synchronized (viewModelImpl.lock) {
                                viewModelImpl.closeables.add(closeable);
                            }
                        }
                    } else {
                        DifferentialMotionFlingController$$ExternalSyntheticLambda0.m("Found @HiltViewModel-annotated class ", cls.getName(), " using @AssistedInject but no creation callback was provided in CreationExtras.");
                    }
                }
                return viewModel2;
            default:
                return new ActivityRetainedComponentManager.ActivityRetainedComponentViewModel(new DaggerApp_HiltComponents_SingletonC$ActivityRetainedCImpl(((DaggerApp_HiltComponents_SingletonC$SingletonCImpl) ((ActivityRetainedComponentManager.ActivityRetainedComponentBuilderEntryPoint) EntryPoints.get(CharsKt.getApplication(((MainActivity) this.initializers).getApplicationContext()), ActivityRetainedComponentManager.ActivityRetainedComponentBuilderEntryPoint.class))).singletonCImpl), new FlagSet.Builder(mutableCreationExtras));
        }
    }
}
