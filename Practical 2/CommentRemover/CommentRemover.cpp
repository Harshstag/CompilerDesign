
#include<iostream>
using namespace std;
string removeComment(string);

int main(){
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
    
    cout << "Given program \n";
    cout << prgm << endl;
    cout << "Modified program is";
    cout << removeComment(prgm);
    return 0;
}

string removeComment(string src)
{
    int i,n;
    n = src.length();
    string res;
    bool s_cmt = false, m_cmt = false;
    for( i = 0;i< n ;i++)
    {
        if(src[i] == '/' && src[i+1] == '/')
        {
            s_cmt = true;
            i++;
        }
        else if(src[i] == '/' && src[i+1] == '*')
        {
            m_cmt = true;
            i++;
        }
        else if(s_cmt == true && src[i] == '\n')
        {
            s_cmt = false;
        }
        else if(m_cmt == true && src[i] == '*' && src[i+1] == '/')
        {
            m_cmt = false;
            i++;
        }
        else if(s_cmt || m_cmt)
        {
            continue;
        }
        else{
            res = res + src[i];
        }
        
    }
    return res;

}