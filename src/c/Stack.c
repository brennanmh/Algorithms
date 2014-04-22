
#include <stdlib.h>
#include <stdio.h>
#include "Stack.h"


Stack *new_stack() {
  Stack *stack = malloc(sizeof(Stack));

  stack->top = NULL;
  stack->num_items = 0;

  return stack;
}

void *push(Stack *stack, void *item) {

  Stack * newStack;
  Node * node;

  if (stack == NULL) {
    newStack = malloc(sizeof(Stack));
    stack = newStack;
  }

  node = malloc(sizeof(Node));

  node->item = item;
  node->next = stack->top;

  stack->top = node;
  stack->num_items++;

  return(stack);

}

void *pop(Stack *stack) {

  Node * node;
  void * item;

  if (stack == NULL || stack->top == NULL) {
    return NULL;
  }

  node = stack->top;
  stack->top = node->next;

  item = node->item;
  stack->num_items--;
  free(node);

  return item;
}


int main(int argc, char **argvc) {
  printf("Hello World\n");
}
