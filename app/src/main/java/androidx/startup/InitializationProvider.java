package androidx.startup;

import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Trace;
import coil3.network.HttpException;
import com.metrolist.music.db.DatabaseDao_Impl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class InitializationProvider extends ContentProvider {
    @Override // android.content.ContentProvider
    public final int delete(Uri uri, String str, String[] strArr) {
        throw new IllegalStateException("Not allowed.");
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri uri) {
        throw new IllegalStateException("Not allowed.");
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri uri, ContentValues contentValues) {
        throw new IllegalStateException("Not allowed.");
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x003e */
    @Override // android.content.ContentProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean onCreate() {
        Context context = getContext();
        if (context == null) {
            throw new HttpException("Context cannot be null");
        }
        if (context.getApplicationContext() == null) {
            return true;
        }
        AppInitializer appInitializer = AppInitializer.getInstance(context);
        Class<?> cls = getClass();
        Context context2 = appInitializer.mContext;
        try {
            Trace.beginSection(DatabaseDao_Impl.AnonymousClass17.truncatedTraceSectionLabel("Startup"));
            appInitializer.discoverAndInitialize(context2.getPackageManager().getProviderInfo(new ComponentName(context2, cls), 128).metaData);
            Trace.endSection();
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            throw new HttpException(e);
        }
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        throw new IllegalStateException("Not allowed.");
    }

    @Override // android.content.ContentProvider
    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new IllegalStateException("Not allowed.");
    }
}
