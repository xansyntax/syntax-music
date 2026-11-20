package io.ktor.util.cio;

import androidx.datastore.core.FileStorage;
import java.io.File;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class FileChannelsKt$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ File f$0;

    public /* synthetic */ FileChannelsKt$$ExternalSyntheticLambda0(File file, byte b) {
        this.$r8$classId = b;
        this.f$0 = file;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        File file = this.f$0;
        switch (b) {
            case 0:
                return FileChannelsKt.readChannel$lambda$0(file);
            default:
                synchronized (FileStorage.activeFilesLock) {
                    FileStorage.activeFiles.remove(file.getAbsolutePath());
                }
                return Unit.INSTANCE;
        }
    }
}
