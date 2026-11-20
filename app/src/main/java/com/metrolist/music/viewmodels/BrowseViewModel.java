package com.metrolist.music.viewmodels;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.metrolist.music.utils.DataStoreKt$get$1;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/music/viewmodels/BrowseViewModel;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/SavedStateHandle;", "savedStateHandle", "<init>", "(Landroidx/lifecycle/SavedStateHandle;)V", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class BrowseViewModel extends ViewModel {
    public final String browseId;
    public final StateFlowImpl items;
    public final StateFlowImpl title;

    public BrowseViewModel(SavedStateHandle savedStateHandle) {
        savedStateHandle.getClass();
        this.browseId = (String) savedStateHandle.get("browseId");
        this.items = StateFlowKt.MutableStateFlow(EmptyList.INSTANCE);
        this.title = StateFlowKt.MutableStateFlow("");
        AwaitKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new DataStoreKt$get$1(this, null), 3);
    }
}
