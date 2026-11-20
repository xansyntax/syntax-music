package com.metrolist.music;

import com.metrolist.innertube.InnerTube;
import com.metrolist.innertube.YouTube;
import com.metrolist.innertubex.models.YouTubeLocale;
import com.metrolist.lastfm.LastFM;
import com.metrolist.music.constants.PreferenceKeysKt;
import java.util.Locale;
import java.util.Map;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.flow.FlowCollector;
import okhttp3.ConnectionPool;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class App$observeSettingsChanges$2$2 implements FlowCollector {
    public static final App$observeSettingsChanges$2$2 INSTANCE = new App$observeSettingsChanges$2$2(0);
    public static final App$observeSettingsChanges$2$2 INSTANCE$1 = new App$observeSettingsChanges$2$2(1);
    public static final App$observeSettingsChanges$2$2 INSTANCE$2 = new App$observeSettingsChanges$2$2(2);
    public static final App$observeSettingsChanges$2$2 INSTANCE$3 = new App$observeSettingsChanges$2$2(3);
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ App$observeSettingsChanges$2$2(byte b) {
        this.$r8$classId = b;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x002f  */
    /* JADX WARN: Code duplicated, block: B:22:0x003e  */
    /* JADX WARN: Code duplicated, block: B:25:0x004b  */
    /* JADX WARN: Code duplicated, block: B:27:0x004e  */
    /* JADX WARN: Code duplicated, block: B:30:0x0059  */
    /* JADX WARN: Code duplicated, block: B:32:0x005c  */
    /* JADX WARN: Code duplicated, block: B:39:0x006a  */
    /* JADX WARN: Code duplicated, block: B:42:0x0077  */
    /* JADX WARN: Code duplicated, block: B:44:0x007a  */
    /* JADX WARN: Code duplicated, block: B:46:0x0084  */
    /* JADX WARN: Code duplicated, block: B:48:0x0087  */
    /* JADX WARN: Code duplicated, block: B:49:0x008a  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        Locale localeForLanguageTag;
        Map map;
        Map map2;
        byte b = this.$r8$classId;
        String strSubstringBefore$default = null;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                String str = (String) obj;
                YouTube youTube = YouTube.INSTANCE;
                if (str != null) {
                    String str2 = !StringsKt.contains(str, "||", false) ? str : null;
                    if (str2 == null) {
                        String str3 = StringsKt__StringsJVMKt.endsWith(str, "||", false) ? str : null;
                        strSubstringBefore$default = str3 != null ? StringsKt.substringBefore$default(str3, "||") : null;
                        if (strSubstringBefore$default == null) {
                            strSubstringBefore$default = StringsKt.substringAfter(str, "||", str);
                        }
                    } else {
                        strSubstringBefore$default = str2;
                    }
                }
                YouTube.setDataSyncId(strSubstringBefore$default);
                break;
            case 1:
                YouTube youTube2 = YouTube.INSTANCE;
                YouTube.setAuthUser((String) obj);
                break;
            case 2:
                try {
                    LastFM.sessionKey = (String) obj;
                } catch (Exception e) {
                    ConnectionPool connectionPool = Timber.Forest;
                    Object[] objArr = {e.getMessage()};
                    connectionPool.getClass();
                    ConnectionPool.e(objArr);
                }
                break;
            default:
                Triple triple = (Triple) obj;
                String country = (String) triple.first;
                String languageTag = (String) triple.second;
                String str4 = (String) triple.third;
                Locale locale = Locale.getDefault();
                if (str4 == null) {
                    localeForLanguageTag = locale;
                } else {
                    if (str4.equals("SYSTEM_DEFAULT")) {
                        str4 = null;
                    }
                    if (str4 == null || (localeForLanguageTag = Locale.forLanguageTag(str4)) == null) {
                        localeForLanguageTag = locale;
                    }
                }
                YouTube youTube3 = YouTube.INSTANCE;
                if (country == null) {
                    country = localeForLanguageTag.getCountry();
                    map = PreferenceKeysKt.CountryCodeToName;
                    if (!map.containsKey(country)) {
                        country = null;
                    }
                    if (country == null) {
                        country = locale.getCountry();
                        if (!map.containsKey(country)) {
                            country = null;
                        }
                        if (country == null) {
                            country = "US";
                        }
                    }
                } else {
                    if (country.equals("SYSTEM_DEFAULT")) {
                        country = null;
                    }
                    if (country == null) {
                        country = localeForLanguageTag.getCountry();
                        map = PreferenceKeysKt.CountryCodeToName;
                        if (!map.containsKey(country)) {
                            country = null;
                        }
                        if (country == null) {
                            country = locale.getCountry();
                            if (!map.containsKey(country)) {
                                country = null;
                            }
                            if (country == null) {
                                country = "US";
                            }
                        }
                    }
                }
                if (languageTag == null) {
                    languageTag = localeForLanguageTag.toLanguageTag();
                    map2 = PreferenceKeysKt.LanguageCodeToName;
                    if (!map2.containsKey(languageTag)) {
                        languageTag = null;
                    }
                    if (languageTag == null) {
                        String language = localeForLanguageTag.getLanguage();
                        strSubstringBefore$default = map2.containsKey(language) ? language : null;
                        if (strSubstringBefore$default == null) {
                            languageTag = "en";
                        } else {
                            languageTag = strSubstringBefore$default;
                        }
                    }
                } else {
                    if (languageTag.equals("SYSTEM_DEFAULT")) {
                        languageTag = null;
                    }
                    if (languageTag == null) {
                        languageTag = localeForLanguageTag.toLanguageTag();
                        map2 = PreferenceKeysKt.LanguageCodeToName;
                        if (!map2.containsKey(languageTag)) {
                            languageTag = null;
                        }
                        if (languageTag == null) {
                            String language2 = localeForLanguageTag.getLanguage();
                            if (map2.containsKey(language2)) {
                            }
                            if (strSubstringBefore$default == null) {
                                languageTag = "en";
                            } else {
                                languageTag = strSubstringBefore$default;
                            }
                        }
                    }
                }
                YouTubeLocale youTubeLocale = new YouTubeLocale(country, languageTag);
                InnerTube innerTube = YouTube.innerTube;
                innerTube.getClass();
                innerTube.innerTubeX.setLocale(youTubeLocale);
                break;
        }
        return unit;
        return unit;
    }
}
