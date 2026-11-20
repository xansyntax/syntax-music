package androidx.datastore.core;

import androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda6;
import java.util.LinkedHashSet;
import kotlin.jvm.functions.Function1;
import okhttp3.Handshake$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FileStorage {
    public static final LinkedHashSet activeFiles = new LinkedHashSet();
    public static final Object activeFilesLock = new Object();
    public final Function1 coordinatorProducer = new SaversKt$$ExternalSyntheticLambda6((byte) 29);
    public final Handshake$$ExternalSyntheticLambda0 produceFile;

    public FileStorage(Handshake$$ExternalSyntheticLambda0 handshake$$ExternalSyntheticLambda0) {
        this.produceFile = handshake$$ExternalSyntheticLambda0;
    }
}
