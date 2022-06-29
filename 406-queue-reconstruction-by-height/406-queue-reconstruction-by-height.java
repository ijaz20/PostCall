class Solution {
    public int[][] reconstructQueue(int[][] pe) {
        return Stream.of(pe)
            .sorted((a , b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0])
            .collect(LinkedList::new, (list, person) -> list.add(person[1], person), LinkedList::addAll)
            .toArray(new int[pe.length][]);
    }
}