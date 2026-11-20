package androidx.media3.common.util;

import android.opengl.EGL14;
import android.opengl.EGLDisplay;
import android.os.Bundle;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class GlUtil {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class GlException extends Exception {
        public GlException(String str, RegularImmutableList regularImmutableList) {
            super(str);
            ImmutableList.copyOf((Collection) regularImmutableList);
        }
    }

    public static void checkGlException(String str, boolean z) throws GlException {
        if (z) {
            return;
        }
        ImmutableList.Itr itr = ImmutableList.EMPTY_ITR;
        throw new GlException(str, RegularImmutableList.EMPTY);
    }

    public static RegularImmutableList fromBundleList(Function function, List list) {
        ImmutableList.Builder builder = ImmutableList.builder();
        for (int i = 0; i < list.size(); i++) {
            Bundle bundle = (Bundle) list.get(i);
            bundle.getClass();
            builder.add(function.apply(bundle));
        }
        return builder.build();
    }

    public static String getAttributeValue(XmlPullParser xmlPullParser, String str) {
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            if (xmlPullParser.getAttributeName(i).equals(str)) {
                return xmlPullParser.getAttributeValue(i);
            }
        }
        return null;
    }

    public static boolean isEndTag(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getEventType() == 3 && xmlPullParser.getName().equals(str);
    }

    public static boolean isExtensionSupported(String str) throws GlException {
        EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
        checkGlException("No EGL display.", !eGLDisplayEglGetDisplay.equals(EGL14.EGL_NO_DISPLAY));
        checkGlException("Error in eglInitialize.", EGL14.eglInitialize(eGLDisplayEglGetDisplay, new int[1], 0, new int[1], 0));
        int iEglGetError = EGL14.eglGetError();
        if (iEglGetError == 12288) {
            String strEglQueryString = EGL14.eglQueryString(eGLDisplayEglGetDisplay, 12373);
            return strEglQueryString != null && strEglQueryString.contains(str);
        }
        throw new GlException("Error in getDefaultEglDisplay, error code: 0x" + Integer.toHexString(iEglGetError), ImmutableList.of((Object) Integer.valueOf(iEglGetError)));
    }

    public static boolean isStartTag(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getEventType() == 2 && xmlPullParser.getName().equals(str);
    }

    public static ArrayList toBundleArrayList(Collection collection, Function function) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add((Bundle) function.apply(it.next()));
        }
        return arrayList;
    }
}
