package com.atilika.kuromoji.util;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class SimpleResourceResolver implements ResourceResolver {
    private Class<?> clazz;

    public SimpleResourceResolver(Class<?> cls) {
        this.clazz = cls;
    }

    @Override // com.atilika.kuromoji.util.ResourceResolver
    public InputStream resolve(String str) throws IOException {
        InputStream resourceAsStream = this.clazz.getResourceAsStream(str);
        if (resourceAsStream != null) {
            return resourceAsStream;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$3(Fragment$5$$ExternalSyntheticOutline0.m("Classpath resource not found: ", str));
        return null;
    }
}
