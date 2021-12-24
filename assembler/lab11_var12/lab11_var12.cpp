#include <string.h>
#include <cmath>
#include <iostream>


double cosh_taylor(double x, int k) {
	int t10 = 10;
	_asm {

		fld t10 ; загрузка вещественного числа
		fld1 ; +1.0 в вещественный стек
		mov eax, k
		mov ebx, 0
		while_take_e:
			fdiv st, st(1)
			dec eax
			cmp eax, ebx
			jne while_take_e

		start :
			fstp st; очистка 10
			; fld e; st(4) = e
			fld x; st(3) = x
			fld1; st(2) = sum
			fldz; st(1) = знаменатель
			fld1; st(0) = step
			fld st; сдвигается нумерация
			fabs ; модуль
			jmp while_calculate

		while_calculate :
			fcomip st, st(5); нормализуется нумерация // сравнение
			jna finish ; <=
			fld1; сдвигается нумерация
			faddp st(2), st ; нормализуется нумерация // сложение
			fdiv st, st(1)
			fld1; сдвигается нумерация
			faddp st(2), st; нормализуется нумерация
			fdiv st, st(1)
			fmul st, st(3)
			fmul st, st(3)
			fadd st(2), st
			fld st
			fabs
			jmp while_calculate

		finish :
			fstp st
			fstp st
			fstp st(2)
			fstp st

	}
}

double p = 1, q = 2;

float fpu_exponent(float x) {
	float result;

	__asm
	{
		finit
		fld x
		fldl2e
		fmulp st(1), st(0); st0 = x * log2(e) = tmp1
		fld1
		fscale; st0 = 2 ^ int(tmp1), st1 = tmp1
		fxch
		fld1
		fxch; st0 = tmp1, st1 = 1, st2 = 2 ^ int(tmp1)

		fprem; st0 = fract(tmp1) = tmp2
		f2xm1; st0 = 2 ^ (tmp2)-1 = tmp3
		faddp st(1), st(0); st0 = tmp3 + 1, st1 = 2 ^ int(tmp1)
		fmulp st(1), st(0); st0 = 2 ^ int(tmp1) + 2 ^ fract(tmp1) = 2 ^ (x * log2(e))

		fst result
		finit
		fld result
		fld p


		fdiv st(0), st(1)
		fld result
		fadd st(0), st(1)
		fld q
		fxch

		fdiv st(0), st(1)
		fst result


		; ret
	}

	return result;
}

int main(int args, char* argv[]) {
	if (args != 3) {
		std::cout << "Invalid number of arguments!";
		exit(-1);
	}
	double x = strtod(argv[1], NULL);
	int k = atoi(argv[2]);
	if (k <= 1 || k >= 16) {
		std::cout << "Invalid arguments!";
		exit(-1);
	}
	std::cout.precision(k);
	std::cout << "C version cosh(x): \t\t\t" << cosh(x) << std::endl;
	std::cout << "ASM version by Taylor cosh(x): \t\t" << cosh_taylor(x, k)
		<< std::endl;
	std::cout << "ASM version by FPU exponent computing : \t" << fpu_exponent(x)
		<< std::endl;

	return 0;
}