package androidx.navigation.internal;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.viewmodel.internal.CloseableCoroutineScope;
import androidx.media3.exoplayer.ExoPlayerImpl;
import androidx.navigation.NavBackStackEntry;
import androidx.savedstate.internal.SavedStateRegistryImpl;
import com.metrolist.music.ui.screens.settings.AboutScreenKt;
import com.metrolist.music.viewmodels.LibraryPodcastsViewModel;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class NavControllerImpl$$ExternalSyntheticLambda3 implements LifecycleEventObserver {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ NavControllerImpl$$ExternalSyntheticLambda3(byte b, Object obj) {
        this.$r8$classId = b;
        this.f$0 = obj;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        byte b = this.$r8$classId;
        int i = 0;
        Object obj = this.f$0;
        switch (b) {
            case 0:
                NavControllerImpl navControllerImpl = (NavControllerImpl) obj;
                navControllerImpl.hostLifecycleState = event.getTargetState();
                if (navControllerImpl._graph != null) {
                    ArrayList mutableList = CollectionsKt.toMutableList((Collection) navControllerImpl.backQueue);
                    int size = mutableList.size();
                    while (i < size) {
                        Object obj2 = mutableList.get(i);
                        i++;
                        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj2;
                        navBackStackEntry.getClass();
                        NavBackStackEntryImpl navBackStackEntryImpl = navBackStackEntry.impl;
                        navBackStackEntryImpl.getClass();
                        navBackStackEntryImpl.hostLifecycleState = event.getTargetState();
                        navBackStackEntryImpl.updateState$navigation_common_release();
                    }
                }
                break;
            case 1:
                ((Function1) obj).invoke(event);
                break;
            case 2:
                SavedStateRegistryImpl savedStateRegistryImpl = (SavedStateRegistryImpl) obj;
                if (event == Lifecycle.Event.ON_START) {
                    savedStateRegistryImpl.isAllowingSavingState = true;
                } else if (event == Lifecycle.Event.ON_STOP) {
                    savedStateRegistryImpl.isAllowingSavingState = false;
                }
                break;
            case 3:
                LibraryPodcastsViewModel libraryPodcastsViewModel = (LibraryPodcastsViewModel) obj;
                if (event == Lifecycle.Event.ON_RESUME) {
                    CloseableCoroutineScope viewModelScope = ViewModelKt.getViewModelScope(libraryPodcastsViewModel);
                    DefaultScheduler defaultScheduler = Dispatchers.Default;
                    AwaitKt.launch$default(viewModelScope, DefaultIoScheduler.INSTANCE, null, new LibraryPodcastsViewModel.AnonymousClass1((byte) 5, libraryPodcastsViewModel, null), 2);
                }
                break;
            default:
                ExoPlayerImpl exoPlayerImpl = (ExoPlayerImpl) obj;
                int i2 = AboutScreenKt.WhenMappings.$EnumSwitchMapping$0[event.ordinal()];
                if (i2 == 1) {
                    if (exoPlayerImpl != null) {
                        exoPlayerImpl.setPlayWhenReady(false);
                    }
                } else if (i2 == 2 && exoPlayerImpl != null) {
                    exoPlayerImpl.setPlayWhenReady(true);
                }
                break;
        }
    }
}
