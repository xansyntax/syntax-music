package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.util.Xml;
import androidx.appcompat.app.AppCompatActivity;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.core.content.res.ColorStateListInflaterCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentActivity;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.WeakHashMap;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class NavUtils {
    public static final Object sAppLocaleStorageSync = new Object();

    public static int checkSelfPermission(Context context, String str) {
        if (str == null) {
            PathKt$$ExternalSyntheticBUOutline0.m("permission must be non-null");
            return 0;
        }
        if (Build.VERSION.SDK_INT >= 33 || !TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        }
        return new NotificationManagerCompat(context).mNotificationManager.areNotificationsEnabled() ? 0 : -1;
    }

    public static ColorStateList getColorStateList(Context context, int i) {
        ColorStateList colorStateListCreateFromXml;
        ColorStateList colorStateList;
        ResourcesCompat.ColorStateListCacheEntry colorStateListCacheEntry;
        Resources resources = context.getResources();
        Resources.Theme theme = context.getTheme();
        ResourcesCompat.ColorStateListCacheKey colorStateListCacheKey = new ResourcesCompat.ColorStateListCacheKey(resources, theme);
        synchronized (ResourcesCompat.sColorStateCacheLock) {
            try {
                SparseArray sparseArray = (SparseArray) ResourcesCompat.sColorStateCaches.get(colorStateListCacheKey);
                colorStateListCreateFromXml = null;
                if (sparseArray == null || sparseArray.size() <= 0 || (colorStateListCacheEntry = (ResourcesCompat.ColorStateListCacheEntry) sparseArray.get(i)) == null) {
                    colorStateList = null;
                } else {
                    if (colorStateListCacheEntry.mConfiguration.equals(resources.getConfiguration())) {
                        if (theme != null || colorStateListCacheEntry.mThemeHash != 0) {
                            if (theme == null || colorStateListCacheEntry.mThemeHash != theme.hashCode()) {
                            }
                        }
                        colorStateList = colorStateListCacheEntry.mValue;
                    }
                    sparseArray.remove(i);
                    colorStateList = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (colorStateList != null) {
            return colorStateList;
        }
        ThreadLocal threadLocal = ResourcesCompat.sTempTypedValue;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        resources.getValue(i, typedValue, true);
        int i2 = typedValue.type;
        if (i2 < 28 || i2 > 31) {
            try {
                colorStateListCreateFromXml = ColorStateListInflaterCompat.createFromXml(resources, resources.getXml(i), theme);
            } catch (Exception e) {
                Log.w("ResourcesCompat", "Failed to inflate ColorStateList, leaving it to the framework", e);
            }
        }
        if (colorStateListCreateFromXml == null) {
            return resources.getColorStateList(i, theme);
        }
        synchronized (ResourcesCompat.sColorStateCacheLock) {
            try {
                WeakHashMap weakHashMap = ResourcesCompat.sColorStateCaches;
                SparseArray sparseArray2 = (SparseArray) weakHashMap.get(colorStateListCacheKey);
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    weakHashMap.put(colorStateListCacheKey, sparseArray2);
                }
                sparseArray2.append(i, new ResourcesCompat.ColorStateListCacheEntry(colorStateListCreateFromXml, colorStateListCacheKey.mResources.getConfiguration(), theme));
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return colorStateListCreateFromXml;
    }

    public static Intent getParentActivityIntent(AppCompatActivity appCompatActivity) {
        Intent parentActivityIntent = appCompatActivity.getParentActivityIntent();
        if (parentActivityIntent != null) {
            return parentActivityIntent;
        }
        try {
            String parentActivityName = getParentActivityName(appCompatActivity, appCompatActivity.getComponentName());
            if (parentActivityName == null) {
                return null;
            }
            ComponentName componentName = new ComponentName(appCompatActivity, parentActivityName);
            try {
                return getParentActivityName(appCompatActivity, componentName) == null ? Intent.makeMainActivity(componentName) : new Intent().setComponent(componentName);
            } catch (PackageManager.NameNotFoundException unused) {
                Log.e("NavUtils", "getParentActivityIntent: bad parentActivityName '" + parentActivityName + "' in manifest");
                return null;
            }
        } catch (PackageManager.NameNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static String getParentActivityName(Context context, ComponentName componentName) throws PackageManager.NameNotFoundException {
        String string;
        ActivityInfo activityInfo = context.getPackageManager().getActivityInfo(componentName, Build.VERSION.SDK_INT >= 29 ? 269222528 : 787072);
        String str = activityInfo.parentActivityName;
        if (str != null) {
            return str;
        }
        Bundle bundle = activityInfo.metaData;
        if (bundle == null || (string = bundle.getString("android.support.PARENT_ACTIVITY")) == null) {
            return null;
        }
        if (string.charAt(0) != '.') {
            return string;
        }
        return context.getPackageName() + string;
    }

    /* JADX WARN: Code duplicated, block: B:42:0x003e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static void persistLocales(Context context, String str) {
        synchronized (sAppLocaleStorageSync) {
            if (str.equals("")) {
                context.deleteFile("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
                return;
            }
            try {
                FileOutputStream fileOutputStreamOpenFileOutput = context.openFileOutput("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file", 0);
                XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
                try {
                    try {
                        xmlSerializerNewSerializer.setOutput(fileOutputStreamOpenFileOutput, null);
                        xmlSerializerNewSerializer.startDocument("UTF-8", Boolean.TRUE);
                        xmlSerializerNewSerializer.startTag(null, "locales");
                        xmlSerializerNewSerializer.attribute(null, "application_locales", str);
                        xmlSerializerNewSerializer.endTag(null, "locales");
                        xmlSerializerNewSerializer.endDocument();
                        if (fileOutputStreamOpenFileOutput != null) {
                            try {
                                fileOutputStreamOpenFileOutput.close();
                            } catch (IOException unused) {
                            }
                        }
                    } catch (Throwable th) {
                        if (fileOutputStreamOpenFileOutput != null) {
                            try {
                                fileOutputStreamOpenFileOutput.close();
                            } catch (IOException unused2) {
                            }
                        }
                        throw th;
                    }
                } catch (Exception e) {
                    Log.w("AppLocalesStorageHelper", "Storing App Locales : Failed to persist app-locales in storage ", e);
                    if (fileOutputStreamOpenFileOutput != null) {
                        fileOutputStreamOpenFileOutput.close();
                    }
                }
            } catch (FileNotFoundException unused3) {
                Log.w("AppLocalesStorageHelper", "Storing App Locales : FileNotFoundException: Cannot open file androidx.appcompat.app.AppCompatDelegate.application_locales_record_file for writing ");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:48:0x0046 A[EXC_TOP_SPLITTER, PHI: r1
      0x0046: PHI (r1v2 java.lang.String) = (r1v0 java.lang.String), (r1v4 java.lang.String) binds: [B:29:0x0053, B:23:0x0044] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    public static String readLocales(Context context) {
        String attributeValue;
        synchronized (sAppLocaleStorageSync) {
            attributeValue = "";
            try {
                FileInputStream fileInputStreamOpenFileInput = context.openFileInput("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
                try {
                    try {
                        XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
                        xmlPullParserNewPullParser.setInput(fileInputStreamOpenFileInput, "UTF-8");
                        int depth = xmlPullParserNewPullParser.getDepth();
                        while (true) {
                            int next = xmlPullParserNewPullParser.next();
                            if (next != 1 && (next != 3 || xmlPullParserNewPullParser.getDepth() > depth)) {
                                if (next != 3 && next != 4 && xmlPullParserNewPullParser.getName().equals("locales")) {
                                    attributeValue = xmlPullParserNewPullParser.getAttributeValue(null, "application_locales");
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        if (fileInputStreamOpenFileInput != null) {
                            try {
                                fileInputStreamOpenFileInput.close();
                            } catch (IOException unused) {
                            }
                        }
                    } catch (IOException | XmlPullParserException unused2) {
                        Log.w("AppLocalesStorageHelper", "Reading app Locales : Unable to parse through file :androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
                        if (fileInputStreamOpenFileInput != null) {
                            fileInputStreamOpenFileInput.close();
                        }
                    }
                    if (attributeValue.isEmpty()) {
                        context.deleteFile("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
                    }
                } catch (Throwable th) {
                    if (fileInputStreamOpenFileInput != null) {
                        try {
                            fileInputStreamOpenFileInput.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException unused4) {
                return "";
            }
        }
        return attributeValue;
    }

    public static void requestPermissions(Activity activity, String[] strArr, int i) {
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if (TextUtils.isEmpty(strArr[i2])) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1(IntIntPair$$ExternalSyntheticOutline0.m(new StringBuilder("Permission request for permissions "), Arrays.toString(strArr), " must not contain null or empty values"));
                return;
            }
            if (Build.VERSION.SDK_INT < 33 && TextUtils.equals(strArr[i2], "android.permission.POST_NOTIFICATIONS")) {
                hashSet.add(Integer.valueOf(i2));
            }
        }
        int size = hashSet.size();
        String[] strArr2 = size > 0 ? new String[strArr.length - size] : strArr;
        if (size > 0) {
            if (size == strArr.length) {
                return;
            }
            int i3 = 0;
            for (int i4 = 0; i4 < strArr.length; i4++) {
                if (!hashSet.contains(Integer.valueOf(i4))) {
                    strArr2[i3] = strArr[i4];
                    i3++;
                }
            }
        }
        if (activity instanceof FragmentActivity) {
            ((FragmentActivity) activity).validateRequestPermissionsRequestCode(i);
        }
        activity.requestPermissions(strArr, i);
    }

    public static Intent getParentActivityIntent(Context context, ComponentName componentName) throws PackageManager.NameNotFoundException {
        String parentActivityName = getParentActivityName(context, componentName);
        if (parentActivityName == null) {
            return null;
        }
        ComponentName componentName2 = new ComponentName(componentName.getPackageName(), parentActivityName);
        if (getParentActivityName(context, componentName2) == null) {
            return Intent.makeMainActivity(componentName2);
        }
        return new Intent().setComponent(componentName2);
    }
}
