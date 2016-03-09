#include <iostream>
#include "makhluk.h"

using namespace std;


//From Class Hewan

		int Hewan::GetLangkah() const {
			return langkah;
		}

		void Hewan::SetLangkah(int langkah){
			this->langkah = langkah;
		}
