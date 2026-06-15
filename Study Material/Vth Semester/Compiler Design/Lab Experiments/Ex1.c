//Write a progeam in C to check whether given input is character, digit and special character.
#include <stdio.h>

int main() {
    char input;

    printf("Enter a character: ");
    scanf("%c", &input);


    if (input >= '0' && input <= '9') {
        printf("The input is a digit.\n");
    }
    
    else if ((input >= 'a' && input <= 'z') || (input >= 'A' && input <= 'Z')) {
        printf("The input is a letter.\n");
    }

    else {
        printf("The input is a special character.\n");
    }

    return 0;
}
