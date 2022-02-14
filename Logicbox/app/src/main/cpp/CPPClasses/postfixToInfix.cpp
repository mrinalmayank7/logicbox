#include<iostream>
#include <stack>
#include <string>
using namespace std;
class postfixToInfix
{
public:
string postToInf(string exp)
{
    stack<string> s;

    for (int i=0; exp[i]!='\0'; i++)
    {
        char current_char = exp[i];
        // Push operands
        if((current_char >= 'a' && current_char <= 'z') || (current_char >= 'A' && current_char <= 'Z') || (current_char >= '0' && current_char <= '9'))
        {
            string op(1, current_char);
            s.push(op);
        }
        else
        {
            string op1 = s.top();
            s.pop();
            string op2 = s.top();
            s.pop();
            s.push("(" + op2 + current_char +
                   op1 + ")");
        }
    }
    return s.top();
}
};