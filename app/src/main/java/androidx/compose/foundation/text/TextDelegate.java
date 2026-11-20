package androidx.compose.foundation.text;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build;
import androidx.compose.ui.semantics.SemanticsSortKt$special$$inlined$thenBy$1;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.profileinstaller.DeviceProfileWriter$$ExternalSyntheticLambda0;
import androidx.profileinstaller.Encoding;
import androidx.profileinstaller.ProfileInstaller$DiagnosticsCallback;
import coil3.ImageLoader$Builder;
import com.metrolist.music.eq.data.Entry;
import com.metrolist.music.eq.data.GitHubAutoEqSearch$$ExternalSyntheticLambda0;
import io.ktor.http.HttpHeaders;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyMap;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.uuid.UuidKt;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.connection.RealCall;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TextDelegate {
    public final Object density;
    public final Object fontFamilyResolver;
    public Object intrinsicsLayoutDirection;
    public Object paragraphIntrinsics;
    public final Object placeholders;
    public boolean softWrap;
    public final Object style;
    public final Object text;

    public TextDelegate(Context context) {
        this.text = new ArrayList();
        this.style = new LinkedHashMap();
        File file = new File(context.getFilesDir(), "autoeq_cache");
        this.density = file;
        this.fontFamilyResolver = new File(file, "tree.json");
        this.placeholders = new File(file, "tree_timestamp");
        this.paragraphIntrinsics = UuidKt.Json$default(new GitHubAutoEqSearch$$ExternalSyntheticLambda0((byte) 2));
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        builder.connectTimeout(15L, timeUnit);
        builder.readTimeout(30L, timeUnit);
        this.intrinsicsLayoutDirection = new OkHttpClient(builder);
    }

    public static String normalizeModelName(String str) {
        Pattern patternCompile = Pattern.compile("\\s*\\([^)]*\\)\\s*");
        patternCompile.getClass();
        str.getClass();
        String strReplaceAll = patternCompile.matcher(str).replaceAll("");
        strReplaceAll.getClass();
        return StringsKt.trim(strReplaceAll).toString();
    }

    public static Map searchModels$default(TextDelegate textDelegate, String str) {
        textDelegate.getClass();
        int i = 0;
        if (!textDelegate.softWrap) {
            Timber.Forest.tag("GitHubAutoEqSearch");
            ConnectionPool.w(new Object[0]);
            return EmptyMap.INSTANCE;
        }
        String lowerCase = str.toLowerCase(Locale.ROOT);
        lowerCase.getClass();
        String string = StringsKt.trim(lowerCase).toString();
        boolean zIsBlank = StringsKt.isBlank(string);
        ArrayList arrayList = (ArrayList) textDelegate.text;
        if (!zIsBlank) {
            ArrayList arrayList2 = new ArrayList();
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                String lowerCase2 = normalizeModelName(((Entry) obj).label).toLowerCase(Locale.ROOT);
                lowerCase2.getClass();
                if (StringsKt.contains(lowerCase2, string, false)) {
                    arrayList2.add(obj);
                }
            }
            arrayList = arrayList2;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int size2 = arrayList.size();
        while (i < size2) {
            Object obj2 = arrayList.get(i);
            i++;
            String strNormalizeModelName = normalizeModelName(((Entry) obj2).label);
            Object arrayList3 = linkedHashMap.get(strNormalizeModelName);
            if (arrayList3 == null) {
                arrayList3 = new ArrayList();
                linkedHashMap.put(strNormalizeModelName, arrayList3);
            }
            ((List) arrayList3).add(obj2);
        }
        List listTake = CollectionsKt.take(CollectionsKt.sortedWith(linkedHashMap.keySet(), new SemanticsSortKt$special$$inlined$thenBy$1((byte) 12, new SemanticsSortKt$special$$inlined$thenBy$1((byte) 11, string))), 100);
        int iMapCapacity = MapsKt__MapsKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(listTake, 10));
        if (iMapCapacity < 16) {
            iMapCapacity = 16;
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(iMapCapacity);
        for (Object obj3 : listTake) {
            linkedHashMap2.put(obj3, (List) MapsKt__MapsKt.getValue(linkedHashMap, (String) obj3));
        }
        return linkedHashMap2;
    }

    public String fetchRawFile(String str) {
        String strString;
        File file = (File) this.density;
        String str2 = File.separator;
        str2.getClass();
        File file2 = new File(file, StringsKt__StringsJVMKt.replace(str, "/", str2, false));
        if (file2.exists() && System.currentTimeMillis() - file2.lastModified() < 86400000) {
            return FilesKt.readText$default(file2);
        }
        try {
            String strConcat = "https://raw.githubusercontent.com/ndellagrotte/AutoEq/master/".concat(CollectionsKt.joinToString$default(StringsKt.split$default(str, new String[]{"/"}, 0, 6), "/", null, null, new GitHubAutoEqSearch$$ExternalSyntheticLambda0((byte) 0), 30));
            Request.Builder builder = new Request.Builder();
            builder.url(strConcat);
            Response responseExecute = new RealCall((OkHttpClient) this.intrinsicsLayoutDirection, new Request(builder), false).execute();
            try {
                if (!responseExecute.isSuccessful) {
                    Timber.Forest.tag("GitHubAutoEqSearch");
                    ConnectionPool.w(str, Integer.valueOf(responseExecute.code));
                    if (file2.exists()) {
                        strString = FilesKt.readText$default(file2);
                        responseExecute.close();
                        return strString;
                    }
                    responseExecute.close();
                    return null;
                }
                ResponseBody responseBody = responseExecute.body;
                if (responseBody != null && (strString = responseBody.string()) != null) {
                    File parentFile = file2.getParentFile();
                    if (parentFile != null) {
                        parentFile.mkdirs();
                    }
                    FilesKt.writeText$default(file2, strString);
                    responseExecute.close();
                    return strString;
                }
                responseExecute.close();
                return null;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CharsKt.closeFinally(responseExecute, th);
                    throw th2;
                }
            }
        } catch (Exception unused) {
            Timber.Forest.tag("GitHubAutoEqSearch");
            ConnectionPool.e$1(str);
            if (file2.exists()) {
                return FilesKt.readText$default(file2);
            }
            return null;
        }
    }

    public String getCachedOrFetchTree() {
        String strString;
        File file = (File) this.placeholders;
        File file2 = (File) this.fontFamilyResolver;
        if (file2.exists() && file.exists()) {
            Long longOrNull = StringsKt__StringsJVMKt.toLongOrNull(StringsKt.trim(FilesKt.readText$default(file)).toString());
            if (System.currentTimeMillis() - (longOrNull != null ? longOrNull.longValue() : 0L) < 86400000) {
                return FilesKt.readText$default(file2);
            }
        }
        try {
            Request.Builder builder = new Request.Builder();
            builder.url("https://api.github.com/repos/ndellagrotte/AutoEq/git/trees/master?recursive=1");
            builder.header(HttpHeaders.Accept, "application/vnd.github+json");
            builder.header("X-GitHub-Api-Version", "2026-03-10");
            Response responseExecute = new RealCall((OkHttpClient) this.intrinsicsLayoutDirection, new Request(builder), false).execute();
            try {
                if (responseExecute.isSuccessful) {
                    ResponseBody responseBody = responseExecute.body;
                    if (responseBody != null && (strString = responseBody.string()) != null) {
                        FilesKt.writeText$default(file2, strString);
                        FilesKt.writeText$default(file, String.valueOf(System.currentTimeMillis()));
                        responseExecute.close();
                        return strString;
                    }
                } else {
                    Timber.Forest.tag("GitHubAutoEqSearch");
                    ConnectionPool.w(new Object[0]);
                    if (file2.exists()) {
                        String text$default = FilesKt.readText$default(file2);
                        responseExecute.close();
                        return text$default;
                    }
                }
                responseExecute.close();
                return null;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CharsKt.closeFinally(responseExecute, th);
                    throw th2;
                }
            }
        } catch (Exception unused) {
            Timber.Forest.tag("GitHubAutoEqSearch");
            ConnectionPool.e$1(new Object[0]);
            if (file2.exists()) {
                return FilesKt.readText$default(file2);
            }
            return null;
        }
    }

    public ArrayList getVariantsForModel(String str) {
        String strNormalizeModelName = normalizeModelName(str);
        ArrayList arrayList = (ArrayList) this.text;
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            if (StringsKt__StringsJVMKt.equals(normalizeModelName(((Entry) obj).label), strNormalizeModelName, true)) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }

    public void layoutIntrinsics(LayoutDirection layoutDirection) {
        ImageLoader$Builder imageLoader$Builder = (ImageLoader$Builder) this.paragraphIntrinsics;
        if (imageLoader$Builder == null || layoutDirection != ((LayoutDirection) this.intrinsicsLayoutDirection) || imageLoader$Builder.getHasStaleResolvedFonts()) {
            this.intrinsicsLayoutDirection = layoutDirection;
            imageLoader$Builder = new ImageLoader$Builder((AnnotatedString) this.text, TextRangeKt.resolveDefaults((TextStyle) this.style, layoutDirection), (FontFamily.Resolver) this.fontFamilyResolver, (Density) this.density, (List) this.placeholders, this.softWrap);
        }
        this.paragraphIntrinsics = imageLoader$Builder;
    }

    public void loadNameIndexForSource(String str) {
        EmptyMap emptyMap = EmptyMap.INSTANCE;
        LinkedHashMap linkedHashMap = (LinkedHashMap) this.style;
        try {
            String strFetchRawFile = fetchRawFile("measurements/" + str + "/name_index.tsv");
            if (strFetchRawFile == null) {
                linkedHashMap.put(str, emptyMap);
                return;
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            Iterator it = CollectionsKt.drop(StringsKt.lines(strFetchRawFile), 1).iterator();
            while (it.hasNext()) {
                List listSplit$default = StringsKt.split$default((String) it.next(), new String[]{"\t"}, 0, 6);
                if (listSplit$default.size() >= 5) {
                    String string = StringsKt.trim((String) listSplit$default.get(2)).toString();
                    String string2 = StringsKt.trim((String) listSplit$default.get(4)).toString();
                    if (!StringsKt.isBlank(string) && !StringsKt.isBlank(string2) && !string2.equals("ignore")) {
                        linkedHashMap2.put(string, string2);
                    }
                }
            }
            linkedHashMap.put(str, linkedHashMap2);
        } catch (Exception unused) {
            linkedHashMap.put(str, emptyMap);
        }
    }

    public FileInputStream openStreamFromAssets(AssetManager assetManager, String str) {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e) {
            String message = e.getMessage();
            if (message == null) {
                return null;
            }
            message.contains("compressed");
            return null;
        }
    }

    public Entry parseEntryFromPath(String str) {
        Object next;
        String str2;
        List listSplit$default = StringsKt.split$default(str, new String[]{"/"}, 0, 6);
        String str3 = null;
        if (listSplit$default.size() < 5) {
            return null;
        }
        String str4 = (String) listSplit$default.get(1);
        String str5 = (String) listSplit$default.get(2);
        String str6 = (String) listSplit$default.get(3);
        Iterator it = CollectionsKt__IterablesKt.listOf((Object[]) new String[]{"in-ear", "over-ear", "earbud"}).iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!StringsKt.contains(str5, (String) next, true));
        String str7 = (String) next;
        String str8 = str7 == null ? "unknown" : str7;
        String string = StringsKt.trim(StringsKt__StringsJVMKt.replace(str5, str8, "", true)).toString();
        if (string.length() == 0) {
            string = "unknown";
        }
        if (string.equals("unknown") || StringsKt.isBlank(string)) {
            LinkedHashMap linkedHashMap = (LinkedHashMap) this.style;
            try {
                if (!linkedHashMap.containsKey(str4)) {
                    loadNameIndexForSource(str4);
                }
                Map map = (Map) linkedHashMap.get(str4);
                if (map != null) {
                    str3 = (String) map.get(str6);
                }
            } catch (Exception unused) {
            }
            if (str3 == null || str3.equals("unknown")) {
                str2 = (Intrinsics.areEqual(str4, "Headphone.com Legacy") || Intrinsics.areEqual(str4, "Innerfidelity")) ? "HMS II.3" : "unknown";
            } else {
                str2 = str3;
            }
        } else {
            str2 = string;
        }
        return new Entry(str6, str8, str2, str4, str5);
    }

    public void result(int i, Serializable serializable) {
        ((Executor) this.text).execute(new DeviceProfileWriter$$ExternalSyntheticLambda0(this, i, serializable));
    }

    public TextDelegate(AnnotatedString annotatedString, TextStyle textStyle, FontFamily.Resolver resolver, Density density, List list, boolean z) {
        this.text = annotatedString;
        this.style = textStyle;
        this.softWrap = z;
        this.density = density;
        this.fontFamilyResolver = resolver;
        this.placeholders = list;
    }

    public TextDelegate(AssetManager assetManager, Executor executor, ProfileInstaller$DiagnosticsCallback profileInstaller$DiagnosticsCallback, String str, File file) {
        byte[] bArr;
        this.softWrap = false;
        this.text = executor;
        this.style = profileInstaller$DiagnosticsCallback;
        this.placeholders = str;
        this.fontFamilyResolver = file;
        int i = Build.VERSION.SDK_INT;
        if (i >= 31) {
            bArr = Encoding.V015_S;
        } else {
            switch (i) {
                case 26:
                    bArr = Encoding.V005_O;
                    break;
                case 27:
                    bArr = Encoding.V009_O_MR1;
                    break;
                case 28:
                case 29:
                case 30:
                    bArr = Encoding.V010_P;
                    break;
                default:
                    bArr = null;
                    break;
            }
        }
        this.density = bArr;
    }
}
