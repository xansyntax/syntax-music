package io.ktor.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.io.FilePathComponents;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.HexFormatKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u0019\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0011\u0010\u0005\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001f\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\b\u001a\u0013\u0010\t\u001a\u00020\u0000*\u00020\u0000H\u0002¢\u0006\u0004\b\t\u0010\u0006\u001a\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u0013\u0010\u0010\u001a\u00020\u000f*\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0013\u0010\u0012\u001a\u00020\u000f*\u00020\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0011\u001a\u0013\u0010\f\u001a\u00020\u0000*\u00020\u0000H\u0002¢\u0006\u0004\b\f\u0010\u0006¨\u0006\u0013"}, d2 = {"Ljava/io/File;", "", "relativePath", "combineSafe", "(Ljava/io/File;Ljava/lang/String;)Ljava/io/File;", "normalizeAndRelativize", "(Ljava/io/File;)Ljava/io/File;", "dir", "(Ljava/io/File;Ljava/io/File;)Ljava/io/File;", "notRooted", "path", "", "dropLeadingTopDirs", "(Ljava/lang/String;)I", "", "", "isPathSeparator", "(C)Z", "isPathSeparatorOrDot", "ktor-utils"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class PathKt {
    private static final File combineSafe(File file, File file2) {
        File fileNormalizeAndRelativize = normalizeAndRelativize(file2);
        fileNormalizeAndRelativize.getClass();
        File file3 = new File("..");
        FilePathComponents components = HexFormatKt.toComponents(fileNormalizeAndRelativize);
        List list = components.segments;
        FilePathComponents components2 = HexFormatKt.toComponents(file3);
        List list2 = components2.segments;
        boolean zEquals = components.root.equals(components2.root);
        boolean zEquals2 = false;
        if (zEquals && list.size() >= list2.size()) {
            zEquals2 = list.subList(0, list2.size()).equals(list2);
        }
        if (zEquals2) {
            PathKt$$ExternalSyntheticBUOutline0.m$3(file2, "Bad relative path ");
            return null;
        }
        if (!fileNormalizeAndRelativize.isAbsolute()) {
            return new File(file, fileNormalizeAndRelativize.getPath());
        }
        PathKt$$ExternalSyntheticBUOutline0.m$2(file2, "Bad relative path ");
        return null;
    }

    public static final int dropLeadingTopDirs(String str) {
        str.getClass();
        int length = str.length() - 1;
        int i = 0;
        while (i <= length) {
            char cCharAt = str.charAt(i);
            if (!isPathSeparator(cCharAt)) {
                if (cCharAt != '.') {
                    break;
                }
                if (i == length) {
                    return i + 1;
                }
                char cCharAt2 = str.charAt(i + 1);
                int i2 = 2;
                if (!isPathSeparator(cCharAt2)) {
                    if (cCharAt2 == '.') {
                        int i3 = i + 2;
                        if (i3 != str.length()) {
                            if (!isPathSeparator(str.charAt(i3))) {
                                break;
                            }
                            i2 = 3;
                        }
                    } else {
                        break;
                    }
                }
                i += i2;
            } else {
                i++;
            }
        }
        return i;
    }

    private static final boolean isPathSeparator(char c) {
        return c == '\\' || c == '/';
    }

    private static final boolean isPathSeparatorOrDot(char c) {
        return c == '.' || isPathSeparator(c);
    }

    public static final File normalizeAndRelativize(File file) {
        file.getClass();
        FilePathComponents components = HexFormatKt.toComponents(file);
        File file2 = components.root;
        List<File> list = components.segments;
        ArrayList arrayList = new ArrayList(list.size());
        for (File file3 : list) {
            String name = file3.getName();
            if (!Intrinsics.areEqual(name, ".")) {
                if (!Intrinsics.areEqual(name, "..")) {
                    arrayList.add(file3);
                } else if (arrayList.isEmpty() || Intrinsics.areEqual(((File) kotlin.collections.CollectionsKt.last(arrayList)).getName(), "..")) {
                    arrayList.add(file3);
                }
            }
        }
        String str = File.separator;
        str.getClass();
        return dropLeadingTopDirs(notRooted(FilesKt.resolve(file2, kotlin.collections.CollectionsKt.joinToString$default(arrayList, str, null, null, null, 62))));
    }

    private static final File notRooted(File file) {
        String strSubstring;
        file.getClass();
        String path = file.getPath();
        path.getClass();
        if (HexFormatKt.getRootLength$FilesKt__FilePathComponentsKt(path) <= 0) {
            return file;
        }
        File file2 = file;
        while (true) {
            File parentFile = file2.getParentFile();
            if (parentFile == null) {
                break;
            }
            file2 = parentFile;
        }
        String path2 = file.getPath();
        path2.getClass();
        String strDrop = StringsKt.drop(file2.getName().length(), path2);
        int length = strDrop.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = strDrop.charAt(i);
            if (cCharAt != '\\' && cCharAt != '/') {
                strSubstring = strDrop.substring(i);
                return new File(strSubstring);
            }
        }
        strSubstring = "";
        return new File(strSubstring);
    }

    private static final File dropLeadingTopDirs(File file) {
        String path = file.getPath();
        if (path == null) {
            path = "";
        }
        int iDropLeadingTopDirs = dropLeadingTopDirs(path);
        if (iDropLeadingTopDirs == 0) {
            return file;
        }
        if (iDropLeadingTopDirs >= file.getPath().length()) {
            return new File(".");
        }
        String path2 = file.getPath();
        path2.getClass();
        return new File(path2.substring(iDropLeadingTopDirs));
    }

    public static final File combineSafe(File file, String str) {
        file.getClass();
        str.getClass();
        return combineSafe(file, new File(str));
    }
}
