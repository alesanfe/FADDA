package main.java.common.extension;

import main.java.streams.Stream2;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Set2 {

    public static <E> Set<E> parse(String s, String sep, Function<String, E> f_map) {
        return Arrays.stream(s.split("[" + sep + "]"))
                .filter(e -> e != null && e.length() > 0)
                .map(e -> f_map.apply(e.trim())).collect(Collectors.toSet());
    }

    public static <E> Set<E> parseSet(String[] tokens, Function<String, E> f_map) {
        return Arrays.stream(tokens)
                .filter(e -> e != null && e.length() > 0)
                .map(e -> f_map.apply(e.trim())).collect(Collectors.toSet());
    }

    public static Set<Integer> range(Integer a, Integer b, Integer c) {
        return Stream2.range(a, b, c).boxed()
                .collect(Collectors.toSet());
    }

    public static Set<Integer> range(Integer a, Integer b) {
        return IntStream.range(a, b).boxed().collect(Collectors.toSet());
    }

    public static <T> Set<T> empty() {
        return new HashSet<>();
    }

    public static <T> Set<T> copy(Collection<T> c) {
        return new HashSet<>(c);
    }

    public static <T extends Comparable<? super T>> SortedSet<T> newTreeSet() {
        return new TreeSet<>();
    }

    public static <T> SortedSet<T> newTreeSet(Comparator<T> cmp) {
        return new TreeSet<>(cmp);
    }

    @SafeVarargs
    public static <E> Set<E> of(E... e) {
        return Arrays.stream(e).collect(Collectors.toSet());
    }

    public static <E, U extends Collection<E>> Set<E> of(U elements) {
        return new HashSet<>(elements);
    }

    public static <E> Set<E> difference(Collection<E> s1, Collection<E> s2) {
        Set<E> s = new HashSet<>(s1);
        s.removeAll(s2);
        return s;
    }

    public static <E> Set<E> union(Collection<E> s1, Collection<E> s2) {
        Set<E> s = new HashSet<>(s1);
        s.addAll(s2);
        return s;
    }

    public static <E> Set<E> intersection(Collection<E> s1, Collection<E> s2) {
        Set<E> s = new HashSet<>(s1);
        s.retainAll(s2);
        return s;
    }

    /**
     * M??todo que permite a??adir a un conjunto una palabra si es palindrome.
     *
     * @param word palabra que queremos a??adir si es pal??ndroma.
     * @param set  conjunto en la que a??adiremos la palabra si es pal??ndroma.
     * @return el conjunto con la palabra a??adida (si es pal??ndroma) o no.
     */
    public static Set<String> addIfPalindrome(String word, Set<String> set) {
        if (set.contains(word)) return set;
        for (int i = 0; i <= word.length() / 2; i++) {
            Character left = word.charAt(i);
            Character right = word.charAt(word.length() - 1 - i);
            if (!left.equals(right)) return set;
        }
        set.add(word);
        return set;
    }

    private Set2() {
    }
}
