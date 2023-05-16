#include <iostream>
using namespace std;

int main()
{
    int i, n, j;

    string prgm = " /* Test program */ \n"
                  "   int main()  \n"
                  "   {           \n"
                  "      // variable declaration \n"
                  "      int a, b, c;    \n"
                  "      /* This is a test  \n"
                  "          multiline     \n"
                  "          comment for   \n"
                  "          testing */      \n"
                  "      a = b + c;       \n"
                  "   }";
    

    n = prgm.length();
    cout << "Given program \n";
    cout << prgm << endl;
    for (i = 0; i < n; i++)
    {
        if (prgm[i] == ' ')
        {
            for (j = i; j < n; j++)
            {
                prgm[j] = prgm[j + 1];
            }
            n--;
        }
    }
    cout << "Modified program is \n";
    cout << prgm;
    return 0;
}