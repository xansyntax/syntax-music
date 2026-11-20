package com.metrolist.music.discord;

import java.util.List;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.ConnectionPool;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class DiscordTemplateRenderer {
    public static final List PLACEHOLDERS = CollectionsKt__IterablesKt.listOf((Object[]) new String[]{"{song.name}", "{artist.name}", "{album.name}", "{song.id}"});

    public static String render(String str, String str2, String str3, String str4, String str5) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        str5.getClass();
        String strReplace = StringsKt__StringsJVMKt.replace(StringsKt__StringsJVMKt.replace(StringsKt__StringsJVMKt.replace(str, "{song.name}", str2, false), "{song.id}", str5, false), "{artist.name}", str3, false);
        if (str4 == null) {
            str4 = "Unknown Album";
        }
        String strReplace2 = StringsKt__StringsJVMKt.replace(strReplace, "{album.name}", str4, false);
        Timber.Forest.tag("DiscordSvc");
        ConnectionPool.v(str, strReplace2);
        return strReplace2;
    }
}
