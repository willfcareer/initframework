package com.xiaomi.ebiz.utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CollectionUtils {
	
	public static <V> Set<V> newHashSet(){
		return new HashSet<V>();
	}
	
	public static <K, V> Map<K, V> newHashMap() {
		return new HashMap<K, V>();
	}
}
