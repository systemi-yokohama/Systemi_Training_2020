public static <T> ArrayList<T>
newArrayList(T... data) {
    return new ArrayList<T> (List.of(data));
}