package com.metrolist.music;

import androidx.activity.ComponentActivity;
import androidx.activity.contextaware.OnContextAvailableListener;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.FragmentActivity;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.listentogether.ListenTogetherManager;
import com.metrolist.music.playback.DownloadUtil;
import com.metrolist.music.utils.SyncUtils;
import com.yalantis.ucrop.UCropActivity;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Hilt_MainActivity$1 implements OnContextAvailableListener {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ FragmentActivity this$0;

    public /* synthetic */ Hilt_MainActivity$1(FragmentActivity fragmentActivity, byte b) {
        this.$r8$classId = b;
        this.this$0 = fragmentActivity;
    }

    @Override // androidx.activity.contextaware.OnContextAvailableListener
    public final void onContextAvailable(ComponentActivity componentActivity) {
        byte b = this.$r8$classId;
        FragmentActivity fragmentActivity = this.this$0;
        switch (b) {
            case 0:
                MainActivity mainActivity = (MainActivity) fragmentActivity;
                if (!mainActivity.injected) {
                    mainActivity.injected = true;
                    DaggerApp_HiltComponents_SingletonC$SingletonCImpl daggerApp_HiltComponents_SingletonC$SingletonCImpl = ((DaggerApp_HiltComponents_SingletonC$ActivityCImpl) ((MainActivity_GeneratedInjector) mainActivity.generatedComponent())).singletonCImpl;
                    mainActivity.database = (MusicDatabase) daggerApp_HiltComponents_SingletonC$SingletonCImpl.provideDatabaseProvider.get();
                    mainActivity.downloadUtil = (DownloadUtil) daggerApp_HiltComponents_SingletonC$SingletonCImpl.downloadUtilProvider.get();
                    mainActivity.syncUtils = (SyncUtils) daggerApp_HiltComponents_SingletonC$SingletonCImpl.syncUtilsProvider.get();
                    mainActivity.listenTogetherManager = (ListenTogetherManager) daggerApp_HiltComponents_SingletonC$SingletonCImpl.provideListenTogetherManagerProvider.get();
                }
                break;
            default:
                UCropActivity uCropActivity = (UCropActivity) fragmentActivity;
                AppCompatDelegate delegate = uCropActivity.getDelegate();
                delegate.installViewFactory();
                uCropActivity.getSavedStateRegistry().consumeRestoredStateForKey("androidx:appcompat");
                delegate.onCreate();
                break;
        }
    }
}
