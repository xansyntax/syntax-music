package com.metrolist.music.ui.screens.settings;

import androidx.activity.compose.ManagedActivityResultLauncher;
import com.metrolist.music.db.DatabaseDao_Impl;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class BackupAndRestoreKt$$ExternalSyntheticLambda4 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ ManagedActivityResultLauncher f$0;

    public /* synthetic */ BackupAndRestoreKt$$ExternalSyntheticLambda4(ManagedActivityResultLauncher managedActivityResultLauncher, byte b) {
        this.$r8$classId = b;
        this.f$0 = managedActivityResultLauncher;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        ManagedActivityResultLauncher managedActivityResultLauncher = this.f$0;
        switch (b) {
            case 0:
                managedActivityResultLauncher.launch(new String[]{"application/octet-stream"});
                break;
            case 1:
                managedActivityResultLauncher.launch(new String[]{"audio/mpeg", "audio/mp4", "audio/x-m4a", "audio/flac", "audio/ogg", "audio/x-ms-wma"});
                break;
            case 2:
                managedActivityResultLauncher.launch(DatabaseDao_Impl.AnonymousClass17.PickVisualMediaRequest$default());
                break;
            case 3:
                managedActivityResultLauncher.launch(DatabaseDao_Impl.AnonymousClass17.PickVisualMediaRequest$default());
                break;
            case 4:
                managedActivityResultLauncher.launch(new String[]{"audio/*"});
                break;
            default:
                managedActivityResultLauncher.launch(new String[]{"text/csv", "text/comma-separated-values", "application/csv", "text/plain"});
                break;
        }
        return unit;
    }
}
