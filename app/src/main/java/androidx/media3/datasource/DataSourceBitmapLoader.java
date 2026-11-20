package androidx.media3.datasource;

import android.content.Context;
import android.net.Uri;
import androidx.compose.ui.platform.WeakCache;
import androidx.media3.common.util.BitmapLoader;
import androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda15;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors$ListeningDecorator;
import com.metrolist.music.db.DatabaseDao_Impl;
import java.util.concurrent.Callable;
import kotlinx.serialization.json.internal.JsonTreeReader;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DataSourceBitmapLoader implements BitmapLoader {
    public static final Supplier DEFAULT_EXECUTOR_SERVICE = DatabaseDao_Impl.AnonymousClass17.memoize(new MediaSessionImpl$$ExternalSyntheticLambda15((byte) 1));
    public final WeakCache dataSourceFactory;
    public final MoreExecutors$ListeningDecorator listeningExecutorService;
    public final boolean makeShared;
    public final int maximumOutputDimension;

    public DataSourceBitmapLoader(JsonTreeReader jsonTreeReader) {
        this.dataSourceFactory = new WeakCache((Context) jsonTreeReader.lexer);
        MoreExecutors$ListeningDecorator moreExecutors$ListeningDecorator = (MoreExecutors$ListeningDecorator) DEFAULT_EXECUTOR_SERVICE.get();
        moreExecutors$ListeningDecorator.getClass();
        this.listeningExecutorService = moreExecutors$ListeningDecorator;
        this.maximumOutputDimension = jsonTreeReader.stackDepth;
        this.makeShared = jsonTreeReader.isLenient;
    }

    @Override // androidx.media3.common.util.BitmapLoader
    public final ListenableFuture decodeBitmap(byte[] bArr) {
        return this.listeningExecutorService.submit((Callable) new DataSourceBitmapLoader$$ExternalSyntheticLambda1(this, bArr, (byte) 0));
    }

    @Override // androidx.media3.common.util.BitmapLoader
    public final ListenableFuture loadBitmap(Uri uri) {
        return this.listeningExecutorService.submit((Callable) new DataSourceBitmapLoader$$ExternalSyntheticLambda1(this, uri, (byte) 1));
    }
}
