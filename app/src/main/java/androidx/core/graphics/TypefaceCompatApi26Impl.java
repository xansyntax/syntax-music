package androidx.core.graphics;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.core.content.res.FontResourcesParserCompat$FontFamilyFilesResourceEntry;
import androidx.core.content.res.FontResourcesParserCompat$FontFileResourceEntry;
import androidx.core.provider.FontsContractCompat$FontInfo;
import coil3.size.SizeKt;
import com.google.common.math.IntMath;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class TypefaceCompatApi26Impl extends SizeKt {
    public static Method sAddFontWeightStyle = null;
    public static Method sCreateFromFamiliesWithDefault = null;
    public static Class sFontFamily = null;
    public static Constructor sFontFamilyCtor = null;
    public static boolean sHasInitBeenCalled = false;
    public final Method mAbortCreation;
    public final Method mAddFontFromAssetManager;
    public final Method mAddFontFromBuffer;
    public final Method mCreateFromFamiliesWithDefault;
    public final Class mFontFamily;
    public final Constructor mFontFamilyCtor;
    public final Method mFreeze;

    public TypefaceCompatApi26Impl() throws NoSuchMethodException {
        Method methodObtainCreateFromFamiliesWithDefaultMethod;
        Constructor<?> constructor;
        Method methodObtainAddFontFromAssetManagerMethod;
        Method method;
        Method method2;
        Method method3;
        Class<?> cls = null;
        try {
            Class<?> cls2 = Class.forName("android.graphics.FontFamily");
            constructor = cls2.getConstructor(null);
            methodObtainAddFontFromAssetManagerMethod = obtainAddFontFromAssetManagerMethod(cls2);
            Class cls3 = Integer.TYPE;
            method = cls2.getMethod("addFontFromBuffer", ByteBuffer.class, cls3, FontVariationAxis[].class, cls3, cls3);
            method2 = cls2.getMethod("freeze", null);
            method3 = cls2.getMethod("abortCreation", null);
            methodObtainCreateFromFamiliesWithDefaultMethod = obtainCreateFromFamiliesWithDefaultMethod(cls2);
            cls = cls2;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class ".concat(e.getClass().getName()), e);
            methodObtainCreateFromFamiliesWithDefaultMethod = null;
            constructor = null;
            methodObtainAddFontFromAssetManagerMethod = null;
            method = null;
            method2 = null;
            method3 = null;
        }
        this.mFontFamily = cls;
        this.mFontFamilyCtor = constructor;
        this.mAddFontFromAssetManager = methodObtainAddFontFromAssetManagerMethod;
        this.mAddFontFromBuffer = method;
        this.mFreeze = method2;
        this.mAbortCreation = method3;
        this.mCreateFromFamiliesWithDefault = methodObtainCreateFromFamiliesWithDefaultMethod;
    }

    public static boolean addFontWeightStyle(String str, boolean z, int i, Object obj) throws NoSuchMethodException {
        init();
        try {
            return ((Boolean) sAddFontWeightStyle.invoke(obj, str, Integer.valueOf(i), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public static void init() throws NoSuchMethodException {
        Method method;
        Class<?> cls;
        Method method2;
        if (sHasInitBeenCalled) {
            return;
        }
        sHasInitBeenCalled = true;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(null);
            method2 = cls.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi21Impl", e.getClass().getName(), e);
            method = null;
            cls = null;
            method2 = null;
        }
        sFontFamilyCtor = constructor;
        sFontFamily = cls;
        sAddFontWeightStyle = method2;
        sCreateFromFamiliesWithDefault = method;
    }

    public static Method obtainAddFontFromAssetManagerMethod(Class cls) {
        Class cls2 = Boolean.TYPE;
        Class cls3 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, cls3, cls2, cls3, cls3, cls3, FontVariationAxis[].class);
    }

    public final boolean addFontFromAssetManager(Context context, Object obj, String str, int i, int i2, int i3, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.mAddFontFromAssetManager.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public Typeface createFromFamiliesWithDefault(Object obj) {
        try {
            Object objNewInstance = Array.newInstance((Class<?>) this.mFontFamily, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) this.mCreateFromFamiliesWithDefault.invoke(null, objNewInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // coil3.size.SizeKt
    public final Typeface createFromFontFamilyFilesResourceEntry(Context context, FontResourcesParserCompat$FontFamilyFilesResourceEntry fontResourcesParserCompat$FontFamilyFilesResourceEntry, Resources resources, int i) throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        Object objNewInstance;
        InputStream inputStreamOpenRawResource;
        FontResourcesParserCompat$FontFileResourceEntry[] fontResourcesParserCompat$FontFileResourceEntryArr = fontResourcesParserCompat$FontFamilyFilesResourceEntry.mEntries;
        Method method = this.mAddFontFromAssetManager;
        if (method == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        int i2 = 0;
        if (method == null) {
            init();
            try {
                Object objNewInstance2 = sFontFamilyCtor.newInstance(null);
                for (FontResourcesParserCompat$FontFileResourceEntry fontResourcesParserCompat$FontFileResourceEntry : fontResourcesParserCompat$FontFileResourceEntryArr) {
                    File tempFile = IntMath.getTempFile(context);
                    if (tempFile != null) {
                        try {
                            try {
                                inputStreamOpenRawResource = resources.openRawResource(fontResourcesParserCompat$FontFileResourceEntry.mResourceId);
                                try {
                                    boolean zCopyToFile = IntMath.copyToFile(tempFile, inputStreamOpenRawResource);
                                    if (inputStreamOpenRawResource != null) {
                                        try {
                                            inputStreamOpenRawResource.close();
                                        } catch (IOException unused) {
                                        }
                                    }
                                    if (!zCopyToFile) {
                                        tempFile.delete();
                                        return null;
                                    }
                                    if (!addFontWeightStyle(tempFile.getPath(), fontResourcesParserCompat$FontFileResourceEntry.mItalic, fontResourcesParserCompat$FontFileResourceEntry.mWeight, objNewInstance2)) {
                                        tempFile.delete();
                                        return null;
                                    }
                                    tempFile.delete();
                                } catch (Throwable th) {
                                    th = th;
                                    Throwable th2 = th;
                                    if (inputStreamOpenRawResource == null) {
                                        throw th2;
                                    }
                                    try {
                                        inputStreamOpenRawResource.close();
                                        throw th2;
                                    } catch (IOException unused2) {
                                        throw th2;
                                    }
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                inputStreamOpenRawResource = null;
                            }
                        } catch (RuntimeException unused3) {
                            tempFile.delete();
                            return null;
                        } catch (Throwable th4) {
                            tempFile.delete();
                            throw th4;
                        }
                    }
                }
                init();
                try {
                    Object objNewInstance3 = Array.newInstance((Class<?>) sFontFamily, 1);
                    Array.set(objNewInstance3, 0, objNewInstance2);
                    return (Typeface) sCreateFromFamiliesWithDefault.invoke(null, objNewInstance3);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            } catch (IllegalAccessException | InstantiationException | InvocationTargetException e2) {
                throw new RuntimeException(e2);
            }
        }
        try {
            objNewInstance = this.mFontFamilyCtor.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused4) {
            objNewInstance = null;
        }
        if (objNewInstance != null) {
            int length = fontResourcesParserCompat$FontFileResourceEntryArr.length;
            while (i2 < length) {
                FontResourcesParserCompat$FontFileResourceEntry fontResourcesParserCompat$FontFileResourceEntry2 = fontResourcesParserCompat$FontFileResourceEntryArr[i2];
                TypefaceCompatApi26Impl typefaceCompatApi26Impl = this;
                Context context2 = context;
                if (typefaceCompatApi26Impl.addFontFromAssetManager(context2, objNewInstance, fontResourcesParserCompat$FontFileResourceEntry2.mFileName, fontResourcesParserCompat$FontFileResourceEntry2.mTtcIndex, fontResourcesParserCompat$FontFileResourceEntry2.mWeight, fontResourcesParserCompat$FontFileResourceEntry2.mItalic ? 1 : 0, FontVariationAxis.fromFontVariationSettings(fontResourcesParserCompat$FontFileResourceEntry2.mVariationSettings))) {
                    i2++;
                    this = typefaceCompatApi26Impl;
                    context = context2;
                } else {
                    try {
                        typefaceCompatApi26Impl.mAbortCreation.invoke(objNewInstance, null);
                    } catch (IllegalAccessException | InvocationTargetException unused5) {
                    }
                }
            }
            TypefaceCompatApi26Impl typefaceCompatApi26Impl2 = this;
            if (typefaceCompatApi26Impl2.freeze(objNewInstance)) {
                return typefaceCompatApi26Impl2.createFromFamiliesWithDefault(objNewInstance);
            }
        }
        return null;
    }

    @Override // coil3.size.SizeKt
    public final Typeface createFromFontInfo(Context context, FontsContractCompat$FontInfo[] fontsContractCompat$FontInfoArr, int i) throws IOException {
        Object objNewInstance;
        Typeface typefaceCreateFromFamiliesWithDefault;
        boolean zBooleanValue;
        if (fontsContractCompat$FontInfoArr.length >= 1) {
            Method method = this.mAddFontFromAssetManager;
            if (method == null) {
                Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
            }
            try {
                if (method != null) {
                    HashMap map = new HashMap();
                    for (FontsContractCompat$FontInfo fontsContractCompat$FontInfo : fontsContractCompat$FontInfoArr) {
                        if (fontsContractCompat$FontInfo.mResultCode == 0) {
                            Uri uri = fontsContractCompat$FontInfo.mUri;
                            if (!map.containsKey(uri)) {
                                map.put(uri, IntMath.mmap(context, uri));
                            }
                        }
                    }
                    Map mapUnmodifiableMap = Collections.unmodifiableMap(map);
                    try {
                        objNewInstance = this.mFontFamilyCtor.newInstance(null);
                    } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
                        objNewInstance = null;
                    }
                    if (objNewInstance != null) {
                        int length = fontsContractCompat$FontInfoArr.length;
                        int i2 = 0;
                        boolean z = false;
                        while (true) {
                            Method method2 = this.mAbortCreation;
                            if (i2 >= length) {
                                if (!z) {
                                    method2.invoke(objNewInstance, null);
                                    break;
                                }
                                if (!freeze(objNewInstance) || (typefaceCreateFromFamiliesWithDefault = createFromFamiliesWithDefault(objNewInstance)) == null) {
                                    break;
                                    break;
                                }
                                return Typeface.create(typefaceCreateFromFamiliesWithDefault, i);
                            }
                            FontsContractCompat$FontInfo fontsContractCompat$FontInfo2 = fontsContractCompat$FontInfoArr[i2];
                            ByteBuffer byteBuffer = (ByteBuffer) mapUnmodifiableMap.get(fontsContractCompat$FontInfo2.mUri);
                            if (byteBuffer != null) {
                                try {
                                    zBooleanValue = ((Boolean) this.mAddFontFromBuffer.invoke(objNewInstance, byteBuffer, Integer.valueOf(fontsContractCompat$FontInfo2.mTtcIndex), null, Integer.valueOf(fontsContractCompat$FontInfo2.mWeight), Integer.valueOf(fontsContractCompat$FontInfo2.mItalic ? 1 : 0))).booleanValue();
                                } catch (IllegalAccessException | InvocationTargetException unused2) {
                                    zBooleanValue = false;
                                }
                                if (!zBooleanValue) {
                                    method2.invoke(objNewInstance, null);
                                    break;
                                }
                                z = true;
                            }
                            i2++;
                            z = z;
                        }
                    }
                } else {
                    int i3 = (i & 1) == 0 ? 400 : 700;
                    boolean z2 = (i & 2) != 0;
                    int i4 = Integer.MAX_VALUE;
                    FontsContractCompat$FontInfo fontsContractCompat$FontInfo3 = null;
                    for (FontsContractCompat$FontInfo fontsContractCompat$FontInfo4 : fontsContractCompat$FontInfoArr) {
                        int iAbs = (Math.abs(fontsContractCompat$FontInfo4.mWeight - i3) * 2) + (fontsContractCompat$FontInfo4.mItalic == z2 ? 0 : 1);
                        if (fontsContractCompat$FontInfo3 == null || i4 > iAbs) {
                            fontsContractCompat$FontInfo3 = fontsContractCompat$FontInfo4;
                            i4 = iAbs;
                        }
                    }
                    ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(fontsContractCompat$FontInfo3.mUri, "r", null);
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        try {
                            Typeface typefaceBuild = new Typeface.Builder(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor()).setWeight(fontsContractCompat$FontInfo3.mWeight).setItalic(fontsContractCompat$FontInfo3.mItalic).build();
                            parcelFileDescriptorOpenFileDescriptor.close();
                            return typefaceBuild;
                        } catch (Throwable th) {
                            try {
                                parcelFileDescriptorOpenFileDescriptor.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    }
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        parcelFileDescriptorOpenFileDescriptor.close();
                        return null;
                    }
                }
            } catch (IOException | IllegalAccessException | InvocationTargetException unused3) {
            }
        }
        return null;
    }

    @Override // coil3.size.SizeKt
    public final Typeface createFromResourcesFontFile(Context context, Resources resources, int i, String str) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Object objNewInstance;
        InputStream inputStreamOpenRawResource;
        Method method = this.mAddFontFromAssetManager;
        if (method == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        if (method != null) {
            try {
                objNewInstance = this.mFontFamilyCtor.newInstance(null);
            } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
                objNewInstance = null;
            }
            if (objNewInstance != null) {
                if (!addFontFromAssetManager(context, objNewInstance, str, 0, -1, -1, null)) {
                    try {
                        this.mAbortCreation.invoke(objNewInstance, null);
                    } catch (IllegalAccessException | InvocationTargetException unused2) {
                    }
                } else if (freeze(objNewInstance)) {
                    return createFromFamiliesWithDefault(objNewInstance);
                }
            }
        } else {
            File tempFile = IntMath.getTempFile(context);
            try {
                if (tempFile != null) {
                    try {
                        inputStreamOpenRawResource = resources.openRawResource(i);
                        try {
                            boolean zCopyToFile = IntMath.copyToFile(tempFile, inputStreamOpenRawResource);
                            if (inputStreamOpenRawResource != null) {
                                try {
                                    inputStreamOpenRawResource.close();
                                } catch (IOException unused3) {
                                }
                            }
                            if (!zCopyToFile) {
                                tempFile.delete();
                                return null;
                            }
                            Typeface typefaceCreateFromFile = Typeface.createFromFile(tempFile.getPath());
                            tempFile.delete();
                            return typefaceCreateFromFile;
                        } catch (Throwable th) {
                            th = th;
                            Throwable th2 = th;
                            if (inputStreamOpenRawResource == null) {
                                throw th2;
                            }
                            try {
                                inputStreamOpenRawResource.close();
                                throw th2;
                            } catch (IOException unused4) {
                                throw th2;
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        inputStreamOpenRawResource = null;
                    }
                }
            } catch (RuntimeException unused5) {
                return null;
            } finally {
                tempFile.delete();
            }
        }
        return null;
    }

    public final boolean freeze(Object obj) {
        try {
            return ((Boolean) this.mFreeze.invoke(obj, null)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public Method obtainCreateFromFamiliesWithDefaultMethod(Class cls) throws NoSuchMethodException {
        Class<?> cls2 = Array.newInstance((Class<?>) cls, 1).getClass();
        Class cls3 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", cls2, cls3, cls3);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
