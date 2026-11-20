package androidx.navigation;

import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import coil3.util.UtilsKt;
import com.google.common.math.IntMath;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.SynchronizedLazyImpl;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.text.MatchGroup;
import kotlin.text.MatcherMatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class NavDeepLink {
    public final Lazy fragArgs$delegate;
    public final Lazy fragArgsAndRegex$delegate;
    public final SynchronizedLazyImpl fragPattern$delegate;
    public final Lazy fragRegex$delegate;
    public final boolean isExactDeepLink;
    public final SynchronizedLazyImpl isParameterizedQuery$delegate;
    public boolean isSingleQueryParamValueOnly;
    public final ArrayList pathArgs;
    public final SynchronizedLazyImpl pathPattern$delegate;
    public final String pathRegex;
    public final Lazy queryArgsMap$delegate;
    public final String uriPattern;
    public static final Regex SCHEME_PATTERN = new Regex("^[a-zA-Z]+[+\\w\\-.]*:");
    public static final Regex FILL_IN_PATTERN = new Regex("\\{(.+?)\\}");
    public static final Regex SCHEME_REGEX = new Regex("http[s]?://");
    public static final Regex WILDCARD_REGEX = new Regex(".*");
    public static final Regex PATH_REGEX = new Regex("([^/]*?|)");
    public static final Regex QUERY_PATTERN = new Regex("^[^?#]+\\?([^#]*).*");

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ParamQuery {
        public final ArrayList arguments = new ArrayList();
        public String paramRegex;
    }

    public NavDeepLink(String str) {
        this.uriPattern = str;
        ArrayList arrayList = new ArrayList();
        this.pathArgs = arrayList;
        boolean z = false;
        z = false;
        final byte b = z ? (byte) 1 : (byte) 0;
        this.pathPattern$delegate = new SynchronizedLazyImpl(new Function0(this) { // from class: androidx.navigation.NavDeepLink$$ExternalSyntheticLambda0
            public final /* synthetic */ NavDeepLink f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                List list;
                byte b2 = b;
                NavDeepLink navDeepLink = this.f$0;
                switch (b2) {
                    case 0:
                        String str2 = navDeepLink.pathRegex;
                        if (str2 != null) {
                            return new Regex(str2, 0);
                        }
                        return null;
                    case 1:
                        return Boolean.valueOf(NavDeepLink.QUERY_PATTERN.matches(navDeepLink.uriPattern));
                    case 2:
                        String str3 = navDeepLink.uriPattern;
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        if (((Boolean) navDeepLink.isParameterizedQuery$delegate.getValue()).booleanValue()) {
                            Uri uri = Uri.parse(str3);
                            uri.getClass();
                            for (String str4 : uri.getQueryParameterNames()) {
                                StringBuilder sb = new StringBuilder();
                                List<String> queryParameters = uri.getQueryParameters(str4);
                                if (queryParameters.size() > 1) {
                                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) Fragment$5$$ExternalSyntheticOutline0.m("Query parameter ", str4, " must only be present once in ", str3, ". To support repeated query parameters, use an array type for your argument and the pattern provided in your URI will be used to parse each query parameter instance."));
                                    return null;
                                }
                                String str5 = (String) CollectionsKt.firstOrNull((List) queryParameters);
                                if (str5 == null) {
                                    navDeepLink.isSingleQueryParamValueOnly = true;
                                    str5 = str4;
                                }
                                NavDeepLink.ParamQuery paramQuery = new NavDeepLink.ParamQuery();
                                int i = 0;
                                for (MatcherMatchResult matcherMatchResultFind$default = Regex.find$default(NavDeepLink.FILL_IN_PATTERN, str5); matcherMatchResultFind$default != null; matcherMatchResultFind$default = matcherMatchResultFind$default.next()) {
                                    MatchGroup matchGroup = matcherMatchResultFind$default.groups.get(1);
                                    matchGroup.getClass();
                                    paramQuery.arguments.add(matchGroup.value);
                                    if (matcherMatchResultFind$default.getRange().first > i) {
                                        String strQuote = Pattern.quote(str5.substring(i, matcherMatchResultFind$default.getRange().first));
                                        strQuote.getClass();
                                        sb.append(strQuote);
                                    }
                                    sb.append("([\\s\\S]+?)?");
                                    i = matcherMatchResultFind$default.getRange().last + 1;
                                }
                                if (i < str5.length()) {
                                    String strQuote2 = Pattern.quote(str5.substring(i));
                                    strQuote2.getClass();
                                    sb.append(strQuote2);
                                }
                                sb.append("$");
                                paramQuery.paramRegex = NavDeepLink.saveWildcardInRegex(sb.toString());
                                linkedHashMap.put(str4, paramQuery);
                            }
                        }
                        return linkedHashMap;
                    case 3:
                        String str6 = navDeepLink.uriPattern;
                        Uri uri2 = Uri.parse(str6);
                        uri2.getClass();
                        if (uri2.getFragment() == null) {
                            return null;
                        }
                        ArrayList arrayList2 = new ArrayList();
                        Uri uri3 = Uri.parse(str6);
                        uri3.getClass();
                        String fragment = uri3.getFragment();
                        StringBuilder sb2 = new StringBuilder();
                        fragment.getClass();
                        NavDeepLink.buildRegex(fragment, arrayList2, sb2);
                        return new Pair(arrayList2, sb2.toString());
                    case 4:
                        Pair pair = (Pair) navDeepLink.fragArgsAndRegex$delegate.getValue();
                        return (pair == null || (list = (List) pair.first) == null) ? new ArrayList() : list;
                    case 5:
                        Pair pair2 = (Pair) navDeepLink.fragArgsAndRegex$delegate.getValue();
                        if (pair2 != null) {
                            return (String) pair2.second;
                        }
                        return null;
                    case 6:
                        String str7 = (String) navDeepLink.fragRegex$delegate.getValue();
                        if (str7 != null) {
                            return new Regex(str7, 0);
                        }
                        return null;
                    default:
                        return null;
                }
            }
        });
        final byte b2 = 1;
        this.isParameterizedQuery$delegate = new SynchronizedLazyImpl(new Function0(this) { // from class: androidx.navigation.NavDeepLink$$ExternalSyntheticLambda0
            public final /* synthetic */ NavDeepLink f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                List list;
                byte b3 = b2;
                NavDeepLink navDeepLink = this.f$0;
                switch (b3) {
                    case 0:
                        String str2 = navDeepLink.pathRegex;
                        if (str2 != null) {
                            return new Regex(str2, 0);
                        }
                        return null;
                    case 1:
                        return Boolean.valueOf(NavDeepLink.QUERY_PATTERN.matches(navDeepLink.uriPattern));
                    case 2:
                        String str3 = navDeepLink.uriPattern;
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        if (((Boolean) navDeepLink.isParameterizedQuery$delegate.getValue()).booleanValue()) {
                            Uri uri = Uri.parse(str3);
                            uri.getClass();
                            for (String str4 : uri.getQueryParameterNames()) {
                                StringBuilder sb = new StringBuilder();
                                List<String> queryParameters = uri.getQueryParameters(str4);
                                if (queryParameters.size() > 1) {
                                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) Fragment$5$$ExternalSyntheticOutline0.m("Query parameter ", str4, " must only be present once in ", str3, ". To support repeated query parameters, use an array type for your argument and the pattern provided in your URI will be used to parse each query parameter instance."));
                                    return null;
                                }
                                String str5 = (String) CollectionsKt.firstOrNull((List) queryParameters);
                                if (str5 == null) {
                                    navDeepLink.isSingleQueryParamValueOnly = true;
                                    str5 = str4;
                                }
                                NavDeepLink.ParamQuery paramQuery = new NavDeepLink.ParamQuery();
                                int i = 0;
                                for (MatcherMatchResult matcherMatchResultFind$default = Regex.find$default(NavDeepLink.FILL_IN_PATTERN, str5); matcherMatchResultFind$default != null; matcherMatchResultFind$default = matcherMatchResultFind$default.next()) {
                                    MatchGroup matchGroup = matcherMatchResultFind$default.groups.get(1);
                                    matchGroup.getClass();
                                    paramQuery.arguments.add(matchGroup.value);
                                    if (matcherMatchResultFind$default.getRange().first > i) {
                                        String strQuote = Pattern.quote(str5.substring(i, matcherMatchResultFind$default.getRange().first));
                                        strQuote.getClass();
                                        sb.append(strQuote);
                                    }
                                    sb.append("([\\s\\S]+?)?");
                                    i = matcherMatchResultFind$default.getRange().last + 1;
                                }
                                if (i < str5.length()) {
                                    String strQuote2 = Pattern.quote(str5.substring(i));
                                    strQuote2.getClass();
                                    sb.append(strQuote2);
                                }
                                sb.append("$");
                                paramQuery.paramRegex = NavDeepLink.saveWildcardInRegex(sb.toString());
                                linkedHashMap.put(str4, paramQuery);
                            }
                        }
                        return linkedHashMap;
                    case 3:
                        String str6 = navDeepLink.uriPattern;
                        Uri uri2 = Uri.parse(str6);
                        uri2.getClass();
                        if (uri2.getFragment() == null) {
                            return null;
                        }
                        ArrayList arrayList2 = new ArrayList();
                        Uri uri3 = Uri.parse(str6);
                        uri3.getClass();
                        String fragment = uri3.getFragment();
                        StringBuilder sb2 = new StringBuilder();
                        fragment.getClass();
                        NavDeepLink.buildRegex(fragment, arrayList2, sb2);
                        return new Pair(arrayList2, sb2.toString());
                    case 4:
                        Pair pair = (Pair) navDeepLink.fragArgsAndRegex$delegate.getValue();
                        return (pair == null || (list = (List) pair.first) == null) ? new ArrayList() : list;
                    case 5:
                        Pair pair2 = (Pair) navDeepLink.fragArgsAndRegex$delegate.getValue();
                        if (pair2 != null) {
                            return (String) pair2.second;
                        }
                        return null;
                    case 6:
                        String str7 = (String) navDeepLink.fragRegex$delegate.getValue();
                        if (str7 != null) {
                            return new Regex(str7, 0);
                        }
                        return null;
                    default:
                        return null;
                }
            }
        });
        final byte b3 = 2;
        Function0 function0 = new Function0(this) { // from class: androidx.navigation.NavDeepLink$$ExternalSyntheticLambda0
            public final /* synthetic */ NavDeepLink f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                List list;
                byte b4 = b3;
                NavDeepLink navDeepLink = this.f$0;
                switch (b4) {
                    case 0:
                        String str2 = navDeepLink.pathRegex;
                        if (str2 != null) {
                            return new Regex(str2, 0);
                        }
                        return null;
                    case 1:
                        return Boolean.valueOf(NavDeepLink.QUERY_PATTERN.matches(navDeepLink.uriPattern));
                    case 2:
                        String str3 = navDeepLink.uriPattern;
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        if (((Boolean) navDeepLink.isParameterizedQuery$delegate.getValue()).booleanValue()) {
                            Uri uri = Uri.parse(str3);
                            uri.getClass();
                            for (String str4 : uri.getQueryParameterNames()) {
                                StringBuilder sb = new StringBuilder();
                                List<String> queryParameters = uri.getQueryParameters(str4);
                                if (queryParameters.size() > 1) {
                                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) Fragment$5$$ExternalSyntheticOutline0.m("Query parameter ", str4, " must only be present once in ", str3, ". To support repeated query parameters, use an array type for your argument and the pattern provided in your URI will be used to parse each query parameter instance."));
                                    return null;
                                }
                                String str5 = (String) CollectionsKt.firstOrNull((List) queryParameters);
                                if (str5 == null) {
                                    navDeepLink.isSingleQueryParamValueOnly = true;
                                    str5 = str4;
                                }
                                NavDeepLink.ParamQuery paramQuery = new NavDeepLink.ParamQuery();
                                int i = 0;
                                for (MatcherMatchResult matcherMatchResultFind$default = Regex.find$default(NavDeepLink.FILL_IN_PATTERN, str5); matcherMatchResultFind$default != null; matcherMatchResultFind$default = matcherMatchResultFind$default.next()) {
                                    MatchGroup matchGroup = matcherMatchResultFind$default.groups.get(1);
                                    matchGroup.getClass();
                                    paramQuery.arguments.add(matchGroup.value);
                                    if (matcherMatchResultFind$default.getRange().first > i) {
                                        String strQuote = Pattern.quote(str5.substring(i, matcherMatchResultFind$default.getRange().first));
                                        strQuote.getClass();
                                        sb.append(strQuote);
                                    }
                                    sb.append("([\\s\\S]+?)?");
                                    i = matcherMatchResultFind$default.getRange().last + 1;
                                }
                                if (i < str5.length()) {
                                    String strQuote2 = Pattern.quote(str5.substring(i));
                                    strQuote2.getClass();
                                    sb.append(strQuote2);
                                }
                                sb.append("$");
                                paramQuery.paramRegex = NavDeepLink.saveWildcardInRegex(sb.toString());
                                linkedHashMap.put(str4, paramQuery);
                            }
                        }
                        return linkedHashMap;
                    case 3:
                        String str6 = navDeepLink.uriPattern;
                        Uri uri2 = Uri.parse(str6);
                        uri2.getClass();
                        if (uri2.getFragment() == null) {
                            return null;
                        }
                        ArrayList arrayList2 = new ArrayList();
                        Uri uri3 = Uri.parse(str6);
                        uri3.getClass();
                        String fragment = uri3.getFragment();
                        StringBuilder sb2 = new StringBuilder();
                        fragment.getClass();
                        NavDeepLink.buildRegex(fragment, arrayList2, sb2);
                        return new Pair(arrayList2, sb2.toString());
                    case 4:
                        Pair pair = (Pair) navDeepLink.fragArgsAndRegex$delegate.getValue();
                        return (pair == null || (list = (List) pair.first) == null) ? new ArrayList() : list;
                    case 5:
                        Pair pair2 = (Pair) navDeepLink.fragArgsAndRegex$delegate.getValue();
                        if (pair2 != null) {
                            return (String) pair2.second;
                        }
                        return null;
                    case 6:
                        String str7 = (String) navDeepLink.fragRegex$delegate.getValue();
                        if (str7 != null) {
                            return new Regex(str7, 0);
                        }
                        return null;
                    default:
                        return null;
                }
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.queryArgsMap$delegate = ResultKt.lazy(lazyThreadSafetyMode, function0);
        final byte b4 = 3;
        this.fragArgsAndRegex$delegate = ResultKt.lazy(lazyThreadSafetyMode, new Function0(this) { // from class: androidx.navigation.NavDeepLink$$ExternalSyntheticLambda0
            public final /* synthetic */ NavDeepLink f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                List list;
                byte b5 = b4;
                NavDeepLink navDeepLink = this.f$0;
                switch (b5) {
                    case 0:
                        String str2 = navDeepLink.pathRegex;
                        if (str2 != null) {
                            return new Regex(str2, 0);
                        }
                        return null;
                    case 1:
                        return Boolean.valueOf(NavDeepLink.QUERY_PATTERN.matches(navDeepLink.uriPattern));
                    case 2:
                        String str3 = navDeepLink.uriPattern;
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        if (((Boolean) navDeepLink.isParameterizedQuery$delegate.getValue()).booleanValue()) {
                            Uri uri = Uri.parse(str3);
                            uri.getClass();
                            for (String str4 : uri.getQueryParameterNames()) {
                                StringBuilder sb = new StringBuilder();
                                List<String> queryParameters = uri.getQueryParameters(str4);
                                if (queryParameters.size() > 1) {
                                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) Fragment$5$$ExternalSyntheticOutline0.m("Query parameter ", str4, " must only be present once in ", str3, ". To support repeated query parameters, use an array type for your argument and the pattern provided in your URI will be used to parse each query parameter instance."));
                                    return null;
                                }
                                String str5 = (String) CollectionsKt.firstOrNull((List) queryParameters);
                                if (str5 == null) {
                                    navDeepLink.isSingleQueryParamValueOnly = true;
                                    str5 = str4;
                                }
                                NavDeepLink.ParamQuery paramQuery = new NavDeepLink.ParamQuery();
                                int i = 0;
                                for (MatcherMatchResult matcherMatchResultFind$default = Regex.find$default(NavDeepLink.FILL_IN_PATTERN, str5); matcherMatchResultFind$default != null; matcherMatchResultFind$default = matcherMatchResultFind$default.next()) {
                                    MatchGroup matchGroup = matcherMatchResultFind$default.groups.get(1);
                                    matchGroup.getClass();
                                    paramQuery.arguments.add(matchGroup.value);
                                    if (matcherMatchResultFind$default.getRange().first > i) {
                                        String strQuote = Pattern.quote(str5.substring(i, matcherMatchResultFind$default.getRange().first));
                                        strQuote.getClass();
                                        sb.append(strQuote);
                                    }
                                    sb.append("([\\s\\S]+?)?");
                                    i = matcherMatchResultFind$default.getRange().last + 1;
                                }
                                if (i < str5.length()) {
                                    String strQuote2 = Pattern.quote(str5.substring(i));
                                    strQuote2.getClass();
                                    sb.append(strQuote2);
                                }
                                sb.append("$");
                                paramQuery.paramRegex = NavDeepLink.saveWildcardInRegex(sb.toString());
                                linkedHashMap.put(str4, paramQuery);
                            }
                        }
                        return linkedHashMap;
                    case 3:
                        String str6 = navDeepLink.uriPattern;
                        Uri uri2 = Uri.parse(str6);
                        uri2.getClass();
                        if (uri2.getFragment() == null) {
                            return null;
                        }
                        ArrayList arrayList2 = new ArrayList();
                        Uri uri3 = Uri.parse(str6);
                        uri3.getClass();
                        String fragment = uri3.getFragment();
                        StringBuilder sb2 = new StringBuilder();
                        fragment.getClass();
                        NavDeepLink.buildRegex(fragment, arrayList2, sb2);
                        return new Pair(arrayList2, sb2.toString());
                    case 4:
                        Pair pair = (Pair) navDeepLink.fragArgsAndRegex$delegate.getValue();
                        return (pair == null || (list = (List) pair.first) == null) ? new ArrayList() : list;
                    case 5:
                        Pair pair2 = (Pair) navDeepLink.fragArgsAndRegex$delegate.getValue();
                        if (pair2 != null) {
                            return (String) pair2.second;
                        }
                        return null;
                    case 6:
                        String str7 = (String) navDeepLink.fragRegex$delegate.getValue();
                        if (str7 != null) {
                            return new Regex(str7, 0);
                        }
                        return null;
                    default:
                        return null;
                }
            }
        });
        final byte b5 = 4;
        this.fragArgs$delegate = ResultKt.lazy(lazyThreadSafetyMode, new Function0(this) { // from class: androidx.navigation.NavDeepLink$$ExternalSyntheticLambda0
            public final /* synthetic */ NavDeepLink f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                List list;
                byte b6 = b5;
                NavDeepLink navDeepLink = this.f$0;
                switch (b6) {
                    case 0:
                        String str2 = navDeepLink.pathRegex;
                        if (str2 != null) {
                            return new Regex(str2, 0);
                        }
                        return null;
                    case 1:
                        return Boolean.valueOf(NavDeepLink.QUERY_PATTERN.matches(navDeepLink.uriPattern));
                    case 2:
                        String str3 = navDeepLink.uriPattern;
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        if (((Boolean) navDeepLink.isParameterizedQuery$delegate.getValue()).booleanValue()) {
                            Uri uri = Uri.parse(str3);
                            uri.getClass();
                            for (String str4 : uri.getQueryParameterNames()) {
                                StringBuilder sb = new StringBuilder();
                                List<String> queryParameters = uri.getQueryParameters(str4);
                                if (queryParameters.size() > 1) {
                                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) Fragment$5$$ExternalSyntheticOutline0.m("Query parameter ", str4, " must only be present once in ", str3, ". To support repeated query parameters, use an array type for your argument and the pattern provided in your URI will be used to parse each query parameter instance."));
                                    return null;
                                }
                                String str5 = (String) CollectionsKt.firstOrNull((List) queryParameters);
                                if (str5 == null) {
                                    navDeepLink.isSingleQueryParamValueOnly = true;
                                    str5 = str4;
                                }
                                NavDeepLink.ParamQuery paramQuery = new NavDeepLink.ParamQuery();
                                int i = 0;
                                for (MatcherMatchResult matcherMatchResultFind$default = Regex.find$default(NavDeepLink.FILL_IN_PATTERN, str5); matcherMatchResultFind$default != null; matcherMatchResultFind$default = matcherMatchResultFind$default.next()) {
                                    MatchGroup matchGroup = matcherMatchResultFind$default.groups.get(1);
                                    matchGroup.getClass();
                                    paramQuery.arguments.add(matchGroup.value);
                                    if (matcherMatchResultFind$default.getRange().first > i) {
                                        String strQuote = Pattern.quote(str5.substring(i, matcherMatchResultFind$default.getRange().first));
                                        strQuote.getClass();
                                        sb.append(strQuote);
                                    }
                                    sb.append("([\\s\\S]+?)?");
                                    i = matcherMatchResultFind$default.getRange().last + 1;
                                }
                                if (i < str5.length()) {
                                    String strQuote2 = Pattern.quote(str5.substring(i));
                                    strQuote2.getClass();
                                    sb.append(strQuote2);
                                }
                                sb.append("$");
                                paramQuery.paramRegex = NavDeepLink.saveWildcardInRegex(sb.toString());
                                linkedHashMap.put(str4, paramQuery);
                            }
                        }
                        return linkedHashMap;
                    case 3:
                        String str6 = navDeepLink.uriPattern;
                        Uri uri2 = Uri.parse(str6);
                        uri2.getClass();
                        if (uri2.getFragment() == null) {
                            return null;
                        }
                        ArrayList arrayList2 = new ArrayList();
                        Uri uri3 = Uri.parse(str6);
                        uri3.getClass();
                        String fragment = uri3.getFragment();
                        StringBuilder sb2 = new StringBuilder();
                        fragment.getClass();
                        NavDeepLink.buildRegex(fragment, arrayList2, sb2);
                        return new Pair(arrayList2, sb2.toString());
                    case 4:
                        Pair pair = (Pair) navDeepLink.fragArgsAndRegex$delegate.getValue();
                        return (pair == null || (list = (List) pair.first) == null) ? new ArrayList() : list;
                    case 5:
                        Pair pair2 = (Pair) navDeepLink.fragArgsAndRegex$delegate.getValue();
                        if (pair2 != null) {
                            return (String) pair2.second;
                        }
                        return null;
                    case 6:
                        String str7 = (String) navDeepLink.fragRegex$delegate.getValue();
                        if (str7 != null) {
                            return new Regex(str7, 0);
                        }
                        return null;
                    default:
                        return null;
                }
            }
        });
        final byte b6 = 5;
        this.fragRegex$delegate = ResultKt.lazy(lazyThreadSafetyMode, new Function0(this) { // from class: androidx.navigation.NavDeepLink$$ExternalSyntheticLambda0
            public final /* synthetic */ NavDeepLink f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                List list;
                byte b7 = b6;
                NavDeepLink navDeepLink = this.f$0;
                switch (b7) {
                    case 0:
                        String str2 = navDeepLink.pathRegex;
                        if (str2 != null) {
                            return new Regex(str2, 0);
                        }
                        return null;
                    case 1:
                        return Boolean.valueOf(NavDeepLink.QUERY_PATTERN.matches(navDeepLink.uriPattern));
                    case 2:
                        String str3 = navDeepLink.uriPattern;
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        if (((Boolean) navDeepLink.isParameterizedQuery$delegate.getValue()).booleanValue()) {
                            Uri uri = Uri.parse(str3);
                            uri.getClass();
                            for (String str4 : uri.getQueryParameterNames()) {
                                StringBuilder sb = new StringBuilder();
                                List<String> queryParameters = uri.getQueryParameters(str4);
                                if (queryParameters.size() > 1) {
                                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) Fragment$5$$ExternalSyntheticOutline0.m("Query parameter ", str4, " must only be present once in ", str3, ". To support repeated query parameters, use an array type for your argument and the pattern provided in your URI will be used to parse each query parameter instance."));
                                    return null;
                                }
                                String str5 = (String) CollectionsKt.firstOrNull((List) queryParameters);
                                if (str5 == null) {
                                    navDeepLink.isSingleQueryParamValueOnly = true;
                                    str5 = str4;
                                }
                                NavDeepLink.ParamQuery paramQuery = new NavDeepLink.ParamQuery();
                                int i = 0;
                                for (MatcherMatchResult matcherMatchResultFind$default = Regex.find$default(NavDeepLink.FILL_IN_PATTERN, str5); matcherMatchResultFind$default != null; matcherMatchResultFind$default = matcherMatchResultFind$default.next()) {
                                    MatchGroup matchGroup = matcherMatchResultFind$default.groups.get(1);
                                    matchGroup.getClass();
                                    paramQuery.arguments.add(matchGroup.value);
                                    if (matcherMatchResultFind$default.getRange().first > i) {
                                        String strQuote = Pattern.quote(str5.substring(i, matcherMatchResultFind$default.getRange().first));
                                        strQuote.getClass();
                                        sb.append(strQuote);
                                    }
                                    sb.append("([\\s\\S]+?)?");
                                    i = matcherMatchResultFind$default.getRange().last + 1;
                                }
                                if (i < str5.length()) {
                                    String strQuote2 = Pattern.quote(str5.substring(i));
                                    strQuote2.getClass();
                                    sb.append(strQuote2);
                                }
                                sb.append("$");
                                paramQuery.paramRegex = NavDeepLink.saveWildcardInRegex(sb.toString());
                                linkedHashMap.put(str4, paramQuery);
                            }
                        }
                        return linkedHashMap;
                    case 3:
                        String str6 = navDeepLink.uriPattern;
                        Uri uri2 = Uri.parse(str6);
                        uri2.getClass();
                        if (uri2.getFragment() == null) {
                            return null;
                        }
                        ArrayList arrayList2 = new ArrayList();
                        Uri uri3 = Uri.parse(str6);
                        uri3.getClass();
                        String fragment = uri3.getFragment();
                        StringBuilder sb2 = new StringBuilder();
                        fragment.getClass();
                        NavDeepLink.buildRegex(fragment, arrayList2, sb2);
                        return new Pair(arrayList2, sb2.toString());
                    case 4:
                        Pair pair = (Pair) navDeepLink.fragArgsAndRegex$delegate.getValue();
                        return (pair == null || (list = (List) pair.first) == null) ? new ArrayList() : list;
                    case 5:
                        Pair pair2 = (Pair) navDeepLink.fragArgsAndRegex$delegate.getValue();
                        if (pair2 != null) {
                            return (String) pair2.second;
                        }
                        return null;
                    case 6:
                        String str7 = (String) navDeepLink.fragRegex$delegate.getValue();
                        if (str7 != null) {
                            return new Regex(str7, 0);
                        }
                        return null;
                    default:
                        return null;
                }
            }
        });
        final byte b7 = 6;
        this.fragPattern$delegate = new SynchronizedLazyImpl(new Function0(this) { // from class: androidx.navigation.NavDeepLink$$ExternalSyntheticLambda0
            public final /* synthetic */ NavDeepLink f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                List list;
                byte b8 = b7;
                NavDeepLink navDeepLink = this.f$0;
                switch (b8) {
                    case 0:
                        String str2 = navDeepLink.pathRegex;
                        if (str2 != null) {
                            return new Regex(str2, 0);
                        }
                        return null;
                    case 1:
                        return Boolean.valueOf(NavDeepLink.QUERY_PATTERN.matches(navDeepLink.uriPattern));
                    case 2:
                        String str3 = navDeepLink.uriPattern;
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        if (((Boolean) navDeepLink.isParameterizedQuery$delegate.getValue()).booleanValue()) {
                            Uri uri = Uri.parse(str3);
                            uri.getClass();
                            for (String str4 : uri.getQueryParameterNames()) {
                                StringBuilder sb = new StringBuilder();
                                List<String> queryParameters = uri.getQueryParameters(str4);
                                if (queryParameters.size() > 1) {
                                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) Fragment$5$$ExternalSyntheticOutline0.m("Query parameter ", str4, " must only be present once in ", str3, ". To support repeated query parameters, use an array type for your argument and the pattern provided in your URI will be used to parse each query parameter instance."));
                                    return null;
                                }
                                String str5 = (String) CollectionsKt.firstOrNull((List) queryParameters);
                                if (str5 == null) {
                                    navDeepLink.isSingleQueryParamValueOnly = true;
                                    str5 = str4;
                                }
                                NavDeepLink.ParamQuery paramQuery = new NavDeepLink.ParamQuery();
                                int i = 0;
                                for (MatcherMatchResult matcherMatchResultFind$default = Regex.find$default(NavDeepLink.FILL_IN_PATTERN, str5); matcherMatchResultFind$default != null; matcherMatchResultFind$default = matcherMatchResultFind$default.next()) {
                                    MatchGroup matchGroup = matcherMatchResultFind$default.groups.get(1);
                                    matchGroup.getClass();
                                    paramQuery.arguments.add(matchGroup.value);
                                    if (matcherMatchResultFind$default.getRange().first > i) {
                                        String strQuote = Pattern.quote(str5.substring(i, matcherMatchResultFind$default.getRange().first));
                                        strQuote.getClass();
                                        sb.append(strQuote);
                                    }
                                    sb.append("([\\s\\S]+?)?");
                                    i = matcherMatchResultFind$default.getRange().last + 1;
                                }
                                if (i < str5.length()) {
                                    String strQuote2 = Pattern.quote(str5.substring(i));
                                    strQuote2.getClass();
                                    sb.append(strQuote2);
                                }
                                sb.append("$");
                                paramQuery.paramRegex = NavDeepLink.saveWildcardInRegex(sb.toString());
                                linkedHashMap.put(str4, paramQuery);
                            }
                        }
                        return linkedHashMap;
                    case 3:
                        String str6 = navDeepLink.uriPattern;
                        Uri uri2 = Uri.parse(str6);
                        uri2.getClass();
                        if (uri2.getFragment() == null) {
                            return null;
                        }
                        ArrayList arrayList2 = new ArrayList();
                        Uri uri3 = Uri.parse(str6);
                        uri3.getClass();
                        String fragment = uri3.getFragment();
                        StringBuilder sb2 = new StringBuilder();
                        fragment.getClass();
                        NavDeepLink.buildRegex(fragment, arrayList2, sb2);
                        return new Pair(arrayList2, sb2.toString());
                    case 4:
                        Pair pair = (Pair) navDeepLink.fragArgsAndRegex$delegate.getValue();
                        return (pair == null || (list = (List) pair.first) == null) ? new ArrayList() : list;
                    case 5:
                        Pair pair2 = (Pair) navDeepLink.fragArgsAndRegex$delegate.getValue();
                        if (pair2 != null) {
                            return (String) pair2.second;
                        }
                        return null;
                    case 6:
                        String str7 = (String) navDeepLink.fragRegex$delegate.getValue();
                        if (str7 != null) {
                            return new Regex(str7, 0);
                        }
                        return null;
                    default:
                        return null;
                }
            }
        });
        final byte b8 = 7;
        new SynchronizedLazyImpl(new Function0(this) { // from class: androidx.navigation.NavDeepLink$$ExternalSyntheticLambda0
            public final /* synthetic */ NavDeepLink f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                List list;
                byte b9 = b8;
                NavDeepLink navDeepLink = this.f$0;
                switch (b9) {
                    case 0:
                        String str2 = navDeepLink.pathRegex;
                        if (str2 != null) {
                            return new Regex(str2, 0);
                        }
                        return null;
                    case 1:
                        return Boolean.valueOf(NavDeepLink.QUERY_PATTERN.matches(navDeepLink.uriPattern));
                    case 2:
                        String str3 = navDeepLink.uriPattern;
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        if (((Boolean) navDeepLink.isParameterizedQuery$delegate.getValue()).booleanValue()) {
                            Uri uri = Uri.parse(str3);
                            uri.getClass();
                            for (String str4 : uri.getQueryParameterNames()) {
                                StringBuilder sb = new StringBuilder();
                                List<String> queryParameters = uri.getQueryParameters(str4);
                                if (queryParameters.size() > 1) {
                                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) Fragment$5$$ExternalSyntheticOutline0.m("Query parameter ", str4, " must only be present once in ", str3, ". To support repeated query parameters, use an array type for your argument and the pattern provided in your URI will be used to parse each query parameter instance."));
                                    return null;
                                }
                                String str5 = (String) CollectionsKt.firstOrNull((List) queryParameters);
                                if (str5 == null) {
                                    navDeepLink.isSingleQueryParamValueOnly = true;
                                    str5 = str4;
                                }
                                NavDeepLink.ParamQuery paramQuery = new NavDeepLink.ParamQuery();
                                int i = 0;
                                for (MatcherMatchResult matcherMatchResultFind$default = Regex.find$default(NavDeepLink.FILL_IN_PATTERN, str5); matcherMatchResultFind$default != null; matcherMatchResultFind$default = matcherMatchResultFind$default.next()) {
                                    MatchGroup matchGroup = matcherMatchResultFind$default.groups.get(1);
                                    matchGroup.getClass();
                                    paramQuery.arguments.add(matchGroup.value);
                                    if (matcherMatchResultFind$default.getRange().first > i) {
                                        String strQuote = Pattern.quote(str5.substring(i, matcherMatchResultFind$default.getRange().first));
                                        strQuote.getClass();
                                        sb.append(strQuote);
                                    }
                                    sb.append("([\\s\\S]+?)?");
                                    i = matcherMatchResultFind$default.getRange().last + 1;
                                }
                                if (i < str5.length()) {
                                    String strQuote2 = Pattern.quote(str5.substring(i));
                                    strQuote2.getClass();
                                    sb.append(strQuote2);
                                }
                                sb.append("$");
                                paramQuery.paramRegex = NavDeepLink.saveWildcardInRegex(sb.toString());
                                linkedHashMap.put(str4, paramQuery);
                            }
                        }
                        return linkedHashMap;
                    case 3:
                        String str6 = navDeepLink.uriPattern;
                        Uri uri2 = Uri.parse(str6);
                        uri2.getClass();
                        if (uri2.getFragment() == null) {
                            return null;
                        }
                        ArrayList arrayList2 = new ArrayList();
                        Uri uri3 = Uri.parse(str6);
                        uri3.getClass();
                        String fragment = uri3.getFragment();
                        StringBuilder sb2 = new StringBuilder();
                        fragment.getClass();
                        NavDeepLink.buildRegex(fragment, arrayList2, sb2);
                        return new Pair(arrayList2, sb2.toString());
                    case 4:
                        Pair pair = (Pair) navDeepLink.fragArgsAndRegex$delegate.getValue();
                        return (pair == null || (list = (List) pair.first) == null) ? new ArrayList() : list;
                    case 5:
                        Pair pair2 = (Pair) navDeepLink.fragArgsAndRegex$delegate.getValue();
                        if (pair2 != null) {
                            return (String) pair2.second;
                        }
                        return null;
                    case 6:
                        String str7 = (String) navDeepLink.fragRegex$delegate.getValue();
                        if (str7 != null) {
                            return new Regex(str7, 0);
                        }
                        return null;
                    default:
                        return null;
                }
            }
        });
        StringBuilder sb = new StringBuilder("^");
        if (!SCHEME_PATTERN.containsMatchIn(str)) {
            String strPattern = SCHEME_REGEX.nativePattern.pattern();
            strPattern.getClass();
            sb.append(strPattern);
        }
        Pattern patternCompile = Pattern.compile("(\\?|#|$)");
        patternCompile.getClass();
        Matcher matcher = patternCompile.matcher(str);
        matcher.getClass();
        MatcherMatchResult matcherMatchResultFindNext = RegexKt.findNext(matcher, 0, str);
        if (matcherMatchResultFindNext != null) {
            buildRegex(str.substring(0, matcherMatchResultFindNext.getRange().first), arrayList, sb);
            if (!WILDCARD_REGEX.containsMatchIn(sb) && !PATH_REGEX.containsMatchIn(sb)) {
                z = true;
            }
            this.isExactDeepLink = z;
            sb.append("($|(\\?(.)*)|(#(.)*))");
        }
        this.pathRegex = saveWildcardInRegex(sb.toString());
    }

    public static void buildRegex(String str, ArrayList arrayList, StringBuilder sb) {
        int i = 0;
        for (MatcherMatchResult matcherMatchResultFind$default = Regex.find$default(FILL_IN_PATTERN, str); matcherMatchResultFind$default != null; matcherMatchResultFind$default = matcherMatchResultFind$default.next()) {
            MatchGroup matchGroup = matcherMatchResultFind$default.groups.get(1);
            matchGroup.getClass();
            arrayList.add(matchGroup.value);
            if (matcherMatchResultFind$default.getRange().first > i) {
                String strQuote = Pattern.quote(str.substring(i, matcherMatchResultFind$default.getRange().first));
                strQuote.getClass();
                sb.append(strQuote);
            }
            String strPattern = PATH_REGEX.nativePattern.pattern();
            strPattern.getClass();
            sb.append(strPattern);
            i = matcherMatchResultFind$default.getRange().last + 1;
        }
        if (i < str.length()) {
            String strQuote2 = Pattern.quote(str.substring(i));
            strQuote2.getClass();
            sb.append(strQuote2);
        }
    }

    public static void parseArgument(Bundle bundle, String str, String str2, NavArgument navArgument) {
        if (navArgument == null) {
            str.getClass();
            bundle.putString(str, str2);
        } else {
            NavType navType = navArgument.type;
            str.getClass();
            navType.put(bundle, str, navType.mo842parseValue(str2));
        }
    }

    public static String saveWildcardInRegex(String str) {
        if (StringsKt.contains(str, "\\Q", false) && StringsKt.contains(str, "\\E", false)) {
            return StringsKt__StringsJVMKt.replace(str, ".*", "\\E.*\\Q", false);
        }
        return StringsKt.contains(str, "\\.\\*", false) ? StringsKt__StringsJVMKt.replace(str, "\\.\\*", ".*", false) : str;
    }

    public final int calculateMatchingPathSegments$navigation_common_release(Uri uri) {
        if (uri == null) {
            return 0;
        }
        List<String> pathSegments = uri.getPathSegments();
        Uri uri2 = Uri.parse(this.uriPattern);
        uri2.getClass();
        List<String> pathSegments2 = uri2.getPathSegments();
        pathSegments.getClass();
        pathSegments2.getClass();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object obj : pathSegments) {
            if (pathSegments2.contains(obj)) {
                linkedHashSet.add(obj);
            }
        }
        return linkedHashSet.size();
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof NavDeepLink)) {
            return false;
        }
        return this.uriPattern.equals(((NavDeepLink) obj).uriPattern);
    }

    public final ArrayList getArgumentsNames$navigation_common_release() {
        Collection collectionValues = ((Map) this.queryArgsMap$delegate.getValue()).values();
        ArrayList arrayList = new ArrayList();
        Iterator it = collectionValues.iterator();
        while (it.hasNext()) {
            CollectionsKt__MutableCollectionsKt.addAll(((ParamQuery) it.next()).arguments, arrayList);
        }
        return CollectionsKt.plus((Iterable) this.fragArgs$delegate.getValue(), (Collection) CollectionsKt.plus((Iterable) arrayList, (Collection) this.pathArgs));
    }

    public final Bundle getMatchingArguments(Uri uri, LinkedHashMap linkedHashMap) {
        MatcherMatchResult matcherMatchResultMatchEntire;
        MatcherMatchResult matcherMatchResultMatchEntire2;
        String strDecode;
        uri.getClass();
        Regex regex = (Regex) this.pathPattern$delegate.getValue();
        if (regex != null && (matcherMatchResultMatchEntire = regex.matchEntire(uri.toString())) != null) {
            Bundle bundleBundleOf = UtilsKt.bundleOf((Pair[]) Arrays.copyOf(new Pair[0], 0));
            if (getMatchingPathArguments(matcherMatchResultMatchEntire, bundleBundleOf, linkedHashMap) && (!((Boolean) this.isParameterizedQuery$delegate.getValue()).booleanValue() || getMatchingQueryArguments(uri, bundleBundleOf, linkedHashMap))) {
                String fragment = uri.getFragment();
                Regex regex2 = (Regex) this.fragPattern$delegate.getValue();
                if (regex2 != null && (matcherMatchResultMatchEntire2 = regex2.matchEntire(String.valueOf(fragment))) != null) {
                    List list = (List) this.fragArgs$delegate.getValue();
                    ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                    int i = 0;
                    for (Object obj : list) {
                        int i2 = i + 1;
                        if (i < 0) {
                            CollectionsKt__IterablesKt.throwIndexOverflow();
                            throw null;
                        }
                        String str = (String) obj;
                        MatchGroup matchGroup = matcherMatchResultMatchEntire2.groups.get(i2);
                        if (matchGroup != null) {
                            strDecode = Uri.decode(matchGroup.value);
                            strDecode.getClass();
                        } else {
                            strDecode = null;
                        }
                        if (strDecode == null) {
                            strDecode = "";
                        }
                        try {
                            parseArgument(bundleBundleOf, str, strDecode, (NavArgument) linkedHashMap.get(str));
                            arrayList.add(Unit.INSTANCE);
                            i = i2;
                        } catch (IllegalArgumentException unused) {
                        }
                    }
                }
                if (IntMath.missingRequiredArguments(linkedHashMap, new NavDeepLink$$ExternalSyntheticLambda8(bundleBundleOf, (byte) 0)).isEmpty()) {
                    return bundleBundleOf;
                }
            }
        }
        return null;
    }

    public final boolean getMatchingPathArguments(MatcherMatchResult matcherMatchResult, Bundle bundle, LinkedHashMap linkedHashMap) {
        ArrayList arrayList = this.pathArgs;
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            int i3 = i + 1;
            String strDecode = null;
            if (i < 0) {
                CollectionsKt__IterablesKt.throwIndexOverflow();
                throw null;
            }
            String str = (String) obj;
            MatchGroup matchGroup = matcherMatchResult.groups.get(i3);
            if (matchGroup != null) {
                strDecode = Uri.decode(matchGroup.value);
                strDecode.getClass();
            }
            if (strDecode == null) {
                strDecode = "";
            }
            try {
                parseArgument(bundle, str, strDecode, (NavArgument) linkedHashMap.get(str));
                arrayList2.add(Unit.INSTANCE);
                i = i3;
            } catch (IllegalArgumentException unused) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00ce  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v1, types: [int] */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r14v8 */
    public final boolean getMatchingQueryArguments(Uri uri, Bundle bundle, LinkedHashMap linkedHashMap) {
        MatcherMatchResult matcherMatchResult;
        ?? r14;
        Object objValueOf;
        boolean z;
        Object obj;
        String query;
        NavDeepLink navDeepLink = this;
        for (Map.Entry entry : ((Map) navDeepLink.queryArgsMap$delegate.getValue()).entrySet()) {
            String str = (String) entry.getKey();
            ParamQuery paramQuery = (ParamQuery) entry.getValue();
            List<String> queryParameters = uri.getQueryParameters(str);
            if (navDeepLink.isSingleQueryParamValueOnly && (query = uri.getQuery()) != null && !query.equals(uri.toString())) {
                queryParameters = CollectionsKt__IterablesKt.listOf(query);
            }
            Unit unit = Unit.INSTANCE;
            boolean z2 = false;
            Bundle bundleBundleOf = UtilsKt.bundleOf((Pair[]) Arrays.copyOf(new Pair[0], 0));
            ArrayList arrayList = paramQuery.arguments;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList.get(i);
                i++;
                String str2 = (String) obj2;
                NavArgument navArgument = (NavArgument) linkedHashMap.get(str2);
                NavType navType = navArgument != null ? navArgument.type : null;
                if ((navType instanceof IntArrayNavType) && !navArgument.isDefaultValuePresent) {
                    IntArrayNavType intArrayNavType = (IntArrayNavType) navType;
                    switch (intArrayNavType.$r8$classId) {
                        case 0:
                            obj = new int[0];
                            break;
                        case 1:
                            obj = new boolean[0];
                            break;
                        case 2:
                            obj = new float[0];
                            break;
                        case 3:
                            obj = new long[0];
                            break;
                        default:
                            obj = new String[0];
                            break;
                    }
                    intArrayNavType.put(bundleBundleOf, str2, obj);
                }
            }
            for (String str3 : queryParameters) {
                String str4 = paramQuery.paramRegex;
                if (str4 != null) {
                    Pattern patternCompile = Pattern.compile(str4);
                    patternCompile.getClass();
                    str3.getClass();
                    Matcher matcher = patternCompile.matcher(str3);
                    matcher.getClass();
                    if (matcher.matches()) {
                        matcherMatchResult = new MatcherMatchResult(matcher, str3);
                    } else {
                        matcherMatchResult = null;
                    }
                } else {
                    matcherMatchResult = null;
                }
                if (matcherMatchResult == null) {
                    return z2;
                }
                ArrayList arrayList2 = paramQuery.arguments;
                ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10));
                int size2 = arrayList2.size();
                boolean z3 = z2;
                int i2 = z3 ? 1 : 0;
                while (i2 < size2) {
                    Object obj3 = arrayList2.get(i2);
                    i2++;
                    int i3 = r14 + 1;
                    if (r14 < 0) {
                        r14 = z3;
                        CollectionsKt__IterablesKt.throwIndexOverflow();
                        throw null;
                    }
                    String str5 = (String) obj3;
                    MatchGroup matchGroup = matcherMatchResult.groups.get(i3);
                    String str6 = matchGroup != null ? matchGroup.value : null;
                    if (str6 == null) {
                        r14 = z3;
                        r14 = z3;
                        str6 = "";
                    }
                    r14 = z3;
                    r14 = z3;
                    NavArgument navArgument2 = (NavArgument) linkedHashMap.get(str5);
                    try {
                        str5.getClass();
                        if (bundleBundleOf.containsKey(str5)) {
                            if (bundleBundleOf.containsKey(str5)) {
                                if (navArgument2 != null) {
                                    NavType navType2 = navArgument2.type;
                                    Object obj4 = navType2.get(str5, bundleBundleOf);
                                    if (!bundleBundleOf.containsKey(str5)) {
                                        throw new IllegalArgumentException("There is no previous value in this savedState.");
                                    }
                                    navType2.put(bundleBundleOf, str5, navType2.parseValue(obj4, str6));
                                    objValueOf = unit;
                                }
                                z = false;
                            } else {
                                z = true;
                            }
                            objValueOf = Boolean.valueOf(z);
                        } else {
                            parseArgument(bundleBundleOf, str5, str6, navArgument2);
                            objValueOf = unit;
                        }
                    } catch (IllegalArgumentException unused) {
                    }
                    arrayList3.add(objValueOf);
                    linkedHashMap = linkedHashMap;
                    r14 = i3;
                    z2 = false;
                }
                r14 = z3;
                linkedHashMap = linkedHashMap;
            }
            bundle.putAll(bundleBundleOf);
            navDeepLink = this;
        }
        return true;
    }

    public final int hashCode() {
        return this.uriPattern.hashCode() * 961;
    }
}
