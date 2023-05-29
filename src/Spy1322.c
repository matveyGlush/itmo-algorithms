#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
    int index;
    char letter;
} Pair;

int compare_pairs(const void* a, const void* b) {
    const Pair* p1 = (const Pair*)a;
    const Pair* p2 = (const Pair*)b;
    if (p1->letter != p2->letter) {
        return p1->letter - p2->letter;
    }
    return p1->index - p2->index;
}

void restore(const Pair* pairs, int n, int index) {
    for (int i = 0; i < n; i++) {
        printf("%c", pairs[index].letter);
        index = pairs[index].index;
    }
    printf("\n");
}

int main() {
    int index;
    scanf("%d", &index);
    index--;
    char initial[100001];
    scanf("%s", initial);
    int n = strlen(initial);
    Pair* pairs = (Pair*)malloc(n * sizeof(Pair));
    for (int i = 0; i < n; i++) {
        pairs[i].index = i;
        pairs[i].letter = initial[i];
    }
    qsort(pairs, n, sizeof(Pair), compare_pairs);
    restore(pairs, n, index);
    free(pairs);
    return 0;
}
