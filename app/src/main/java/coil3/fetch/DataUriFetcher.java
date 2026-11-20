package coil3.fetch;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.util.TypedValue;
import android.webkit.MimeTypeMap;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.core.content.res.ResourcesCompat;
import coil3.Uri;
import coil3.UriKt;
import coil3.decode.AssetMetadata;
import coil3.decode.DataSource;
import coil3.decode.FileImageSource;
import coil3.decode.ResourceMetadata;
import coil3.decode.SourceImageSource;
import coil3.intercept.EngineInterceptor;
import coil3.request.ImageRequestsKt;
import coil3.request.ImageRequests_androidKt;
import coil3.request.Options;
import coil3.size.Precision;
import coil3.size.Size;
import coil3.size.SizeKt;
import coil3.util.MimeTypesKt;
import coil3.util.Utils_androidKt;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.io.IOException;
import java.util.Locale;
import kotlin.collections.CollectionsKt;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__IndentKt;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Buffer;
import okio.FileSystem;
import okio.Path;
import okio.RealBufferedSource;
import okio.internal.ZipFilesKt$$ExternalSyntheticLambda2;
import okio.internal._ZlibJvmKt;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DataUriFetcher implements Fetcher {
    public final /* synthetic */ byte $r8$classId;
    public final Options options;
    public final Uri uri;

    public /* synthetic */ DataUriFetcher(Uri uri, Options options, byte b) {
        this.$r8$classId = b;
        this.uri = uri;
        this.options = options;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0073  */
    @Override // coil3.fetch.Fetcher
    public final Object fetch(EngineInterceptor.C00531 c00531) throws XmlPullParserException, IOException {
        Integer intOrNull;
        String mimeTypeFromExtension;
        Drawable drawable;
        byte b = this.$r8$classId;
        DataSource dataSource = DataSource.DISK;
        Uri uri = this.uri;
        Options options = this.options;
        String mimeTypeFromExtension2 = null;
        switch (b) {
            case 0:
                String str = uri.data;
                int iIndexOf$default = StringsKt.indexOf$default(str, ";base64,", 0, false, 6);
                if (iIndexOf$default == -1) {
                    PathKt$$ExternalSyntheticBUOutline0.m$2(uri, "invalid data uri: ");
                    return null;
                }
                int iIndexOf$default2 = StringsKt.indexOf$default(str, ':', 0, 6);
                if (iIndexOf$default2 == -1) {
                    PathKt$$ExternalSyntheticBUOutline0.m$2(uri, "invalid data uri: ");
                    return null;
                }
                String strSubstring = str.substring(iIndexOf$default2 + 1, iIndexOf$default);
                byte[] bArrDecode$default = Base64.decode$default(Base64.Default, str, iIndexOf$default + 8, 4);
                Buffer buffer = new Buffer();
                buffer.write(bArrDecode$default, 0, bArrDecode$default.length);
                return new SourceFetchResult(new SourceImageSource(buffer, options.fileSystem, null), strSubstring, DataSource.MEMORY);
            case 1:
                String strJoinToString$default = CollectionsKt.joinToString$default(CollectionsKt.drop(UriKt.getPathSegments(uri), 1), "/", null, null, null, 62);
                SourceImageSource sourceImageSource = new SourceImageSource(new RealBufferedSource(StringsKt__IndentKt.source(options.context.getAssets().open(strJoinToString$default))), options.fileSystem, new AssetMetadata(strJoinToString$default));
                if (!StringsKt.isBlank(strJoinToString$default)) {
                    String strSubstringBeforeLast$default = StringsKt.substringBeforeLast$default(StringsKt.substringBeforeLast$default(strJoinToString$default, '#'), '?');
                    String strSubstringAfterLast = StringsKt.substringAfterLast('.', StringsKt.substringAfterLast('/', strSubstringBeforeLast$default, strSubstringBeforeLast$default), "");
                    if (!StringsKt.isBlank(strSubstringAfterLast)) {
                        String lowerCase = strSubstringAfterLast.toLowerCase(Locale.ROOT);
                        lowerCase.getClass();
                        mimeTypeFromExtension2 = (String) MimeTypesKt.mimeTypeData.get(lowerCase);
                        if (mimeTypeFromExtension2 == null) {
                            mimeTypeFromExtension2 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(lowerCase);
                        }
                    }
                }
                return new SourceFetchResult(sourceImageSource, mimeTypeFromExtension2, dataSource);
            case 2:
                String str2 = Path.DIRECTORY_SEPARATOR;
                String filePath = UriKt.getFilePath(uri);
                if (filePath == null) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("filePath == null");
                    return null;
                }
                Path path = Path.Companion.get(filePath);
                FileImageSource fileImageSourceImageSource$default = MathKt.ImageSource$default(path, options.fileSystem, null, null, 28);
                String strSubstringAfterLast2 = StringsKt.substringAfterLast('.', path.name(), "");
                if (!StringsKt.isBlank(strSubstringAfterLast2)) {
                    String lowerCase2 = strSubstringAfterLast2.toLowerCase(Locale.ROOT);
                    lowerCase2.getClass();
                    mimeTypeFromExtension2 = (String) MimeTypesKt.mimeTypeData.get(lowerCase2);
                    if (mimeTypeFromExtension2 == null) {
                        mimeTypeFromExtension2 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(lowerCase2);
                    }
                }
                return new SourceFetchResult(fileImageSourceImageSource$default, mimeTypeFromExtension2, dataSource);
            case 3:
                String str3 = uri.path;
                if (str3 == null) {
                    str3 = "";
                }
                int iIndexOf$default3 = StringsKt.indexOf$default(str3, '!', 0, 6);
                if (iIndexOf$default3 == -1) {
                    PathKt$$ExternalSyntheticBUOutline0.m$2(uri, "Invalid jar:file URI: ");
                    return null;
                }
                String str4 = Path.DIRECTORY_SEPARATOR;
                Path path2 = Path.Companion.get(str3.substring(0, iIndexOf$default3));
                Path path3 = Path.Companion.get(str3.substring(iIndexOf$default3 + 1, str3.length()));
                FileSystem fileSystem = options.fileSystem;
                fileSystem.getClass();
                FileImageSource fileImageSourceImageSource$default2 = MathKt.ImageSource$default(path3, _ZlibJvmKt.openZip(path2, fileSystem, new ZipFilesKt$$ExternalSyntheticLambda2((byte) 0)), null, null, 28);
                String strSubstringAfterLast3 = StringsKt.substringAfterLast('.', path3.name(), "");
                if (!StringsKt.isBlank(strSubstringAfterLast3)) {
                    String lowerCase3 = strSubstringAfterLast3.toLowerCase(Locale.ROOT);
                    lowerCase3.getClass();
                    mimeTypeFromExtension2 = (String) MimeTypesKt.mimeTypeData.get(lowerCase3);
                    if (mimeTypeFromExtension2 == null) {
                        mimeTypeFromExtension2 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(lowerCase3);
                    }
                }
                return new SourceFetchResult(fileImageSourceImageSource$default2, mimeTypeFromExtension2, dataSource);
            default:
                String str5 = uri.authority;
                if (str5 != null) {
                    if (StringsKt.isBlank(str5)) {
                        str5 = null;
                    }
                    if (str5 != null) {
                        String str6 = (String) CollectionsKt.lastOrNull(UriKt.getPathSegments(uri));
                        if (str6 == null || (intOrNull = StringsKt__StringsJVMKt.toIntOrNull(10, str6)) == null) {
                            PathKt$$ExternalSyntheticBUOutline0.m$1(uri, "Invalid android.resource URI: ");
                            return null;
                        }
                        int iIntValue = intOrNull.intValue();
                        Context context = options.context;
                        Resources resources = str5.equals(context.getPackageName()) ? context.getResources() : context.getPackageManager().getResourcesForApplication(str5);
                        TypedValue typedValue = new TypedValue();
                        resources.getValue(iIntValue, typedValue, true);
                        String string = typedValue.string.toString();
                        if (StringsKt.isBlank(string)) {
                            mimeTypeFromExtension = null;
                        } else {
                            String strSubstringBeforeLast$default2 = StringsKt.substringBeforeLast$default(StringsKt.substringBeforeLast$default(string, '#'), '?');
                            String strSubstringAfterLast4 = StringsKt.substringAfterLast('.', StringsKt.substringAfterLast('/', strSubstringBeforeLast$default2, strSubstringBeforeLast$default2), "");
                            if (StringsKt.isBlank(strSubstringAfterLast4)) {
                                mimeTypeFromExtension = null;
                            } else {
                                String lowerCase4 = strSubstringAfterLast4.toLowerCase(Locale.ROOT);
                                lowerCase4.getClass();
                                mimeTypeFromExtension = (String) MimeTypesKt.mimeTypeData.get(lowerCase4);
                                if (mimeTypeFromExtension == null) {
                                    mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(lowerCase4);
                                }
                            }
                        }
                        if (!Intrinsics.areEqual(mimeTypeFromExtension, "text/xml")) {
                            return new SourceFetchResult(new SourceImageSource(new RealBufferedSource(StringsKt__IndentKt.source(resources.openRawResource(iIntValue, new TypedValue()))), options.fileSystem, new ResourceMetadata(str5, iIntValue)), mimeTypeFromExtension, dataSource);
                        }
                        if (str5.equals(context.getPackageName())) {
                            drawable = SizeKt.getDrawable(context, iIntValue);
                            if (drawable == null) {
                                _UtilJvmKt$$ExternalSyntheticLambda0.m((Object) IntIntPair$$ExternalSyntheticOutline0.m(iIntValue, "Invalid resource ID: "));
                                return null;
                            }
                        } else {
                            XmlResourceParser xml = resources.getXml(iIntValue);
                            int next = xml.next();
                            while (next != 2 && next != 1) {
                                next = xml.next();
                            }
                            if (next != 2) {
                                throw new XmlPullParserException("No start tag found.");
                            }
                            Resources.Theme theme = context.getTheme();
                            ThreadLocal threadLocal = ResourcesCompat.sTempTypedValue;
                            drawable = resources.getDrawable(iIntValue, theme);
                            if (drawable == null) {
                                _UtilJvmKt$$ExternalSyntheticLambda0.m((Object) IntIntPair$$ExternalSyntheticOutline0.m(iIntValue, "Invalid resource ID: "));
                                return null;
                            }
                        }
                        Drawable bitmapDrawable = drawable;
                        Bitmap.Config[] configArr = Utils_androidKt.VALID_TRANSFORMATION_CONFIGS;
                        boolean z = bitmapDrawable instanceof VectorDrawable;
                        if (z) {
                            bitmapDrawable = new BitmapDrawable(context.getResources(), MathKt.convertToBitmap(bitmapDrawable, (Bitmap.Config) UriKt.getExtra(options, ImageRequests_androidKt.bitmapConfigKey), options.size, options.scale, (Size) UriKt.getExtra(options, ImageRequestsKt.maxBitmapSizeKey), options.precision == Precision.INEXACT));
                        }
                        return new ImageFetchResult(UriKt.asImage(bitmapDrawable), z, dataSource);
                    }
                }
                PathKt$$ExternalSyntheticBUOutline0.m$1(uri, "Invalid android.resource URI: ");
                return null;
        }
    }
}
