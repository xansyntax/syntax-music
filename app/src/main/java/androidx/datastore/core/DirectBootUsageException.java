package androidx.datastore.core;

import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DirectBootUsageException extends IOException {
    public final String message;

    public DirectBootUsageException(FileNotFoundException fileNotFoundException) {
        super(fileNotFoundException);
        this.message = "Encountered a [" + fileNotFoundException.getMessage() + "]. If you are trying to use DataStore during direct boot, this exception likely indicates that your DataStore file is not located in the Device Encrypted Storage and therefore is not available for write access during direct boot mode. DataStore to be used during direct boot must be initialized using `DataStoreFactory.createInDeviceProtectedStorage()`.";
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return this.message;
    }
}
