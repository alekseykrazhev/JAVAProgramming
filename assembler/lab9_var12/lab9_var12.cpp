#include <iostream>

int asmm(int N) {
	int count = 0;
	int no = N * 10;
	int ten = 10, one = 1, res = 0, z = 0.1;
	_asm {
		mov eax, N
		mov ebx, ten
		xor ecx, ecx
		_loop_1 :
		xor edx, edx
			div ebx
			cmp eax, 0
			je _Mark_1
			add ecx, 2
			loop _loop_1
			_Mark_1 :
		mov eax, N
			xor ebx, ebx
			add ebx, 1
			add ecx, 2
			_loop_2 :
			imul ebx, 10
			loop _loop_2
			imul eax, 10
			add eax, ebx
			add eax, 1
			mov res, eax
	}
	return res;
}

int main()
{
    std::cout << "Enter a number:\n";
	int N;
    std::cin >> N;
	
    std::cout << asmm(N);
}
