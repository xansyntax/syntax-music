package com.metrolist.music.ui.screens.equalizer.wizard;

import android.content.Context;
import androidx.compose.foundation.text.TextDelegate;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.metrolist.music.eq.data.EQProfileRepository;
import com.metrolist.music.utils.SyncUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptySet;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/metrolist/music/ui/screens/equalizer/wizard/WizardViewModel;", "Landroidx/lifecycle/ViewModel;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class WizardViewModel extends ViewModel {
    public final StateFlowImpl _state;
    public final TextDelegate autoEqSearch;
    public final EQProfileRepository eqProfileRepository;
    public StandaloneCoroutine searchJob;
    public final ReadonlyStateFlow state;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[WizardStep.values().length];
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public WizardViewModel(Context context, EQProfileRepository eQProfileRepository) {
        eQProfileRepository.getClass();
        this.eqProfileRepository = eQProfileRepository;
        TextDelegate textDelegate = new TextDelegate(context);
        this.autoEqSearch = textDelegate;
        WizardStep wizardStep = WizardStep.MODEL_SELECTION;
        EmptyList emptyList = EmptyList.INSTANCE;
        StateFlowImpl stateFlowImplMutableStateFlow = StateFlowKt.MutableStateFlow(new WizardState(wizardStep, "", emptyList, null, emptyList, EmptySet.INSTANCE, false, false, null, false));
        this._state = stateFlowImplMutableStateFlow;
        this.state = StateFlowKt.asStateFlow(stateFlowImplMutableStateFlow);
        if (((File) textDelegate.fontFamilyResolver).exists()) {
            AwaitKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new SyncUtils.AnonymousClass2(this, null, (byte) 27), 3);
        }
    }

    public final void searchModels(String str) {
        AwaitKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new WizardViewModel$loadVariants$1(this, str, null, (byte) 1), 3);
    }
}
