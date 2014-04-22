

typedef struct _Stack {
  void *top;
  int num_items;
} Stack;

typedef struct _Node {
  void *item;
  struct _Node *next;
} Node;

Stack *new_stack();
void *push(Stack *, void *);
void *pop(Stack *);

