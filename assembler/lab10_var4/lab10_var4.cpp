#include <iostream>
#include <string>

int removeSpaceASM(char* str) {
    int counter = 0;
    __asm {
        mov   eax, str
        mov   esi, str
        mov   edi, esi
        mov   ebx, esi
        xor ecx, ecx

        iterLoop :
        lodsb //al = eds: [esi++]
            cmp   al, '\0'
            je    emptyStringResult
            cmp   al, ' '
            jne   notSpace
            jcxz  iterLoop
            dec   ecx // --allowed
            stosb // es: [edi++] = al
            jmp   iterLoop

            notSpace :
        inc ecx // if 1 -> 2 (binary 10), 0 -> 1 (binary 01)
            and ecx, 1 // 2 -> 0, 1 -> 1
            add counter, ecx
            mov   ecx, 1
            stosb
            jmp   iterLoop

            emptyStringResult :
        stosb // write the '\0' at final position

            mov   eax, counter
    }
}

int removeSpaceCStyle(char* str) {
    int counter = 0;
    unsigned int strLength = strlen(str) + 1;
    int iter = -1;
    bool isSpace = true;

    while (++iter < strLength && str[iter] == ' ');

    while (iter < strLength) {
        if (str[iter] != ' ') {
            if (isSpace && str[iter] != '\0')
                counter++;

            str[iter++];
            isSpace = false;


        }
        else if (str[iter++] == ' ') {
            if (!isSpace) {
                isSpace = true;
            }

        }
    }

    return counter;
}

int main() {
    const char* inputStr = "sdfsf df sfd dsfs f  sdfs sdf      sdfsdf lhj jkn";
    unsigned int len = strlen(inputStr) + 1;

    char* asmStr = new char[len];
    strcpy_s(asmStr, len, inputStr);

    char* CpStr = new char[len];
    strcpy_s(CpStr, len, inputStr);

    std::cout << "INPUT:";
    std::cout << inputStr << std::endl;
    std::cout << "---------------------------" << std::endl;

    std::cout << "ASM:";
    std::cout << removeSpaceASM(asmStr) << std::endl;
    std::cout << "---------------------------" << std::endl;

    std::cout << "C++:";
    std::cout << removeSpaceCStyle(CpStr) << std::endl;
    return 0;
}