package androidx.savedstate.internal;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.media3.extractor.text.CueDecoder;
import androidx.navigation.internal.NavControllerImpl$$ExternalSyntheticLambda3;
import androidx.room.RoomDatabase$$ExternalSyntheticLambda0;
import androidx.savedstate.SavedStateRegistryOwner;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.google.common.collect.RegularImmutableMap;
import java.io.Serializable;
import java.util.LinkedHashMap;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SavedStateRegistryImpl {
    public boolean attached;
    public boolean isAllowingSavingState;
    public boolean isRestored;
    public Serializable keyToProviders;
    public Object lock;
    public Object onAttach;
    public Object owner;
    public Cloneable restoredState;

    public SavedStateRegistryImpl(SavedStateRegistryOwner savedStateRegistryOwner, RoomDatabase$$ExternalSyntheticLambda0 roomDatabase$$ExternalSyntheticLambda0) {
        this.owner = savedStateRegistryOwner;
        this.onAttach = roomDatabase$$ExternalSyntheticLambda0;
        this.lock = new CueDecoder((byte) 27);
        this.keyToProviders = new LinkedHashMap();
        this.isAllowingSavingState = true;
    }

    public void performAttach() {
        SavedStateRegistryOwner savedStateRegistryOwner = (SavedStateRegistryOwner) this.owner;
        if (((LifecycleRegistry) savedStateRegistryOwner.getLifecycle()).state != Lifecycle.State.INITIALIZED) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Restarter must be created only during owner's initialization stage");
        } else {
            if (this.attached) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("SavedStateRegistry was already attached.");
                return;
            }
            ((RoomDatabase$$ExternalSyntheticLambda0) this.onAttach).invoke();
            savedStateRegistryOwner.getLifecycle().addObserver(new NavControllerImpl$$ExternalSyntheticLambda3((byte) 2, this));
            this.attached = true;
        }
    }

    public SavedStateRegistryImpl() {
        this.lock = RegularImmutableMap.EMPTY;
        this.isRestored = true;
        ImmutableList.Itr itr = ImmutableList.EMPTY_ITR;
        this.keyToProviders = RegularImmutableList.EMPTY;
    }
}
