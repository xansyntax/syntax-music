package okhttp3.internal;

import coil3.network.HttpException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class _UtilJvmKt$$ExternalSyntheticLambda0 {
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void m(String str, Object obj, Object obj2, Object obj3, int i) {
        throw new IllegalArgumentException((str + obj + obj2 + obj3 + ((char) i)).toString());
    }

    public static /* synthetic */ void m$1(String str, Object obj, Object obj2) {
        throw new IllegalStateException((str + obj + obj2).toString());
    }

    public static /* synthetic */ void m$2(int i, String str) {
        throw new IllegalStateException((str + i).toString());
    }

    public static /* synthetic */ void m$3(Object obj, String str) {
        throw new IllegalStateException((str + obj).toString());
    }

    public static /* synthetic */ void m$4(Object obj, String str) {
        throw new IllegalArgumentException((str + obj).toString());
    }

    public static /* synthetic */ void m$5(Object obj, String str) throws IOException {
        throw new IOException(str + obj);
    }

    public static /* synthetic */ void m$6(Object obj, String str) throws FileNotFoundException {
        throw new FileNotFoundException(str + obj);
    }

    public static /* synthetic */ void m$2() {
        throw new HttpException();
    }

    public static /* synthetic */ void m$3(int i, String str) {
        throw new IllegalStateException(str + i);
    }

    public static /* synthetic */ void m$2(Object obj, String str) {
        throw new IllegalArgumentException(str + obj);
    }

    public static /* synthetic */ void m$3(String str) throws IOException {
        throw new IOException(str);
    }

    public static /* synthetic */ void m$2(String str) {
        throw new IllegalStateException(str);
    }

    public static /* synthetic */ void m$1(int i, String str) {
        throw new IllegalStateException((str + i).toString());
    }

    public static /* synthetic */ void m$1(Object obj) {
        throw new IllegalArgumentException(obj.toString());
    }

    public static /* synthetic */ void m$1(Object obj, String str) {
        throw new IllegalStateException(str + obj);
    }

    public static /* synthetic */ void m$1(String str) {
        throw new IllegalArgumentException(str);
    }

    public static /* synthetic */ void m$1() {
        throw new NoSuchElementException();
    }

    public static /* synthetic */ void m$1(StringBuilder sb, int i) {
        sb.append(i);
        throw new IllegalArgumentException(sb.toString().toString());
    }

    public static /* synthetic */ void m(int i, String str) {
        throw new IllegalArgumentException((str + i + '.').toString());
    }

    public static /* synthetic */ void m(Object obj) {
        throw new IllegalStateException(obj.toString());
    }

    public static /* synthetic */ void m(Object obj, String str) {
        throw new IllegalStateException(str + obj + '\'');
    }

    public static /* synthetic */ void m(String str) {
        throw new IndexOutOfBoundsException(str);
    }

    public static /* synthetic */ void m(String str, Object obj, Object obj2) {
        throw new IllegalArgumentException((str + obj + obj2).toString());
    }

    public static /* synthetic */ void m() {
        throw new IllegalStateException();
    }

    public static /* synthetic */ void m(String str, Object obj, Object obj2, Object obj3, Object obj4) {
        throw new IllegalStateException((str + obj + obj2 + obj3 + obj4).toString());
    }

    public static /* synthetic */ void m(StringBuilder sb, int i) {
        sb.append(i);
        throw new IllegalStateException(sb.toString().toString());
    }
}
