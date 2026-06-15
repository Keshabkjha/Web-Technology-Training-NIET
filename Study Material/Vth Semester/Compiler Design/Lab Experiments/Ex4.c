// Write a program in to simulate the token generated in lexical analyzer phase(keyword, expression)
#include <stdio.h>
#include <ctype.h>
#include <string.h>
#define MAX_LENGTH 100

const char *keywords[] = {
    "int", "float", "if", "else", "while", "return", "for", "do", "void", "main"
};
int num_keywords = sizeof(keywords) / sizeof(keywords[0]);
int isKeyword(const char *str) {
    for (int i = 0; i < num_keywords; i++) {
        if (strcmp(str, keywords[i]) == 0) {
            return 1;
        }
    }
    return 0;
}
void generateTokens(const char *input) {
    char buffer[MAX_LENGTH];
    int i = 0, j = 0;
    
    while (input[i] != '\0') {
        if (isspace(input[i])) {
            i++;
            continue;
        }
        if (isalpha(input[i])) {
            j = 0;
            while (isalnum(input[i]) || input[i] == '_') {
                buffer[j++] = input[i++];
            }
            buffer[j] = '\0';
            if (isKeyword(buffer)) {
                printf("Keyword: %s\n", buffer);
            } else {
                printf("Identifier: %s\n", buffer);
            }
        }
        else if (isdigit(input[i])) {
            j = 0;
            while (isdigit(input[i])) {
                buffer[j++] = input[i++];
            }
            buffer[j] = '\0';
            printf("Number: %s\n", buffer);
        }
        else {
            printf("Operator/Symbol: %c\n", input[i]);
            i++;
        }
    }
}

int main() {
    char input[MAX_LENGTH];
    
    printf("Enter a simple C expression: ");
    fgets(input, MAX_LENGTH, stdin);

    generateTokens(input);

    return 0;
}
