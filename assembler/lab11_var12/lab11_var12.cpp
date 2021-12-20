#include <iostream>

int main(char* argv[])
{
    int x = atoi(argv[0]);
    int k = atoi(argv[1]);
    double res1 = cosh(x);
    std::cout << res1;
    _asm {
        
    };
}
