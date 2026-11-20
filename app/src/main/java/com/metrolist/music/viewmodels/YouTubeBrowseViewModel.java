package com.metrolist.music.viewmodels;

import android.content.Context;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import kotlin.Metadata;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/metrolist/music/viewmodels/YouTubeBrowseViewModel;", "Landroidx/lifecycle/ViewModel;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class YouTubeBrowseViewModel extends ViewModel {
    public final String browseId;
    public final Context context;
    public final String params;
    public final StateFlowImpl result;

    public YouTubeBrowseViewModel(Context context, SavedStateHandle savedStateHandle) {
        savedStateHandle.getClass();
        this.context = context;
        Object obj = savedStateHandle.get("browseId");
        obj.getClass();
        this.browseId = (String) obj;
        this.params = (String) savedStateHandle.get("params");
        this.result = StateFlowKt.MutableStateFlow(null);
        AwaitKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new HomeViewModel.C02082.AnonymousClass4(this, null), 3);
    }
}
