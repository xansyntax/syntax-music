package androidx.core.content;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import io.ktor.http.ContentDisposition;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import io.ktor.websocket.WebSocketDeflateExtensionKt;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class FileProvider extends ContentProvider {
    public static final String[] COLUMNS = {"_display_name", "_size"};
    public static final File DEVICE_ROOT = new File("/");
    public static final HashMap sCache = new HashMap();
    public String mAuthority;
    public SimplePathStrategy mLocalPathStrategy;
    public final Object mLock;
    public final int mResourceId;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class SimplePathStrategy {
        public final String mAuthority;
        public final HashMap mRoots = new HashMap();

        public SimplePathStrategy(String str) {
            this.mAuthority = str;
        }

        public final File getFileForUri(Uri uri) {
            String encodedPath = uri.getEncodedPath();
            int iIndexOf = encodedPath.indexOf(47, 1);
            if (iIndexOf == -1) {
                PathKt$$ExternalSyntheticBUOutline0.m$3(uri, "Unable to find path from root: ");
                return null;
            }
            String strDecode = Uri.decode(encodedPath.substring(1, iIndexOf));
            String strDecode2 = Uri.decode(encodedPath.substring(iIndexOf + 1));
            File file = (File) this.mRoots.get(strDecode);
            if (file == null) {
                PathKt$$ExternalSyntheticBUOutline0.m$3(uri, "Unable to find configured root for ");
                return null;
            }
            File file2 = new File(file, strDecode2);
            try {
                File canonicalFile = file2.getCanonicalFile();
                if (FileProvider.removeTrailingSlash(canonicalFile.getPath()).startsWith(FileProvider.removeTrailingSlash(file.getPath()).concat("/"))) {
                    return canonicalFile;
                }
                throw new SecurityException("Resolved path jumped beyond configured root");
            } catch (IOException unused) {
                PathKt$$ExternalSyntheticBUOutline0.m$3(file2, "Failed to resolve canonical path for ");
                return null;
            }
        }
    }

    public FileProvider(int i) {
        this.mLock = new Object();
        this.mResourceId = i;
    }

    public static SimplePathStrategy getPathStrategy(Context context, String str, int i) {
        SimplePathStrategy pathStrategy;
        HashMap map = sCache;
        synchronized (map) {
            try {
                pathStrategy = (SimplePathStrategy) map.get(str);
                if (pathStrategy == null) {
                    try {
                        try {
                            pathStrategy = parsePathStrategy(context, str, i);
                            map.put(str, pathStrategy);
                        } catch (IOException e) {
                            throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e);
                        }
                    } catch (XmlPullParserException e2) {
                        throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e2);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return pathStrategy;
    }

    public static Uri getUriForFile(Context context, File file, String str) {
        SimplePathStrategy pathStrategy = getPathStrategy(context, str, 0);
        try {
            String canonicalPath = file.getCanonicalPath();
            Map.Entry entry = null;
            for (Map.Entry entry2 : pathStrategy.mRoots.entrySet()) {
                String path = ((File) entry2.getValue()).getPath();
                if (removeTrailingSlash(canonicalPath).startsWith(removeTrailingSlash(path).concat("/")) && (entry == null || path.length() > ((File) entry.getValue()).getPath().length())) {
                    entry = entry2;
                }
            }
            if (entry == null) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1(Fragment$5$$ExternalSyntheticOutline0.m("Failed to find configured root that contains ", canonicalPath));
                return null;
            }
            String path2 = ((File) entry.getValue()).getPath();
            return new Uri.Builder().scheme("content").authority(pathStrategy.mAuthority).encodedPath(Uri.encode((String) entry.getKey()) + '/' + Uri.encode(path2.endsWith("/") ? canonicalPath.substring(path2.length()) : canonicalPath.substring(path2.length() + 1), "/")).build();
        } catch (IOException unused) {
            PathKt$$ExternalSyntheticBUOutline0.m$3(file, "Failed to resolve canonical path for ");
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00b1  */
    public static SimplePathStrategy parsePathStrategy(Context context, String str, int i) throws XmlPullParserException, IOException {
        File externalStorageDirectory;
        SimplePathStrategy simplePathStrategy = new SimplePathStrategy(str);
        ProviderInfo providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider(str, 128);
        if (providerInfoResolveContentProvider == null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1(Fragment$5$$ExternalSyntheticOutline0.m("Couldn't find meta-data for provider with authority ", str));
            return null;
        }
        if (providerInfoResolveContentProvider.metaData == null && i != 0) {
            Bundle bundle = new Bundle(1);
            providerInfoResolveContentProvider.metaData = bundle;
            bundle.putInt("android.support.FILE_PROVIDER_PATHS", i);
        }
        XmlResourceParser xmlResourceParserLoadXmlMetaData = providerInfoResolveContentProvider.loadXmlMetaData(context.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
        if (xmlResourceParserLoadXmlMetaData == null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Missing android.support.FILE_PROVIDER_PATHS meta-data");
            return null;
        }
        while (true) {
            int next = xmlResourceParserLoadXmlMetaData.next();
            if (next == 1) {
                return simplePathStrategy;
            }
            if (next == 2) {
                String name = xmlResourceParserLoadXmlMetaData.getName();
                String attributeValue = xmlResourceParserLoadXmlMetaData.getAttributeValue(null, ContentDisposition.Parameters.Name);
                String attributeValue2 = xmlResourceParserLoadXmlMetaData.getAttributeValue(null, "path");
                if ("root-path".equals(name)) {
                    externalStorageDirectory = DEVICE_ROOT;
                } else if ("files-path".equals(name)) {
                    externalStorageDirectory = context.getFilesDir();
                } else if ("cache-path".equals(name)) {
                    externalStorageDirectory = context.getCacheDir();
                } else if ("external-path".equals(name)) {
                    externalStorageDirectory = Environment.getExternalStorageDirectory();
                } else if ("external-files-path".equals(name)) {
                    File[] externalFilesDirs = context.getExternalFilesDirs(null);
                    if (externalFilesDirs.length > 0) {
                        externalStorageDirectory = externalFilesDirs[0];
                    } else {
                        externalStorageDirectory = null;
                    }
                } else if ("external-cache-path".equals(name)) {
                    File[] externalCacheDirs = context.getExternalCacheDirs();
                    if (externalCacheDirs.length > 0) {
                        externalStorageDirectory = externalCacheDirs[0];
                    } else {
                        externalStorageDirectory = null;
                    }
                } else if ("external-media-path".equals(name)) {
                    File[] externalMediaDirs = context.getExternalMediaDirs();
                    if (externalMediaDirs.length > 0) {
                        externalStorageDirectory = externalMediaDirs[0];
                    } else {
                        externalStorageDirectory = null;
                    }
                } else {
                    externalStorageDirectory = null;
                }
                if (externalStorageDirectory == null) {
                    continue;
                } else {
                    String str2 = new String[]{attributeValue2}[0];
                    if (str2 != null) {
                        externalStorageDirectory = new File(externalStorageDirectory, str2);
                    }
                    if (TextUtils.isEmpty(attributeValue)) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Name must not be empty");
                        return null;
                    }
                    try {
                        simplePathStrategy.mRoots.put(attributeValue, externalStorageDirectory.getCanonicalFile());
                    } catch (IOException e) {
                        throw new IllegalArgumentException("Failed to resolve canonical path for " + externalStorageDirectory, e);
                    }
                }
            }
        }
    }

    public static String removeTrailingSlash(String str) {
        return (str.length() <= 0 || str.charAt(str.length() + (-1)) != '/') ? str : str.substring(0, str.length() - 1);
    }

    @Override // android.content.ContentProvider
    public final void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (providerInfo.exported) {
            throw new SecurityException("Provider must not be exported");
        }
        if (!providerInfo.grantUriPermissions) {
            throw new SecurityException("Provider must grant uri permissions");
        }
        String str = providerInfo.authority;
        if (str == null || str.trim().isEmpty()) {
            throw new SecurityException("Provider must have a non-empty authority");
        }
        String str2 = providerInfo.authority.split(";")[0];
        synchronized (this.mLock) {
            this.mAuthority = str2;
        }
        HashMap map = sCache;
        synchronized (map) {
            map.remove(str2);
        }
    }

    @Override // android.content.ContentProvider
    public final int delete(Uri uri, String str, String[] strArr) {
        return getLocalPathStrategy().getFileForUri(uri).delete() ? 1 : 0;
    }

    public final SimplePathStrategy getLocalPathStrategy() {
        SimplePathStrategy pathStrategy;
        synchronized (this.mLock) {
            try {
                if (this.mAuthority == null) {
                    throw new NullPointerException("mAuthority is null. Did you override attachInfo and did not call super.attachInfo()?");
                }
                pathStrategy = this.mLocalPathStrategy;
                if (pathStrategy == null) {
                    pathStrategy = getPathStrategy(getContext(), this.mAuthority, this.mResourceId);
                    this.mLocalPathStrategy = pathStrategy;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return pathStrategy;
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri uri) {
        File fileForUri = getLocalPathStrategy().getFileForUri(uri);
        int iLastIndexOf = fileForUri.getName().lastIndexOf(46);
        if (iLastIndexOf < 0) {
            return "application/octet-stream";
        }
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileForUri.getName().substring(iLastIndexOf + 1));
        return mimeTypeFromExtension != null ? mimeTypeFromExtension : "application/octet-stream";
    }

    @Override // android.content.ContentProvider
    public final String getTypeAnonymous(Uri uri) {
        return "application/octet-stream";
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public final ParcelFileDescriptor openFile(Uri uri, String str) {
        int i;
        File fileForUri = getLocalPathStrategy().getFileForUri(uri);
        if ("r".equals(str)) {
            i = WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
        } else if ("w".equals(str) || "wt".equals(str)) {
            i = 738197504;
        } else if ("wa".equals(str)) {
            i = 704643072;
        } else if ("rw".equals(str)) {
            i = 939524096;
        } else {
            if (!"rwt".equals(str)) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1(Fragment$5$$ExternalSyntheticOutline0.m("Invalid mode: ", str));
                return null;
            }
            i = 1006632960;
        }
        return ParcelFileDescriptor.open(fileForUri, i);
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int i;
        File fileForUri = getLocalPathStrategy().getFileForUri(uri);
        String queryParameter = uri.getQueryParameter("displayName");
        if (strArr == null) {
            strArr = COLUMNS;
        }
        String[] strArr3 = new String[strArr.length];
        Object[] objArr = new Object[strArr.length];
        int i2 = 0;
        for (String str3 : strArr) {
            if ("_display_name".equals(str3)) {
                strArr3[i2] = "_display_name";
                i = i2 + 1;
                objArr[i2] = queryParameter == null ? fileForUri.getName() : queryParameter;
            } else {
                if ("_size".equals(str3)) {
                    strArr3[i2] = "_size";
                    i = i2 + 1;
                    objArr[i2] = Long.valueOf(fileForUri.length());
                }
            }
            i2 = i;
        }
        String[] strArr4 = new String[i2];
        System.arraycopy(strArr3, 0, strArr4, 0, i2);
        Object[] objArr2 = new Object[i2];
        System.arraycopy(objArr, 0, objArr2, 0, i2);
        MatrixCursor matrixCursor = new MatrixCursor(strArr4, 1);
        matrixCursor.addRow(objArr2);
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }

    public FileProvider() {
        this(0);
    }
}
